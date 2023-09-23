package ParrotCraft;

import java.lang.Math;  // imported math.random to get random number for feedParrot()
import java.util.Scanner; // imported scanner for inputs

/**
 * Implementation of the class for ParrotCraft and all of its methods.
 * ParrotCraft allows the user to interact with parrots using five methods.
 * @author Joshua Cruz
 */
public class Parrot {

    /** default parrot name **/
    private String name;
    /** default number of hearts (health) **/
    private int health;
    /** default amount of cracker crumbs in stomach **/
    private double crumbs;
    /** default untamed **/
    private boolean isTame;
    /** default parrot is alive **/
    private boolean isAlive;
    /** the parrot is flying on default **/
    private boolean isFlying;

    /** name setter **/
    public void setName(String name) {
        this.name = name;
    }
    /** crumbs setter **/
    public void setCrumbs(double crumbs) {
        this.crumbs = crumbs;
    }
    /** constructor **/
    public Parrot(String name, int health, double crumbs, boolean isTame, boolean isAlive, boolean isFlying) {
        this.name = name;
        this.health = health;
        this.crumbs = crumbs;
        this.isTame = isTame;
        this.isAlive = isAlive;
        this.isFlying = isFlying;
    }
    /**
     * feeds the parrot
     * @param fedCrumbs the amount of crumbs fed in kg
     */
    public void feedParrot(double fedCrumbs) {
        if (isAlive && health < 3) {
            health += 1;        // +1 health is added to the parrot when fed
            crumbs += fedCrumbs; // the input by the user is added to the existing amount of crumbs in the parrot's stomach
            // https://www.geeksforgeeks.org/java-math-random-method-examples/
            if (Math.random()*100 <= fedCrumbs*20){
                isTame = true;
                /** given a random number from 1-100, if it's less than the
                 * given number multiplied by 20 in regards to crumbs, that is the
                 * probability of taming the parrot.
                 */
            }
            /**
             * Once the amount is greater than 2.5 kg, the parrot loses 2 health
             */
            if ( crumbs > 2.5 ) {
                health -= 2;
                if (health <= 0){       // Once the parrot reaches 0 health, it is DEAD
                    health = 0;
                    isAlive = false;
                }
            }
        } else if (isAlive && health == 3) {
            crumbs += fedCrumbs;
            if (Math.random()*100 <= fedCrumbs*20){
                isTame = true;
            }
            if ( crumbs > 2.5 ) {
                health -= 2;
                if (health <= 0){
                    health = 0;
                    isAlive = false;
                }
            }
        } else {
            System.out.println("The parrot is already dead!");      // A DEAD parrot cannot be fed
        }
    }
    /**
     * commands the tamed parrot to either fly or sit
     */
    public void commandParrot() {
        if (isAlive) {
            if (isTame) {
                Scanner input = new Scanner(System.in);     // input
                int birdAction;
                do {
                    System.out.print("1. Fly or 2. Stay? ");
                    birdAction = input.nextInt();

                    if (birdAction == 1) {      // the bird is asked to fly
                        if (isFlying) {
                            System.out.println("Parrot is already flying");     //when a flying parrot is asked to fly
                        } else {
                            isFlying = true;
                            System.out.println("Parrot starts to fly!");        //a sitting parrot is asked to fly
                        }
                    } else if (birdAction == 2) {       // the bird is asked to sit
                        if (isFlying) {
                            System.out.println("Parrot lands and sits");        // a flying parrot is asked to sit
                            isFlying = false;
                        } else {
                            System.out.println("Parrot is already sitting");        // a sitting parrot is asked to sit
                        }
                    } else {
                        System.out.println("Please enter a valid input!");          // for invalid inputs
                    }
                } while ((birdAction != 1) && (birdAction != 2));
            } else {
                System.out.println("Parrot is not tamed!");         // Parrot cannot be commanded if not tamed
            }
        } else {
            System.out.println("The parrot is already dead!");      //Cannot command a DEAD Parrot
        }
    }
    /**
     * asks the user to pick two parrots and have them play with each other, resulting
     * to both of them being untamed
     * @params otherParrot
     */
    public void playParrot(Parrot otherParrot){
        if (isAlive || otherParrot.isAlive) {        // verify if both parrots are alive
            if (isTame && otherParrot.isTame){
                System.out.println("Parrots are now playing. But now they've rediscovered the joy of their own species, they are now untamed!");
                isTame = false;
                otherParrot.isTame = false;             // both parrots become untamed after playing with each other
            } else {
                System.out.println("Untamed parrots cannot play!");     // untamed parrots cannot play
            }
        } else {
            System.out.println("Dead parrots cannot play!");        //DEAD parrots cannot play
        }
    }
    /**
     * the user hits the parrot, resulting in them losing 1 health
     */
    public void hitParrot() {
        if (isAlive){
            health -= 1;            //parrot loses 1 health when hit by the user
            isTame = false;         //parrot becomes untamed after being hit
            if (health > 0) {
                System.out.println("Ouch!");
            } else {
                health = 0;         //parrot dies when health becomes 0
                isAlive = false;
                System.out.println("Parrot is dead!");
            }
        } else {
            System.out.println("Bruh, it's already dead!");     //parrot cannot lose health when it's already dead
        }
    }
    /**
     * Displays a full report on the parrots
     */
    public String screenShow() {
        String isTameOutput;
        if (isTame) {
            isTameOutput = "Tamed ";
        }   else {
            isTameOutput = "Untamed ";
        }
        String isAliveOutput;
        if (isAlive) {
            isAliveOutput = "";
        } else {
            isAliveOutput = "DEAD ";
        }
        String isFlyingOutput;
        if (isFlying) {
            isFlyingOutput = "flying ";
        } else {
            isFlyingOutput = "sitting ";
        }
        /**
         * @return the status report of the parrots
         */
        return isTameOutput + isAliveOutput + " Parrot " + name + ": " + crumbs + "kg crumbs, " + health + " hearts, " + isFlyingOutput;
    }
};

