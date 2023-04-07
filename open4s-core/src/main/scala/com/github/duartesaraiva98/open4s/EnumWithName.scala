package com.github.duartesaraiva98.open4s

import io.circe.{Encoder, Json}

import scala.util.matching.Regex

object EnumWithName {
  def deriveEncoder[T <: EnumWithName]: Encoder[T] = (a: T) => Json.fromString(a.name)
}

trait EnumWithName extends Product {
  def name: String = s"${productPrefix.head.toLower}${productPrefix.substring(1)}"

  val upperCaseRegex: Regex = "[A-Z]".r

  def snakeCaseName: String = name.flatMap(char =>
    if(char.isUpper) s"_${char.toLower}"
    else char.toString
  )
}
