package cloudapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer perde;
    private Integer duration;
    private Date firstPlay;
    private String genre;

    private List<Integer> cast;

    public Theatre() {

    }

    public Theatre(String newName, String newDescription,
                   List<Integer> newCast) {
        this.name = newName;
        this.description = newDescription;
        this.cast = newCast;// new LinkedList<Artist>();
    }

    public Theatre(String Name, String Description, Integer Perde,
                   Integer Duration, Date Fistplay, String Genre,
                   List<Integer> castlist) {

        this.setName(Name);
        this.setDescription(Description);
        this.setPerde(Perde);
        this.setDuration(Duration);
        this.setFirstPlay(Fistplay);
        this.setGenre(Genre);
        this.setCast(castlist);

    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public String getDescription() {
        return this.description;
    }

    public void addPeopleToCast(Integer newArtist) {
        this.cast.add(newArtist);
    }

    public List<Integer> getCast() {
        return cast;
    }

    public void setCast(List<Integer> cast) {
        this.cast = cast;
    }

    public long getId() {
        return id;
    }
    
    public Date getFirstPlay() {
        return firstPlay;
    }

    public void setFirstPlay(Date firstPlay) {
        this.firstPlay = firstPlay;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}