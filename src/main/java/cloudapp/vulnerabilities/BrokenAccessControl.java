package cloudapp.vulnerabilities;

import cloudapp.attacks.AddBigContent;
import cloudapp.attacks.ContRead;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationType;
import cloudapp.jpa.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
public class BrokenAccessControl extends ContRead {

    public BrokenAccessControl(TheatreRepository theatreRepository) {
        super(theatreRepository);
    }


    @Override
    public Operation go(Operation operation) {
        return super.go(operation);

    }
}
