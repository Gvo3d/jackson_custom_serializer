package support;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.util.Date;

public class NextRunTaskParser {
    private DateTimeJsonParser parser;

    public NextRunTaskParser(DateTimeJsonParser parser) {
        this.parser = parser;
    }

    public String getNextRunTime(String expression) {
        Date currTime = new Date(System.currentTimeMillis());
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("test", "group")
                .withSchedule(CronScheduleBuilder.cronSchedule(expression))
                .build();
        Date nextFireAt = trigger.getFireTimeAfter(currTime);
        return parser.parseDateToString(nextFireAt);
    }
}
