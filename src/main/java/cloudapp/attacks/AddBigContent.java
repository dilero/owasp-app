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

public abstract class AddBigContent implements IAttack {
    private final TheatreRepository theatreRepository;
    private final IVulnerability vulnerability;

    public AddBigContent(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
        this.vulnerability = new IVulnerability() {
            @Override
            public Operation act(Operation operation) {
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(OperationBase.ADD);
                Theatre randomMalTheatre = TheatreUtil.getRandomMalTheatre();
                theatreRepository.save(randomMalTheatre);
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