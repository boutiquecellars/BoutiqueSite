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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "product_carousel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCarousel.findAll", query = "SELECT p FROM ProductCarousel p"),
    @NamedQuery(name = "ProductCarousel.findByProductId", query = "SELECT p FROM ProductCarousel p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductCarousel.findByProductOrder", query = "SELECT p FROM ProductCarousel p WHERE p.productOrder = :productOrder")})
public class ProductCarousel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_order")
    private Integer productOrder;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Product product;

    public ProductCarousel() {
    }

    public ProductCarousel(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Integer productOrder) {
        this.productOrder = productOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCarousel)) {
            return false;
        }
        ProductCarousel other = (ProductCarousel) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.ProductCarousel[ productId=" + productId + " ]";
    }
    
}
