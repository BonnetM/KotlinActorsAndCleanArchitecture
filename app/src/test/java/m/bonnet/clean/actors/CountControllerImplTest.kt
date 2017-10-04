package m.bonnet.clean.actors

import kotlinx.coroutines.experimental.Unconfined
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CountControllerImplTest {

    @Mock private lateinit var interactor: CountInteractor
    private lateinit var controller: CountControllerImpl

    @Before
    fun setUp() {
        controller = CountControllerImpl(interactor, Unconfined)
    }

    @Test
    fun testPlusAction() {
        // When
        controller.handle(PlusAction())

        // Then
        Mockito.verify(interactor).plusOne()
    }

    @Test
    fun testMinusAction() {
        // When
        controller.handle(MinusAction())

        // Then
        Mockito.verify(interactor).minusOne()
    }
}