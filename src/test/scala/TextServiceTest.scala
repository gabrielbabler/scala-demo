import org.scalatest.funsuite.AnyFunSuite

class TextServiceTest extends AnyFunSuite {
  test("TextService.text_break") {
    val text: String = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."
    val expectedText: String = "In 1991, while studying computer science\nat University of Helsinki, Linus\nTorvalds began a project that later\nbecame the Linux kernel. He wrote the\nprogram specifically for the hardware he\nwas using and independent of an\noperating system because he wanted to\nuse the functions of his new PC with an\n80386 processor. Development was done on\nMINIX using the GNU C Compiler."
    assert(TextService.text_break(text) == expectedText)
  }

  test("TextService.text_break text exceed the chars limit for the first word") {
    val invalidText: String = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    assertThrows[Exception] {
      TextService.text_break(invalidText)
    }
  }

  test("TextService.text_break text exceed the chars limit for any word but first") {
    val invalidText: String = "Hey aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    assertThrows[Exception] {
      TextService.text_break(invalidText)
    }
  }
}