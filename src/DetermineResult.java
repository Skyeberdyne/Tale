import java.util.*;
import java.io.*;

public class DetermineResult {

    // Fields:
    private Scanner console;
    private Scanner infoScan;
    private SetPosition position;
    private SetEffect effect;
    private Map<String, Integer> characterStats;
    private Map<String, Clock> clockList;
    private Map<String, String> actionHistory;
    private Map<String, HashSet<String> > actions;
    private Dice dicePool;
    private OutcomeCheck newOutcome;
    private int actionNumber;
    private ClockCheck checkClocks;
    private File challengeFile;
    private PrintStream challengePrint;
    private Location currentLocation;

    //------------------------------------------------------------------------------------------//

    // Constructor Method:
    public DetermineResult(Scanner console, SetPosition position, SetEffect effect,
                           Map<String, Integer> characterStats,
                           Map<String, Clock> clockList, Map<String, String> actionHistory,
                           Map< String, HashSet<String> > actions, Dice dicePool,
                           OutcomeCheck newOutcome) throws FileNotFoundException {
        this.console = console;
        this.position = position;
        this.effect = effect;
        this.characterStats = characterStats;
        this.clockList = clockList;
        this.actionHistory = actionHistory;
        this.actions = actions;
        this.dicePool = dicePool;
        this.newOutcome = newOutcome;
        this.actionNumber = 0;
        this.challengeFile = new File("Difficulty A1.txt");
        this.challengePrint = new PrintStream(challengeFile);
        this.infoScan = new Scanner(new File("Options Paperwork.txt"));
    }

    //------------------------------------------------------------------------------------------//

    // This is an auxiliary method that helps add an object, (a ClockCheck)
        // to the list of fields above.
    // Exception(s): N/A
    // Return: N/A
    // Parameter: "checkClocks", this is our overall ClockCheck object that checks
        // the status of each of the defined clocks. The parameter adds the object to
        // the list of fields.
    public void addParameter(ClockCheck checkClocks) {
        this.checkClocks = checkClocks;
    }

    //------------------------------------------------------------------------------------------//

    // Given a non-trivial action, (one with assigned challenge values), this method takes
        // the action given by the player, reads & assigns it an Effect and Position value
        // and produces the outcome to the console as a part of the gameplay.
    // Exception(s): N/A
    // Return: N/A
    // Parameter: "action", this is the action the player input that will prompt the method
        // to assign the difficulty depending on the action.
    public void setDifficulty(String action) throws FileNotFoundException {
        // Scans the given file for effect / position info:
        Scanner difficultyScan = new Scanner(challengeFile);

        // Flips on / off if chosen action is reached
        int resultCheck = 0;

        // Priming the variables:
        String newPosition = "";
        String newEffect = "";

        // Assigns the Position & Effect for the "Obscure" action from
            // "challengeFile.txt".
        if(action.equalsIgnoreCase("Obscure")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Obscure")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Using our Position & Effect objects, we set the Position / Effect
                // to whatever value was assigned to our String variables above.

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Pickpocket" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Pickpocket")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Pickpocket")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Assassinate" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Assassinate")) {

            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Assassinate")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Threaten" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Threaten")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Threaten")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Persuade" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Persuade")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Persuade")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Cast a Spell" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Cast a Spell")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Cast a Spell")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Pray / Beseech" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Pray / Beseech")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Pray / Beseech")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Curse" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Curse")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Curse")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Intuit" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Intuit")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Intuit")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }

            // Assigns the Position & Effect for the "Tinker" action from
                // "challengeFile.txt".
        } else if(action.equalsIgnoreCase("Tinker")) {
            while(difficultyScan.hasNextLine()) {
                String consideredLine = difficultyScan.nextLine();
                if(consideredLine.equals("Tinker")) {
                    resultCheck = 1;
                    newPosition = difficultyScan.nextLine();
                    newEffect = difficultyScan.nextLine();
                }
                if(resultCheck == 1) {
                    if(consideredLine.equals("*--------------------------------------" +
                            "---------------------------------------*")) {
                        resultCheck = 0;
                        break;
                    }
                }
            }

            // Positions:
            if(newPosition.equals("Controlled")) {
                position.controlled();
            } else if(newPosition.equals("Risky")) {
                position.risky();
            } else if(newPosition.equals("Desperate")) {
                position.desperate();
            }

            // Effects:
            if(newEffect.equals("None")) {
                effect.none();
            } else if(newEffect.equals("Limited")) {
                effect.limited();
            } else if(newEffect.equals("Standard")) {
                effect.standard();
            } else if(newEffect.equals("Great")) {
                effect.great();
            } else if(newEffect.equals("Extreme")) {
                effect.extreme();
            }
        }
    }

    //------------------------------------------------------------------------------------------//

    // This method changes the considered "challengeFile" object per room / location the player
        // finds themselves in. I.e. each room has a native challenge file with pre-determined
        // Effect and Position values.
    // Exception(s): N/A
    // Return: N/A
    // Parameter: "newLocation", this is the player's location / room, read in as a String.
    public void alterChallengeFile(String newLocation) {
        // Deletes the previously written "Difficulty.txt" file.
        this.challengeFile.delete();

        String newChallengeFile = "Difficulty " + newLocation + ".txt";
        this.challengeFile = new File(newChallengeFile);

        // We should take values from a very big .txt file filled with all possible difficulty values
            // and put the relevant ones into difficulty.txt
            // This program should also check if the action is ineffective or not
            // and apply the proper message.
    }

    //------------------------------------------------------------------------------------------//

    //
    public String questionPrompt(Scanner console, Map< String, HashSet<String> > actions) {
        System.out.println("What will you do?");
        System.out.println(actions.keySet());
        System.out.println("[Or type \"?\" for more information]");
        System.out.println();
        String decision = console.nextLine();
        System.out.println("*-------------------------------------------------------" +
                "----------------------*");
        System.out.println();

        if (decision.equalsIgnoreCase("Sneak")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Sneak"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Speak")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Speak"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Move")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Move"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Attune")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Attune"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Study")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Study"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Engage")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Engage"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Move")) {
            System.out.println("Choose an option...");
            System.out.println(actions.get("Move"));
            System.out.println();
            decision = console.nextLine();

        } else if (decision.equalsIgnoreCase("Access an Item")) {
            // Print inventory here

        } else if (decision.equals("?")) {
            // Add options paperwork here
            String consideredLine = "";
            while (!consideredLine.equals("[Type \"Yay\" if yes, and \"Nay\" to " +
                    "Return to the Action Menu]")) {
                consideredLine = infoScan.nextLine();
                System.out.println(consideredLine);
            }

            String infoResponse = this.console.nextLine();
            if (infoResponse.equalsIgnoreCase("Yay")) {
                while (this.infoScan.hasNextLine()) {
                    consideredLine = infoScan.nextLine();
                    System.out.println(consideredLine);
                }

            }
        }

        return decision;
    }

    //------------------------------------------------------------------------------------------//

    //
    public void resolveAction(Location currentLocation) throws FileNotFoundException {
        this.currentLocation = currentLocation;

        // NEED TO PUT RESULT CHECK = 0 RIGHT BEFORE THE BREAK; IN PRINTING

        // Relevant Objects / Variables:
        String outcome = "";
        String cautionMessage = "Would you still like to perform this action? \n" +
                "[Yes, No] \n";
        String effectMessage = "Orenzio will remember that...";

        // Relevant Clocks:
        Clock storyClock = clockList.get("storyClock"); // THIS WILL BE USED FOR THE WHILE LOOPS

        // Primes the Results .txt Scanner
        String actionChoice = "Obscure A1.txt";
        Scanner fileScan = new Scanner(new File(actionChoice));

        // This checks if we've reached the proper text
        int resultCheck = 0;

        // This checks if our Story Clock has reached its first threshold (initially);
            // this value updates as each threshold is crossed.
        //int storyPointCheck = 1;

        // This loop will continue until the very last story point is reached
        //while (storyPointCheck < 6) {

            // This loop will continue until a Story Threshold is reached (I.e. Story Point #1, 2, 3, etc.)
            //while (!(clockList.get("storyClock").clockStatus() == storyPointCheck)) {

                // Loop continues until a clock threshold is reached
                while (checkClocks.checkThreshold().isEmpty()) {
                    // This resets the check every time a message is displayed
                    // THIS SHOULD BE WRITTEN RIGHT BEFORE THE BREAK STATEMENT IN EACH ACTION OPTION
                    resultCheck = 0;
                    // Loop Primer
                    String decision = "?";

                    // If "?" is chosen, loop will continuously prompt for an action
                    while (decision.equals("?")) {
                        decision = questionPrompt(console, actions);
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();
                    }

                    // Action Outcomes:
                    // EACH ACTION WILL NEED TO CHECK IF THAT ACTION IS EFFECTIVE IN A GIVEN SITUATION
                    // I.E. OBSCURE WON'T WORK IF YOU'RE IN BRIGHT LIGHT SOMEWHERE
                    if (decision.equalsIgnoreCase("Obscure")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Obscure")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Obscure")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {
                                String newFile = "Obscure " + currentLocation + ".txt";
                                // fileScan = Scanner(new File(newFile));
                                while (fileScan.hasNextLine()) {
                                    String consideredLine = fileScan.nextLine();
                                    if (consideredLine.equals("BAD")) {
                                        resultCheck = 1;
                                        consideredLine = fileScan.nextLine();
                                    }
                                    if (resultCheck == 1) {
                                        System.out.println(consideredLine);
                                        if (consideredLine.equals("*--------------------------------------" +
                                                "---------------------------------------*")) {
                                            resultCheck = 0;
                                            break;
                                        }
                                    }
                                }
                                System.out.println(effectMessage);
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                actionHistory.put("Obscure", "Bad");

                            } else if (outcome.equals("Mixed")) {
                                actionChoice = "Obscure " + currentLocation + ".txt";
                                while (fileScan.hasNextLine()) {
                                    String consideredLine = fileScan.nextLine();
                                    if (consideredLine.equals("MIXED")) {
                                        resultCheck = 1;
                                        consideredLine = fileScan.nextLine();
                                    }
                                    if (resultCheck == 1) {
                                        System.out.println(consideredLine);
                                        if (consideredLine.equals("*--------------------------------------" +
                                                "---------------------------------------*")) {
                                            resultCheck = 0;
                                            break;
                                        }
                                    }
                                }
                                System.out.println(effectMessage);
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                actionHistory.put("Obscure", "Mixed");

                            } else if (outcome.equals("Good")) {
                                actionChoice = "Obscure " + currentLocation + ".txt";
                                while (fileScan.hasNextLine()) {
                                    String consideredLine = fileScan.nextLine();
                                    if (consideredLine.equals("GOOD")) {
                                        resultCheck = 1;
                                        consideredLine = fileScan.nextLine();
                                    }
                                    if (resultCheck == 1) {
                                        System.out.println(consideredLine);
                                        if (consideredLine.equals("*--------------------------------------" +
                                                "---------------------------------------*")) {
                                            resultCheck = 0;
                                            break;
                                        }
                                    }
                                }
                                actionHistory.put("Obscure", "Good");

                            } else if (outcome.equals("Critical")) {
                                clockList.get("sneakClock").tickUp(2);
                                clockList.get("sneakClock").clockStatus(); // THIS IS TO CHECK IF IT IS RIGHT

                                actionChoice = "Obscure " + currentLocation + ".txt";
                                while (fileScan.hasNextLine()) {
                                    String consideredLine = fileScan.nextLine();
                                    if (consideredLine.equals("CRITICAL")) {
                                        resultCheck = 1;
                                        consideredLine = fileScan.nextLine();
                                    }
                                    if (resultCheck == 1) {
                                        System.out.println(consideredLine);
                                        if (consideredLine.equals("*--------------------------------------" +
                                                "---------------------------------------*")) {
                                            resultCheck = 0;
                                            break;
                                        }
                                    }
                                }
                                System.out.println(effectMessage);
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                actionHistory.put("Obscure", "Critical");

                                this.actionNumber++;

                            }

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Pickpocket")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Pickpocket")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Pickpocket")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Assassinate")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Assassinate")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Assassinate")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Threaten")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Threaten")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Threaten")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Persuade")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Persuade")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Persuade")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Discuss")) {

                    } else if (decision.equalsIgnoreCase("North")) {

                    } else if (decision.equalsIgnoreCase("South")) {

                    } else if (decision.equalsIgnoreCase("East")) {

                    } else if (decision.equalsIgnoreCase("West")) {

                    } else if (decision.equalsIgnoreCase("Forward")) {

                    } else if (decision.equalsIgnoreCase("Cast a Spell")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Cast a Spell")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Cast a Spell")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Pray / Beseech")) { // Need to incorporate Concordance Clock

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Pray / Beseech")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Pray / Beseech")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Curse")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Curse")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Curse")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Intuit")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Intuit")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Intuit")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }


                    } else if (decision.equalsIgnoreCase("Tinker")) {

                        // Set Position & Effect:
                        setDifficulty(decision);
                        System.out.println();

                        // Confirmation Message:
                        System.out.println(cautionMessage);
                        String answer = console.nextLine();
                        System.out.println("*-------------------------------------------------------" +
                                "----------------------*");
                        System.out.println();

                        // "Yes" Confirmation, continues on with chosen action
                        if (answer.equalsIgnoreCase("Yes")) {

                            if (characterStats.containsKey("Tinker")) {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
                                        characterStats.get("Tinker")));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            } else {
                                outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
                                System.out.println("*-------------------------------------------------------" +
                                        "----------------------*");
                                System.out.println();
                            }

                            // Outcome Trees:
                            if (outcome.equals("Bad")) {

                            } else if (outcome.equals("Mixed")) {

                            } else if (outcome.equals("Good")) {

                            } else if (outcome.equals("Critical")) {

                            }

                            this.actionNumber++;

                            // "No" Confirmation, allows for re-selecting of an action
                        } else if (answer.equalsIgnoreCase("No")) {
                            break;
                        }
                    }
                }

                // This resolves the given threshold once one has been reached
                //checkClocks.resolveThreshold();
            //}
            // After the story threshold is crossed, this updates the storyPointCheck
            //storyPointCheck++;

            // STORY STUFF HAPPENS HERE

       // }

    }

    //------------------------------------------------------------------------------------------//

}
