//Name: Isha Bhatta
//Student Id:2408180
package com.manage.banking.allclasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI extends JFrame {
    private LinkedList<Account> globalAccounts;
    private JLabel showAllData;
    private JButton showAllButton, depositButton, withdrawButton, transferButton;
    private JTextField accDeposit, accWithdraw, acc1Transfer, acc2Transfer, depositInput, withdrawInput, transferAmount;
    private JComboBox<String> operationDropdown;

    private JPanel depositPanel, withdrawPanel, transferPanel;

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Reduced distance between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Initialize global variable with the accounts list
        globalAccounts = accounts;

        // Initialize buttons
        showAllButton = new JButton("Show All");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        transferButton = new JButton("Transfer");

        // Initialize text fields and labels
        showAllData = new JLabel("Account Data will be displayed here");

        // Initialize labels
        JLabel labelDeposit = new JLabel("Account No:");
        JLabel labelDepositAmount = new JLabel("Amount:");
        JLabel labelWithdraw = new JLabel("Account No:");
        JLabel labelWithdrawAmount = new JLabel("Amount:");
        JLabel labelTransferFrom = new JLabel("From Account:");
        JLabel labelTransferTo = new JLabel("To Account:");
        JLabel labelTransferAmount = new JLabel("Amount:");

        accDeposit = new JTextField();
        accWithdraw = new JTextField();
        acc1Transfer = new JTextField();
        acc2Transfer = new JTextField();
        depositInput = new JTextField();
        withdrawInput = new JTextField();
        transferAmount = new JTextField();

        // Reduce text field, button, and dropdown menu size
        Dimension smallSize = new Dimension(100, 25); // Width, Height

        accDeposit.setPreferredSize(smallSize);
        depositInput.setPreferredSize(smallSize);
        accWithdraw.setPreferredSize(smallSize);
        withdrawInput.setPreferredSize(smallSize);
        acc1Transfer.setPreferredSize(smallSize);
        acc2Transfer.setPreferredSize(smallSize);
        transferAmount.setPreferredSize(smallSize);

        // Initialize operation dropdown menu
        String[] operations = {"Select Operation", "Show All", "Deposit", "Withdraw", "Transfer"};
        operationDropdown = new JComboBox<>(operations);
        operationDropdown.setPreferredSize(smallSize); // Set size for dropdown
        operationDropdown.setSelectedItem("Show All"); // Set default selection

        // Setup GridBagLayout constraints for Operation Dropdown
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Span across all 3 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the dropdown
        add(operationDropdown, gbc);

        // Setup GridBagLayout constraints for Show All Data
        gbc.gridy = 1;
        gbc.gridwidth = 3; // Span across all 3 columns
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER; // Center the table
        add(showAllData, gbc);

        // Setup Deposit Panel
        depositPanel = new JPanel(new GridBagLayout());
        GridBagConstraints depositGbc = new GridBagConstraints();
        depositGbc.insets = new Insets(5, 5, 5, 5);
        depositGbc.fill = GridBagConstraints.HORIZONTAL;
        depositGbc.anchor = GridBagConstraints.CENTER;

        depositGbc.gridx = 0;
        depositGbc.gridy = 0;
        depositPanel.add(labelDeposit, depositGbc);

        depositGbc.gridx = 1;
        depositPanel.add(accDeposit, depositGbc);

        depositGbc.gridx = 0;
        depositGbc.gridy = 1;
        depositPanel.add(labelDepositAmount, depositGbc);

        depositGbc.gridx = 1;
        depositPanel.add(depositInput, depositGbc);

        depositGbc.gridx = 0;
        depositGbc.gridy = 2;
        depositGbc.gridwidth = 2;
        depositPanel.add(depositButton, depositGbc);

        gbc.gridy = 2;
        gbc.gridwidth = 3;
        add(depositPanel, gbc);
        depositPanel.setVisible(false); // Hide panel initially

        // Setup Withdraw Panel
        withdrawPanel = new JPanel(new GridBagLayout());
        GridBagConstraints withdrawGbc = new GridBagConstraints();
        withdrawGbc.insets = new Insets(5, 5, 5, 5);
        withdrawGbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawGbc.anchor = GridBagConstraints.CENTER;

        withdrawGbc.gridx = 0;
        withdrawGbc.gridy = 0;
        withdrawPanel.add(labelWithdraw, withdrawGbc);

        withdrawGbc.gridx = 1;
        withdrawPanel.add(accWithdraw, withdrawGbc);

        withdrawGbc.gridx = 0;
        withdrawGbc.gridy = 1;
        withdrawPanel.add(labelWithdrawAmount, withdrawGbc);

        withdrawGbc.gridx = 1;
        withdrawPanel.add(withdrawInput, withdrawGbc);

        withdrawGbc.gridx = 0;
        withdrawGbc.gridy = 2;
        withdrawGbc.gridwidth = 2;
        withdrawPanel.add(withdrawButton, withdrawGbc);

        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(withdrawPanel, gbc);
        withdrawPanel.setVisible(false); // Hide panel initially

        // Setup Transfer Panel
        transferPanel = new JPanel(new GridBagLayout());
        GridBagConstraints transferGbc = new GridBagConstraints();
        transferGbc.insets = new Insets(5, 5, 5, 5);
        transferGbc.fill = GridBagConstraints.HORIZONTAL;
        transferGbc.anchor = GridBagConstraints.CENTER;

        transferGbc.gridx = 0;
        transferGbc.gridy = 0;
        transferPanel.add(labelTransferFrom, transferGbc);

        transferGbc.gridx = 1;
        transferPanel.add(acc1Transfer, transferGbc);

        transferGbc.gridx = 0;
        transferGbc.gridy = 1;
        transferPanel.add(labelTransferTo, transferGbc);

        transferGbc.gridx = 1;
        transferPanel.add(acc2Transfer, transferGbc);

        transferGbc.gridx = 0;
        transferGbc.gridy = 2;
        transferPanel.add(labelTransferAmount, transferGbc);

        transferGbc.gridx = 1;
        transferPanel.add(transferAmount, transferGbc);

        transferGbc.gridx = 0;
        transferGbc.gridy = 3;
        transferGbc.gridwidth = 2;
        transferPanel.add(transferButton, transferGbc);

        gbc.gridy = 4;
        gbc.gridwidth = 3;
        add(transferPanel, gbc);
        transferPanel.setVisible(false); // Hide panel initially

        // Handler for dropdown and button actions
        HandlerClass handler = new HandlerClass();
        operationDropdown.addActionListener(handler);
        depositButton.addActionListener(handler);
        withdrawButton.addActionListener(handler);
        transferButton.addActionListener(handler);

        // Basic frame settings
        setSize(800, 700); // Adjusted to fit the new layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Trigger default action for "Show All"
        handler.handleDropdownSelection("Show All");
    }

    private class HandlerClass implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == operationDropdown) {
                handleDropdownSelection((String) operationDropdown.getSelectedItem());
            } else if (e.getSource() == depositButton) {
                handleDeposit();
            } else if (e.getSource() == withdrawButton) {
                handleWithdraw();
            } else if (e.getSource() == transferButton) {
                handleTransfer();
            }
        }

        private void handleDropdownSelection(String selectedOperation) {
            // Hide all panels
            showAllData.setVisible(false);
            depositPanel.setVisible(false);
            withdrawPanel.setVisible(false);
            transferPanel.setVisible(false);

            // Show relevant panel based on selection
            switch (selectedOperation) {
                case "Show All":
                    showAllData.setVisible(true);
                    showAllData.setText(formatAccountData());
                    break;
                case "Deposit":
                    depositPanel.setVisible(true);
                    break;
                case "Withdraw":
                    withdrawPanel.setVisible(true);
                    break;
                case "Transfer":
                    transferPanel.setVisible(true);
                    break;
                default:
                    break;
            }
        }

        private void handleDeposit() {
            int accNum = Integer.parseInt(accDeposit.getText());
            int amount = Integer.parseInt(depositInput.getText());
            for (Account acc : globalAccounts) {
                if (acc.getAccountNum() == accNum) {
                    acc.deposit(amount);
                    JOptionPane.showMessageDialog(null, "Deposited: " + amount + " to Account " + accNum);
                    break;
                }
            }
        }

        private void handleWithdraw() {
            int accNum = Integer.parseInt(accWithdraw.getText());
            int amount = Integer.parseInt(withdrawInput.getText());
            for (Account acc : globalAccounts) {
                if (acc.getAccountNum() == accNum) {
                    acc.withdraw(amount);
                    JOptionPane.showMessageDialog(null, "Withdrew: " + amount + " from Account " + accNum);
                    break;
                }
            }
        }

        private void handleTransfer() {
            int acc1Num = Integer.parseInt(acc1Transfer.getText());
            int acc2Num = Integer.parseInt(acc2Transfer.getText());
            int amount = Integer.parseInt(transferAmount.getText());
            Account acc1 = null, acc2 = null;
            for (Account acc : globalAccounts) {
                if (acc.getAccountNum() == acc1Num) {
                    acc1 = acc;
                } else if (acc.getAccountNum() == acc2Num) {
                    acc2 = acc;
                }
            }
            if (acc1 != null && acc2 != null) {
                if (acc1.getBalance() >= amount) {
                    acc1.withdraw(amount);
                    acc2.deposit(amount);
                    JOptionPane.showMessageDialog(null, "Transferred: " + amount + " from Account " + acc1Num + " to Account " + acc2Num);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds in Account " + acc1Num);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid account numbers");
            }
        }
    }

    private String formatAccountData() {
        StringBuilder formattedData = new StringBuilder();
        formattedData.append("<html><body><table style='border-collapse: collapse;'>")
                .append("<tr style='background-color: #f2f2f2;'>") // Header row background color
                .append("<th style='text-align: center; padding: 8px;'>S.N</th>")
                .append("<th style='text-align: center; padding: 8px;'>First Name</th>")
                .append("<th style='text-align: center; padding: 8px;'>Last Name</th>")
                .append("<th style='text-align: center; padding: 8px;'>Account Number</th>")
                .append("<th style='text-align: center; padding: 8px;'>Balance</th>")
                .append("</tr>");
        int serialNumber = 1;
        for (Account acc : globalAccounts) {
            formattedData.append("<tr>")
                    .append("<td style='text-align: center; padding: 8px;'>").append(serialNumber++).append("</td>")
                    .append("<td style='text-align: center; padding: 8px;'>").append(acc.getFirstName()).append("</td>")
                    .append("<td style='text-align: center; padding: 8px;'>").append(acc.getLastName()).append("</td>")
                    .append("<td style='text-align: center; padding: 8px;'>").append(acc.getAccountNum()).append("</td>")
                    .append("<td style='text-align: center; padding: 8px;'>").append(acc.getBalance()).append("</td>")
                    .append("</tr>");
        }

        formattedData.append("</table></body></html>");
        return formattedData.toString();
    }
}

