import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {
    private JTextField emailField, firstNameField, lastNameField, phoneField, addressField;
    private JPasswordField passwordField;
    private JButton continueButton;
    private int topPadding = 20;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Eren.2011";

    public Signup() {
        setTitle("Signup Page");
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(250, 130, 60));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(topPadding, 30, 10, 30);

        JLabel titleLabel = new JLabel("Signup Form", JLabel.CENTER);
        titleLabel.setPreferredSize(new Dimension(200, 50));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, gbc);

        addField("E-Mail:          ", emailField = new JTextField(20), gbc);
        addField("Password:    ", passwordField = new JPasswordField(20), gbc);
        addField("First Name:  ", firstNameField = new JTextField(20), gbc);
        addField("Last Name:   ", lastNameField = new JTextField(20), gbc);
        addField("Number:       ", phoneField = new JTextField(20), gbc);
        addField("Address:      ", addressField = new JTextField(20), gbc);

        continueButton = new JButton("Continue");
        continueButton.addActionListener(this);
        continueButton.setFocusable(false);
        gbc.weighty = 1;
        add(continueButton, gbc);

        setVisible(true);
    }

    private void addField(String label, Component field, GridBagConstraints gbc) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        panel.setBackground(new Color(250, 130, 60));
        add(panel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            if (email.isEmpty() ||
                password.isEmpty() ||
                firstNameField.getText().trim().isEmpty() ||
                lastNameField.getText().trim().isEmpty() ||
                phoneField.getText().trim().isEmpty() ||
                addressField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (password.length() < 6) {
                JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (saveUserToDatabase(email, password)) {
                    JOptionPane.showMessageDialog(this, "Signup successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); 
                    new LoginSignup();
                } else {
                    JOptionPane.showMessageDialog(this, "Signup failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean saveUserToDatabase(String email, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (email, password, first_name, last_name, phone, address) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, firstNameField.getText().trim());
            ps.setString(4, lastNameField.getText().trim());
            ps.setString(5, phoneField.getText().trim());
            ps.setString(6, addressField.getText().trim());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

class LoginSignup extends JFrame implements ActionListener {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Eren.2011";

    public LoginSignup() {
        setTitle("Login Page");
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(60, 130, 250));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 30, 10, 30);

        JLabel titleLabel = new JLabel("Login Form", JLabel.CENTER);
        titleLabel.setPreferredSize(new Dimension(200, 50));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, gbc);

        addField("E-Mail:      ", emailField = new JTextField(20), gbc);
        addField("Password:  ", passwordField = new JPasswordField(20), gbc);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        gbc.weighty = 1;
        add(loginButton, gbc);

        setVisible(true);
    }

    private void addField(String label, Component field, GridBagConstraints gbc) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        panel.setBackground(new Color(60, 130, 250));
        add(panel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            if (authenticateUser(email, password)) {
                JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean authenticateUser(String email, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
