package cloudapp.vulnerabilities;

import cloudapp.attacks.AddRegular;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsecureDeserilization extends AddRegular {
    @Autowired
    public InsecureDeserilization(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
