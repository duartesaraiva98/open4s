package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.{CodecConfig, EnumWithName}
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

case class Rebalance(enable: Rebalance.Value)

object Rebalance extends CodecConfig {
  def apply: Rebalance = new Rebalance(Rebalance.Value.All)

  implicit val encoder: Encoder[Rebalance] = deriveConfiguredEncoder

  sealed trait Value extends EnumWithName

  object Value {
    implicit val encoder: Encoder[Value] = EnumWithName.deriveEncoder

    case object All extends Value

    case object Primaries extends Value

    case object Replicas extends Value

    case object None extends Value
  }
}
