package org.ibra

import org.ibra.collections.CollectionsTest

class ChecksumApp {
  
  def filtering(): Unit = {
    val listFiles = new java.io.File("./src/org/ibra/math").listFiles()
    require(listFiles != null, "Files list are empty, check your path.")
    
    for(file <- listFiles 
        if file.isFile()
        if file.getName.endsWith(".scala");
        line <- scala.io.Source.fromFile(file).getLines.toList;
        trimmed = line.trim
        if trimmed.matches(".*gcd.*")
        ) {
      println(trimmed);
    }
  }
  
  def getLineLengths(): Array[Int] = {
    val listFiles = new java.io.File("./src/org/ibra/math").listFiles()
    require(listFiles != null, "Files list are empty, check your path.")
    
    val lineLengths = 
    for{file <- listFiles 
        if file.isFile()
        if file.getName.endsWith(".scala");
        line <- scala.io.Source.fromFile(file).getLines.toList;
        trimmed = line.trim} yield trimmed.length
        
        lineLengths
  }
  
  def testMatch(arg: String): String = {
   
    val result = arg match {
      case "1" => "It is number one"
      case "2" => "It is number two"
      case "3" => "It is number three"
      case _ => "Number is not defined"
    }
    
    result
  }    
 }

  

  object ChecksumApp extends App {
  
    //def main(args: Array[String]): Unit = {
      import org.ibra.ChecksumAccumulator;
      println(ChecksumAccumulator.calculate("calculate thiS"));
    //}
    /*val app = new ChecksumApp()
    println(app.testMatch("5"));*/
    /*import org.ibra.io.FileMatcher
    println(FileMatcher.contains("App").foreach(println));*/
    
    /*val testList = "a" :: "b" :: "c" :: Nil    
    println(testList.takeWhile(_.equals("c")))*/
    
    /*val list = List.apply(-1, 10, 50, 40);
    
    val app = new CollectionsTest()
    println(app.maxRecursion(list));*/
    //println(app.foldSum(List(1,2,3,4,5)))
    //println(app.mkString(List('H','e','l','l','o')))    
    //println(List(1,2,3,-4,5).dropWhile(_ > 0));
    //println(app.listCaseMatch(list));    
    //println(app.recursionTest(4, list));
    
    /*import org.ibra.collections.Queue
    val q: Queue[Int] = Queue(4,5,6,7,8)
    val q2: Queue[AnyVal] = q.enqueue(9.5);
    
    println(q)
    println(q2)*/
  }