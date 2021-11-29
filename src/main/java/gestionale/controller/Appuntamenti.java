package gestionale.controller;

/*
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gestionale.repository.QueryAppuntamenti;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Appuntamenti {

	private JDialog frmAppuntamenti;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public String dataStringMouse;
	public boolean erroreAppuntamenti = false;
	
	public Appuntamenti() {
		
	}

	
	public void initialize() {
		frmAppuntamenti = new JDialog();
		frmAppuntamenti.setTitle("Gestionale ........\r\n");
		frmAppuntamenti.setBounds(400, 200, 316, 196);
		frmAppuntamenti.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAppuntamenti.getContentPane().setLayout(null);
		
		JLabel lblCognome = new JLabel("Cognome\r\n");
		lblCognome.setBounds(10, 35, 68, 14);
		frmAppuntamenti.getContentPane().add(lblCognome);
		
		JLabel lblNome = new JLabel("Nome\r\n");
		lblNome.setBounds(10, 60, 68, 14);
		frmAppuntamenti.getContentPane().add(lblNome);
		
		JLabel lblOrario = new JLabel("Orario\r\n");
		lblOrario.setBounds(10, 85, 68, 14);
		frmAppuntamenti.getContentPane().add(lblOrario);
		
		textField = new JTextField();
		textField.setBounds(88, 32, 176, 20);
		frmAppuntamenti.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 57, 176, 20);
		frmAppuntamenti.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(88, 82, 68, 20);
		frmAppuntamenti.getContentPane().add(textField_2);
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QueryAppuntamenti queryAppuntamenti = new QueryAppuntamenti();
				try {
					queryAppuntamenti.inserimentoAppuntamenti(textField.getText(), textField_1.getText(), textField_2.getText(),dataStringMouse);
					if (queryAppuntamenti.errore == true) { erroreAppuntamenti = true;			}
				} catch (SQLException | IOException e1) {
					e1.printStackTrace();
				}
				frmAppuntamenti.dispose();
				
			}
		});
		btnSalva.setBounds(98, 111, 113, 23);
		frmAppuntamenti.getContentPane().add(btnSalva);
		frmAppuntamenti.setModal(true);
		frmAppuntamenti.setVisible(true);
	}
}
*/