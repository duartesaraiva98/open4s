package com.github.duartesaraiva98.open4s

import io.circe.{Encoder, Json}

object IndexAliases {
  implicit val encoder: Encoder[IndexAliases] = (a: IndexAliases) =>
    Json.fromFields(a.values.map((_, Json.obj())))
}

case class IndexAliases(values: Seq[String])