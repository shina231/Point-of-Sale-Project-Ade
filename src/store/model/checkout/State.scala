package store.model.checkout
import store.model.items._

  abstract class State(myCheck: SelfCheckout) {
    def enterPressed():Unit
    def numberPressed(number:Int):Unit
    def clearPressed():Unit={
      this.myCheck.displayStr = ""
    }

    def checkoutPressed():Unit
    def cashPressed():Unit
    def itemsInCart():List[Item]
    def displayString():String
    def creditPressed():Unit
  }

