package cloudapp.regulars;

import cloudapp.entity.Operation;
import org.springframework.stereotype.Service;

@FunctionalInterface
public interface IRequest {
    Operation go(Operation operation) throws Exception;

}
