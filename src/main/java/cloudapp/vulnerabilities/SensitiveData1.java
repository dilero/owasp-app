package cloudapp.vulnerabilities;

import cloudapp.attacks.BulkRead;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensitiveData1 extends BulkRead {
    @Autowired
    public SensitiveData1(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
