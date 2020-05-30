

object week5ex1a {
  
 
 def frame (x:String, f : String => String) : String ={
   f(x)
   
 }                                                //> frame: (x: String, f: String => String)String
 def greet1 (x:String) : String ={
   
   
   var greet = "Hello "+x+", How are you doing?"
   return greet
   
 }                                                //> greet1: (x: String)String
 
 def greet2 (x:String) : String ={
   
   
   var greet = "Hello "+x+", How U Doing?"
   return greet
   
 }                                                //> greet2: (x: String)String
  println(frame("Hamed",greet1))                  //> Hello Hamed, How are you doing?
  println(frame("Hamed",greet2))                  //> Hello Hamed, How U Doing?
  
}