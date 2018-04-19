package cloudapp.vulnerabilities;

import cloudapp.attacks.DeleteAll;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionB extends DeleteAll {

    @Autowired
    public InjectionB(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
