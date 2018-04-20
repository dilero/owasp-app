package cloudapp.vulnerabilities;

import cloudapp.attacks.AddRegular;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class InsecureDeserilization extends AddRegular {
    public InsecureDeserilization(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
