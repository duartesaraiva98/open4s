package com.github.duartesaraiva98.open4s.api

case class OpenIndexApi(indexName: String) extends Api {
  override protected val request: Api.Request = Api.Request.POST
  override protected val uriPath: String = s"$indexName/_open"
  override protected val body: Option[String] = None
}
