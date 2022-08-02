import java.io.ByteArrayInputStream;
import java.util.Scanner;
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

  @Mock PaperRockScissorsRound paperRockScissorsRound;
  @InjectMocks private PaperRockScissors testee;

  @ParameterizedTest
  @CsvSource({"0", "1", "2", "20"})
  public void playGame_callsNTimesToPlayRound(int numberOfRounds) {

    System.setIn(new ByteArrayInputStream("rock\n".repeat(numberOfRounds).getBytes()));
    testee.playGame(numberOfRounds);
    Mockito.verify(paperRockScissorsRound, Mockito.times(numberOfRounds))
        .playRound(ArgumentMatchers.any(), ArgumentMatchers.any());
  }
}
