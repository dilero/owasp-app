package cloudapp.attacks;

import cloudapp.entity.ClassLabel;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationBase;
import cloudapp.jpa.TheatreRepository;
import cloudapp.regulars.IRequest;
import cloudapp.vulnerabilities.IVulnerability;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public abstract class AccessUrl implements IRequest {
    private final TheatreRepository theatreRepository;
    private final IVulnerability vulnerability;

    public AccessUrl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
        this.vulnerability = new IVulnerability() {
            @Override
            public Operation act(Operation operation) throws Exception {
                operation.setClassLabel(ClassLabel.MALICIOUS);
                operation.setOperationBase(getBase());
                URL oracle = new URL("http://www.oracle.com/");
                URLConnection yc = oracle.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        yc.getInputStream()));
                in.close();
                return operation;
            }
        };
    }

    public Operation go(Operation operation) {
        Operation act = operation;
        try {
            act = vulnerability.act(operation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return act;
    }


    public OperationBase getBase() {
        return OperationBase.READ;
    }
}
