package transport.company.dao;
import transport.company.entity.Employee;

import java.util.List;

public class EmployeeDAO extends TemplateDAO<Employee> {

    public Employee get(long id) {
        return super.get(id, Employee.class);
    }

    public List<Employee> getAll() {
        return super.getAll();
    }

    public  void add(Employee data) {
        super.add(data);
    }

    public void delete(Employee data) {
        super.update(data);
    }

    public void update(Employee data) {
        super.update(data);
    }
}
