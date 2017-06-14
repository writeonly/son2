package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.glue.{Config, MatcherFormatProvider}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.path.formats.matchers.{MatcherFormatPath, MatcherFormatSmart}

class MatcherFormatProviderPath(c: Config) extends MatcherFormatProvider(c) {
//  def r = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatReader())
//  def w = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatWriter(c))
  def r = new MatcherFormatPath()
  def w = new MatcherFormatSmart(c.p)


}

object MatcherFormatProviderPath {

  def apply(config: Config): Provider = either(config)
    .right
    .get

  //  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()

  def either(config: Config): Either[Option[String], Provider] = new MatcherFormatProviderPath(config)
    .apply()



  //either
}