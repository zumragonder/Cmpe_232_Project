import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pants extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Pants() {
        // Set window title
        setTitle("Pant");
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

        // Create JLabel for "Men's Beige Pants" title
        JLabel classyPantsLabel = new JLabel(" Men's Beige Pants");
        classyPantsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classyPantsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classyPantsLabel.setForeground(trendyolColor);
        productPanel.add(classyPantsLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create pants panel
        JPanel pantsPanel = new JPanel(new BorderLayout());
        pantsPanel.setBackground(Color.WHITE); // White surface

        // Add the pants picture to the pants panel
        String pantsImagePath = "C:/Users/Zümra Gönder/Desktop/clothe2.jpg";
        JLabel pantsImageLabel = new JLabel();
        try {
            ImageIcon pantsImageIcon = new ImageIcon(pantsImagePath);
            Image scaledPantsImage = pantsImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            pantsImageLabel.setIcon(new ImageIcon(scaledPantsImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        pantsPanel.add(pantsImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Beige\n" +
                "Material: Cotton Blend\n" +
                "Style: Formal\n" +
                "Closure: Button\n" +
                "Features: Belt Loops, Center Crease\n" +
                "Care instructions: Machine Washable                 \n" );

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        pantsPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $59.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pantsPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add pants panel to the product panel
        productPanel.add(pantsPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Pant";
                double productPrice = 59.99; // Sample price

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
                // Create an instance of ClothesComment
                ClothesComment commentPage = new ClothesComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current Pants frame
            }
        });
        
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Pants frame
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
        new Pants();
    }
}
