import java.util.Random;

public class RandomHandSignGenerator implements HandSignGetter {

  private Random randomGenerator = new Random();

  @Override
  public HandSign getHandSign() {
    return HandSign.values()[randomGenerator.nextInt(HandSign.values().length)];
  }
}
