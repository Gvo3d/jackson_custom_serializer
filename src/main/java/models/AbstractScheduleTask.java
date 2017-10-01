package models;

import java.util.Date;

public abstract class AbstractScheduleTask {
    private String type;
    private String schedulet_at;
    private int execute_times;
    private Date start_time;
    private Date end_time;
    private String time_zone;
    private String callback_url;
    private Date last_run_at;
    private int lastRunCode;
    private String lastRunResult;
    private boolean enabled;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchedulet_at() {
        return schedulet_at;
    }

    public void setSchedulet_at(String schedulet_at) {
        this.schedulet_at = schedulet_at;
    }

    public int getExecute_times() {
        return execute_times;
    }

    public void setExecute_times(int execute_times) {
        this.execute_times = execute_times;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getCallback_url() {
        return callback_url;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public Date getLast_run_at() {
        return last_run_at;
    }

    public void setLast_run_at(Date last_run_at) {
        this.last_run_at = last_run_at;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getLastRunCode() {
        return lastRunCode;
    }

    public void setLastRunCode(int lastRunCode) {
        this.lastRunCode = lastRunCode;
    }

    public String getLastRunResult() {
        return lastRunResult;
    }

    public void setLastRunResult(String lastRunResult) {
        this.lastRunResult = lastRunResult;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", schedulet_at='" + schedulet_at + '\'' +
                ", execute_times=" + execute_times +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", time_zone='" + time_zone + '\'' +
                ", callback_url='" + callback_url + '\'' +
                ", last_run_at=" + last_run_at +
                ", lastRunCode=" + lastRunCode +
                ", lastRunResult='" + lastRunResult + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
