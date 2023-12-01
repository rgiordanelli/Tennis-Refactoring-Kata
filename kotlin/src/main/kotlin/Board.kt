import kotlin.math.abs

private val MINIMUM_WINNING_SCORE = Score(4)
private val MINIMUM_ADVANTAGES_SCORE = Score(3)
private const val MINIMUM_WINNING_GAP = 2

class Board(private val player1: Player, private val player2: Player) {
    private val player1Score = player1.score
    private val player2Score = player2.score

    fun getCurrentStage(): Stage {
        if (isGameFinished()) {
            return Stage.GAME_WON
        }
        if (isInAdvantagesPhase()) {
            return Stage.ADVANTAGES
        }
        return Stage.BEFORE_ADVANTAGES
    }

    fun areScoresEven() = player1Score == player2Score
    fun isPlayer1Winning() = player1Score > player2Score

    fun incrementPlayer1Score() = player1Score.increment()
    fun incrementPlayer2Score() = player2Score.increment()
    fun player1ScoreName() = player1Score.toString()
    fun player2ScoreName() = player2Score.toString()

    private fun isGameFinished(): Boolean {
        if (player1Score < MINIMUM_WINNING_SCORE && player2Score < MINIMUM_WINNING_SCORE) {
            return false
        }

        return getScoreDifference() >= MINIMUM_WINNING_GAP
    }

    private fun isInAdvantagesPhase(): Boolean {
        if (isGameFinished()) {
            return false
        }

        return player1Score >= MINIMUM_ADVANTAGES_SCORE && player2Score >= MINIMUM_ADVANTAGES_SCORE
    }

    private fun getScoreDifference() = abs(player1Score - player2Score)
}