import java.util.*;
import java.io.*;
import java.util.List;

// Starting in encounterOne below; trying to load in the state of a room first
    // I have edited the Location class to include a natural list of position and effect values that can be
    // changed with player action



// READ FIRST
// THEN ClockCheck resolveThreshold is your new starting point.
// Good luck! You're an amazing writer, and this project is really cool. Keep with it, man.

// PLAN OF ATTACK:
// Currently, I am trying to figure out how to adjust the difficulty of each action based on the threshold
    // a certain clock is at.
    // I.e. if a threshold is reached, the program should edit the file to make certain actions easier / harder.
        // (My idea was using a PrintStream).
    // Each "room" should have its own effect and position .txt file
// NEXT is drawing the map.
    // Some actions should be more useful in certain areas than others.
    // I need to find a way to keep track of the player's heading AND what "room" they're in.

// THINGS TO IMPLEMENT:
    // The Librarian Class. This will help retrieve all the .txt files.
    // Make sure the loop works until Story Point #1 is reached
        // If you can get the program to this point, then you can just repeat the code for story point #'s 2 - 6
    // Spell selection
    // Curse selection
    // Prayer selection
    // Mid-Action "?" information
    // Each room needs a specific name; write the reportLocation method in the Location class

    // DetermineResult's alterChallengeFile method
    // DetermineResult's questionPrompt "Access an Item" option
    // DetermineResult's resolveAction "Pray / Beseech" option needs to incorporate the Concordance clock
        // This goes for the "Curse" option as well


// WE CAN NOW ADJUST THE DIFFICULTY PER ENCOUNTER WITH A FILE CALLED Difficulty <num>.txt
    // WHERE THE <num> IS THE ACTION "ROUND" YOU'RE CURRENTLY ON.
    // NEXT IS DECIDING HOW TO ADJUST EACH POSITION / EFFECT IF A CLOCK IS AT A GIVEN THRESHOLD


public class Game {

    public static void main(String[] args) throws FileNotFoundException {

        // Relevant Object Creation:
        Scanner console = new Scanner(System.in);
        SetPosition position = new SetPosition();
        SetEffect effect = new SetEffect();

        Map< String, HashSet<String> > actions = new HashMap<>();
        fillActions(actions);

        // Title Screen:
        Scanner titleScan = new Scanner(new File("Title Screen.txt"));
        while(titleScan.hasNextLine()) {
            String newLine = titleScan.nextLine();
            System.out.println(newLine);
        }

        // Game Selection (Import or New Game):
        System.out.println("Will you be Importing a Character, or Starting a New Game?\n" +
                           "[Import, New Game]\n");
        String beginning = console.nextLine();
        System.out.println("*-------------------------------------------------------" +
                "----------------------*");
        System.out.println();

        // Importing an Old Character:
        if(beginning.equalsIgnoreCase("Import")) {
            System.out.println("What is the name of your hero?");
            String typedHero = console.nextLine();
            String importHero = (typedHero + ".txt");
            String importStats = (typedHero + " Stats.txt");

            // Character Import:
            Scanner heroScan = new Scanner(new File(importHero));
            Scanner statScan = new Scanner(new File(importStats));

            Map<String, String> character = new HashMap<>();
            Map<String, Integer> characterStats = new HashMap<>();

            // Filling the Character Info:
            int lineCount = 1;
            String lastThing = "";
            while(heroScan.hasNextLine()) {
                String newThing = heroScan.nextLine();
                if(lineCount % 2 == 1) {
                    lineCount++;
                    lastThing = newThing;
                    character.put(newThing, "");
                } else {
                    lineCount++;
                    character.put(lastThing, newThing);
                }
            }

            // Filling the Stat Info:
            lineCount = 1;
            lastThing = "";
            while(statScan.hasNextLine()) {
                String newThing = statScan.nextLine();
                if(lineCount % 2 == 1) {
                    lineCount++;
                    lastThing = newThing;
                    characterStats.put(newThing, 0);
                } else {
                    lineCount++;
                    int num = Integer.parseInt(newThing);
                    characterStats.put(lastThing, num);
                }
            }

            // Restart Formatting:
            System.out.println("*-------------------------------------------------------" +
                    "----------------------*");
            System.out.println();

            System.out.println("Bending the Stretch to restore your previous progress...");
            System.out.println();
            System.out.println("*-------------------------------------------------------" +
                    "----------------------*");
            System.out.println();

            // Game Beginning:
            encounterOne(position, effect, console, character, actions, characterStats); // Re-adjust for new progress

            // Starting a new Game:
        } else if(beginning.equalsIgnoreCase("New Game")) {

            // Character Creation:
            characterCreator newCharacter = new characterCreator();
            Map<String, String> character = newCharacter.main();
            Map<String, Integer> characterStats = newCharacter.getStats();

            // New Game Beginning:
            encounterOne(position, effect, console, character, actions, characterStats);

        }

    }

    //------------------------------------------------------------------------------------------//

    //
    public static void encounterOne (SetPosition position, SetEffect effect,
                                     Scanner console, Map<String, String> character,
                                     Map< String, HashSet<String> > actions,
                                     Map<String, Integer> characterStats)
            throws FileNotFoundException {

        // Relevant Objects:
        Map<String, String> actionHistory = new TreeMap<>();
        Dice dicePool = new Dice();
        OutcomeCheck newOutcome = new OutcomeCheck();
        SaveGame newSave = new SaveGame();

        // Relevant Clocks:
        Clock playerHealth = new PlayerHealthClock(6);
        Clock orenzioHealth = new NPCHealthClock(6);
        Clock sneakClock = new SneakClock();
        Clock storyClock = new StoryClock();

        // Adding Clocks to the Overall List:
        Map<String, Clock> clockList = new HashMap<>();
        clockList.put("playerHealth", playerHealth);
        clockList.put("orenzioHealth", orenzioHealth);
        clockList.put("sneakClock", sneakClock);
        clockList.put("storyClock", storyClock);

        ClockCheck resolveClock = new ClockCheck(clockList);

        // Encounter Introduction:
        Scanner fileScan = new Scanner(new File("Encounter One.txt"));
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
            System.out.println(line);
        }
        System.out.println();
        System.out.println("*-------------------------------------------------------" +
                "----------------------*");
        System.out.println();

        // A list of all the locations
        List<Location> locationList = new ArrayList<>();
        Location a0 = new Location();
        locationList.add(a0);

        String currentLocation = "a0"; // this will get updated as player traverses the rooms

        // This loops until a threshold is reached
        while(resolveClock.checkThreshold().isEmpty()) {
            // Loads the current location:
            // Location currentLocation = locationList.get(currentLocation)
        }

        // Location currentLocation = new Location(); // Edit: parameter to be passed is newResult

        // These objects helps resolve an action:
        DetermineResult newResult = new DetermineResult(console, position, effect, characterStats,
                                                         clockList, actionHistory, actions,
                                                         dicePool, newOutcome);

        // This will check all clocks for thresholds
        // ClockCheck checkClocks = new ClockCheck(clockList, currentLocation);
        // newResult.addParameter(checkClocks);

        // Loop continuously prompts for actions to be resolved until some a clock threshold is filled
             // newResult.resolveAction(currentLocation);
             // newSave.saveProgress();


        // Outcome Methods: REMEMBER TO CHECK CLOCKS AFTER EACH OUTCOME AND SAVE PROGRESS
        //outcome(console, position, effect, characterStats, clockList, actionHistory, actions,
        //         dicePool, newOutcome);
        // SAVE PROGRESS
        // CHECK CLOCK



    }

    //------------------------------------------------------------------------------------------//

    // This method fills the "action" list.
    public static void fillActions(Map< String, HashSet<String> > actions) {
        actions.put("Speak", new HashSet<String>());
        actions.get("Speak").add("Persuade");
        actions.get("Speak").add("Threaten");
        actions.get("Speak").add("Discuss");

        actions.put("Sneak", new HashSet<String>());
        actions.get("Sneak").add("Obscure");
        actions.get("Sneak").add("Pickpocket");
        actions.get("Sneak").add("Assassinate");

        actions.put("Attune", new HashSet<String>());
        actions.get("Attune").add("Cast a Spell");
        actions.get("Attune").add("Pray / Beseech");
        actions.get("Attune").add("Curse");

        actions.put("Move", new HashSet<String>());
        actions.get("Move").add("North");
        actions.get("Move").add("South");
        actions.get("Move").add("East");
        actions.get("Move").add("West");
        actions.get("Move").add("Forward");

        actions.put("Study", new HashSet<String>());
        actions.get("Study").add("Intuit");
        actions.get("Study").add("Tinker");

        actions.put("Engage", new HashSet<String>());
        actions.get("Engage").add("Melee");
        actions.get("Engage").add("Curse");
        actions.get("Engage").add("Assassinate");
        actions.get("Engage").add("Cast a Spell");

        actions.put("Access an Item", new HashSet<String>());
        actions.get("Access an Item").add("Barter");
        actions.get("Access an Item").add("Use...");
    }

    //------------------------------------------------------------------------------------------//



}