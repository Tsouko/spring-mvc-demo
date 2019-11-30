package gr.hua.dit.springmvc1.Service;

import java.util.List;

import gr.hua.dit.springmvc1.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
