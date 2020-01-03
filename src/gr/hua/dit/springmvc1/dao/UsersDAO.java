package gr.hua.dit.springmvc1.dao;

import gr.hua.dit.springmvc1.entity.Users;

public interface UsersDAO {

	
	public void saveUsers(Users users);
	
	public Users getUsers(int id);

	public void deleteUsers(int id);
}
