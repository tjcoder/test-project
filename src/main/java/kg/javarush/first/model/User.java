package kg.javarush.first.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 3, max = 25, message = "must be at least 3 characters in length")
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    @Column(name = "isadmin", columnDefinition="BIT")
    private boolean isAdmin;

    @Column(name = "createddate", columnDefinition="TIMESTAMP")
    private Timestamp createdDate;

    public User(){}
    public User(int id, String name, Integer age,
                boolean isAdmin, Timestamp createdDate) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean getIsAdmin() {
        return isAdmin();
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public String getFormattedDate()
    {
        Date dNow = new Date(getCreatedDate().getTime());
        SimpleDateFormat ft = new SimpleDateFormat("E dd-MM-yyyy 'at' hh:mm:ss a");

        return ft.format(dNow);
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
