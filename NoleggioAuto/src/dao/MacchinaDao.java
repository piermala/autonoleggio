package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataSource.DataSource;
import model.Macchina;

public class MacchinaDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private static final String NOME_TABELLA = "MACCHINA";
	
	/// AGGIUNGI
	public Macchina aggiungiMacchina(String modello, String targa){
		
		Macchina m = null;
		String sql = "INSERT INTO " + NOME_TABELLA + "(MODELLO,TARGA) VALUES(?,?)"; 
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, modello);
			pst.setString(2, targa);	
			
			m = new Macchina(modello, targa);
			int rs = pst.executeUpdate();			
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return m;		
	}
	
	
	/// TROVA MACCHINA
	public Macchina trovaMacchina(String modello, String targa){
		
		Macchina m = null;
		String sql = "SELECT * FROM " + NOME_TABELLA + " WHERE MODELLO=? AND TARGA=?";
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, modello);
			pst.setString(2, targa);				
			
			rs = pst.executeQuery();			
			
			while(rs.next()){				
				m = new Macchina(modello, targa);
				System.out.println(m);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return m;			
	}
	
	
	/// MODIFICA MACCHINA
	public Macchina modificaMacchina(String modelloNuovo, String targaNuova, String modelloVecchio, String targaVecchia){
		
		Macchina m = null;
		String sql = "UPDATE " + NOME_TABELLA + " SET MODELLO=?,TARGA=? WHERE MODELLO=? AND TARGA=?"; 
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, modelloNuovo);
			pst.setString(2, targaNuova);
			pst.setString(3, modelloVecchio);
			pst.setString(4, targaVecchia);
			
			m = new Macchina(modelloNuovo, targaNuova);
			int rs = pst.executeUpdate();			
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(m);
		return m;		
	}
	
	
	/// ELIMINA PERSONA
	public boolean eliminaMacchina(String modello, String targa){
		
		boolean eliminata = false;
		String sql = "DELETE FROM " + NOME_TABELLA + " WHERE MODELLO=? AND TARGA=?";
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, modello);
			pst.setString(2, targa);			
				
			int rs = pst.executeUpdate();	
				
			if (rs == 0){
				System.out.println("RS " + rs);
				eliminata = false;
			} else {
				System.out.println("RS " + rs);
				eliminata = true;
			}			
				
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
			
		System.out.println("ELIMINATA?  : " + eliminata);
		return eliminata;		
	}
	
	
	
	/// CHIUDI
	public void close() {
		if (pst!=null || con != null){
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
