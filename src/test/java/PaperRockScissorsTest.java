import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperRockScissorsTest {

  @InjectMocks private PaperRockScissors testee;

  @Test
  @DisplayName("When PlayerOne throws Scissors and PlayerTwo throws Paper, PlayerOne wins")
  public void playRound_ScissorsAgainstPaper() {
    assertEquals(RoundResult.WINS_PLAYER_ONE, testee.playRound(HandSign.SCISSORS, HandSign.PAPER));
  }
}
