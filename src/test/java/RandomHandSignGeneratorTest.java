import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RandomHandSignGeneratorTest {

  @Mock Random randomGenerator;
  @InjectMocks private RandomHandSignGenerator testee;

  @Test
  public void getHandSign_callsRandomGenerator() {
    testee.getHandSign();
    Mockito.verify(randomGenerator).nextInt(HandSign.values().length);
  }

  @Test
  // This test will break if the order of the enum is changed.
  public void getHandSign_canReturnAllHandSigns() {
    Mockito.when(randomGenerator.nextInt(3)).thenReturn(0).thenReturn(1).thenReturn(2);

    Assertions.assertEquals(HandSign.PAPER, testee.getHandSign());
    Assertions.assertEquals(HandSign.ROCK, testee.getHandSign());
    Assertions.assertEquals(HandSign.SCISSORS, testee.getHandSign());
  }
}
