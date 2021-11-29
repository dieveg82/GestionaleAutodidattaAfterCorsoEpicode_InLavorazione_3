package gestionale.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gestionale.model.Cliente;
import gestionale.service.ClienteService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SpringBootApplication
public class AnagraficaClienti {

	private JDialog frmAnagrafica;
	private JTable table;
	private DefaultTableModel dtmAnagrafica;
	private int selezioneInt;
	private Cliente cliente = new Cliente();
	private Cliente clienteFattura = new Cliente ();
	private boolean ricercaPerFiltro = false;
	private boolean inserisciFattura = false;
	@Autowired
	ClienteService clienteService;
	@Autowired
	InserimentoClienti clienteBean;
	@Autowired
	AnagraficaClienti anagraficaClienti;
	@Autowired
	FiltroCliente filtroCliente;

	public AnagraficaClienti() throws SQLException {
	
	}

	public void initialize() throws SQLException {
		frmAnagrafica = new JDialog();
		frmAnagrafica.setTitle("Gestionale Dott.ssa ");
		frmAnagrafica.setBounds(100, 100, 1215, 703);
		frmAnagrafica.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAnagrafica.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 1179, 555);
		frmAnagrafica.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int contaclick = e.getClickCount();
				if (contaclick == 1) {
					cliente.setId((int) dtmAnagrafica.getValueAt(table.getSelectedRow(), 0));
				} else if ( contaclick > 1) {
					clienteFattura = clienteService.getById((int) dtmAnagrafica.getValueAt(table.getSelectedRow(), 0));
					frmAnagrafica.dispose ();
				}
			}
		});
		table.setModel(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Cognome", "Nome", "Codice Fiscale", "Via", "Numero Civico", "Codice Postale", "Citta", "Capoluogo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(1).setPreferredWidth(137);
		table.getColumnModel().getColumn(2).setPreferredWidth(141);
		table.getColumnModel().getColumn(3).setPreferredWidth(152);
		table.getColumnModel().getColumn(4).setPreferredWidth(142);
		table.getColumnModel().getColumn(5).setPreferredWidth(99);
		table.getColumnModel().getColumn(6).setPreferredWidth(109);
		table.getColumnModel().getColumn(7).setPreferredWidth(165);
		table.getColumnModel().getColumn(8).setPreferredWidth(111);
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Modifica");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				clienteBean.setId(cliente.getId());
				clienteBean.setModifica(true);
				try {
					clienteBean.setModifica(true);
					clienteBean.initialize();
					frmAnagrafica.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(68, 601, 136, 23);
		frmAnagrafica.getContentPane().add(btnNewButton);

		JButton btnElimina = new JButton("Elimina\r\n");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clienteService.deleteCliente(cliente.getId());
				frmAnagrafica.dispose();
				try {
					anagraficaClienti.initialize();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnElimina.setBounds(407, 601, 136, 23);
		frmAnagrafica.getContentPane().add(btnElimina);

		JButton btnFiltra = new JButton("Filtra");
		btnFiltra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtroCliente.initialize();
				ricercaPerFiltro = true;
				frmAnagrafica.dispose();
				try {
					anagraficaClienti.initialize();
					ricercaPerFiltro = false;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFiltra.setBounds(242, 601, 136, 23);
		frmAnagrafica.getContentPane().add(btnFiltra);

		JButton btnStampa = new JButton("Stampa\r\n");
		btnStampa.setBounds(569, 601, 136, 23);
		frmAnagrafica.getContentPane().add(btnStampa);

		JLabel lblNewLabel = new JLabel("Fare click sulla riga desiderata prima di premere Modifica / Elimina");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(192, 635, 465, 14);
		frmAnagrafica.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliccare due volte per inserire il cliente in fattura");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 11, 291, 14);
		frmAnagrafica.getContentPane().add(lblNewLabel_1);
		

		dtmAnagrafica = (DefaultTableModel) table.getModel();

		popolaTabella();
		if (inserisciFattura == true) {
			frmAnagrafica.setModal ( true);
		}
		frmAnagrafica.setVisible(true);
	}

	public void popolaTabella() throws SQLException {
		List<Cliente> listCliente = new ArrayList<Cliente>();
		if (ricercaPerFiltro == true) {
			listCliente = filtroCliente.getListCliente();
		} else {
			listCliente = clienteService.findAll();
		}
		for (Cliente c : listCliente) {
			Vector rowData = new Vector();
			rowData.add(c.getId());
			rowData.add(c.getCognome());
			rowData.add(c.getNome());
			rowData.add(c.getCodiceFiscale());
			rowData.add(c.getVia());
			rowData.add(c.getNumeroCivico());
			rowData.add(c.getCodicePostale());
			rowData.add(c.getCitta());
			rowData.add(c.getCapoluogo());
			dtmAnagrafica.addRow(rowData);

		}
	}
}
