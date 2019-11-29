import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Withdraw extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAmount;
	private JTextField textFieldDescription;

	public static void main(String[] args) {
		try {
			Withdraw dialog = new Withdraw();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Withdraw() {
		setFont(new Font("Times New Roman", Font.PLAIN, 15));
		setTitle("Withdraw");
		setBounds(100, 100, 300, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAmount = new JLabel("Please provide the amount to be withdrawn:");
			lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblAmount.setBounds(10, 40, 265, 14);
			contentPanel.add(lblAmount);
		}
		
		JButton btnConfirm = new JButton("OK");
		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnConfirm.setBounds(86, 157, 89, 23);
		contentPanel.add(btnConfirm);
		
		textFieldAmount = new JTextField();
		textFieldAmount.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				DocumentEvent.EventType type = documentEvent.getType();
		        String typeString = null;
		        if (type.equals(DocumentEvent.EventType.CHANGE)) {
		          typeString = "Change";
		        }  else if (type.equals(DocumentEvent.EventType.INSERT)) {
		          typeString = "Insert";
		        }  else if (type.equals(DocumentEvent.EventType.REMOVE)) {
		          typeString = "Remove";
		        }
				btnConfirm.setEnabled(true);
				String input = textFieldAmount.getText();
				try {
					textFieldAmount.setBackground(Color.WHITE);
					double amount = Double.valueOf(input);
				} catch(Exception e) {
					textFieldAmount.setBackground(Color.RED);
				}
			}
		});
		textFieldAmount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldAmount.setBounds(10, 67, 256, 20);
		contentPanel.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblDescription = new JLabel("(Optional) provide a description");
		lblDescription.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDescription.setBounds(10, 98, 265, 14);
		contentPanel.add(lblDescription);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(10, 123, 256, 20);
		contentPanel.add(textFieldDescription);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCancel.setBounds(185, 157, 89, 23);
		contentPanel.add(btnCancel);
	}
}
