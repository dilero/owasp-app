package cloudapp.vulnerabilities;

import cloudapp.attacks.LongActingUpdate;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InjectionA extends LongActingUpdate {

    @Autowired
    public InjectionA(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }

}
