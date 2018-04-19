package cloudapp.attacks;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;
import cloudapp.vulnerabilities.IAttack;
import cloudapp.vulnerabilities.IVulnerability;

public class AddRegular implements IAttack {
    private final TheatreRepository theatreRepository;
    private final IVulnerability vulnerability;

    public AddRegular(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
        this.vulnerability = new IVulnerability() {
            @Override
            public Operation act(Operation operation) {
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.ADD);
                Theatre randomTheatre = TheatreUtil.getRandomTheatre();
                theatreRepository.save(randomTheatre);
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