package cloudapp.service;

import cloudapp.cpumetrics.IcCpuMetrics;
import cloudapp.entity.*;
import cloudapp.jpa.OperationRepository;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreConstants;
import cloudapp.utils.TheatreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by z003k81p on 4/4/2018.
 */
@Service
public class OperationService {

    private final OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public Operation preProcess(String types, OperationType operationType) {
        Operation operation = new Operation();
        operation.setStartTime(System.nanoTime());
        operation.setRequestedOperations(types);
        operation.setOperationTime(new Date().getTime());
        operation.setOperationType(operationType);
        operation.setThreadName(Thread.currentThread().getName());
        operation = cpuCalculor(operation);
        return operation;
    }


    public void save(Operation operation) {
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
