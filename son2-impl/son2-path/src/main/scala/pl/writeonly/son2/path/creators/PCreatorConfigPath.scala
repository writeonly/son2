package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.core.pcreators.PCreatorConfig
import pl.writeonly.son2.path.core.{ConfigPath, ProvidersPath}

class PCreatorConfigPath(f: Symbol) extends PartialCreatorConfigSymbol(f) {
  override def apply(s: String): Config = ConfigPath(provider = Symbol(s))
}

class PCreatorConfigPathMain extends PCreatorConfig {

  override def isDefinedAt(s: String) = s != null && s.startsWith("$")

  override def apply(s: String) = new Config(
    read = RConfig(provider = ProvidersPath.SMART, path = Option(s)),
    write = WConfig(provider = ProvidersPath.STRICT, style = false)
  )
}
