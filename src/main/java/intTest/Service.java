package intTest;

public class Service {
    private Class clazz;

    public Service(Class clazz) {
        this.clazz = clazz;
    }

    public Class getTarget(){
        return clazz;
    }

    @Override
    public String toString() {
        return "Service{" +
                "clazz=" + clazz +
                '}';
    }
}
