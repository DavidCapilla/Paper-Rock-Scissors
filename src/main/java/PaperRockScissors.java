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

      System.out.println(
          "Player One throws "
              + playerOneHandSign
              + " and Player Two throws throws "
              + playerTwoHandSign
              + ". "
              + roundResult);
    }
  }
}
