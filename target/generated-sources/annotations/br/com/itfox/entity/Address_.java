package br.com.itfox.entity;

import br.com.itfox.entity.Client;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-15T22:57:54")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> postalCode;
    public static volatile CollectionAttribute<Address, Client> clientCollection1;
    public static volatile SingularAttribute<Address, String> modifiedDate;
    public static volatile SingularAttribute<Address, String> addressLine1;
    public static volatile SingularAttribute<Address, String> suburb;
    public static volatile CollectionAttribute<Address, Client> clientCollection;
    public static volatile SingularAttribute<Address, String> addressLine2;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, Integer> addressId;

}