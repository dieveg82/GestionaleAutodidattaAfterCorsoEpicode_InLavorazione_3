package gestionale.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SpringBootApplication
public class MessaggioConferma {

	private JDialog frmMessaggioConferma;
	private JLabel lblNewLabel = new JLabel("Operazione avvenuta con successo !!");

	public MessaggioConferma() {}


	public void initialize() {
		frmMessaggioConferma = new JDialog();
		frmMessaggioConferma.setTitle("Gestionale .....");
		frmMessaggioConferma.setBounds(500, 300, 248, 169);
		frmMessaggioConferma.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmMessaggioConferma.getContentPane().setLayout(null);
		lblNewLabel.setBounds(37, 28, 187, 43);
		frmMessaggioConferma.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMessaggioConferma.dispose();
			}
		});
		btnNewButton.setBounds(74, 82, 89, 23);
		frmMessaggioConferma.getContentPane().add(btnNewButton);
		frmMessaggioConferma.setModal (true);
		frmMessaggioConferma.setVisible (true);
	}

}
