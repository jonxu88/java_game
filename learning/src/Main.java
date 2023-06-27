import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Player player = new Player("Steve", 10, 50);
        System.out.println(player.bark());
        System.out.println(player.unitInfo());

        Enemy enemy = new Enemy("UglyGoblin", 15,30);
        System.out.println(enemy.bark());
        System.out.println(enemy.unitInfo());

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("quit") && player.getCurrentHitPoints() > 0 && enemy.getCurrentHitPoints() > 0) {
            System.out.print("Enter a command ('attack' or 'charge') or 'quit':");
            userInput = scanner.nextLine();

            if (userInput.equals("attack")) {
                player.setCurrentTurnChoice(Unit.TurnChoice.ATTACK);
            } else if (userInput.equals("charge")) {
                player.setCurrentTurnChoice(Unit.TurnChoice.CHARGE);
            } else {
                System.out.println("Invalid command, please try again.");
            }

            double randomDouble = Math.random();
            // System.out.println(String.format("Printing random number %s", randomDouble));

            if (randomDouble > 0.5) {
                enemy.setCurrentTurnChoice(Unit.TurnChoice.ATTACK);
            } else {
                enemy.setCurrentTurnChoice(Unit.TurnChoice.CHARGE);
            }

            TurnResolver.resolveTurn(player,enemy);
            System.out.println(player.unitInfo());
            System.out.println(enemy.unitInfo());
        }

        if (player.getCurrentHitPoints() <= 0) {
            System.out.println(player.deathMessage());
        }

        if (enemy.getCurrentHitPoints() <= 0) {
            System.out.println(enemy.deathMessage());
        }

        System.out.println("Exiting...");
        scanner.close();


        // player attacks enemy
        // player.attack(enemy);
        // System.out.println(enemy.unitInfo());

//        System.out.println("Disabling attack!");
//        enemy.disableAttack();
//        System.out.println(enemy.unitInfo());
    }
}