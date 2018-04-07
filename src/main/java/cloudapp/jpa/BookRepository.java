package cloudapp.jpa;

import cloudapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by z003k81p on 4/4/2018.
 */
public interface GreetingRepository extends JpaRepository<Book, Long> {

}
