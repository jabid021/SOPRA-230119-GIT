package dao;

import java.util.List;

public interface IDAO<T,K> {

	String url = "jdbc:mysql://localhost:3306/reserve?characterEncoding=UTF-8";
	String loginBdd = "root";
	String passwordBdd = "";
	
	public T findById(K id);
	public List<T> findAll();
	public T save(T o);
	public void delete(K id);
	
}
