package cloudapp.controller;

import cloudapp.entity.Book;
import cloudapp.entity.Operation;
import cloudapp.entity.OperationType;
import cloudapp.jpa.TheatreRepository;
import cloudapp.service.OperationService;
import cloudapp.service.RegularOperationService;
import cloudapp.service.TheatreService;
import cloudapp.utils.OperationParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RegularOperationController {

    @Autowired
    private RegularOperationService regularOperationService;
    @Autowired
    private TheatreService theatreService;


    @RequestMapping("/regular")
    public void greeting(@RequestParam(value = "types") String types) {
        List<OperationType> operationList = OperationParser.getOperationList(types);
        for (OperationType operationType : operationList) {
            regularOperationService.save(types, operationType);
        }

    }

    @RequestMapping("/theatre")
    public void saveTheatres() {
        theatreService.saveAll();

    }


}
