import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Table() {
        // Set window title
        setTitle("Table");
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

        // Create JLabel for "Wooden Table" title
        JLabel tableLabel = new JLabel(" Wooden Table");
        tableLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tableLabel.setHorizontalAlignment(SwingConstants.LEFT);
        tableLabel.setForeground(trendyolColor);
        productPanel.add(tableLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create table panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.WHITE); // White surface

        // Add the table picture to the table panel
        String tableImagePath = "C:/Users/Zümra Gönder/Desktop/home3.jpg";
        JLabel tableImageLabel = new JLabel();
        try {
            ImageIcon tableImageIcon = new ImageIcon(tableImagePath);
            Image scaledTableImage = tableImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            tableImageLabel.setIcon(new ImageIcon(scaledTableImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tablePanel.add(tableImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: ABC Furniture\n" +
                "Type: Dining Table\n" +
                "Material: Solid Wood\n" +
                "Color: Grey\n" +
                "Dimensions: 60\"L x 36\"W x 30\"H\n" +
                "Features: Classic design, \n"
                + "durable construction                                        \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        tablePanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $79.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tablePanel.add(priceLabel, BorderLayout.SOUTH);

        // Add table panel to the product panel
        productPanel.add(tablePanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Table";
                double productPrice = 79.99; // Sample price

                // Create an instance of MyCardPage only when adding a product
                MyCardPage cardPage = new MyCardPage();
                // Add the product to the card
                cardPage.addProductToCard(productName, productPrice);
                // Show the card page
                cardPage.setVisible(true);
            }
        });

        commentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeComment commentPage = new HomeComment();
                commentPage.setVisible(true);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Table frame
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

    public static void main(String[] args) {
        // Create an instance of ClassyShoes
        new Table();
    }
}

