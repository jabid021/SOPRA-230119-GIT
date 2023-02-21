package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import context.Singleton;
import model.Medecin;
import model.Patient;
import model.Visite;

public class DAOVisite implements IDAO<Visite,Integer> {

	@Override
	public Visite findById(Integer id) {
		 DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		 DAOPatient daoPatient= Singleton.getInstance().getDaoPatient();
		 
		Visite v =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where numero=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Patient p = daoPatient.findById(rs.getInt("id_patient"));
				Medecin m= (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				v = new Visite(rs.getInt("numero"),p,m,rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("salle"));

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}


	@Override
	public List<Visite> findAll() {
		DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		DAOPatient daoPatient= Singleton.getInstance().getDaoPatient();
		List<Visite> visites = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Patient p = daoPatient.findById(rs.getInt("id_patient"));
				Medecin m= (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				Visite v = new Visite(rs.getInt("numero"),p,m,rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("salle"));
				visites.add(v);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public void insert(Visite v) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO visite (id_patient,id_medecin,date_visite,prix,salle) VALUES(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, v.getPatient().getId());
			ps.setInt(2, v.getMedecin().getId());
			ps.setString(3, v.getDateVisite().toString());
			ps.setDouble(4, v.getPrix());
			ps.setInt(5, v.getSalle());

			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) 
			{
				Integer id = rs.getInt(1);
				v.setNumero(id);
			}

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Visite v) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE visite set id_patient=?,id_medecin=?,date_visite=?,prix=?,salle=? where numero=?");
			ps.setInt(1, v.getPatient().getId());
			ps.setInt(2, v.getMedecin().getId());
			ps.setString(3, v.getDateVisite().toString());
			ps.setDouble(4, v.getPrix());
			ps.setInt(5, v.getSalle());
			ps.setInt(6, v.getNumero());

			ps.executeUpdate();


			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE from visite where id=?");
			ps.setInt(1, id);
			
			
			ps.executeUpdate();


			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Visite> findAllByPatient(Integer id)
	{
		DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
		DAOPatient daoPatient= Singleton.getInstance().getDaoPatient();
		List<Visite> visites = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id_patient=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Patient p = daoPatient.findById(id);
				Medecin m= (Medecin) daoCompte.findById(rs.getInt("id_medecin"));
				Visite v = new Visite(rs.getInt("numero"),p,m,rs.getDouble("prix"),LocalDate.parse(rs.getString("date_visite")),rs.getInt("salle"));
				visites.add(v);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visites;
	}

}
