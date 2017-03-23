package pl.writeonly.son2.main

import java.io.FileInputStream

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers._
import pl.writeonly.son2.core.streamers.{StreamerImpl, StreamerSource}
import pl.writeonly.son2.util.AppLogging

object MainSon2 extends AppLogging {

  val YAML = ".yaml"

  val son2 = args.length match {
    case 0 => Option.empty
    case _ => args(0).toLowerCase match {
      case o if ("object".startsWith(o)) => Option(new ProviderObject)
      case y if ("yaml".startsWith(y)) => Option(new ProviderYaml)
      case x if ("xml".startsWith(x)) => Option(new ProviderXml)
      case c if ("csv".startsWith(c)) => Option(new ProviderCsv)
      case j if ("javaprops".startsWith(j)) => Option(new ProviderJavaProps)
      case p if ("properties".startsWith(p)) => Option(new ProviderJavaProps)
      case _ => Option.empty
    }
  }

  son2.map { s =>
    val streamer = new StreamerImpl(new LinerOpt (s))
    val source = new StreamerSource(new LinerOpt (s))
    args.length match {
      case 1 => streamer.convertStream(System.in, System.out)
      case 2 => source.convertStream(new FileInputStream(args(1)), System.out)
      case _ => streamer.convertFile(args(1), args(2))
    }
  }.getOrElse {
    val file = new StreamerSource(new LinerOpt(new ProviderIdentity))
    val in = getClass().getClassLoader().getResourceAsStream("README.md")
    file.convertStream(in, System.out)
  }
}

class MainSon2(file: StreamerImpl) {
  def convertStream() = file.convertStream(System.in, System.out)

  def convertFile(in: String) = file.convertFile(in, in + MainSon2.YAML)

  def convertFile(in: String, out: String) = file.convertFile(in, out)

}
