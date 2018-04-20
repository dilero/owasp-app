package cloudapp.regulars;

import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import org.springframework.stereotype.Service;

public interface IRequest {
    Operation go(Operation operation) throws Exception;

    OperationBase getBase();

}
