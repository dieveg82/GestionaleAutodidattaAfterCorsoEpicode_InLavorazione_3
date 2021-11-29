package gestionale.controller;
/*


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Agenda {

	private JFrame frmAgenda;
	private JTable table;
	public DefaultTableModel dtmTableModel ;
	JComboBox meseComboBox;
	JComboBox annoComboBox;
	private JButton btnVerificaApputamenti;
	private JTable appuntamentiTable;
	private JLabel lblNewLabel;
	String dataStringMouse ="";
	ResultSet resultSet;
	DefaultTableModel tableAppuntamentiDefaultTableModel ;
	int idAppuntamenti = 0;
	public boolean erroreAppuntamenti = false;
		public Agenda() {
		initialize();
	}


	private void initialize() {
		frmAgenda = new JFrame();
		frmAgenda.setTitle("Gestionale .......\r\n");
		frmAgenda.setBounds(400, 200, 954, 300);
		frmAgenda.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 128, 550, 122);
		frmAgenda.getContentPane().add(scrollPane);
		
		table = new JTable();
		tableAppuntamentiDefaultTableModel = new DefaultTableModel();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				// PULIZIA DATABELLA APPUNTAMENTI //
				if (tableAppuntamentiDefaultTableModel.getRowCount() != 0) {
		
				while (tableAppuntamentiDefaultTableModel.getRowCount() !=0) {
					tableAppuntamentiDefaultTableModel.removeRow(0);
				}; }
			
				
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String annoComboxInt = (String) annoComboBox.getSelectedItem();
				
				int giorno = (int) table.getValueAt(row, column);
				int mese = meseComboBox.getSelectedIndex() + 1 ;
				int anno = Integer.valueOf(annoComboxInt);
				dataStringMouse = (String.valueOf(giorno) + "/" + String.valueOf(mese) + "/" + String.valueOf(anno) );
				verificaAppuntamenti();
			
 
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Lunedi", "Marted\u00EC", "Mercoledi", "Giovedi", "Venedi'", "Sabato", "Domenica"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.getColumnModel().getColumn(4).setPreferredWidth(58);
		table.getColumnModel().getColumn(5).setPreferredWidth(58);
		table.getColumnModel().getColumn(6).setPreferredWidth(58);
		scrollPane.setViewportView(table);
		
		dtmTableModel = new DefaultTableModel();
		dtmTableModel = (DefaultTableModel) table.getModel();
		
		
		JLabel lblMese = new JLabel("Mese");
		lblMese.setHorizontalAlignment(SwingConstants.CENTER);
		lblMese.setBounds(10, 22, 64, 14);
		frmAgenda.getContentPane().add(lblMese);
		
		String[] meseStrings  = {"Gennaio " , "Febbraio" , "Marzo" , "Aprile" , "Maggio" , "Giugno" , "Luglio" , "Agosto" ," Settembre" , "Ottobre ","Novembre" , "Dicembre"};
		meseComboBox = new JComboBox(meseStrings);
		meseComboBox.setBounds(96, 18, 74, 22);
		frmAgenda.getContentPane().add(meseComboBox);
		java.util.Date dataDate = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); // attenzione yyyy/MM/dd deve essere sempre scritto cosi
		System.out.println(format.format(dataDate));
		format = new SimpleDateFormat("yyyy/LLLLLLLL/dd");// la m minuscola indica i minuti
		System.out.println(format.format(dataDate));
//		org.joda.time.LocalDate dataDate2 = new org.joda.time.LocalDate();	
//		int meseComboBoxIniziale = dataDate2.getMonthOfYear() - 1;
//		System.out.println( dataDate2.parse("2020-3-04"));
//		meseComboBox.setSelectedItem(meseStrings[meseComboBoxIniziale]);
			
		JLabel lblAnno = new JLabel("Anno");
		lblAnno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnno.setBounds(10, 55, 64, 14);
		frmAgenda.getContentPane().add(lblAnno);
		
		
		ArrayList<String> an = new ArrayList<String>();
		for (int i =2020 ; i < 2049 ; i++ ) {    
				String l = String.valueOf(i);
				an.add(l); 		}
		
		String[] anno = new String[ an.size()];
		anno =  (String[]) an.toArray(anno);
		
		annoComboBox = new JComboBox (anno);
		annoComboBox.setBounds(96, 51, 74, 22);
		frmAgenda.getContentPane().add(annoComboBox);
	
		JButton btnVisualizza = new JButton("Aggiorna Agenda");
		btnVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int l = dtmTableModel.getRowCount() - 1;
				for ( int i = 0 ; i <= l ; i ++) {
				dtmTableModel.removeRow(0);}
				for ( int i = 0 ; i <= l ; i ++) {
				dtmTableModel.insertRow(i, new Object[][] {}); }
								
				
				mouseClickMese();
				dtmTableModel.getTableModelListeners();
			}
		});
		btnVisualizza.setBounds(20, 83, 150, 23);
		frmAgenda.getContentPane().add(btnVisualizza);
		
		JButton btnNewButton = new JButton("Inserisci Appuntamento\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
//				
//				Appuntamenti inserAppuntamenti = new Appuntamenti();
//				inserAppuntamenti.dataStringMouse = dataStringMouse;
//				inserAppuntamenti.initialize();
//				if (inserAppuntamenti.erroreAppuntamenti == true) {
//					MessaggioConferma errore = new MessaggioConferma();
//					errore.lblNewLabel.setText("SELEZIONARE GIORNO");
//				}
//				QueryAppuntamenti verificaAppuntamenti = new QueryAppuntamenti();
//				tableAppuntamentiDefaultTableModel = new DefaultTableModel();
//				tableAppuntamentiDefaultTableModel = (DefaultTableModel) appuntamentiTable.getModel();
//				try {
//					resultSet = verificaAppuntamenti.selezioneAppuntamenti(dataStringMouse);
//
//					if (tableAppuntamentiDefaultTableModel.getColumnCount() != 0) {
//						while (tableAppuntamentiDefaultTableModel.getRowCount() !=0) {
//							tableAppuntamentiDefaultTableModel.removeRow(0);
//						}; }
//				} catch (SQLException e1) {			e1.printStackTrace();			}
//				try {
//					while (resultSet.next()) {
//						Vector rowData = new Vector ();
//						rowData.add(resultSet.getString(1));
//						rowData.add(resultSet.getString(2));
//						rowData.add(resultSet.getString(3));
//						rowData.add(resultSet.getString(4));
//						rowData.add(resultSet.getString(5));
//						
//						
//						
//						tableAppuntamentiDefaultTableModel.addRow(rowData);	
//						
//					}
//				} catch (SQLException e1) {			e1.printStackTrace();			}
				
			}
		});
		btnNewButton.setBounds(389, 33, 171, 23);
		frmAgenda.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(623, 22, 305, 168);
		frmAgenda.getContentPane().add(scrollPane_1);
		
		appuntamentiTable = new JTable();
		appuntamentiTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// INIZIALIZZAZIONE ID TABELLA APPUTAMENTI PER EVENTUALE CANCELLAZIONE //
				if (tableAppuntamentiDefaultTableModel.getRowCount() != 0) {
					int rowAppuntamenti  =appuntamentiTable.getSelectedRow();
					String id =  (String) appuntamentiTable.getValueAt(rowAppuntamenti, 0);
					idAppuntamenti = Integer.valueOf(id);
				}
				
			}
		});
		appuntamentiTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome ", "Cognome", "Orario", "Data"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		appuntamentiTable.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane_1.setViewportView(appuntamentiTable);
		
		lblNewLabel = new JLabel("SELEZIONA IL GIORNO POI CLICCA IL BOTTONE\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(309, 11, 304, 14);
		frmAgenda.getContentPane().add(lblNewLabel);
		
		JButton eliminaAppuntamentiButton = new JButton("Cancella Appuntamento");
		eliminaAppuntamentiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				// BOTTONE PER LA CANCELLAZIONE DI UN APPUNTAMENTO//				
//				QueryAppuntamenti cancellaAppuntamenti = new QueryAppuntamenti();
//				try {
//					cancellaAppuntamenti.cancella(idAppuntamenti);
//						while (tableAppuntamentiDefaultTableModel.getRowCount() != 0) {
//								tableAppuntamentiDefaultTableModel.removeRow(0);
//								
//						}
//						verificaAppuntamenti();					
//				} catch (SQLException e1) {
//					MessaggioConferma errore = new MessaggioConferma();
//					errore.lblNewLabel.setText("SELEZIONA RIGA");
//					e1.printStackTrace();
//				}
//				
				
			}
		});
		eliminaAppuntamentiButton.setBounds(389, 67, 171, 23);
		frmAgenda.getContentPane().add(eliminaAppuntamentiButton);
		
		JButton btnCercaAppuntamento = new JButton("Cerca Appuntamento\r\n");
		btnCercaAppuntamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				tableAppuntamentiDefaultTableModel = new DefaultTableModel();
//				tableAppuntamentiDefaultTableModel = (DefaultTableModel) appuntamentiTable.getModel();
//				CercaAppuntamento cercaAppuntamento = new CercaAppuntamento();
//				
//				if (tableAppuntamentiDefaultTableModel.getRowCount() != 0) {
//					
//					while (tableAppuntamentiDefaultTableModel.getRowCount() !=0) {
//						tableAppuntamentiDefaultTableModel.removeRow(0);
//					}; }
//				else {
//				try {
//					while (cercaAppuntamento.rsetCercaAppuntamento.next()) {
//						Vector rowData = new Vector ();
//						rowData.add(cercaAppuntamento.rsetCercaAppuntamento.getString(1));
//						rowData.add(cercaAppuntamento.rsetCercaAppuntamento.getString(2));
//						rowData.add(cercaAppuntamento.rsetCercaAppuntamento.getString(3));
//						rowData.add(cercaAppuntamento.rsetCercaAppuntamento.getString(4));
//						rowData.add(cercaAppuntamento.rsetCercaAppuntamento.getString(5));
//						tableAppuntamentiDefaultTableModel.addRow(rowData);	
//						
//					}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}}
			
				
				
			}
		});
		btnCercaAppuntamento.setBounds(389, 101, 171, 23);
		frmAgenda.getContentPane().add(btnCercaAppuntamento);
		frmAgenda.setVisible(true);
	}
	
//		public DefaultTableModel inserimentoGiorniDefaultTableModel () {
			
//			CalcolaGiornoSettimana giornoSettimana = new CalcolaGiornoSettimana();
//			CodiceGiorno traduzioneGiorno = new CodiceGiorno();
//			CodiceMese inserimentoGiorniMese = new CodiceMese();
//			CodiceAnno inserimentoTipoAnno = new CodiceAnno();
//			org.joda.time.LocalDate dataDate2 = new org.joda.time.LocalDate();	
//			java.util.Date data = new java.util.Date();
//			
//			int primogiorno = 1;
//			int mese =dataDate2.getMonthOfYear() - 1;
//			int numeroMassimoMese = 0 ;
//			String giornoSettimanaString = giornoSettimana.CalcolaGiornoSettimana(2020, mese, 01);
//			int numeroColonnaPrimoGiorno = traduzioneGiorno.GiornoSettimanaDefaultModel(giornoSettimanaString);
//			boolean bisestile = inserimentoTipoAnno.bisestile(2020);
//			if (bisestile == true )
//				numeroMassimoMese = inserimentoGiorniMese.numeroGiorniMeseBisestile (mese);
//			else
//				numeroMassimoMese = inserimentoGiorniMese.numeroGiorniMese (mese);
//			int numeroRigaPrimoGiorno = 0;
//			
//			// inserisco un array dove indico i giorni della settimana in base alla colonna dell'agenda.
//			//Esempio Luned 0 , Marted 1 , Mercoled 2 etc etc
//		
//			dtmTableModel.setValueAt(primogiorno, numeroRigaPrimoGiorno, numeroColonnaPrimoGiorno);
//			
//				while (numeroColonnaPrimoGiorno <= dtmTableModel.getColumnCount()-1 && numeroRigaPrimoGiorno < dtmTableModel.getRowCount()) {
//					primogiorno = primogiorno +1;
//						if (numeroColonnaPrimoGiorno == dtmTableModel.getColumnCount()-1) {
//								numeroColonnaPrimoGiorno =0;
//								numeroRigaPrimoGiorno = numeroRigaPrimoGiorno + 1; }
//						else {numeroColonnaPrimoGiorno = numeroColonnaPrimoGiorno + 1; }
//								if ( numeroRigaPrimoGiorno < 6)
//									if ( primogiorno <=  numeroMassimoMese)
//										dtmTableModel.setValueAt(primogiorno, numeroRigaPrimoGiorno, numeroColonnaPrimoGiorno);
//											
//										
//				}
//			
//			
//			
//			return dtmTableModel;
//		}
		
			public void mouseClickMese () {
			
////			CalcolaGiornoSettimana giornoSettimana = new CalcolaGiornoSettimana();
////			CodiceGiorno traduzioneGiorno = new CodiceGiorno();
////			CodiceMese inserimentoGiorniMese = new CodiceMese();
////			CodiceAnno inserimentoTipoAnno = new CodiceAnno();
//			
//			java.util.Date data = new java.util.Date();
//			
//			int primogiorno = 1;
//			int meseComboBoxInt = meseComboBox.getSelectedIndex();
//			int mese = meseComboBoxInt;
//			String annoComboxInt = (String) annoComboBox.getSelectedItem();
//			int anno = Integer.valueOf(annoComboxInt);
//			
//			int numeroMassimoMese = 0 ;
//			String giornoSettimanaString = giornoSettimana.CalcolaGiornoSettimana(anno, meseComboBoxInt, 01);
//			int numeroColonnaPrimoGiorno = traduzioneGiorno.GiornoSettimanaDefaultModel(giornoSettimanaString);
//			boolean bisestile = inserimentoTipoAnno.bisestile(2020);
//			if (bisestile == true )
//				numeroMassimoMese = inserimentoGiorniMese.numeroGiorniMeseBisestile (mese);
//			else
//				numeroMassimoMese = inserimentoGiorniMese.numeroGiorniMese (mese);
//			int numeroRigaPrimoGiorno = 0;
//			
//			// inserisco un array dove indico i giorni della settimana in base alla colonna dell'agenda.
//			//Esempio Lunedi e 0 , Martedi e 1 , Mercoledi e 2 etc etc
//		
//			dtmTableModel.setValueAt(primogiorno, numeroRigaPrimoGiorno, numeroColonnaPrimoGiorno);
//			
//				while (numeroColonnaPrimoGiorno <= dtmTableModel.getColumnCount()-1 && numeroRigaPrimoGiorno < dtmTableModel.getRowCount()) {
//					primogiorno = primogiorno +1;
//						if (numeroColonnaPrimoGiorno == dtmTableModel.getColumnCount()-1) {
//								numeroColonnaPrimoGiorno =0;
//								numeroRigaPrimoGiorno = numeroRigaPrimoGiorno + 1; }
//						else {numeroColonnaPrimoGiorno = numeroColonnaPrimoGiorno + 1; }
//								if ( numeroRigaPrimoGiorno < 6)
//									if ( primogiorno <=  numeroMassimoMese)
//										dtmTableModel.setValueAt(primogiorno, numeroRigaPrimoGiorno, numeroColonnaPrimoGiorno);
//				}		
		}
			
			private void verificaAppuntamenti () {
//				QueryAppuntamenti verificaAppuntamenti = new QueryAppuntamenti();
//				tableAppuntamentiDefaultTableModel = new DefaultTableModel();
//				tableAppuntamentiDefaultTableModel = (DefaultTableModel) appuntamentiTable.getModel();
//				try {
//					resultSet = verificaAppuntamenti.selezioneAppuntamenti(dataStringMouse);
//				} catch (SQLException e1) {			e1.printStackTrace();			}
//				try {
//					while (resultSet.next()) {
//						Vector rowData = new Vector ();
//						rowData.add(resultSet.getString(1));
//						rowData.add(resultSet.getString(2));
//						rowData.add(resultSet.getString(3));
//						rowData.add(resultSet.getString(4));
//						rowData.add(resultSet.getString(5));
//						
//						
//						
//						tableAppuntamentiDefaultTableModel.addRow(rowData);	
//						
//					}
//				} catch (SQLException e1) {			e1.printStackTrace();			}
//				
//				
			}
}
*/