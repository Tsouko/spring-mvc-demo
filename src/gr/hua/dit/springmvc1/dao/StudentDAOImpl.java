package gr.hua.dit.springmvc1.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.springmvc1.entity.Customer;
import gr.hua.dit.springmvc1.entity.Student;


@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Student> query = currentSession.createQuery("from Student order by lastName", Student.class);

		// execute the query and get the results list
		List<Student> students = query.getResultList();

		// return the results
		return students;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//testing
	@Override
	public void getCurrentAutoIncrementStudent() {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Student> query = currentSession.createQuery("LAST_INSERT_ID()", Student.class);
		
		//auto to query logika epistrefei thn timh tou teleutaioy id poy mphke. opote 8a mporw an exw parei prin, apo ton xrhsth, ton epi8ymhto rolo pou 8a exei 
		//na paw kai na balw to id,efoson o teleutaios xrhsths einai autos pou molis mphke, kai ton rolo ston pinaka authorities 
	}

}
