package intTest;

public interface TelemetryTarget {
    default Service getService(Class clazz) {
        return new Service(clazz);
    }

    default Service getService() {
        return new Service(this.getClass());
    }
}
