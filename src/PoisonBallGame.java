
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Player {
    public String name;
    public int lives = 3;
    public Player(String name) {
        this.name = name;
    }

    public void lose() {
        this.lives--;
    }
    public boolean isDead() {
        if (this.lives <= 0) {
            System.out.println(this.name + " has been eliminated from the game.");
            return true;
        }
        return false;
    }
}
public class PoisonBallGame{


public static String choiceToString(int choice) {
    return switch (choice) {
        case 1 -> "Rock";
        case 2 -> "Paper";
        case 3 -> "Scissors";
        default -> "Invalid";
    };
}

    // Function to play RPS
    public static String playRPS(int p1, int p2) {
        
        if (p1 == p2) return "It's a tie!";

        // 1 = Rock, 2 = Paper, 3 = Scissors
        if ((p1 == 1 && p2 == 3) ||
            (p1 == 2 && p2 == 1) ||
            (p1 == 3 && p2 == 2)) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }

    public static void main(String[] args) {
       
        Random rand = new Random();
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of players: ");
        int amountOfPlayers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players.add(new Player(playerName));
        }
        while (players.size() > 1) {
            players.removeIf(Player::isDead);
            int firstplayerIndex = players.size() - 1;
            int randomIndex = rand.nextInt(players.size() - 1);
            System.out.println(players.get(firstplayerIndex).name + " is the poison player and chooses to fight " + players.get(randomIndex).name);



        scanner.close();
      }
    }
}
    /*
        psuedocode for actually running the game

        while (more than 1 player has lives remaining) {
            for each player in players {
                if (player isPoisoned) {
                    // player chosen loses a life
                    // player takes turn
                    // randomly choose another player to fight
                    // if win, give opponent poisoned status
                    // if lose, keep poisoned status
                    // if lives == 0, remove player from game
                    //    randomly choose another player to be poisoned
                }
            }
            increment round counter
        }
    */

/*create scoreboard 
*prompting player name
*round counter
*determine last survivor
*lives reset constant
*call other classes
*/
//  String PlayerName;
//  int RoundCounter;
//  int LiveCounter;
//  int SurvivorsRemaining;


// public  class Player{
//     String name;
//     int lifeCounter;
//     Player(String name, int lifeCounter) {
//     this.name = name;
//    // this.health = health;
//     this.lifeCounter = lifeCounter;
// }
// //comment from JBailey
// }