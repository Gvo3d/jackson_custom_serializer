package intTest;

import org.apache.log4j.Logger;

public class Obj2 implements TelemetryTarget{

    public void doThing(){
        Logger logger = Logger.getLogger(Obj2.class);
        System.out.println("doThing "+getService());
    }

}
