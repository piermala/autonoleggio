package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataSource.DataSource;
import model.Persona;

public class PersonaDao {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private static final String NOME_TABELLA = "PERSONA";
	
	
	
	/// AGGIUNGI PERSONA
	public Persona aggiungiPersona(String nome, String cognome, String codiceFiscale){
		
		Persona p = null;
		String sql = "INSERT INTO " + NOME_TABELLA + " (NOME,COGNOME,CODICEFISCALE) VALUES(?,?,?)";
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, codiceFiscale);
			
			p = new Persona(nome, cognome, codiceFiscale);
			int rs = pst.executeUpdate();
			System.out.println(rs);
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return p;			
	}
	
	
	
	/// TROVA PERSONA
	public Persona trovaPersona(String nome,String cognome){
		
		Persona p = null;
		String sql = "SELECT * FROM " + NOME_TABELLA + " WHERE NOME=? AND COGNOME=?";
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			rs = pst.executeQuery();
			
			while (rs.next()){
				String n = rs.getString(1);
				String c = rs.getString(3);
				p = new Persona(nome, cognome, rs.getString("CODICEFISCALE"));
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		System.out.println(p);
		return p;		
	}
	
	
	
	/// MODIFICA PERSONA
	public Persona modificaPersona(String nomeVecchio, String cognomeVecchio, String nomeNuovo, String cognomeNuovo){
		
		Persona p = null;
		String sql = "UPDATE " + NOME_TABELLA + " SET NOME=?,COGNOME=? WHERE NOME=? AND COGNOME=?";
		
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nomeNuovo);
			pst.setString(2, cognomeNuovo);
			pst.setString(3, nomeVecchio);
			pst.setString(4, cognomeVecchio);
			
			p = new Persona(nomeNuovo, cognomeNuovo);
			int rs = pst.executeUpdate();			
			 
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}		
		
		System.out.println("\n\n*** " + p);
		return p;		
	}
	
	
	
	/// ELIMINA PERSONA
	public boolean eliminaPersona(String nome, String cognome){
		
		boolean eliminato = false;
		String sql = "DELETE FROM " + NOME_TABELLA + " WHERE NOME=? AND COGNOME=?";
		try {
			con = DataSource.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, cognome);			
			
			int rs = pst.executeUpdate();	
			
			if (rs == 0){
				System.out.println("RS " + rs);
				eliminato = false;
			} else {
				System.out.println("RS " + rs);
				eliminato = true;
			}			
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		System.out.println("ELIMINATO?    : " + eliminato);
		return eliminato;		
	}
	
	
	
	/// CHIUSURA
	public void close(){
		if (pst!=null || con != null | rs != null){
			try {
				pst.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
