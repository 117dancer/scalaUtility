package com.redislabs.provider.redis
//import com.redislabs.provider.redis._

import org.apache.spark.{SparkConf,SparkContext}

object Test {

  def main(args: Array[String]): Unit={
    val path1=args(0)
    val scNew = new SparkContext(new SparkConf()
      // initial redis host - can be any node in cluster mode
      .set("redis.host", "172.16.3.208")
      // initial redis port
      .set("redis.port", "6379")
      // optional redis AUTH password
      //.set("redis.auth", "")
      .set("spark.driver.allowMultipleContexts","true")
    )

    val keysRDD = scNew.fromRedisKeyPattern("foo*", 5)
    keysRDD.saveAsTextFile(path1)

  }

}
