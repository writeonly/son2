package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.glue.CreatorConverterOr

class CreatorConverterOrPath extends CreatorConverterOr(new ChainNotationConfigPath().get, new ChainNotationRWTPath())