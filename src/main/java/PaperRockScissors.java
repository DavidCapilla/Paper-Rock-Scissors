import java.util.Random;
import java.util.Scanner;

public class PaperRockScissors {

  private PaperRockScissorsRound paperRockScissorsRound = new PaperRockScissorsRound();

  public void playGame(int numberOfRounds) {

    Scanner inputScanner = new Scanner(System.in);
    for (int round = 0; round < numberOfRounds; round++) {
      HandSign playerOneHandSign = getHandSignFromInput(inputScanner);
      HandSign playerTwoHandSign = getRandomHandSign();
      RoundResult roundResult = paperRockScissorsRound.playRound(playerOneHandSign, playerTwoHandSign);

      System.out.println("Player One throws " + playerOneHandSign +
          " and Player Two throws throws " + playerTwoHandSign +
          ". " + roundResult);
    }
  }

  private HandSign getHandSignFromInput(Scanner inputScanner) {

    HandSign playerOneHandSign = null;
    while (playerOneHandSign == null) {
      System.out.println("Introduce the hand sign you want to play (paper, rock or scissors): ");
      String playerOneSign = inputScanner.next();
      playerOneHandSign = convertStringToSign(playerOneSign);
      if (playerOneHandSign == null){
        System.out.println("Invalid sign " + playerOneSign + ". Introduce a valid sign: paper, rock or scissors");
      }
    }
    return playerOneHandSign;
  }

  private HandSign convertStringToSign(String playerOneSign) {
    return switch (playerOneSign.toUpperCase()) {
      case "PAPER" -> HandSign.PAPER;
      case "ROCK" -> HandSign.ROCK;
      case "SCISSORS" -> HandSign.SCISSORS;
      default -> null;
    };
  }

  private HandSign getRandomHandSign() {
    return HandSign.values()[new Random().nextInt(HandSign.values().length)];
  }
}
