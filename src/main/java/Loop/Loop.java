package Loop;

import Main.Main;

public class Loop{
    private static Loop loop = null;

    private Loop(){}

    public static Loop get(){
        if(loop == null){
            loop = new Loop();
        }
        return loop;
    }

    /**
     * call update per second
     */
    public void start() {
        while(true) {
            Main.get().update();
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                //nothing
            }
        }
    }
}
