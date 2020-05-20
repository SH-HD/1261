object HamedShariffarW4Ex {
  
  //Exercise 1 (Mandatory)
  //Define the following values:
  val x : Double = 42.354562                      //> x  : Double = 42.354562
  val y : Int = 3                                 //> y  : Int = 3
  //Write required code in println command to print the following output:
  //  ●The round value of x is 42.35
    println(f"The round value of x is $x%.2f")    //> The round value of x is 42.35
    
  //●The left zero padding version of y is 0003
    println(f"The left zero padding version of y is $y%04d")
                                                  //> The left zero padding version of y is 0003
  
  

  
  
  //Exercise 2 (Mandatory)Write a function to compute factorial (5! = 5*4*3*2*1)
 
  
  var number: Int=5  //It is the number to calculate factorial
                                                  //> number  : Int = 5
  def factor(x: Int) : Int = {
     var fact  : Int= 1
     var j     : Int =0
     for (j <- 1 to x)
        {
      fact=fact*j
        }
     println("Factorial of "+x+" is: "+fact)
     return fact }                                //> factor: (x: Int)Int
    
factor(number)                                    //> Factorial of 5 is: 120
                                                  //| res0: Int = 120
  
  
  //Then write another function to call fact function and println few examples (i.e, 6,8,4.52).
  //. Your program should return NA if the input is not integer.




def CallFactor (x: Double,f : Int => Int ): Double = {
var A: Int=1

A = x.toInt// geting the
if (x == A) { f(A)}
else { println(x+" is not an integer")}

return 0}                                         //> CallFactor: (x: Double, f: Int => Int)Double

val trial = List(6,8,4.52)                        //> trial  : List[Double] = List(6.0, 8.0, 4.52)

for (x <- trial){CallFactor(x, factor )}          //> Factorial of 6 is: 720
                                                  //| Factorial of 8 is: 40320
                                                  //| 4.52 is not an integer


   
   
   
  
  
  //Exercise 3 (Mandatory)Repeat the previous exercise by
  // accepting the double numbers into the factorialfunction.//
  // Convert them to integer before calling the fact function.
  
 def CallFactor2 (x: Double,f : Int => Int ): Double = {

f(x.toInt)

return 0}                                         //> CallFactor2: (x: Double, f: Int => Int)Double


for (x <- trial){CallFactor2(x, factor )}         //> Factorial of 6 is: 720
                                                  //| Factorial of 8 is: 40320
                                                  //| Factorial of 4 is: 24
  
  
  
  
  //Exercise 4 (Optional)Write a code that prints out the first 10 values of the Fibonacci sequence.
  //●The result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
  var f1 : Int  = 0                               //> f1  : Int = 0
  var f2 : Int  = 1                               //> f2  : Int = 1
  var next : Int  = 0                             //> next  : Int = 0
  import scala.collection.mutable.ArrayBuffer
 
  var  fibo  = new ArrayBuffer[Int]()             //> fibo  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  fibo += f1                                      //> res1: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(0)

  for (x <- 1 to 9)
        {
            fibo += f2
            next = f1 + f2
            f1 = f2
            f2 = next
         }
  for (x <- 0 to 9) System.out.print(fibo(x)+", ")//> 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
 
  
  
  //Exercise 5 (Optional)Write a function that takes the number and says here is the cube of the input:
  //●5 -> 125 is the cube
  
  
var input : Double = 5                            //> input  : Double = 5.0

def cubeIt(x: Double): Int = {
println(f"here is the cube of the input: "+scala.math.pow(x,3))
return 0
}                                                 //> cubeIt: (x: Double)Int

cubeIt(input)                                     //> here is the cube of the input: 125.0
                                                  //| res2: Int = 0

 //●Retry doing it via lambda function
 
 // lambda expression
    input = 5
    val ex1 = (x : Double) => x*x*x               //> ex1  : Double => Double = HamedShariffarW4Ex$$$Lambda$20/1644443712@5315b42
                                                  //| e
     println(f"here is the cube of the input: "+ex1(input) )
                                                  //> here is the cube of the input: 125.0
 
 
}