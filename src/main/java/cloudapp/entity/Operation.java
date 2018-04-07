package cloudapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private OperationType operationType;
    private OperationBase operationBase;
    private Date operationTime;
    private ClassLabel classLabel;
    private String requestedOperations;

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

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
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
}
