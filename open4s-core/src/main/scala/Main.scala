import com.github.duartesaraiva98.open4s.api.CreateApi
import com.github.duartesaraiva98.open4s.settings.IndexSettings
import com.github.duartesaraiva98.open4s.{IndexAliases, IndexMappings}

import java.net.http.{HttpClient, HttpResponse}
import javax.net.ssl.SSLContext

object Main extends App {
  val host = "http://localhost"
  val port = 9200

  val client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()

  val request = CreateApi(
    indexName = "test_index",
    indexSettings = IndexSettings(),
    indexMappings = IndexMappings(
      Seq()
    ),
    indexAliases = IndexAliases(Nil)
  ).httpRequest(host, port)

  val httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString)

  println(httpResponse.body())
}