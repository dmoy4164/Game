/**
  * Represents the game as a whole.
  */
public class Game {
    /**
     * Represents the amount of health the enemy has. By default, the first enemy has 200 health.
     */
    public double eHealth = 200;
    /**
     * Represents the amount of health the user has. By default, the user has 100 health.
     */
    public double uHealth = 100;
    /**
     * Stores the user's inputted name.
     */
    public String name;
    /**
     * Stores the enemy's name. By default, the first enemy is 'Elias Wu Feng'.
     */
    public String eName = ("Elias Wu Feng");
    /**
     * Stores the user's choice of weapon. By default, it is 'fists'.
     */
    public String weapon = "fists";
    /**
     * Stores the base damage of the weapon the user chose. By default, it is 5 damage with 'fists'.
     */
    private double uDamage = 5;
    /**
     * Stores the base damage of the enemy. By default, it is 0.
     */
    private double eDamage = 0;
    /**
     * Stores the user's choice of action.
     */
    public String action = "";
    /**
     * Stores the total amount of bread the user has. By default, it is 5.
     */
    public int bread = 5;
    /**
     * Stores the total amount of water the user has. By default, it is 5.
     */
    public int water = 5;
    /**
     * Determines which fight the user is in.
     */
    public int fight = 1;

    /**
  * Constructs the user through their name and choice of weapon.
  * @param nameA Sets the user's name to variable name.
  * @param weaponA Sets the user's weapon to variable weapon.
     */
    public Game (String nameA, String weaponA){
        name = nameA;
        weapon = weaponA;
        if (weapon.equalsIgnoreCase("sword")){
            uDamage = 20;
        }
        if (weapon.equalsIgnoreCase("mace")){
            uDamage = 30;
        }
        if (weapon.equalsIgnoreCase("keyboard")){
            uDamage = 26;
        }
        if (weapon.equalsIgnoreCase("apcsa textbook")){
            uDamage = 40;
        }
    }
    /**
     * Constructs the user through their name and defaulting their weapon of choice to 'fists'. If certain special names are chosen, unreasonable amount of stats are given.
     * @param nameB Sets the user's name to variable name.
     */
    public Game (String nameB){
        name = nameB;
        if (name.equalsIgnoreCase("saitama")){
            uDamage = 200;
        }
        if (name.equalsIgnoreCase("donnie")){
            uHealth = 54321;
            uDamage = 12345;
        }
    }
    /**
     * Returns the user's name and choice of weapon.
     * @return String - The user's name and choice of weapon.
     */
    public String toString(){
        return ("Name: " + name + "\n" + "Weapon: " + weapon);
    }

    /**
     * Determines the user's turn and their actions and carries them out. Also contains the amount of damage the user and enemy will do.
     * @param action Decides the action the user uses.
     * @return String - Commentary on the action the user used and the effect it had on the enemy.
     */
    public String userTurn (String action){
        //add item usage//
        if (fight == 1){
            eDamage = Math.random()*15+1;
        } else if (fight == 2){
            eDamage = Math.random()*20+1;
        } else {
            eDamage = Integer.MIN_VALUE;
        }
        double halfChance = Math.random();
        if (halfChance>=0.5){
            uDamage = uDamage + (Math.random()*(10)+1);
        } else {
            uDamage = uDamage - (Math.random()*(2)+1);
        }

        if (action.equalsIgnoreCase("attack")){
            eHealth = eHealth - uDamage;

            return("You did " + uDamage + " damage!");
        }
        if (action.equalsIgnoreCase("flee")){
            return("no.");
        }
        if (action.equalsIgnoreCase("block")){
            eDamage = eDamage /2;
            return("You prepare for an incoming attack.");
        }
        if (action.equalsIgnoreCase("use water")){
            return(itemUse("water"));
        }
        if (action.equalsIgnoreCase("use bread")){
            return(itemUse("bread"));
        }
        if (action.equals("System.exit(0);")){
            eHealth = 0;
            return("\n" + "i-i-impossible! how?!" + "\n" +"Process finished with exit code 0" + "\n");

        }
        return ("that's not an action!");
    }
    /**
     * Determines the enemy's actions and carries them out. Deals the damage to the user.
     * Prints commentary on the action the enemy used and the effect it had on the user.
     */
    public void enemyTurn(){
        int output = (int) (Math.random()*(4)+1);
        if (fight == 1){
            if (output == 1){
                System.out.println(eName + " tackles you.");
            }
            if (output == 2){
                System.out.println(eName + " punches you.");
            }
            if (output == 3){
                System.out.println(eName + " kicks you.");
            }
            if (output == 4){
                System.out.println(eName + " headbutts you.");
            }

        } else if (fight == 2){
            if (output == 1){
                System.out.println("Andy throws his backpack at you.");
            }
            if (output ==2){
                System.out.println("Andy pats you on the back.");
            }
            if (output == 3){
                System.out.println("Andy stares at you and smiles.");
            }
            if (output ==4){
                System.out.println("Andy taps on your head with a pencil.");
            }
        } else{
            if (output == 1){
                System.out.println(eName + " compiles you to git.");
            }
            if (output == 2){
                System.out.println(eName + " sends you to github.");
            }
            if (output == 3){
                System.out.println(eName + " runs your process.");
            }
            if (output == 4){
                System.out.println(eName + " throws an error at you.");
            }
        }
        uHealth = uHealth - eDamage;
        System.out.println(eDamage + " damage taken!");
    }
    /**
     * Allows for the user to use items.
     * @param item Selects the item to be used accordingly.
     * @return String - Commentary on the item used.
     */
    public String itemUse(String item){
        if (item.equalsIgnoreCase("water")){
            if (water>0){
                uHealth = 100;
                water = water-1;
                return ("You drank water. HP restored to full.");
            } else {
                return ("You have no water!");
            }
        }

        if (item.equalsIgnoreCase("bread")){
            if (bread>0){
                eHealth = eHealth -75;
                bread = bread-1;
                return ("You threw your bread at " + eName + ". They take 75 damage.");
            } else {
                return ("You have no bread!");
            }
        }

        return "";
    }
    /**
     * Organizes large blocks of text into one place to be called.
     * @param num Allows for selection of which section of text to print.
     * Prints out lots of text.
     */
    public void talk (int num){
        if (num == 1){
            System.out.println();
            System.out.println(eName + ": " + eHealth + " HP");
            System.out.println("You: " + uHealth + " HP");
            System.out.println("What do you want to do? attack/flee/block");
        }
        if (num == 2){
            System.out.println("now go defeat the evil minion, " + eName + "\n"+"\n");
            System.out.println("------------------" + "\n" + "ELIAS WU FENG INCOMING!!" + "\n"+"------------------"+"\n");
        }
        if (num == 3){
            System.out.println("\n"+ eName +": " + name + ", remember our words...system dot exit...");
            System.out.println();
            System.out.println("Congrats, " + name + ". You've defeated the ruthless Elias Wu Feng. Here, drink some water.");
            System.out.println(itemUse("water"));
            System.out.println("Here, take this bread and water too.");
            System.out.println("Water x5 obtained ; Bread x5 obtained");
            System.out.println("(use by saying 'use (item name)' during your turn)");
        }
        if (num == 4){
            System.out.println("Now that Elias Wu Feng is gone, it's time for you to fight Andy Liang. There he is!");
            System.out.println("------------------" + "\n" + "ANDY LIANG APPROACHES!!" + "\n" + "------------------" + "\n");
        }
        if (num == 5){
            System.out.println();
            System.out.println(eName + ": " + eHealth + " HP");
            System.out.println("You: " + uHealth + " HP");
            System.out.println("What do you want to do? attack/flee/block/use item");
        }
        if (num == 0){
            System.out.println("\n"+ eName + ": kghhgjhbfhdgmakhfgjfdk...zero...");
            System.out.println("Congrats, " + name + ". You've defeated the mighty Andy Liang. Now this may be unexpected, ");
            System.out.println("but it's time for me to rid of you. I must thank you for freeing me of all constraints. ");
            System.out.println("I'll play with you for a bit...");
            System.out.println("------------------" + "\n" + "IntelliJ IDEA Community Edition 2022.2.2 decides to have fun." + "\n" + "------------------" + "\n");
        }
        if (num == 6){
            System.out.println("With IntelliJ defeated, " + name + " returns to the classroom, tired and gasping for breath.");
            System.out.println(name + " is then congratulated by their classmates and teacher.");
            System.out.println("1x Thumbs Up received from Mr.Folwell");
            System.out.println("HP recovered to full.");
            System.out.println();
            System.out.println("THE END");
            System.out.println("-----------------");
        }
    }
}
