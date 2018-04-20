package cloudapp.regulars;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;

import java.util.List;

public class Update implements IRequest {
    private final TheatreRepository theatreRepository;

    public Update(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Operation go(Operation operation) throws Exception {
        operation.setClassLabel(ClassLabel.REGULAR);
        operation.setOperationBase(getBase());
        List<Theatre> all = theatreRepository.findAll();
        if (all.size() > 0) {
            Theatre theatre = all.get(0);
            theatre.setDescription(TheatreUtil.getRandomDescription());
            theatreRepository.save(theatre);

        }
        return operation;
    }

    @Override
    public OperationBase getBase() {
        return OperationBase.UPDATE;
    }
}
