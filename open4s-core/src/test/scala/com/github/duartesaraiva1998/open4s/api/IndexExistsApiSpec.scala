package com.github.duartesaraiva1998.open4s.api

import com.github.duartesaraiva98.open4s.api.IndexExistsApi
import java.net.http.HttpRequest

class IndexExistsApiSpec extends ApiSpec {

  trait Scope {
    val indexExistsApi: IndexExistsApi = IndexExistsApi("test_index")
  }

  "IndexExists" should {
    "build request" in new Scope {
      val expectedRequest: HttpRequest = baseRequestBuilder("test_index")
        .HEAD()
        .build()

      indexExistsApi.httpRequest(host, port) shouldBe expectedRequest
    }
  }
}
