import java.util.*;

public class Dice {

    // Fields:
    private Random singleDie;
    private List<Integer> dicePool;

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public Dice() {
        this.singleDie = new Random();
        this.dicePool = new ArrayList<>();
    }

    //------------------------------------------------------------------------------------------//

    // This method rolls a number of dice specified as a parameter and adds each roll
        // to the dice pool.
    // Exception(s): N/A
    // Return: "List<Integer>", this is the total result of each die being rolled.
    // Parameter: "numDice", this is the number of dice that is wished to be rolled.
    public List<Integer> rollDice(int numDice) {
        System.out.println("You rolled...");
        for(int i = 1; i <= numDice; i++) {

            // Rolls a die and adds it to the dice pool:
            int newRoll = singleDie.nextInt(6) + 1;
            this.dicePool.add(newRoll);

            System.out.println("  - Die " + i + ": " + newRoll);
        }

        return this.dicePool;
    }

    //------------------------------------------------------------------------------------------//

    // This method clears the dice pool of any entries made by previous rolls.
    // Exception(s): N/A
    // Return: N/A
    // Parameter(s): N/A
    public void clearDicePool() {
        for(int i = 0; i < dicePool.size(); i++) {
            this.dicePool.remove(i);
        }
    }
}
