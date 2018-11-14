/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.entity;

import br.com.itfox.beans.Order;
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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author belchiorpalma
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByTransactionId", query = "SELECT t FROM Transaction t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "Transaction.findByAccessCode", query = "SELECT t FROM Transaction t WHERE t.accessCode = :accessCode"),
    @NamedQuery(name = "Transaction.findByTransactionAuthorisationCode", query = "SELECT t FROM Transaction t WHERE t.transactionAuthorisationCode = :transactionAuthorisationCode"),
    @NamedQuery(name = "Transaction.findByTransactionResponseCode", query = "SELECT t FROM Transaction t WHERE t.transactionResponseCode = :transactionResponseCode"),
    @NamedQuery(name = "Transaction.findByTransactionResponseMessage", query = "SELECT t FROM Transaction t WHERE t.transactionResponseMessage = :transactionResponseMessage"),
    @NamedQuery(name = "Transaction.findByTransactionInvoiceNumber", query = "SELECT t FROM Transaction t WHERE t.transactionInvoiceNumber = :transactionInvoiceNumber"),
    @NamedQuery(name = "Transaction.findByTransactionInvoiceReference", query = "SELECT t FROM Transaction t WHERE t.transactionInvoiceReference = :transactionInvoiceReference"),
    @NamedQuery(name = "Transaction.findByTransactionTotalAmount", query = "SELECT t FROM Transaction t WHERE t.transactionTotalAmount = :transactionTotalAmount"),
    @NamedQuery(name = "Transaction.findByTransactiontransactionID", query = "SELECT t FROM Transaction t WHERE t.transactiontransactionID = :transactiontransactionID"),
    @NamedQuery(name = "Transaction.findByTransactionStatus", query = "SELECT t FROM Transaction t WHERE t.transactionStatus = :transactionStatus"),
    @NamedQuery(name = "Transaction.findByTransactionTokenCustomerId", query = "SELECT t FROM Transaction t WHERE t.transactionTokenCustomerId = :transactionTokenCustomerId"),
    @NamedQuery(name = "Transaction.findByTransactionBeagleScore", query = "SELECT t FROM Transaction t WHERE t.transactionBeagleScore = :transactionBeagleScore"),
    @NamedQuery(name = "Transaction.findByTransactionOptions", query = "SELECT t FROM Transaction t WHERE t.transactionOptions = :transactionOptions"),
    @NamedQuery(name = "Transaction.findByVerificationCvn", query = "SELECT t FROM Transaction t WHERE t.verificationCvn = :verificationCvn"),
    @NamedQuery(name = "Transaction.findByVerificationAddress", query = "SELECT t FROM Transaction t WHERE t.verificationAddress = :verificationAddress"),
    @NamedQuery(name = "Transaction.findByVerificationEmail", query = "SELECT t FROM Transaction t WHERE t.verificationEmail = :verificationEmail"),
    @NamedQuery(name = "Transaction.findByVerificationMobile", query = "SELECT t FROM Transaction t WHERE t.verificationMobile = :verificationMobile"),
    @NamedQuery(name = "Transaction.findByVerificationPhone", query = "SELECT t FROM Transaction t WHERE t.verificationPhone = :verificationPhone"),
    @NamedQuery(name = "Transaction.findByBeagleVerificationEmail", query = "SELECT t FROM Transaction t WHERE t.beagleVerificationEmail = :beagleVerificationEmail"),
    @NamedQuery(name = "Transaction.findByBeagleVerificationPhone", query = "SELECT t FROM Transaction t WHERE t.beagleVerificationPhone = :beagleVerificationPhone"),
    @NamedQuery(name = "Transaction.findByCustomerTokenCustomerId", query = "SELECT t FROM Transaction t WHERE t.customerTokenCustomerId = :customerTokenCustomerId"),
    @NamedQuery(name = "Transaction.findByCustomerReference", query = "SELECT t FROM Transaction t WHERE t.customerReference = :customerReference"),
    @NamedQuery(name = "Transaction.findByCustomerTitle", query = "SELECT t FROM Transaction t WHERE t.customerTitle = :customerTitle"),
    @NamedQuery(name = "Transaction.findByCustomerFirstName", query = "SELECT t FROM Transaction t WHERE t.customerFirstName = :customerFirstName"),
    @NamedQuery(name = "Transaction.findByCustomerLastName", query = "SELECT t FROM Transaction t WHERE t.customerLastName = :customerLastName"),
    @NamedQuery(name = "Transaction.findByCustomerCompanyName", query = "SELECT t FROM Transaction t WHERE t.customerCompanyName = :customerCompanyName"),
    @NamedQuery(name = "Transaction.findByCustomerJobDescription", query = "SELECT t FROM Transaction t WHERE t.customerJobDescription = :customerJobDescription"),
    @NamedQuery(name = "Transaction.findByCustomerStreet1", query = "SELECT t FROM Transaction t WHERE t.customerStreet1 = :customerStreet1"),
    @NamedQuery(name = "Transaction.findByCustomerStreet2", query = "SELECT t FROM Transaction t WHERE t.customerStreet2 = :customerStreet2"),
    @NamedQuery(name = "Transaction.findByCustomerCity", query = "SELECT t FROM Transaction t WHERE t.customerCity = :customerCity"),
    @NamedQuery(name = "Transaction.findByCustomerState", query = "SELECT t FROM Transaction t WHERE t.customerState = :customerState"),
    @NamedQuery(name = "Transaction.findByCustomerPostalCode", query = "SELECT t FROM Transaction t WHERE t.customerPostalCode = :customerPostalCode"),
    @NamedQuery(name = "Transaction.findByCustomerCountry", query = "SELECT t FROM Transaction t WHERE t.customerCountry = :customerCountry"),
    @NamedQuery(name = "Transaction.findByCustomerEmail", query = "SELECT t FROM Transaction t WHERE t.customerEmail = :customerEmail"),
    @NamedQuery(name = "Transaction.findByCustomerPhone", query = "SELECT t FROM Transaction t WHERE t.customerPhone = :customerPhone"),
    @NamedQuery(name = "Transaction.findByCustomerMobile", query = "SELECT t FROM Transaction t WHERE t.customerMobile = :customerMobile"),
    @NamedQuery(name = "Transaction.findByCustomerComments", query = "SELECT t FROM Transaction t WHERE t.customerComments = :customerComments"),
    @NamedQuery(name = "Transaction.findByCustomerFax", query = "SELECT t FROM Transaction t WHERE t.customerFax = :customerFax"),
    @NamedQuery(name = "Transaction.findByCustomerUrl", query = "SELECT t FROM Transaction t WHERE t.customerUrl = :customerUrl"),
    @NamedQuery(name = "Transaction.findByCustomerNote", query = "SELECT t FROM Transaction t WHERE t.customerNote = :customerNote"),
    @NamedQuery(name = "Transaction.findByShippingAddressShippingMethod", query = "SELECT t FROM Transaction t WHERE t.shippingAddressShippingMethod = :shippingAddressShippingMethod"),
    @NamedQuery(name = "Transaction.findByShippingAddressFirstName", query = "SELECT t FROM Transaction t WHERE t.shippingAddressFirstName = :shippingAddressFirstName"),
    @NamedQuery(name = "Transaction.findByShippingAddressLastName", query = "SELECT t FROM Transaction t WHERE t.shippingAddressLastName = :shippingAddressLastName"),
    @NamedQuery(name = "Transaction.findByShippingAddressStreet1", query = "SELECT t FROM Transaction t WHERE t.shippingAddressStreet1 = :shippingAddressStreet1"),
    @NamedQuery(name = "Transaction.findByShippingAddressStreet2", query = "SELECT t FROM Transaction t WHERE t.shippingAddressStreet2 = :shippingAddressStreet2"),
    @NamedQuery(name = "Transaction.findByShippingAddressCity", query = "SELECT t FROM Transaction t WHERE t.shippingAddressCity = :shippingAddressCity"),
    @NamedQuery(name = "Transaction.findByShippingAddressState", query = "SELECT t FROM Transaction t WHERE t.shippingAddressState = :shippingAddressState"),
    @NamedQuery(name = "Transaction.findByShippingAddressCountry", query = "SELECT t FROM Transaction t WHERE t.shippingAddressCountry = :shippingAddressCountry"),
    @NamedQuery(name = "Transaction.findByShippingAddressPostalCode", query = "SELECT t FROM Transaction t WHERE t.shippingAddressPostalCode = :shippingAddressPostalCode"),
    @NamedQuery(name = "Transaction.findByShippingAddressEmail", query = "SELECT t FROM Transaction t WHERE t.shippingAddressEmail = :shippingAddressEmail"),
    @NamedQuery(name = "Transaction.findByShippingAddressPhone", query = "SELECT t FROM Transaction t WHERE t.shippingAddressPhone = :shippingAddressPhone"),
    @NamedQuery(name = "Transaction.findByShippingAddressFax", query = "SELECT t FROM Transaction t WHERE t.shippingAddressFax = :shippingAddressFax"),
    @NamedQuery(name = "Transaction.findByTransactionOrder", query = "SELECT t FROM Transaction t WHERE t.transactionOrder = :transactionOrder"),
    @NamedQuery(name = "Transaction.findByTransactionOrderStatus", query = "SELECT t FROM Transaction t WHERE t.transactionOrderStatus = :transactionOrderStatus")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @Size(max = 450)
    @Column(name = "access_code")
    private String accessCode;
    @Size(max = 45)
    @Column(name = "transaction_authorisation_code")
    private String transactionAuthorisationCode;
    @Size(max = 45)
    @Column(name = "transaction_response_code")
    private String transactionResponseCode;
    @Size(max = 45)
    @Column(name = "transaction_response_message")
    private String transactionResponseMessage;
    @Size(max = 45)
    @Column(name = "transaction_invoice_number")
    private String transactionInvoiceNumber;
    @Size(max = 45)
    @Column(name = "transaction_invoice_reference")
    private String transactionInvoiceReference;
    @Size(max = 45)
    @Column(name = "transaction_total_amount")
    private String transactionTotalAmount;
    @Size(max = 45)
    @Column(name = "transaction_transactionID")
    private String transactiontransactionID;
    @Size(max = 45)
    @Column(name = "transaction_status")
    private String transactionStatus;
    @Size(max = 45)
    @Column(name = "transaction_token_customer_id")
    private String transactionTokenCustomerId;
    @Size(max = 45)
    @Column(name = "transaction_beagle_score")
    private String transactionBeagleScore;
    @Size(max = 450)
    @Column(name = "transaction_options")
    private String transactionOptions;
    @Size(max = 45)
    @Column(name = "verification_cvn")
    private String verificationCvn;
    @Size(max = 45)
    @Column(name = "verification_address")
    private String verificationAddress;
    @Size(max = 45)
    @Column(name = "verification_email")
    private String verificationEmail;
    @Size(max = 45)
    @Column(name = "verification_mobile")
    private String verificationMobile;
    @Size(max = 45)
    @Column(name = "verification_phone")
    private String verificationPhone;
    @Size(max = 45)
    @Column(name = "beagle_verification_email")
    private String beagleVerificationEmail;
    @Size(max = 45)
    @Column(name = "beagle_verification_phone")
    private String beagleVerificationPhone;
    @Size(max = 45)
    @Column(name = "customer_token_customer_id")
    private String customerTokenCustomerId;
    @Size(max = 45)
    @Column(name = "customer_reference")
    private String customerReference;
    @Size(max = 45)
    @Column(name = "customer_title")
    private String customerTitle;
    @Size(max = 45)
    @Column(name = "customer_first_name")
    private String customerFirstName;
    @Size(max = 45)
    @Column(name = "customer_last_name")
    private String customerLastName;
    @Size(max = 45)
    @Column(name = "customer_company_name")
    private String customerCompanyName;
    @Size(max = 45)
    @Column(name = "customer_job_description")
    private String customerJobDescription;
    @Size(max = 45)
    @Column(name = "customer_street1")
    private String customerStreet1;
    @Size(max = 45)
    @Column(name = "customer_street2")
    private String customerStreet2;
    @Size(max = 45)
    @Column(name = "customer_city")
    private String customerCity;
    @Size(max = 45)
    @Column(name = "customer_state")
    private String customerState;
    @Size(max = 45)
    @Column(name = "customer_postal_code")
    private String customerPostalCode;
    @Size(max = 45)
    @Column(name = "customer_country")
    private String customerCountry;
    @Size(max = 45)
    @Column(name = "customer_email")
    private String customerEmail;
    @Size(max = 45)
    @Column(name = "customer_phone")
    private String customerPhone;
    @Size(max = 45)
    @Column(name = "customer_mobile")
    private String customerMobile;
    @Size(max = 45)
    @Column(name = "customer_comments")
    private String customerComments;
    @Size(max = 45)
    @Column(name = "customer_fax")
    private String customerFax;
    @Size(max = 45)
    @Column(name = "customer_url")
    private String customerUrl;
    @Size(max = 4500)
    @Column(name = "customer_note")
    private String customerNote;
    @Size(max = 45)
    @Column(name = "shipping_address_shipping_method")
    private String shippingAddressShippingMethod;
    @Size(max = 45)
    @Column(name = "shipping_address_first_name")
    private String shippingAddressFirstName;
    @Size(max = 45)
    @Column(name = "shipping_address_last_name")
    private String shippingAddressLastName;
    @Size(max = 45)
    @Column(name = "shipping_address_street1")
    private String shippingAddressStreet1;
    @Size(max = 45)
    @Column(name = "shipping_address_street2")
    private String shippingAddressStreet2;
    @Size(max = 45)
    @Column(name = "shipping_address_city")
    private String shippingAddressCity;
    @Size(max = 45)
    @Column(name = "shipping_address_state")
    private String shippingAddressState;
    @Size(max = 45)
    @Column(name = "shipping_address_country")
    private String shippingAddressCountry;
    @Size(max = 45)
    @Column(name = "shipping_address_postal_code")
    private String shippingAddressPostalCode;
    @Size(max = 45)
    @Column(name = "shipping_address_email")
    private String shippingAddressEmail;
    @Size(max = 45)
    @Column(name = "shipping_address_phone")
    private String shippingAddressPhone;
    @Size(max = 45)
    @Column(name = "shipping_address_fax")
    private String shippingAddressFax;
    @Column(name = "transaction_order")
    private Integer transactionOrder;
    @Column(name = "transaction_order_status")
    private Integer transactionOrderStatus;
    @Transient 
    private Order salesOrder;

    public Transaction() {
    }

    public Transaction(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getTransactionAuthorisationCode() {
        return transactionAuthorisationCode;
    }

    public void setTransactionAuthorisationCode(String transactionAuthorisationCode) {
        this.transactionAuthorisationCode = transactionAuthorisationCode;
    }

    public String getTransactionResponseCode() {
        return transactionResponseCode;
    }

    public void setTransactionResponseCode(String transactionResponseCode) {
        this.transactionResponseCode = transactionResponseCode;
    }

    public String getTransactionResponseMessage() {
        return transactionResponseMessage;
    }

    public void setTransactionResponseMessage(String transactionResponseMessage) {
        this.transactionResponseMessage = transactionResponseMessage;
    }

    public String getTransactionInvoiceNumber() {
        return transactionInvoiceNumber;
    }

    public void setTransactionInvoiceNumber(String transactionInvoiceNumber) {
        this.transactionInvoiceNumber = transactionInvoiceNumber;
    }

    public String getTransactionInvoiceReference() {
        return transactionInvoiceReference;
    }

    public void setTransactionInvoiceReference(String transactionInvoiceReference) {
        this.transactionInvoiceReference = transactionInvoiceReference;
    }

    public String getTransactionTotalAmount() {
        return transactionTotalAmount;
    }

    public void setTransactionTotalAmount(String transactionTotalAmount) {
        this.transactionTotalAmount = transactionTotalAmount;
    }

    public String getTransactiontransactionID() {
        return transactiontransactionID;
    }

    public void setTransactiontransactionID(String transactiontransactionID) {
        this.transactiontransactionID = transactiontransactionID;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionTokenCustomerId() {
        return transactionTokenCustomerId;
    }

    public void setTransactionTokenCustomerId(String transactionTokenCustomerId) {
        this.transactionTokenCustomerId = transactionTokenCustomerId;
    }

    public String getTransactionBeagleScore() {
        return transactionBeagleScore;
    }

    public void setTransactionBeagleScore(String transactionBeagleScore) {
        this.transactionBeagleScore = transactionBeagleScore;
    }

    public String getTransactionOptions() {
        return transactionOptions;
    }

    public void setTransactionOptions(String transactionOptions) {
        this.transactionOptions = transactionOptions;
    }

    public String getVerificationCvn() {
        return verificationCvn;
    }

    public void setVerificationCvn(String verificationCvn) {
        this.verificationCvn = verificationCvn;
    }

    public String getVerificationAddress() {
        return verificationAddress;
    }

    public void setVerificationAddress(String verificationAddress) {
        this.verificationAddress = verificationAddress;
    }

    public String getVerificationEmail() {
        return verificationEmail;
    }

    public void setVerificationEmail(String verificationEmail) {
        this.verificationEmail = verificationEmail;
    }

    public String getVerificationMobile() {
        return verificationMobile;
    }

    public void setVerificationMobile(String verificationMobile) {
        this.verificationMobile = verificationMobile;
    }

    public String getVerificationPhone() {
        return verificationPhone;
    }

    public void setVerificationPhone(String verificationPhone) {
        this.verificationPhone = verificationPhone;
    }

    public String getBeagleVerificationEmail() {
        return beagleVerificationEmail;
    }

    public void setBeagleVerificationEmail(String beagleVerificationEmail) {
        this.beagleVerificationEmail = beagleVerificationEmail;
    }

    public String getBeagleVerificationPhone() {
        return beagleVerificationPhone;
    }

    public void setBeagleVerificationPhone(String beagleVerificationPhone) {
        this.beagleVerificationPhone = beagleVerificationPhone;
    }

    public String getCustomerTokenCustomerId() {
        return customerTokenCustomerId;
    }

    public void setCustomerTokenCustomerId(String customerTokenCustomerId) {
        this.customerTokenCustomerId = customerTokenCustomerId;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerCompanyName() {
        return customerCompanyName;
    }

    public void setCustomerCompanyName(String customerCompanyName) {
        this.customerCompanyName = customerCompanyName;
    }

    public String getCustomerJobDescription() {
        return customerJobDescription;
    }

    public void setCustomerJobDescription(String customerJobDescription) {
        this.customerJobDescription = customerJobDescription;
    }

    public String getCustomerStreet1() {
        return customerStreet1;
    }

    public void setCustomerStreet1(String customerStreet1) {
        this.customerStreet1 = customerStreet1;
    }

    public String getCustomerStreet2() {
        return customerStreet2;
    }

    public void setCustomerStreet2(String customerStreet2) {
        this.customerStreet2 = customerStreet2;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerPostalCode() {
        return customerPostalCode;
    }

    public void setCustomerPostalCode(String customerPostalCode) {
        this.customerPostalCode = customerPostalCode;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerComments() {
        return customerComments;
    }

    public void setCustomerComments(String customerComments) {
        this.customerComments = customerComments;
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }

    public void setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public String getShippingAddressShippingMethod() {
        return shippingAddressShippingMethod;
    }

    public void setShippingAddressShippingMethod(String shippingAddressShippingMethod) {
        this.shippingAddressShippingMethod = shippingAddressShippingMethod;
    }

    public String getShippingAddressFirstName() {
        return shippingAddressFirstName;
    }

    public void setShippingAddressFirstName(String shippingAddressFirstName) {
        this.shippingAddressFirstName = shippingAddressFirstName;
    }

    public String getShippingAddressLastName() {
        return shippingAddressLastName;
    }

    public void setShippingAddressLastName(String shippingAddressLastName) {
        this.shippingAddressLastName = shippingAddressLastName;
    }

    public String getShippingAddressStreet1() {
        return shippingAddressStreet1;
    }

    public void setShippingAddressStreet1(String shippingAddressStreet1) {
        this.shippingAddressStreet1 = shippingAddressStreet1;
    }

    public String getShippingAddressStreet2() {
        return shippingAddressStreet2;
    }

    public void setShippingAddressStreet2(String shippingAddressStreet2) {
        this.shippingAddressStreet2 = shippingAddressStreet2;
    }

    public String getShippingAddressCity() {
        return shippingAddressCity;
    }

    public void setShippingAddressCity(String shippingAddressCity) {
        this.shippingAddressCity = shippingAddressCity;
    }

    public String getShippingAddressState() {
        return shippingAddressState;
    }

    public void setShippingAddressState(String shippingAddressState) {
        this.shippingAddressState = shippingAddressState;
    }

    public String getShippingAddressCountry() {
        return shippingAddressCountry;
    }

    public void setShippingAddressCountry(String shippingAddressCountry) {
        this.shippingAddressCountry = shippingAddressCountry;
    }

    public String getShippingAddressPostalCode() {
        return shippingAddressPostalCode;
    }

    public void setShippingAddressPostalCode(String shippingAddressPostalCode) {
        this.shippingAddressPostalCode = shippingAddressPostalCode;
    }

    public String getShippingAddressEmail() {
        return shippingAddressEmail;
    }

    public void setShippingAddressEmail(String shippingAddressEmail) {
        this.shippingAddressEmail = shippingAddressEmail;
    }

    public String getShippingAddressPhone() {
        return shippingAddressPhone;
    }

    public void setShippingAddressPhone(String shippingAddressPhone) {
        this.shippingAddressPhone = shippingAddressPhone;
    }

    public String getShippingAddressFax() {
        return shippingAddressFax;
    }

    public void setShippingAddressFax(String shippingAddressFax) {
        this.shippingAddressFax = shippingAddressFax;
    }

    public Integer getTransactionOrder() {
        return transactionOrder;
    }

    public void setTransactionOrder(Integer transactionOrder) {
        this.transactionOrder = transactionOrder;
    }

    public Integer getTransactionOrderStatus() {
        return transactionOrderStatus;
    }

    public void setTransactionOrderStatus(Integer transactionOrderStatus) {
        this.transactionOrderStatus = transactionOrderStatus;
    }

    public Order getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(Order salesOrder) {
        this.salesOrder = salesOrder;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.itfox.entity.Transaction[ transactionId=" + transactionId + " ]";
    }
    
}
