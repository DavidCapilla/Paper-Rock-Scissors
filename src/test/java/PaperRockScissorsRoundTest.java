import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaperRockScissorsRoundTest {

  @InjectMocks private PaperRockScissorsRound testee;

  private static Stream<Arguments> providePaperRockScissorRoundCombinations() {
    return Stream.of(
        Arguments.of(HandSign.PAPER, HandSign.PAPER, RoundResult.DRAW),
        Arguments.of(HandSign.PAPER, HandSign.ROCK, RoundResult.WINS_PLAYER_ONE),
        Arguments.of(HandSign.PAPER, HandSign.SCISSORS, RoundResult.WINS_PLAYER_TWO),
        Arguments.of(HandSign.ROCK, HandSign.PAPER, RoundResult.WINS_PLAYER_TWO),
        Arguments.of(HandSign.ROCK, HandSign.ROCK, RoundResult.DRAW),
        Arguments.of(HandSign.ROCK, HandSign.SCISSORS, RoundResult.WINS_PLAYER_ONE),
        Arguments.of(HandSign.SCISSORS, HandSign.PAPER, RoundResult.WINS_PLAYER_ONE),
        Arguments.of(HandSign.SCISSORS, HandSign.ROCK, RoundResult.WINS_PLAYER_TWO),
        Arguments.of(HandSign.SCISSORS, HandSign.SCISSORS, RoundResult.DRAW));
  }

  @ParameterizedTest
  @MethodSource("providePaperRockScissorRoundCombinations")
  public void playRound_combinationOfGames(
      HandSign playerOneSign, HandSign playerTwoSign, RoundResult expectedResult) {
    Assertions.assertEquals(expectedResult, testee.playRound(playerOneSign, playerTwoSign));
  }
}
