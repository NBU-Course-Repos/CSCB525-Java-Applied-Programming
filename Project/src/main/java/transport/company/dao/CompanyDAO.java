package transport.company.dao;
import config.SessionFactoryUtil;
import org.hibernate.Session;
import transport.company.dto.CompanyDTO;
import transport.company.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyDAO extends TemplateDAO<Company> {

    public Company get(long id) {
        return super.get(id, Company.class);
    }

    public List<Company> getAll() {
        List<Company> result;
        try (Session session = SessionFactoryUtil.getCurrentSessionFromConfig().openSession()){
            session.beginTransaction();
            result = session.createQuery("SELECT t FROM Company t").getResultList();
            session.getTransaction().commit();
        }
        return result;
    }

    public  void add(Company data) {
        super.add(data);
    }
    public List<CompanyDTO> sortByNameAndEarnings(){
        List<CompanyDTO> sortedList = new ArrayList<>();
        for (Company c : getAll()){
            sortedList.add(new CompanyDTO(c.getName(),c.getEarnings()));
        }
        sortedList.sort(CompanyDTO.byName.thenComparing(CompanyDTO.byEarnings));
        return sortedList;
    }
    public void delete(Company data) {
        super.update(data);
    }

    public void update(Company data) {
        super.update(data);
    }
}
