package cloudapp.vulnerabilities;

import cloudapp.attacks.AccessUrl;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XMLExternal extends AccessUrl {

    @Autowired
    public XMLExternal(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
