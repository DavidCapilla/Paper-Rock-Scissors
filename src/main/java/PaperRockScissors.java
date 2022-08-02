import java.util.Scanner;

public class PaperRockScissors {

  private PaperRockScissorsRound paperRockScissorsRound = new PaperRockScissorsRound();

  public void playGame(int numberOfRounds) {

    Scanner inputScanner = new Scanner(System.in);
    for (int round = 0; round < numberOfRounds; round++) {
      String playerOneSign = inputScanner.next();
      paperRockScissorsRound.playRound(convertStringToSign(playerOneSign), HandSign.SCISSORS);
    }
  }

  private HandSign convertStringToSign(String playerOneSign) {
    return HandSign.SCISSORS;
  }
}
