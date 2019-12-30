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
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Authorities authorities = currentSession.get(Authorities.class, id);
		return authorities;
	}

	@Override
	@Transactional
	public void deleteAuthority(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Customer
		Authorities authorities = currentSession.get(Authorities.class, id);

		// delete Customer
		currentSession.delete(authorities);
	}

}
