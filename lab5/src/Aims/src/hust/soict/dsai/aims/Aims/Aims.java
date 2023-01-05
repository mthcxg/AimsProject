package hust.soict.dsai.aims.Aims;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void main(String[] args) {
		Cart cart = new Cart();
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd1, dvd2, dvd3);
		cart.addMedia(dvd1, dvd2, dvd3);

		boolean stopMenu = false;
		boolean stopStoreMenu = false;
		boolean stopUpdateStore = false;
		boolean stopCartMenu = false;
		int menuOption, storeMenuOption, updateStoreOption, cartMenuOption, filterCartOption, sortCartOption;

		Scanner sc = new Scanner(System.in);

		while (!stopMenu) {
			Aims.showMenu();
			menuOption = Aims.input(3);
			stopStoreMenu = false;
			stopUpdateStore = false;
			stopCartMenu = false;
			/*
			 * Store options
			 */
			if (menuOption == 1) {
				while (!stopStoreMenu) {
					Aims.storeMenu();
					storeMenuOption = Aims.input(4);
					// See media's details
					if (storeMenuOption == 1) {
						System.out.println("Enter title: ");
						String title = sc.next();
						Media m = store.searchByTitle(title);// check xem co trong store khong
						if (m == null) {
							System.out.println("Cannot find media"); // khong co thi bao khong thay
						} else {// tim thay thi hien
							System.out.println(m.toString());
						}

					}
					// Add a media to the cart
					else if (storeMenuOption == 2) {
						System.out.println("Enter title to add to cart: ");
						String title = sc.next();
						Media m = store.searchByTitle(title);// check xem co trong store khong
						if (m == null) {
							System.out.println("Cannot find media"); // khong co thi bao khong thay
						} else {// tim thay
							System.out.println("Found: ");
							System.out.println(m);
							cart.addMedia(m);// them vao cart khi ton tai trong store
						}

					}

					// Play a media in the store
					else if (storeMenuOption == 3) {
						System.out.println("Enter title to play: ");
						String title = sc.next();
						Media m = store.searchByTitle(title);// check xem co trong store khong
						if (m == null) {
							System.out.println("Cannot find media"); // khong co thi bao khong thay
						} else {// tim thay thi play
							((Playable) m).play();
						}

					}
					// Go to cart menu
					else if (storeMenuOption == 4) {
						cart.print();
					}
					// Go back to menu
					else if (storeMenuOption == 0) {
						stopStoreMenu = true;
					}
				}
			}
			/*
			 * Update store options
			 */
			if (menuOption == 2) {
				while (!stopUpdateStore) {
					Aims.updateStore();
					updateStoreOption = Aims.input(2);
					// Add a media to the store
					if (updateStoreOption == 1) {
						Aims.addMediaMenu();
						int choose = sc.nextInt();
						switch (choose) {// dvd cd book
						case 1: {// add dvd
							sc.nextLine();
							System.out.println("Enter title: ");
							String title = sc.nextLine();
							System.out.println("Enter director: ");
							String director = sc.nextLine();
							System.out.println("Enter Category: ");
							String category = sc.nextLine();
							System.out.println("Enter Length: ");
							int length = sc.nextInt();
							System.out.println("Enter cost: ");
							float cost = sc.nextFloat();
							DigitalVideoDisc dvd = new DigitalVideoDisc(title, director, category, length, cost);
							store.addMedia(dvd);
							break;
						}
						case 2: {// add cd
							CompactDisc cd = new CompactDisc(null);
							sc.nextLine();
							System.out.println("Enter title: ");
							cd.setTitle(sc.nextLine());
							System.out.println("Enter Artist: ");
							cd.setArtist(sc.nextLine());
							System.out.println("Enter Category: ");
							cd.setCategory(sc.nextLine());
							System.out.println("Enter cost: ");
							cd.setCost(sc.nextFloat());
							sc.nextLine();
							store.addMedia(cd);
							break;
						}
						case 3: {// add Book
							Book book = new Book();
							sc.nextLine();
							System.out.println("Enter title: ");
							book.setTitle(sc.nextLine());
							System.out.println("Enter Category: ");
							book.setCategory(sc.nextLine());
							System.out.println("Enter cost: ");
							book.setCost(sc.nextFloat());
							sc.nextLine();
							store.addMedia(book);
							break;
						}
						case 0:
							break;
						}
					}

					// Remove a media from the store
					else if (updateStoreOption == 2) {
						System.out
								.println("Please enter the title of the media that you want to remove from the store:");
						String s = sc.next();
						Media cd = store.searchByTitle(s);
						store.removeMedia(cd);

					}
					// Go back to menu
					else if (updateStoreOption == 0) {
						stopUpdateStore = true;
					}
				}
			}
			/*
			 * Cart options
			 */
			if (menuOption == 3) {
				while (!stopCartMenu) {
					Aims.cartMenu();
					cartMenuOption = Aims.input(5);
					// Filter media(s) in the cart
					if (cartMenuOption == 1) {
						Aims.filterCart();
						filterCartOption = Aims.input(2);
						// Filter by id
						if (filterCartOption == 1) {
							System.out.println("Enter id: ");
							int id = sc.nextInt();
							Media m = cart.searchById(id); // tim kiem = id
							if (m == null) {
								System.out.println("Cannot find"); // m = null, khong tim thay
							} else {
								System.out.println("Found item with id: " + id);
								System.out.println(m);
							}
						}
						// Filter by title
						else if (filterCartOption == 2) {
							System.out.println("Enter title: ");
							String title = sc.nextLine();
							Media m = cart.searchByTitle(title); // tim kiem = title
							if (m == null) {
								System.out.println("Cannot find"); // m = null, khong tim thay
							} else {
								System.out.println("Found item with title: " + title);
								System.out.println(m);
							}
						}

					}
					// Sort media(s) in the cart
					else if (cartMenuOption == 2) {
						Aims.sortCart();
						sortCartOption = Aims.input(2);
						// Sort media(s) in the cart by title cost
						if (sortCartOption == 1) {
							cart.sortByTitleCost();
						}
						// Sort media(s) in the cart by cost title
						else if (sortCartOption == 2) {
							cart.sortByCostTitle();
						}

					}
					// Remove media(s) from the cart
					else if (cartMenuOption == 3) {
						System.out.println("Enter title you want to remove: ");
						String title = sc.nextLine();
						Media m = cart.searchByTitle(title); // tim kiem = title
						if (m == null) {
							System.out.println("Cannot find"); // m = null, khong tim thay
						} else {
							cart.removeMedia(m); // remove
						}
					}

					// Play a media in the cart
					else if (cartMenuOption == 4) {
						System.out.println("Enter title you want to play: ");
						String title = sc.nextLine();
						Media m = cart.searchByTitle(title); // tim kiem = title
						if (m == null) {
							System.out.println("Cannot find"); // m = null, khong tim thay
						} else if (m instanceof Playable) {
							((Playable) m).play();
						}

					}
					// Place an order
					else if (cartMenuOption == 5) {
						cart.print();
						System.out.println("Your order has been placed successfully!");
						menuOption = 0;
						stopCartMenu = true;
						cart = new Cart();
					}
					// Go back to menu
					else if (cartMenuOption == 0) {
						stopCartMenu = true;
					}
				}
			}
			if (menuOption == 0) {
				System.out
						.println("----------------------------------------------------------------------------------");
				System.out
						.println("--------------------------------Application closed--------------------------------");
				System.out
						.println("----------------------------------------------------------------------------------");
				stopMenu = true;
			}
		}
	}

	// Show all menu options
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	// Show all store options
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media in the store");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	// Show all cart options
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media in the cart");
		System.out.println("5. Place");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	// Show all update store options
	public static void updateStore() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media(s) to the store");
		System.out.println("2. Remove media(s) from the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	// Show all add media options
	public static void addMediaMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a DVD to the store");
		System.out.println("2. Add a CD to the store");
		System.out.println("3. Add a Book to the store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	// Show all filter cart options
	public static void filterCart() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media(s) by id");
		System.out.println("2. Filter media(s) by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	// Show all sort cart options
	public static void sortCart() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort media(s) by title");
		System.out.println("2. Sort media(s) by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	// Take input from user
	public static int input(int optionNum) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean checkMenuOption = false;
		while (!checkMenuOption) {
			try {
				option = sc.nextInt();
				if (option >= 0 && option <= optionNum) {
					checkMenuOption = true;
				} else {
					System.out.println("Please type a number from 0 to " + optionNum);
				}
			} catch (InputMismatchException e) {
				System.out.println("Not a valid number!");
				sc.next();
			}
		}
		return option;
	}

}