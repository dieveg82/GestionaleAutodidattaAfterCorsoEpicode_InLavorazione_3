package gestionale.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
public class QueryAppuntamenti {
	
	public boolean errore = false;
	
	 public QueryAppuntamenti() {	} 
		
	
	public  void inserimentoAppuntamenti (String cognome , String nome , String orario , String giorno) throws SQLException, IOException {
		if (giorno =="") { errore = true;	}
		else {
		String sql = ("INSERT  INTO appuntamenti (`Cognome`,`Nome`, `Orario`,`Giorno`) VALUES ('"+cognome+"' , '"+nome+"','"+orario+"','"+giorno+"' )");
			PreparedStatement ps =  (PreparedStatement) con.prepareStatement(sql);

		ps.executeUpdate();
		errore = false;
		}
	}
	
	public ResultSet selezioneAppuntamenti (String dataAppuntamenti) throws SQLException {
		
		String sql = "SELECT * FROM appuntamenti WHERE `Giorno` = ('"+dataAppuntamenti+"') ";
	
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		return rs ;	
}
	public ResultSet selezioneAppuntamenti (int id) throws SQLException {
		
		String sql = "SELECT * FROM appuntamenti WHERE `Giorno` = ('"+id+"') ";
	
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		return rs ;	
}
	
	public void cancella (int idAppuntamento ) throws SQLException{
		
		String sql = " DELETE FROM appuntamenti WHERE (`Id` = '"+idAppuntamento+"')" ;
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

		ps.executeUpdate();		
	}
	
	public ResultSet cercaAppuntamento (String selezione ,String cognomeNome) throws SQLException {
		
		String sql = "SELECT * FROM appuntamenti WHERE `"+selezione+"` = ('"+cognomeNome+"') ";
		
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		return rs ;	
}
}
*/