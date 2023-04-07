package com.github.duartesaraiva98.open4s.settings

import io.circe.{Encoder, Json}

import java.time.temporal.ChronoUnit

object Period {
  val twelveHours: Period = Period(12, ChronoUnit.HOURS)
  val sixtySeconds: Period = Period(60, ChronoUnit.SECONDS)
  val thirtySeconds: Period = Period(30, ChronoUnit.SECONDS)
  val oneSecond: Period = Period(1, ChronoUnit.SECONDS)

  implicit val encoder: Encoder[Period] = (a: Period) => Json.fromString(a.asString)
}

case class Period(value: Int, unit: ChronoUnit) {

  def asString: String = {
    val letter: Char = unit match {
      case ChronoUnit.SECONDS => 's'
      case ChronoUnit.MINUTES => 'm'
      case ChronoUnit.HOURS => 'h'
      case ChronoUnit.DAYS => 'd'
      case _ => throw new IllegalArgumentException(s"Incompatible unit '$unit' provided")
    }
    s"$value$letter"
  }
}
