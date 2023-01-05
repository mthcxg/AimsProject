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

        // Bắt sự kiện ô input keyword thay đổi, nếu có thay đổi thì tiến hành lọc dữ liệu
        tfFilter.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilterMedia(newValue);
                    }
                }
        );

        // Lắng nghe sự thay đổi của danh sách sản phẩm trong giỏ hàng và tính lại tiền
        cart.getItemOrdered().addListener((ListChangeListener<Media>) change -> {
            while (change.next()) {
                //System.out.println(cart.totalCost());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // Update tiền của đơn hàng
                        totalCostLabel.setText(String.valueOf(cart.totalCost()) + " $");
                        System.out.println("Update total cost");
                    }
                });

            }
        });
    }

    //Xửm lý sự kiện khi click vào nút remove
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }


    //Xử lý sự kiện khi click vào nút PlaceOrder
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.print();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText("Đặt hàng thành công");
        alert.show();
    }

    //Xử lý sự kiện khi click vào nút Play
    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Lấy media hiện tại
        Playable media = (Playable)tblMedia.getSelectionModel().getSelectedItem();
        // Lấy title của media hiện tại
        String mediaTitle = tblMedia.getSelectionModel().getSelectedItem().getTitle();
        try {
            // Play
            media.play();
            // Hiển thị thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Trình phát nhạc");
            Disc disc = (Disc)media;
            alert.setHeaderText( mediaTitle + "is Playing " + " Director: " + disc.getDirector());
            alert.show();
        } catch (Exception e) {
            // Bắt lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText(e.getLocalizedMessage());
            alert.show();
        }

    }

    // Hiển thị nút play và remove
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    //Lọc dữ liệu theo ID hoặc Title
    void showFilterMedia(String filter) {
        filteredList.setPredicate(item -> {
            if(filter.isEmpty()) {
                return true;
            }
            try {
                // Nếu lọc theo ID
                if(radioBtnFilterId.isSelected()) {
                    return String.valueOf(item.getId()).equals(filter);
                } else if(radioBtnFilterTitle.isSelected()) {
                    // Nếu lọc theo title
                    return item.getTitle().contains(filter);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

            return true;

        });

    }


}

