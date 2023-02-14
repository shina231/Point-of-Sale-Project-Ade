package store.model.checkout

import store.model.items.Item

class newState(myCheck: SelfCheckout) extends State(myCheck) {


    override def enterPressed(): Unit = {
      myCheck.mycart= myCheck.mycart :+ myCheck.lilItem
    }
  override def displayString(): String = {
     this.myCheck.displayStr
   }

  override def itemsInCart(): List[Item] = {
    this.myCheck.mycart
  }

  override def numberPressed(number:Int): Unit = {
        myCheck.displayStr += number.toString
       myCheck.state = new On(myCheck)

  }
  //  override def clearPressed(): Unit ={
  //    myCheck.displayStr = ""
 //     myCheck.state = new On(myCheck)
  //  }
    override def cashPressed(): Unit ={
      //myCheck.mycart = List()
     // myCheck.displayStr = ""
     // displayString()
     // myCheck.state = new thirdState(myCheck)
    }
    override def creditPressed(): Unit ={
     // myCheck.mycart = List()
     // myCheck.displayStr = ""
     // displayString()
     // myCheck.state = new thirdState(myCheck)
    }
  override def checkoutPressed(): Unit = {
   // myCheck.displayStr = ""
    //myCheck.displayStr += myCheck.cashString
    //displayString()
    myCheck.state = new thirdState(myCheck)
  }

  /*
  override def subtotal(): Unit = {
    var myAcc: Double = 0.0
    for (i <- myCheck.mycart) {
      myAcc += i.price()
    }
    myAcc
  }

  override def tax(): Unit = {
    myCheck.state = new On(myCheck)

  }

  override def total(): Unit = {
    myCheck.state = new On(myCheck)
  }
*/
}
