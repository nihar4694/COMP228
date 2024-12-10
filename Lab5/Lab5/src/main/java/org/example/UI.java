package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class UI {
    private GameAppDAO dao = new GameAppDAO(); // Database handler

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Game App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Add Tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Add Player", createAddPlayerPanel());
        tabbedPane.addTab("Add Game", createAddGamePanel());
        tabbedPane.addTab("Add Player-Game", createAddPlayerGamePanel());
        tabbedPane.addTab("View Data", createViewDataPanel());

        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private JPanel createAddPlayerPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2));
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField postalCodeField = new JTextField();
        JTextField provinceField = new JTextField();
        JTextField phoneField = new JTextField();
        JButton addButton = new JButton("Add Player");

        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Postal Code:"));
        panel.add(postalCodeField);
        panel.add(new JLabel("Province:"));
        panel.add(provinceField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel(""));
        panel.add(addButton);

        addButton.addActionListener(e -> {
            Player player = new Player();
            player.setFirstName(firstNameField.getText());
            player.setLastName(lastNameField.getText());
            player.setAddress(addressField.getText());
            player.setPostalCode(postalCodeField.getText());
            player.setProvince(provinceField.getText());
            player.setPhoneNumber(phoneField.getText());
            try {
                dao.insertPlayer(player);
                JOptionPane.showMessageDialog(panel, "Player added successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(panel, "Error adding player!");
            }
        });

        return panel;
    }

    private JPanel createAddGamePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JTextField gameTitleField = new JTextField();
        JButton addButton = new JButton("Add Game");

        panel.add(new JLabel("Game Title:"));
        panel.add(gameTitleField);
        panel.add(new JLabel(""));
        panel.add(addButton);

        addButton.addActionListener(e -> {
            Game game = new Game();
            game.setTitle(gameTitleField.getText());
            try {
                dao.insertGame(game);
                JOptionPane.showMessageDialog(panel, "Game added successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(panel, "Error adding game!");
            }
        });

        return panel;
    }

    private JPanel createAddPlayerGamePanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField gameIdField = new JTextField();
        JTextField playerIdField = new JTextField();
        JTextField playingDateField = new JTextField();
        JTextField scoreField = new JTextField();
        JButton addButton = new JButton("Add Player-Game");

        panel.add(new JLabel("Game ID:"));
        panel.add(gameIdField);
        panel.add(new JLabel("Player ID:"));
        panel.add(playerIdField);
        panel.add(new JLabel("Playing Date (YYYY-MM-DD):"));
        panel.add(playingDateField);
        panel.add(new JLabel("Score:"));
        panel.add(scoreField);
        panel.add(new JLabel(""));
        panel.add(addButton);

        addButton.addActionListener(e -> {
            PlayerAndGame playerAndGame = new PlayerAndGame();
            playerAndGame.setGameId(Integer.parseInt(gameIdField.getText()));
            playerAndGame.setPlayerId(Integer.parseInt(playerIdField.getText()));
            playerAndGame.setPlayingDate(playingDateField.getText());
            playerAndGame.setScore(Integer.parseInt(scoreField.getText()));
            try {
                dao.insertPlayerAndGame(playerAndGame);
                JOptionPane.showMessageDialog(panel, "Player-Game data added successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(panel, "Error adding Player-Game data!");
            }
        });

        return panel;
    }

    private JPanel createViewDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        JButton viewPlayersButton = new JButton("View Players");
        JButton viewGamesButton = new JButton("View Games");
        JButton viewPlayerGameButton = new JButton("View Player-Game Info");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewPlayersButton);
        buttonPanel.add(viewGamesButton);
        buttonPanel.add(viewPlayerGameButton);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        viewPlayersButton.addActionListener(e -> {
            textArea.setText("");
            try {
                String playersData = dao.displayAllPlayers(); // Get data as String
                textArea.setText(playersData);
            } catch (SQLException ex) {
                ex.printStackTrace();
                textArea.setText("Error retrieving players!");
            }
        });

        viewGamesButton.addActionListener(e -> {
            textArea.setText("");
            try {
                String gamesData = dao.displayAllGames(); // Get data as String
                textArea.setText(gamesData);
            } catch (SQLException ex) {
                ex.printStackTrace();
                textArea.setText("Error retrieving games!");
            }
        });

        viewPlayerGameButton.addActionListener(e -> {
            textArea.setText("");
            try {
                String playerGameData = dao.displayPlayerAndGameInfo(); // Get data as String
                textArea.setText(playerGameData);
            } catch (SQLException ex) {
                ex.printStackTrace();
                textArea.setText("Error retrieving Player-Game data!");
            }
        });

        return panel;
    }

}
