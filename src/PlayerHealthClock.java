import java.util.*;

public class PlayerHealthClock implements Clock {

    // Fields:
    private Stack<Integer> healthClock = new Stack<>();

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public PlayerHealthClock(int healthAmount) {
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
        return 1;
    }

    //------------------------------------------------------------------------------------------//

    //
    public String healthStatus() {
        String playerMessage = "You have " + this.healthClock.size() + " HP";
        return playerMessage;
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
