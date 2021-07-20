package pl.indexpz.charity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class DataSetup {

    private static final Logger logger = LoggerFactory.getLogger(DataSetup.class);

    private AtomicBoolean alreadyRun = new AtomicBoolean(false);

    @EventListener
    @Transactional
    public void testData(ContextRefreshedEvent event){
        if(!alreadyRun.getAndSet(true)){
            System.out.println("Aplikacja właśnie się uruchomiła i rozpoczynamy zabawę");
        }
    }

}
