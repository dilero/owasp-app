package cloudapp.attacks;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;
import cloudapp.vulnerabilities.IAttack;
import cloudapp.vulnerabilities.IVulnerability;

import java.io.IOException;
import java.util.List;

public class ShortConnect implements IAttack {
    private final TheatreRepository theatreRepository;
    private final IVulnerability vulnerability;


    public ShortConnect(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
        this.vulnerability = new IVulnerability() {
            @Override
            public Operation act(Operation operation) {
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(OperationBase.READ);
                theatreRepository.flush();
                return operation;
            }
        };
    }

    public Operation go(Operation operation) {
        Operation act = null;
        try {
            act = vulnerability.act(operation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return act;
    }
}
