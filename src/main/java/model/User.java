package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data // be aware of that @Data provides equals and hashcode methods, that might cause a problem.
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    public User() {
    }

    public User(String email, String name, Date createdDate) {
        this.email = email;
        this.name = name;
        this.createdDate = createdDate;
    }
}
