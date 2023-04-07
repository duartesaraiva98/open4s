package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object SoftDeletes extends CodecConfig {
  val default: SoftDeletes = SoftDeletes(RetentionLease.default)

  implicit val encoder: Encoder[SoftDeletes] = deriveConfiguredEncoder
}

case class SoftDeletes(retentionLease: RetentionLease)
