package com.github.duartesaraiva98.open4s.settings

import com.github.duartesaraiva98.open4s.CodecConfig
import io.circe.Encoder
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder

object IndexSettings extends CodecConfig {

  implicit val encoder: Encoder[IndexSettings] = deriveConfiguredEncoder

}

case class IndexSettings(
    numberOfShards: Int = 1,
    numberOfRoutingShards: Option[Int] = None,
    shard: Shard = Shard.default,
    codec: Codec = Codec.Default,
    routingPartitionSize: Int = 1,
    softDeletes: SoftDeletes = SoftDeletes.default,
    loadFixedBitsetFiltersEagerly: Boolean = true,
    hidden: Boolean = false,
    numberOfReplicas: Int = 1,
    autoExpandReplicas: Option[AutoExpandReplicas] = None,
    search: Search = Search.default,
    refreshInterval: RefreshInterval = RefreshInterval.default,
    maxResultWindow: Int = 10000,
    maxInnerResultWindow: Int = 100,
    maxRescoreWindow: Int = 10000,
    maxDocvalueFieldsSearch: Int = 100,
    maxScriptFields: Int = 32,
    maxNgramDiff: Int = 1,
    maxShingleDiff: Int = 3,
    maxRefreshListeners: Option[Int] = None,
    highlight: Highlight = Highlight.default,
    maxTermsCount: Int = 65536,
    maxRegexLength: Int = 1000,
    query: Option[Query] = None,
    routing: Routing = Routing(Allocation.apply, Rebalance.apply),
    gcDeletes: Period = Period.sixtySeconds
)
