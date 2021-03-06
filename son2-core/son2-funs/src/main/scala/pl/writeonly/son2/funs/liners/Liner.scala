package pl.writeonly.son2.funs.liners

import pl.writeonly.son2.apis.converters.Converter

abstract class Liner(val provider: Converter) {

  def convert(line: String): String = provider.convert(line) + "\n"

  def comment(line: String): String = provider.comment(line) + "\n"

  def apply(line: String): String

}
