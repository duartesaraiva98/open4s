package com.github.duartesaraiva98.open4s.settings

import io.circe.{Encoder, Json}

case class AutoExpandReplicas(min: Int, max: AutoExpandReplicas.MaxOrAll) {
  def asString = s"$min-${max.label}"
}

object AutoExpandReplicas {
  implicit val encoder: Encoder[AutoExpandReplicas] =
    (a: AutoExpandReplicas) => Json.fromString(a.asString)

  sealed trait MaxOrAll { val label: String }

  object MaxOrAll {

    case class Max(value: Int) extends MaxOrAll {
      override val label: String = value.toString
    }

    case object All extends MaxOrAll {
      override val label: String = "all"
    }
  }
}
