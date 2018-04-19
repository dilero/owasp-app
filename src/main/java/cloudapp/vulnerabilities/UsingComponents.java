package cloudapp.vulnerabilities;

import cloudapp.attacks.DeleteAll;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsingComponents extends DeleteAll {
    @Autowired
    public UsingComponents(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
