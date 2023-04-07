package com.github.duartesaraiva1998.open4s.api

import com.github.duartesaraiva98.open4s.{IndexAliases, IndexMappings}
import com.github.duartesaraiva98.open4s.api.CreateApi
import com.github.duartesaraiva98.open4s.settings.IndexSettings
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class CreateApiSpec extends AnyWordSpec with Matchers {


  trait Scope {
    val createApi: CreateApi = CreateApi(
      indexName = "test_index",
      indexSettings = IndexSettings(),
      indexMappings = IndexMappings(
        Seq(
          IndexMappings.Type.Boolean("some_boolean"),
          IndexMappings.Type.Object("some_object",
            IndexMappings(
              Seq(
                IndexMappings.Type.Boolean("some_boolean_2")
              )
            )
          ),
          IndexMappings.Type.Binary("some_binary"),
          IndexMappings.Type.Ip("some_ip"),
          IndexMappings.Type.Date("some_date"),
          IndexMappings.Type.Range.IntegerRange("some_integer_range"),
          IndexMappings.Type.Range.LongRange("some_long_range"),
          IndexMappings.Type.Range.DoubleRange("some_double_range"),
          IndexMappings.Type.Range.FloatRange("some_float_range"),
          IndexMappings.Type.Range.IpRange("some_ip_range"),
          IndexMappings.Type.Range.DateRange("some_date_range"),
          IndexMappings.Type.Numeric.Byte("some_byte"),
          IndexMappings.Type.Numeric.Double("some_double"),
          IndexMappings.Type.Numeric.HalfFloat("some_half_float"),
          IndexMappings.Type.Numeric.Float("some_float"),
          IndexMappings.Type.Numeric.Integer("some_integer"),
          IndexMappings.Type.Numeric.Long("some_long"),
          IndexMappings.Type.Numeric.Short("some_short"),
          IndexMappings.Type.Numeric.ScaledFloat("some_scaled_float", 2),
          IndexMappings.Type.String.Text("some_text"),
          IndexMappings.Type.String.Keyword("some_keyword"),
          IndexMappings.Type.String.TokenCount("some_token_count")
        )
      ),
      indexAliases = IndexAliases(Seq("sample-alias1"))
    )
  }

  "CreateApi" should {
    "create body" in new Scope {
      val jsonWithoutSpacesOrNewLines: String =
        Source.fromResource("request_bodies/create-index.json").mkString.replace(" ", "").replace("\n", "")
      createApi.body shouldBe jsonWithoutSpacesOrNewLines
    }
  }

}
