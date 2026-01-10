import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Player {
    public String name;
    public int lives = 1;

    public Player(String name) {
        this.name = name;
    }

    public void lose() {
        lives--;
    }

    public boolean isDead() {
        return lives <= 0;
    }
}

public class PoisonBallGame {

    public static String choiceToString(int choice) {
        return switch (choice) {
            case 1 -> "Rock";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> "Invalid";
        };
    }

    public static void playRPS(int p1, int p2, Player player1, Player player2) {
        System.out.println(player1.name + " chooses " + choiceToString(p1));
        System.out.println(player2.name + " chooses " + choiceToString(p2));

        if (p1 == p2) {
            System.out.println("It's a tie!");
            return;
        }

        if ((p1 == 1 && p2 == 3) || (p1 == 2 && p2 == 1) || (p1 == 3 && p2 == 2)) {
            player2.lose();
            System.out.println(player1.name + " wins!");
        } else {
            player1.lose();
            System.out.println(player2.name + " wins!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("Enter number of players: ");
        int amountOfPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            players.add(new Player(scanner.nextLine()));
        }

        int currentPoisonPlayer = rand.nextInt(players.size());

        while (players.size() > 1) {

            int opponent;
            do {
                opponent = rand.nextInt(players.size());
            } while (opponent == currentPoisonPlayer);

            Player poison = players.get(currentPoisonPlayer);
            Player other = players.get(opponent);

            System.out.println("\n" + poison.name + " is the poison player and fights " + other.name);
            System.out.print(poison.name + " enter choice (1 Rock, 2 Paper, 3 Scissors): ");
            int p1 = scanner.nextInt();
            System.out.print(other.name + " enter choice (1 Rock, 2 Paper, 3 Scissors): ");
            int p2 = scanner.nextInt();

            int poisonLives = poison.lives;
            int otherLives = other.lives;

            playRPS(p1, p2, poison, other);

            // Remove dead players and announce once
            players.removeIf(p -> {
                if (p.isDead()) {
                    System.out.println(p.name + " has been eliminated.");
                    return true;
                }
                return false;
            });

            if (players.size() <= 1) break;

            // Fix poison index if needed
            if (!players.contains(poison)) {
                currentPoisonPlayer = rand.nextInt(players.size());
            } else if (other.lives < otherLives) {
                currentPoisonPlayer = players.indexOf(other);
            }
        }

        System.out.println("\n" + players.get(0).name + " is the last survivor and wins the game!");
        scanner.close();
    }
}
