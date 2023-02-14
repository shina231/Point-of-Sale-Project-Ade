package store.model.items

class SalesTax(mySale: Double) extends Modifier() {
  override def updatePrice(myDub: Double): Double = {
    myDub
  }

  override def computeTax(InputP: Double): Double = {
    var cut = InputP * 0.01
    var toAdd = mySale*cut
    toAdd
  }
}
