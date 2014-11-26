object ct {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import java.util._
  
  def max[T](a:T,b:T)(implicit cp:Comparator[T]):T = {
    if(cp.compare(a,b) > 0) a else b
  }                                               //> max: [T](a: T, b: T)(implicit cp: java.util.Comparator[T])T
  
  def max2[T:Comparator](a:T,b:T):T = {
    val cp = implicitly[Comparator[T]]
    if(cp.compare(a,b) > 0) a else b
  }                                               //> max2: [T](a: T, b: T)(implicit evidence$2: java.util.Comparator[T])T
  
  implicit val c = new Comparator[Int] {
    override def compare(a:Int,b:Int) = a - b
  }                                               //> c  : java.util.Comparator[Int] = ct$$anonfun$main$1$$anon$1@6e3c330a
  
  max(2,3)                                        //> res0: Int = 3
  max2(2,3)                                       //> res1: Int = 3
  
  class PkId extends java.util.Comparator[Int]{
    override def compare(a:Int,b:Int) = a - b
  }
  
  class DeviceId extends PkId
  
}