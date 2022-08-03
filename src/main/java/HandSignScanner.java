import java.util.Scanner;

public class HandSignScanner implements HandSignGetter {

  @Override
  public HandSign getHandSign() {

    // I wanted to have the scanner as a field of the class but I had testing problems.
    Scanner inputScanner = new Scanner(System.in);

    HandSign handSign = null;
    while (handSign == null) {
      System.out.println("Introduce the hand sign you want to play (paper, rock or scissors): ");
      String inputSign = inputScanner.next();
      handSign = convertStringToHandSign(inputSign);
      if (handSign == null){
        System.out.println("Invalid sign " + inputSign + ". Introduce a valid sign: paper, rock or scissors");
      }
    }
    return handSign;
  }

  private HandSign convertStringToHandSign(String playerOneSign) {
    return switch (playerOneSign.toUpperCase()) {
      case "PAPER" -> HandSign.PAPER;
      case "ROCK" -> HandSign.ROCK;
      case "SCISSORS" -> HandSign.SCISSORS;
      default -> null;
    };
  }
}
