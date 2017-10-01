package intTest;

public class Obj implements TelemetryTarget{

    public void doThing(){
        System.out.println("doThing "+getService(this.getClass()));
    }

    public void doThing2(){
        System.out.println("doThing2 "+getService());
    }
}
