package com.github.duartesaraiva98.open4s.api

import com.github.duartesaraiva98.open4s.settings.IndexSettings
import com.github.duartesaraiva98.open4s.{CodecConfig, IndexAliases, IndexMappings}
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.{Encoder, Printer}
import io.circe.syntax.EncoderOps


// TOOD: URL Params, aliases
case class CreateApi(indexName: String, indexSettings: IndexSettings, indexMappings: IndexMappings, indexAliases: IndexAliases) extends Api {

  override val request: Api.Request = Api.Request.PUT
  override val uriPath: String = indexName
  override val body: String = CreateApi.Request(indexSettings, indexMappings, indexAliases).asJson.printWith(Printer.noSpaces.copy(dropNullValues = true))
}

object CreateApi {
  object Request extends CodecConfig {
    implicit val encoder: Encoder[Request] = deriveConfiguredEncoder
  }

  case class Request(settings: IndexSettings, mappings: IndexMappings, aliases: IndexAliases)
}
