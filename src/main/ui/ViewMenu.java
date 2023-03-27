package ui;

import model.Dish;
import model.Menu;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ViewMenu extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable table;
    private Menu menu;
    private static final String SAVE_ACTION = "SAVE_ACTION";
    private static final String LOAD_ACTION = "LOAD_ACTION";
    private static final String DELETE_ACTION = "DELETE_ACTION";

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/menu.json";


    public ViewMenu(Menu menu) {
        this.menu = menu;
        final String[] columnLabels = new String[]{
                "Index",
                "Name",
                "Ingredient",
                "Price"
        };
        tableModel = new DefaultTableModel(null, columnLabels) {
        };
        table = new JTable(tableModel);
        this.populateTableRows();
        add(new JScrollPane(table));
        this.setButtons();
        setTitle("Menu");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        //load();


    }

   /* private void setWindow() {
        setPreferredSize(new Dimension(750, 500));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);
    }

    private void setBackgroundImage() {
        try {
            BufferedImage backgroundImage = ImageIO.read(new File("src/main/ui/background.jpg"));
            setContentPane(new BackgroundImage(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    private void setButtons() {
        JButton saveButton = new JButton(("Save"));
        add(saveButton);
        saveButton.setActionCommand(SAVE_ACTION);
        saveButton.addActionListener(this);
        saveButton.setForeground(Color.darkGray);

        JButton loadButton = new JButton("Load");
        add(loadButton);
        loadButton.setActionCommand(LOAD_ACTION);
        loadButton.addActionListener(this);
        loadButton.setForeground(Color.darkGray);

        JButton detailsButton = new JButton("Delete");
        add(detailsButton);
        detailsButton.setActionCommand(DELETE_ACTION);
        detailsButton.addActionListener(this);
        detailsButton.setForeground(Color.darkGray);
    }

    private void populateTableRows() {
        for (int i = 0; i < menu.size(); i++) {
            Dish dish = menu.allDishes().get(i);
            Object[] tableRow = new Object[]{
                    i,
                    dish.getName(),
                    dish.getIngredients(),
                    dish.getPrice()
            };
            tableModel.addRow(tableRow);
        }
    }

    //MODIFIES: this
    //EFFECTS: save dish to this menu
    private void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(menu);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("fail to save");

        }
    }

    //MODIFIES: this
    //EFFECTS: load dish from file
    private void load() {
        try {
            menu = jsonReader.read();
            populateTableRows();
        } catch (IOException e) {
            System.out.println("fail to load");
        }
    }

    private void deleteSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();
        menu.deleteDish((String)table.getModel().getValueAt(selectedRowIndex,1));
        model.removeRow(selectedRowIndex);
        System.out.println("row " + selectedRowIndex + " is deleted.");
    }

    @Override
        public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals(SAVE_ACTION)) {
            save();
        } else if (action.equals(LOAD_ACTION)) {
            load();
        } else if (action.equals(DELETE_ACTION)) {
            deleteSelectedRow();

            /*String selectedRowIndex = String.valueOf(Integer.parseInt(String.valueOf(table.getSelectedRow())));
            //menu.getDishesDetails(selectedRowIndex);
            remove(Integer.parseInt(selectedRowIndex));*/
        }
    }

}
