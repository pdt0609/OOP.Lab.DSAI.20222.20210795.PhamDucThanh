package hust.soict.dsai.aims.screen.manager;

import javax.swing.JPanel;
import javax.swing.JTextField;

import AimsProject.src.hust.soict.dsai.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.dsai.aims.store.Store;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDigitalVideoDiscToStoreScreen extends addItemToStoreScreen {
    private Store store;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JTextField text5;

    
    public addDigitalVideoDiscToStoreScreen(Store store) {
        this.store = store;
        this.setTitle("Add DVD");
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
        text1.addActionListener(new getItemData());
        panel.add(text1, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        text2 = new JTextField(15);
        text2.addActionListener(new getItemData()); 
        panel.add(text2, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Director:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        text3 = new JTextField(15);
        text3.addActionListener(new getItemData()); 
        panel.add(text3, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Length:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        text4 = new JTextField(15);
        text4.addActionListener(new getItemData()); 
        panel.add(text4, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Cost:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        text5 = new JTextField(15); 
        text5.addActionListener(new getItemData());
        panel.add(text5, gbc);


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        JButton addButton = new JButton("Add");
        addButton.setName("Add");
        addButton.addActionListener(new getItemData());
        panel.add(addButton, gbc);

        
        cp.add(createNorth(store), BorderLayout.NORTH);
        cp.add(panel, BorderLayout.CENTER);
        cp.setVisible(true);
        this.pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @Override
    public void addItem() {
        this.store.addMedia(new DigitalVideoDisc(text1.getText(), text2.getText(), text3.getText(), Integer.parseInt(text4.getText()), Float.parseFloat(text5.getText())));
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
}
