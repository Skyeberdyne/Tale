import java.util.*;

// This class checks the clocks in a given list to see if any of them are full or not

public class ClockCheck {

    // Fields:
    // private Location currentLocation;
    private Map<Clock, Integer> thresholdClocks; // These are clocks that have reached a threshold, i.e. Clock, Threshold #
    private Clock playerHealth;
    private Clock orenzioHealth; // Thresholds: 1 (Death's Door), 5 (Bloodied), 10 (Full Health)
    private Clock sneakClock; // Thresholds: 3 (Midpoint), 6 (Full)

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public ClockCheck(Map<String, Clock> clockList) {

        // These are clocks that have reached a threshold, i.e. Clock, Threshold #
        this.thresholdClocks = new HashMap<>();
        this.playerHealth = clockList.get("playerHealth");
        this.orenzioHealth = clockList.get("orenzioHealth");
        this.sneakClock = clockList.get("sneakClock");
        // this.currentLocation = currentLocation;

    }

    //------------------------------------------------------------------------------------------//

    // This method will check all clocks and throw any threshold clocks into a List
    public Map<Clock, Integer> checkThreshold() {

        // EACH CLOCK SHOULD HAVE ITS OWN THRESHOLD CHECK
        // Player Health:
//        if(playerHealth.clockStatus() == 5) { // Thresh. 1: (Bloodied)
//            thresholdClocks.put(playerHealth, 2);
//        } else if(playerHealth.clockStatus() == 1) { // Thresh. 2: (Death's Door)
//            thresholdClocks.put(playerHealth, 3);
//        }
//
//        // NPC Health:
//        if(orenzioHealth.clockStatus() == 5) { // Thresh. 1: (Bloodied)
//            thresholdClocks.put(orenzioHealth, 2);
//        } else if(orenzioHealth.clockStatus() == 1) { // Thresh. 2: (Death's Door)
//            thresholdClocks.put(orenzioHealth, 3);
//        }
//
//        // Sneak Clock:
//        if(sneakClock.clockStatus() == 6) { // Thresh. 2: (Fully Hidden)
//            thresholdClocks.put(sneakClock, 2);
//        } else if(sneakClock.clockStatus() == 3) { // Thresh. 1: (Partially Obscured)
//            thresholdClocks.put(sneakClock, 1);
//        }



        return thresholdClocks;
    }

    //------------------------------------------------------------------------------------------//

    // This resolves every threshold in the list

    // PROBLEM: HOW DO I PREVENT EACH CLOCK FROM BEING RE-ADDED WITH THE SAME THRESHOLD # AS BEFORE?
    // THIS SHOULD EMPTY THE THRESHOLDCLOCKS MAP SO THAT THE LOOP MAY CONTINUE
    public void resolveThreshold() {
        while(!this.thresholdClocks.isEmpty()) { // Loops until there are no more threshold clocks to be checked

            // Next we should check the story clock AND the current location,
            // i.e. if currenLocation is blah blah blah

        }
    }
}
