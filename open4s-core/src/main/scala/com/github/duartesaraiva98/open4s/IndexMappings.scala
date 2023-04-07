package com.github.duartesaraiva98.open4s

import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.syntax.EncoderOps
import io.circe.{Encoder, Json}

case class IndexMappings(properties: Seq[IndexMappings.Type])

object IndexMappings extends CodecConfig {

  implicit val encoder: Encoder[IndexMappings] = deriveConfiguredEncoder

  sealed trait Type extends EnumWithName {
    val fieldName: java.lang.String
    val index: scala.Boolean = true
  }

  object Type {

    implicit val e: Encoder[Seq[Type]] = (a: Seq[Type]) => {
      val at: Seq[(java.lang.String, Json)] = a.map {
        case Object(fieldName, mappings) => (fieldName, mappings.asJson)
        case n: Numeric.ScaledFloat =>
          (n.fieldName, Json.obj(
            ("type", Json.fromString(n.snakeCaseName)),
            ("scaling_factor", Json.fromInt(n.scalingFactor))
          ))
        case t => (t.fieldName, Json.obj(("type", Json.fromString(t.snakeCaseName))))
      }

      Json.obj(at: _*)
    }

    case class Boolean(fieldName: java.lang.String) extends Type

    case class Object(fieldName: java.lang.String, mappings: IndexMappings) extends Type

    case class Binary(fieldName: java.lang.String, docValues: scala.Boolean = false, store: scala.Boolean = false) extends Type

    case class Ip(fieldName: java.lang.String) extends Type

    case class Date(fieldName: java.lang.String) extends Type

    object Date {

      sealed trait Format

    }

    sealed trait Range extends Type

    object Range {

      case class IntegerRange(fieldName: java.lang.String) extends Range

      case class LongRange(fieldName: java.lang.String) extends Range

      case class DoubleRange(fieldName: java.lang.String) extends Range

      case class FloatRange(fieldName: java.lang.String) extends Range

      case class IpRange(fieldName: java.lang.String) extends Range

      case class DateRange(fieldName: java.lang.String) extends Range //TODO: Formats https://opensearch.org/docs/2.4/opensearch/supported-field-types/date/#formats
    }

    sealed trait Numeric extends Type

    object Numeric {

      case class Byte(fieldName: java.lang.String) extends Numeric

      case class Double(fieldName: java.lang.String) extends Numeric

      case class HalfFloat(fieldName: java.lang.String) extends Numeric

      case class Float(fieldName: java.lang.String) extends Numeric

      case class Integer(fieldName: java.lang.String) extends Numeric

      case class Long(fieldName: java.lang.String) extends Numeric

      case class Short(fieldName: java.lang.String) extends Numeric

      case class ScaledFloat(fieldName: java.lang.String, scalingFactor: Int) extends Numeric
    }

    sealed trait String extends Type {

    }

    object String {

      case class Keyword(fieldName: java.lang.String) extends String

      case class Text(fieldName: java.lang.String) extends String

      case class TokenCount(fieldName: java.lang.String) extends String
    }
  }
}