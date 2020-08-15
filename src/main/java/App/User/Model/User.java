package App.User.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class

public class User {

    //go to localhost:8080/h2-console to access h2 database.
    //Put this in the JDBC URL: jdbc:h2:mem:testdb
    //username: sa, no password

    @Id
//    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //use identity so h2 auto increment properly from data.sql
    private Long id;
    private String firstName;
    private String lastName;

    public User() {
    }
    public User(long id, String firstName, String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
