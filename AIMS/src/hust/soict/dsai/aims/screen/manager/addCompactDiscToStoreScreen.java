package hust.soict.dsai.aims.screen.manager;

import javax.swing.JPanel;
import javax.swing.JTextField;

import AimsProject.src.hust.soict.dsai.aims.store.Store;

import AimsProject.src.hust.soict.dsai.aims.media.CompactDisc;
import AimsProject.src.hust.soict.dsai.aims.media.Track;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class addCompactDiscToStoreScreen extends addItemToStoreScreen {
    private Store store;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JTextField text5;
    private JTextField text6;
    private JTextField text7;
    private JTextField text8;
    private JTextField text9;
    private ArrayList<String> listOfTrackTitle;
    private ArrayList<Integer> listOfTrackLength;
    private ArrayList<Track> listOfTrack;
    private int i = 0;
    private int j = 0;
    
    public addCompactDiscToStoreScreen(Store store) {
        this.store = store;
        this.setTitle("Add CD");
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
        panel.add(new JLabel("Artist:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        text3 = new JTextField(15);
        text3.addActionListener(new getItemData()); 
        panel.add(text3, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Director:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        text4 = new JTextField(15);
        text4.addActionListener(new getItemData()); 
        panel.add(text4, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Track's title:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        text5 = new JTextField(15);
        text5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = text5.getText();
                text5.setText("");
                if (i == 0) {
                    i += 1;
                    text7.setText(text7.getText() + text);
                } else {
                    text7.setText(text7.getText() + " - " + text);
                }
            }
        }); 
        panel.add(text5, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Track's length:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        text6 = new JTextField(15);
        text6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int text = Integer.parseInt(text6.getText());
                text6.setText("");
                if (j == 0) {
                    j += 1;
                    text8.setText("" + text8.getText() + text);
                } else {
                    text8.setText(text8.getText() + " - " + text);
                }
            }
        }); 
        panel.add(text6, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("List of track's title:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        text7 = new JTextField(15);
        text7.setEditable(false);
        text7.addActionListener(new getItemData()); 
        panel.add(text7, gbc);


        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("List of track's length:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        text8 = new JTextField(15);
        text8.setEditable(false);
        text8.addActionListener(new getItemData()); 
        panel.add(text8, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Cost:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        text9 = new JTextField(15); 
        text9.addActionListener(new getItemData());
        panel.add(text9, gbc);


        gbc.gridx = 0;
        gbc.gridy = 9;
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
        listOfTrackTitle = new ArrayList<String>();
        listOfTrackLength = new ArrayList<Integer>();
        for (String str: text7.getText().split(" - ")) {
            listOfTrackTitle.add(str);
        }
        for (String str: text8.getText().split(" - ")) {
            listOfTrackLength.add(Integer.parseInt(str));
        }
        listOfTrack = new ArrayList<Track>();
        for (int i = 0; i < text7.getText().split(" - ").length && i < text8.getText().split(" - ").length; i++) {
            listOfTrack.add(new Track(listOfTrackTitle.get(i), listOfTrackLength.get(i)));
        }
        this.store.addMedia(new CompactDisc(text1.getText(), text2.getText(), text3.getText(), text4.getText(), listOfTrack, Integer.parseInt(text9.getText())));
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