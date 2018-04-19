package cloudapp.vulnerabilities;

import cloudapp.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public interface IAttack {
    Operation go(Operation operation) throws Exception;

}
