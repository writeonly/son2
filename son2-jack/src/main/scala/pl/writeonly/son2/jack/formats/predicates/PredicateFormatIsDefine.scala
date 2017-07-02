package pl.writeonly.son2.jack.formats.predicates

import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.notation.NotationReaderJack

import scala.util.control.Exception.catching

class PredicateFormatIsDefine(c: CreatorFormat[NotationReaderJack]) extends PredicateFormat[NotationReaderJack]() {

  override def on(s: String): Boolean = isDefined(s, c.on)

  override def yaml(s: String): Boolean = isDefined(s, c.yaml)

  override def xml(s: String): Boolean = isDefined(s, c.xml)

  override def csv(s: String): Boolean = isDefined(s, c.csv)

  override def javaprops(s: String): Boolean = isDefined(s, c.javaprops)

  override def properties(s: String): Boolean = isDefined(s, c.javaprops)

  def isDefined(s: String, om: NotationReaderJack): Boolean = catching(classOf[Exception])
    .opt(om(s))
    .isDefined

}
