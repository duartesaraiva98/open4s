package com.github.duartesaraiva1998.open4s.api

import com.github.duartesaraiva98.open4s.api.DeleteIndexApi

import java.net.http.HttpRequest

class DeleteIndexApiSpec extends ApiSpec {

  trait Scope {
    val deleteIndexApi: DeleteIndexApi = DeleteIndexApi("test_index")
  }

  "DeleteIndexApi" should {
    "build request" in new Scope {
      val expectedRequest: HttpRequest = baseRequestBuilder("test_index")
        .DELETE()
        .build()

      deleteIndexApi.httpRequest(host, port) shouldBe expectedRequest
    }
  }
}
