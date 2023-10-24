package entity;

import entity.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-16T09:15:01")
@StaticMetamodel(Programme.class)
public class Programme_ { 

    public static volatile SingularAttribute<Programme, String> code;
    public static volatile SingularAttribute<Programme, String> progname;
    public static volatile ListAttribute<Programme, Student> studentList;
    public static volatile SingularAttribute<Programme, String> faculty;

}