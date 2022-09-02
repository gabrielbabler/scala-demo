import scala.collection.mutable

object TextService extends App {

  def text_break(text: String): String = {

    val words: Array[String] = text.split(" ")
    var limit: Int = 40

    val sb: mutable.StringBuilder = new mutable.StringBuilder();

    if (words(0).length <= limit) {
      sb.append(words(0))
      limit -= words(0).length
    } else {
      throw new Exception("The first word exceed the valid limit of 40 chars")
    }

    for (i <- 1 until words.length) {
      val wordLength = words(i).length

      if(wordLength > limit) {
        throw new Exception("The first word exceed the valid limit of 40 chars")
      }

      if (wordLength + 1 <= limit) {
        sb.append(" ").append(words(i))
        limit -= wordLength + 1
      } else {
        sb.append("\n").append(words(i))
        limit = 40 - wordLength
      }
    }
    sb.toString()
  }
}