package com.github.duartesaraiva1998.open4s.api

import com.github.duartesaraiva98.open4s.api.CloseIndexApi

import java.net.http.HttpRequest
import java.net.http.HttpRequest.BodyPublishers

class CloseIndexApiSpec extends ApiSpec {
  trait Scope {
    val closeIndex: CloseIndexApi = CloseIndexApi("test_index")
  }

  "CloseIndexApi" should {
    "build request" in new Scope {
      val expectedRequest: HttpRequest = baseRequestBuilder("test_index/_close")
        .POST(BodyPublishers.noBody())
        .build()

      closeIndex.httpRequest(host, port) shouldBe expectedRequest
    }
  }
}
