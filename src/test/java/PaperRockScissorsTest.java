import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperRockScissorsTest {

  @Mock private HandSignGetter playerOneHandSignGetter;
  @Mock private HandSignGetter playerTwoHandSignGetter;
  @Mock private PaperRockScissorsRound paperRockScissorsRound;
  @InjectMocks private PaperRockScissors testee;

  @ParameterizedTest
  @CsvSource({"1"})
  public void playGame_callsNTimesToPlayRound(int numberOfRounds) {

    Mockito.when(playerOneHandSignGetter.getHandSign()).thenReturn(HandSign.PAPER);
    Mockito.when(playerTwoHandSignGetter.getHandSign()).thenReturn(HandSign.ROCK);
    testee.playGame(numberOfRounds);
    Mockito.verify(paperRockScissorsRound, Mockito.times(numberOfRounds))
        .playRound(HandSign.PAPER, HandSign.ROCK);
  }

  @Test
  public void playGame_invalidNumberOfRounds() {

    testee.playGame(-10);
    Mockito.verify(paperRockScissorsRound, Mockito.never())
        .playRound(ArgumentMatchers.any(), ArgumentMatchers.any());
  }
}
