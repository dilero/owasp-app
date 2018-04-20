package cloudapp.regulars;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;

public class Read implements IRequest {
    private final TheatreRepository theatreRepository;

    public Read(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Operation go(Operation operation) throws Exception {
        operation.setClassLabel(ClassLabel.REGULAR);
        operation.setOperationBase(getBase());
        theatreRepository.findByName(TheatreUtil.ANY_NAME);
        return operation;
    }
    @Override
    public OperationBase getBase() {
        return OperationBase.READ;
    }

}
