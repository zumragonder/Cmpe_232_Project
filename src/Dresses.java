import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dresses extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Dresses() {
        // Set window title
        setTitle("Dress");
        // Set window size
        setSize(800, 500);
        // Set layout
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Set background color to Trendyol color
        Color trendyolColor = new Color(250, 130, 60);
        getContentPane().setBackground(trendyolColor);

        // Create JLabel for "Trendyol" text
        trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create panel for Product Page section
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create JLabel for "Mini Length Red Dress" title
        JLabel dressLabel = new JLabel(" Mini Length Red Dress");
        dressLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dressLabel.setForeground(trendyolColor);
        productPanel.add(dressLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create dress panel
        JPanel dressPanel = new JPanel(new BorderLayout());
        dressPanel.setBackground(Color.WHITE); // White surface

        // Add the dress picture to the dress panel
        String dressImagePath = "C:/Users/Zümra Gönder/Desktop/clothe1.jpg";
        JLabel dressImageLabel = new JLabel();
        try {
            ImageIcon dressImageIcon = new ImageIcon(dressImagePath);
            Image scaledDressImage = dressImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            dressImageLabel.setIcon(new ImageIcon(scaledDressImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dressPanel.add(dressImageLabel, BorderLayout.CENTER);

        // Add dress description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Red\n" +
                "Material: Polyester\n" +
                "Style: Sleeveless\n" +
                "Skirt: Pleated\n" +
                "Length: Short                                     ");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        dressPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $79.90");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dressPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add dress panel to the product panel
        productPanel.add(dressPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Dress";
                double productPrice = 79.90; // Sample price

                // Create an instance of MyCardPage only when adding a product
                MyCardPage cardPage = new MyCardPage();
                // Add the product to the card
                cardPage.addProductToCard(productName, productPrice);
                // Show the card page
                cardPage.setVisible(true);

                // Update stock in the database
                updateProductStock(productName);
            }
        });

        commentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of ClothesComment
                ClothesComment commentPage = new ClothesComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current Dresses frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Dresses frame
                dispose();
            }
        });

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(trendyolColor);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(commentsButton); // Add the Comments button
        buttonPanel.add(homeButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Set window visibility
        setVisible(true);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void updateProductStock(String productName) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/trendyol"; // Change to your database URL
        String username = "root"; // Change to your database username
        String password = "Eren.2011"; // Change to your database password

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(url, username, password);

            // SQL query to update the product stock
            String sql = "UPDATE products SET stock = stock - 1 WHERE product_name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, productName);

            // Execute the update statement
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Stock updated successfully for product: " + productName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of ClassyShoes
        new Dresses();
    }
}

