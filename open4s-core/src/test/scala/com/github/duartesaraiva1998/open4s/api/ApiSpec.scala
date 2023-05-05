package com.github.duartesaraiva1998.open4s.api

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.net.URI
import java.net.http.HttpRequest

trait ApiSpec extends AnyWordSpec with Matchers {
  val host: String = "http://localhost"
  val port: Int    = 9200

  def baseRequestBuilder(uriPath: String): HttpRequest.Builder =
    HttpRequest
      .newBuilder(URI.create(s"$host:$port/$uriPath"))
      .header("Content-Type", "application/json")
}
