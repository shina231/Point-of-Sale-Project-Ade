package store.model.checkout
import store.model.items.Item


class thirdState (myCheck: SelfCheckout) extends State(myCheck){


  override def displayString(): String ={
    this.myCheck.displayStr = myCheck.cashString
    this.myCheck.displayStr
  }
  override def enterPressed(): Unit ={
  }

  override def numberPressed(number: Int): Unit ={
  }
 // override def displayString(): Unit = {
 //   myCheck.displayStr = myCheck.cashString
 //   myCheck.displayStr
 // }


  override def clearPressed(): Unit ={
  }

  override def checkoutPressed(): Unit ={
    myCheck.displayStr = myCheck.cashString
    myCheck.displayStr

  }

  override def cashPressed(): Unit ={
    myCheck.mycart = myCheck.emptyCart
    myCheck.displayStr = ""
    myCheck.state = new On(myCheck)

  }

  override def creditPressed(): Unit ={
    myCheck.mycart = myCheck.emptyCart
    myCheck.displayStr = ""
    myCheck.state = new On(myCheck)
  }

  override def itemsInCart(): List[Item] = {
    this.myCheck.mycart
  }

  /*
  override def subtotal(): Unit = {

  }

  override def tax(): Unit = {}


  override def total(): Unit = {

  }
*/
}
