package dpla.data_source

import org.apache.spark.sql.types._

object Schema {

  val edmAgentType = StructType(Seq(
    StructField("uri", StringType, true),
    StructField("name", StringType, true),
    StructField("providedLabel", StringType, true),
    StructField("note", StringType, true),
    StructField("scheme", StringType, true),
    StructField("exactMatch", ArrayType(StringType, false), false),
    StructField("closeMatch", ArrayType(StringType, false), false)
  ))

  val edmTimeSpanType = StructType(Seq(
    StructField("originalSourceDate", StringType, true),
    StructField("prefLabel", StringType, true),
    StructField("begin", StringType, true),
    StructField("end", StringType, true)
  ))

  val skosConceptType = StructType(Seq(
    StructField("concept", StringType, true),
    StructField("providedLabel", StringType, true),
    StructField("note", StringType, true),
    StructField("scheme", StringType, true),
    StructField("exactMatch", ArrayType(StringType, false), false),
    StructField("closeMatch", ArrayType(StringType, false), false)
  ))

  val dplaPlaceType = StructType(Seq(
    StructField("name", StringType, true),
    StructField("city", StringType, true),
    StructField("county", StringType, true),
    StructField("region", StringType, true),
    StructField("state", StringType, true),
    StructField("country", StringType, true),
    StructField("coordinates", StringType, true)
  ))

  val literalOrUriType = StructType(Seq(
    StructField("value", StringType, false),
    StructField("isUri", BooleanType, false)
  ))

  val collectionType = StructType(Seq(
    StructField("title", StringType, true),
    StructField("description", StringType, true)
  ))

  val edmWebResourceType = StructType(Seq(
    StructField("uri", StringType, false),
    StructField("fileFormat", ArrayType(StringType, false), false),
    StructField("dcRights", ArrayType(StringType, false), false),
    StructField("edmRights", StringType, true)
  ))

  val sourceResourceType = StructType(Seq(
    StructField("alternateTitle", ArrayType(StringType, false), false),
    StructField("collection", ArrayType(collectionType), false),
    StructField("contributor", ArrayType(edmAgentType), false),
    StructField("creator", ArrayType(edmAgentType), false),
    StructField("date", ArrayType(edmTimeSpanType), false),
    StructField("description", ArrayType(StringType, false), false),
    StructField("extent", ArrayType(StringType, false), false),
    StructField("format", ArrayType(StringType, false), false),
    StructField("genre", ArrayType(skosConceptType, false), false),
    StructField("identifier", ArrayType(StringType, false), false),
    StructField("language", ArrayType(skosConceptType, false), false),
    StructField("place", ArrayType(dplaPlaceType, false), false),
    StructField("publisher", ArrayType(edmAgentType, false), false),
    StructField("relation", ArrayType(literalOrUriType, false), false),
    StructField("replacedBy", ArrayType(StringType, false), false),
    StructField("replaces", ArrayType(StringType, false), false),
    StructField("rights", ArrayType(StringType, false), false),
    StructField("rightsHolder", ArrayType(edmAgentType, false), false),
    StructField("subject", ArrayType(skosConceptType, false), false),
    StructField("temporal", ArrayType(edmTimeSpanType, false), false),
    StructField("title", ArrayType(StringType, false), false),
    StructField("type", ArrayType(StringType, false), false)))

  val schema: StructType = StructType(Seq(
    StructField("dplaUri", StringType, false),
    StructField("SourceResource", sourceResourceType, false),
    StructField("dataProvider", edmAgentType, false),
    StructField("originalRecord", StringType, false),
    StructField("hasView", ArrayType(edmWebResourceType, false), false),
    StructField("intermediateProvider", edmAgentType, true),
    StructField("isShownAt", edmWebResourceType, false),
    StructField("object", edmWebResourceType, true),
    StructField("preview", edmWebResourceType, true),
    StructField("provider", edmAgentType, false),
    StructField("edmRights", StringType, true),
    StructField("sidecar", StringType, true)
  ))


}
