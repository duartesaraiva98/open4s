package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object Idle extends CodecConfig {
  val default: Idle = Idle(Period.thirtySeconds)

  implicit val encoder: Encoder[Idle] = deriveConfiguredEncoder
}

case class Idle(after: Period)
