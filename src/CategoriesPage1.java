import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoriesPage1 extends JFrame implements ActionListener {
    private JButton homeButton;
    private JButton categoryNameButton;
    private JPanel productsPanel;

    public CategoriesPage1(String categoryName) {
        setTitle("Categories Page"); // Set the window title
        setSize(800, 500); // Set window size
        setResizable(false); // Disable window resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setLocationRelativeTo(null); // Center the window on screen
        getContentPane().setBackground(new Color(255, 255, 255)); // Set background color to white

        // Create the top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 130, 60)); // Set background color for the top panel
        topPanel.setPreferredSize(new Dimension(800, 100)); // Set preferred size for the top panel

        // Create and configure the category name button
        categoryNameButton = new JButton(categoryName);
        categoryNameButton.setFont(new Font("Arial", Font.BOLD, 24)); // Set font properties
        categoryNameButton.setForeground(Color.ORANGE); // Set text color
        categoryNameButton.setBackground(Color.WHITE); // Set background color
        categoryNameButton.setFocusPainted(false); // Disable focus painting
        categoryNameButton.addActionListener(this);
        categoryNameButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                categoryNameButton.setBackground(new Color(255, 130, 60).darker()); // Darken the button on press
            }

            public void mouseReleased(MouseEvent e) {
                categoryNameButton.setBackground(Color.WHITE); // Reset background color on release
            }
        });
        topPanel.add(categoryNameButton, BorderLayout.WEST); // Add button to the west of the top panel

        // Create and add the TRENDYOL label
        JLabel trendyolLabel = new JLabel("TRENDYOL", JLabel.CENTER);
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 32)); // Set font properties
        trendyolLabel.setForeground(Color.WHITE); // Set text color
        topPanel.add(trendyolLabel, BorderLayout.NORTH); // Add label to the north of the top panel

        // Create and add the page label
        JLabel pageLabel = new JLabel("", JLabel.CENTER);
        pageLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set font properties
        pageLabel.setForeground(Color.WHITE); // Set text color
        topPanel.add(pageLabel, BorderLayout.SOUTH); // Add label to the south of the top panel

        // Create the home button
        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 18)); // Set font properties
        homeButton.setBackground(Color.WHITE); // Set background color
        homeButton.setForeground(new Color(255, 130, 60)); // Set text color
        homeButton.addActionListener(this);
        homeButton.setFocusable(false); // Make button unfocusable
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 130, 60)); // Set background color
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Set layout
        buttonPanel.add(homeButton); // Add home button to the panel

        topPanel.add(buttonPanel, BorderLayout.EAST); // Add button panel to the east of the top panel

        // Create and configure the products panel
        productsPanel = new JPanel(new GridLayout(2, 3, 10, 10)); // Set layout
        productsPanel.setBackground(new Color(255, 255, 255)); // Set background color
        String[] productImages = { // Array of product image paths
            "C:/Users/Zümra Gönder/Desktop/clothe1.jpg",
            "C:/Users/Zümra Gönder/Desktop/clothe2.jpg",
            "C:/Users/Zümra Gönder/Desktop/clothe3.jpg",
            "C:/Users/Zümra Gönder/Desktop/clothe4.jpg",
            "C:/Users/Zümra Gönder/Desktop/clothe5.jpg",
            "C:/Users/Zümra Gönder/Desktop/clothe6.jpg"
        };

        // Create and add product buttons to the products panel
        for (int i = 0; i < productImages.length; i++) {
            JButton productButton = createProductButton(productImages[i], i);
            productsPanel.add(productButton);
        }

        // Create the main panel and add components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 255, 255)); // Set background color
        mainPanel.add(topPanel, BorderLayout.NORTH); // Add top panel to the north
        mainPanel.add(productsPanel, BorderLayout.CENTER); // Add products panel to the center

        add(mainPanel); // Add main panel to the JFrame
        setVisible(true); // Make the window visible
    }

    // Method to create product buttons
    private JButton createProductButton(String imagePath, int index) {
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
        JButton productButton = new JButton(icon);
        productButton.setPreferredSize(new Dimension(200, 100)); // Set preferred size
        productButton.setBackground(Color.WHITE); // Set background color
        productButton.setForeground(new Color(255, 130, 60)); // Set text color
        productButton.setFocusable(false); // Make button unfocusable
        productButton.addActionListener(this);
        productButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                productButton.setBackground(new Color(255, 130, 60).darker()); // Darken the button on press
            }

            public void mouseReleased(MouseEvent e) {
                productButton.setBackground(Color.WHITE); // Reset background color on release
                // Direct to appropriate product page based on index
                if (index == 0) {
                    new Dresses();
                    dispose();

                }
                else if (index == 1) {
                    new Pants();
                    dispose();

                }
                else if (index == 2) {
                    new Tshirt();
                    dispose();

                }
                else if (index == 3) {
                    new Jackets();
                    dispose();

                }
                else if (index == 4) {
                    new Cardigans();
                    dispose();

                }
                else if (index == 5) {
                    new Skirts();
                    dispose();

                }
            }

            public void mouseEntered(MouseEvent e) {
                productButton.setBackground(new Color(255, 130, 60).darker()); // Darken the button on hover
            }

            public void mouseExited(MouseEvent e) {
                productButton.setBackground(Color.WHITE); // Reset background color when the mouse exits
            }
        });
        return productButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            dispose(); // Close the current window
            new HomePage(); // Open the home page
        } else if (e.getSource() == categoryNameButton) {
            categoryNameButton.setBackground(new Color(255, 130, 60).darker()); // Darken the category button on click
        } else {
            // Handle other button clicks here
        }
    }
    public static void main(String[] args) {
        new CategoriesPage1("Clothes"); // Instantiate the categories page with a category name
    }
}
