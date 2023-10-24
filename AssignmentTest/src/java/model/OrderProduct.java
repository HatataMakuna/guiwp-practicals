/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ORDER_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProduct.findAll", query = "SELECT o FROM OrderProduct o")
    , @NamedQuery(name = "OrderProduct.findByOrderId", query = "SELECT o FROM OrderProduct o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "OrderProduct.findByUsername", query = "SELECT o FROM OrderProduct o WHERE o.username = :username")
    , @NamedQuery(name = "OrderProduct.findByPaymentId", query = "SELECT o FROM OrderProduct o WHERE o.paymentId = :paymentId")
    , @NamedQuery(name = "OrderProduct.findByTotalPrice", query = "SELECT o FROM OrderProduct o WHERE o.totalPrice = :totalPrice")
    , @NamedQuery(name = "OrderProduct.findByOrderDate", query = "SELECT o FROM OrderProduct o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "OrderProduct.findByStatus", query = "SELECT o FROM OrderProduct o WHERE o.status = :status")})
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ORDER_ID")
    private String orderId;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 10)
    @Column(name = "PAYMENT_ID")
    private String paymentId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;

    public OrderProduct() {
    }

    public OrderProduct(String orderId) {
        this.orderId = orderId;
    }

    public OrderProduct(String orderId, String username, String paymentId, Double totalPrice, Date orderDate, String status) {
        this.orderId = orderId;
        this.username = username;
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderProduct)) {
            return false;
        }
        OrderProduct other = (OrderProduct) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrderProduct[ orderId=" + orderId + " ]";
    }
    
}
