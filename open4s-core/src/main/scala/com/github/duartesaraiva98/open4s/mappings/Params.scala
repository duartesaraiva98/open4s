package com.github.duartesaraiva98.open4s.mappings

import io.circe.Encoder
import io.circe.syntax.EncoderOps
import io.circe.generic.semiauto

sealed trait Params


object Params {

  implicit val encoder: Encoder[Params] = {
    case b: Base => b.asJson(semiauto.deriveEncoder[Base])
  }

  implicit val objectEncoder: Encoder[Object] = semiauto.deriveEncoder

  case class Base(index: scala.Boolean = true) extends Params

  case class Object(dynamic: String = "true", // true || false || strict
                    enabled: Boolean = true
                   ) extends Params
}
