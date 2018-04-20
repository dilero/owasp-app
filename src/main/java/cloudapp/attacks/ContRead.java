package cloudapp.attacks;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;
import cloudapp.regulars.IRequest;
import cloudapp.vulnerabilities.IVulnerability;

public abstract class ContRead implements IRequest {
    private final TheatreRepository theatreRepository;
    private final IVulnerability vulnerability;

    public ContRead(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
        this.vulnerability = new IVulnerability() {
            @Override
            public Operation act(Operation operation) {
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(getBase());

                for (int i = 0; i < 100; i++) {
                    theatreRepository.findByName(TheatreUtil.ANY_NAME);
                }

                return operation;
            }
        };
    }

    public Operation go(Operation operation) {
        Operation act = operation;
        try {
            act = vulnerability.act(operation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return act;
    }

    public OperationBase getBase() {
        return OperationBase.READ;
    }
}
