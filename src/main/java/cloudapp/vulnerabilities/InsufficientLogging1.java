package cloudapp.vulnerabilities;

import cloudapp.attacks.DeleteAll;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsufficientLogging1 extends DeleteAll {

    @Autowired
    public InsufficientLogging1(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
