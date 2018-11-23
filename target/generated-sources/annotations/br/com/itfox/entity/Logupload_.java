package br.com.itfox.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-20T09:36:44")
@StaticMetamodel(Logupload.class)
public class Logupload_ { 

    public static volatile SingularAttribute<Logupload, Date> date;
    public static volatile SingularAttribute<Logupload, String> path;
    public static volatile SingularAttribute<Logupload, String> filename;
    public static volatile SingularAttribute<Logupload, Integer> loguploadId;
    public static volatile SingularAttribute<Logupload, byte[]> description;
    public static volatile SingularAttribute<Logupload, String> status;

}