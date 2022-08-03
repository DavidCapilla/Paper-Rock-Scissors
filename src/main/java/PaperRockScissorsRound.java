import domain.HandSign;
import domain.RoundResult;

public class PaperRockScissorsRound {

  public RoundResult playRound(HandSign playerOneSign, HandSign playerTwoSign) {

    if (playerOneSign.equals(playerTwoSign)) {
      return RoundResult.DRAW;
    } else if (getSignThatBeats(playerOneSign).equals(playerTwoSign)) {
      return RoundResult.WINS_PLAYER_ONE;
    }
    return RoundResult.WINS_PLAYER_TWO;
  }

  private HandSign getSignThatBeats(HandSign handSign) {

    return switch (handSign) {
      case PAPER -> HandSign.ROCK;
      case ROCK -> HandSign.SCISSORS;
      case SCISSORS -> HandSign.PAPER;
    };
  }
}