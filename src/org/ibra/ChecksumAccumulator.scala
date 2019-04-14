package org.ibra
//Class definition
class ChecksumAccumulator {
  //Variables/fields
  var sum = 0  
  //Methods  
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~ (sum & 0xFF) + 1
}

//Singelton object, and because it has the same name as its parent class it is called companion object
object ChecksumAccumulator {
  import scala.collection.mutable.HashMap
  var cache = new HashMap[String, Int]
  
  def calculate(text: String): Int = {
    if(cache.contains(text)) {
      println("Fetched from cache, no more extra calculations.")
      return cache(text)
    } else {
      val acc = new ChecksumAccumulator()
      for(b <- text.getBytes()) {
        acc.add(b);
      }
      val cs = acc.checksum()
      cache += (text -> cs)
      return cs
    }
  }
}