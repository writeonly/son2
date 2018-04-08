package pl.writeonly.son2.jack.notation

import pl.writeonly.son2.apis.config.WConfig
import pl.writeonly.son2.apis.notation.NotationWriter
import pl.writeonly.son2.jack.core.Jack

class NotationWriterJack(c: WConfig, jack: Jack)
    extends NotationWriter(jack, c) {

  override def writePretty(value: Any): String =
    jack.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)

  override def writeRaw(value: Any): String =
    jack.mapper.writeValueAsString(value)

  override def comment(s: String) = jack.s1 + s + jack.s2

}
