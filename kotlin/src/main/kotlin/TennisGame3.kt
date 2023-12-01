class TennisGame3(private val player1Name: String, private val player2Name: String) : TennisGame {
    private val table = Table()

    override fun getScore(): String {
        if (table.isGameFinished()) {
            return "Win for ${getWinningPlayerName()}"
        }

        if (table.isInAdvantagesPhase()) {
            return scoreDuringAdvantagesPhase()
        }

        return scoreBeforeAdvantagesPhase()
    }

    private fun scoreDuringAdvantagesPhase(): String {
        if (table.areScoresEven()) {
            return "Deuce"
        }

        return "Advantage ${getWinningPlayerName()}"
    }

    private fun scoreBeforeAdvantagesPhase(): String {
        if (table.areScoresEven()) {
            return "${table.player1ScoreName()}-All"
        }

        return "${table.player1ScoreName()}-${table.player2ScoreName()}"
    }

    private fun getWinningPlayerName(): String {
        if (table.isPlayer1Winning()) {
            return player1Name
        }

        return player2Name
    }

    override fun wonPoint(playerName: String) {
        if (playerName === "player1") {
            table.incrementPlayer1Score()
        } else {
            table.incrementPlayer2Score()
        }
    }

}
