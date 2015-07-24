#Akka远程启动Actor
config
----
本模版中重点关注local.conf,其中

	actor {
    	deployment {
      		"/local/*" {
        		remote = "akka.tcp://remoteSystem@127.0.0.1:2552"
      		}
    	}
  	}
  表示对于任何在/local/ actor路径之下的actor，由remoteSystem系统负责启动。简单理解为将所有在名为“local”的actor内部启动（例如通过actorOf）的actor，委托到远程系统。
  
path
----
可以通过actor的path方法查看相关actor的路径，本例中委托远端启动的actor路径为

	akka.tcp://remoteSystem@127.0.0.1:2552/remote/akka.tcp/localSystem@127.0.0.1:2554/user/local/remoteOne
通过这个路径可以看出是在远端存在（remoteSystem），但是是由本地发起（localSystem），因此路径很长。