import scala.collection.mutable

object TextService extends App {

  def text_break(text: String): String = {
    val LimitCharsPerWord: Int = 40

    val words: Array[String] = text.split(" ")
    var limitAux: Int = LimitCharsPerWord

    val sb: mutable.StringBuilder = new mutable.StringBuilder();

    if (words(0).length <= LimitCharsPerWord) {
      sb.append(words(0))
      limitAux -= words(0).length
    } else {
      throw new Exception("The first word exceed the valid limit of 40 chars")
    }

    for (i <- 1 until words.length) {
      val wordLength = words(i).length

      if(wordLength > LimitCharsPerWord) {
        println(words(i))
        throw new Exception("The word exceed the valid limit of 40 chars")
      }

      if (wordLength + 1 <= limitAux) {
        sb.append(" ").append(words(i))
        limitAux -= wordLength + 1
      } else {
        sb.append("\n").append(words(i))
        limitAux = 40 - wordLength
      }
    }
    sb.toString()
  }
}