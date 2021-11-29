package gestionale.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.stereotype.Component;

import gestionale.model.Cliente;
import gestionale.service.ClienteService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class InserimentoClienti {

	private JDialog frmInserimentoClienti;
	private JTextField textFieldCognome;
	private JTextField textFieldNome;
	private JTextField textFieldCodiceFiscale;
	private JTextField textFieldVia;
	private JTextField textFieldCivico;
	private JTextField textFieldCodicePostale;
	private JTextField textFieldCitta;
	private JTextField textFieldProvincia;
	private Cliente cliente = new Cliente();
	private boolean modifica = false;
	private Integer id;

	@Autowired
	ClienteService clienteService;

	@Autowired
	MessaggioConferma messaggioConferma;

	public void initialize() throws SQLException {
		frmInserimentoClienti = new JDialog();
		frmInserimentoClienti.setTitle("Dott.ssa .....\r\n");
		frmInserimentoClienti.setBounds(400, 200, 450, 433);
		frmInserimentoClienti.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmInserimentoClienti.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cognome\r\n");
		lblNewLabel.setBounds(35, 41, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(35, 76, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Cod Fiscale");
		lblNewLabel_2_1.setBounds(35, 111, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Via/Viale/Corso");
		lblNewLabel_2_1_1.setBounds(35, 146, 107, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Numero Civico");
		lblNewLabel_2_1_1_1.setBounds(35, 181, 107, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Codice Postale");
		lblNewLabel_2_1_1_1_1.setBounds(35, 216, 107, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Citta");
		lblNewLabel_2_1_1_1_1_1.setBounds(35, 251, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Provincia");
		lblNewLabel_2_1_1_1_1_1_1.setBounds(35, 286, 81, 24);
		frmInserimentoClienti.getContentPane().add(lblNewLabel_2_1_1_1_1_1_1);

		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(143, 43, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldCognome);
		textFieldCognome.setColumns(10);

		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(143, 78, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldNome);

		textFieldCodiceFiscale = new JTextField();
		textFieldCodiceFiscale.setColumns(10);
		textFieldCodiceFiscale.setBounds(143, 113, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldCodiceFiscale);

		textFieldVia = new JTextField();
		textFieldVia.setColumns(10);
		textFieldVia.setBounds(143, 148, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldVia);

		textFieldCivico = new JTextField();
		textFieldCivico.setColumns(10);
		textFieldCivico.setBounds(143, 183, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldCivico);

		textFieldCodicePostale = new JTextField();
		textFieldCodicePostale.setColumns(10);
		textFieldCodicePostale.setBounds(143, 218, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldCodicePostale);

		textFieldCitta = new JTextField();
		textFieldCitta.setColumns(10);
		textFieldCitta.setBounds(143, 253, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldCitta);

		textFieldProvincia = new JTextField();
		textFieldProvincia.setColumns(10);
		textFieldProvincia.setBounds(143, 288, 193, 20);
		frmInserimentoClienti.getContentPane().add(textFieldProvincia);

		if (modifica == true) {
			cliente = clienteService.getById(id);
			textFieldCognome.setText(cliente.getCognome());
			textFieldNome.setText(cliente.getNome());
			textFieldCodiceFiscale.setText(cliente.getCodiceFiscale());
			textFieldVia.setText(cliente.getVia());
			textFieldCivico.setText(cliente.getNumeroCivico());
			textFieldCodicePostale.setText(cliente.getCodicePostale());
			textFieldCitta.setText(cliente.getCitta());
			textFieldProvincia.setText(cliente.getCapoluogo());
			textFieldCognome.getText();

		}
		JButton btnSa = new JButton("Salva");
		btnSa.setBounds(164, 339, 89, 23);
		frmInserimentoClienti.getContentPane().add(btnSa);
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente.setCognome(textFieldCognome.getText().toUpperCase());
				cliente.setNome(textFieldNome.getText().toUpperCase());
				cliente.setCodiceFiscale(textFieldCodiceFiscale.getText().toUpperCase());
				cliente.setVia(textFieldVia.getText().toUpperCase());
				cliente.setNumeroCivico(textFieldCivico.getText().toUpperCase());
				cliente.setCodicePostale(textFieldCodicePostale.getText().toUpperCase());
				cliente.setCitta(textFieldCitta.getText().toUpperCase());
				cliente.setCapoluogo(textFieldProvincia.getText().toUpperCase());

				if (modifica == true) {
					clienteService.insertCliente(cliente);
					messaggioConferma.setLblNewLabel(new JLabel("Inserimento effettuato con successo"));
					messaggioConferma.initialize();
					frmInserimentoClienti.dispose();
					modifica = false;
				} else {
					List<Cliente> listCliente = clienteService.findAll();
					boolean errore = false;
					for (Cliente c : listCliente) {
						if (c.getCodiceFiscale().equals(cliente.getCodiceFiscale())) {
							errore = true;
						}
					}
					if (errore == true) {
						messaggioConferma.setLblNewLabel(new JLabel("Cliente già presente in anagrafica"));
						messaggioConferma.initialize();
						frmInserimentoClienti.dispose();
						errore = false;
					} else {
						cliente.setId(null);
						clienteService.insertCliente(cliente);
						messaggioConferma.setLblNewLabel(new JLabel("Inserimento effettuato con successo"));
						messaggioConferma.initialize();
						frmInserimentoClienti.dispose();
					}
				}
			}
		});
		frmInserimentoClienti.setModal(true);
		frmInserimentoClienti.setVisible(true);
	}
}
