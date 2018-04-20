package cloudapp.service;

import cloudapp.entity.Operation;
import cloudapp.entity.OperationType;
import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;
import cloudapp.vulnerabilities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class TheatreService {
    private final TheatreRepository theatreRepository;


    @Autowired
    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }


    public void saveAll() {

        for (int i = 0; i < 100; i++) {
            for (Theatre theatre : TheatreUtil.getTheatres()) {
                theatreRepository.save(theatre);
            }
        }
    }

}
