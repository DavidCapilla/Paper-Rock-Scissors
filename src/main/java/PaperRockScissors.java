public class PaperRockScissors {

  private final HandSignGetter playerOneHandSignGetter;
  private final HandSignGetter playerTwoHandSignGetter;
  private PaperRockScissorsRound paperRockScissorsRound;

  public PaperRockScissors(
      HandSignGetter playerOneHandSignGetter,
      HandSignGetter playerTwoHandSignGetter) {
    this.playerOneHandSignGetter = playerOneHandSignGetter;
    this.playerTwoHandSignGetter = playerTwoHandSignGetter;
    paperRockScissorsRound = new PaperRockScissorsRound();
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
