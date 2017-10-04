package m.bonnet.clean.actors

interface CountInteractor {
    fun plusOne()
    fun minusOne()
}

class CountInteractorImpl(private val countPresenter: CountPresenter) : CountInteractor {
    private var count = 0
    override fun plusOne() {
        countPresenter.presentCount(++count)
    }

    override fun minusOne() {
        countPresenter.presentCount(--count)
    }
}