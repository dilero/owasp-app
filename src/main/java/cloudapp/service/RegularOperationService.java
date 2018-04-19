package cloudapp.service;

import cloudapp.entity.*;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreConstants;
import cloudapp.utils.TheatreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularOperationService {

    private final OperationService operationService;
    private final TheatreRepository theatreRepository;


    @Autowired
    public RegularOperationService(TheatreRepository theatreRepository, OperationService operationService) {
        this.operationService = operationService;
        this.theatreRepository = theatreRepository;
    }

    public void save(String types, OperationType operationType) {
        Operation operation = operationService.preProcess(types, operationType);
        operation = actOperation(operationType, operation);
        operationService.save(operation);

    }

    private Operation actOperation(OperationType operationType, Operation operation) {
        Theatre newTheatre = null;
        List<Theatre> all = null;

        switch (operationType) {
            case REG_ADD:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.ADD);
                newTheatre = TheatreUtil.getRandomTheatre();
                theatreRepository.save(newTheatre);
                break;

            case REG_READ:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.READ);
                theatreRepository.findByName(TheatreUtil.ANY_NAME);
                break;

            case REG_UPDATE:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.UPDATE);
                all = theatreRepository.findAll();
                if (all.size() > 0) {
                    Theatre theatre = all.get(0);
                    theatre.setDescription(TheatreUtil.getRandomDescription());
                    theatreRepository.save(theatre);

                }
                break;

            case REG_DELETE:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.DELETE);
                all = theatreRepository.findAll();
                if (all.size() > 0) {
                    Theatre theatre = all.get(0);
                    theatreRepository.deleteById(theatre.getId());
                }
                break;
            default:
                break;
        }

        return operation;
    }
}
