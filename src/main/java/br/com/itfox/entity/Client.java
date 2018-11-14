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
    @NamedQuery(name = "Client.findByPhone", query = "SELECT c FROM Client c WHERE c.phone = :phone"),
    @NamedQuery(name = "Client.findByDateBirth", query = "SELECT c FROM Client c WHERE c.dateBirth = :dateBirth"),
    @NamedQuery(name = "Client.findByCompanyName", query = "SELECT c FROM Client c WHERE c.companyName = :companyName"),
    @NamedQuery(name = "Client.findByContactPerson", query = "SELECT c FROM Client c WHERE c.contactPerson = :contactPerson"),
    @NamedQuery(name = "Client.findByStreetAddress1", query = "SELECT c FROM Client c WHERE c.streetAddress1 = :streetAddress1"),
    @NamedQuery(name = "Client.findByStreetAddress2", query = "SELECT c FROM Client c WHERE c.streetAddress2 = :streetAddress2"),
    @NamedQuery(name = "Client.findBySuburb", query = "SELECT c FROM Client c WHERE c.suburb = :suburb"),
    @NamedQuery(name = "Client.findByPostcode", query = "SELECT c FROM Client c WHERE c.postcode = :postcode"),
    @NamedQuery(name = "Client.findByState", query = "SELECT c FROM Client c WHERE c.state = :state"),
    @NamedQuery(name = "Client.findBySameAsDelivery", query = "SELECT c FROM Client c WHERE c.sameAsDelivery = :sameAsDelivery")})
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
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "date_birth")
    private String dateBirth;
    @Size(max = 450)
    @Column(name = "company_name")
    private String companyName;
    @Size(max = 45)
    @Column(name = "contact_person")
    private String contactPerson;
    @Size(max = 450)
    @Column(name = "street_address1")
    private String streetAddress1;
    @Size(max = 450)
    @Column(name = "street_address2")
    private String streetAddress2;
    @Size(max = 450)
    @Column(name = "suburb")
    private String suburb;
    @Size(max = 450)
    @Column(name = "postcode")
    private String postcode;
    @Size(max = 450)
    @Column(name = "state")
    private String state;
    @Column(name = "same_as_delivery")
    private Integer sameAsDelivery;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSameAsDelivery() {
        return sameAsDelivery;
    }

    public void setSameAsDelivery(Integer sameAsDelivery) {
        this.sameAsDelivery = sameAsDelivery;
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
