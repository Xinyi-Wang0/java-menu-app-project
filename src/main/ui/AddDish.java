package ui;

import model.Dish;
import model.Menu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDish extends JFrame implements ActionListener {
    JTextField dishNameField;
    JTextField ingredient;
    JTextField price;
    Menu menu;
    ViewMenu viewMenu;

    private static final String FINISH_ACTION = "FINISH_ACTION";

    //MODIFIES: this
    //EFFECTS: add dish to the menu view
    public AddDish(ViewMenu viewMenu, Menu menu) {
        super("Add an Item");
        this.viewMenu = viewMenu;
        this.menu = menu;
        this.setWindow();

        this.setLabelsFieldsButtons();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //EFFECTS: set up window
    private void setWindow() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 340));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);
    }

    //EFFECTS: set up buttons
    private void setLabelsFieldsButtons() {
        JLabel itemNameLabel = new JLabel("Enter item name: ");
        itemNameLabel.setBounds(48, 40, 400, 20);
        add(itemNameLabel);

        dishNameField = new JTextField(30);
        dishNameField.setBounds(50, 70, 300, 20);
        add(dishNameField);

        JLabel ingredientLabel = new JLabel("Enter ingredient");
        ingredientLabel.setBounds(50, 100, 600, 20);
        add(ingredientLabel);

        ingredient = new JTextField(30);
        ingredient.setBounds(50, 130,300,20);
        add(ingredient);

        JLabel priceLabel = new JLabel("Enter price");
        priceLabel.setBounds(50, 160, 600, 20);
        add(priceLabel);

        price = new JTextField(30);
        price.setBounds(50, 190,300,20);
        add(price);

        JButton finishButton = new JButton("Finish");
        finishButton.setBounds(150,240,100,20);
        add(finishButton);
        finishButton.setActionCommand(FINISH_ACTION);
        finishButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(FINISH_ACTION)) {
            String name = dishNameField.getText();
            String ingredients = ingredient.getText();
            int setprice = Integer.parseInt(price.getText());
            menu.addDish(new Dish(name, ingredients, setprice));
            System.out.println("Added: " + name + ", " + ingredients + ", " + setprice);
            dispose();
        }

    }
}
