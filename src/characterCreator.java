import java.util.*;
import java.io.*;

public class characterCreator {

    // Fields:
    Map<String, Integer> statList = new HashMap<>();

    // Main is modified to have no String[] args, and returns a map
    public Map<String, String> main() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        Map<String, String> newCharacter = new HashMap<>();

        String[] races = {"Mannai", "Eefi", "Urkil", "Morceaux", "Sheol"};
        String[] continent = {"Regalo di Volci", "Cala'corva", "Uud", "Iagomal",
                "Agri", "The Islands of Azadini"};
        String[] specializations = {"Champion", "Troubadour", "Chaplain",
                "Magician", "Deluviite", "Shadow"};
        String[] championSubclass = {"Aural Inferna", "Green Knight", "Hikkomori"};
        String[] troubadourSubclass = {"Academy Scholar", "Circle Sophist", "Flintsteel"};
        String[] chaplainSubclass = {"Vaporist", "Clergy of the Host", "Shaman"};
        String[] magicianSubclass = {"Astramancer", "Triacht", "Sybil"};
        String[] deluviiteSubclass = {"Hex Magus", "Lazarys", "Mächinenbau"};
        String[] shadowSubclass = {"Street Urchin", "Guild Fixer", "Spook"};

        statList.put("Persuade", 0);
        statList.put("Threaten", 0);
        statList.put("Obscure", 0);
        statList.put("Pickpocket", 0);
        statList.put("Assassinate", 0);
        statList.put("Cast a Spell", 0);
        statList.put("Pray / Beseech", 0);
        statList.put("Curse", 0);
        statList.put("Intuit", 0);
        statList.put("Tinker", 0);
        statList.put("Melee", 0);

        introduction(console);
        raceSelection(console, races, newCharacter);
        age(console, newCharacter);
        birthplace(console, newCharacter, continent);
        classSelection(console, newCharacter, specializations);
        profession(console, newCharacter, championSubclass, troubadourSubclass, chaplainSubclass,
                magicianSubclass, deluviiteSubclass, shadowSubclass);
        statsOut(console, newCharacter, statList, championSubclass,
                troubadourSubclass, chaplainSubclass,
                magicianSubclass, deluviiteSubclass, shadowSubclass, races, continent, specializations);

        return newCharacter;

    }

    //------------------------------------------------------------------------------------------//

    // This method prints out the Introduction for the game.
        // Parameter: "console", A Scanner that allows the user to input data.
        // Return: N/A
    public static void introduction(Scanner console) {
        System.out.println("Prepare for your Epic Quest...");
        System.out.println("What say you to this call to adventure?");
        System.out.println();

        String answer = console.nextLine();

        if(answer.equalsIgnoreCase("Huzzah!")) {
            System.out.println();
            System.out.println("With such zeal, there is no doubt you are a worthy Hero!");
            System.out.println("Begin your quest O, Luminous One!");
            System.out.println("*-------------------------------------------------------" +
                    "----------------------*");
        } else {
            System.out.println();
            System.out.println("I see...");
            System.out.println("Regardless. Your destiny begins NOW...");
            System.out.println();
            System.out.println("*-------------------------------------------------------" +
                    "----------------------*");
        }
    }

    //------------------------------------------------------------------------------------------//

    // This is a "getter" method that allows us to access the "Stat List"
    public Map<String, Integer> getStats() {
        return statList;
    }

    // This method is the Race Selection for the Character Creator.
        // Parameter: "console", a Scanner that allows the user to input their text-based answers.
        // Parameter: "races", this is an Array of the 5 different playable races.
        // Return: N/A
    public static void raceSelection (Scanner console, String[] races,
                                      Map<String, String> newCharacter)
            throws FileNotFoundException {
        String userInput = "";
        while(!userInput.equalsIgnoreCase("Mannai") &&
                !userInput.equalsIgnoreCase("Eefi") &&
                !userInput.equalsIgnoreCase("Urkil") &&
                !userInput.equalsIgnoreCase("Morceaux") &&
                !userInput.equalsIgnoreCase("Sheol")) {

            System.out.println();
            System.out.println("Choose Your Race: ");
            System.out.println(Arrays.toString(races));
            System.out.println();
            System.out.println("Type \"?\" for more information.");
            System.out.println();

            userInput = console.nextLine();
            System.out.println();
            if (userInput.equals("?")) {
                Scanner fileScan = new Scanner(new File("raceInfo.txt"));
                while (fileScan.hasNextLine()) {
                    System.out.println(fileScan.nextLine());
                }
            } else if (!userInput.equalsIgnoreCase("Mannai") &&
                    !userInput.equalsIgnoreCase("Eefi") &&
                    !userInput.equalsIgnoreCase("Urkil") &&
                    !userInput.equalsIgnoreCase("Morceaux") &&
                    !userInput.equalsIgnoreCase("Sheol")) {
                System.out.println(userInput + " is not an option, you twit. Try again.");
                System.out.println("*----------------------------------------------" +
                        "-------------------------------*");
            }
        }

        newCharacter.put("Race", userInput);

        if(userInput.equalsIgnoreCase("Mannai")) {
            System.out.println("The Mannai are brilliant, resiliant, and have lived " +
                    "on Khosh'Dâram since " +
                    "time-immemorial. You have chosen well");
        } else if(userInput.equalsIgnoreCase("Eefi")) {
            System.out.println("A proud and wilding people known for their cunning " +
                    "skill with the arcane arts. " +
                    "You have made a noble choice.");
        } else if(userInput.equalsIgnoreCase("Urkil")) {
            System.out.println("The Urkíl of Khosh'Dâram have seen generations " +
                    "of pain, but their suffering " +
                    "has tempered a tribe of warriors; equal parts fierce and wise.");
        } else if(userInput.equalsIgnoreCase("Morceaux")) {
            System.out.println("Forged from the primordial elements of the Covergence Rune, " +
                    "the Morceaux are made of" +
                    " aether & cronós itself. An informed decision, indeed.");
        } else if(userInput.equalsIgnoreCase("Sheol")) {
            System.out.println("The blood that flows through Sheol veins is " +
                    "from the realm of Agony itself." +
                    " To call these hunters deadly is an understatement. Bravo.");
        }
        System.out.println("*-----------------------------------------------------" +
                "------------------------*");
        System.out.println();
    }

    //------------------------------------------------------------------------------------------//

    // This method calls for the Character's age.
        // Parameter: "console", a Scanner that lets the user input data into the program.
        // Parameter: "newCharacter", this is a running tally of all the choices the user
            // has made thus far.
        // Return: N/A
    public static void age(Scanner console, Map<String, String> newCharacter) {
        String age = "";
        int num = 1;
        if(newCharacter.get("Race").equalsIgnoreCase("Mannai")) {
            num = 0;
            while( (num > 100) || (num < 18)) {
                System.out.println("The Mannai typically reach maturity at age 18 and complete ");
                System.out.println("their cycle around age 100.");
                System.out.println();

                System.out.println("So...How old are YOU?");
                System.out.println();

                age = console.nextLine();
                System.out.println();
                num = Integer.parseInt(age);
                if(num == 0) {
                    System.out.println("A 0-year-old would instantly combust...");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
                if (num < 18 && !(num == 0)) {
                    System.out.println(num + " is too young!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                } else if (num > 100) {
                    System.out.println(num + " is too old!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Eefi")) {
            num = 0;
            while( (num > 880) || (num < 158)) {
                System.out.println("An Eefi youth becomes an adult during their 158th ");
                System.out.println("year, and completes their cycle around age 880");
                System.out.println();

                System.out.println("So...How old are YOU?");
                System.out.println();

                age = console.nextLine();
                System.out.println();
                num = Integer.parseInt(age);
                if(num == 0) {
                    System.out.println("When was the las time YOU remember being 0? HMMM? " +
                            "Yeah, I didn't think so...");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
                if (num < 158 && !(num == 0)) {
                    System.out.println(num + " is too young!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                } else if (num > 880) {
                    System.out.println(num + " is too old!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Urkil")) {
            num = 0;
            while( (num > 160) || (num < 29)) {
                System.out.println("Urkíl move through liminal space at age 29, and complete");
                System.out.println("their cycle roughly around their 160th year.");
                System.out.println();

                System.out.println("So...How old are YOU?");
                System.out.println();

                age = console.nextLine();
                System.out.println();
                num = Integer.parseInt(age);
                if(num == 0) {
                    System.out.println("Being 0 is basically like not existing. WTF...");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
                if (num < 29 && !(num == 0)) {
                    System.out.println(num + " is too young!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                } else if (num > 160) {
                    System.out.println(num + " is too old!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Morceaux")) {
            num = 0;
            while((num > 3500000) || (num < 90)) {
                System.out.println("While a healthy Morceaux matures around age 90, unless");
                System.out.println("acted upon by an outside force, the Morceaux don't die");
                System.out.println("in the same ways the Mannai, Eefi, and Urkíl do. ");
                System.out.println("They live on ad infinitum!");
                System.out.println();

                System.out.println("So...How old are YOU?"); // WHAT IF THEY ENTER A DOUBLE OR A STRING
                System.out.println();

                age = console.nextLine();
                System.out.println();
                num = Integer.parseInt(age);
                if(num == 0) {
                    System.out.println("How can someone be 0? Spoiler Alert: They can't...");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
                if (num < 90 && !(num == 0)) {
                    System.out.println(num + " is too young!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                } else if(num > 3500000) {
                    System.out.println(num + " is too old!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                }
            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Sheol")) {
            num = 0;
            while( (num > 250) || (num < 45)) {
                System.out.println("A Sheol, (if not hunted down as an adolescent),");
                System.out.println("matures at age 45 and completes their cycle at");
                System.out.println("roughly the 250th year mark.");
                System.out.println();

                System.out.println("So...How old are YOU?");
                System.out.println();

                age = console.nextLine();
                System.out.println();
                num = Integer.parseInt(age);
                if(num == 0) {
                    System.out.println("I don't even think that is possible...");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
                if (num < 45 && !(num == 0)) {
                    System.out.println(num + " is too young!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                } else if (num > 250) {
                    System.out.println(num + " is too old!");
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                }
            }
        }

        newCharacter.put("Age", age);

        if(newCharacter.get("Race").equalsIgnoreCase("Mannai")) {
            if((num >= 18) && (num <= 31)) { // Tier 1
                System.out.println("Ah, yes! You are bright-eyed with the strength of youth!");

            } else if((num >= 32) && (num <= 45)) { // Tier 2
                System.out.println("You are stronger and wiser than you were as a young adult. " +
                        "Determination has helped you through your early years.");

            } else if((num >= 46) && (num <= 67)) { // Tier 3
                System.out.println("You have been fully set-upon by adulthood. " +
                        "You recall the distant memory of childhood and now prepare for " +
                        "a role as an early-elder.");

            } else if((num >= 68) && (num <= 79)) { // Tier 4
                System.out.println("Time has crept by, and with it, took your youth. " +
                        "You are considered quite elderly, and the years hang on your " +
                        "body like heavy luggage.");

            } else if((num >= 80) && (num <= 93)) { // Tier 5
                System.out.println("Organs have been failing, your skin is graying as much as " +
                        "your hair, (which grayed long ago). It is hard to breathe and walk " +
                        "let alone adventure...");

            } else if((num >= 94) && (num <= 99)) { // Tier 6
                System.out.println("People look at you with worry as you shamble by. You are " +
                        "a nigh-dead bag of bones, and it is a wonder that the Gods have" +
                        "kept you alive to become this old.");

            } else if(num == 100) { // Tier 7
                System.out.println("People shriek when they look in your eyes. You are " +
                        "the walking embodiment of death. Every sip of air you take has a " +
                        "high chance of being your last.");
                System.out.println("You are old as fuck!");

            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Eefi")) {
            if((num >= 158) && (num <= 273)) { // Tier 1
                System.out.println("");

            } else if((num >= 274) && (num <= 396)) { // Tier 2
                System.out.println("");

            } else if((num >= 397) && (num <= 590)) { // Tier 3
                System.out.println("");

            } else if((num >= 591) && (num <= 695)) { // Tier 4
                System.out.println("");

            } else if((num >= 696) && (num <= 818)) { // Tier 5
                System.out.println("");

            } else if((num >= 819) && (num <= 880)) { // Tier 6
                System.out.println("");

            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Urkil")) {
            if((num >= 90) && (num <= 100)) { // Tier 1
                System.out.println("");

            } else if((num >= 51) && (num <= 72)) { // Tier 2
                System.out.println("");

            } else if((num >= 73) && (num <= 107)) { // Tier 3
                System.out.println("");

            } else if((num >= 108) && (num <= 126)) { // Tier 4
                System.out.println("");

            } else if((num >= 127) && (num <= 149)) { // Tier 5
                System.out.println("");

            } else if((num >= 150) && (num <= 160)) { // Tier 6
                System.out.println("");

            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Morceaux")) {
            if((num >= 90) && (num <= 100)) { // Tier 1
                System.out.println("");

            } else if((num >= 101) && (num <= 3499999)) { // Tier 2
                System.out.println("");

            }

        } else if(newCharacter.get("Race").equalsIgnoreCase("Sheol")) {
            if((num >= 45) && (num <= 78)) { // Tier 1
                System.out.println("");

            } else if((num >= 79) && (num <= 113)) { // Tier 2
                System.out.println("");

            } else if((num >= 114) && (num <= 168)) { // Tier 3
                System.out.println("");

            } else if((num >= 169) && (num <= 198)) { // Tier 4
                System.out.println("");

            } else if((num >= 199) && (num <= 233)) { // Tier 5
                System.out.println("");

            } else if((num >= 234) && (num <= 250)) { // Tier 6
                System.out.println("");

            }

        }

        System.out.println("*-----------------------------------------------------" +
                "------------------------*");
    }

    //------------------------------------------------------------------------------------------//

    // This method allows the Player to choose a where on Khosh'Dâram they are from.
        // Parameter: "console", a Scanner that allows the user to input data into the console.
        // Parameter: "newCharacter", a Stack of all the previously known Character info.
        // Parameter: "continent", a list of all the States on the continent.
        // Return: N/A
    public static void birthplace(Scanner console, Map<String, String> newCharacter,
                                  String[] continent) throws FileNotFoundException {

        String userInput = "";
        while (!userInput.equalsIgnoreCase("Regalo Di Volci") &&
                !userInput.equalsIgnoreCase("Cala'corva") &&
                !userInput.equalsIgnoreCase("Uud") &&
                !userInput.equalsIgnoreCase("Iagomal") &&
                !userInput.equalsIgnoreCase("The Islands of Azadini") &&
                !userInput.equalsIgnoreCase("Azadini") &&
                !userInput.equalsIgnoreCase("Agri")) {

            System.out.println();
            System.out.println("Choose Your Birthplace: ");
            System.out.println(Arrays.toString(continent));
            System.out.println();
            System.out.println("Type \"?\" for more information.");
            System.out.println();

            userInput = console.nextLine();
            System.out.println();
            if (userInput.equals("?")) {
                Scanner fileScan = new Scanner(new File("continentInfo.txt"));
                while (fileScan.hasNextLine()) {
                    System.out.println(fileScan.nextLine());
                }
            } else if (!userInput.equalsIgnoreCase("Regalo di Volci") &&
                    !userInput.equalsIgnoreCase("Cala'corva") &&
                    !userInput.equalsIgnoreCase("Uud") &&
                    !userInput.equalsIgnoreCase("Iagomal") &&
                    !userInput.equalsIgnoreCase("Agri") &&
                    !userInput.equalsIgnoreCase("The Islands of Azadini") &&
                    !userInput.equalsIgnoreCase("Azadini")) {
                System.out.println(userInput + " isn't a state on Khosh'Dâram! Learn your " +
                        "geography, you imbecile!");
                System.out.println("*--------------------------------------------" +
                        "---------------------------------*");
            }
        }

        newCharacter.put("Birthplace", userInput);

        if (userInput.equalsIgnoreCase("Regalo di Volci")) {
            System.out.println("Regalo di Volci is the seat to the City of Saints. " +
                    "It is a symbol of total Order.");
            System.out.println("Growing up beside such magnificence taught you well...");

        } else if (userInput.equalsIgnoreCase("Cala'corva")) {
            System.out.println("The Red Waste turns those not strong enough to sand and " +
                    "alights the soul of a weakling in Whitefyre...");
            System.out.println("...Weak soul, you are not.");

        } else if (userInput.equalsIgnoreCase("Uud")) {
            System.out.println("The mysteries of Uud are equally obscured to those born " +
                    "there as they are to vistors from foreign lands.");
            System.out.println("The rivers and branches of the Wøde wrap around your bones.");

        } else if (userInput.equalsIgnoreCase("Iagomal")) {
            System.out.println("A Province mired in political turmoil since the early days of its founding.");
            System.out.println("The laws and policies of the land have taught you about social forbearance.");

        } else if (userInput.equalsIgnoreCase("Agri")) {
            System.out.println("The sprawling grain fields and ivy forests of Agrí remain, ");
            System.out.println("even as the years change the Barons, Lords, and Ladies.");
            System.out.println("The wind running over the hills will always remind you of home...");

        } else if (userInput.equalsIgnoreCase("The Islands of Azadini")) {
            System.out.println("Its a surprise to most on Khosh'Dâram that the Islands haven't");
            System.out.println("sunk into the ocean for good, (and most pray that they do)...");
            System.out.println("Constant skirmishes with the Sea have hardened your hands and your stare.");

        } else if (userInput.equalsIgnoreCase("Azadini")) {
            System.out.println("Its a surprise to most on Khosh'Dâram that the Islands haven't");
            System.out.println("sunk into the ocean for good, (and most pray that they do)...");
            System.out.println("Constant skirmishes with the Sea have hardened your hands and your stare.");

        }
        System.out.println("*---------------------------------------------------------------" +
                "--------------*");
    }

    //------------------------------------------------------------------------------------------//

    // This method, after selecting their Character's Race, allows the user to
    // select the Specialization they'll be playing as during the course of the game.
        // Parameter: "console", a Scanner that lets the user input data into the program.
        // Parameter: "newCharacter", this is a running tally of all the choices the user
            // has made thus far.
        // Parameter: "specialization", this is a list of all the specializations the user
            // can choose from.
        // Return: N/A
    public static void classSelection(Scanner console, Map<String, String> newCharacter,
                                      String[] specializations) throws FileNotFoundException {

        String userInput = "";
        while(!userInput.equalsIgnoreCase("Champion") &&
                !userInput.equalsIgnoreCase("Troubadour") &&
                !userInput.equalsIgnoreCase("Magician") &&
                !userInput.equalsIgnoreCase("Chaplain") &&
                !userInput.equalsIgnoreCase("Deluviite") &&
                !userInput.equalsIgnoreCase("Shadow")) {

            System.out.println();
            System.out.println("Choose Your Specialization: ");
            System.out.println(Arrays.toString(specializations));
            System.out.println();
            System.out.println("Type \"?\" for more information.");
            System.out.println();

            userInput = console.nextLine();
            System.out.println();
            if (userInput.equals("?")) {
                Scanner fileScan = new Scanner(new File("classInfo.txt"));
                while (fileScan.hasNextLine()) {
                    System.out.println(fileScan.nextLine());
                }
            } else if (!userInput.equalsIgnoreCase("Champion") &&
                    !userInput.equalsIgnoreCase("Troubadour") &&
                    !userInput.equalsIgnoreCase("Chaplain") &&
                    !userInput.equalsIgnoreCase("Magician") &&
                    !userInput.equalsIgnoreCase("Deluviite") &&
                    !userInput.equalsIgnoreCase("Shadow")) {
                System.out.println(userInput + " isn't a Specialization. Perhaps yours " +
                        "is \" nitwit\". Try again.");
                System.out.println("*-------------------------------------------------" +
                        "----------------------------*");
            }
        }

        newCharacter.put("Specialization", userInput);

        if (userInput.equalsIgnoreCase("Champion")) {
            System.out.println("");
        } else if (userInput.equalsIgnoreCase("Troubadour")) {
            System.out.println("");
        } else if (userInput.equalsIgnoreCase("Chaplain")) {
            System.out.println("");
        } else if (userInput.equalsIgnoreCase("Magician")) {
            System.out.println("");
        } else if (userInput.equalsIgnoreCase("Deluviite")) {
            System.out.println("");
        } else if (userInput.equalsIgnoreCase("Shadow")) {
            System.out.println("");
        }
        System.out.println("*---------------------------------------------------------------" +
                "--------------*");
    }

    //------------------------------------------------------------------------------------------//

    // This method, after a call to the Specialization method, allows the user
    // to pick a Profession that is based on their previous choice of class.
        // Parameter: "console", a Scanner that lets the user input data into the program.
        // Parameter: "newCharacter", this is a running tally of all the choices the user
            // has made thus far.
        // Parameter(s): "<Profession>Subclass", these are all the lists of each Specialization's
            // particular subclass.
        // Return: N/A
    public static void profession(Scanner console, Map<String, String> newCharacter,
                                  String[] championSubclass, String[] troubadourSubclass,
                                  String[] chaplainSubclass, String[] magicianSubclass,
                                  String[] deluviiteSubclass, String[] shadowSubclass)
            throws FileNotFoundException {

        if(newCharacter.get("Specialization").equalsIgnoreCase("Champion")) {
            String userInput = "";
            while(!userInput.equalsIgnoreCase("Aural Inferna") &&
                    !userInput.equalsIgnoreCase("Green Knight") &&
                    !userInput.equalsIgnoreCase("Hikkomori")) {

                System.out.println();
                System.out.println("Choose Your Profession: ");
                System.out.println(Arrays.toString(championSubclass));
                System.out.println();
                System.out.println("Type \"?\" for more information.");
                System.out.println();

                userInput = console.nextLine();
                if (userInput.equals("?")) {
                    Scanner fileScan = new Scanner(new File("championInfo.txt"));
                    while (fileScan.hasNextLine()) {
                        System.out.println(fileScan.nextLine());
                    }
                } else if (!userInput.equalsIgnoreCase("Aural Inferna") &&
                        !userInput.equalsIgnoreCase("Green Knight") &&
                        !userInput.equalsIgnoreCase("Hikkomori")) {
                    System.out.println(userInput + "? That's not a Profession. You are an " +
                            "absolute Dumb-Head.");
                    System.out.println("*-------------------------------------------------" +
                            "----------------------------*");
                }
            }
            newCharacter.put("Profession", userInput);

            if(userInput.equalsIgnoreCase("Aural Inferna")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Green Knight")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Hikkomori")) {
                System.out.println("");
            }
            System.out.println("*-----------------------------------------------------" +
                    "------------------------*");

        } else if(newCharacter.get("Specialization").equalsIgnoreCase("Troubadour")) {
            String userInput = "";
            while(!userInput.equalsIgnoreCase("Academy Scholar") &&
                    !userInput.equalsIgnoreCase("Circle Sophist") &&
                    !userInput.equalsIgnoreCase("Flintsteel")) {

                System.out.println();
                System.out.println("Choose Your Profession: ");
                System.out.println(Arrays.toString(troubadourSubclass));
                System.out.println();
                System.out.println("Type \"?\" for more information.");
                System.out.println();

                userInput = console.nextLine();
                if (userInput.equals("?")) {
                    Scanner fileScan = new Scanner(new File("troubadourInfo.txt"));
                    while (fileScan.hasNextLine()) {
                        System.out.println(fileScan.nextLine());
                    }
                } else if (!userInput.equalsIgnoreCase("Academy Scholar") &&
                        !userInput.equalsIgnoreCase("Circle Sophist") &&
                        !userInput.equalsIgnoreCase("Flintsteel")) {
                    System.out.println(userInput + "? That's not a Profession. You are an " +
                            "absolute Dumb-Head.");
                    System.out.println("*-------------------------------------------------" +
                            "----------------------------*");
                }
            }
            newCharacter.put("Profession", userInput);

            if(userInput.equalsIgnoreCase("Academy Scholar")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Circle Sophist")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Flintsteel")) {
                System.out.println("");
            }
            System.out.println("*-----------------------------------------------------" +
                    "------------------------*");

        } else if(newCharacter.get("Specialization").equalsIgnoreCase("Chaplain")) {
            String userInput = "";
            while(!userInput.equalsIgnoreCase("Vaporist") &&
                    !userInput.equalsIgnoreCase("Clergy of the Host") &&
                    !userInput.equalsIgnoreCase("Shaman")) {

                System.out.println();
                System.out.println("Choose Your Profession: ");
                System.out.println(Arrays.toString(chaplainSubclass));
                System.out.println();
                System.out.println("Type \"?\" for more information.");
                System.out.println();

                userInput = console.nextLine();
                if (userInput.equals("?")) {
                    Scanner fileScan = new Scanner(new File("chaplainInfo.txt"));
                    while (fileScan.hasNextLine()) {
                        System.out.println(fileScan.nextLine());
                    }
                } else if (!userInput.equalsIgnoreCase("Vaporist") &&
                        !userInput.equalsIgnoreCase("Clergy of the Host") &&
                        !userInput.equalsIgnoreCase("Shaman")) {
                    System.out.println(userInput + "? That's not a Profession. You are an " +
                            "absolute Dumb-Head.");
                    System.out.println("*-------------------------------------------------" +
                            "----------------------------*");
                }
            }
            newCharacter.put("Profession", userInput);

            if(userInput.equalsIgnoreCase("Vaporist")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Clergy of the Host")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Shaman")) {
                System.out.println("");
            }
            System.out.println("*-----------------------------------------------------" +
                    "------------------------*");

        } else if(newCharacter.get("Specialization").equalsIgnoreCase("Magician")) {
            String userInput = "";
            while(!userInput.equalsIgnoreCase("Astramancer") &&
                    !userInput.equalsIgnoreCase("Triacht") &&
                    !userInput.equalsIgnoreCase("Sybil")) {

                System.out.println();
                System.out.println("Choose Your Profession: ");
                System.out.println(Arrays.toString(magicianSubclass));
                System.out.println();
                System.out.println("Type \"?\" for more information.");
                System.out.println();

                userInput = console.nextLine();
                if (userInput.equals("?")) {
                    Scanner fileScan = new Scanner(new File("magicianInfo.txt"));
                    while (fileScan.hasNextLine()) {
                        System.out.println(fileScan.nextLine());
                    }
                } else if (!userInput.equalsIgnoreCase("Astramancer") &&
                        !userInput.equalsIgnoreCase("Triacht") &&
                        !userInput.equalsIgnoreCase("Sybil")) {
                    System.out.println(userInput + "? That's not a Profession. You are an " +
                            "absolute Dumb-Head.");
                    System.out.println("*-------------------------------------------------" +
                            "----------------------------*");
                }
            }
            newCharacter.put("Profession", userInput);

            if(userInput.equalsIgnoreCase("Astramancer")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Triacht")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Sybil")) {
                System.out.println("");
            }
            System.out.println("*-----------------------------------------------------" +
                    "------------------------*");

        } else if(newCharacter.get("Specialization").equalsIgnoreCase("Deluviite")) {
            String userInput = "";
            while(!userInput.equalsIgnoreCase("Machinenbau") &&
                    !userInput.equalsIgnoreCase("Lazarys") &&
                    !userInput.equalsIgnoreCase("Hex Magus")) {

                System.out.println();
                System.out.println("Choose Your Profession: ");
                System.out.println(Arrays.toString(deluviiteSubclass));
                System.out.println();
                System.out.println("Type \"?\" for more information.");
                System.out.println();

                userInput = console.nextLine();
                if (userInput.equals("?")) {
                    Scanner fileScan = new Scanner(new File("deluviiteInfo.txt"));
                    while (fileScan.hasNextLine()) {
                        System.out.println(fileScan.nextLine());
                    }
                } else if (!userInput.equalsIgnoreCase("Machinenbau") &&
                        !userInput.equalsIgnoreCase("Lazarys") &&
                        !userInput.equalsIgnoreCase("Hex Magus")) {
                    System.out.println(userInput + "? That's not a Profession. You are an " +
                            "absolute Dumb-Head.");
                    System.out.println("*-------------------------------------------------" +
                            "----------------------------*");
                }
            }
            newCharacter.put("Profession", userInput);

            if(userInput.equalsIgnoreCase("Machinenbau")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Lazarys")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Hex Magus")) {
                System.out.println("");
            }
            System.out.println("*-----------------------------------------------------" +
                    "------------------------*");

        } else if(newCharacter.get("Specialization").equalsIgnoreCase("Shadow")) {
            String userInput = "";
            while(!userInput.equalsIgnoreCase("Street Urchin") &&
                    !userInput.equalsIgnoreCase("Guild Fixer") &&
                    !userInput.equalsIgnoreCase("Spook")) {

                System.out.println();
                System.out.println("Choose Your Profession: ");
                System.out.println(Arrays.toString(shadowSubclass));
                System.out.println();
                System.out.println("Type \"?\" for more information.");
                System.out.println();

                userInput = console.nextLine();
                if (userInput.equals("?")) {
                    Scanner fileScan = new Scanner(new File("shadowInfo.txt"));
                    while (fileScan.hasNextLine()) {
                        System.out.println(fileScan.nextLine());
                    }
                } else if (!userInput.equalsIgnoreCase("Street Urchin") &&
                        !userInput.equalsIgnoreCase("Guild Fixer") &&
                        !userInput.equalsIgnoreCase("Spook")) {
                    System.out.println(userInput + "? That's not a Profession. You are an " +
                            "absolute Dumb-Head.");
                    System.out.println("*-------------------------------------------------" +
                            "----------------------------*");
                }
            }
            newCharacter.put("Profession", userInput);

            if(userInput.equalsIgnoreCase("Street Urchin")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Guild Fixer")) {
                System.out.println("");
            } else if(userInput.equalsIgnoreCase("Spook")) {
                System.out.println("");
            }
            System.out.println("*-----------------------------------------------------" +
                    "------------------------*");
        }
    }

    //------------------------------------------------------------------------------------------//

    // This method "stats out" the Character based on all the choices the user has made
    // in the Character Creator up to this point. I.e. Race, Age, Birthplace,
    // Specialization, and Profession.
        // Parameter: "console", a Scanner that lets the user input data into the program.
        // Parameter: "newCharacter", this is a running tally of all the choices the user
            // has made thus far.
        // Parameter: "statList", an ordered List of the Stat names.
        // Parameter: "stats", an ordered list of all the Character's skill statistics.
        // Parameter(s): "<Profession>Subclass", these are all the lists of each Specialization's
            // particular subclass.
        // Parameter: "races", this is an Array of the 5 different playable races.
        // Parameter: "continent", a list of all the States on the continent.
        // Parameter: "specialization", a list of all the Classes the user can choose from.
        // Return: N/A
    public static void statsOut (Scanner console, Map<String, String> newCharacter,
                                 Map<String, Integer> statList,
                                 String[] championSubclass, String[] troubadourSubclass,
                                 String[] chaplainSubclass, String[] magicianSubclass,
                                 String[] deluviiteSubclass, String[] shadowSubclass,
                                 String[] races, String[] continent, String[] Specialization) throws FileNotFoundException {

        statRace(newCharacter.get("Race"), statList);
        statAge(newCharacter.get("Age"), statList);
        statSpecialization(newCharacter.get("Specialization"), statList);
        statProfession(newCharacter.get("Specialization"),
                newCharacter.get("Profession"), statList,
                championSubclass, troubadourSubclass,
                chaplainSubclass, magicianSubclass,
                deluviiteSubclass, shadowSubclass);

        System.out.println();
        System.out.println("And finally...");
        String hero = name(console, newCharacter);

        summary(console, newCharacter, statList, races, continent,
                Specialization, championSubclass, troubadourSubclass,
                chaplainSubclass, magicianSubclass, deluviiteSubclass, shadowSubclass);

        System.out.println();
        System.out.println("May Khoash favour you, Brave " + hero + "...");
        System.out.println("*-----------------------------------------------------" +
                "------------------------*");
        System.out.println();

        // THIS IS WHERE THE CHARACTER IS SAVED / EXPORTED


    }

    //------------------------------------------------------------------------------------------//

    // This method assigns numerical skill values to the Character's Race.
        // Parameter: "race", the Character's chosen race.
        // Parameter: "stats", an ordered list of all the Character's skill statistics.
    // Return: Type 'String',
    public static void statRace(String race, Map<String, Integer> statList) {
        if(race.equalsIgnoreCase("Mannai")) {
            int newNum = statList.get("Persuade") + 1;
            statList.put("Persuade", newNum);

        } else if(race.equalsIgnoreCase("Eefi")) {
            int newNum = statList.get("Cast a Spell") + 1;
            statList.put("Cast a Spell", newNum);

        } else if(race.equalsIgnoreCase("Urkil")) {
            int newNum = statList.get("Melee") + 1;
            statList.put("Melee", newNum);

        } else if(race.equalsIgnoreCase("Morceaux")) {
            int newNum = statList.get("Intuit") + 1;
            statList.put("Intuit", newNum);

        } else if(race.equalsIgnoreCase("Sheol")) {
            int newNum = statList.get("Curse") + 1;
            statList.put("Curse", newNum);

        }
    }

    //------------------------------------------------------------------------------------------//

    // This method assigns numerical skill values to the Character's Age.
        // Parameter: "age", the Character's chosen Age.
        // Parameter: "stats", an ordered list of all the Character's skill statistics.
        // Return: N/A
    public static void statAge(String age, Map<String, Integer> statList) {



    }

    //------------------------------------------------------------------------------------------//

    // This method assigns numerical skill values to the Character's Specialization.
        // Parameter: "specialization", the Character's chosen Specialization.
        // Parameter: "stats", an ordered list of all the Character's skill statistics.
        // Return: N/A
    public static void statSpecialization(String specialization, Map<String, Integer> statList) {
        if(specialization.equalsIgnoreCase("Champion")) {
            int newNumA = statList.get("Melee") + 1;
            statList.put("Melee", newNumA);

            int newNumB = statList.get("Threaten") + 1;
            statList.put("Threaten", newNumB);

            int newNumC = statList.get("Intuit") + 1;
            statList.put("Intuit", newNumC);

        } else if(specialization.equalsIgnoreCase("Troubadour")) {
            int newNumA = statList.get("Persuade") + 1;
            statList.put("Persuade", newNumA);

            int newNumB = statList.get("Obscure") + 1;
            statList.put("Obscure", newNumB);

            int newNumC = statList.get("Tinker") + 1;
            statList.put("Tinker", newNumC);

        } else if(specialization.equalsIgnoreCase("Chaplain")) {
            int newNumA = statList.get("Pray / Beseech") + 1;
            statList.put("Pray / Beseech", newNumA);

            int newNumB = statList.get("Persuade") + 1;
            statList.put("Persuade", newNumB);

            int newNumC = statList.get("Intuit") + 1;
            statList.put("Intuit", newNumC);

        } else if(specialization.equalsIgnoreCase("Magician")) {
            int newNumA = statList.get("Cast a Spell") + 1;
            statList.put("Cast a Spell", newNumA);

            int newNumB = statList.get("Tinker") + 1;
            statList.put("Tinker", newNumB);

            int newNumC = statList.get("Curse") + 1;
            statList.put("Curse", newNumC);

        } else if(specialization.equalsIgnoreCase("Deluviite")) {
            int newNumA = statList.get("Curse") + 1;
            statList.put("Curse", newNumA);

            int newNumB = statList.get("Threaten") + 1;
            statList.put("Threaten", newNumB);

            int newNumC = statList.get("Melee") + 1;
            statList.put("Melee", newNumC);

        } else if(specialization.equalsIgnoreCase("Shadow")) {
            int newNumA = statList.get("Obscure") + 1;
            statList.put("Obscure", newNumA);

            int newNumB = statList.get("Assassinate") + 1;
            statList.put("Assassinate", newNumB);

            int newNumC = statList.get("Pickpocket") + 1;
            statList.put("Pickpocket", newNumC);

        }
    }

    //------------------------------------------------------------------------------------------//

    // This method assigns numerical skill values to the Character's Profession.
        // Parameter: "specialization", the Character's chosen Specialization.
        // Parameter: "profession", the Character's chosen Profession.
        // Parameter(s): "<profession>Subclass", these are all the lists of each Specialization's
            // particular subclass.
        // Return: N/A
    public static void statProfession(String specialization, String profession, Map<String, Integer> statList,
                                        String[] championSubclass,
                                        String[] troubadourSubclass,
                                        String[] chaplainSubclass, String[] magicianSubclass,
                                        String[] deluviiteSubclass, String[] shadowSubclass) {
        if(specialization.equalsIgnoreCase("Champion")) {
            if(profession.equalsIgnoreCase(championSubclass[0])) {
                int newNumA = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumA);

                int newNumB = statList.get("Threaten") + 1;
                statList.put("Threaten", newNumB);

                int newNumC = statList.get("Melee") + 1;
                statList.put("Melee", newNumC);

            } else if(profession.equalsIgnoreCase(championSubclass[1])) {
                int newNumA = statList.get("Pray / Beseech") + 1;
                statList.put("Pray / Beseech", newNumA);

                int newNumB = statList.get("Obscure") + 1;
                statList.put("Obscure", newNumB);

                int newNumC = statList.get("Intuit") + 1;
                statList.put("Intuit", newNumC);

            } else if(profession.equalsIgnoreCase(championSubclass[2])) {
                int newNumA = statList.get("Assassinate") + 1;
                statList.put("Assasinate", newNumA);

                int newNumB = statList.get("Melee") + 1;
                statList.put("Melee", newNumB);

                int newNumC = statList.get("Obscure") + 1;
                statList.put("Obscure", newNumC);

            }
        } else if(specialization.equalsIgnoreCase("Troubadour")) {
            if(profession.equalsIgnoreCase(troubadourSubclass[0])) {
                int newNumA = statList.get("Tinker") + 1;
                statList.put("Tinker", newNumA);

                int newNumB = statList.get("Intuit") + 1;
                statList.put("Intuit", newNumB);

                int newNumC = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumC);

            } else if(profession.equalsIgnoreCase(troubadourSubclass[1])) {
                int newNumA = statList.get("Obscure") + 1;
                statList.put("Obscure", newNumA);

                int newNumB = statList.get("Cast a Spell") + 1;
                statList.put("Cast a Spell", newNumB);

                int newNumC = statList.get("Threaten") + 1;
                statList.put("Threaten", newNumC);

            } else if(profession.equalsIgnoreCase(troubadourSubclass[2])) {
                int newNumA = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumA);

                int newNumB = statList.get("Melee") + 1;
                statList.put("Melee", newNumB);

                int newNumC = statList.get("Pickpocket") + 1;
                statList.put("Pickpocket", newNumC);

            }
        } else if(specialization.equalsIgnoreCase("Chaplain")) {
            if(profession.equalsIgnoreCase(chaplainSubclass[0])) {
                int newNumA = statList.get("Intuit") + 1;
                statList.put("Intuit", newNumA);

                int newNumB = statList.get("Tinker") + 1;
                statList.put("Tinker", newNumB);

                int newNumC = statList.get("Cast a Spell") + 1;
                statList.put("Cast a Spell", newNumC);

            } else if(profession.equalsIgnoreCase(chaplainSubclass[1])) {
                int newNumA = statList.get("Pray / Beseech") + 1;
                statList.put("Pray / Beseech", newNumA);

                int newNumB = statList.get("Cast a Spell") + 1;
                statList.put("Cast a Spell", newNumB);

                int newNumC = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumC);

            } else if(profession.equalsIgnoreCase(chaplainSubclass[2])) {
                int newNumA = statList.get("Curse") + 1;
                statList.put("Curse", newNumA);

                int newNumB = statList.get("Threaten") + 1;
                statList.put("Threaten", newNumB);

                int newNumC = statList.get("Melee") + 1;
                statList.put("Melee", newNumC);

            }
        } else if(specialization.equalsIgnoreCase("Magician")) {
            if(profession.equalsIgnoreCase(magicianSubclass[0])) {
                int newNumA = statList.get("Cast a Spell") + 1;
                statList.put("Cast a Spell", newNumA);

                int newNumB = statList.get("Tinker") + 1;
                statList.put("Tinker", newNumB);

                int newNumC = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumC);

            } else if(profession.equalsIgnoreCase(magicianSubclass[1])) {
                int newNumA = statList.get("Cast a Spell") + 1;
                statList.put("Obscure", newNumA);

                int newNumB = statList.get("Assassinate") + 1;
                statList.put("Assassinate", newNumB);

                int newNumC = statList.get("Pickpocket") + 1;
                statList.put("Pickpocket", newNumC);

            } else if(profession.equalsIgnoreCase(magicianSubclass[2])) {
                int newNumA = statList.get("Curse") + 1;
                statList.put("Curse", newNumA);

                int newNumB = statList.get("Cast a Spell") + 1;
                statList.put("Cast a Spell", newNumB);

                int newNumC = statList.get("Melee") + 1;
                statList.put("Melee", newNumC);

            }
        } else if(specialization.equalsIgnoreCase("Deluviite")) {
            if(profession.equalsIgnoreCase(deluviiteSubclass[0])) {
                int newNumA = statList.get("Obscure") + 1;
                statList.put("Obscure", newNumA);

                int newNumB = statList.get("Curse") + 1;
                statList.put("Curse", newNumB);

                int newNumC = statList.get("Threaten") + 1;
                statList.put("Threaten", newNumC);

            } else if(profession.equalsIgnoreCase(deluviiteSubclass[1])) {
                int newNumA = statList.get("Pray / Beseech") + 1;
                statList.put("Pray / Beseech", newNumA);

                int newNumB = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumB);

                int newNumC = statList.get("Curse") + 1;
                statList.put("Curse", newNumC);

            } else if(profession.equalsIgnoreCase(deluviiteSubclass[2])) {
                int newNumA = statList.get("Tinker") + 1;
                statList.put("Tinker", newNumA);

                int newNumB = statList.get("Intuit") + 1;
                statList.put("Intuit", newNumB);

                int newNumC = statList.get("Curse") + 1;
                statList.put("Curse", newNumC);

            }
        } else if(specialization.equalsIgnoreCase("Shadow")) {
            if(profession.equalsIgnoreCase(shadowSubclass[0])) {
                int newNumA = statList.get("Melee") + 1;
                statList.put("Melee", newNumA);

                int newNumB = statList.get("Threaten") + 1;
                statList.put("Threaten", newNumB);

                int newNumC = statList.get("Pickpocket") + 1;
                statList.put("Pickpocket", newNumC);

            } else if(profession.equalsIgnoreCase(shadowSubclass[1])) {
                int newNumA = statList.get("Threaten") + 1;
                statList.put("Threaten", newNumA);

                int newNumB = statList.get("Assassinate") + 1;
                statList.put("Assassinate", newNumB);

                int newNumC = statList.get("Persuade") + 1;
                statList.put("Persuade", newNumC);

            } else if(profession.equalsIgnoreCase(shadowSubclass[2])) {
                int newNumA = statList.get("Obscure") + 1;
                statList.put("Obscure", newNumA);

                int newNumB = statList.get("Assassinate") + 1;
                statList.put("Assassinate", newNumB);

                int newNumC = statList.get("Curse") + 1;
                statList.put("Curse", newNumC);

            }
        }
    }

    //------------------------------------------------------------------------------------------//

    // This method lets the user give their Character a name.
        // Parameter: "console", a Scanner that lets the user input data into the program.
        // Return: Type 'String', this is the Character's name.
    public static String name(Scanner console, Map<String, String> newCharacter) {

        String answer = "";
        String name = "";
        while(!(answer.equalsIgnoreCase("Yes"))) {
            System.out.println();
            System.out.println("Choose a Name...");
            System.out.println();
            name = console.nextLine();
            System.out.println();
            System.out.println("You have chosen \"" + name + "\" as your name.");
            System.out.println();

            System.out.println("Is this your true name?");
            System.out.println();
            answer = console.nextLine();
            System.out.println();
            if(!(answer.equalsIgnoreCase("No")) &&
                    !(answer.equalsIgnoreCase("Yes"))) {
                System.out.println("You have typed gibberish. Choose a real name...fool.");
            } else if(answer.equalsIgnoreCase("No")) {
                System.out.println("Choose wisely, Hero, for there is power in a name...");
            }
        }

        newCharacter.put("Name", name);
        return name;
    }

    //------------------------------------------------------------------------------------------//

    // This method is a concise summary of everything that has been entered by the
    // user thus far. It also allows the user to edit any information if they feel
    // it is necessary.
        // Parameter: "console", a Scanner that lets the user input data into the program.
        // Parameter: "newCharacter", this is a running tally of all the choices the user
            // has made thus far.
        // Parameter: "statList", an ordered List of the Stat names.
        // Parameter: "stats", an ordered list of all the Character's skill statistics.
        // Parameter(s): "<Profession>Subclass", these are all the lists of each Specialization's
            // particular Profession.
        // Parameter: "races", this is an Array of the 5 different playable races.
        // Parameter: "continent", a list of all the States on the continent.
        // Parameter: "specialization", a list of all the Classes the user can choose from.
        // Return: N/A
    public static void summary(Scanner console, Map<String, String> newCharacter,
                               Map<String, Integer> statList, String[] races,
                               String[] continent, String[] specializations, String[] championSubclass,
                               String[] troubadourSubclass,
                               String[] chaplainSubclass, String[] magicianSubclass,
                               String[] deluviiteSubclass, String[] shadowSubclass)
            throws FileNotFoundException {

        printCharacter(newCharacter, statList);

        System.out.println();
        System.out.println("Does that look right to you?");
        System.out.println("[Yes, No]");
        System.out.println();

        String answer = console.nextLine();
        if(!answer.equalsIgnoreCase("Yes")) {

            String edit = "";
            while(!edit.equalsIgnoreCase("No")) {

                System.out.println();
                System.out.println("What would you like to change?");
                System.out.println("------------------------------");
                System.out.println("[Name, Race, Age, Birthplace, Specialization, Profession]");
                System.out.println();

                String change = console.nextLine();
                if (change.equalsIgnoreCase("Name")) {
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    name(console, newCharacter);
                    System.out.println();
                    printCharacter(newCharacter, statList);

                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                    System.out.println("Would you like to change anything else?");
                    System.out.println("[Yes, No]");
                    System.out.println();
                    edit = console.nextLine();

                } else if (change.equalsIgnoreCase("Race")) {
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    raceSelection(console, races, newCharacter);

                    statList.clear();
                    statList.put("Persuade", 0);
                    statList.put("Threaten", 0);
                    statList.put("Obscure", 0);
                    statList.put("Pickpocket", 0);
                    statList.put("Assassinate", 0);
                    statList.put("Cast a Spell", 0);
                    statList.put("Pray / Beseech", 0);
                    statList.put("Curse", 0);
                    statList.put("Intuit", 0);
                    statList.put("Tinker", 0);
                    statList.put("Melee", 0);

                    statRace(newCharacter.get("Race"), statList);
                    statAge(newCharacter.get("Age"), statList);
                    statSpecialization(newCharacter.get("Specialization"), statList);
                    statProfession(newCharacter.get("Specialization"),
                            newCharacter.get("Profession"), statList,
                            championSubclass, troubadourSubclass,
                            chaplainSubclass, magicianSubclass,
                            deluviiteSubclass, shadowSubclass);

                    System.out.println();
                    printCharacter(newCharacter, statList);

                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                    System.out.println("Would you like to change anything else?");
                    System.out.println("[Yes, No]");
                    System.out.println();
                    edit = console.nextLine();

                } else if (change.equalsIgnoreCase("Age")) {
                    System.out.println();
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    age(console, newCharacter);

                    statList.clear();
                    statList.put("Persuade", 0);
                    statList.put("Threaten", 0);
                    statList.put("Obscure", 0);
                    statList.put("Pickpocket", 0);
                    statList.put("Assassinate", 0);
                    statList.put("Cast a Spell", 0);
                    statList.put("Pray / Beseech", 0);
                    statList.put("Curse", 0);
                    statList.put("Intuit", 0);
                    statList.put("Tinker", 0);
                    statList.put("Melee", 0);

                    statRace(newCharacter.get("Race"), statList);
                    statAge(newCharacter.get("Age"), statList);
                    statSpecialization(newCharacter.get("Specialization"), statList);
                    statProfession(newCharacter.get("Specialization"),
                            newCharacter.get("Profession"), statList,
                            championSubclass, troubadourSubclass,
                            chaplainSubclass, magicianSubclass,
                            deluviiteSubclass, shadowSubclass);

                    System.out.println();
                    printCharacter(newCharacter, statList);

                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                    System.out.println("Would you like to change anything else?");
                    System.out.println("[Yes, No]");
                    System.out.println();
                    edit = console.nextLine();

                } else if (change.equalsIgnoreCase("Birthplace")) {
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    birthplace(console, newCharacter, continent);

                    System.out.println();
                    printCharacter(newCharacter, statList);

                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                    System.out.println("Would you like to change anything else?");
                    System.out.println("[Yes, No]");
                    System.out.println();
                    edit = console.nextLine();

                } else if (change.equalsIgnoreCase("Specialization")) {
                    System.out.println();
                    System.out.println("If you want to change your Specialization you'll " +
                            "have to change your Profession too.");
                    System.out.println("Is this alright?");
                    System.out.println("[Yes, No]");
                    System.out.println();
                    String response = console.nextLine();
                    if(response.equalsIgnoreCase("Yes")) {
                        System.out.println("*-----------------------------------------------------" +
                                "------------------------*");
                        classSelection(console, newCharacter, specializations);
                        profession(console, newCharacter, championSubclass, troubadourSubclass, chaplainSubclass,
                                magicianSubclass, deluviiteSubclass, shadowSubclass);

                        statList.clear();
                        statList.put("Persuade", 0);
                        statList.put("Threaten", 0);
                        statList.put("Obscure", 0);
                        statList.put("Pickpocket", 0);
                        statList.put("Assassinate", 0);
                        statList.put("Cast a Spell", 0);
                        statList.put("Pray / Beseech", 0);
                        statList.put("Curse", 0);
                        statList.put("Intuit", 0);
                        statList.put("Tinker", 0);
                        statList.put("Melee", 0);

                        statRace(newCharacter.get("Race"), statList);
                        statAge(newCharacter.get("Age"), statList);
                        statSpecialization(newCharacter.get("Specialization"), statList);
                        statProfession(newCharacter.get("Specialization"),
                                newCharacter.get("Profession"), statList,
                                championSubclass, troubadourSubclass,
                                chaplainSubclass, magicianSubclass,
                                deluviiteSubclass, shadowSubclass);

                        System.out.println();
                        printCharacter(newCharacter, statList);

                        System.out.println("*-----------------------------------------------------" +
                                "------------------------*");
                        System.out.println();
                        System.out.println("Would you like to change anything else?");
                        System.out.println("[Yes, No]");
                        System.out.println();
                        edit = console.nextLine();

                    } else if(response.equalsIgnoreCase("No")) {
                        edit = "Yes";

                    }

                } else if (change.equalsIgnoreCase("Profession")) {
                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    profession(console, newCharacter, championSubclass, troubadourSubclass, chaplainSubclass,
                            magicianSubclass, deluviiteSubclass, shadowSubclass);

                    statList.clear();
                    statList.put("Persuade", 0);
                    statList.put("Threaten", 0);
                    statList.put("Obscure", 0);
                    statList.put("Pickpocket", 0);
                    statList.put("Assassinate", 0);
                    statList.put("Cast a Spell", 0);
                    statList.put("Pray / Beseech", 0);
                    statList.put("Curse", 0);
                    statList.put("Intuit", 0);
                    statList.put("Tinker", 0);
                    statList.put("Melee", 0);

                    statRace(newCharacter.get("Race"), statList);
                    statAge(newCharacter.get("Age"), statList);
                    statSpecialization(newCharacter.get("Specialization"), statList);
                    statProfession(newCharacter.get("Specialization"),
                            newCharacter.get("Profession"), statList,
                            championSubclass, troubadourSubclass,
                            chaplainSubclass, magicianSubclass,
                            deluviiteSubclass, shadowSubclass);

                    System.out.println();
                    printCharacter(newCharacter, statList);

                    System.out.println("*-----------------------------------------------------" +
                            "------------------------*");
                    System.out.println();
                    System.out.println("Would you like to change anything else?");
                    System.out.println("[Yes, No]");
                    System.out.println();
                    edit = console.nextLine();

                }
            }
        }
    }

    //------------------------------------------------------------------------------------------//

    // This method prints all the previously chosen Character information, i.e.
    // stats, Name, Birthplace, Profession, Specialization, and Age.
        // Parameter: "newCharacter", this is a running tally of all the choices the user
            // has made thus far.
        // Parameter: "statList", an ordered List of the Stat names.
        // Parameter: "stats", an ordered list of all the Character's skill statistics.
        // Return: N/A
    public static void printCharacter (Map<String, String> newCharacter,
                                       Map<String, Integer> statList) {
        System.out.println("*-----------------------------------------------------" +
                "------------------------*");
        System.out.println("*-----------------------------------------------------" +
                "------------------------*");
        System.out.println("This is your Character so far...");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("Your Name: " + newCharacter.get("Name"));
        System.out.println("Your Race: " + newCharacter.get("Race"));
        System.out.println("Your Age: " + newCharacter.get("Age"));
        System.out.println("Your Birthplace: " + newCharacter.get("Birthplace"));
        System.out.println("Your Specialization: " + newCharacter.get("Specialization"));
        System.out.println("Your Profession: " + newCharacter.get("Profession"));
        System.out.println();

        System.out.println("These are your current stats:");
        System.out.println("-----------------------------");

        Set<String> statNames = statList.keySet();
        for(String name : statNames) {
            int statNum = statList.get(name);
            if(!(statNum == 0)) {
                System.out.println(name + ": " + statNum);
            }
        }
        System.out.println();
        System.out.println("All other stats are stabilized at Lvl. 0");
        System.out.println("-----------------------------");
    }

}