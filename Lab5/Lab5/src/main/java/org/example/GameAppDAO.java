package org.example;
import java.sql.*;

import static org.example.DbConnection.getConnection;

public class GameAppDAO {

    public void insertPlayer(Player player) throws SQLException {
        String query = "INSERT INTO Player (first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, player.getFirstName());
            stmt.setString(2, player.getLastName());
            stmt.setString(3, player.getAddress());
            stmt.setString(4, player.getPostalCode());
            stmt.setString(5, player.getProvince());
            stmt.setString(6, player.getPhoneNumber());
            stmt.executeUpdate();
        }
    }

    public void insertGame(Game game) throws SQLException {
        String query = "INSERT INTO Game (game_title) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, game.getTitle());
            stmt.executeUpdate();
        }
    }

    public void insertPlayerAndGame(PlayerAndGame playerAndGame) throws SQLException {
        String query = "INSERT INTO PlayerAndGame (game_id, player_id, playing_date, score) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, playerAndGame.getGameId());
            stmt.setInt(2, playerAndGame.getPlayerId());
            stmt.setString(3, playerAndGame.getPlayingDate());
            stmt.setInt(4, playerAndGame.getScore());
            stmt.executeUpdate();
        }
    }

    public String displayAllPlayers() throws SQLException {
        StringBuilder result = new StringBuilder();
        String query = "SELECT * FROM Player"; // Example query
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                result.append("ID: ").append(rs.getInt("player_id"))
                        .append(", Name: ").append(rs.getString("first_name"))
                        .append(" ").append(rs.getString("last_name"))
                        .append(", Phone: ").append(rs.getString("phone_number"))
                        .append("\n");
            }
        }
        return result.toString();
    }

    public String displayAllGames() throws SQLException {
        StringBuilder result = new StringBuilder();
        String query = "SELECT * FROM Game"; // Example query
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                result.append("ID: ").append(rs.getInt("game_id"))
                        .append(", Title: ").append(rs.getString("game_title"))
                        .append("\n");
            }
        }
        return result.toString();
    }

    public String displayPlayerAndGameInfo() throws SQLException {
        StringBuilder result = new StringBuilder();
        String query = "SELECT * FROM PlayerAndGame"; // Example query
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                result.append("Player ID: ").append(rs.getInt("player_id"))
                        .append(", Game ID: ").append(rs.getInt("game_id"))
                        .append(", Score: ").append(rs.getInt("score"))
                        .append(", Date: ").append(rs.getString("playing_date"))
                        .append("\n");
            }
        }
        return result.toString();
    }

}

