package aiomed.aiomed.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleService {
    private final static int THREAD_AMOUNT = 1;
    private final AiOmed_Service aiOmedService;

    public ScheduleService(AiOmed_Service aiOmedService) {
        this.aiOmedService = aiOmedService;
    }


    public void scheduleDailyChecker() {

        LocalTime now = LocalTime.now();

        long initialDelay = Duration.between(now, LocalTime.MIDNIGHT).toMillis();


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(THREAD_AMOUNT);

        scheduler.scheduleAtFixedRate(() -> aiOmedService.checker(), initialDelay, TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS);
    }
}
