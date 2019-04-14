package org.ibra.collections

import scala.annotation.tailrec

class CollectionsTest {
  
  def checkListOp(): Unit = {
    
    val list = List("Hello", "there,", "this", "is", "awesome")
    val charsList = list.map(_.toList)
    println(charsList)
    val flattedList = charsList.flatMap(_ .mkString)
    println(flattedList)
  }
  
  def sumList(list: List[Int]): Int = {
    
    var sum = 0
    list.foreach(sum += _)
    sum
  }    
  
  def reduceSum(list: List[Int]): Int = {
    
    list.reduceLeft(_ + _);
  }
  
  def foldSum(list: List[Int]): Int = {
    
    //list.foldLeft(0)(_ + _)
    (0 /: list) (_ + _)
  }
  
  def mkString(list: List[Char]): String = {
    
    ("" /: list)(_ + "" + _)
  }    
  
  def recursionTest(a: Int, list: List[Int]): List[Int] = {
    if(list.isEmpty || a < list.head) {
      a :: list
    } else {
      list.head :: recursionTest(a, list.tail)
    }
  }
  
  def listCaseMatch(list: List[Int]): Unit = {
    list match {
      case Nil => print("")
      case head :: tail => {println("[head : " + head + "]");println("[tail : " + tail + "]");}
    }
  }
  
  def fib(number: Int): Int = {
    
    @tailrec
    def _fib(x: Int, prev:Int = 0, next: Int = 1): Int = {
      x match {
        case 0 => {println("prev");prev}
        case 1 => {println("next");next}
        case _ => _fib(x-1, next, (prev + next))
      }
    }
    
    _fib(number)
  }
  
  def sumRecursion(list: List[Int]): Int = {
    @tailrec
    def _sumRecursion(subList: List[Int], acc: Int): Int = {
      subList match {
        case Nil => acc
        case head :: tail => _sumRecursion(tail, acc + head)
      }
    }
    
    _sumRecursion(list, 0)
  }
  
  def facRecursion(list: List[Int]): Int = {
    @tailrec
    def _sumRecursion(subList: List[Int], acc: Int): Int = {
      subList match {
        case Nil => acc
        case head :: tail => _sumRecursion(tail, acc * head)
      }
    }
    
    _sumRecursion(list, 1)
  }    
  
  def maxRecursion(list: List[Int]): Int = {    
    @tailrec
    def _maxRecursion(internalList: List[Int], maxHolder: Int): Int = {
      internalList match {
        case Nil => maxHolder
        case head :: tail => {
          if (head > maxHolder) 
            _maxRecursion(tail, head)
          else 
            _maxRecursion(tail, maxHolder)
        }
      }
    }
    
    _maxRecursion(list, 0)
  }
}