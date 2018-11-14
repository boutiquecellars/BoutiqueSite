/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author belchiorpalma
 */
@Embeddable
public class EmailMktCartPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "email_mkt_id")
    private int emailMktId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "client_id")
    private int clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;

    public EmailMktCartPK() {
    }

    public EmailMktCartPK(int emailMktId, int clientId, int productId) {
        this.emailMktId = emailMktId;
        this.clientId = clientId;
        this.productId = productId;
    }

    public int getEmailMktId() {
        return emailMktId;
    }

    public void setEmailMktId(int emailMktId) {
        this.emailMktId = emailMktId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) emailMktId;
        hash += (int) clientId;
        hash += (int) productId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailMktCartPK)) {
            return false;
        }
        EmailMktCartPK other = (EmailMktCartPK) object;
        if (this.emailMktId != other.emailMktId) {
            return false;
        }
        if (this.clientId != other.clientId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.EmailMktCartPK[ emailMktId=" + emailMktId + ", clientId=" + clientId + ", productId=" + productId + " ]";
    }
    
}
