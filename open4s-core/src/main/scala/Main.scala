import com.github.duartesaraiva98.open4s.mappings.IndexMappings
import com.github.duartesaraiva98.open4s.settings.IndexSettings
import com.github.duartesaraiva98.open4s.{IndexAliases, OpenSearchClient}

import java.net.http.HttpClient

object Main extends App {
  val host = "http://localhost"
  val port = 9200

  val client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()

  val openSearchClient = new OpenSearchClient(client, host, port)

  println("Create")
  openSearchClient.createIndex(
    indexName = "test_index",
    indexSettings = IndexSettings(),
    indexMappings = IndexMappings(
      Seq()
    ),
    indexAliases = IndexAliases(Nil)
  )
  println("Close")
  openSearchClient.closeIndex("test_index")
  println("Open")
  openSearchClient.openIndex("test_index")
  println("Delete")
  openSearchClient.deleteIndex("test_index")
}