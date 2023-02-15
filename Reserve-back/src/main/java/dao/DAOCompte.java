package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Adresse;
import model.Client;
import model.Compte;
import model.Ranger;

public class DAOCompte implements IDAO<Compte,Integer> {

	@Override
	public Compte findById(Integer id) {
		Compte c =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));	
				}
				else if(rs.getString("type_compte").equals("client"))
				{
					Adresse a = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"), rs.getString("cp"), rs.getString("pays"));
					c = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),a);	
				}
				else if(rs.getString("type_compte").equals("ranger"))
				{
					c = new Ranger(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("anciennete"));
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
		Compte c =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");
			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));	
				}
				else if(rs.getString("type_compte").equals("client"))
				{
					Adresse a = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"), rs.getString("cp"), rs.getString("pays"));
					c = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),a);	
				}
				else if(rs.getString("type_compte").equals("ranger"))
				{
					c = new Ranger(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("anciennete"));
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

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,anciennete,numero, voie, ville, cp, pays,type_compte) VALUES(?,?,?,?,?,?,?,?,?,?,?)");

			if(c instanceof Admin) 
			{		

				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setObject(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "admin");
			}

			else if(c instanceof Client) 
			{

				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setObject(5, null);
				ps.setString(6, ((Client) c).getAdresse().getNumero());
				ps.setString(7, ((Client) c).getAdresse().getVoie());
				ps.setString(8, ((Client) c).getAdresse().getVille());
				ps.setString(9, ((Client) c).getAdresse().getCp());
				ps.setString(10, ((Client) c).getAdresse().getPays());
				ps.setString(11, "client");
			}	
			else if(c instanceof Ranger) 
			{

				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setInt(5, ((Ranger) c).getAnciennete());
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "ranger");
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

			PreparedStatement ps = conn.prepareStatement(
					"UPDATE compte set login=?,password=?,nom=?,prenom=?,anciennete=?,numero=?, voie=?, ville=?, cp=?, pays=?,type_compte=? where id=?");

			if(c instanceof Admin) 
			{		

				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setObject(5, null);
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "admin");
				ps.setInt(12, c.getId());
			}

			else if(c instanceof Client) 
			{

				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setObject(5, null);
				ps.setString(6, ((Client) c).getAdresse().getNumero());
				ps.setString(7, ((Client) c).getAdresse().getVoie());
				ps.setString(8, ((Client) c).getAdresse().getVille());
				ps.setString(9, ((Client) c).getAdresse().getCp());
				ps.setString(10, ((Client) c).getAdresse().getPays());
				ps.setString(11, "client");
				ps.setInt(12, c.getId());
			}	
			else if(c instanceof Ranger) 
			{

				ps.setString(1, c.getLogin());
				ps.setString(2, c.getPassword());
				ps.setString(3, c.getNom());
				ps.setString(4, c.getPrenom());
				ps.setInt(5, ((Ranger) c).getAnciennete());
				ps.setString(6, null);
				ps.setString(7, null);
				ps.setString(8, null);
				ps.setString(9, null);
				ps.setString(10, null);
				ps.setString(11, "ranger");
				ps.setInt(12, c.getId());
			}	



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


	
	public List<Ranger> findAllRanger() 
	{
		List<Ranger> comptes = new ArrayList();
		Ranger r =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where type_compte=?");
			ps.setString(1, "ranger");
			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				r = new Ranger(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("anciennete"));

				comptes.add(r);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return comptes;


	}
	
	public List<Client> findAllClient() 
	{
		List<Client> comptes = new ArrayList();
		Client c =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where type_compte='client'");
			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				Adresse a = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"), rs.getString("cp"), rs.getString("pays"));
				c = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),a);	

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

	

	public Compte findByLoginAndPassword(String login,String password)
	{
		Compte c =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1,login);
			ps.setString(2,password);


			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				if(rs.getString("type_compte").equals("admin")) 
				{
					c = new Admin(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"));	
				}
				else if(rs.getString("type_compte").equals("client"))
				{
					Adresse a = new Adresse(rs.getString("numero"), rs.getString("voie"), rs.getString("ville"), rs.getString("cp"), rs.getString("pays"));
					c = new Client(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),a);	
				}
				else if(rs.getString("type_compte").equals("ranger"))
				{
					c = new Ranger(rs.getInt("id"),rs.getString("login"),rs.getString("password"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("anciennete"));
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
