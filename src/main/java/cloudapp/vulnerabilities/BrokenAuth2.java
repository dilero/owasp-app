package cloudapp.vulnerabilities;

import cloudapp.attacks.BulkRead;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrokenAuth2 extends BulkRead {
    @Autowired
    public BrokenAuth2(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
