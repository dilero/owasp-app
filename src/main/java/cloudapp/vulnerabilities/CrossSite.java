package cloudapp.vulnerabilities;

import cloudapp.attacks.ShortConnect;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrossSite extends ShortConnect {
    @Autowired
    public CrossSite(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}