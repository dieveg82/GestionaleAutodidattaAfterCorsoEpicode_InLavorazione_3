package gestionale.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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

import org.jdesktop.swingx.JXFindBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gestionale.model.Cliente;
import gestionale.model.Fattura;
import gestionale.service.ClienteService;
import gestionale.service.FatturaService;
import lombok.Getter;
import lombok.Setter;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

@Setter
@Getter
@SpringBootApplication
public class MenuFattura {

	private JDialog frmMenuFattura;
	private JTable table;
	private DefaultTableModel dtmAnagrafica;
	private JButton btnNewButtonModifica;
	private JButton btnNewButtonElimina;
	private JButton btnNewButtonFiltra;
	private Fattura fattura;
	private boolean filtro = false;
	private int mouseSelezione = 0;
	private Cliente cliente;

	@Autowired
	FiltroFattura filtroFattura;
	@Autowired
	InserimentoFattura inserimentoFattura;
	@Autowired
	FatturaService fatturaService;
	@Autowired
	MenuFattura menuFattura;
	@Autowired
	ClienteService clienteService;
	@Autowired
	MessaggioConferma messaggioConferma;

	public MenuFattura() throws SQLException {

	}

	public void initialize() {
		frmMenuFattura = new JDialog();
		frmMenuFattura.setTitle("Gestionale Dott.ssa ");
		frmMenuFattura.setBounds(100, 100, 1200, 480);
		frmMenuFattura.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmMenuFattura.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 1164, 348);
		frmMenuFattura.getContentPane().add(scrollPane);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Num Fattura", "DataFattura", "Cognome", "Nome", "Trattamento", "Trattamento",
						"Trattamento", "Imponibile", "Totale Fattura", "Metodo Pagamento" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(3).setPreferredWidth(107);
		table.getColumnModel().getColumn(7).setPreferredWidth(96);
		table.getColumnModel().getColumn(8).setPreferredWidth(85);
		table.getColumnModel().getColumn(9).setPreferredWidth(233);
		scrollPane.setViewportView(table);

		btnNewButtonModifica = new JButton("Modifica");
		btnNewButtonModifica.setBounds(10, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButtonModifica);

		btnNewButtonModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inserimentoFattura.setCliente(cliente);
				inserimentoFattura.setFattura(fattura);
				inserimentoFattura.setModifica(true);
				inserimentoFattura.initialize();
				

			}
		});

		btnNewButtonElimina = new JButton("Elimina");
		btnNewButtonElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fattura.setNumeroFattura(null);
				fattura.setBollo((fattura.getBollo()*-1));
				fattura.setEmap(fattura.getEmap() * -1);
				fattura.setImponibile(fattura.getImponibile() * -1);
				fattura.setTotaleFattura(fattura.getTotaleFattura() * -1);
				fatturaService.insertFattura(fattura);
				frmMenuFattura.dispose();
				messaggioConferma.setLblNewLabel(new JLabel ("Creata Nota di credito a storno !"));
				messaggioConferma.initialize();
				menuFattura.initialize();
			}
		});
		btnNewButtonElimina.setBounds(122, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButtonElimina);
		btnNewButtonFiltra = new JButton("Filtra");
		btnNewButtonFiltra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			filtroFattura.initialize();		

			}
		});
		btnNewButtonFiltra.setBounds(233, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButtonFiltra);

		JLabel lblNewLabel = new JLabel("Selezionare Riga prima dei comandi Modifica / Elimina / Stampa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 384, 532, 14);
		frmMenuFattura.getContentPane().add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("Inserisci ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMenuFattura.dispose();
				inserimentoFattura.initialize();
			}
		});
		btnNewButton_3.setBounds(341, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Stampa");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				try {
//
//					JasperDesign stampaDesign = JRXmlLoader
//							.load("C:\\Users\\Diego\\eclipse-workspace\\ProgettoEster\\Blank_A4.jrxml");
//					String sql = "SELECT * FROM fattura WHERE `NumeroFattura` = " + mouseSelezione + " ";
//
//					JRDesignQuery selezioneJrDesignQuery = new JRDesignQuery();
//					selezioneJrDesignQuery.setText(sql);
//					stampaDesign.setQuery(selezioneJrDesignQuery);
//
//					HashMap<String, Object> mappasqlHashMap = new HashMap<>();
//					mappasqlHashMap.put("NumeroFattura", mouseSelezione);
//
//					JasperReport jsJasperReport = JasperCompileManager.compileReport(stampaDesign);
//					JasperPrint jPrint = JasperFillManager.fillReport(jsJasperReport, mappasqlHashMap, con);
//
//					JasperViewer.viewReport(jPrint, false);
//
//				} catch (JRException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
			}
		});
		btnNewButton_3_1.setBounds(453, 407, 89, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_3_1);

		JButton btnNewButton_3_1_1 = new JButton("Report Fatture\r\n");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				try {
//					JasperDesign stampaDesign = JRXmlLoader
//							.load("C:\\Users\\Diego\\eclipse-workspace\\ProgettoEster\\Blank_A4_Landscape.jrxml");
//					String sql = "SELECT * FROM fattura ";
//
//					JRDesignQuery selezioneJrDesignQuery = new JRDesignQuery();
//					selezioneJrDesignQuery.setText(sql);
//					stampaDesign.setQuery(selezioneJrDesignQuery);
//
//					HashMap<String, Object> mappasqlHashMap = new HashMap<>();
//					mappasqlHashMap.put("NumeroFattura", sql);
//
//					JasperReport jsJasperReport = JasperCompileManager.compileReport(stampaDesign);
//					JasperPrint jPrint = JasperFillManager.fillReport(jsJasperReport, mappasqlHashMap, con);
//					JasperViewer.viewReport(jPrint, false);
//
//				} catch (JRException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//
			}
		});
		btnNewButton_3_1_1.setBounds(564, 407, 112, 23);
		frmMenuFattura.getContentPane().add(btnNewButton_3_1_1);

		dtmAnagrafica = (DefaultTableModel) table.getModel();

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 0) {
					fattura = fatturaService.findByNumeroFattura((Integer) dtmAnagrafica.getValueAt(table.getSelectedRow(), 0));
					fattura.setNumeroFattura((Integer) dtmAnagrafica.getValueAt(table.getSelectedRow(), 0));
					fattura.setDataFattura((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 1));
					fattura.getCliente().setCognome((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 2)); 
					fattura.getCliente().setNome((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 3));
					cliente = clienteService.findByNomeByCognome(fattura.getCliente().getCognome(), fattura.getCliente().getNome());
					fattura.setTrattamento((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 4));
					fattura.setTrattamento2((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 5));
					fattura.setTrattamento3((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 6));
					fattura.setImponibile((Double) dtmAnagrafica.getValueAt(table.getSelectedRow(), 7));
					fattura.setTotaleFattura((Double) dtmAnagrafica.getValueAt(table.getSelectedRow(), 8));
					fattura.setMetodoPagamento((String) dtmAnagrafica.getValueAt(table.getSelectedRow(), 9));
				}
			}
		});
		popolaTabella();
		frmMenuFattura.setVisible(true);	
	}

	public void popolaTabella() {
		List<Fattura> listFattura = fatturaService.findAll();

		for (Fattura f : listFattura) {
			Vector rowData = new Vector();
			rowData.add(f.getNumeroFattura());
			rowData.add(f.getDataFattura());
			rowData.add(f.getCliente().getCognome());
			rowData.add(f.getCliente().getNome());
			rowData.add(f.getTrattamento());
			rowData.add(f.getTrattamento2());
			rowData.add(f.getTrattamento3());
			rowData.add(f.getImponibile());
			rowData.add(f.getTotaleFattura());
			rowData.add(f.getMetodoPagamento());
			dtmAnagrafica.addRow(rowData);
		}
	}
}
