package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object Query extends CodecConfig {
  implicit val encoder: Encoder[Query] = deriveConfiguredEncoder
}

case class Query(defaultField: Seq[String])
