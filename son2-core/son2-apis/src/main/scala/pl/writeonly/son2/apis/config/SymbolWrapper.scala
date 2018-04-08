package pl.writeonly.son2.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

import pl.writeonly.sons.utils.ops.Pipe._

abstract class SymbolWrapper[T <: SymbolWrapper[T]](val s: Symbol) {
  def startsWith(other: T): Boolean = name.startsWith(other.name)

  def name: String = s.name
}

case class IllegalSymbolException[T <: SymbolWrapper[T]](
  symbol: SymbolWrapper[T]
) extends IllegalArgumentException(s"$symbol")

case class ProviderType(override val s: Symbol)
    extends SymbolWrapper[ProviderType](s)

case object ProviderType {
  @JsonCreator
  def apply(name: String): ProviderType =
    name |> Symbol.apply |> ProviderType.apply
}

case class Format(override val s: Symbol) extends SymbolWrapper[Format](s)

case object Format {
  @JsonCreator
  def apply(name: String): Format = name |> Symbol.apply |> Format.apply
}

case class Action(override val s: Symbol) extends SymbolWrapper[Action](s)

case object Action {
  @JsonCreator
  def apply(name: String): Action = name |> Symbol.apply |> Action.apply
}

trait MetaLike {
  def providerType: ProviderType
  def format: Format
}

case class Meta(providerType: ProviderType, format: Format) extends MetaLike
