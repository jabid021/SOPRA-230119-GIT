package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Activite;
import model.Biome;
import model.Scientifique;
import model.Tourisme;
import model.Vehicule;

public class DAOActivite implements IDAO<Activite,Integer>{

	@Override
	public Activite findById(Integer id) {
		
		DAOBiome daoB = new DAOBiome();
		Activite a =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from activite where id=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				Biome b = daoB.findById(rs.getInt("biome"));
				Vehicule v=null;
				if(rs.getString("vehicule")!=null) 
				{
					v=Vehicule.valueOf(rs.getString("vehicule"));
				}
				if(rs.getString("type_activite").equals("Scientifique")) 
				{
					a = new Scientifique(rs.getInt("id"),rs.getBoolean("guide"),rs.getDouble("prix"),rs.getInt("duree"),b,v);	
				}
				else if(rs.getString("type_activite").equals("Tourisme"))
				{
					a = new Tourisme(rs.getInt("id"),rs.getBoolean("guide"),rs.getDouble("prix"),rs.getInt("duree"),b,v);	
				}		
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public List<Activite> findAll() {
		DAOBiome daoB = new DAOBiome();
		List<Activite> activites = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from activite");

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{

				Biome b = daoB.findById(rs.getInt("biome"));
				Vehicule v=null;
				if(rs.getString("vehicule")!=null) 
				{
					v=Vehicule.valueOf(rs.getString("vehicule"));
				}
				if(rs.getString("type_activite").equals("Scientifique")) 
				{
					Activite a = new Scientifique(rs.getInt("id"),rs.getBoolean("guide"),rs.getDouble("prix"),rs.getInt("duree"),b,v);
					activites.add(a);
				}
				else if(rs.getString("type_activite").equals("Tourisme"))
				{
					Activite a = new Tourisme(rs.getInt("id"),rs.getBoolean("guide"),rs.getDouble("prix"),rs.getInt("duree"),b,v);
					activites.add(a);
				}		
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return activites;
	}

	@Override
	public void insert(Activite a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO activite (guide,prix,duree,vehicule,biome,type_activite) VALUES(?,?,?,?,?,?)");


			if(a instanceof Scientifique) 
			{

				ps.setBoolean(1, a.isGuide());
				ps.setDouble(2, a.getPrix());
				ps.setInt(3, a.getDuree());
				if(a.getVehicule()==null) 
				{
					ps.setObject(4, null);
				}
				else 
				{
					ps.setString(4, a.getVehicule().toString());
				}
				ps.setInt(5, a.getBiome().getId());
				ps.setString(6, "Scientifique");
			}

			else if(a instanceof Tourisme) 
			{
				ps.setBoolean(1, a.isGuide());
				ps.setDouble(2, a.getPrix());
				ps.setInt(3, a.getDuree());
				if(a.getVehicule()==null) 
				{
					ps.setObject(4, null);
				}
				else 
				{
					ps.setString(4, a.getVehicule().toString());
				}
				ps.setInt(5, a.getBiome().getId());
				ps.setString(6, "Tourisme");
			}	



			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Activite a) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE activite set guide=?,prix=?,duree=?,vehicule=?,biome=?,type_activite=? where id=?");


			if(a instanceof Scientifique) 
			{

				ps.setBoolean(1, a.isGuide());
				ps.setDouble(2, a.getPrix());
				ps.setInt(3, a.getDuree());
				if(a.getVehicule()==null) 
				{
					ps.setObject(4, null);
				}
				else 
				{
					ps.setString(4, a.getVehicule().toString());
				}
				ps.setInt(5, a.getBiome().getId());
				ps.setString(6, "Scientifique");
				ps.setInt(7, a.getId());
			}

			else if(a instanceof Tourisme) 
			{
				ps.setBoolean(1, a.isGuide());
				ps.setDouble(2, a.getPrix());
				ps.setInt(3, a.getDuree());
				if(a.getVehicule()==null) 
				{
					ps.setObject(4, null);
				}
				else 
				{
					ps.setString(4, a.getVehicule().toString());
				}
				ps.setInt(5, a.getBiome().getId());
				ps.setString(6, "Tourisme");
				ps.setInt(7, a.getId());
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

			PreparedStatement ps = conn.prepareStatement("DELETE from activite where id=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
