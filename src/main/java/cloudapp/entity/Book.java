package cloudapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by z003k81p on 4/4/2018.
 */
@Entity
public class Book {

    @Id
    private Long id;
    private String name;

    public Book() {

    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
