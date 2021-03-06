package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.RWTConfig

trait PartialCreator extends PartialFunction[RWTConfig, NotationRWT] {

  override def apply(s: RWTConfig) = rwt(s)

  def rwt(c: RWTConfig) = NotationRWT(r(c), w(c), t(c))

  def r(c: RWTConfig): NotationReaderLike

  def w(c: RWTConfig): NotationWriter

  def t(c: RWTConfig): NotationTranslator

  def is(s: RWTConfig): Boolean = isDefinedAt(s)

}
