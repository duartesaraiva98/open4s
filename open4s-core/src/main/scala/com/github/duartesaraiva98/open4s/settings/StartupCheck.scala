package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.EnumWithName
import io.circe.Encoder

sealed trait StartupCheck extends EnumWithName

object StartupCheck {
  implicit val codec: Encoder[StartupCheck] = EnumWithName.deriveEncoder

  case object False extends StartupCheck

  case object True extends StartupCheck

  case object Checksum extends StartupCheck
}
