package cloudapp.service;

import cloudapp.entity.Operation;
import cloudapp.entity.OperationType;
import cloudapp.vulnerabilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AttackService {
    @Autowired
    private BrokenAccessControl brokenAccessControl;
    @Autowired
    private BrokenAuth1 brokenAuth1;
    @Autowired
    private BrokenAuth2 brokenAuth2;
    @Autowired
    private CrossSite crossSite;
    @Autowired
    private InjectionA injectionA;
    @Autowired
    private InjectionB injectionB;
    @Autowired
    private InsecureDeserilization insecureDeserilization;
    @Autowired
    private InsufficientLogging1 insufficientLogging1;
    @Autowired
    private SecurityMisconfiuration securityMisconfiuration;
    @Autowired
    private SensitiveData1 sensitiveData1;
    @Autowired
    private SensitiveData2 sensitiveData2;
    @Autowired
    private UsingComponents usingComponents;
    @Autowired
    private XMLExternal xmlExternal;


    @Autowired
    private OperationService operationService;

    public void save(String types, OperationType operationType) {
        Operation operation = operationService.preProcess(types, operationType);
        operation = attack(operationType, operation);
        operationService.save(operation);
    }


    private Operation attack(OperationType operationType, Operation operation) {

        switch (operationType) {
            case BAC:
                operation = brokenAccessControl.go(operation);
                break;
            case BA1:
                operation = brokenAuth1.go(operation);
                break;
            case BA2:
                operation = brokenAuth2.go(operation);
                break;
            case CS:
                operation = crossSite.go(operation);
                break;
            case IA:
                operation = injectionA.go(operation);
                break;
            case IB:
                operation = injectionB.go(operation);
                break;
            case InD:
                operation = insecureDeserilization.go(operation);
                break;
            case InL:
                operation = insufficientLogging1.go(operation);
                break;
            case SM:
                operation = securityMisconfiuration.go(operation);
                break;
            case SD1:
                operation = sensitiveData1.go(operation);
                break;
            case SD2:
                operation = sensitiveData2.go(operation);
                break;
            case UC:
                operation = usingComponents.go(operation);
                break;
            case XE:
                operation = xmlExternal.go(operation);
                break;
        }

        return operation;
    }


}
