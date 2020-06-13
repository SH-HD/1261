// Databricks notebook source
                                               //> frame: (x: String, f: String => String)String
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
  


// COMMAND ----------


  var nums = List.range(1,10)                     //> nums  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val oddNums = nums.filter( (x: Int) => x%2 != 0)//> oddNums  : List[Int] = List(1, 3, 5, 7, 9)
  
  
  def fac (n: Int): Int ={
   if(n==0) return 1
   else  return n*fac(n-1)
  }                                               //> fac: (n: Int)Int
  fac(5)                                          //> res0: Int = 120
 
 val mapedlist = oddNums.map( (oddNum: Int) => {fac(oddNum)})
                                                  //> mapedlist  : List[Int] = List(1, 6, 120, 5040, 362880)
  


// COMMAND ----------

// MAGIC %fs ls

// COMMAND ----------

// MAGIC %fs ls dbfs:/FileStore/

// COMMAND ----------

// MAGIC %fs ls dbfs:/FileStore/import-stage

// COMMAND ----------

// MAGIC %fs ls dbfs:/FileStore/tables/

// COMMAND ----------



val spark = SparkSession
  .builder()
  .appName("week5ex1c")
  .config("spark.some.config.option", "some-value")
  .getOrCreate()

// For implicit conversions like converting RDDs to DataFrames
import spark.implicits._
  

 val input = spark.read.textFile("/FileStore/tables/TheHungerGames.txt")

 val words = input.flatMap(x => x.split(" "))
    val wordCounts = words.rdd.countByValue()
    wordCounts.foreach(println)



// COMMAND ----------

//Generate a list from 1 to 45
var numbers = List.range(1,46)                    //> numbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
                                                  //| , 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                                                  //|  35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45)
//Sum of the numbers divisible by 4
var DB4 = numbers.filter( (x: Int) => x%4 == 0)   //> DB4  : List[Int] = List(4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44)
var sum = DB4.reduce( (x: Int, y: Int) => x + y)  //> sum  : Int = 264

//Sum of the squares of the numbers divisible by 3 and less than 20
var DB3L20 = numbers.filter( (x: Int) => (x%3 == 0)&&(x<20))
                                                  //> DB3L20  : List[Int] = List(3, 6, 9, 12, 15, 18)
var sum_sq = 0                                    //> sum_sq  : Int = 0

 for (n<-DB3L20 ){sum_sq = sum_sq+n*n}
 
 println(sum_sq)  

// COMMAND ----------

 
 
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
  


// COMMAND ----------




    

  
  case class Person(age:Int,	sex:String,	bmi:Double,	children:String,	smoker:String,	region:String,	charges:Double)

     

  
  
  def mapper(line:String): Person = {
    val fields = line.split(',')  
    
    val person:Person = Person(fields(0).toInt, fields(1), fields(2).toDouble, fields(3), fields(4), fields(5), fields(6).toDouble)
    return person
  }
  

  
    
  
    

    
    // Convert our csv file to a DataSet, using our Person case
    // class to infer the schema.
    import spark.implicits._
    
   // Read insurance.csv file 
    val lines = spark.sparkContext.textFile("/FileStore/tables/insurance.csv")
    val junk = lines.first()


    val fdata = lines.filter(x => x != junk) // removes the first line
    
    
    val people = fdata.map(mapper).toDS().cache()
    println("1. // Read insurance.csv file  : done!")
    
    //Print the size
    
    println("2. The number of rows in the data set is "+people.count)
  

    

   // Print sex and count of sex (use group by in sql)
    println("3. Print sex and count of sex (use group by in sql)")
 
    people.groupBy("sex").count().show()
    
    //Filter smoker=yes and print again the sex,count of sex
    println("4. Filter smoker=yes and print again the sex,count of sex")
    //println("Filter out  smokers:")
    people.filter(people("smoker").contains("yes")).groupBy("sex").count().show()
    
    
    
    //Group by region and sum the charges (in each region), then print rows bydescending order (with respect to sum)
    println("5. Group by region and sum the charges (in each region), then print rows bydescending order (with respect to sum)")
    people.groupBy("region").sum("charges").sort( $"sum(charges)".desc).show()
    
    
 
    

// COMMAND ----------


