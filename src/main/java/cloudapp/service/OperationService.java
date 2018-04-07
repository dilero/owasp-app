package cloudapp.service;

import cloudapp.cpumetrics.IcCpuMetrics;
import cloudapp.entity.*;
import cloudapp.jpa.BookRepository;
import cloudapp.jpa.OperationRepository;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreConstants;
import cloudapp.utils.TheatreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by z003k81p on 4/4/2018.
 */
@Transactional
@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private TheatreRepository theatreRepository;

    public void save(String types, OperationType operationType) {
        long startTime = System.nanoTime();
        Operation operation = new Operation();
        operation.setRequestedOperations(types);
        operation.setOperationTime(new Date());
        operation.setOperationType(operationType);
        operation.setThreadName(Thread.currentThread().getName());
        operation = cpuCalculor(operation);

        try {
            actOperation(operationType, operation);
        } catch (Exception e) {

        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        operation.setTime(totalTime);
        operationRepository.save(operation);
    }

    private void actOperation(OperationType operationType, Operation operation) {
        Theatre newTheatre = null;
        List<Theatre> all = null;

        switch (operationType) {
            case REG_ADD:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.ADD);
                newTheatre = TheatreUtil.getRandomTheatre();
                theatreRepository.save(newTheatre);
                operation = cpuCalculor(operation);
                break;


            case MAL_ADD:
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(OperationBase.ADD);
                newTheatre = TheatreUtil.getRandomMalTheatre();
                theatreRepository.save(newTheatre);
                operation = cpuCalculor(operation);
                break;


            case REG_READ:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.READ);
                theatreRepository.findByName("The Shawshank Redemption");
                operation = cpuCalculor(operation);
                break;


            case MAL_READ:
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(OperationBase.READ);
                theatreRepository.findByName(TheatreConstants.malSample1);
                operation = cpuCalculor(operation);
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
                operation = cpuCalculor(operation);
                break;

            case MAL_UPDATE:
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(OperationBase.UPDATE);
                all = theatreRepository.findAll();
                if (all.size() > 0) {
                    Theatre theatre = all.get(0);
                    theatre.setDescription(TheatreUtil.getRandomMalDescription());
                    theatreRepository.save(theatre);

                }
                operation = cpuCalculor(operation);
                break;
            case REG_DELETE:
                operation.setClassLabel(ClassLabel.REGULAR);
                operation.setOperationBase(OperationBase.DELETE);
                all = theatreRepository.findAll();
                if (all.size() > 0) {
                    Theatre theatre = all.get(0);
                    theatreRepository.delete(theatre.getId());
                }
                operation = cpuCalculor(operation);
                break;

            case MAL_DELETE:
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(OperationBase.DELETE);
                all = theatreRepository.findAll();
                if (all.size() > 0) {
                    theatreRepository.deleteAll();
                }

                for (int i = 0; i < 10; i++) {
                    theatreRepository.save(TheatreUtil.getRandomTheatre());
                }
                operation = cpuCalculor(operation);
                break;


            default:
                break;
        }
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
