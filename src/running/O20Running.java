package running;

import java.awt.*;

public class O20Running extends Running{

    private Robot robot;

    public  O20Running() {

        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void stop(){

    }
    public void run(){

    }

    public boolean waitForGuai(){

        return false;
    }

    public boolean waitForBuy(){

        return false;
    }

    public boolean waitForChat(){

        return false;
    }

    public boolean chooseSing(){

        return  false;
    }
}
