package cloudapp.vulnerabilities;

import cloudapp.attacks.BulkRead;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class BrokenAuth2 extends BulkRead {
    public BrokenAuth2(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
