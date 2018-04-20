package cloudapp.regulars;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;

public class Add implements IRequest {
    private final TheatreRepository theatreRepository;

    public Add(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Operation go(Operation operation) throws Exception {
        operation.setClassLabel(ClassLabel.REGULAR);
        operation.setOperationBase(getBase());
        Theatre newTheatre = TheatreUtil.getRandomTheatre();
        theatreRepository.save(newTheatre);
        return operation;
    }

    @Override
    public OperationBase getBase() {
        return OperationBase.ADD;
    }
}
