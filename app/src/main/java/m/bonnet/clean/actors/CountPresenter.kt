package m.bonnet.clean.actors

interface CountPresenter {
    fun presentCount(count: Int)
}

class CountPresenterImpl(private val countDisplay: CountDisplay) : CountPresenter {
    override fun presentCount(count: Int) {
        countDisplay.displayCount(count)
    }
}