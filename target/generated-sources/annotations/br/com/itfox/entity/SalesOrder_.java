package br.com.itfox.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-20T09:36:44")
@StaticMetamodel(SalesOrder.class)
public class SalesOrder_ { 

    public static volatile SingularAttribute<SalesOrder, String> clientId;
    public static volatile SingularAttribute<SalesOrder, Integer> orderId;
    public static volatile SingularAttribute<SalesOrder, String> session;
    public static volatile SingularAttribute<SalesOrder, String> ip;
    public static volatile SingularAttribute<SalesOrder, String> description;
    public static volatile SingularAttribute<SalesOrder, String> orderStatus;
    public static volatile SingularAttribute<SalesOrder, Date> orderDate;

}