object extractor {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  case class User(name:String,address:String)
  
  val user = User("brooks","NY")                  //> user  : extractor.User = User(brooks,NY)
  
  object AdminUser{
    def unapply(u:User):Boolean = u.name == "admin"
  }
  
  user match{
    case AdminUser() => """yes"""
    case _ => "no,{}"
  }                                               //> res0: String = no,{}
  
  val admin = User("admin","BT")                  //> admin  : extractor.User = User(admin,BT)
  admin match{
    case u@AdminUser() => s"yes, ${u.address}"
    case _ => "no,{}"
  }                                               //> res1: String = yes, BT
  
}