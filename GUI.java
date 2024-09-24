package Coursework;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class GUI extends JFrame {
    private Transaction transferObject;
    private LinkedList<Account> globalAccounts;
    private StringBuilder sbAllData;

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField accDeposit;
    private JTextField accWithdraw;
    private JTextField acc1Transfer;
    private JTextField acc2Transfer;
    private JTextField depositInput;
    private JTextField withdrawInput;
    private JTextField transferAmount;

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        getContentPane().setLayout(null);

        this.globalAccounts = accounts;
        this.transferObject = new Transaction();
        this.sbAllData = new StringBuilder();

        for (Account account : accounts) {
            sbAllData
                    .append(account.getFirstName())
                    .append(" ")
                    .append(account.getLastName())
                    .append(" ")
                    .append(account.getAccountNumber())
                    .append(" ")
                    .append(account.getBalance()).append("\n");
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 872, 536);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(173, 130, 213));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Banking System");
        lblNewLabel.setForeground(new Color(64, 0, 0));
        lblNewLabel.setBackground(new Color(64, 0, 0));
        lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 30));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(281, 10, 226, 45);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Deposit Account");
        lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(46, 91, 121, 24);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Withdraw Account");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(46, 141, 121, 24);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Transfer from");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1_2.setBounds(46, 190, 121, 24);
        contentPane.add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("Transfer to");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_3.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1_3.setBounds(62, 235, 105, 24);
        contentPane.add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("Deposit Amount");
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_4.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1_4.setBounds(46, 282, 121, 24);
        contentPane.add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("Withdraw Amount");
        lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_5.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1_5.setBounds(46, 326, 121, 24);
        contentPane.add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("Transfer Amount");
        lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_6.setFont(new Font("Yu Gothic", Font.BOLD, 13));
        lblNewLabel_1_6.setBounds(46, 367, 121, 24);
        contentPane.add(lblNewLabel_1_6);

        accDeposit = new JTextField();
        accDeposit.setBackground(new Color(128, 128, 128));
        accDeposit.setBounds(225, 88, 176, 24);
        contentPane.add(accDeposit);
        accDeposit.setColumns(10);

        accWithdraw = new JTextField();
        accWithdraw.setBackground(new Color(128, 128, 128));
        accWithdraw.setColumns(10);
        accWithdraw.setBounds(225, 138, 176, 24);
        contentPane.add(accWithdraw);

        acc1Transfer = new JTextField();
        acc1Transfer.setBackground(new Color(128, 128, 128));
        acc1Transfer.setColumns(10);
        acc1Transfer.setBounds(225, 187, 176, 24);
        contentPane.add(acc1Transfer);

        acc2Transfer = new JTextField();
        acc2Transfer.setBackground(new Color(128, 128, 128));
        acc2Transfer.setColumns(10);
        acc2Transfer.setBounds(225, 232, 176, 24);
        contentPane.add(acc2Transfer);

        depositInput = new JTextField();
        depositInput.setBackground(new Color(128, 128, 128));
        depositInput.setColumns(10);
        depositInput.setBounds(225, 279, 176, 24);
        contentPane.add(depositInput);

        withdrawInput = new JTextField();
        withdrawInput.setBackground(new Color(128, 128, 128));
        withdrawInput.setColumns(10);
        withdrawInput.setBounds(225, 323, 176, 24);
        contentPane.add(withdrawInput);

        transferAmount = new JTextField();
        transferAmount.setBackground(new Color(128, 128, 128));
        transferAmount.setColumns(10);
        transferAmount.setBounds(225, 364, 176, 24);
        contentPane.add(transferAmount);

        JTextArea showAllData = new JTextArea();
        showAllData.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
        showAllData.setBackground(new Color(192, 192, 192));
        showAllData.setForeground(new Color(0, 0, 0));
        showAllData.setBounds(487, 80, 274, 161);
        contentPane.add(showAllData);

        JButton showAllButton = new JButton("Show All Data");
        showAllButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
        showAllButton.setBackground(new Color(156, 189, 194));
        showAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAllData.setText(sbAllData.toString());
            }
        });
        showAllButton.setBounds(633, 272, 128, 36);
        contentPane.add(showAllButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
        depositButton.setBackground(new Color(156, 189, 194));
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accDepositText = accDeposit.getText();
                String depositInputText = depositInput.getText();

                if (validateInput(accDepositText, depositInputText)) {
                    int accountNumber = Integer.parseInt(accDepositText) - 1;
                    int amount = Integer.parseInt(depositInputText);

                    if (accountNumber >= 0 && accountNumber < globalAccounts.size() && amount > 0) {
                        globalAccounts.get(accountNumber).deposit(amount);

                        updateAllData();

                        showAllData.setText(sbAllData.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Please provide valid account numbers and a positive amount.");
                    }
                }
            }
        });
        depositButton.setBounds(487, 272, 128, 36);
        contentPane.add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
        withdrawButton.setBackground(new Color(156, 189, 194));
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accWithdrawText = accWithdraw.getText();
                String withdrawInputText = withdrawInput.getText();

                if (validateInput(accWithdrawText, withdrawInputText)) {
                    int accountNumber = Integer.parseInt(accWithdrawText) - 1;
                    int amount = Integer.parseInt(withdrawInputText);

                    if (accountNumber >= 0 && accountNumber < globalAccounts.size() && amount > 0) {
                        Account account = globalAccounts.get(accountNumber);

                        if (account.getBalance() >= amount) {
                            account.withdraw(amount);
                            updateAllData();
                            showAllData.setText(sbAllData.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds in the account.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please provide valid account numbers and a positive amount.");
                    }
                }
            }
        });
        withdrawButton.setBounds(633, 326, 128, 36);
        contentPane.add(withdrawButton);

        JButton transferButton = new JButton("Transfer");
        transferButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
        transferButton.setBackground(new Color(156, 189, 194));
        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String acc1TransferText = acc1Transfer.getText();
                String acc2TransferText = acc2Transfer.getText();
                String transferAmountText = transferAmount.getText();

                if (validateInput(acc1TransferText, acc2TransferText, transferAmountText)) {
                    int account1Number = Integer.parseInt(acc1TransferText) - 1;
                    int account2Number = Integer.parseInt(acc2TransferText) - 1;
                    int amount = Integer.parseInt(transferAmountText);

                    if (account1Number >= 0 && account1Number < globalAccounts.size()
                            && account2Number >= 0 && account2Number < globalAccounts.size()
                            && amount > 0) {
                        Account account1 = globalAccounts.get(account1Number);
                        Account account2 = globalAccounts.get(account2Number);

                        if (account1.getBalance() >= amount) {
                            account1.withdraw(amount);
                            account2.deposit(amount);

                            updateAllData();

                            showAllData.setText(sbAllData.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "Account 1 has insufficient funds for the transfer.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please provide valid account numbers and a positive amount.");
                    }
                }
            }
        });
        transferButton.setBounds(487, 326, 128, 36);
        contentPane.add(transferButton);
    }

    private boolean validateInput(String... inputs) {
        for (String input : inputs) {
            if (input.isEmpty() || !input.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers.");
                return false;
            }
        }
        return true;
    }

    private void updateAllData() {
        sbAllData = new StringBuilder();
        for (Account account : globalAccounts) {
            sbAllData
                    .append(account.getFirstName())
                    .append(" ")
                    .append(account.getLastName())
                    .append(" ")
                    .append(account.getAccountNumber())
                    .append(" ")
                    .append(account.getBalance()).append("\n");
        }
    }
}
