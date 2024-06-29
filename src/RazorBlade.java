import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RazorBlade extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public RazorBlade() {
        // Set window title
        setTitle("Razor Blade");
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

        // Create JLabel for "Razor Blade" title
        JLabel razorBladeLabel = new JLabel(" Razor Blade");
        razorBladeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        razorBladeLabel.setHorizontalAlignment(SwingConstants.LEFT);
        razorBladeLabel.setForeground(trendyolColor);
        productPanel.add(razorBladeLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create razor blade panel
        JPanel razorBladePanel = new JPanel(new BorderLayout());
        razorBladePanel.setBackground(Color.WHITE); // White surface

        // Add the razor blade picture to the razor blade panel
        String razorBladeImagePath = "C:/Users/Zümra Gönder/Desktop/care5.jpg";
        JLabel razorBladeImageLabel = new JLabel();
        try {
            ImageIcon razorBladeImageIcon = new ImageIcon(razorBladeImagePath);
            Image scaledRazorBladeImage = razorBladeImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            razorBladeImageLabel.setIcon(new ImageIcon(scaledRazorBladeImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        razorBladePanel.add(razorBladeImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: XYZ Blades\n" +
                "Type: Safety Razor Blades\n" +
                "Material: Stainless Steel\n" +
                "Packaging: 10 Blades                             \n");
        
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        razorBladePanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $3.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        razorBladePanel.add(priceLabel, BorderLayout.SOUTH);

        // Add razor blade panel to the product panel
        productPanel.add(razorBladePanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Razor Blade";
                double productPrice = 3.00; // Sample price

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
                // Create an instance of CareComment
                CareComment commentPage = new CareComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current RazorBlade frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current RazorBlade frame
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

