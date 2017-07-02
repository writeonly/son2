package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationWriterJack}

class PartialCreatorXml(pretty: Boolean) extends PartialCreatorPair {
  def startsWith = Formats.XML

  def r = new NotationReaderJack(new XmlMapper)

  def w = new NotationWriterJack(pretty, new XmlMapper, "<!-- ", " -->")
}
