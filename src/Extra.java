import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Extra {
    // This contains all the code I might need later if I majorly F it up.

    //------------------------------------------------------------------------------------------//


//    public static void outcome(Scanner console, SetPosition position, SetEffect effect,
//                               Map<String, Integer> characterStats,
//                               Map<String, Clock> clockList, Map<String, String> actionHistory,
//                               Map< String, HashSet<String>> actions,
//                               Dice dicePool, OutcomeCheck newOutcome)
//            throws FileNotFoundException {
//
//        // Relevant Objects / Variables:
//        String outcome = "";
//        String cautionMessage = "Would you still like to perform this action? \n" +
//                "[Yes, No] \n";
//        String effectMessage = "Orenzio will remember that...";
//
//        // Primes the Results .txt Scanner
//        String actionChoice = "Obscure 1";
//        Scanner fileScan = new Scanner(new File(actionChoice + ".txt"));
//        // This checks if we've reached the proper text
//        int resultCheck = 0;
//
//        // Loop continues until an action is confirmed
//        while(actionHistory.isEmpty()) {
//
//            // Loop Primer
//            String decision = "?";
//
//            // If "?" is chosen, loop will continuously prompt for an action
//            while(decision.equals("?")) {
//                decision = questionPrompt(console, actions);
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//            }
//
//            // Action Outcomes:
//            if (decision.equalsIgnoreCase("Obscure")) {
//
//                // Set Position & Effect:
//                position.risky();
//                effect.limited();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Obscure")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Obscure")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//                        actionChoice = "Obscure 1";
//                        while(fileScan.hasNextLine()) {
//                            String consideredLine = fileScan.nextLine();
//                            if(consideredLine.equals("BAD")) {
//                                resultCheck = 1;
//                                consideredLine = fileScan.nextLine();
//                            }
//                            if(resultCheck == 1) {
//                                System.out.println(consideredLine);
//                                if(consideredLine.equals("*--------------------------------------" +
//                                        "---------------------------------------*")) {
//                                    break;
//                                }
//                            }
//                        }
//                        System.out.println(effectMessage);
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        actionHistory.put("Obscure", "Bad");
//
//                    } else if (outcome.equals("Mixed")) {
//                        actionChoice = "Obscure 1";
//                        while(fileScan.hasNextLine()) {
//                            String consideredLine = fileScan.nextLine();
//                            if(consideredLine.equals("MIXED")) {
//                                resultCheck = 1;
//                                consideredLine = fileScan.nextLine();
//                            }
//                            if(resultCheck == 1) {
//                                System.out.println(consideredLine);
//                                if(consideredLine.equals("*--------------------------------------" +
//                                        "---------------------------------------*")) {
//                                    break;
//                                }
//                            }
//                        }
//                        System.out.println(effectMessage);
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        actionHistory.put("Obscure", "Mixed");
//
//                    } else if (outcome.equals("Good")) {
//                        actionChoice = "Obscure 1";
//                        while(fileScan.hasNextLine()) {
//                            String consideredLine = fileScan.nextLine();
//                            if(consideredLine.equals("GOOD")) {
//                                resultCheck = 1;
//                                consideredLine = fileScan.nextLine();
//                            }
//                            if(resultCheck == 1) {
//                                System.out.println(consideredLine);
//                                if(consideredLine.equals("*--------------------------------------" +
//                                        "---------------------------------------*")) {
//                                    break;
//                                }
//                            }
//                        }
//                        actionHistory.put("Obscure", "Good");
//
//                    } else if (outcome.equals("Critical")) {
//                        clockList.get("sneakClock").tickUp(2);
//                        clockList.get("sneakClock").clockStatus(); // THIS IS TO CHECK IF IT IS RIGHT
//
//                        actionChoice = "Obscure 1";
//                        while(fileScan.hasNextLine()) {
//                            String consideredLine = fileScan.nextLine();
//                            if(consideredLine.equals("CRITICAL")) {
//                                resultCheck = 1;
//                                consideredLine = fileScan.nextLine();
//                            }
//                            if(resultCheck == 1) {
//                                System.out.println(consideredLine);
//                                if(consideredLine.equals("*--------------------------------------" +
//                                        "---------------------------------------*")) {
//                                    break;
//                                }
//                            }
//                        }
//                        System.out.println(effectMessage);
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        actionHistory.put("Obscure", "Critical");
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Pickpocket")) {
//
//                // Set Position & Effect:
//                position.desperate();
//                effect.great();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Pickpocket")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Pickpocket")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Assasinate")) {
//
//                // Set Position & Effect:
//                position.desperate();
//                effect.extreme();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Assassinate")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Assassinate")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Threaten")) {
//
//                // Set Position & Effect:
//                position.risky();
//                effect.standard();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Threaten")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Threaten")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Persuade")) {
//                // Set Position & Effect:
//                position.controlled();
//                effect.great();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Persuade")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Persuade")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Discuss")) {
//
//            } else if (decision.equalsIgnoreCase("North")) {
//
//            } else if (decision.equalsIgnoreCase("South")) {
//
//            } else if (decision.equalsIgnoreCase("East")) {
//
//            } else if (decision.equalsIgnoreCase("West")) {
//
//            } else if (decision.equalsIgnoreCase("Forward")) {
//
//            } else if (decision.equalsIgnoreCase("Cast a Spell")) {
//
//                // Set Position & Effect:
//                position.risky();
//                effect.limited();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Cast a Spell")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Cast a Spell")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Pray / Beseech")) { // Need to incorporate Concordance Clock
//
//                // Set Position & Effect:
//                position.desperate();
//                effect.limited();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Pray / Beseech")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Pray / Beseech")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Curse")) {
//
//                // Set Position & Effect:
//                position.desperate();
//                effect.great();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Curse")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Curse")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//            } else if (decision.equalsIgnoreCase("Intuit")) {
//
//                // Set Position & Effect:
//                position.controlled();
//                effect.standard();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Intuit")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Intuit")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//
//
//
//
//
//            } else if (decision.equalsIgnoreCase("Tinker")) {
//
//                // Set Position & Effect:
//                position.controlled();
//                effect.standard();
//                System.out.println();
//
//                // Confirmation Message:
//                System.out.println(cautionMessage);
//                String answer = console.nextLine();
//                System.out.println("*-------------------------------------------------------" +
//                        "----------------------*");
//                System.out.println();
//
//                // "Yes" Confirmation, continues on with chosen action
//                if (answer.equalsIgnoreCase("Yes")) {
//
//                    if (characterStats.containsKey("Tinker")) {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2 +
//                                characterStats.get("Tinker")));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    } else {
//                        outcome = newOutcome.currentOutcome(dicePool.rollDice(2));
//                        System.out.println("*-------------------------------------------------------" +
//                                "----------------------*");
//                        System.out.println();
//                    }
//
//                    // Outcome Trees:
//                    if (outcome.equals("Bad")) {
//
//                    } else if (outcome.equals("Mixed")) {
//
//                    } else if (outcome.equals("Good")) {
//
//                    } else if (outcome.equals("Critical")) {
//
//                    }
//
//                    // "No" Confirmation, allows for re-selecting of an action
//                } else if (answer.equalsIgnoreCase("No")) {
//                    // Go back to action menu here
//                }
//            }
//        }
//
//    }

    //------------------------------------------------------------------------------------------//

}
