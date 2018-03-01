package pl.writeonly.son2.path.glue

import org.skyscreamer.jsonassert.JSONAssert
import pl.writeonly.son2.core.config._
import pl.writeonly.son2.core.converters.Converter2
import pl.writeonly.son2.core.glue.Piper
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.WhiteAssertSpec

class CreatorConverterPathAssertSpec extends WhiteAssertSpec {

  val expectedStr = "{}"
  val provider = ProvidersPath.TAPESTRY
  val providerName = provider.name
  val configer = new ChainNotationConfigPath().get
  val chain = new ChainNotationRWTPath
  val reader = chain.r
  val writer = chain.w
  "A configer" when {
    "providerName is 'tapestry" should {
      "return true" in {
        assertResult(true) {
          configer.isDefinedAt(providerName)
        }
      }
      "return 'tapestry" in {
        assertResult(provider) {
          configer.apply(providerName).read.provider
        }
      }
    }
  }
  "A CreatorConverterPath " when {
    "in config provider is 'tapestry, query is $..*, stream is false and pretty is true" should {
      val config =
        Config(RConfig('tapestry, 'object, false, RPath("$..*"), Set()),
               WConfig('tapestry, 'yaml, true, true, Set()),
               TConfig())
      val converter = CreatorConverterPath(config)
      "return [] for {} by streamer" in {
        val streamer = new Piper(null, converter).print(false)
        val json = streamer.convertString(native = false, expectedStr)
        JSONAssert.assertEquals("[]", json, true)
      }
      "return [] for {}" in {
        val json = converter.convert(expectedStr)
        JSONAssert.assertEquals("[]", json, true)
      }
      "return 'tapestry from config read provider" in {
        assertResult(provider) {
          converter.config.read.provider
        }
      }
      "return 'tapestry from config write provider" in {
        assertResult(provider) {
          converter.config.write.provider
        }
      }
      val converter2 = converter.asInstanceOf[Converter2]
      //      "return 'tapestry from config read provider" in {
      //        assertResult(provider) {
      //          converter2.in
      //        }
      //      }
      //      "return 'tapestry from config write provider" in {
      //        assertResult(provider) {
      //          converter.config.write.provider
      //        }
      //      }
    }

    "provider is 'tapestry" should {
      val a = CreatorConverterPath.apply(provider)
      "read.provider is 'tapestry" in {
        assertResult(provider) {
          a.config.read.provider
        }
      }
      "write.provider is 'tapestry" in {
        assertResult(provider) {
          a.config.write.provider
        }
      }
    }
    "in config provider is 'tapestry" should {
      val config = Config(read =
                            RConfig(provider = provider, path = RPath.parse),
                          write = WConfig(provider = provider))
      val a = CreatorConverterPath.apply(config)
      "read.provider is 'tapestry" in {
        assertResult(provider) {
          a.config.read.provider
        }
      }
      "write.provider is 'tapestry" in {
        assertResult(provider) {
          a.config.write.provider
        }
      }
    }
    "in config provider is 'tapestry ans query is null" should {
      val config =
        Config(read = RConfig(provider = provider, path = RPath.parse),
               write = WConfig(provider = provider))
      val converter = CreatorConverterPath.apply(config)
      "read.provider is 'tapestry" in {
        assertResult(provider) {
          converter.config.read.provider
        }
      }
      "write.provider is 'tapestry" in {
        assertResult(provider) {
          converter.config.write.provider
        }
      }
    }
    "in config provider is 'tapestry and query is $..*" should {
      val config = Config(read =
                            RConfig(provider = provider, path = RPath("$..*")),
                          write = WConfig(provider = provider))
      val a = CreatorConverterPath.apply(config)
      "read.provider is 'tapestry" in {
        assertResult(provider) {
          a.config.read.provider
        }
      }
      "write.provider is 'tapestry" in {
        assertResult(provider) {
          a.config.write.provider
        }
      }
    }
  }
}