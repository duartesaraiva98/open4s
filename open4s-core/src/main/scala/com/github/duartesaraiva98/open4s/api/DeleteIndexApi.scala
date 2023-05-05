package com.github.duartesaraiva98.open4s.api

case class DeleteIndexApi(indexName: String) extends Api {
  override protected val request: Api.Request = Api.Request.DELETE
  override protected val uriPath: String      = indexName
  override protected val body: Option[String] = None
}
