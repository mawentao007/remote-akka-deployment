import akka.actor.{Actor, Props, ActorSystem}
import com.typesafe.config.ConfigFactory

/**
 * Created by marvin on 15-7-24.
 */
object Local {
  def main(args:Array[String]) ={

    val localSystem = ActorSystem("localSystem",ConfigFactory.load("local"))

    val localActor = localSystem.actorOf(Props[Local],"local")
    localActor ! "[local]may be ok"


  }

}

class Local extends Actor{
  override def preStart {

    val remoteActor = context.actorOf(Props[Remote],"remoteOne")
    println(remoteActor.path)
    remoteActor ! "[remote]let us go"

  }

  def receive = {
    case msg:String => println(msg)
        val rActor = context.actorSelection("akka.tcp://remoteSystem@127.0.0.1:2552/remote/akka.tcp/localSystem@127.0.0.1:2554/user/local/remoteOne")
        rActor ! "[remote]now"
  }

}
