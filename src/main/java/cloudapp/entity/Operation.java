package cloudapp.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by z003k81p on 4/6/2018.
 */
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String threadName;
    private String userName;
    private long time; //duration
    private double currentThreadCpuRateAmongsLiveHttpThreads;
    private double currentThreadCpuRateSince;
    private long startTime;
    private long endTime;
    private long operationTime;
    private String requestedOperations;
    @Enumerated(EnumType.STRING)
    private OperationType vulnerabilityName;
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    @Enumerated(EnumType.STRING)
    private OperationBase operationBase;
    @Enumerated(EnumType.STRING)
    private ClassLabel classLabel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getCurrentThreadCpuRateAmongsLiveHttpThreads() {
        return currentThreadCpuRateAmongsLiveHttpThreads;
    }

    public void setCurrentThreadCpuRateAmongsLiveHttpThreads(double currentThreadCpuRateAmongsLiveHttpThreads) {
        this.currentThreadCpuRateAmongsLiveHttpThreads = currentThreadCpuRateAmongsLiveHttpThreads;
    }

    public double getCurrentThreadCpuRateSince() {
        return currentThreadCpuRateSince;
    }

    public void setCurrentThreadCpuRateSince(double currentThreadCpuRateSince) {
        this.currentThreadCpuRateSince = currentThreadCpuRateSince;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public OperationBase getOperationBase() {
        return operationBase;
    }

    public void setOperationBase(OperationBase operationBase) {
        this.operationBase = operationBase;
    }

    public long getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(long operationTime) {
        this.operationTime = operationTime;
    }

    public ClassLabel getClassLabel() {
        return classLabel;
    }

    public void setClassLabel(ClassLabel classLabel) {
        this.classLabel = classLabel;
    }

    public String getRequestedOperations() {
        return requestedOperations;
    }

    public void setRequestedOperations(String requestedOperations) {
        this.requestedOperations = requestedOperations;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public OperationType getVulnerabilityName() {
        return vulnerabilityName;
    }

    public void setVulnerabilityName(OperationType vulnerabilityName) {
        this.vulnerabilityName = vulnerabilityName;
    }
}
