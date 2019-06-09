# Entity
## Entity class
Entity class has following characteristics.
* Most important object in JPA with persistence.
* Each entity must have identifier like a primary key to identify each record.
  * The identifier distinguishes instance of the entity.
  * **@Id** annotation is to set identifier.
* An instance of an entity class is a target of saving to table in database.
* Using **EntityManager**, an instance of an entity class is saved and queried.
* Name of an entity class will be name of table by default.
  * **@Table** annotation can be used, when need to set name of table directly.

## Config Entity

### By @Entity annotation
Put the annotation "**@Entity**" on a class that to be an entity.

###### annotation example1
```
import javax.persistence.Entity;

@Entity
public class Room {
  ...
}

```

###### annotation example2 - with @Table annotation

```

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "root_info")
public class Room {
  ...
}

```

#### @Basic
The use of the Basic annotation is optional for persistent fields and properties of these types.
if the **@Basic** annotation is not specified, then default **@Basic** annotation will apply.

##### properties
* fetch (* optional): the value of the field should be lazily loaded or eagerly loaded.
* optional (* optional): the value of the field allow being nullable.

#### @Id
According to [java persistence api](https://docs.oracle.com/javaee/7/api/javax/persistence/Id.html), **@Id** annotation specifies the primary key of an entity. And can be applied to following types.
* Primitive type
* Primitive wrapper type
* String
* Date (java.util.Date)
* Date (java.sql.Date)
* BigDecimal
* BigInteger

#### @GeneratedValue
**@GeneratedValue** annotation provides for the speicification of generation strategies for the values of primary keys.
And applied to
* primary key property or field of an entity or mapped super-class.


#### @Temporal
Not support date type of java8, but with hibernate 5.2 we can use date type of java8.

But with hibernate 5.1, need to add a dependancy like below.

##### Add hibernate-java8
```
<dependancy>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-java8</artifactId>
  <version>5.1.0.Final</version>
</dependancy>
```

#### @Enumerated
Better using `EnumType.String`


#### @Column

### By XML







## Notes
### @Table annotation
* it also has catalog and schema attribute
  * catalog: In MYSQL, catalog is data dictionary, which is meta data.
    *
  * schema: In Oracle, schema is a collection of logical structures of data,
    * [schema of oracle] (https://docs.oracle.com/cd/B19306_01/server.102/b14220/schema.htm)
