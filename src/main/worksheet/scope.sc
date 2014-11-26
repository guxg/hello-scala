
object scope {

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  import scala.util.{ Try, Success, Failure }

  class BracketBuilder {

    var _begin: Option[String] = None;
    var _end: Option[String] = None;

    def enclose(begin: String, end: String): BracketBuilder = {
      _begin = Option(begin)
      _end = Option(end);
      this
    }

    def say(something: => Try[Option[String]]): BracketBuilder = {
      val sth = something;
      sth.foreach(msg => for { b <- _begin; m <- msg; e <- _end } { println(m.mkString(b, " ", e)) })
      this
    }
  }

  object BracketBuilder {
    implicit val default = new BracketBuilder()
    //def apply() = new BracketBuilder()
  }

  def using(config: BracketBuilder => BracketBuilder)(process: BracketBuilder => Unit)(implicit builder: BracketBuilder): Unit = {
    process(config(builder))
  }                                               //> using: (config: scope.BracketBuilder => scope.BracketBuilder)(process: scope
                                                  //| .BracketBuilder => Unit)(implicit builder: scope.BracketBuilder)Unit

  case class Speaker(m: String) {
    def say(implicit builder: BracketBuilder) = builder.say(Try(Option(m)))
  }

  implicit def stringToSpeaker(m: String) = Speaker(m)
                                                  //> stringToSpeaker: (m: String)scope.Speaker

  using(_.enclose("[", "]")) { implicit b =>
    "hello".say
  }                                               //> [h e l l o]

}