public class PaperRockScissors {

  private PaperRockScissorsRound paperRockScissorsRound = new PaperRockScissorsRound();

  public void playGame(int numberOfRounds) {

    for (int round = 0; round < numberOfRounds; round++) {
      paperRockScissorsRound.playRound(HandSign.SCISSORS, HandSign.SCISSORS);
    }
  }
}
