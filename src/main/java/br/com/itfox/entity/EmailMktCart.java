/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "email_mkt_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailMktCart.findAll", query = "SELECT e FROM EmailMktCart e"),
    @NamedQuery(name = "EmailMktCart.findByEmailMktId", query = "SELECT e FROM EmailMktCart e WHERE e.emailMktCartPK.emailMktId = :emailMktId"),
    @NamedQuery(name = "EmailMktCart.findByClientId", query = "SELECT e FROM EmailMktCart e WHERE e.emailMktCartPK.clientId = :clientId"),
    @NamedQuery(name = "EmailMktCart.findByProductId", query = "SELECT e FROM EmailMktCart e WHERE e.emailMktCartPK.productId = :productId"),
    @NamedQuery(name = "EmailMktCart.findByQuantity", query = "SELECT e FROM EmailMktCart e WHERE e.quantity = :quantity"),
    @NamedQuery(name = "EmailMktCart.findByPrice", query = "SELECT e FROM EmailMktCart e WHERE e.price = :price"),
    @NamedQuery(name = "EmailMktCart.findByTotal", query = "SELECT e FROM EmailMktCart e WHERE e.total = :total"),
    @NamedQuery(name = "EmailMktCart.findByDate", query = "SELECT e FROM EmailMktCart e WHERE e.date = :date"),
    @NamedQuery(name = "EmailMktCart.findByStatus", query = "SELECT e FROM EmailMktCart e WHERE e.status = :status")})
public class EmailMktCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmailMktCartPK emailMktCartPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantity")
    private Float quantity;
    @Column(name = "price")
    private Float price;
    @Column(name = "total")
    private Float total;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 45)
    @Column(name = "status")
    private String status;

    public EmailMktCart() {
    }

    public EmailMktCart(EmailMktCartPK emailMktCartPK) {
        this.emailMktCartPK = emailMktCartPK;
    }

    public EmailMktCart(int emailMktId, int clientId, int productId) {
        this.emailMktCartPK = new EmailMktCartPK(emailMktId, clientId, productId);
    }

    public EmailMktCartPK getEmailMktCartPK() {
        return emailMktCartPK;
    }

    public void setEmailMktCartPK(EmailMktCartPK emailMktCartPK) {
        this.emailMktCartPK = emailMktCartPK;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        hash += (emailMktCartPK != null ? emailMktCartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailMktCart)) {
            return false;
        }
        EmailMktCart other = (EmailMktCart) object;
        if ((this.emailMktCartPK == null && other.emailMktCartPK != null) || (this.emailMktCartPK != null && !this.emailMktCartPK.equals(other.emailMktCartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.EmailMktCart[ emailMktCartPK=" + emailMktCartPK + " ]";
    }
    
}
