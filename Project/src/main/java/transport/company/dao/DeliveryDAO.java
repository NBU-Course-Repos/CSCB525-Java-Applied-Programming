package transport.company.dao;

import transport.company.entity.Delivery;

import java.util.List;

public class DeliveryDAO extends TemplateDAO<Delivery>{
    public Delivery get(long id) {
        return super.get(id, Delivery.class);
    }
    public List<Delivery> getAll() {
        return super.getAll();
    }
    public void add(Delivery data) { super.add(data); }
    public void delete(Delivery data) {
        super.update(data);
    }
    public void update(Delivery data) {
        super.update(data);
    }
}
