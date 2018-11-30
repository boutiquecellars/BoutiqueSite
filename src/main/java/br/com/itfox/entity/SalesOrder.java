/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "sales_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrder.findAll", query = "SELECT s FROM SalesOrder s"),
    @NamedQuery(name = "SalesOrder.findByOrderId", query = "SELECT s FROM SalesOrder s WHERE s.orderId = :orderId"),
    @NamedQuery(name = "SalesOrder.findByClientId", query = "SELECT s FROM SalesOrder s WHERE s.clientId = :clientId"),
    @NamedQuery(name = "SalesOrder.findByOrderDate", query = "SELECT s FROM SalesOrder s WHERE s.orderDate = :orderDate"),
    @NamedQuery(name = "SalesOrder.findByDescription", query = "SELECT s FROM SalesOrder s WHERE s.description = :description"),
    @NamedQuery(name = "SalesOrder.findByOrderStatus", query = "SELECT s FROM SalesOrder s WHERE s.orderStatus = :orderStatus"),
    @NamedQuery(name = "SalesOrder.findBySession", query = "SELECT s FROM SalesOrder s WHERE s.session = :session"),
    @NamedQuery(name = "SalesOrder.findByIp", query = "SELECT s FROM SalesOrder s WHERE s.ip = :ip")})
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Size(max = 45)
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "order_status")
    private String orderStatus;
    @Size(max = 4500)
    @Column(name = "session")
    private String session;
    @Size(max = 45)
    @Column(name = "ip")
    private String ip;
    @Size(max = 45)
    @Column(name = "shipping")
    private String shipping;

    public SalesOrder() {
    }

    public SalesOrder(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
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
        if (!(object instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.SalesOrder[ orderId=" + orderId + " ]";
    }
    
}
