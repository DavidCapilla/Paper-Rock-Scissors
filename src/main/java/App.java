import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Introduce the number of rounds you want to play:");
        int numberOfRounds = inputScanner.nextInt();
        PaperRockScissors paperRockScissors = new PaperRockScissors();
        paperRockScissors.playGame(numberOfRounds);
    }
}
