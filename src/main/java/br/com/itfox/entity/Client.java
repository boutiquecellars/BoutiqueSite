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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name"),
    @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByDateBirth", query = "SELECT c FROM Client c WHERE c.dateBirth = :dateBirth"),
    @NamedQuery(name = "Client.findByCompanyName1", query = "SELECT c FROM Client c WHERE c.companyName1 = :companyName1"),
    @NamedQuery(name = "Client.findByContactPerson1", query = "SELECT c FROM Client c WHERE c.contactPerson1 = :contactPerson1"),
    @NamedQuery(name = "Client.findByStreetAddress11", query = "SELECT c FROM Client c WHERE c.streetAddress11 = :streetAddress11"),
    @NamedQuery(name = "Client.findByStreetAddress12", query = "SELECT c FROM Client c WHERE c.streetAddress12 = :streetAddress12"),
    @NamedQuery(name = "Client.findBySuburb1", query = "SELECT c FROM Client c WHERE c.suburb1 = :suburb1"),
    @NamedQuery(name = "Client.findByPostal1", query = "SELECT c FROM Client c WHERE c.postal1 = :postal1"),
    @NamedQuery(name = "Client.findByState1", query = "SELECT c FROM Client c WHERE c.state1 = :state1"),
    @NamedQuery(name = "Client.findBySameAsDelivery", query = "SELECT c FROM Client c WHERE c.sameAsDelivery = :sameAsDelivery"),
    @NamedQuery(name = "Client.findByCompanyName2", query = "SELECT c FROM Client c WHERE c.companyName2 = :companyName2"),
    @NamedQuery(name = "Client.findByStreetAddress21", query = "SELECT c FROM Client c WHERE c.streetAddress21 = :streetAddress21"),
    @NamedQuery(name = "Client.findByStreetAddress22", query = "SELECT c FROM Client c WHERE c.streetAddress22 = :streetAddress22"),
    @NamedQuery(name = "Client.findBySuburb2", query = "SELECT c FROM Client c WHERE c.suburb2 = :suburb2"),
    @NamedQuery(name = "Client.findByPostal2", query = "SELECT c FROM Client c WHERE c.postal2 = :postal2"),
    @NamedQuery(name = "Client.findByState2", query = "SELECT c FROM Client c WHERE c.state2 = :state2")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "client_id")
    private Integer clientId;
    @Size(max = 445)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 450)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 445)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 45)
    @Column(name = "date_birth")
    private String dateBirth;
    @Size(max = 450)
    @Column(name = "company_name1")
    private String companyName1;
    @Size(max = 45)
    @Column(name = "contact_person1")
    private String contactPerson1;
    @Size(max = 450)
    @Column(name = "street_address11")
    private String streetAddress11;
    @Size(max = 450)
    @Column(name = "street_address12")
    private String streetAddress12;
    @Size(max = 450)
    @Column(name = "suburb1")
    private String suburb1;
    @Size(max = 450)
    @Column(name = "postal1")
    private String postal1;
    @Size(max = 450)
    @Column(name = "state1")
    private String state1;
    @Column(name = "same_as_delivery")
    private Integer sameAsDelivery;
    @Size(max = 450)
    @Column(name = "company_name2")
    private String companyName2;
    @Size(max = 450)
    @Column(name = "street_address21")
    private String streetAddress21;
    @Size(max = 450)
    @Column(name = "street_address22")
    private String streetAddress22;
    @Size(max = 450)
    @Column(name = "suburb2")
    private String suburb2;
    @Size(max = 45)
    @Column(name = "postal2")
    private String postal2;
    @Size(max = 45)
    @Column(name = "state2")
    private String state2;
    @JoinColumn(name = "billing_address", referencedColumnName = "address_id")
    @ManyToOne
    private Address billingAddress;
    @JoinColumn(name = "shipping_address", referencedColumnName = "address_id")
    @ManyToOne
    private Address shippingAddress;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCompanyName1() {
        return companyName1;
    }

    public void setCompanyName1(String companyName1) {
        this.companyName1 = companyName1;
    }

    public String getContactPerson1() {
        return contactPerson1;
    }

    public void setContactPerson1(String contactPerson1) {
        this.contactPerson1 = contactPerson1;
    }

    public String getStreetAddress11() {
        return streetAddress11;
    }

    public void setStreetAddress11(String streetAddress11) {
        this.streetAddress11 = streetAddress11;
    }

    public String getStreetAddress12() {
        return streetAddress12;
    }

    public void setStreetAddress12(String streetAddress12) {
        this.streetAddress12 = streetAddress12;
    }

    public String getSuburb1() {
        return suburb1;
    }

    public void setSuburb1(String suburb1) {
        this.suburb1 = suburb1;
    }

    public String getPostal1() {
        return postal1;
    }

    public void setPostal1(String postal1) {
        this.postal1 = postal1;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public Integer getSameAsDelivery() {
        return sameAsDelivery;
    }

    public void setSameAsDelivery(Integer sameAsDelivery) {
        this.sameAsDelivery = sameAsDelivery;
    }

    public String getCompanyName2() {
        return companyName2;
    }

    public void setCompanyName2(String companyName2) {
        this.companyName2 = companyName2;
    }

    public String getStreetAddress21() {
        return streetAddress21;
    }

    public void setStreetAddress21(String streetAddress21) {
        this.streetAddress21 = streetAddress21;
    }

    public String getStreetAddress22() {
        return streetAddress22;
    }

    public void setStreetAddress22(String streetAddress22) {
        this.streetAddress22 = streetAddress22;
    }

    public String getSuburb2() {
        return suburb2;
    }

    public void setSuburb2(String suburb2) {
        this.suburb2 = suburb2;
    }

    public String getPostal2() {
        return postal2;
    }

    public void setPostal2(String postal2) {
        this.postal2 = postal2;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Client[ clientId=" + clientId + " ]";
    }
    
}
