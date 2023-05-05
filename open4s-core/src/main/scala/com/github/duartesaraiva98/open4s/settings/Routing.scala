package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object Routing extends CodecConfig {
  implicit val encoder: Encoder[Routing] = deriveConfiguredEncoder
}

case class Routing(allocation: Allocation, rebalance: Rebalance)
