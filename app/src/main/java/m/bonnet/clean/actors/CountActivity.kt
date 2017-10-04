package m.bonnet.clean.actors

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_count.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

interface CountDisplay {
    fun displayCount(count: Int)
}

class CountActivity : AppCompatActivity(), CountDisplay {

    private lateinit var countController: CountController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count)
        countController = CountControllerImpl(CountInteractorImpl(CountPresenterImpl(this)))
        plusOneButton.setOnClickListener { countController.handle(PlusAction()) }
        minusOneButton.setOnClickListener { countController.handle(MinusAction()) }
    }

    override fun displayCount(count: Int) {
        launch(UI) {
            numberValue.text = count.toString()
        }
    }
}
