import kotlin.math.abs

private val MINIMUM_WINNING_SCORE = Score(4)
private val MINIMUM_ADVANTAGES_SCORE = Score(3)
private const val MINIMUM_WINNING_GAP = 2

class Table {
    private val player1Score = Score()
    private val player2Score = Score()

    fun areScoresEven() = player1Score == player2Score
    fun isPlayer1Winning() = player1Score > player2Score

    fun incrementPlayer1Score() = player1Score.increment()
    fun incrementPlayer2Score() = player2Score.increment()
    fun player1ScoreName() = player1Score.toString()
    fun player2ScoreName() = player2Score.toString()

    fun isGameFinished(): Boolean {
        if (player1Score < MINIMUM_WINNING_SCORE && player2Score < MINIMUM_WINNING_SCORE) {
            return false
        }

        return getScoreDifference() >= MINIMUM_WINNING_GAP
    }

    fun isInAdvantagesPhase(): Boolean {
        if (isGameFinished()) {
            return false
        }

        return player1Score >= MINIMUM_ADVANTAGES_SCORE && player2Score >= MINIMUM_ADVANTAGES_SCORE
    }

    private fun getScoreDifference() = abs(player1Score - player2Score)
}