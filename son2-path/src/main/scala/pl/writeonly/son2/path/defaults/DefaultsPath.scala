package pl.writeonly.son2.path.defaults

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.spi.json._
import com.jayway.jsonpath.spi.mapper._
import net.minidev.json.JSONValue
import net.minidev.json.parser.JSONParser
import net.minidev.json.writer.JsonReaderI
import pl.writeonly.son2.core.config.RConfig

import scala.collection.JavaConverters._

class DefaultsPath(c:RConfig, json : JsonProvider, mapping : MappingProvider) extends Defaults {
  override def jsonProvider = json

  override def mappingProvider = mapping

  override def options : java.util.Set[com.jayway.jsonpath.Option] = new java.util.HashSet(optionCollection)

  private def optionCollection = c.options
    .map(toOption)
    .asJavaCollection

  private def toOption(name:String): com.jayway.jsonpath.Option = com.jayway.jsonpath.Option.valueOf(name)

}
