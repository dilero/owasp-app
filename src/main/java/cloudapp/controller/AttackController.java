package cloudapp.controller;

import cloudapp.entity.OperationType;
import cloudapp.service.AttackService;
import cloudapp.utils.OperationParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttackController {
    @Autowired
    private AttackService attackService;

    @RequestMapping("/attack")
    public void greeting(@RequestParam(value = "types") String types) {
        List<OperationType> operationList = OperationParser.getOperationList(types);
        for (OperationType operationType : operationList) {
            attackService.save(types, operationType);
        }

    }


}
