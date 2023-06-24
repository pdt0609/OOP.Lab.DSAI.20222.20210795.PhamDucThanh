package hust.soict.dsai.aims.screen.manager;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Store;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

/*import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;*/


public class addItemToStoreScreen extends JFrame {
    private Store store;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    


    /*public addItemToStoreScreen(Store store) {
        this.store = store;
        this.setTitle("Add Item");
        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        text1 = new JTextField(15); 
        text1.setName("Title");
        text1.addActionListener(new getItemData());
        panel.add(text1, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        text2 = new JTextField(15);
        text2.setName("Category");
        text2.addActionListener(new getItemData()); 
        panel.add(text2, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Cost:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        text3 = new JTextField(15); 
        text3.setName("Cost");
        text3.addActionListener(new getItemData());
        panel.add(text3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add");
        addButton.setName("Add");
        addButton.addActionListener(new getItemData());
        panel.add(addButton, gbc);


        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        cp.setVisible(true);
        this.pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }*/

    JPanel createNorth(Store store) {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar(store));
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(Store store) {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store"); 

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addBookToStoreScreen(store);
                dispose();
            }
        });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addCompactDiscToStoreScreen(store);
                dispose();
            }
        });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addDigitalVideoDiscToStoreScreen(store);
                dispose();
            }
        });

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreManagerScreen(store);
                dispose();
            }
        });
        JMenuItem logOut = new JMenuItem("Log out");
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        menu.add(smUpdateStore);
        menu.add(viewStore);
        menu.add(logOut);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);


        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    public class getItemData implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source.getClass() == JButton.class) {
                if ((((JButton)source).getName()).equals("Add")) {
                    addItem();
                }
            }
        }
    }

    public void addItem() {
        this.store.addMedia(new DigitalVideoDisc(text1.getText(), text2.getText(), Float.parseFloat(text3.getText())));
    }

}
