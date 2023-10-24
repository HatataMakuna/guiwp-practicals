package model;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class CustomerService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public CustomerService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addItem(Customer cus) {
        mgr.persist(cus);
        return true;
    }
    
    public Customer findByUsername(String username) {
        Customer cus = mgr.find(Customer.class, username);
        return cus;
    }
    
    public Customer findByPassword(String password) {
        Customer cus = mgr.find(Customer.class, password);
        return cus;
    }
    
    public Customer findByName(String name) {
        Customer cus = mgr.find(Customer.class, name);
        return cus;
    }

    public Customer findByGender(Character gender) {
        Customer cus = mgr.find(Customer.class, gender);
        return cus;
    }
    
    public Customer findByIc(String ic) {
        Customer cus = mgr.find(Customer.class, ic);
        return cus;
    }
    
    public Customer findByPhone(String phone) {
        Customer cus = mgr.find(Customer.class, phone);
        return cus;
    }
    
    public Customer findByGmail(String gmail) {
        Customer cus = mgr.find(Customer.class, gmail);
        return cus;
    }
    
    public Customer findByAddress(String address) {
        Customer cus = mgr.find(Customer.class, address);
        return cus;
    }
    
    public boolean deleteItem(String username) {
        Customer cus = findByUsername(username);
        if (cus != null) {
            mgr.remove(cus);
            return true;
        }
        return false;
    }

    public List<Customer> findAll() {
        List CustomerList = mgr.createNamedQuery("Customer.findAll").getResultList();
        return CustomerList;
    }
    
    public boolean updatePassword(Customer cus) {
        mgr.merge(cus);
        return true;
    }
}