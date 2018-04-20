package cloudapp.service;

import cloudapp.cpumetrics.IcCpuMetrics;
import cloudapp.entity.*;
import cloudapp.jpa.OperationRepository;
import cloudapp.jpa.TheatreRepository;
import cloudapp.regulars.*;
import cloudapp.vulnerabilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by z003k81p on 4/4/2018.
 */
@Service
public class OperationService {

    private final OperationRepository operationRepository;
    private final TheatreRepository theatreRepository;

    private final Map<OperationType, IRequest> functionMap = new HashMap<>();

    @Autowired
    public OperationService(OperationRepository operationRepository, TheatreRepository theatreRepository) {
        this.operationRepository = operationRepository;
        this.theatreRepository = theatreRepository;

        buildRequestMap(theatreRepository);
    }

    public void request(List<OperationType> typeList, OperationType operationType) {
        String typeString = "";
        for (OperationType type : typeList) {
            typeString = typeString + functionMap.get(type).getBase().toString() + ";";
        }

        Operation operation = preProcess(typeString, operationType);
        try {
            operation = functionMap.get(operationType).go(operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        save(operation);
    }

    private void buildRequestMap(TheatreRepository theatreRepository) {
        functionMap.put(OperationType.REG_ADD, new Add(theatreRepository));
        functionMap.put(OperationType.REG_DELETE, new Delete(theatreRepository));
        functionMap.put(OperationType.REG_READ, new Read(theatreRepository));
        functionMap.put(OperationType.REG_UPDATE, new Update(theatreRepository));

        functionMap.put(OperationType.BAC, new BrokenAccessControl(theatreRepository));
        functionMap.put(OperationType.BA1, new BrokenAuth1(theatreRepository));
        functionMap.put(OperationType.BA2, new BrokenAuth2(theatreRepository));
        functionMap.put(OperationType.CS, new CrossSite(theatreRepository));
        functionMap.put(OperationType.IA, new InjectionA(theatreRepository));
        functionMap.put(OperationType.IB, new InjectionB(theatreRepository));
        functionMap.put(OperationType.InD, new InsecureDeserilization(theatreRepository));
        functionMap.put(OperationType.InL, new InsufficientLogging(theatreRepository));
        functionMap.put(OperationType.SM, new SecurityMisconfiuration(theatreRepository));
        functionMap.put(OperationType.SD1, new SensitiveData1(theatreRepository));
        functionMap.put(OperationType.SD2, new SensitiveData2(theatreRepository));
        functionMap.put(OperationType.UC, new UsingComponents(theatreRepository));
        functionMap.put(OperationType.XE, new XMLExternal(theatreRepository));
    }

    private Operation preProcess(String types, OperationType operationType) {
        Operation operation = new Operation();
        operation.setStartTime(System.nanoTime());
        operation.setOperationTime(new Date().getTime());
        operation.setOperationType(operationType);
        operation.setRequestedOperations(types);
        operation.setThreadName(Thread.currentThread().getName());
        operation = cpuCalculor(operation);
        return operation;
    }


    private void save(Operation operation) {
        operation = cpuCalculor(operation);
        operation.setEndTime(System.nanoTime());
        long totalTime = operation.getEndTime() - operation.getStartTime();
        operation.setTime(totalTime);
        operationRepository.save(operation);
    }


    private Operation cpuCalculor(Operation operation) {
        IcCpuMetrics.resetHistory(-1l);
        IcCpuMetrics.resetHistory(Thread.currentThread().getId());
        long epoch = System.nanoTime();

        operation.setCurrentThreadCpuRateAmongsLiveHttpThreads(IcCpuMetrics
                .getCurrentThreadCpuRateAmongLiveHttpThreads());

        operation.setCurrentThreadCpuRateSince(IcCpuMetrics
                .getCurrentThreadCpuRateSince(epoch, Runtime.getRuntime().availableProcessors()));
        return operation;
    }

}
