import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyCardPage extends JFrame {
    private JButton homeButton;
    private JButton paymentButton;
    private JLabel trendyolLabel;
    private JPanel myCardPanel;
    private JTextArea productsTextArea;
    private JLabel totalPriceLabel;

    private static final String CART_FILE_PATH = "cart.txt";

    public MyCardPage() {
        setTitle("My Card Page");
        setSize(800, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);
        Color trendyolColor = new Color(250, 130, 60);
        getContentPane().setBackground(trendyolColor);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(800, 80));
        topPanel.setBackground(trendyolColor);

        trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 36));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        topPanel.add(trendyolLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        myCardPanel = new JPanel(new BorderLayout());
        myCardPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        JLabel myCardLabel = new JLabel("  My Card");
        myCardLabel.setFont(new Font("Arial", Font.BOLD, 20));
        myCardLabel.setHorizontalAlignment(SwingConstants.LEFT);
        myCardLabel.setForeground(trendyolColor);
        myCardPanel.add(myCardLabel, BorderLayout.NORTH);

        ImageIcon cartIcon = new ImageIcon("C:\\Users\\User\\OneDrive\\Resimler\\Saved Pictures\\sepetfoto.jpg");
        Image scaledCartImage = cartIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledCartIcon = new ImageIcon(scaledCartImage);
        JLabel cartLabel = new JLabel(scaledCartIcon);

        myCardPanel.add(cartLabel, BorderLayout.WEST);

        add(myCardPanel, BorderLayout.CENTER);

        productsTextArea = new JTextArea();
        productsTextArea.setEditable(false);
        myCardPanel.add(new JScrollPane(productsTextArea), BorderLayout.CENTER);

        totalPriceLabel = new JLabel("Total Price: $0.00");
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceLabel.setForeground(Color.WHITE);
        add(totalPriceLabel, BorderLayout.SOUTH);

        homeButton = new JButton("Home");
        homeButton.setFocusable(false);
        paymentButton = new JButton("Payment");

        homeButton.setBackground(Color.WHITE);
        paymentButton.setBackground(Color.WHITE);
        homeButton.setForeground(Color.BLACK);
        paymentButton.setForeground(Color.BLACK);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                dispose();
            }
        });

        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentPage paymentPage = new PaymentPage(getTotalPrice());
                paymentPage.setVisible(true);
                clearCartItems();
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(trendyolColor);
        buttonPanel.add(homeButton);
        buttonPanel.add(paymentButton);

        add(buttonPanel, BorderLayout.SOUTH);

        loadCartItems();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListenerToTextFields();
    }

    public void addProductToCard(String productName, double price) {
        productsTextArea.append(productName + " - $" + price + "\n");
        updateTotalPrice(price);
        saveCartItems(productName, price);
    }

    private void updateTotalPrice(double price) {
        String totalPriceText = totalPriceLabel.getText();
        double totalPrice = Double.parseDouble(totalPriceText.substring(totalPriceText.indexOf('$') + 1));
        totalPrice += price;
        totalPriceLabel.setText("Total Price: $" + totalPrice);
    }

    private double getTotalPrice() {
        String totalPriceText = totalPriceLabel.getText();
        return Double.parseDouble(totalPriceText.substring(totalPriceText.indexOf('$') + 1));
    }

    public boolean isCartEmpty() {
        return productsTextArea.getText().trim().isEmpty();
    }

    private void addKeyListenerToTextFields() {
        // Here you can add key listeners to text fields if needed
    }

    private void saveCartItems(String productName, double price) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CART_FILE_PATH, true))) {
            writer.write(productName + "," + price);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCartItems() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CART_FILE_PATH))) {
            String line;
            double totalPrice = 0.0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String productName = parts[0];
                double price = Double.parseDouble(parts[1]);
                productsTextArea.append(productName + " - $" + price + "\n");
                totalPrice += price;
            }
            totalPriceLabel.setText("Total Price: $" + totalPrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearCartItems() {
        productsTextArea.setText("");
        totalPriceLabel.setText("Total Price: $0.00");
        try (PrintWriter writer = new PrintWriter(CART_FILE_PATH)) {
            writer.print("");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public List<String> getCartItems() {
        List<String> cartItems = new ArrayList<>();
        String[] lines = productsTextArea.getText().split("\n");
        for (String line : lines) {
            if (!line.trim().isEmpty() && !line.equals("\n\n\n\n\n\n\n                There are no products in your cart :(")) {
                cartItems.add(line);
            }
        }
        return cartItems;
    }

    public static void main(String[] args) {
        MyCardPage myCardPage = new MyCardPage();
        if (myCardPage.isCartEmpty()) {
            Font messageFont = new Font("Arial", Font.PLAIN, 20);
            myCardPage.productsTextArea.setFont(messageFont);
            myCardPage.productsTextArea.setText("\n\n\n\n\n\n\n                There are no products in your cart :(");
            myCardPage.productsTextArea.setEditable(false);
        }
    }
}
