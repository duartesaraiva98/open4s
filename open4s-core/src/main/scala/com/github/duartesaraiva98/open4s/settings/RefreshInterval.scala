package com.github.duartesaraiva98.open4s.settings

import io.circe.{Encoder, Json}

sealed trait RefreshInterval

object RefreshInterval {
  val default: Enabled = Enabled(Period.oneSecond)

  implicit val encoder: Encoder[RefreshInterval] = {
    case Disabled => Json.fromString("-1")
    case Enabled(period) => Json.fromString(period.asString)
  }

  case object Disabled extends RefreshInterval

  case class Enabled(period: Period = Period.oneSecond) extends RefreshInterval
}