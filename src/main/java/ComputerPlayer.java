import domain.HandSign;
import domain.Player;
import java.util.Random;

public class ComputerPlayer implements Player {

  private Random randomGenerator = new Random();

  @Override
  public HandSign getHandSign() {
    return HandSign.values()[randomGenerator.nextInt(HandSign.values().length)];
  }
}
