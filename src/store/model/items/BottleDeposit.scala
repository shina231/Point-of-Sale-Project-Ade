package store.model.items

class BottleDeposit(deposit: Double) extends Modifier() {
  override def updatePrice(InP: Double): Double = {
    InP
  }

  override def computeTax(myTax: Double): Double = {
    deposit
  }
}


