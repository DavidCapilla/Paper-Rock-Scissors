import domain.HandSign;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HandSignScannerTest {

  private HandSignScanner testee = new HandSignScanner();

  private static Stream<Arguments> provideInputHandSignPair() {
    return Stream.of(
        Arguments.of("paper", HandSign.PAPER),
        Arguments.of("rock", HandSign.ROCK),
        Arguments.of("scissors", HandSign.SCISSORS),
        Arguments.of("Paper", HandSign.PAPER),
        Arguments.of("PAPER", HandSign.PAPER));
  }

  @ParameterizedTest
  @MethodSource("provideInputHandSignPair")
  public void getHandSign_matchInputsWithHandSign(String input, HandSign expectedResult) {
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Assertions.assertEquals(expectedResult, testee.getHandSign());
  }

  @Test
  @DisplayName(
      "When an invalid input is introduced, it asks again "
          + "for an input until a valid one is introduced")
  public void getHandSign_invalidInputRepeatsTheQuestionUntilValidInput() {
    String invalidInputsWithEndingValidInput = "wrongSign\n".repeat(5) + "paper";
    System.setIn(new ByteArrayInputStream(invalidInputsWithEndingValidInput.getBytes()));
    Assertions.assertEquals(HandSign.PAPER, testee.getHandSign());
  }
}
