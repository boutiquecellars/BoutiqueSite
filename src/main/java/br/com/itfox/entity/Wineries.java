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
@Table(name = "WINERIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wineries.findAll", query = "SELECT w FROM Wineries w"),
    @NamedQuery(name = "Wineries.findByWineriesId", query = "SELECT w FROM Wineries w WHERE w.wineriesId = :wineriesId"),
    @NamedQuery(name = "Wineries.findByName", query = "SELECT w FROM Wineries w WHERE w.name = :name"),
    @NamedQuery(name = "Wineries.findByDescription", query = "SELECT w FROM Wineries w WHERE w.description = :description"),
    @NamedQuery(name = "Wineries.findByPhoto", query = "SELECT w FROM Wineries w WHERE w.photo = :photo")})
public class Wineries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WINERIES_ID")
    private Integer wineriesId;
    @Size(max = 145)
    @Column(name = "NAME")
    private String name;
    @Size(max = 450)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 245)
    @Column(name = "PHOTO")
    private String photo;

    public Wineries() {
    }

    public Wineries(Integer wineriesId) {
        this.wineriesId = wineriesId;
    }

    public Integer getWineriesId() {
        return wineriesId;
    }

    public void setWineriesId(Integer wineriesId) {
        this.wineriesId = wineriesId;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wineriesId != null ? wineriesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wineries)) {
            return false;
        }
        Wineries other = (Wineries) object;
        if ((this.wineriesId == null && other.wineriesId != null) || (this.wineriesId != null && !this.wineriesId.equals(other.wineriesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Wineries[ wineriesId=" + wineriesId + " ]";
    }
    
}
