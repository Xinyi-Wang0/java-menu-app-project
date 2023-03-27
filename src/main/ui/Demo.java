package ui;

import model.Menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Demo extends JFrame implements ActionListener {

    private final Menu menu = new Menu();
    private static final String MENU_ACTION = "MENU_ACTION";
    private static final String VIEW_MENU_ACTION = "VIEW_MENU_ACTION";
    private ViewMenu viewMenu;
    private AddDish addDish;


    //MODIFIES: this
    //EFFECTS: create main frame include add and view
    public Demo() {
        JFrame menuFrame = new JFrame("MenuDemo");
        menuFrame.setBounds(300, 300, 300, 300);
        JButton menuButton = new JButton("Add dish");
        menuButton.setBounds(95, 50, 100, 50);
        menuFrame.add(menuButton);
        menuButton.setActionCommand(MENU_ACTION);
        menuButton.addActionListener(this);
        this.setBackgroundImage();


        JButton viewMenuButton = new JButton("View menu");
        viewMenuButton.setBounds(95, 130, 100, 50);
        menuFrame.add(viewMenuButton);
        viewMenuButton.setActionCommand(VIEW_MENU_ACTION);
        viewMenuButton.addActionListener(this);


        /*ImageIcon gui = new ImageIcon();
        JLabel label = new JLabel();
        label.setIcon(gui);*/


        //menuFrame.add(icon1);
        //Reference: "https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html"

        menuFrame.setLayout(null);
        menuFrame.setVisible(true);

    }

    //EFFECTS: find the path of image
   /* protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }*/

    private void setBackgroundImage() {
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("src/main/ui/images/background.jpg"));
            setContentPane(new BackgroundImage(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Demo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(MENU_ACTION)) {
            addDish = new AddDish(viewMenu, menu);
        } else if (action.equals(VIEW_MENU_ACTION)) {
            viewMenu = new ViewMenu(menu);
            menu.viewAllDish();
            dispose();
        }
    }
}