import java.util.Stack;

public class AggressionClock implements Clock {

    // Fields:
    private Stack<Integer> AggressionClock;
    private int tickCounter;

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public AggressionClock() {
        this.AggressionClock = new Stack<>();
        this.tickCounter = 0;
    }

    //------------------------------------------------------------------------------------------//

    public void tickUp(int tickAmount) {
        for(int i = 1; i <= tickAmount; i++) {
            if(AggressionClock.size() == 6) { // THIS IS THE SNEAK THRESHOLD CHECK
                System.out.println("The clock is full!");
            } else {
                this.AggressionClock.push(tickCounter + 1);
                this.tickCounter++;
            }
        }
    }

    public void tickDown(int tickAmount) {

    }

    public int clockStatus() {

        return 1; // Placeholder
    }

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
