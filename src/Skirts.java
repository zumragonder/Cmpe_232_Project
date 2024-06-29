import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Skirts extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Skirts() {
        // Set window title
        setTitle("Skirt");
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

        // Create JLabel for "Classy Shoes" title
        JLabel classyShoesLabel = new JLabel(" Brown Pleated Skirt with Belt");
        classyShoesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classyShoesLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classyShoesLabel.setForeground(trendyolColor);
        productPanel.add(classyShoesLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create shoes panel
        JPanel shoesPanel = new JPanel(new BorderLayout());
        shoesPanel.setBackground(Color.WHITE); // White surface

        // Add the shoe picture to the shoes panel
        String shoeImagePath = "C:/Users/Zümra Gönder/Desktop/clothe6.jpg";
        JLabel shoeImageLabel = new JLabel();
        try {
            ImageIcon shoeImageIcon = new ImageIcon(shoeImagePath);
            Image scaledShoeImage = shoeImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            shoeImageLabel.setIcon(new ImageIcon(scaledShoeImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        shoesPanel.add(shoeImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Brown\n" +
                "Material: Shiny\n" +
                "Belt Color: Brown\n" +
                "Buckle: Silver\n" +
                "Style: Pleated\n" +
                "Closure: Belt                                     \n" );


        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        shoesPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $74.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shoesPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add shoes panel to the product panel
        productPanel.add(shoesPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Skirt";
                double productPrice = 74.99; // Sample price

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
                // Create an instance of CommentPage
                ClothesComment commentPage = new ClothesComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current ClassyShoes frame
            }
        });
        
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current ClassyShoes frame
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
        new Skirts();
    }
}
