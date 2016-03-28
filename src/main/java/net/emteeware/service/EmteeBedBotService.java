package net.emteeware.service;

import lombok.extern.slf4j.Slf4j;
import net.emteeware.model.DueUsers;
import net.emteeware.model.MonitoredUsers;
import net.emteeware.model.UserUpdates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MThomas on 28.03.2016.
 * (c) eMTeeWare 2016
 */
@Slf4j
@Service
public class EmteeBedBotService {

    private UserUpdates userUpdates;
    private MonitoredUsers monitoredUsers;
    private DueUsers dueUsers;

    @Autowired
    TwitterService twitterService;

    @Autowired
    UserService userService;



    public void runMainLoop() {
        while(true) {
            log.info("running main loop");
            userUpdates = twitterService.getUserUpdates();
            userService.updateUsers(userUpdates);
            monitoredUsers = userService.getUsersToMonitor();
            dueUsers = twitterService.checkMonitoredUsers(monitoredUsers);
            twitterService.sendDueUsersToBed(dueUsers);
            try {
                Thread.sleep(1000 * 60 * 5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
