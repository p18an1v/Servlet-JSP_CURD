package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletController {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_USER = "System";
    private static final String DB_PASSWORD = "root";

    private Connection conn;

    public WalletController() throws SQLException {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void addFunds(String userId, double amount) throws SQLException {
        String sql = "UPDATE users SET balance = balance + ? WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            stmt.executeUpdate();
        }
    }

    public void deductFunds(String userId, double amount) throws SQLException {
        String sql = "UPDATE users SET balance = balance - ? WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, userId);
            stmt.executeUpdate();
        }
    }

    public double getBalance(String userId) throws SQLException {
        String sql = "SELECT balance FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                } else {
                    throw new IllegalArgumentException("User not found: " + userId);
                }
            }
        }
    }

    public void close() throws SQLException {
        conn.close();
    }
}
