package store.model.checkout
import store.model.items.Item

class rescanState(myCheck:SelfCheckout) extends State(myCheck){

  override def enterPressed(): Unit = {

    var gummi: Item = myCheck.myStoreInv.getOrElse(myCheck.displayStr, myCheck.errorInput)
    myCheck.displayStr = ""
    myCheck.mycart = myCheck.mycart :+ gummi
    myCheck.state = new On(myCheck)
    clearPressed()
  }

  override def displayString(): String = {
    this.myCheck.displayStr
  }

  override def itemsInCart(): List[Item] = {
    this.myCheck.mycart
  }

  override def numberPressed(number: Int): Unit = {
    myCheck.displayStr += number
    myCheck.state = new On(myCheck)
  }

  override def clearPressed(): Unit = {
    myCheck.displayStr = ""
    myCheck.state = new On(myCheck)
  }

  override def cashPressed(): Unit = {
  }

  override def creditPressed(): Unit = {
  }

  override def checkoutPressed(): Unit = {
    myCheck.displayStr += myCheck.cashString
    myCheck.state = new thirdState(myCheck)
  }

}
