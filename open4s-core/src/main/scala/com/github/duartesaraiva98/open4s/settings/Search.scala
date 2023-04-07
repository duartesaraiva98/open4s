package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object Search extends CodecConfig {
  val default: Search = Search(Idle.default)

  implicit val encoder: Encoder[Search] = deriveConfiguredEncoder
}

case class Search(idle: Idle)
