import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*
         * Begins the game.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println( "hi. an evil guy has been terrorizing the APCSA classroom for months. we desperately need your help." + "\n"+
                "his name is andy liang and you must defeat him. you have no choice in the matter. practice first on his evil minion, elias wu feng." + "\n"+
                "wait, i forgot to ask. whats your name?");
        String a = scan.nextLine();
        Game start = new Game(a);
        System.out.println("ok "+a+", do you want a weapon? (yes/no)");
        String c = scan.nextLine();
        if (c.equals("yes")){
            System.out.println("what weapon? i have the following: sword, mace, keyboard, apcsa textbook");
            String b = scan.nextLine();
            start = new Game(a, b);
        } else {
            System.out.println("wow ok. confident aren't you?");
        }
        /*
         * Begins first part.
         */
        System.out.println("\n" + start + "\n");
        start.talk(2);
        while (start.uHealth >0 && start.eHealth >0){
            start.talk(1);
            start.action = scan.nextLine();
            System.out.println(start.userTurn(start.action));
            start.enemyTurn();
        }
        if (start.uHealth <=0){
            System.out.println("\n"+"what a pity. you died. ill have to find someone else to replace you.");
            System.exit(0);
        }
        if (start.eHealth <=0){
            start.talk(3);
            start.eHealth = 581;
            start.eName = ("Andy Liang");
        }
        /*
         * Begins second part.
         */
        start.talk(4);
        while (start.uHealth >0 && start.eHealth >0){
            start.talk(5);
            start.action = scan.nextLine();
            System.out.println(start.userTurn(start.action));
            start.enemyTurn();
        }
        if (start.uHealth <=0) {
            System.out.println("\n" + "what a pity. you died. ill have to find someone else to replace you.");
            System.exit(0);
        }
        /*
         * Begins third part.
         */
        if (start.eHealth <=0){
            start.talk(0);
            start.eHealth = Integer.MAX_VALUE;
            start.eName = ("IntelliJ IDEA Community Edition 2022.2.2");
        }
        while (start.uHealth >0 && start.eHealth >0){
            start.talk(5);
            start.action = scan.nextLine();
            System.out.println(start.userTurn(start.action));
            if (start.eHealth >0){
                start.enemyTurn();
            }
        }
        if (start.uHealth <=0){
            System.out.println("I pity thee.");
            System.exit(0);
        }
        /*
         * Ends.
         */
        if (start.eHealth <=0){
            start.talk(6);
        }
    }
}
