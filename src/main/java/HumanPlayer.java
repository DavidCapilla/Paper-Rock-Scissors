import domain.HandSign;
import domain.Player;
import java.util.Scanner;

public class HumanPlayer implements Player {

  @Override
  public HandSign getHandSign() {

    // With more time I would create a wrapper of this scanner it order to
    // avoid dependency an better testing. I place it here to avoid testing
    // issues derived of not doing the previous thing.
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
