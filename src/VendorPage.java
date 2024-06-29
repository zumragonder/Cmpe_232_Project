import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VendorPage extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/trendyol";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Eren.2011";

    private DefaultListModel<String> productListModel;
    private JList<String> productList;
    private JComboBox<String> categoryComboBox;

    public VendorPage() {
        setTitle("Vendor Page");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 140, 0));
        add(panel);

        JLabel trendyolHeader = new JLabel("Trendyol", SwingConstants.CENTER);
        trendyolHeader.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolHeader.setForeground(Color.WHITE);
        panel.add(trendyolHeader, BorderLayout.NORTH);

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BorderLayout());
        subPanel.setBackground(new Color(255, 140, 0));
        panel.add(subPanel, BorderLayout.CENTER);

        JLabel stockHeader = new JLabel("Stocks of Products", SwingConstants.LEFT);
        stockHeader.setFont(new Font("Arial", Font.BOLD, 16));
        stockHeader.setForeground(Color.WHITE);
        subPanel.add(stockHeader, BorderLayout.NORTH);

        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        productList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(productList);
        subPanel.add(scrollPane, BorderLayout.CENTER);

        String[] categories = {"Accessories", "Cosmetics", "Footwear", "Clothing", "Personal Care", "Home Stuff"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadProductsByCategory((String) categoryComboBox.getSelectedItem());
            }
        });
        subPanel.add(categoryComboBox, BorderLayout.SOUTH);

        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new FlowLayout());
        updatePanel.setBackground(new Color(255, 140, 0));
        JLabel productLabel = new JLabel("Product:");
        JTextField productField = new JTextField(10);
        JLabel stockLabel = new JLabel("Stock:");
        JTextField stockField = new JTextField(5);
        JButton updateButton = new JButton("Update Stock");
        JButton addToCartButton = new JButton("Add to Cart");

        updatePanel.add(productLabel);
        updatePanel.add(productField);
        updatePanel.add(stockLabel);
        updatePanel.add(stockField);
        updatePanel.add(updateButton);
        updatePanel.add(addToCartButton);

        panel.add(updatePanel, BorderLayout.SOUTH);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = productField.getText().trim();
                int stock;
                try {
                    stock = Integer.parseInt(stockField.getText().trim());
                } catch (NumberFormatException ex) {
                    showMessage("Please enter a valid stock number.", "Error");
                    return;
                }

                updateStock(product, stock);
            }
        });

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String product = productField.getText().trim();
                int quantity;
                try {
                    quantity = Integer.parseInt(stockField.getText().trim());
                } catch (NumberFormatException ex) {
                    showMessage("Please enter a valid quantity.", "Error");
                    return;
                }

                addToCart(product, quantity);
            }
        });

        loadProductsByCategory((String) categoryComboBox.getSelectedItem());

        setVisible(true);
    }

    private void loadProductsByCategory(String category) {
        productListModel.clear();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT product_name, stock FROM products WHERE category = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("product_name");
                int stock = rs.getInt("stock");
                productListModel.addElement(productName + " - Stock: " + stock);
            }
            showMessage("Products loaded successfully.", "Success");
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage("Error loading products.", "Error");
        }
    }

    private void updateStock(String product, int stock) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE products SET stock = ? WHERE product_name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, stock);
            ps.setString(2, product);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                showMessage("Stock updated successfully!", "Success");
            } else {
                showMessage("Product not found.", "Error");
            }
            loadProductsByCategory((String) categoryComboBox.getSelectedItem());
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage("Error updating stock.", "Error");
        }
    }

    private void addToCart(String product, int quantity) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE products SET stock = stock - ? WHERE product_name = ? AND stock >= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setString(2, product);
            ps.setInt(3, quantity);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                showMessage("Product added to cart successfully!", "Success");
            } else {
                showMessage("Insufficient stock or product not found.", "Error");
            }
            loadProductsByCategory((String) categoryComboBox.getSelectedItem());
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage("Error adding product to cart.", "Error");
        }
    }

    private void showMessage(String message, String messageType) {
        if (messageType.equals("Success")) {
            JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (messageType.equals("Error")) {
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendorPage();
            }
        });
    }
}
