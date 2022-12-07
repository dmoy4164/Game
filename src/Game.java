/**
  * Represents the game as whole.
  */
public class Game {
    /**
     * Represents the amount of health the enemy has. By default, the first enemy has 200 health.
     */
    public double ehealth = 200;
    /**
     * Represents the amount of health the user has. By default, the user has 100 health.
     */
    public double uhealth = 100;
    /**
     * Stores the user's inputted name.
     */
    public String name;
    /**
     * Stores the enemy's name. By default, the first enemy is 'Elias Wu Feng'.
     */
    public String ename = ("Elias Wu Feng");
    /**
     * Stores the user's choice of weapon. By default, it is 'fists'.
     */
    public String weapon = "fists";
    /**
     * Stores the base damage of the weapon the user chose. By default, it is 5 damage with 'fists'.
     */
    private double udamage = 5;
    /**
     * Stores the base damage of the enemy. By default, it is 0.
     */
    private double edamage = 0;
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
  * Constructs the user through their name and choice of weapon.
  * @param nam Sets the user's name to variable name.
  * @param weap Sets the user's weapon to variable weapon.
     */
    public Game (String nam, String weap){
        name = nam;
        weapon = weap;
        if (weapon.equalsIgnoreCase("sword")){
            udamage = 20;
        }
        if (weapon.equalsIgnoreCase("mace")){
            udamage = 30;
        }
        if (weapon.equalsIgnoreCase("keyboard")){
            udamage = 26;
        }
        if (weapon.equalsIgnoreCase("apcsa textbook")){
            udamage = 40;
        }
    }
    /**
     * Constructs the user through their name and defaulting their weapon of choice to 'fists'. If certain special names are chosen, unreasonable amount of stats are given.
     * @param namee Sets the user's name to variable name.
     */
    public Game (String namee){
        name = namee;
        if (name.equalsIgnoreCase("saitama")){
            udamage = 200;
        }
        if (name.equalsIgnoreCase("donnie")){
            uhealth = 54321;
            udamage = 12345;
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
     * @param abc Decides the action the user uses.
     * @param fight Decides which fight the user is in, which also determines what actions are available and enemy's damage.
     * @return String - Commentary on the action the user used and the effect it had on the enemy.
     */
    public String userTurn (String abc, int fight){
        //add item usage//
        if (fight == 1){
            edamage = Math.random()*15+1;
        } else if (fight == 2){
            edamage = Math.random()*20+1;
        } else {
            edamage = Integer.MIN_VALUE;
        }
        double halfChance = Math.random();
        if (halfChance>=0.5){
            udamage = udamage + (Math.random()*(10)+1);
        } else {
            udamage = udamage - (Math.random()*(2)+1);
        }

        if (abc.equalsIgnoreCase("attack")){
            ehealth = ehealth - udamage;

            return("You did " + udamage + " damage!");
        }
        if (abc.equalsIgnoreCase("flee")){
            return("no.");
        }
        if (abc.equalsIgnoreCase("block")){
            edamage = edamage/2;
            return("You prepare for an incoming attack.");
        }
        if (abc.equalsIgnoreCase("use water")){
            return(itemUse("water"));
        }
        if (abc.equalsIgnoreCase("use bread")){
            return(itemUse("bread"));
        }
        if (abc.equals("System.exit(0);")){
            ehealth = 0;
            return("\n" + "i-i-impossible! how?!" + "\n" +"Process finished with exit code 0" + "\n");

        }
        return ("that's not an action!");
    }
    /**
     * Determines the enemy's actions and carries them out. Deals the damage to the user.
     * @param enemy Decides which enemy the user is fighting.
     * @return String - Commentary on the action the enemy used and the effect it had on the user.
     */
    public void enemyTurn(int enemy){
        int output = (int) (Math.random()*(4)+1);
        if (enemy == 1){
            if (output == 1){
                System.out.println(ename + " tackles you.");
            }
            if (output == 2){
                System.out.println(ename + " punches you.");
            }
            if (output == 3){
                System.out.println(ename + " kicks you.");
            }
            if (output == 4){
                System.out.println(ename + " headbutts you.");
            }

        } else if (enemy == 2){
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
                System.out.println(ename + " compiles you to git.");
            }
            if (output == 2){
                System.out.println(ename + " sends you to github.");
            }
            if (output == 3){
                System.out.println(ename + " runs your process.");
            }
            if (output == 4){
                System.out.println(ename + " throws an error at you.");
            }
        }
        uhealth = uhealth-edamage;
        System.out.println(edamage + " damage taken!");
    }
    /**
     * Allows for the user to use items.
     * @param item Selects the item to be used accordingly.
     * @return String - Commentary on the item used.
     */
    public String itemUse(String item){
        if (item.equalsIgnoreCase("water")){
            if (water>0){
                uhealth = 100;
                return ("You drank water. HP restored to full.");
            } else {
                return ("You have no water!");
            }
        }
        water= water-1;
        if (item.equalsIgnoreCase("bread")){
            if (bread>0){
                ehealth = ehealth-75;
                return ("You threw your bread at " + ename + ". They take 75 damage.");
            } else{
                return ("You have no bread!");
            }
        }
        bread = bread-1;
        return "";
    }
    /**
     * Organizes large blocks of text into one place to be called.
     * @param num Allows for selection of which section of text to print.
     * @return void - Prints out lots of text.
     */
    public void talk (int num){
        if (num == 1){
            System.out.println();
            System.out.println(ename + ": " + ehealth + " HP");
            System.out.println("You: " + uhealth + " HP");
            System.out.println("What do you want to do? attack/flee/block");
        }
        if (num == 2){
            System.out.println("now go defeat the evil minion, " +ename + "\n"+"\n");
            System.out.println("------------------" + "\n" + "ELIAS WU FENG INCOMING!!" + "\n"+"------------------"+"\n");
        }
        if (num == 3){
            System.out.println("\n"+ename+": " + name + ", remember our words...system dot exit...");
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
            System.out.println(ename + ": " + ehealth + " HP");
            System.out.println("You: " + uhealth + " HP");
            System.out.println("What do you want to do? attack/flee/block/use item");
        }
        if (num == 0){
            System.out.println("\n"+ename + ": kghhgjhbfhdgmakhfgjfdk...zero...");
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
