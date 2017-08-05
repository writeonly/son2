package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.Config

case class NotationPair(
                         c: String => Config,
                         r: NotationReader = null,
                         w: NotationWriter = null,
                         t:NotationTranslator = null
                       )
