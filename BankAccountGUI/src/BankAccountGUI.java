import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankAccountGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBalance;
	public BankAccount savings = BankAccountTestData.getSavingsBankAccount();
	public BankAccount chequing = BankAccountTestData.getChequingBankAccount();
	private JComboBox<String> comboBoxSelectAccount;
	private JButton btnWithdraw;
	private JButton btnDeposit;
	private JButton btnTransactions;
	public static BankAccount currentAccount;

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


		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Withdraw withdraw = new Withdraw(currentAccount);
				withdraw.setVisible(true);
			}
		});
		btnWithdraw.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnWithdraw.setBounds(10, 198, 118, 46);
		contentPane.add(btnWithdraw);


		btnDeposit = new JButton("Deposit");
		btnDeposit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Deposit deposit = new Deposit(currentAccount);
				deposit.setVisible(true);
			}
		});
		btnDeposit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnDeposit.setBounds(152, 198, 118, 46);
		contentPane.add(btnDeposit);


		btnTransactions = new JButton("Transactions");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transactions.main(null);
			}
		});
		btnTransactions.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnTransactions.setBounds(294, 198, 118, 46);
		contentPane.add(btnTransactions);


		comboBoxSelectAccount = new JComboBox<String>();
		comboBoxSelectAccount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBoxSelectAccount.setMaximumRowCount(3);
		comboBoxSelectAccount.addItem("Please select an Account");
		comboBoxSelectAccount.addItem("Chequing");
		comboBoxSelectAccount.addItem("Savings");
		comboBoxSelectAccount.setBounds(95, 22, 198, 34);
		contentPane.add(comboBoxSelectAccount);
		comboBoxSelectAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setControls();
			}
		});

	}

	private void setControls() {
		try {
			String rowName = (String)comboBoxSelectAccount.getSelectedItem();
			if (rowName == "Chequing") {
				currentAccount = chequing;
				textFieldBalance.setEnabled(true);
				textFieldBalance.setText(String.format("%.2f", chequing.getBalance()));
				btnWithdraw.setEnabled(true);
				btnDeposit.setEnabled(true);
				btnTransactions.setEnabled(true);
			}
			else if(rowName == "Savings"){
				currentAccount = savings;
				textFieldBalance.setEnabled(true);
				textFieldBalance.setText(String.format("%.2f", savings.getBalance()));
				btnWithdraw.setEnabled(true);
				btnDeposit.setEnabled(true);
				btnTransactions.setEnabled(true);
			}
			else {

				textFieldBalance.setEnabled(false);
				btnWithdraw.setEnabled(false);
				btnDeposit.setEnabled(false);
				btnTransactions.setEnabled(false);
				System.out.print("Epic");
			}
		} catch(NullPointerException e) {
			textFieldBalance.setEnabled(false);
			btnWithdraw.setEnabled(false);
			btnDeposit.setEnabled(false);
			btnTransactions.setEnabled(false);

		}
	}

	protected static void btnWithdraw_mouseClicked(MouseEvent arg0) {
		System.out.print("Epic Withdraw");
	}
	protected static void btnDeposit_mouseClicked(MouseEvent arg0) {
		System.out.print("Epic Deposit");
	}
}
