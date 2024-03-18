 
// import scala.util .Random
//  val random=new Random()

//  def listaAlAzar(long:Int): List[Int] ={
//  //Crea una lista de long enteros,
//  // con valores aleatorios entre 1 y long 2
//     val v=Vector. fill(long){
//      random.nextInt(long*2)+1
//  }

//  v.toList
// }

// def menorQue(a:Int, b:Int): Boolean=a<b
// def mayorQue(a:Int, b:Int): Boolean=a>b
// def algortmosIguales(a:Int,b:Int):Boolean= a==b
// def comparar[T](a1:List[Int]=>(List[Int],Int) , a2:List[Int]=>(List[Int],Int), l : List [Int]):( Int , Int) = {
//     val(v1,v2)=(a1(l)._2,a2(l)._2)
//     val(l1,l2)=(a1(l)._1,a2(l)._1)
//     if(!(l1==l2)) (-1,-1)
//     else (v1,v2)
      
    
    
// }

//  def menoresQue_noMenoresQue[T](l : List [T] , v:T, comparador:(T,T)=>Boolean): (List [T] , List [T] , Int) = {
//    def aux(l:List[T],l1:List[T],l2:List[T]):(List [T] , List [T] , Int) ={
//       if(l.isEmpty)(l1,l2,0)
//       else if(comparador(v,l.head)){
         
//          val(l_me,l_ma,v1)=aux(l.tail,l1,l.head::l2)
//          (l_me,l_ma,v1+1)

//       }else{
         
//          val(l_me,l_ma,v1)=aux(l.tail,l.head::l1,l2)
//          (l_me,l_ma,v1+1)
//       }
//    }
//    aux(l.tail,List(),List(v))
     
// }

// def quickSort[T](comp:(T,T)=>Boolean): List[T]=>(List[T],Int) = {
//    def quick(l:List[T]):(List[T],Int)={
      
//     if(l.isEmpty||l.tail.isEmpty) (l,0)
//       else{
//          val (l1,l2,v1)=menoresQue_noMenoresQue(l,l.head,comp)
//          val(l3,v2)=quick(l1)
//          val(l4,v3)=quick(l2)
//          (l3++l4,v1+v2+v3)
//   }
// }
// quick
// }

// def insert[T](e:T,sortedList:List[T],comparador:(T,T)=>Boolean):(List[T],Int)={
//     if(sortedList.isEmpty) (e::sortedList,0)
//     else if (comparador(e,sortedList.head)) (e::sortedList,1)
//     else {
//       val(l,v)=insert(e,sortedList.tail,comparador)
//       (sortedList.head::l,v+1)
//     }
//   }

//   //--------------------------------------------------------------------------tercera funcion correcta
//   def insertionSort[T](comparador:(T,T)=>Boolean):List[T]=>(List[T],Int)={
//   def insertionS(list:List[T]):(List[T],Int)={
//     if(list.isEmpty || list.tail.isEmpty)(list,0)
//     else {
//       val(l,v)=insertionS(list.tail)
//       val(l1,v1)=insert(list.head,l,comparador)
//       (l1,v1+v)
//     }
//   }  
//   insertionS
  
// }


// val lis=List(3,2,1,4,5,6)

// val lista: List[Int] = List(3,2,1,4,5,6)

// val a1=insertionSort[Int](menorQue)
// val a2=quickSort[Int](menorQue)
// comparar[Int](a1,a2,lista)

// lis==lista

//---------------------------------------------------------actualizacion 3/17/2024
// def menoresQue_noMenoresQue[T](l : List [T] , v:T, comparador:(T,T)=>Boolean): (List [T] , List [T] , Int) = {
//    def aux(l:List[T],l1:List[T],l2:List[T]):(List [T] , List [T] , Int) ={
//       if(l.isEmpty|| l.tail.isEmpty)(l1,l2,0)
      
//       else if(comparador(l.tail.head,v)){
         
//          val(l_me,l_ma,v1)=aux(l.tail,l.tail.head::l1,l2)
//          (l_me,l_ma,v1+1)

//       }else{
         
//          val(l_me,l_ma,v1)=aux(l.tail,l1,l.tail.head::l2)
//          (l_me,l_ma,v1+1)
//       }
//    }
//    aux(l,List(),List(v))
     
// }

// def quickSort[T](comp:(T,T)=>Boolean): List[T]=>(List[T],Int) = {
//    def quick(l:List[T]):(List[T],Int)={
//       def aux(l:List[T],l2:List[T]):(List[T],Int)={

//          if(l.isEmpty)(l,0)
//          else if(l==l2){
//             (l,1)
//          }
//          else{
//          val (l1,l2,v1)=menoresQue_noMenoresQue(l,l.head,comp)
//          val(l3,v2)=aux(l1,l)
//          val(l4,v3)=aux(l2,l)
//          (l3++l4,v1+v3+v2)
         
         
//          }
//       }
      
         
//       aux(l,List())  
//       }
// quick
// }

//ultima actualizacion-----------------------------------------------------3/17/2024
def menoresQue_noMenoresQue[T](l: List[T], v: T, comp: (T, T) => Boolean): (List[T], List[T], Int) = {
def reverseList[T](l:List[T],l2:List[T]):List[T]={
   if(l.isEmpty)(l2)
   else reverseList(l.tail,l.head::l2)
}
  def aux(l: List[T], l1: List[T], l2: List[T], count: Int): (List[T], List[T], Int) = {
    if (l.isEmpty) (reverseList(l1,List()), reverseList(l2,List()), count)
    else {
      val head = l.head
      val tail = l.tail
      if (comp(head, v)) aux(tail, head :: l1, l2, count + 1)
      else aux(tail, l1, head :: l2, count + 1)
    }
  }

  aux(l, List(), List(), 0)
}


def quickSort[T](comp: (T, T) => Boolean): List[T] => (List[T],Int) = {
  def quick(l: List[T]): (List[T],Int) = {
    def aux(l: List[T]): (List[T],Int) = {
      if (l.isEmpty || l.tail.isEmpty) (l,0)
      else {
        val pivot = l.head
        val (less, greater, c) = menoresQue_noMenoresQue(l.tail, pivot, comp)
        val(less1,c1)=aux(less)
        val((greater1),c2)=aux(greater)
        (less1++(pivot::greater1),c+c1+c2)
        
      }
    }
    aux(l)
  }
  quick
}
