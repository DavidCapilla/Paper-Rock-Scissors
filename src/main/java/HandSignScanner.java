import domain.HandSign;
import domain.HandSignGetter;
import java.util.Scanner;

public class HandSignScanner implements HandSignGetter {

  @Override
  public HandSign getHandSign() {

    // I wanted to have the scanner as a field of the class but I had testing problems.
    Scanner inputScanner = new Scanner(System.in);

    HandSign handSign;
    while (true) {
      System.out.println("Introduce the hand sign you want to play (paper, rock or scissors): ");
      String inputSign = inputScanner.next();
      handSign = convertStringToHandSign(inputSign);
      if (handSign != null) {
        break;
      }
      System.out.println("Invalid sign \"" + inputSign + "\". Valid hand signs: paper, rock or scissors.");
    }
    return handSign;
  }

  private HandSign convertStringToHandSign(String sign) {
    return switch (sign.toUpperCase()) {
      case "PAPER" -> HandSign.PAPER;
      case "ROCK" -> HandSign.ROCK;
      case "SCISSORS" -> HandSign.SCISSORS;
      default -> null;
    };
  }
}
