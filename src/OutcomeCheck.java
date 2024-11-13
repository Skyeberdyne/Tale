import java.util.*;

public class OutcomeCheck {

    // Fields:
    String outcome;

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public OutcomeCheck() {
        this.outcome = "";
    }

    //------------------------------------------------------------------------------------------//

    // This method checks the entire dice pool, records the highest dice, criticals
        // (if there are any), and assigns an outcome target word for the player's action.
    // Exception(s): N/A
    // Return: "String", this is the outcome target word for the action.
    // Parameter: "dicePool", this is the give dice pool from a previous roll.
    public String currentOutcome(List<Integer> dicePool) {
        int highestRoll = 0;
        int critCount = 0;

        for(int i = 0; i < dicePool.size(); i++) {
            int currentDie = dicePool.get(i);
            if(currentDie >= highestRoll) {
                highestRoll = currentDie;
            }

            // Checks multiple 6's
            if(currentDie == 6) {
                critCount++;
            }
        }

        // Assigns an Effect
        if( (highestRoll == 1) || (highestRoll == 2) || (highestRoll == 3) ) {
            this.outcome = "Bad";
        } else if( (highestRoll == 4) || (highestRoll == 5) ) {
            this.outcome = "Mixed";
        } else if(highestRoll == 6) {
            if(critCount >= 2) {
                this.outcome = "Critical";
            } else {
                this.outcome = "Good";
            }
        }

        // Resets the counters:
        highestRoll = 0;
        critCount = 0;

        System.out.println("The outcome was " + outcome + ".");
        return outcome;
    }

    //------------------------------------------------------------------------------------------//

    // This method clears the outcome field of any previous determinations.
    // Exception(s): N/A
    // Return: N/A
    // Parameter(s): N/A
    public void clearOutcome() {
        this.outcome = "";
    }
}
