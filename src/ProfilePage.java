import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProfilePage extends JFrame {
    private JPanel cardPanel = new JPanel(new CardLayout());
    private JPanel ordersPanel, cardDetailsPanel;
    private List<String> comments = new ArrayList<>();
    private List<String> cartItems;

    public ProfilePage(List<String> cartItems) {
        this.cartItems = cartItems != null ? cartItems : new ArrayList<>(); // cartItems null ise boş bir liste ata
        setTitle("Profile Page");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(250, 130, 60));
        JLabel myProfileLabel = new JLabel("                       Profile ", JLabel.CENTER);
        myProfileLabel.setFont(new Font("Arial", Font.BOLD, 40));
        myProfileLabel.setForeground(Color.WHITE);
        myProfileLabel.setVerticalAlignment(JLabel.TOP);
        leftPanel.add(myProfileLabel, BorderLayout.NORTH);
        ordersPanel = createOrdersPanel();
        leftPanel.add(ordersPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(250, 130, 60));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnHome = new JButton("Home");
        JButton btnCard = new JButton("My Card");

        styleButton(btnHome);
        styleButton(btnCard);

        btnHome.addActionListener(e -> openHomePage());
        btnCard.addActionListener(e -> openMyCardPage());

        rightPanel.add(btnHome, gbc);
        gbc.gridy++;
        rightPanel.add(btnCard, gbc);
        gbc.gridy++;

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        cardDetailsPanel = createCardPanel();
        cardPanel.add(cardDetailsPanel, "Card");
        add(cardPanel, BorderLayout.CENTER);

        getContentPane().setBackground(new Color(250, 130, 60));
    }

    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(120, 40));
        button.setBackground(Color.WHITE);
        button.setForeground(new Color(250, 130, 60));
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setFocusPainted(false);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(new Color(250, 130, 60));
                button.setForeground(Color.WHITE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(250, 130, 60));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 200, 150));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(250, 130, 60));
            }
        });
    }

    private void showPanel(String card) {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, card);
    }

    private void openHomePage() {
        new HomePage().setVisible(true);
        this.dispose();
    }

    private void openMyCardPage() {
        new MyCardPage().setVisible(true);
        this.dispose();
    }

    private JPanel createOrdersPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 130, 60));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        int cartItemIndex = 0; // ürün bilgilerini almak için bir indeks

        for (int i = 0; i < 6; i++) {
            String orderId = generateOrderID();

            JPanel orderPanel = new JPanel(new BorderLayout());
            orderPanel.setBackground(new Color(250, 130, 60));
            JLabel orderLabel = new JLabel("Order ID: " + orderId + "   ");
            JTextField commentField = new JTextField("Click here to add comment");
            commentField.setForeground(Color.GRAY);
            commentField.setPreferredSize(new Dimension(200, 25));

            if (cartItemIndex < cartItems.size()) {
                JLabel productLabel = new JLabel("Product: " + cartItems.get(cartItemIndex));
                productLabel.setForeground(Color.WHITE);
                orderPanel.add(productLabel, BorderLayout.SOUTH);
                cartItemIndex++;
            }

            commentField.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    if (commentField.getText().equals("Click here to add comment")) {
                        commentField.setText("");
                        commentField.setForeground(Color.BLACK);
                    }
                }

                public void focusLost(java.awt.event.FocusEvent evt) {
                    if (commentField.getText().isEmpty()) {
                        commentField.setForeground(Color.GRAY);
                        commentField.setText("Click here to add comment");
                    }
                }
            });

            JLabel dateLabel = new JLabel("Date: " + getRandomDate());
            dateLabel.setForeground(Color.WHITE);

            JButton addButton = new JButton("Add Comment");
            addButton.setPreferredSize(new Dimension(120, 30));
            styleButton(addButton);
            addButton.addActionListener(e -> {
                String comment = commentField.getText();
                if (!comment.isEmpty() && !comment.equals("Click here to add comment")) {
                    comments.add("Order ID: " + orderId + " - " + comment);
                    commentField.setText("");
                    commentField.setForeground(Color.GRAY);
                    commentField.setText("Click here to add comment");
                }
            });

            JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            datePanel.setBackground(new Color(250, 130, 60));
            datePanel.add(dateLabel);

            orderPanel.add(orderLabel, BorderLayout.WEST);
            orderPanel.add(commentField, BorderLayout.CENTER);
            orderPanel.add(addButton, BorderLayout.EAST);
            orderPanel.add(datePanel, BorderLayout.NORTH);
            orderPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            panel.add(orderPanel);
        }
        return panel;
    }

    private String generateOrderID() {
        StringBuilder orderId = new StringBuilder();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = characters.length();

        for (int i = 0; i < 10; i++) {
            orderId.append(characters.charAt(random.nextInt(length)));
        }

        return orderId.toString();
    }

    private String getRandomDate() {
        Random random = new Random();
        int day = random.nextInt(28) + 1;
        int month = random.nextInt(12) + 1;
        int year = random.nextInt(3) + 2021;
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(250, 130, 60));
        JLabel profileLabel = new JLabel();
        profileLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(profileLabel);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // MyCardPage'den ürün bilgilerini alarak ProfilePage'e aktarın
            MyCardPage myCardPage = new MyCardPage();
            List<String> cartItems = myCardPage.getCartItems();
            ProfilePage frame = new ProfilePage(cartItems);
            frame.setVisible(true);
        });
    }
}
