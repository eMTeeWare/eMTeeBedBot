package net.emteeware.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by MThomas on 28.03.2016.
 * (c) eMTeeWare 2016
 */
@Slf4j
@Service
public class EmteeBedBotService {

    public void runMainLoop() {
        while(true) {
            log.info("running main loop");
            try {
                Thread.sleep(1000 * 60 * 5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
