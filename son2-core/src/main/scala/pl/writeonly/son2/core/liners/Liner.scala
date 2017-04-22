package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.util.AppLazyLogging


abstract class Liner(val provider: Provider) extends AppLazyLogging {

  def convert(line: String) = provider.convert(line) + "\n"

  def comment(line: String) = provider.comment(line) + "\n"

  def apply(line: String): String

}
