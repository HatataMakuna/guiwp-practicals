package model;

import model.OrderProduct;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class OrderProductService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public OrderProductService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addItem(OrderProduct op) {
        mgr.persist(op);
        return true;
    }

    public OrderProduct findByOrderId(String orderid) {
        OrderProduct op = mgr.find(OrderProduct.class, orderid);
        return op;
    }
    
    public OrderProduct findByUsername(String username) {
        OrderProduct op = mgr.find(OrderProduct.class, username);
        return op;
    }
    
    public OrderProduct findByPaymentId(String paymentid) {
        OrderProduct op = mgr.find(OrderProduct.class, paymentid);
        return op;
    }
    
    public OrderProduct findByTotalPrice(String totalprice) {
        OrderProduct op = mgr.find(OrderProduct.class, totalprice);
        return op;
    }
    
    public OrderProduct findByOrderDate(String orderdate) {
        OrderProduct op = mgr.find(OrderProduct.class, orderdate);
        return op;
    }
    
    public OrderProduct findByOrderStatus(String orderstatus) {
        OrderProduct op = mgr.find(OrderProduct.class, orderstatus);
        return op;
    }
    
    public List<OrderProduct> findAll() {
        List OrderProductList = mgr.createNamedQuery("OrderProduct.findAll").getResultList();
        return OrderProductList;
    }
    
    public boolean updateStatus(OrderProduct op) {
        OrderProduct tempOp = findByOrderId(op.getOrderId());
        if (tempOp != null) {
            tempOp.setStatus(op.getStatus());
            mgr.merge(tempOp);
            return true;
        }
        return false;
    }
}