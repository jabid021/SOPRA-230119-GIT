package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import model.Biome;
import model.Zone;

public class DAOBiomeJDBC implements IDAO<Biome,Integer>{

	@Override
	public Biome findById(Integer id) {
		Biome b =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from biome where id=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Zone z = Zone.valueOf(rs.getString("zone"));
				b = new Biome (rs.getInt("id"), rs.getString("nom"),rs.getInt("superficie"),z);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Biome> findAll() {
		List<Biome> biome = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from biome");

			ResultSet rs =  ps.executeQuery();


			while(rs.next()) 
			{
				//rs.get() toujours dans le while
				Zone z= Zone.valueOf(rs.getString("zone"));
				//Id dans le le biome
				Biome b = new Biome (rs.getInt("id"), rs.getString("nom"),rs.getInt("superficie"),z);
				biome.add(b);

			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return biome;
	}

	
	public void insert(Biome b) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO biome (nom, superficie, zone) VALUES(?,?,?)");

			ps.setString(1,b.getNom());
			ps.setInt(2, b.getSuperficie());
			ps.setString(3,b.getZone().toString());

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
	public void update(Biome b) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE biome set nom=?,superficie=?,zone=? where id=?");
			ps.setString(1,b.getNom());
			ps.setInt(2,b.getSuperficie());
			ps.setString(3, b.getZone().toString());
			ps.setInt(4,b.getId());

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

			PreparedStatement ps = conn.prepareStatement("DELETE from biome where id=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Biome save(Biome o) {
		// TODO Auto-generated method stub
		return null;
	}

}
