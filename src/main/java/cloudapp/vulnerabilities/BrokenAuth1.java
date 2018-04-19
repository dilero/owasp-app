package cloudapp.vulnerabilities;

import cloudapp.attacks.ContRead;
import cloudapp.entity.OperationType;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokenAuth1 extends ContRead {

    @Autowired
    public BrokenAuth1(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
