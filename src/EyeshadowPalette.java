import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EyeshadowPalette extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public EyeshadowPalette() {
        // Set window title
        setTitle("Eyeshadow Palette");
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

        // Create JLabel for "Eyeshadow Palette with 12 Color" title
        JLabel eyeshadowPaletteLabel = new JLabel(" Eyeshadow Palette with 12 Color ");
        eyeshadowPaletteLabel.setFont(new Font("Arial", Font.BOLD, 20));
        eyeshadowPaletteLabel.setHorizontalAlignment(SwingConstants.LEFT);
        eyeshadowPaletteLabel.setForeground(trendyolColor);
        productPanel.add(eyeshadowPaletteLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create eyeshadowPalette panel
        JPanel eyeshadowPalettePanel = new JPanel(new BorderLayout());
        eyeshadowPalettePanel.setBackground(Color.WHITE); // White surface

        // Add the eyeshadowPalette picture to the eyeshadowPalette panel
        String eyeshadowPaletteImagePath = "C:/Users/Zümra Gönder/Desktop/makeup2.jpg";
        JLabel eyeshadowPaletteImageLabel = new JLabel();
        try {
            ImageIcon eyeshadowPaletteImageIcon = new ImageIcon(eyeshadowPaletteImagePath);
            Image scaledEyeshadowPaletteImage = eyeshadowPaletteImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            eyeshadowPaletteImageLabel.setIcon(new ImageIcon(scaledEyeshadowPaletteImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        eyeshadowPalettePanel.add(eyeshadowPaletteImageLabel, BorderLayout.CENTER);
        
        // Add eyeshadowPalette description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: DEF Beauty\n" +
                "Type: Eyeshadow Palette\n" +
                "Shades: 12 Colors\n" +
                "Finish: Matte and Shimmer\n" +
                "Net Weight: 15g                                   \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        eyeshadowPalettePanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $14.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eyeshadowPalettePanel.add(priceLabel, BorderLayout.SOUTH);

        // Add eyeshadowPalette panel to the product panel
        productPanel.add(eyeshadowPalettePanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Eyeshadow Palette";
                double productPrice = 14.99; // Sample price

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
                // Create an instance of MakeupComment
                MakeupComment commentPage = new MakeupComment();
                // Make the commentPage visible
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
                // Close the current EyeshadowPalette frame
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
        new EyeshadowPalette();
    }
}

