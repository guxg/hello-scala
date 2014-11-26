object fa {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  import scala.concurrent._
  import scala.concurrent.duration._
  import java.util.concurrent.{ TimeUnit }
  import scala.language.postfixOps
  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  import scala.concurrent.blocking

  def loadAverage(): String = s"${System.currentTimeMillis}"
                                                  //> loadAverage: ()String

  val name = Future[String] {
    println("blocking begins")
    blocking(Thread.sleep((10 seconds).toMillis))
    println("blocking finished")
    loadAverage
  }                                               //> blocking begins
                                                  //| name  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$Defa
                                                  //| ultPromise@6dd6c962
                                                  
          //Await.result(name, 10.seconds)
          
   //val flow =
          

}