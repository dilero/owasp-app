package cloudapp.vulnerabilities;

import cloudapp.attacks.ContRead;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class SensitiveData2 extends ContRead {
    public SensitiveData2(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
