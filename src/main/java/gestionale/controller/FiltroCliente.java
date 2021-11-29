package gestionale.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gestionale.model.Cliente;
import gestionale.model.Fattura;
import gestionale.service.ClienteService;
import gestionale.service.FatturaService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SpringBootApplication
public class FiltroCliente {

	private JDialog frmFiltro;
	private JTextField textField;
	private DefaultTableModel dtmFiltroDefaultTableModel;
	private List<Cliente> listCliente = new ArrayList<Cliente>();

	@Autowired
	ClienteService clienteService;
	
	public FiltroCliente() {
	}

	public void initialize() {
		frmFiltro = new JDialog();
		frmFiltro.setTitle("Gestionale .......");
		frmFiltro.setBounds(400, 200, 316, 180);
		frmFiltro.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmFiltro.getContentPane().setLayout(null);
		final String[] filtro = { "Nome", "Cognome", "Codice Fiscale", "Citta" };
		JComboBox comboBox = new JComboBox(filtro);
		comboBox.setBounds(95, 26, 102, 22);
		frmFiltro.getContentPane().add(comboBox);

		textField = new JTextField();
		textField.setBounds(49, 59, 186, 20);
		frmFiltro.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					listCliente = clienteService.find(filtro[comboBox.getSelectedIndex()], textField.getText());
					frmFiltro.dispose();
			}
		});
		btnNewButton.setBounds(95, 90, 89, 23);
		frmFiltro.getContentPane().add(btnNewButton);
		frmFiltro.setModal(true);
		frmFiltro.setVisible(true);

	}
}
