package br.com.itfox.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-15T22:57:54")
@StaticMetamodel(Log.class)
public class Log_ { 

    public static volatile SingularAttribute<Log, Date> date;
    public static volatile SingularAttribute<Log, byte[]> log;
    public static volatile SingularAttribute<Log, String> name;
    public static volatile SingularAttribute<Log, String> description;
    public static volatile SingularAttribute<Log, Integer> logId;

}