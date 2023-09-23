package ParrotCraft;

/** Imported scanner **/
import java.util.Scanner;

/**
 * This program is the interaction between a user and a parrot.
 * @author Joshua Cruz
 */
public class ParrotCraft {
    /**
     * @param args unused
     */
    public static void main(String[] args) {
        Parrot parrotOne = new Parrot("Julius", 3, 0.1, false, true, true);
        Parrot parrotTwo = new Parrot("Julius", 3, 0.1, false, true, true);
        Parrot parrotThree = new Parrot("Julius", 3, 0.1, false, true, true);

        Scanner input = new Scanner(System.in);
        int user_in = 0;
        while (user_in != 5) {
            /** output **/
            System.out.println("---------------------------");
            System.out.println("1. " + parrotOne.screenShow());
            System.out.println("2. " + parrotTwo.screenShow());
            System.out.println("3. " + parrotThree.screenShow());
            System.out.println("---------------------------");
            System.out.println("1: Feed");
            System.out.println("2: Command");
            System.out.println("3: Play");
            System.out.println("4: Hit");
            System.out.println("5: Quit");
            System.out.print("Select An Option: ");

            /** input **/
            user_in = input.nextInt();
            System.out.println("---------------------------");

            /** processing **/
            if (user_in == 1) {
                do {
                    System.out.print("Which parrot? ");
                    user_in = input.nextInt();

                    if (user_in != 1 && user_in != 2 && user_in != 3) {
                        System.out.println("Enter a valid input!");
                    } else {
                        System.out.print("How much crackers in kg do you want to feed? ");
                        double crackers = input.nextDouble();
                        if (user_in == 1) {
                            parrotOne.feedParrot(crackers);
                        } else if (user_in == 2) {
                            parrotTwo.feedParrot(crackers);
                        } else if (user_in == 3) {
                            parrotThree.feedParrot(crackers);
                        }
                    }
                } while (user_in != 1 && user_in != 2 && user_in != 3);
            } else if (user_in == 2) {
                do {
                    System.out.print("Which parrot? ");
                    user_in = input.nextInt();
                    if (user_in != 1 && user_in != 2 && user_in != 3) {
                        System.out.println("Enter a valid input!");
                    } else {
                        if (user_in == 1) {
                            parrotOne.commandParrot();
                        } else if (user_in == 2) {
                            parrotTwo.commandParrot();
                        } else if (user_in == 3) {
                            parrotThree.commandParrot();
                        }
                    }
                } while (user_in != 1 && user_in != 2 && user_in != 3);
            } else if (user_in == 3) {
                int parrotA = 0;
                int parrotB = 0;
                do {
                    System.out.print("Pick the first parrot? ");
                    user_in = input.nextInt();
                    if (user_in != 1 && user_in != 2 && user_in != 3) {
                        System.out.println("Enter a valid input!");
                    } else {
                        parrotA = user_in;
                    }
                } while (user_in != 1 && user_in != 2 && user_in != 3);
                do {
                    System.out.print("Pick the second parrot? ");
                    user_in = input.nextInt();
                    if (user_in != 1 && user_in != 2 && user_in != 3) {
                        System.out.println("Enter a valid input!");
                    } else if (user_in == parrotA) {
                        System.out.println("Cannot select the same parrot!");
                    } else {
                        parrotB = user_in;
                    }
                } while ((user_in != 1 && user_in != 2 && user_in != 3) || (user_in == parrotA));
                if (parrotA == 1) {
                    if (parrotB == 2) {
                        parrotOne.playParrot(parrotTwo);
                    } else if (parrotB == 3) {
                        parrotOne.playParrot(parrotThree);
                    }
                } else if (parrotA == 2) {
                    if (parrotB == 1) {
                        parrotTwo.playParrot(parrotOne);
                    } else if (parrotB == 3) {
                        parrotTwo.playParrot(parrotThree);
                    }
                } else if (parrotA == 3) {
                    if (parrotB == 1) {
                        parrotThree.playParrot(parrotOne);
                    } else if (parrotB == 2) {
                        parrotThree.playParrot(parrotTwo);
                    }
                }
            } else if (user_in == 4) {
                do {
                    System.out.print("Which parrot? ");
                    user_in = input.nextInt();
                    if (user_in != 1 && user_in != 2 && user_in != 3) {
                        System.out.println("Enter a valid input!");
                    } else {
                        if (user_in == 1) {
                            parrotOne.hitParrot();
                        } else if (user_in == 2) {
                            parrotTwo.hitParrot();
                        } else if (user_in == 3) {
                            parrotThree.hitParrot();
                        }
                    }
                } while (user_in != 1 && user_in != 2 && user_in != 3);
            } else if (user_in == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Enter a valid input!");
            }
        }
    }
}
