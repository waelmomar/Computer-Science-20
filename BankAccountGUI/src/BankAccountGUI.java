import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JButton;

public class BankAccountGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldBalance;
	public BankAccount savings = BankAccountTestData.getSavingsBankAccount();
	public BankAccount chequing = BankAccountTestData.getChequingBankAccount();
	public BankAccount currentAccount;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankAccountGUI frame = new BankAccountGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BankAccountGUI() {
		setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Bank Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAccount.setBounds(10, 22, 75, 35);
		contentPane.add(lblAccount);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:  ");
		lblCurrentBalance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCurrentBalance.setBounds(10, 123, 118, 20);
		contentPane.add(lblCurrentBalance);
		
		textFieldBalance = new JTextField();
		textFieldBalance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldBalance.setEditable(false);
		textFieldBalance.setBounds(115, 116, 178, 35);
		contentPane.add(textFieldBalance);
		textFieldBalance.setColumns(10);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Withdraw.main(null);
			}
		});
		btnWithdraw.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnWithdraw.setBounds(10, 198, 118, 46);
		contentPane.add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit.main(null);
			}
		});
		btnDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDeposit.setBounds(152, 198, 118, 46);
		contentPane.add(btnDeposit);
		
		JButton btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions.main(null);
			}
		});
		btnTransactions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTransactions.setBounds(294, 198, 118, 46);
		contentPane.add(btnTransactions);
		
		JComboBox comboBoxSelectAccount = new JComboBox();
		comboBoxSelectAccount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSelectAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rowName = (String)comboBoxSelectAccount.getSelectedItem();
				if (rowName == "Please select an Account") {
					textFieldBalance.setEnabled(false);
					btnWithdraw.setEnabled(false);
					btnDeposit.setEnabled(false);
					btnTransactions.setEnabled(false);
				}
				if (rowName == "Chequing") {
					currentAccount = chequing;
					textFieldBalance.setEnabled(true);
					textFieldBalance.setText(String.format("%.2f", chequing.getBalance()));
					btnWithdraw.setEnabled(true);
					btnDeposit.setEnabled(true);
					btnTransactions.setEnabled(true);
				}
				if (rowName == "Savings") {
					currentAccount = savings;
					textFieldBalance.setEnabled(true);
					textFieldBalance.setText(String.format("%.2f", savings.getBalance()));
					btnWithdraw.setEnabled(true);
					btnDeposit.setEnabled(true);
					btnTransactions.setEnabled(true);
				}
			}
		});
		comboBoxSelectAccount.setMaximumRowCount(3);
		comboBoxSelectAccount.addItem("Please select an Account");
		comboBoxSelectAccount.addItem("Chequing");
		comboBoxSelectAccount.addItem("Savings");
		comboBoxSelectAccount.setBounds(95, 22, 198, 34);
		contentPane.add(comboBoxSelectAccount);
	}
}
