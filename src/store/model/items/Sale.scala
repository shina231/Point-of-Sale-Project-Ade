package store.model.items

  class Sale(percent:Double) extends Modifier(){
    override def updatePrice(myDub:Double): Double = {
      val num:Double= (1 - (percent / 100))
      myDub*num
    }
      override def computeTax(PostSale: Double): Double = {
        0.0
      }
}
