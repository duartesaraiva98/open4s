package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.EnumWithName
import io.circe.Encoder

sealed trait Codec extends EnumWithName

object Codec {
  implicit val encoder: Encoder[Codec] = EnumWithName.deriveEncoder

  case object Default extends Codec

  case object BestCompression extends Codec
}
