import java.util.*;

public class NPCHealthClock implements Clock {

    // Fields:
    private Stack<Integer> healthClock = new Stack<>();

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public NPCHealthClock(int healthAmount) {
        for(int i = healthAmount; i >= 1; i--) {
            this.healthClock.push(i);
        }
    }

    //------------------------------------------------------------------------------------------//

    public void tickUp(int tickAmount) {

    }

    //------------------------------------------------------------------------------------------//

    public void tickDown(int tickAmount) {

    }

    //------------------------------------------------------------------------------------------//

    public int clockStatus() {

        return 1; // Placeholder
    }

    //
    public boolean isFull() {

        return true; // placeholder
    }

    //
    public void clearClock() {

    }

    public int thresholdNum() {

        return 1; // placeholder
    }
}
