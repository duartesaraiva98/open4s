package com.github.duartesaraiva98.open4s.api

case class IndexExistsApi(indexName: String) extends Api {
  override protected val request: Api.Request = Api.Request.HEAD
  override protected val uriPath: String      = indexName
  override protected val body: Option[String] = None
}
