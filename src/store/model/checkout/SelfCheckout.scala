package store.model.checkout

import store.model.items.Item


class SelfCheckout {
  var cashString: String = "cash or credit"
  var lilItem :Item = null
  var state: State = new On(this)
  var rescan: State = new rescanState(this)
  var state3:State = new thirdState(this)
  // var state4:State = new State4(this)
  var myStoreInv : Map[String,Item] = Map()
  var errorInput : Item = new Item("error",0.0)
  var displayStr: String = ""
  var emptyStr:String  = ""
  var mycart: List[Item] = List()
  var emptyCart: List[Item] = List()


  def addItemToStore(barcode: String, item: Item): Unit = {
    myStoreInv += (barcode -> item)
  }


  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def enterPressed(): Unit = {
    this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.creditPressed()

  }

  def loyaltyCardPressed(): Unit = {
    // TODO
  }

  def displayString(): String = {
    this.state.displayString()
 }

  def itemsInCart(): List[Item] = {
    this.state.itemsInCart()
  }

  def subtotal(): Double = {
    var myAcc:Double = 0.0
    for (i <- mycart){
      myAcc += i.price()
    }
    myAcc
  }

  def tax(): Double = {
    var myAcc: Double = 0.0
    for (i <- mycart) {
      myAcc += i.tax
    }
    myAcc
  }

  def total(): Double = {
    this.subtotal() + this.tax()
  }

  def prepareStore(): Unit = {
    var Grapes: Item = new Item("Welchs", 10.0)
    addItemToStore("35", Grapes)

    // Similar to openMap in the Pale Blue Dot assignment, this method is not required and is
    // meant to help you run manual tests.
    //
    // This method is called by the GUI during setup. Use this method to prepare your
    // items and call addItemToStore to add their barcodes. Also add any sales/tax/etc to your
    // items.
    //
    // This method will not be called during testing and you should not call it in your tests.
    // Each test must setup its own items to ensure compatibility in AutoLab. However, you can
    // write a similar method in your Test Suite classes.

    // Example usage:
    //   val testItem: Item = new Item("test item", 100.0)
    //    this.addItemToStore("472", testItem)


  }
}
