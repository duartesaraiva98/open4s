package com.github.duartesaraiva98.open4s.api

import com.github.duartesaraiva98.open4s.mappings.IndexMappings
import com.github.duartesaraiva98.open4s.settings.IndexSettings
import com.github.duartesaraiva98.open4s.{CodecConfig, IndexAliases}
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.{Encoder, Printer}
import io.circe.syntax.EncoderOps

// TOOD: URL Params
case class CreateIndexApi(
    indexName: String,
    indexSettings: IndexSettings,
    indexMappings: IndexMappings,
    indexAliases: IndexAliases
) extends Api {

  override protected val request: Api.Request = Api.Request.PUT
  override protected val uriPath: String      = indexName
  override protected val body: Option[String] = Some(
    CreateIndexApi
      .Request(indexSettings, indexMappings, indexAliases)
      .asJson
      .printWith(Printer.noSpaces.copy(dropNullValues = true))
  )
}

object CreateIndexApi {
  object Request extends CodecConfig {
    implicit val encoder: Encoder[Request] = deriveConfiguredEncoder
  }

  case class Request(settings: IndexSettings, mappings: IndexMappings, aliases: IndexAliases)
}
