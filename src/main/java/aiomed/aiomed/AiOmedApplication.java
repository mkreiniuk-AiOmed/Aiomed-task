package aiomed.aiomed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
public class AiOmedApplication {



    public static void main(String[] args) {
        SpringApplication.run(AiOmedApplication.class, args);
    }

}
