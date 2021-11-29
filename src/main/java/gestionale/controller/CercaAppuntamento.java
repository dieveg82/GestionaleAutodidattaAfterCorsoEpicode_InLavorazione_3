package gestionale.controller;
/*
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import gestionale.repository.QueryAppuntamenti;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CercaAppuntamento {

	private JDialog frmFindAppuntamento;
	private JTextField textField;
	ResultSet rsetCercaAppuntamento;



	public CercaAppuntamento() {
		initialize();
	}


	private void initialize() {
		frmFindAppuntamento = new JDialog();
		frmFindAppuntamento.setTitle("Gestionale .......");
		frmFindAppuntamento.setBounds(100, 100, 323, 192);
		frmFindAppuntamento.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmFindAppuntamento.getContentPane().setLayout(null);
		
		final String[] cercaAppuntamento = { "Cognome" , "Nome" };
		final JComboBox comboBox = new JComboBox(cercaAppuntamento);
		comboBox.setBounds(66, 41, 144, 22);
		frmFindAppuntamento.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(84, 75, 109, 20);
		frmFindAppuntamento.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cerca\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryAppuntamenti cercAppuntamenti = new QueryAppuntamenti();
				
				try {
					rsetCercaAppuntamento =cercAppuntamenti.cercaAppuntamento(cercaAppuntamento[comboBox.getSelectedIndex()], textField.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				frmFindAppuntamento.dispose();
			}
		});
		btnNewButton.setBounds(94, 106, 89, 23);
		frmFindAppuntamento.getContentPane().add(btnNewButton);
		frmFindAppuntamento.setModal(true);
		frmFindAppuntamento.setVisible(true);
	}
}
*/