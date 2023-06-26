package hust.soict.dsai.test.screen.customer.cart;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Store;
import hust.soict.dsai.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TestCartScreen extends Application {
    private static Cart cart;
    private static Store store;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Cart.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
        CartController viewStoreController = new CartController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) throws LimitExceededException {
        store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladin1", "Animation", 18.99f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin3", "Animation", 18.99f);
        store.addMedia(dvd3);
        store.removeMedia(dvd1);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin4", "Animation", 18.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin5", "Animation", 18.99f);
        store.addMedia(dvd5);
        store.addMedia(dvd4);
        cart = new Cart();
        cart.addMedia(dvd1);
        cart.addMedia(dvd3);
        launch(args);
    }
}