package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Compte;
import model.Medecin;
import model.Secretaire;

public class DAOCompte implements IDAO<Compte,Integer> {

	@Override
	public Compte findById(Integer id) {
		Compte c = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					c = new Medecin(id,rs.getString("login"),rs.getString("password"));
				}
				else if(rs.getString("type_compte").equals("Secretaire")) 
				{
					c = new Secretaire(id,rs.getString("login"),rs.getString("password"));
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList();
		Compte c = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where ");
			

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					c = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else if(rs.getString("type_compte").equals("Secretaire")) 
				{
					c = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				comptes.add(c);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public void insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,type_compte) VALUES(?,?,?)");
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			if(c instanceof Medecin) 
			{
				ps.setString(3, "Medecin");
			}
			else 
			{
				ps.setString(3, "Secretaire");
			}
			
			ps.executeUpdate();


			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE compte set login=?,password=?,type_compte=? where id=?");
			ps.setString(1, c.getLogin());
			ps.setString(2, c.getPassword());
			if(c instanceof Medecin) 
			{
				ps.setString(3, "Medecin");
			}
			else 
			{
				ps.setString(3, "Secretaire");
			}
			ps.setInt(4, c.getId());
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
			PreparedStatement ps = conn.prepareStatement("DELETE from compte where id=?");
			ps.setInt(1, id);
			
			
			ps.executeUpdate();


			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Compte findByLoginAndPassword(String login,String password) 
	{
		Compte c = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) 
				{
					c = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else if(rs.getString("type_compte").equals("Secretaire")) 
				{
					c = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
