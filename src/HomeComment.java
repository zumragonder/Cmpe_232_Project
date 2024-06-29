import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class HomeComment extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "Eren.2011";

    public HomeComment() {
        // Set window title
        setTitle("Comment Page");
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
        JLabel trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create panel for Comment section
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create JLabel for "Comments" title
        JLabel commentsLabel = new JLabel(" Comments");
        commentsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        commentsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        commentsLabel.setForeground(trendyolColor);
        commentPanel.add(commentsLabel, BorderLayout.NORTH);

        // Create JTextArea for displaying user comments
        JTextArea commentTextArea = new JTextArea();
        commentTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        commentTextArea.setLineWrap(true); // Wrap text to next line if needed
        commentTextArea.setWrapStyleWord(true); // Wrap whole words
        commentTextArea.setEditable(false); // Make the text area read-only

        // Fetch comments from the database and append them to the JTextArea
        StringBuilder comments = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT username, comment FROM home_comments")) {

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String comment = resultSet.getString("comment");
                comments.append(username).append(": ").append(comment).append("\n\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        commentTextArea.setText(comments.toString());

        JScrollPane scrollPane = new JScrollPane(commentTextArea);
        commentPanel.add(scrollPane, BorderLayout.CENTER);

        // Add comment panel to the frame
        add(commentPanel, BorderLayout.CENTER);

        // Set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set window visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of CommentPage
        new HomeComment();
    }
}
