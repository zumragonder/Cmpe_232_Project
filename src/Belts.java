import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Belts extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Belts() {
        setTitle("Belt");
        setSize(800, 500);
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

        // Create JLabel for "Belt" title
        JLabel beltLabel = new JLabel(" Black Leather Belt for Men");
        beltLabel.setFont(new Font("Arial", Font.BOLD, 20));
        beltLabel.setHorizontalAlignment(SwingConstants.LEFT);
        beltLabel.setForeground(trendyolColor);
        productPanel.add(beltLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create belt panel
        JPanel beltPanel = new JPanel(new BorderLayout());
        beltPanel.setBackground(Color.WHITE);

        // Add the belt picture to the belt panel
        String beltImagePath = "C:/Users/Zümra Gönder/Desktop/acc6.jpg";
        JLabel beltImageLabel = new JLabel();
        try {
            ImageIcon beltImageIcon = new ImageIcon(beltImagePath);
            Image scaledBeltImage = beltImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            beltImageLabel.setIcon(new ImageIcon(scaledBeltImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        beltPanel.add(beltImageLabel, BorderLayout.CENTER);

        // Some informations about product
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Black\n" +
                "Material: Leather\n" +
                "Style: Casual\n" +
                "Buckle: Silver\n" +
                "Width: 3.5 cm\n" +
                "Length: Adjustable                                     \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        beltPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $29.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        beltPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add belt panel to the product panel
        productPanel.add(beltPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Belt";
                double productPrice = 29.99; // Sample price

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
                AccessoriesComment commentPage = new AccessoriesComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current frame
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
        // Create an instance of belt
        new Belts();
    }
}
