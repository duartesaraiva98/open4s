package com.github.duartesaraiva98.open4s

import io.circe.generic.extras.Configuration

trait CodecConfig {
  implicit val SnakeCaseConfig: Configuration = Configuration.default.withSnakeCaseMemberNames

}
