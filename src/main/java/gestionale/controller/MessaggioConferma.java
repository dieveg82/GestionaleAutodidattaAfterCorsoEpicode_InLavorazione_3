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
import javax.swing.SwingConstants;

@Setter
@Getter
@SpringBootApplication
public class MessaggioConferma {

	private JDialog frmMessaggioConferma = new JDialog ();
	private JLabel lblNewLabel = new JLabel("Operazione avvenuta con successo !!");

	public MessaggioConferma() {
	}


	public void initialize() {
		frmMessaggioConferma.setTitle("Gestionale .....");
		frmMessaggioConferma.setBounds(500, 300, 365, 169);
		frmMessaggioConferma.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frmMessaggioConferma.getContentPane().setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 329, 43);
		frmMessaggioConferma.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMessaggioConferma.dispose();
			}
		});
		btnNewButton.setBounds(127, 82, 89, 23);
		frmMessaggioConferma.getContentPane().add(btnNewButton);
		frmMessaggioConferma.setModal (true);
		frmMessaggioConferma.setVisible (true);
	}

}
