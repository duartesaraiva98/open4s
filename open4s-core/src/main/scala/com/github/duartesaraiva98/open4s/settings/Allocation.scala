package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.{CodecConfig, EnumWithName}
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

case class Allocation(enable: Allocation.Value)

object Allocation extends CodecConfig {
  def apply: Allocation = new Allocation(Allocation.Value.All)

  implicit val encoder: Encoder[Allocation] = deriveConfiguredEncoder

  sealed trait Value extends EnumWithName

  object Value {
    implicit val encoder: Encoder[Value] = EnumWithName.deriveEncoder

    case object All extends Value

    case object Primaries extends Value

    case object NewPrimaries extends Value

    case object None extends Value
  }
}
