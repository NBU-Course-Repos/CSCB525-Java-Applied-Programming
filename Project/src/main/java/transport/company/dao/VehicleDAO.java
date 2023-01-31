package transport.company.dao;
import transport.company.entity.Vehicle;

import java.util.List;

public class VehicleDAO extends TemplateDAO<Vehicle> {
    public Vehicle get(long id) {
        return super.get(id, Vehicle.class);
    }

    public List<Vehicle> getAll() {
        return super.getAll();
    }

    public  void add(Vehicle data) {
        super.add(data);
    }

    public void delete(Vehicle data) {
        super.update(data);
    }

    public void update(Vehicle data) {
        super.update(data);
    }
}


