package bmsystem;

import java.sql.*;

public class DAO {
    public double getAmount(String cardNo) {

        double dbamount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");
            String query = "SELECT amount FROM balance WHERE cardNo = ?";
            PreparedStatement p = c.prepareStatement(query);
            p.setString(1, cardNo);

            ResultSet rs = p.executeQuery();

            if (rs.next()) {
                dbamount = rs.getDouble("amount");
                System.out.println("Success");
            } else {
                System.out.println("Invalid");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return dbamount;
    }

    public void insertBalance(String cardNo){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");

              String insertInitialBalanceQuery = "INSERT INTO balance (cardNo, amount) VALUES (?, ?)";

              PreparedStatement insertInitialBalanceStatement = c.prepareStatement(insertInitialBalanceQuery);

              insertInitialBalanceStatement.setString(1, cardNo);
              double initialBalance = 0;
              insertInitialBalanceStatement.setDouble(2, initialBalance);

              int insertResult = insertInitialBalanceStatement.executeUpdate();

              if (insertResult > 0) {
                  System.out.println("Initial balance record inserted successfully");
              } else {
                  System.out.println("Failed to insert initial balance record");
              }

          } catch (SQLException | ClassNotFoundException e) {
              e.printStackTrace();
          }

    }
    public void updateBalance(String cardNo, double newBalance) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "bunny28");

            String updateBalanceQuery = "UPDATE balance SET amount = ? WHERE cardNo = ?";
            PreparedStatement updateBalanceStatement = c.prepareStatement(updateBalanceQuery);
            updateBalanceStatement.setDouble(1, newBalance);
            updateBalanceStatement.setString(2, cardNo);

            int updateBalanceResult = updateBalanceStatement.executeUpdate();

            if (updateBalanceResult > 0) {
                System.out.println("Balance updated successfully");
            } else {
                System.out.println("Failed to update balance");
            }

            updateBalanceStatement.close();
            c.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
