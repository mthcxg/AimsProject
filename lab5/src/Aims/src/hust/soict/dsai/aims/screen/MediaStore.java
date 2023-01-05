package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	private static final String ADD_TO_CART = "Add to Cart";
	private static final String PLAY = "Play";

	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + "S");
		title.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton addToCartButton = new JButton(ADD_TO_CART);
		PlayButtonListener btnListener = new PlayButtonListener(media, cart);
		addToCartButton.addActionListener(btnListener);
		container.add(new JButton("Add to cart"));
		if (media instanceof Playable) {
			JButton playButton = new JButton(PLAY);
			container.add(playButton);
			playButton.addActionListener(btnListener);
		}
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	}

	public class PlayButtonListener implements ActionListener {
		private Media media;
		private Cart cart;

		public PlayButtonListener(Media media, Cart cart) {
			this.media = media;
			this.cart = cart;
		}

		@Override
		public void actionPerformed(ActionEvent evt) {
			String button = evt.getActionCommand();
			if (button.equals("Play")) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(null, "Dang xem" + " " + media.toString());
			}

			else if (button.equals("Add to cart")) {

				if (cart == null) {
					cart = new Cart();
				}

				this.cart.addMedia(media);
				JFrame frame = new JFrame();
				this.cart.print();
				JOptionPane.showMessageDialog(frame,
						"" + media.getTitle() + " " + media.getCategory() + " " + media.getCost());
			} else if (button.equals("View Cart")) {
				if (cart == null) {
					cart = new Cart();
				}
				cart.print();
			}
		}
	}
}
