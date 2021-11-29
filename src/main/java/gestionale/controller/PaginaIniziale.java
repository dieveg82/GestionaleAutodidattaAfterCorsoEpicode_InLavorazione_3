package gestionale.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import gestionale.service.ClienteService;

@SpringBootApplication
public class PaginaIniziale {

	@Autowired
	InserimentoClienti inserimentoClienti;
	@Autowired
	AnagraficaClienti anagraficaClienti;
	@Autowired
	MenuFattura menuFattura;

	private JFrame frmPaginaIniziale;

	public void initialize() throws SQLException {
		frmPaginaIniziale = new JFrame();
		frmPaginaIniziale.setBounds(400, 200, 417, 279);
		frmPaginaIniziale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPaginaIniziale.getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Gestionale");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 45, 266, 39);
		frmPaginaIniziale.getContentPane().add(lblNewLabel);
		frmPaginaIniziale.setVisible(true);
		JButton btnNewButton = new JButton("Inserisci Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					inserimentoClienti.initialize();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(59, 106, 137, 23);
		frmPaginaIniziale.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Fattura");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menuFattura.initialize();
				/*
				 * MenuFattura menuFattura; try { menuFattura = new MenuFattura(); QueryFattura
				 * queryFattura = new QueryFattura(); try { menuFattura.initialize(); resultSet
				 * = queryFattura.selezioneFattura();
				 * menuFattura.dtmDefaultTableModel(resultSet); } catch (SQLException e1) { //
				 * TODO Auto-generated catch block e1.printStackTrace(); } } catch (SQLException
				 * e2) { // TODO Auto-generated catch block e2.printStackTrace(); }
				 */ }
		});
		btnNewButton_1.setBounds(206, 106, 131, 23);
		frmPaginaIniziale.getContentPane().add(btnNewButton_1);
		JButton btnAnagrafica = new JButton("Anagrafica");
		btnAnagrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						anagraficaClienti.initialize();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		btnAnagrafica.setBounds(59, 140, 137, 23);
		frmPaginaIniziale.getContentPane().add(btnAnagrafica);

		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				Agenda agenda = new Agenda();
//				agenda.inserimentoGiorniDefaultTableModel();
//				agenda.dtmTableModel.getTableModelListeners();
			}
		});
		btnAgenda.setBounds(206, 140, 131, 23);
		frmPaginaIniziale.getContentPane().add(btnAgenda);
	}
}