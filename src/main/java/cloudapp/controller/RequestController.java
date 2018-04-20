package cloudapp.controller;

import cloudapp.entity.OperationType;
import cloudapp.service.OperationService;
import cloudapp.utils.OperationParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestController {
    @Autowired
    private OperationService operationService;

    @RequestMapping("/request")
    public void greeting(@RequestParam(value = "types") String types) {
        List<OperationType> operationList = OperationParser.getOperationList(types);
        for (OperationType operationType : operationList) {
            operationService.request(operationList, operationType);
        }

    }


}
