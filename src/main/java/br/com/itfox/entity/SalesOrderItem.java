/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "sales_order_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesOrderItem.findAll", query = "SELECT s FROM SalesOrderItem s"),
    @NamedQuery(name = "SalesOrderItem.findByOrderItemId", query = "SELECT s FROM SalesOrderItem s WHERE s.orderItemId = :orderItemId"),
    @NamedQuery(name = "SalesOrderItem.findByOrderId", query = "SELECT s FROM SalesOrderItem s WHERE s.orderId = :orderId"),
    @NamedQuery(name = "SalesOrderItem.findByProductId", query = "SELECT s FROM SalesOrderItem s WHERE s.productId = :productId"),
    @NamedQuery(name = "SalesOrderItem.findByProductQuantity", query = "SELECT s FROM SalesOrderItem s WHERE s.productQuantity = :productQuantity"),
    @NamedQuery(name = "SalesOrderItem.findByProductPrice", query = "SELECT s FROM SalesOrderItem s WHERE s.productPrice = :productPrice"),
    @NamedQuery(name = "SalesOrderItem.findByProductDescount", query = "SELECT s FROM SalesOrderItem s WHERE s.productDescount = :productDescount"),
    @NamedQuery(name = "SalesOrderItem.findByProductTotal", query = "SELECT s FROM SalesOrderItem s WHERE s.productTotal = :productTotal"),
    @NamedQuery(name = "SalesOrderItem.findByOrderItemStatus", query = "SELECT s FROM SalesOrderItem s WHERE s.orderItemStatus = :orderItemStatus")})
public class SalesOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_item_id")
    private Integer orderItemId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_id")
    private Integer productId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "product_quantity")
    private Double productQuantity;
    @Column(name = "product_price")
    private Double productPrice;
    @Column(name = "product_descount")
    private Double productDescount;
    @Column(name = "product_total")
    private Double productTotal;
    @Size(max = 45)
    @Column(name = "order_item_status")
    private String orderItemStatus;

    public SalesOrderItem() {
    }

    public SalesOrderItem(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductDescount() {
        return productDescount;
    }

    public void setProductDescount(Double productDescount) {
        this.productDescount = productDescount;
    }

    public Double getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(Double productTotal) {
        this.productTotal = productTotal;
    }

    public String getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(String orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderItemId != null ? orderItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderItem)) {
            return false;
        }
        SalesOrderItem other = (SalesOrderItem) object;
        if ((this.orderItemId == null && other.orderItemId != null) || (this.orderItemId != null && !this.orderItemId.equals(other.orderItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.SalesOrderItem[ orderItemId=" + orderItemId + " ]";
    }
    
}
