package hust.soict.dsai.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Cart;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;



public class ItemController {
    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }
    
    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClick(ActionEvent event) throws LimitExceededException {
        if (cart.dvdList().contains(media)) {
            JDialog dialog = new JDialog();
            dialog.setTitle("S.O.S");
            JPanel panel = new JPanel();
            FlowLayout boxlayout = new FlowLayout(FlowLayout.CENTER, 75, 75);
            panel.setLayout(boxlayout);
            panel.add(new JLabel("The media existed in the list"));
            dialog.add(panel);
            dialog.setSize(200, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            
        } else {
            cart.addMedia(media);
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        JDialog dialog = new JDialog();
        dialog.setTitle("Play");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        String[] playList = ((Playable) media).play().split("/n");
        for (int i = 0; i < playList.length; i++) {
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(playList[i]), gbc);
        }
        dialog.add(panel);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost()+"$");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

}