package com.github.duartesaraiva98.open4s.api

import com.github.duartesaraiva98.open4s.api.Api.Request

import java.net.URI
import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers
import scala.util.chaining.scalaUtilChainingOps

trait Api {
  protected val request: Api.Request
  protected val uriPath: String
  protected val body: Option[String]

  def httpRequest(host: String, port: Int): HttpRequest =
    HttpRequest
      .newBuilder(URI.create(s"$host:$port/$uriPath"))
      .header("Content-Type", "application/json")
      .pipe(httpRequest =>
        request match {
          case Request.GET => httpRequest.GET()
          case Request.PUT => httpRequest.PUT(BodyPublishers.ofString(body.getOrElse("")))
          case Request.POST => httpRequest.POST(BodyPublishers.ofString(body.getOrElse("")))
          case Request.DELETE => httpRequest.DELETE()
        }
      )
      .build()
}

object Api {
  sealed trait Request

  object Request {
    case object GET extends Request
    case object PUT extends Request
    case object POST extends Request
    case object DELETE extends Request
  }
}
