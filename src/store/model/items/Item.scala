package store.model.items

class Item(var itemdesc: String , var basePrice:Double) {

  var myMod:List[Modifier] = List()

  def description(): String = {
    this.itemdesc
  }

  def price(): Double = {
    var myCost:Double = basePrice
    for (mods <- myMod){
     myCost =  mods.updatePrice(myCost)
    }
    myCost
  }

  def setBasePrice(num: Double): Unit = {
    this.basePrice = num
  }

  def addModifier(newMod:Modifier): Unit ={
    myMod :+= newMod
  }
  def tax(): Double ={
    var Accu: Double = 0.0
    for (mods <- myMod){
      Accu += mods.computeTax(price())
    }
    Accu
  }
}





