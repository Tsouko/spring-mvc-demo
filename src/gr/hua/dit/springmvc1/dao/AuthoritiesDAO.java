package gr.hua.dit.springmvc1.dao;

import java.util.List;

import gr.hua.dit.springmvc1.entity.Authorities;


public interface AuthoritiesDAO {
	public List<Authorities> getAuthorities();

	public void saveAuthorities(Authorities authorities);
	
	public Authorities getAuthority(int id);

	public void deleteAuthority(int id);
}
