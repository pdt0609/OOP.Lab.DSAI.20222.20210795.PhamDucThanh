package hust.soict.dsai.aims.screen.manager;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Store;
import hust.soict.dsai.aims.media.Track;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class LoginScreen extends JFrame {
    private Store store;

    public static void main(String[] args) {
        Store store1 = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Aladin1", "Animation", 18.99f);
        store1.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);
        store1.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);
        store1.addMedia(dvd3);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);
        store1.addMedia(dvd4);
        Track track = new Track("Track", 10);
        Track track2 = new Track("Track2", 20);
        Track track3 = new Track("Track3", 20);
        Track track4 = new Track("Track4", 20);
        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(track);
        tracks.add(track2);
        tracks.add(track3);
        tracks.add(track4);
        CompactDisc cd = new CompactDisc("pham", "duc", "thanh", "dsai", tracks, 19.66f);
        store1.addMedia(cd);
        new LoginScreen(store1);
    }
    public LoginScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();

        JRadioButton customerBtn = new JRadioButton("Customer");
        JRadioButton managerBtn = new JRadioButton("Store Manager");
        customerBtn.setBounds(140, 40, 120, 30);
        managerBtn.setBounds(140, 90, 120, 30);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(customerBtn);
        bg.add(managerBtn);
        customerBtn.setSelected(true);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(140, 140, 120, 30);
        
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (managerBtn.isSelected()) {
                    new StoreManagerScreen(store);
                    dispose();
                } 
            }
        });
        
        cp.add(customerBtn);
        cp.add(managerBtn);
        cp.add(loginBtn);

        setTitle("Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Store getStore() {
        return store;
    }
}

