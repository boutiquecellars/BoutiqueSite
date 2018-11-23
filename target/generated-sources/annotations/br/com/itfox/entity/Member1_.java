package br.com.itfox.entity;

import br.com.itfox.entity.Areaoper;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-20T09:36:44")
@StaticMetamodel(Member1.class)
public class Member1_ { 

    public static volatile SingularAttribute<Member1, Date> date;
    public static volatile CollectionAttribute<Member1, Areaoper> areaoperCollection;
    public static volatile SingularAttribute<Member1, String> pass;
    public static volatile SingularAttribute<Member1, String> terms;
    public static volatile SingularAttribute<Member1, String> name;
    public static volatile SingularAttribute<Member1, Date> regdate;
    public static volatile SingularAttribute<Member1, String> permission;
    public static volatile SingularAttribute<Member1, String> email;
    public static volatile SingularAttribute<Member1, Integer> memberId;

}