/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "areaoper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areaoper.findAll", query = "SELECT a FROM Areaoper a"),
    @NamedQuery(name = "Areaoper.findByAreaOperacional", query = "SELECT a FROM Areaoper a WHERE a.areaOperacional = :areaOperacional"),
    @NamedQuery(name = "Areaoper.findByDescricao", query = "SELECT a FROM Areaoper a WHERE a.descricao = :descricao")})
public class Areaoper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AREA_OPERACIONAL")
    private Integer areaOperacional;
    @Size(max = 405)
    @Column(name = "DESCRICAO")
    private String descricao;
    @JoinTable(name = "member_areaoper", joinColumns = {
        @JoinColumn(name = "AREA_OPERACIONAL", referencedColumnName = "AREA_OPERACIONAL")}, inverseJoinColumns = {
        @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID")})
    @ManyToMany
    private Collection<Member1> member1Collection;

    public Areaoper() {
    }

    public Areaoper(Integer areaOperacional) {
        this.areaOperacional = areaOperacional;
    }

    public Integer getAreaOperacional() {
        return areaOperacional;
    }

    public void setAreaOperacional(Integer areaOperacional) {
        this.areaOperacional = areaOperacional;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Member1> getMember1Collection() {
        return member1Collection;
    }

    public void setMember1Collection(Collection<Member1> member1Collection) {
        this.member1Collection = member1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaOperacional != null ? areaOperacional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areaoper)) {
            return false;
        }
        Areaoper other = (Areaoper) object;
        if ((this.areaOperacional == null && other.areaOperacional != null) || (this.areaOperacional != null && !this.areaOperacional.equals(other.areaOperacional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Areaoper[ areaOperacional=" + areaOperacional + " ]";
    }
    
}
