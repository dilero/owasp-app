package cloudapp.vulnerabilities;

import cloudapp.attacks.ContRead;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityMisconfiuration  extends ContRead{

    @Autowired
    public SecurityMisconfiuration(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
