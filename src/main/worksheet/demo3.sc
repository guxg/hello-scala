object demo3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  List(1,2,3).toSet.apply()                       //> res0: Boolean = false
  
  val xs = List(1,2,3)                            //> xs  : List[Int] = List(1, 2, 3)
  
  xs.toSet[Int].map(_*2)                          //> res1: scala.collection.immutable.Set[Int] = Set(2, 4, 6)
  
  xs.toSet.map((x:Int) => x*2)                    //> res2: scala.collection.immutable.Set[Int] = Set(2, 4, 6)
  
  xs.toSet.map[Int,Set[Int]](_*2)                 //> res3: Set[Int] = Set(2, 4, 6)
  
  List(1,2,3).toSet(Unit)                         //> res4: Boolean = false
  
     
}