package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.{Meta, MetaLike, WConfig}
import pl.writeonly.son2.apis.core.core.DString

class NotationTranslator(meta: MetaLike, c: WConfig, t: DString)
    extends NotationWriter(meta, c)
    with NotationReaderLike {
  override def writePretty(value: Any): String = value.asInstanceOf[String]

  override def writeRaw(value: Any): String = value.asInstanceOf[String]

  override def apply(s: String): Any = t(s)
}
