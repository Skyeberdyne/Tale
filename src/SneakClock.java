import java.util.Stack;

public class SneakClock implements Clock {

    // Fields:
    private Stack<Integer> sneakClock;
    private int tickCounter;

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public SneakClock() {
        this.sneakClock = new Stack<>();
        this.tickCounter = 0;
    }

    //------------------------------------------------------------------------------------------//

    //
    public void tickUp(int tickAmount) {

        for(int i = 1; i <= tickAmount; i++) {
            if(this.tickCounter == 6) { // THIS IS THE SNEAK THRESHOLD MAXIMUM
                break;
            } else {
                this.sneakClock.push(tickCounter + 1);
                this.tickCounter++;
            }
        }
    }

    //------------------------------------------------------------------------------------------//

    //
    public void tickDown(int tickAmount) {

    }

    //------------------------------------------------------------------------------------------//

    //
    public int clockStatus() {

        return 1; // Placeholder
    }

    //------------------------------------------------------------------------------------------//

    //
    public int thresholdNum() {

        return 1; // placeholder
    }

    //------------------------------------------------------------------------------------------//

    //
    public boolean isFull() {

        return true; // placeholder
    }

    //------------------------------------------------------------------------------------------//

    //
    public void clearClock() {

    }

}
