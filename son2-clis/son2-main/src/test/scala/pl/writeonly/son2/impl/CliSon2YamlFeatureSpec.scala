package pl.writeonly.son2.impl

import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.scalaops.specs.BlackSpec

import scala.sys.process._

class CliSon2YamlFeatureSpec extends BlackSpec {

  val SON2ML = Features.SON2 + " y"

  val outName = (name: String) =>
    Features.outputPathname(Types.CLI, name, FormatsJack.YAML)

  feature(classOf[CliSon2YamlFeatureSpec].getSimpleName) {

    scenario("Apply one exclamation") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val file = SON2ML + " " + in + " " + outName("one")
      When("should produce null when consume null")
      val result = file.!
      Then("0 == result")
      assert(0 == result)
    }

    scenario("Apply two exclamation") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val file = SON2ML + " " + in + " " + outName("two")
      When("should produce null when consume null")
      val result = file.!!
      Then("'' == result")
      assert("" == result)
    }
  }
}
