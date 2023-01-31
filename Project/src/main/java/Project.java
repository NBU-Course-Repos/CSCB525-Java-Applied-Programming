import transport.company.dao.*;
import transport.company.dto.CompanyDTO;
import transport.company.entity.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Project {
    static public void main(String[] args){
        DAO<Employee> employeeDAO = new EmployeeDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        DAO<Customer> customerDAO = new CustomerDAO();
        Company company = new Company("Audi");
        Company company2 = new Company("Ferari");
        Company company3 = new Company("Mercedes");
        companyDAO.add(company);
//        Employee employee1 = new Employee("Ivan", company, 2000.0);
        Customer customer = new Customer();
        customerDAO.update(customer);
        Delivery delivery1 = new Delivery.Builder()
                .destination("Dublin")
                .origin("Sofia")
                .originDate(LocalDate.now())
                .destinationDate(LocalDate.now().plusDays(7))
                .delivery(DeliveryOf.CARGO)
                .weight(10.0)
                .distance(1000.0)
                .customer(customer)
                .build();
        customer.newDelivery(company, delivery1);
        customer.pay(delivery1);
        companyDAO.update(company);
        customerDAO.update(customer);
        List<CompanyDTO> ls = companyDAO.sortByNameAndEarnings();
        for (CompanyDTO c : ls){
            System.out.println(c);
        }
//        DeliveryDAO deliveryDAO = new DeliveryDAO();
//        for (Delivery delivery : company.getDeliveries()){
//            deliveryDAO.update(delivery);
//        }
//        employeeDAO.update(employee1);


    }

}
