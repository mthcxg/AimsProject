package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    
    @FXML
    private TableColumn<Media, Float> colMediaCost;


    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label totalCostLabel;

    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        this.filteredList = new FilteredList<Media>(cart.getItemOrdered());
    }

    // khoi tao event
    @FXML
    private void initialize() {
        // them du lieu vao bang
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );

        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );

        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );

        // hien thi toan bo san pham trong cart
        tblMedia.setItems(filteredList);

        // an nut play va remove ban dau
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        totalCostLabel.setText(String.valueOf(cart.totalCost()));

        // hien nut play/remove khi 1 dong duoc nhan vao
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if(newValue != null) {
                            // neu 1 item duoc an vao thi hien
                            updateButtonBar(newValue);
                        } else {
                            //khong thi an
                            btnPlay.setVisible(false);
                            btnRemove.setVisible(false);
                        }
                    }
            }

        );

        // B???t s??? ki???n ?? input keyword thay ?????i, n???u c?? thay ?????i th?? ti???n h??nh l???c d??? li???u
        tfFilter.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilterMedia(newValue);
                    }
                }
        );

        // L???ng nghe s??? thay ?????i c???a danh s??ch s???n ph???m trong gi??? h??ng v?? t??nh l???i ti???n
        cart.getItemOrdered().addListener((ListChangeListener<Media>) change -> {
            while (change.next()) {
                //System.out.println(cart.totalCost());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // Update ti???n c???a ????n h??ng
                        totalCostLabel.setText(String.valueOf(cart.totalCost()) + " $");
                        System.out.println("Update total cost");
                    }
                });

            }
        });
    }

    //X???m l?? s??? ki???n khi click v??o n??t remove
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }


    //X??? l?? s??? ki???n khi click v??o n??t PlaceOrder
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.print();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Th??ng b??o");
        alert.setHeaderText("?????t h??ng th??nh c??ng");
        alert.show();
    }

    //X??? l?? s??? ki???n khi click v??o n??t Play
    @FXML
    void btnPlayPressed(ActionEvent event) {
        // L???y media hi???n t???i
        Playable media = (Playable)tblMedia.getSelectionModel().getSelectedItem();
        // L???y title c???a media hi???n t???i
        String mediaTitle = tblMedia.getSelectionModel().getSelectedItem().getTitle();
        try {
            // Play
            media.play();
            // Hi???n th??? th??ng b??o
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tr??nh ph??t nh???c");
            Disc disc = (Disc)media;
            alert.setHeaderText( mediaTitle + "is Playing " + " Director: " + disc.getDirector());
            alert.show();
        } catch (Exception e) {
            // B???t l???i n???u c??
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Th??ng b??o");
            alert.setHeaderText(e.getLocalizedMessage());
            alert.show();
        }

    }

    // Hi???n th??? n??t play v?? remove
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    //L???c d??? li???u theo ID ho???c Title
    void showFilterMedia(String filter) {
        filteredList.setPredicate(item -> {
            if(filter.isEmpty()) {
                return true;
            }
            try {
                // N???u l???c theo ID
                if(radioBtnFilterId.isSelected()) {
                    return String.valueOf(item.getId()).equals(filter);
                } else if(radioBtnFilterTitle.isSelected()) {
                    // N???u l???c theo title
                    return item.getTitle().contains(filter);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

            return true;

        });

    }


}

