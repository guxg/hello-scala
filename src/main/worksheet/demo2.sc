object demo2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  case class Extractor(val ptn:String){
      
    def unapply(x:String) = {
      val index:Int = x.indexOf(ptn)
      if(index>(-1))
        Some(x.substring(index+ptn.size))
      else
        None
    }
    
  }
  
  val E = Extractor("ja")                         //> E  : demo2.Extractor = Extractor(ja)
  
  val books:List[String] = List("java","scala")   //> books  : List[String] = List(java, scala)
  
  val hit = books.collectFirst( {
    case E(h) => h
  })                                              //> hit  : Option[String] = Some(va)
  
  println(hit)                                    //> Some(va)
  
  import scala.concurrent._
  
  val a:Future[String] = Future.failed(new Exception(""));
                                                  //> a  : scala.concurrent.Future[String] = scala.concurrent.impl.Promise$KeptPro
                                                  //| mise@71846ce0
  
  
  
}