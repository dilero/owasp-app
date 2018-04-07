package cloudapp.service;

import cloudapp.entity.Book;
import cloudapp.jpa.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z003k81p on 4/4/2018.
 */
@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Book save(Book book) {
        return greetingRepository.save(book);
    }

}
