package br.com.itfox.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-20T09:36:44")
@StaticMetamodel(SalesOrderItem.class)
public class SalesOrderItem_ { 

    public static volatile SingularAttribute<SalesOrderItem, Double> productQuantity;
    public static volatile SingularAttribute<SalesOrderItem, Double> productDescount;
    public static volatile SingularAttribute<SalesOrderItem, Integer> productId;
    public static volatile SingularAttribute<SalesOrderItem, String> orderItemStatus;
    public static volatile SingularAttribute<SalesOrderItem, Integer> orderId;
    public static volatile SingularAttribute<SalesOrderItem, Integer> orderItemId;
    public static volatile SingularAttribute<SalesOrderItem, Double> productPrice;
    public static volatile SingularAttribute<SalesOrderItem, Double> productTotal;

}