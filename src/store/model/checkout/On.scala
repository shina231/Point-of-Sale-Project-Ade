package store.model.checkout

import store.model.items.Item

class On(myCheck: SelfCheckout) extends State(myCheck) {



  override def enterPressed(): Unit = {
    var gummi: Item = myCheck.myStoreInv.getOrElse(myCheck.displayStr, myCheck.errorInput)
    myCheck.mycart :+= gummi
    myCheck.lilItem = gummi
    clearPressed()
    myCheck.state = new newState(myCheck)
  }

  override def numberPressed(number: Int): Unit = {
    myCheck.displayStr += number.toString
  }

  //override def clearPressed(): Unit = {
  //  myCheck.displayStr = ""
 // }
  override def itemsInCart():List[Item]= {
    this.myCheck.mycart
 }

  override def displayString(): String ={
    this.myCheck.displayStr
  }
  override def cashPressed(): Unit = {}

  override def creditPressed(): Unit ={
  }

  override def checkoutPressed(): Unit = {
  //  myCheck.displayStr += myCheck.cashString
   // myCheck.state = new thirdState(myCheck)
  }
  }
