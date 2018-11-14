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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "email_mkt_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailMktProduct.findAll", query = "SELECT e FROM EmailMktProduct e"),
    @NamedQuery(name = "EmailMktProduct.findByEmailMktProductId", query = "SELECT e FROM EmailMktProduct e WHERE e.emailMktProductId = :emailMktProductId"),
    @NamedQuery(name = "EmailMktProduct.findByEmailMktId", query = "SELECT e FROM EmailMktProduct e WHERE e.emailMktId = :emailMktId"),
    @NamedQuery(name = "EmailMktProduct.findByProductId", query = "SELECT e FROM EmailMktProduct e WHERE e.productId = :productId")})
public class EmailMktProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_mkt_product_id")
    private Integer emailMktProductId;
    @Column(name = "email_mkt_id")
    private Integer emailMktId;
    @Column(name = "product_id")
    private Integer productId;

    public EmailMktProduct() {
    }

    public EmailMktProduct(Integer emailMktProductId) {
        this.emailMktProductId = emailMktProductId;
    }

    public Integer getEmailMktProductId() {
        return emailMktProductId;
    }

    public void setEmailMktProductId(Integer emailMktProductId) {
        this.emailMktProductId = emailMktProductId;
    }

    public Integer getEmailMktId() {
        return emailMktId;
    }

    public void setEmailMktId(Integer emailMktId) {
        this.emailMktId = emailMktId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailMktProductId != null ? emailMktProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailMktProduct)) {
            return false;
        }
        EmailMktProduct other = (EmailMktProduct) object;
        if ((this.emailMktProductId == null && other.emailMktProductId != null) || (this.emailMktProductId != null && !this.emailMktProductId.equals(other.emailMktProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.EmailMktProduct[ emailMktProductId=" + emailMktProductId + " ]";
    }
    
}
