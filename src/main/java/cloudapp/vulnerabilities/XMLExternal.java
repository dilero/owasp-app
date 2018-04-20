package cloudapp.vulnerabilities;

import cloudapp.attacks.AccessUrl;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class XMLExternal extends AccessUrl {
    public XMLExternal(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }
}
