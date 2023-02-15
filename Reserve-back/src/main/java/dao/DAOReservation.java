package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.Activite;
import model.Client;
import model.Ranger;
import model.Reservation;

public class DAOReservation implements IDAO<Reservation,Integer>{

	@Override
	public Reservation findById(Integer id) {
		DAOCompte daoC = new DAOCompte();
		DAOActivite daoA = new DAOActivite();
		
		Reservation r =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where id=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) daoC.findById(rs.getInt("client"));
				Activite activite = daoA.findById(rs.getInt("activite"));
				Ranger ranger = null;
				if(rs.getObject("ranger") != null) {
					ranger= (Ranger) daoC.findById(rs.getInt("ranger"));
				}
				r = new Reservation(rs.getInt("id"),rs.getInt("effectif"),rs.getDouble("prix"),LocalDate.parse(rs.getString("jour")),LocalTime.parse(rs.getString("heure")),client, activite);
				r.setRanger(ranger);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	@Override
	public List<Reservation> findAll() {
		DAOCompte daoC = new DAOCompte();
		DAOActivite daoA = new DAOActivite();
		List<Reservation> reservations = new ArrayList();
		Reservation r =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation");

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) daoC.findById(rs.getInt("client"));
				Activite activite = daoA.findById(rs.getInt("activite"));
				Ranger ranger = null;
				if(rs.getObject("ranger") != null) {
					ranger= (Ranger) daoC.findById(rs.getInt("ranger"));
				}
				r = new Reservation(rs.getInt("id"),rs.getInt("effectif"),rs.getDouble("prix"),LocalDate.parse(rs.getString("jour")),LocalTime.parse(rs.getString("heure")),client, activite);
				r.setRanger(ranger);
				reservations.add(r);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reservations;
	}

	@Override
	public void insert(Reservation r) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement
					(
							"INSERT INTO reservation (effectif,prix,jour,heure,client,activite,ranger) VALUES(?,?,?,?,?,?,?)");
			ps.setInt(1, r.getEffectif());
			ps.setDouble(2, r.getPrix());
			ps.setString(3, r.getJour().toString());
			ps.setString(4, r.getHeure().toString());
			ps.setInt(5, r.getClient().getId());
			ps.setInt(6, r.getActivite().getId());
			if(r.getRanger() != null) {
				ps.setInt(7, r.getRanger().getId());
			}else {
				ps.setObject(7, null);
			}


			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Reservation r) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE reservation set effectif=?,prix=?,jour=?,heure=?,client=?, activite=?, ranger=? where id=?");

			ps.setInt(1, r.getEffectif());
			ps.setDouble(2, r.getPrix());
			ps.setString(3, r.getJour().toString());
			ps.setString(4, r.getHeure().toString());
			ps.setInt(5, r.getClient().getId());
			ps.setInt(6, r.getActivite().getId());
			if(r.getRanger() != null) {
				ps.setInt(7, r.getRanger().getId());
			}else {
				ps.setObject(7, null);

			}
			ps.setInt(8, r.getId());

			ps.executeUpdate();
			ps.close();
			conn.close();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE from reservation where id=?");
			ps.setInt(1, id);

			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public List<Reservation> findAllByClient(Integer idClient) 
	{
		DAOCompte daoC = new DAOCompte();
		DAOActivite daoA = new DAOActivite();
		List<Reservation> reservations = new ArrayList();
		Reservation r =null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);


			PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where client = ?");
			ps.setInt(1, idClient);

			ResultSet rs =  ps.executeQuery();

			while(rs.next()) 
			{
				Client client = (Client) daoC.findById(rs.getInt("client"));
				Activite activite = daoA.findById(rs.getInt("activite"));
				Ranger ranger = null;
				if(rs.getObject("ranger") != null) {
					ranger= (Ranger) daoC.findById(rs.getInt("ranger"));
				}
				r = new Reservation(rs.getInt("id"),rs.getInt("effectif"),rs.getDouble("prix"),LocalDate.parse(rs.getString("jour")),LocalTime.parse(rs.getString("heure")),client, activite);
				r.setRanger(ranger);
				reservations.add(r);
			}

			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return reservations;
	}


	public List<Reservation> findAllByRanger(Integer idRanger) 
	{
		DAOCompte daoC = new DAOCompte();
		DAOActivite daoA = new DAOActivite();
        List<Reservation> reservationsR = new ArrayList();
        Reservation r =null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,loginBdd,passwordBdd);

            PreparedStatement ps = conn.prepareStatement("SELECT * from reservation where ranger=?");
            ps.setInt(1, idRanger);
            
            ResultSet rs =  ps.executeQuery();

            while(rs.next()) 
            {
                Client client = (Client) daoC.findById(rs.getInt("client"));
                Activite activite = daoA.findById(rs.getInt("activite"));
                Ranger ranger = null;
                if(rs.getObject("ranger") != null) {
                    ranger= (Ranger) daoC.findById(rs.getInt("ranger"));
                }
                r = new Reservation(rs.getInt("id"),rs.getInt("effectif"),rs.getDouble("prix"),LocalDate.parse(rs.getString("jour")),LocalTime.parse(rs.getString("heure")),client, activite);
                r.setRanger(ranger);
                reservationsR.add(r);
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservationsR;
	}

}
