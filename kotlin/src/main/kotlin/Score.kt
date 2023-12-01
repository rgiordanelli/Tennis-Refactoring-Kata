val scoresNames = arrayOf("Love", "Fifteen", "Thirty", "Forty")

class Score(private var score: Int = 0) {

    fun increment() {
        score++
    }

    override fun toString(): String {
        if (score >= scoresNames.size)
            throw IllegalArgumentException("score too high to get a proper name")
        return scoresNames[score]
    }

    operator fun compareTo(player2Score: Score): Int {
        return this.score - player2Score.score
    }

    operator fun minus(player2Score: Score): Int {
        return this.score - player2Score.score
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other is Score) {
            return score == other.score
        }

        return false
    }

    override fun hashCode(): Int {
        return score
    }

}