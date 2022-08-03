import domain.HandSign;
import domain.Player;
import domain.RoundResult;

public class PaperRockScissors {

  private final Player playerOne;
  private final Player playerTwo;
  private final PaperRockScissorsReferee paperRockScissorsReferee;

  public PaperRockScissors(
      PaperRockScissorsReferee paperRockScissorsReferee,
      Player playerOne,
      Player playerTwo) {
    this.paperRockScissorsReferee = paperRockScissorsReferee;
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
  }

  public void playGame(int numberOfRounds) {

    for (int round = 0; round < numberOfRounds; round++) {
      HandSign playerOneHandSign = playerOne.getHandSign();
      HandSign playerTwoHandSign = playerTwo.getHandSign();
      RoundResult roundResult =
          paperRockScissorsReferee.determineWinner(playerOneHandSign, playerTwoHandSign);

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
