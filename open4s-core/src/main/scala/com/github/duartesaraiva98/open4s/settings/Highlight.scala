package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object Highlight extends CodecConfig {
  val default: Highlight = Highlight(1000000)

  implicit val encoder: Encoder[Highlight] = deriveConfiguredEncoder
}

case class Highlight(maxAnalyzedOffset: Int)
