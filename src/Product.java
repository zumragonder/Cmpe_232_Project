import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product {
    private int id;
    private String name;
    private int stock;
    private double price;

    public Product(int id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean updateStock(int quantity) {
        if (this.stock >= quantity) {
            this.stock -= quantity;
            try (Connection conn = Database.getConnection()) {
                String sql = "UPDATE products SET stock = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, this.stock);
                stmt.setInt(2, this.id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
