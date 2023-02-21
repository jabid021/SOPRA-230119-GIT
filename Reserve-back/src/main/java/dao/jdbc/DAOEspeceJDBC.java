package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import model.Animal;
import model.Biome;
import model.Espece;
import model.Vegetal;

public class DAOEspeceJDBC implements IDAO<Espece,Integer>{

	@Override
	public Espece findById(Integer id) {
		DAOBiomeJDBC daoB = new DAOBiomeJDBC();
		Espece espece = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from espece where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Biome b = daoB.findById(rs.getInt("biome"));

				if (rs.getString("type_espece").equals("Vegetal")) {
					espece = new Vegetal(rs.getInt("id"), rs.getString("nom"), rs.getInt("effectif"),
							rs.getInt("indice_protection"), b);
				} else if (rs.getString("type_espece").equals("Animal")) {

					espece = new Animal(rs.getInt("id"), rs.getString("nom"), rs.getInt("effectif"),
							rs.getInt("indice_protection"), rs.getInt("dangerosite"), b);

				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return espece;
	}

	@Override
	public List<Espece> findAll() {
		DAOBiomeJDBC daoB = new DAOBiomeJDBC();
		List<Espece> especes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from espece");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Biome b = daoB.findById(rs.getInt("biome"));

				if (rs.getString("type_espece").equals("Vegetal")) {
					Vegetal v = new Vegetal(rs.getInt("id"), rs.getString("nom"), rs.getInt("effectif"),
							rs.getInt("indice_protection"), b);
					especes.add(v);
				} else if (rs.getString("type_espece").equals("Animal")) {

					Animal a = new Animal(rs.getInt("id"), rs.getString("nom"), rs.getInt("effectif"),
							rs.getInt("indice_protection"), rs.getInt("dangerosite"), b);
					especes.add(a);
				}
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return especes;
	}

	public void insert(Espece e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, loginBdd, passwordBdd);


			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO espece (nom,effectif,indice_protection,dangerosite,biome,type_espece) VALUES(?,?,?,?,?,?)");

			if (e instanceof Vegetal) {

				ps.setString(1, e.getNom());
				ps.setInt(2, e.getEffectif());
				ps.setInt(3, e.getIndiceProtection());
				ps.setObject(4, null);
				ps.setInt(5, e.getBiome().getId());
				ps.setString(6, "Vegetal");
			}

			else if (e instanceof Animal) {

				ps.setString(1, e.getNom());
				ps.setInt(2, e.getEffectif());
				ps.setInt(3, e.getIndiceProtection());
				ps.setInt(4, ((Animal) e).getDangerosite());
				ps.setInt(5, e.getBiome().getId());
				ps.setString(6, "Animal");
			}

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void update(Espece e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, loginBdd, passwordBdd);


			PreparedStatement ps = conn.prepareStatement(
					"UPDATE espece set nom=?,effectif=?,indice_protection=?,dangerosite=?,biome=?,type_espece=? where id=?");

			if (e instanceof Vegetal) {

				ps.setString(1, e.getNom());
				ps.setInt(2, e.getEffectif());
				ps.setInt(3, e.getIndiceProtection());
				ps.setObject(4, null);
				ps.setInt(5, e.getBiome().getId());
				ps.setString(6, "Vegetal");
				ps.setInt(7, e.getId());
			}

			else if (e instanceof Animal) {

				ps.setString(1, e.getNom());
				ps.setInt(2, e.getEffectif());
				ps.setInt(3, e.getIndiceProtection());
				ps.setInt(4, ((Animal) e).getDangerosite());
				ps.setInt(5, e.getBiome().getId());
				ps.setString(6, "Animal");
				ps.setInt(7, e.getId());
			}

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, loginBdd, passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from espece where id=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Espece save(Espece o) {
		// TODO Auto-generated method stub
		return null;
	}

}
