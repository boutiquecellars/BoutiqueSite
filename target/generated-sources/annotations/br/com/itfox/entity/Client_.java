package br.com.itfox.entity;

import br.com.itfox.entity.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-15T22:57:54")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> lastName;
    public static volatile SingularAttribute<Client, Integer> clientId;
    public static volatile SingularAttribute<Client, String> companyName;
    public static volatile SingularAttribute<Client, String> streetAddress1;
    public static volatile SingularAttribute<Client, String> postcode;
    public static volatile SingularAttribute<Client, String> contactPerson;
    public static volatile SingularAttribute<Client, String> streetAddress2;
    public static volatile SingularAttribute<Client, String> firstName;
    public static volatile SingularAttribute<Client, Integer> sameAsDelivery;
    public static volatile SingularAttribute<Client, String> phone;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, String> suburb;
    public static volatile SingularAttribute<Client, Address> shippingAddress;
    public static volatile SingularAttribute<Client, String> state;
    public static volatile SingularAttribute<Client, Address> billingAddress;
    public static volatile SingularAttribute<Client, String> dateBirth;
    public static volatile SingularAttribute<Client, String> email;

}