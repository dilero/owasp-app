package cloudapp.controller;

import cloudapp.entity.Book;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationType;
import cloudapp.service.OperationService;
import cloudapp.utils.OperationParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class OperationController {

    @Autowired
    private OperationService operationService;


    @RequestMapping("/operation")
    public void greeting(@RequestParam(value = "types") String types) {
        List<OperationType> operationList = OperationParser.getOperationList(types);

    }


}
