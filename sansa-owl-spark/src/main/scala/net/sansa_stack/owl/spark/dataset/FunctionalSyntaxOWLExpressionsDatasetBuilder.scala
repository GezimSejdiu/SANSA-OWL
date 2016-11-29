package net.sansa_stack.owl.spark.dataset

import net.sansa_stack.owl.spark.rdd.FunctionalSyntaxOWLExpressionsRDDBuilder
import org.apache.spark.sql.SparkSession


object FunctionalSyntaxOWLExpressionsDatasetBuilder {
  def build(spark: SparkSession, filePath: String): OWLExpressionsDataset = {
    val rdd = FunctionalSyntaxOWLExpressionsRDDBuilder.build(spark.sparkContext, filePath)
    import spark.implicits._
    spark.sqlContext.createDataset[String](rdd)
  }
}
