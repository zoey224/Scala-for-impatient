import org.apache.spark.sql.SparkSession
object Chapter1 {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Chapter-1 exercise")
      .master("local")
      .getOrCreate()
    import spark.implicits._
    val signum=judgeNum(-1.5)
    println(signum)
    printlikeJava()
    countdown(6)
    println(product("Hello"))
    println(multiplicative(5,2))

  }
  //exercise 1
  def judgeNum(num:Double):Int={
    if (num>0) 1 else if (num==0) 0 else -1
  }
  //exercise 4
    def printlikeJava(){
      for (i<-(1 to 10).reverse) println(i)
  }
  //exercise 5
  def countdown(n:Int):Unit={
    for (i<-n to 0 by -1) println(i)
  }
// exercise 6\7\8
  def product(s: String): Long = {
//    var res=1L
//    for(i<-s){
//    res =res*i
//    }
//    res

//    s.foldLeft(1L)((res, ch) => res * ch)
//    s.foldLeft(1L)(_ * _)
    var i =1L
    s.foreach(i*=_)
    i
  }
  // exercise 10
  def multiplicative(x:Double, n:Int):Double={
    if (n==0) 1
    else if (n<0)
      1/multiplicative(x,-n)
    else if (n%2==0)
      multiplicative(x,n/2)*multiplicative(x,n/2)
    else
      x*multiplicative(x,n-1)
  }

}
