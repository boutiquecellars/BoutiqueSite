/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByMemberId", query = "SELECT m FROM Member1 m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "Member1.findByName", query = "SELECT m FROM Member1 m WHERE m.name = :name"),
    @NamedQuery(name = "Member1.findByEmail", query = "SELECT m FROM Member1 m WHERE m.email = :email"),
    @NamedQuery(name = "Member1.findByPass", query = "SELECT m FROM Member1 m WHERE m.pass = :pass"),
    @NamedQuery(name = "Member1.findByRegdate", query = "SELECT m FROM Member1 m WHERE m.regdate = :regdate"),
    @NamedQuery(name = "Member1.findByTerms", query = "SELECT m FROM Member1 m WHERE m.terms = :terms"),
    @NamedQuery(name = "Member1.findByPermission", query = "SELECT m FROM Member1 m WHERE m.permission = :permission"),
    @NamedQuery(name = "Member1.findByDate", query = "SELECT m FROM Member1 m WHERE m.date = :date")})
public class Member1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEMBER_ID")
    private Integer memberId;
    @Size(max = 75)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 145)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "PASS")
    private String pass;
    @Column(name = "REGDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;
    @Size(max = 45)
    @Column(name = "TERMS")
    private String terms;
    @Size(max = 45)
    @Column(name = "PERMISSION")
    private String permission;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToMany(mappedBy = "member1Collection")
    private Collection<Areaoper> areaoperCollection;

    public Member1() {
    }

    public Member1(Integer memberId) {
        this.memberId = memberId;
    }

    public Member1(Integer memberId, String email) {
        this.memberId = memberId;
        this.email = email;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Areaoper> getAreaoperCollection() {
        return areaoperCollection;
    }

    public void setAreaoperCollection(Collection<Areaoper> areaoperCollection) {
        this.areaoperCollection = areaoperCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Member1[ memberId=" + memberId + " ]";
    }
    
}
