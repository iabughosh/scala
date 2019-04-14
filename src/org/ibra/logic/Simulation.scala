package org.ibra.logic

abstract class Simulation {
  
  type Action = () => Unit
  case class WorkItem(time: Int, action: Action)
  
  private var curTime = 0
  def currentTime(): Int = curTime
  
  private var agenda: List[WorkItem] = List()
  
  private def insert(item: WorkItem, ag: List[WorkItem]): List[WorkItem] = {
    
    if(ag == Nil || ag.isEmpty || item.time < ag.head.time) item :: ag
    else ag.head :: insert(item, ag.tail)
  }
  
  def afterDelay(delay: Int)(action: => Unit): Unit = {
    
    insert(WorkItem(curTime + delay, () => action), agenda)
  }
  
  private def next(): Unit = {
    
    (agenda: @unchecked) match {
      case head :: tail => {
        curTime = head.time
        agenda = tail
        head.action()
      }
    }
  }
  
  def run(): Unit = {
    afterDelay(0){println("Simulation has been started at : " + curTime)}
    while(!agenda.isEmpty) next()    
  }
}