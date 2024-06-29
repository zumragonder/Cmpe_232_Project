import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sofa extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Sofa() {
        // Set window title
        setTitle("Sofa");
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

        // Create JLabel for "White Sofa" title
        JLabel classySofaLabel = new JLabel(" White Sofa");
        classySofaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classySofaLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classySofaLabel.setForeground(trendyolColor);
        productPanel.add(classySofaLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create sofa panel
        JPanel sofaPanel = new JPanel(new BorderLayout());
        sofaPanel.setBackground(Color.WHITE); // White surface

        // Add the sofa picture to the sofa panel
        String sofaImagePath = "C:/Users/Zümra Gönder/Desktop/home1.jpg";
        JLabel sofaImageLabel = new JLabel();
        try {
            ImageIcon sofaImageIcon = new ImageIcon(sofaImagePath);
            Image scaledSofaImage = sofaImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            sofaImageLabel.setIcon(new ImageIcon(scaledSofaImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        sofaPanel.add(sofaImageLabel, BorderLayout.CENTER);
        
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: XYZ Furniture\n" +
                "Type: Sofa\n" +
                "Color: White\n" +
                "Material: Fabric\n" +
                "Dimensions: 80\"W x 36\"D x 32\"H\n" +
                "Features: Comfortable seating, sturdy wooden frame\n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        sofaPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $119.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sofaPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add sofa panel to the product panel
        productPanel.add(sofaPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Sofa";
                double productPrice = 119.99; // Sample price

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
                // Close the current Sofa frame
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
        new Sofa();
    }
}

