import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
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
        System.out.println("\n" + start + "\n");
        start.talk(2);
        while (start.uhealth>0 && start.ehealth>0){
            start.talk(1);
            start.action = scan.nextLine();
            System.out.println(start.userTurn(start.action,1));
            start.enemyTurn(1);
        }
        if (start.uhealth<=0){
            System.out.println("\n"+"what a pity. you died. ill have to find someone else to replace you.");
            System.exit(0);
        }
        if (start.ehealth<=0){
            start.talk(3);
            start.ehealth = 581;
            start.ename = ("Andy Liang");
        }
        //start 2nd part here//
        start.talk(4);
        while (start.uhealth>0 && start.ehealth>0){
            start.talk(5);
            start.action = scan.nextLine();
            System.out.println(start.userTurn(start.action,2));
            start.enemyTurn(2);
        }
        if (start.uhealth<=0) {
            System.out.println("\n" + "what a pity. you died. ill have to find someone else to replace you.");
            System.exit(0);
        }
        if (start.ehealth<=0){
            start.talk(0);
            start.ehealth = Integer.MAX_VALUE;
            start.ename = ("IntelliJ IDEA Community Edition 2022.2.2");
        }
        while (start.uhealth>0 && start.ehealth>0){
            start.talk(5);
            start.action = scan.nextLine();
            System.out.println(start.userTurn(start.action,2));
            if (start.ehealth>0){
                start.enemyTurn(3);
            }
        }
        if (start.uhealth<=0){
            System.out.println("I pity thee.");
            System.exit(0);
        }
        if (start.ehealth<=0){
            start.talk(6);
        }


    }
}
