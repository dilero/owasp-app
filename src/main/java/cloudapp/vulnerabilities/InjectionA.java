package cloudapp.vulnerabilities;

import cloudapp.attacks.LongActingUpdate;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class InjectionA extends LongActingUpdate {
    public InjectionA(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }

}
