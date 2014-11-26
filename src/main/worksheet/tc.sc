object tc {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import scala.reflect._
  
  class Speaker[A <: Product]
  
  abstract class Speakable[A <: Product](implicit classTag: ClassTag[A]){
    val name: String = classTag.runtimeClass.getSimpleName
    def say = println(name)
  }
  
  sealed trait Animal
  
  case class Dog(name:String) extends Animal
  case class Cat(name:String) extends Animal
  
  //object Dog extends Speakable[Dog]
  
  def speak[S <: Product : Speakable](a:Animal) = {
    implicitly[Speakable[S]].say
  }                                               //> speak: [S <: Product](a: tc.Animal)(implicit evidence$1: tc.Speakable[S])Uni
                                                  //| t
  
  
  //val dog = Dog()
  //speak(dog)
  
}