package com.soprasteria.dao;

import java.util.List;

import com.soprasteria.model.Client;
import com.soprasteria.model.Compte;
import com.soprasteria.model.Ranger;

public interface IDAOCompte extends IDAO<Compte,Integer> {
	public List<Ranger> findAllRanger();
	public List<Client> findAllClient();
	public Compte findByLoginAndPassword(String login,String password);
}
