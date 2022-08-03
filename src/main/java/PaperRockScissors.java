import domain.HandSign;
import domain.HandSignGetter;
import domain.RoundResult;

public class PaperRockScissors {

  private final HandSignGetter playerOneHandSignGetter;
  private final HandSignGetter playerTwoHandSignGetter;
  private final PaperRockScissorsRound paperRockScissorsRound;

  public PaperRockScissors(
      PaperRockScissorsRound paperRockScissorsRound,
      HandSignGetter playerOneHandSignGetter,
      HandSignGetter playerTwoHandSignGetter) {
    this.playerOneHandSignGetter = playerOneHandSignGetter;
    this.playerTwoHandSignGetter = playerTwoHandSignGetter;
    this.paperRockScissorsRound = paperRockScissorsRound;
  }

  public void playGame(int numberOfRounds) {

    for (int round = 0; round < numberOfRounds; round++) {
      HandSign playerOneHandSign = playerOneHandSignGetter.getHandSign();
      HandSign playerTwoHandSign = playerTwoHandSignGetter.getHandSign();
      RoundResult roundResult =
          paperRockScissorsRound.playRound(playerOneHandSign, playerTwoHandSign);

      // This could be moved to class in charge of the output.
      System.out.println(
          "Player One throws "
              + playerOneHandSign
              + " and Player Two throws "
              + playerTwoHandSign
              + ". "
              + getWinnerFromRoundResult(roundResult));
    }
  }

  private String getWinnerFromRoundResult(RoundResult roundResult){
    return switch (roundResult) {
      case DRAW -> "It's a draw.";
      case WINS_PLAYER_ONE -> "The winner is Player One.";
      case WINS_PLAYER_TWO -> "The winner is Player Two.";
    };
  }
}
