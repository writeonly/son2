package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.apis.chain.PCreatorReaderSymbol
import pl.writeonly.son2.jack.core.Jack
import pl.writeonly.son2.jack.notation.NotationReaderJack

class PCreatorReaderJack(jack: Jack)
    extends PCreatorReaderSymbol(
      jack.meta.format,
      _ => new NotationReaderJack(jack)
    )
