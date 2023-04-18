package com.github.duartesaraiva98.open4s.mappings

import io.circe.Encoder
import io.circe.syntax.EncoderOps
import io.circe.generic.semiauto

sealed trait Params

object Params {

  implicit val objectParamsEncoder: Encoder[Object] = semiauto.deriveEncoder

  implicit val encoder: Encoder[Params] = {
    case b: Base   => b.asJson(semiauto.deriveEncoder[Base])
    case o: Object => o.asJson(objectParamsEncoder)
  }

  case class Base(index: scala.Boolean = true) extends Params

  case class Object(
      dynamic: String = "true", // true || false || strict
      enabled: Boolean = true
  ) extends Params
}
