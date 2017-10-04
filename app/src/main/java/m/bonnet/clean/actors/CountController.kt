package m.bonnet.clean.actors

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.channels.actor
import kotlin.coroutines.experimental.CoroutineContext

sealed class CountAction
class PlusAction : CountAction()
class MinusAction : CountAction()

interface CountController {
    fun handle(countAction: CountAction): Boolean
}

class CountControllerImpl(private val interactor: CountInteractor, coroutineContext: CoroutineContext = CommonPool) : CountController {

    private val actor = actor<CountAction>(coroutineContext) {
        for (event in channel) {
            when (event) {
                is PlusAction -> interactor.plusOne()
                is MinusAction -> interactor.minusOne()
            }
        }
    }

    override fun handle(countAction: CountAction): Boolean {
        return actor.offer(countAction)
    }
}