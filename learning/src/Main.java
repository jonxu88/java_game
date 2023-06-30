// TODO: Implement DEFEND, halves damage taken and preserves charge
// TODO: Implement multiple enemy types, not just UglyGoblin, can adjust charge multiplier, defense multiplier
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        Player player = new Player("Steve", 10, 150);
        System.out.println(player.bark());
        System.out.println(player.unitInfo());

        Enemy enemy = new Enemy("UglyGoblin", 15,100);
        System.out.println(enemy.bark());
        System.out.println(enemy.unitInfo());

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("quit") && player.getCurrentHitPoints() > 0 && enemy.getCurrentHitPoints() > 0) {
            System.out.print("Enter a command ('attack', 'defend', or 'charge') or 'quit':");
            userInput = scanner.nextLine();

            if (userInput.equals("attack")) {
                player.setCurrentTurnChoice(Unit.TurnChoice.ATTACK);
            } else if (userInput.equals("charge")) {
                player.setCurrentTurnChoice(Unit.TurnChoice.CHARGE);
            } else if (userInput.equals("defend")) {
                player.setCurrentTurnChoice(Unit.TurnChoice.DEFEND);
            } else {
                System.out.println("Invalid command, please try again.");
            }

            double randomDouble = Math.random();
            // System.out.println(String.format("Printing random number %s", randomDouble));

            if (randomDouble > 0.66) {
                enemy.setCurrentTurnChoice(Unit.TurnChoice.ATTACK);
            } else if (randomDouble > 0.33 && randomDouble < 0.66) {
                enemy.setCurrentTurnChoice(Unit.TurnChoice.CHARGE);
            } else {
                enemy.setCurrentTurnChoice(Unit.TurnChoice.DEFEND);
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
    }
}