package cloudapp.service;

import cloudapp.entity.Theatre;
import cloudapp.jpa.TheatreRepository;
import cloudapp.utils.TheatreUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;


    public void saveAll() {

        for (int i = 0; i < 100; i++) {
            for (Theatre theatre : TheatreUtil.getTheatres()) {
                theatreRepository.save(theatre);
            }
        }
    }

}
