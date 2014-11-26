object demo {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Builder{
  }
  
  object Builder {
    implicit val default = this.apply;
    def apply() = new Builder()
  }
  
  def build(name:String)(implicit builder:Builder) = {
  
  }                                               //> build: (name: String)(implicit builder: demo.Builder)Unit
  
  build("hello,implicit")
  
}