import akka.actor.{Props, ActorSystem, Actor}
import com.typesafe.config.ConfigFactory

/**
 * Created by marvin on 15-7-24.
 */
object Remote{
  def main(args:Array[String])={
    ActorSystem("remoteSystem",ConfigFactory.load("remote"))
    println(" ")
  }
}

class Remote extends Actor {

  def receive ={
    case msg:String=> println(msg)
      sender ! "what happened"
  }

}
