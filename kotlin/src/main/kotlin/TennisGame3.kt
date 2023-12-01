class TennisGame3(private val player1Name: String, private val player2Name: String) : TennisGame {
    private val board = Board(Player(player1Name), Player(player2Name))

    override fun getScore(): String {
        val stage = board.getCurrentStage()

        if (stage == Stage.GAME_WON) {
            return "Win for ${getWinningPlayerName()}"
        }

        if (stage == Stage.ADVANTAGES) {
            return scoreDuringAdvantagesPhase()
        }

        return scoreBeforeAdvantagesPhase()
    }

    private fun scoreDuringAdvantagesPhase(): String {
        if (board.areScoresEven()) {
            return "Deuce"
        }

        return "Advantage ${getWinningPlayerName()}"
    }

    private fun scoreBeforeAdvantagesPhase(): String {
        if (board.areScoresEven()) {
            return "${board.player1ScoreName()}-All"
        }

        return "${board.player1ScoreName()}-${board.player2ScoreName()}"
    }

    private fun getWinningPlayerName(): String {
        if (board.isPlayer1Winning()) {
            return player1Name
        }

        return player2Name
    }

    override fun wonPoint(playerName: String) {
        if (playerName === "player1") {
            board.incrementPlayer1Score()
        } else {
            board.incrementPlayer2Score()
        }
    }

}
