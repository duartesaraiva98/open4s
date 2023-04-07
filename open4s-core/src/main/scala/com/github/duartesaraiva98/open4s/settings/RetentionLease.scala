package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object RetentionLease extends CodecConfig {
  val default: RetentionLease = RetentionLease(Period.twelveHours)

  implicit val encoder: Encoder[RetentionLease] = deriveConfiguredEncoder
}

case class RetentionLease(period: Period)
