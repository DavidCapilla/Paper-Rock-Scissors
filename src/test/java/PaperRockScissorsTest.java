import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import domain.HandSign;
import domain.Player;
import domain.RoundResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperRockScissorsTest {

  @Mock private Player playerOne;
  @Mock private Player playerTwo;
  @Mock private PaperRockScissorsReferee paperRockScissorsReferee;
  private PaperRockScissors testee;

  @BeforeEach
  // Implemented in order to avoid problems with the annotation @InjectMocks that confuses the
  // players since they are of the same class.
  public void manualInjectionOfMocks() {
    testee = new PaperRockScissors(paperRockScissorsReferee, playerOne, playerTwo);
  }

  @ParameterizedTest
  @CsvSource({"1", "2", "3", "20"})
  public void playGame_callsNTimesToPlayRound(int numberOfRounds) {

    when(playerOne.getHandSign()).thenReturn(HandSign.PAPER);
    when(playerTwo.getHandSign()).thenReturn(HandSign.ROCK);
    when(paperRockScissorsReferee.determineWinner(any(), any()))
        .thenReturn(RoundResult.WINS_PLAYER_ONE);

    testee.playGame(numberOfRounds);

    verify(paperRockScissorsReferee, Mockito.times(numberOfRounds))
        .determineWinner(HandSign.PAPER, HandSign.ROCK);
  }

  @Test
  public void playGame_invalidNumberOfRounds() {

    testee.playGame(-10);
    verify(paperRockScissorsReferee, never()).determineWinner(any(), any());
  }
}
