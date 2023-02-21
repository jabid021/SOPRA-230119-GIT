package dao;

import java.util.List;

import model.Client;
import model.Compte;
import model.Ranger;

public interface IDAOCompte extends IDAO<Compte,Integer> {

	
	public List<Ranger> findAllRanger();
	public List<Client> findAllClient();
	public Compte findByLoginAndPassword(String login,String password);
}
