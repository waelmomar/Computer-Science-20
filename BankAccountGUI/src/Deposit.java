import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JDialog {
	private JTextField textFieldAmount;
	private JTextField textFieldDescription;

	public static void main(String[] args) {
		try {
			Deposit dialog = new Deposit();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Deposit() {
		setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Deposit");
		setBounds(100, 100, 300, 230);
		getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBounds(0, 0, 284, 191);
		getContentPane().add(contentPanel);
		
		JLabel lblAmount = new JLabel("Please provide the amount to deposit:");
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblAmount.setBounds(10, 40, 265, 14);
		contentPanel.add(lblAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldAmount.setColumns(10);
		textFieldAmount.setBounds(10, 67, 256, 20);
		contentPanel.add(textFieldAmount);
		
		JLabel lblDescription = new JLabel("(Optional) provide a description");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDescription.setBounds(10, 98, 265, 14);
		contentPanel.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(10, 123, 256, 20);
		contentPanel.add(textFieldDescription);
		
		JButton btnConfirm = new JButton("OK");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnConfirm.setBounds(86, 157, 89, 23);
		contentPanel.add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(185, 157, 89, 23);
		contentPanel.add(btnCancel);
	}
}
