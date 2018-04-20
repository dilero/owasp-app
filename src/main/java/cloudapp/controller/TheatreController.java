package cloudapp.controller;

import cloudapp.entity.OperationType;
import cloudapp.service.TheatreService;
import cloudapp.utils.OperationParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;


    @RequestMapping("/theatre")
    public void saveTheatres() {
        theatreService.saveAll();

    }


}
