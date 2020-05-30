object week5ex1b {
  var nums = List.range(1,10)                     //> nums  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val oddNums = nums.filter( (x: Int) => x%2 != 0)//> oddNums  : List[Int] = List(1, 3, 5, 7, 9)
  
  
  def fac (n: Int): Int ={
   if(n==0) return 1
   else  return n*fac(n-1)
  }                                               //> fac: (n: Int)Int
  fac(5)                                          //> res0: Int = 120
 
 val mapedlist = oddNums.map( (oddNum: Int) => {fac(oddNum)})
                                                  //> mapedlist  : List[Int] = List(1, 6, 120, 5040, 362880)
  
}