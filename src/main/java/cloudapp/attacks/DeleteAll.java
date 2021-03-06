package cloudapp.attacks;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;
import cloudapp.regulars.IRequest;
import cloudapp.vulnerabilities.IVulnerability;

import java.util.List;

public abstract class DeleteAll implements IRequest {
    private final TheatreRepository theatreRepository;
    private final IVulnerability vulnerability;

    public DeleteAll(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
        this.vulnerability = new IVulnerability() {
            @Override
            public Operation act(Operation operation) {
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(getBase());
                List<Theatre> all = theatreRepository.findAll();
                if (all.size() > 0) {
                    theatreRepository.deleteAll();
                }

                for (int i = 0; i < 100; i++) {
                    for (Theatre theatre : TheatreUtil.getTheatres()) {
                        theatreRepository.save(theatre);
                    }
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

    @Override
    public OperationBase getBase() {
        return OperationBase.DELETE;
    }
}
