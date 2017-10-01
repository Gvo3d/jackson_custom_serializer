package intTest;

import java.util.HashMap;
import java.util.Map;

public interface TelemetryTarget {
    Map<Class, Service> services = new HashMap<>();

    default Service getService() {
        Class clazz = this.getClass();

        Service service = services.get(clazz);
        if (null==service){
            service = new Service(clazz);
            services.put(clazz, service);
        }

        Object obj = (Object) services;
        System.out.println(obj.toString());

        return service;
    }
}
