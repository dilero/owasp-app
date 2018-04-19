package cloudapp.vulnerabilities;

import cloudapp.attacks.ContRead;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensitiveData2 extends ContRead {
    @Autowired
    public SensitiveData2(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
