package store.model.items

  abstract class Modifier() {
    def updatePrice(myDub: Double): Double

    def computeTax(myTax: Double): Double
}
