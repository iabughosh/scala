package org.ibra.io

object FileMatcher {
  
  val listFiles = new java.io.File("./src/org/ibra").listFiles()
  
  private def fileMatching(matcher: String => Boolean): Array[String] = {
    
    for(file <- listFiles
      if matcher(file.getName)) 
      yield file.getName
  }
  
  def endsWith(query: String): Array[String] = {
    fileMatching(_.endsWith(query))
  }
  
  def contains(query: String): Array[String] = {
    fileMatching(_.contains(query))
  }
}