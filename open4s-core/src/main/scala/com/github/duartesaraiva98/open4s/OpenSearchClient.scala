package com.github.duartesaraiva98.open4s

import com.github.duartesaraiva98.open4s.api.{Api, CloseIndexApi, CreateIndexApi, DeleteIndexApi, OpenIndexApi}
import com.github.duartesaraiva98.open4s.mappings.IndexMappings
import com.github.duartesaraiva98.open4s.settings.IndexSettings

import java.net.http.{HttpClient, HttpResponse}
import scala.util.{Failure, Success, Try}

class OpenSearchClient(client: HttpClient, host: String, port: Int) {

  def createIndex(
      indexName: String,
      indexSettings: IndexSettings,
      indexMappings: IndexMappings,
      indexAliases: IndexAliases
  ): Try[Unit] =
    execute(CreateIndexApi(indexName, indexSettings, indexMappings, indexAliases))

  def deleteIndex(indexName: String): Try[Unit] = execute(DeleteIndexApi(indexName))

  def closeIndex(indexName: String): Try[Unit] = execute(CloseIndexApi(indexName))

  def openIndex(indexName: String): Try[Unit] = execute(OpenIndexApi(indexName))

  private def execute(api: Api) = Try(
    client.send(api.httpRequest(host, port), HttpResponse.BodyHandlers.ofString)
  ) match {
    case Failure(exception) =>
      println(exception) // TODO: Make logger
      Success(())
    case Success(response) =>
      println(response.body())
      Success(())
  }

}
