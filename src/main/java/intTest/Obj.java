package intTest;

import org.apache.log4j.Logger;

public class Obj implements TelemetryTarget{

    public void doThing(){
        Logger logger = Logger.getLogger(Obj.class);
        System.out.println("doThing "+getService());
    }

}
