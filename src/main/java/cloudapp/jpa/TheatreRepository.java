package cloudapp.jpa;

import cloudapp.entity.Book;
import cloudapp.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by z003k81p on 4/4/2018.
 */
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    public Theatre findByName(String name);

}
