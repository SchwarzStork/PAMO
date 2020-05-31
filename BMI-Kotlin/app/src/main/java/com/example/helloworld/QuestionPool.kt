package com.example.helloworld

class QuestionPool {
    private val Questions = arrayOf(
            "Jak potocznie Amerykanie mówią na koronawirusa ?",
            "Gdzie było pierwsze ognisko koronawirusa ?",
            "W jakim kraju na początku roku utknął na kwarantannie statek wycieczkowy ?",
            "Czy wynaleziono już szczepionkę na koronawirusa ?",
            "Jaka sieć stacji benzynowych sprzedaje swój własny żel przeciwwirusowy",
            "Czy koronawirus jest prawdziwy?")
    private val Choices = arrayOf(arrayOf("Wu Flu", "Flutang Clan", "Karate Flu"), arrayOf("Na targu", "W kopalni", "Na basenie"), arrayOf("Rosja", "Chiny", "Japonia"), arrayOf("Tak", "Nie", "Szczepionki trują ludzi"), arrayOf("Lotos", "Circle K", "Orlen"), arrayOf("Tak", "To wszystko spisek", "Wirus nie istnieje"))
    private val CorrectAnswers = arrayOf("Wu Flu", "Na targu", "Japonia", "Tak", "Orlen", "Tak")
    fun getQuestion(a: Int): String {
        return Questions[a]
    }

    fun getChoice1(a: Int): String {
        return Choices[a][0]
    }

    fun getChoice2(a: Int): String {
        return Choices[a][1]
    }

    fun getChoice3(a: Int): String {
        return Choices[a][2]
    }

    fun getCorrectAnswer(a: Int): String {
        return CorrectAnswers[a]
    }
}