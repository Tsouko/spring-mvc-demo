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
	@Transactional
	public void saveStudent(Student student) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				if (student.getId() != 0) {
					// update the customer
					currentSession.update(student);
				} else {
					// save the student
					currentSession.save(student);
				}

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
	@Transactional
	public void deleteStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the Customer
		Student Student = currentSession.get(Student.class, id);

		// delete Customer
		currentSession.delete(Student);

	}

	@Override
	public Student getStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Student student = currentSession.get(Student.class, id);
		return student;
	}

}
