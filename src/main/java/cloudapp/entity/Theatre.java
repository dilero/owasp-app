package cloudapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer perde;
    private Integer duration;
    private Date firstplay;
    private String genre;


    public Theatre() {

    }

    public Theatre(String newName, String newDescription) {
        this.name = newName;
        this.description = newDescription;
    }

    public Theatre(String Name, String Description, Integer Perde,
                   Integer Duration, Date Fistplay, String Genre) {

        this.setName(Name);
        this.setDescription(Description);
        this.setPerde(Perde);
        this.setDuration(Duration);
        this.setFirstplay(Fistplay);
        this.setGenre(Genre);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPerde() {
        return perde;
    }

    public void setPerde(Integer perde) {
        this.perde = perde;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getFirstplay() {
        return firstplay;
    }

    public void setFirstplay(Date firstplay) {
        this.firstplay = firstplay;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }
}
