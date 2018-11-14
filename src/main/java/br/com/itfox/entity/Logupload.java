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
import javax.persistence.Lob;
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
@Table(name = "logupload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logupload.findAll", query = "SELECT l FROM Logupload l"),
    @NamedQuery(name = "Logupload.findByLoguploadId", query = "SELECT l FROM Logupload l WHERE l.loguploadId = :loguploadId"),
    @NamedQuery(name = "Logupload.findByFilename", query = "SELECT l FROM Logupload l WHERE l.filename = :filename"),
    @NamedQuery(name = "Logupload.findByPath", query = "SELECT l FROM Logupload l WHERE l.path = :path"),
    @NamedQuery(name = "Logupload.findByStatus", query = "SELECT l FROM Logupload l WHERE l.status = :status"),
    @NamedQuery(name = "Logupload.findByDate", query = "SELECT l FROM Logupload l WHERE l.date = :date")})
public class Logupload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LOGUPLOAD_ID")
    private Integer loguploadId;
    @Size(max = 145)
    @Column(name = "FILENAME")
    private String filename;
    @Size(max = 245)
    @Column(name = "PATH")
    private String path;
    @Lob
    @Column(name = "DESCRIPTION")
    private byte[] description;
    @Size(max = 45)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Logupload() {
    }

    public Logupload(Integer loguploadId) {
        this.loguploadId = loguploadId;
    }

    public Integer getLoguploadId() {
        return loguploadId;
    }

    public void setLoguploadId(Integer loguploadId) {
        this.loguploadId = loguploadId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte[] getDescription() {
        return description;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loguploadId != null ? loguploadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logupload)) {
            return false;
        }
        Logupload other = (Logupload) object;
        if ((this.loguploadId == null && other.loguploadId != null) || (this.loguploadId != null && !this.loguploadId.equals(other.loguploadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Logupload[ loguploadId=" + loguploadId + " ]";
    }
    
}
