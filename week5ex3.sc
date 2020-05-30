object week5ex3 {

  
 
 def get_max (x:Double, y:Double, f : (Double, Double) => Double) : Double ={
   f(x,y)
   
 }                                                //> get_max: (x: Double, y: Double, f: (Double, Double) => Double)Double
 def max (x:Double, y:Double) :Double ={
   
   if(x>y)
       return x
   else
       return y
   
 }                                                //> max: (x: Double, y: Double)Double
 
  println(get_max (54,100,max))                   //> 100.0
  

}