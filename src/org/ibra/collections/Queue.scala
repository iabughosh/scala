package org.ibra.collections

trait Queue[+T] {
  
  def head(): T
  def tail(): Queue[T]
  def enqueue[U >: T](element: U): Queue[U]
}

object Queue {
  
  def apply[T](elements: T*): Queue[T] = {
    
    new QueueImpl[T](elements.toList, Nil)
  }
  
  def apply[T](elements: List[T]): Queue[T] = {
    
    new QueueImpl[T](elements, Nil)
  }
  
  private class QueueImpl[T](
                private var leading: List[T],
                private var trailing: List[T]) 
          extends Queue[T] {
    
    //TODO: Enhance
    def mirror = if(leading.isEmpty) new QueueImpl[T](trailing.reverse, Nil)
                 else this
    
    override def head(): T = {
      mirror.leading.head
    }
    
    override def tail(): Queue[T] = {
      val q = mirror
      new QueueImpl[T](q.leading.tail, q.trailing)
    } 
    
    override def enqueue[U >: T](element: U): Queue[U] = {
      new QueueImpl[U](leading, element :: trailing)
    }
    
    override def toString(): String = {
      val sep = trailing match {
        case Nil => ""
        case _ => ","
      }
      val str = leading.mkString("[",",","") + sep + trailing.reverse.mkString("",",","]")
      str
    }
  }
}