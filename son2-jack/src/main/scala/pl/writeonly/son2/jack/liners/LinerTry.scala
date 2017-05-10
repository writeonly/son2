package pl.writeonly.son2.jack.liners

import pl.writeonly.son2.jack.providers.Provider

import scala.util.{Failure, Success, Try}

class LinerTry(provider: Provider) extends Liner(provider) {

  def apply(line: String): String = {
    Try(convert(line)) match {
      case Success(converted) => converted
      case Failure(exception) => exception.getStackTrace.mkString("\n")
    }
  }

}