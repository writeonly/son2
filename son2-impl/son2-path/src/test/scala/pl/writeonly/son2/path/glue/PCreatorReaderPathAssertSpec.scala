package pl.writeonly.son2.path.glue

import pl.writeonly.son2.apis.config.RConfig
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}
import pl.writeonly.son2.path.creators.PCreatorReaderPath
import pl.writeonly.son2.path.notation._
import pl.writeonly.son2.path.notations.CreatorNotationTapestry
import pl.writeonly.scalaops.specs.WhiteAssertSpec

class PCreatorReaderPathAssertSpec extends WhiteAssertSpec {
  //  val pCreator = new PCreatorReaderPath(NotationCaseSmart())
  val pCreator = new PCreatorReaderPath(CreatorNotationTapestry())

  "A pCreator" when {
    val config = RConfig(provider = ProvidersPath.TAPESTRY)
    "is isDefinedAt with 'tapestry in config" should {
      "return true" in {
        assertResult(true) {
          pCreator.isDefinedAt(config)
        }
      }
    }
    "is apply with 'tapestry in config" should {
      "reader has class NotationReaderPath" in {
        assertResult(classOf[NotationReaderPath]) {
          val reader = pCreator.apply(config)
          reader.getClass
          //DefaultsSmart
        }
      }
      "defaults has class DefaultsTapesty" in {
        assertResult(classOf[DefaultsPath]) {
          val reader = pCreator.apply(config)
          val readerPath = reader.asInstanceOf[NotationReaderPath]
          val defaults = readerPath.defaults
          defaults.getClass
        }
      }
    }
  }

}
