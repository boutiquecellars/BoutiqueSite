package br.com.itfox.entity;

import br.com.itfox.entity.EmailMktCartPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-20T09:36:44")
@StaticMetamodel(EmailMktCart.class)
public class EmailMktCart_ { 

    public static volatile SingularAttribute<EmailMktCart, Date> date;
    public static volatile SingularAttribute<EmailMktCart, Float> total;
    public static volatile SingularAttribute<EmailMktCart, Float> quantity;
    public static volatile SingularAttribute<EmailMktCart, Float> price;
    public static volatile SingularAttribute<EmailMktCart, EmailMktCartPK> emailMktCartPK;
    public static volatile SingularAttribute<EmailMktCart, String> status;

}