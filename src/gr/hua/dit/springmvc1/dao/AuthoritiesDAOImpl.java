package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.Authorities;
import gr.hua.dit.springmvc1.entity.Student;


@Repository
public class AuthoritiesDAOImpl implements AuthoritiesDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Authorities> getAuthorities() {
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Authorities> query = currentSession.createQuery("from Authorities order by id", Authorities.class);

		// execute the query and get the results list
		List<Authorities> authorities = query.getResultList();

		// return the results
		return authorities;
	}

	@Override
	@Transactional
	public void saveAuthorities(Authorities authorities) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(authorities);
	}

	@Override
	public Authorities getAuthority(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuthority(int id) {
		// TODO Auto-generated method stub

	}

}
