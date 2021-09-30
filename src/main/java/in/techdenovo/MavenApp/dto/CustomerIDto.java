package in.techdenovo.MavenApp.dto;

import in.techdenovo.MavenApp.model.Customer;

import java.util.List;

public interface CustomerIDto {
    public List<Customer> getCustomers();
    public Customer getCustomer( long id);
    public int insertCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(long id);
}
