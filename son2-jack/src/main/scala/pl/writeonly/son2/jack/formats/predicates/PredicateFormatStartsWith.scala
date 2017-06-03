package pl.writeonly.son2.jack.formats.predicates

import pl.writeonly.son2.jack.core.Formats._
import pl.writeonly.son2.jack.formats.creators.CreatorFormat

class PredicateFormatStartsWith[F]() extends PredicateFormat[F]() {

  override def on(s: String): Boolean = OBJECT.startsWith(s)

  override def yaml(s: String): Boolean = YAML.startsWith(s)

  override def xml(s: String): Boolean = XML.startsWith(s)

  override def csv(s: String): Boolean = CSV.startsWith(s)

  override def javaprops(s: String): Boolean = JAVA_PROPS.startsWith(s)

  override def properties(s: String): Boolean = PROPERTIES.startsWith(s)

}
