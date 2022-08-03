import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import domain.HandSign;
import domain.Player;
import domain.RoundResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperRockScissorsTest {

  @Mock private Player playerOne;
  @Mock private Player playerTwo;
  @Mock private PaperRockScissorsRound paperRockScissorsRound;
  @InjectMocks private PaperRockScissors testee;

  @ParameterizedTest
  @CsvSource({"1"})
  public void playGame_callsNTimesToPlayRound(int numberOfRounds) {

    when(playerOne.getHandSign()).thenReturn(HandSign.PAPER);
    when(playerTwo.getHandSign()).thenReturn(HandSign.ROCK);
    when(paperRockScissorsRound.playRound(any(), any()))
        .thenReturn(RoundResult.WINS_PLAYER_ONE);

    testee.playGame(numberOfRounds);

    verify(paperRockScissorsRound, Mockito.times(numberOfRounds))
        .playRound(HandSign.PAPER, HandSign.ROCK);
  }

  @Test
  public void playGame_invalidNumberOfRounds() {

    testee.playGame(-10);
    verify(paperRockScissorsRound, Mockito.never())
        .playRound(any(), any());
  }
}
