object week5exe2 {

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
 
 println(sum_sq)                                  //> 819
      
}