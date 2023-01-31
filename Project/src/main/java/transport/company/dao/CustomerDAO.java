package transport.company.dao;
import transport.company.entity.Company;
import transport.company.entity.Customer;

import java.util.List;

public class CustomerDAO extends TemplateDAO<Customer>{

    public Customer get(long id) {
        return super.get(id, Customer.class);
    }
    public List<Customer> getAll() {
        return super.getAll();
    }
    public  void add(Customer data) {
        super.add(data);
    }
    public void delete(Customer data) {
        super.update(data);
    }
    public void update(Customer data) {
        super.update(data);
    }

}
