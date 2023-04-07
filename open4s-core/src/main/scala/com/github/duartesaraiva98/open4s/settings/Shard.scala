package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object Shard extends CodecConfig {
  val default: Shard = Shard(StartupCheck.False)

  implicit val encoder: Encoder[Shard] = deriveConfiguredEncoder
}

case class Shard(checkOnStartup: StartupCheck)
