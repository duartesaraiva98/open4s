package com.github.duartesaraiva1998.open4s.api

import com.github.duartesaraiva98.open4s.api.OpenIndexApi

import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers

class OpenIndexApiSpec extends ApiSpec {

  trait Scope {
    val openIndexApi: OpenIndexApi = OpenIndexApi("test_index")
  }

  "OpenIndexApi" should {
    "build request" in new Scope {
      val expectedRequest: HttpRequest = baseRequestBuilder("test_index/_open")
        .POST(BodyPublishers.noBody())
        .build()

      openIndexApi.httpRequest(host, port) shouldBe expectedRequest
    }
  }

}
