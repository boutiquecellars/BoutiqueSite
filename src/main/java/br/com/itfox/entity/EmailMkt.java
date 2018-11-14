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
@Table(name = "email_mkt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailMkt.findAll", query = "SELECT e FROM EmailMkt e"),
    @NamedQuery(name = "EmailMkt.findByEmailMktId", query = "SELECT e FROM EmailMkt e WHERE e.emailMktId = :emailMktId"),
    @NamedQuery(name = "EmailMkt.findByName", query = "SELECT e FROM EmailMkt e WHERE e.name = :name"),
    @NamedQuery(name = "EmailMkt.findByDescription", query = "SELECT e FROM EmailMkt e WHERE e.description = :description"),
    @NamedQuery(name = "EmailMkt.findByMetaTagTitle", query = "SELECT e FROM EmailMkt e WHERE e.metaTagTitle = :metaTagTitle"),
    @NamedQuery(name = "EmailMkt.findByMetaTagDescription", query = "SELECT e FROM EmailMkt e WHERE e.metaTagDescription = :metaTagDescription"),
    @NamedQuery(name = "EmailMkt.findByMetaTagKeywords", query = "SELECT e FROM EmailMkt e WHERE e.metaTagKeywords = :metaTagKeywords"),
    @NamedQuery(name = "EmailMkt.findByMetaTagUrl", query = "SELECT e FROM EmailMkt e WHERE e.metaTagUrl = :metaTagUrl")})
public class EmailMkt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_mkt_id")
    private Integer emailMktId;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 4000)
    @Column(name = "description")
    private String description;
    @Size(max = 4000)
    @Column(name = "meta_tag_title")
    private String metaTagTitle;
    @Size(max = 4000)
    @Column(name = "meta_tag_description")
    private String metaTagDescription;
    @Size(max = 4000)
    @Column(name = "meta_tag_keywords")
    private String metaTagKeywords;
    @Size(max = 4000)
    @Column(name = "meta_tag_url")
    private String metaTagUrl;

    public EmailMkt() {
    }

    public EmailMkt(Integer emailMktId) {
        this.emailMktId = emailMktId;
    }

    public Integer getEmailMktId() {
        return emailMktId;
    }

    public void setEmailMktId(Integer emailMktId) {
        this.emailMktId = emailMktId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTagTitle() {
        return metaTagTitle;
    }

    public void setMetaTagTitle(String metaTagTitle) {
        this.metaTagTitle = metaTagTitle;
    }

    public String getMetaTagDescription() {
        return metaTagDescription;
    }

    public void setMetaTagDescription(String metaTagDescription) {
        this.metaTagDescription = metaTagDescription;
    }

    public String getMetaTagKeywords() {
        return metaTagKeywords;
    }

    public void setMetaTagKeywords(String metaTagKeywords) {
        this.metaTagKeywords = metaTagKeywords;
    }

    public String getMetaTagUrl() {
        return metaTagUrl;
    }

    public void setMetaTagUrl(String metaTagUrl) {
        this.metaTagUrl = metaTagUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailMktId != null ? emailMktId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailMkt)) {
            return false;
        }
        EmailMkt other = (EmailMkt) object;
        if ((this.emailMktId == null && other.emailMktId != null) || (this.emailMktId != null && !this.emailMktId.equals(other.emailMktId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.EmailMkt[ emailMktId=" + emailMktId + " ]";
    }
    
}
