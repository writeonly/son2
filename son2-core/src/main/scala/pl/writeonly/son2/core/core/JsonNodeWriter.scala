package pl.writeonly.son2.core.core

import com.fasterxml.jackson.databind.{JsonNode, ObjectMapper}

class JsonNodeWriter(val mapper: ObjectMapper, val pretty: Boolean = true) {
  def writeValueAsString(value: JsonNode) = if (pretty) {
    mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)
  } else {
    mapper.writeValueAsString(value)
  }
}