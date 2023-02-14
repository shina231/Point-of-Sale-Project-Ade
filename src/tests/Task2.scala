package tests

import org.scalatest.FunSuite
import store.model.items._
import store.model.checkout.SelfCheckout

class Task2 extends FunSuite {
  var epsilon:Double = 0.001

 test("coumpounding sales"){
// add 2 sales onto one and add a edge case
var testSelfCheckout: SelfCheckout = new SelfCheckout()
   var Welch: Item = new Item("Grapes", 20.0)
   var Sale1: Sale = new Sale(25)
   var Sale2: Sale = new Sale(25)

   testSelfCheckout.addItemToStore("24", Welch)

   testSelfCheckout.numberPressed(2)
   testSelfCheckout.numberPressed(4)
   testSelfCheckout.enterPressed()

   Welch.addModifier(Sale1)
   Welch.addModifier(Sale2)

   assert(Math.abs(Welch.price()-11.25)<epsilon)
 }

  test("items no modifiers"){
    var testSelfy: SelfCheckout = new SelfCheckout()
    var JambaJuice: Item = new Item("Smoothie",21.0)
    testSelfy.addItemToStore("05",JambaJuice)

    testSelfy.numberPressed(0)
    testSelfy.numberPressed(5)
    testSelfy.enterPressed()

    assert(Math.abs(JambaJuice.price()-21.0)<epsilon)
    assert(Math.abs(JambaJuice.tax()- 0.0)<epsilon)
    assert(JambaJuice.description() == "Smoothie")

  }

  test("only one modifier allowed"){
    var testSelfy: SelfCheckout = new SelfCheckout()
    var JambaJuice: Item = new Item("Smoothie", 20.0)
    var Salee: Sale = new Sale(51)

    testSelfy.addItemToStore("05", JambaJuice)

    testSelfy.numberPressed(0)
    testSelfy.numberPressed(5)
    testSelfy.enterPressed()
    JambaJuice.addModifier(Salee)
    assert(Math.abs(JambaJuice.price() - 9.8) < epsilon)
  }

  test("sales skimp by one percent"){
    // add a sale like 51% or random #
  }
  test("extra penny bottle deposit"){
    var myBottle: BottleDeposit = new BottleDeposit(30)
    var Accu: Double = 30.8
    assert(Math.abs(myBottle.updatePrice(30.8) - Accu) < epsilon)


    var myBottle1: BottleDeposit = new BottleDeposit(10.5)
    var Accu2: Double = 10.5
    assert(Math.abs(myBottle1.computeTax(10.5) - Accu2) < epsilon)
  }


  test("Test salejutsu") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Snapple: Item = new Item("Peach", 6.0)
    var Welch: Item = new Item("Grapes", 10.0)

    testSelfCheckout.addItemToStore("24", Welch)
    testSelfCheckout.addItemToStore("98", Snapple)

    testSelfCheckout.numberPressed(9)
    testSelfCheckout.numberPressed(8)
    testSelfCheckout.enterPressed()

    var changeMod: Modifier = new Sale(50)
    Snapple.addModifier(changeMod)
    assert(Math.abs(Snapple.price() - 3) < epsilon)

    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()

    var newMod: Modifier = new Sale(50)
    Welch.addModifier(newMod)
    assert(Math.abs(Welch.price()- 5)< epsilon)
  }

test ( "test salesTax"){
  var testSelfCheckout: SelfCheckout = new SelfCheckout()
  var CheezIt: Item = new Item("Peach", 20.0)
  var Fridge: Item = new Item("Grapes", 100.0)
  var cart:List[Item] = testSelfCheckout.itemsInCart()
  var SalesUno: Modifier = new Sale(10)
  var SalesDos: Modifier = new Sale(10)


  testSelfCheckout.addItemToStore("645", Fridge)
  testSelfCheckout.addItemToStore("98", CheezIt)

  testSelfCheckout.numberPressed(6)
  testSelfCheckout.numberPressed(4)
  testSelfCheckout.numberPressed(5)

  testSelfCheckout.enterPressed()

  Fridge.addModifier(SalesUno)
  Fridge.addModifier(SalesDos)

  var P1 = testSelfCheckout.subtotal()
  assert(Math.abs(P1 - 81.0)<epsilon)
}

  test("subtotal test") {
    var testSelfCheck: SelfCheckout = new SelfCheckout()
    var Apple: Item = new Item("Sweet", 20.0)
    var Orange: Item = new Item("Juicy", 25.0)
    testSelfCheck.addItemToStore("10", Apple)
    testSelfCheck.addItemToStore("15", Orange)
    var SalesUno: Modifier = new Sale(10)
    var SalesDos: Modifier = new Sale(10)

    testSelfCheck.numberPressed(1)
    testSelfCheck.numberPressed(0)
    testSelfCheck.enterPressed()

    testSelfCheck.numberPressed(1)
    testSelfCheck.numberPressed(5)
    testSelfCheck.enterPressed()

    var myTotal = testSelfCheck.subtotal()
    assert(Math.abs(myTotal - 45.0) < epsilon)
  }

  test("total test"){
    var testSelfCheck: SelfCheckout = new SelfCheckout()
    var Apple: Item = new Item ("Sweet",20.0)
    var Orange: Item = new Item ("Juicy",25.0)
    var Saless: Sale = new Sale (50)

    testSelfCheck.addItemToStore("10", Apple)
    testSelfCheck.addItemToStore("15", Orange)

    testSelfCheck.numberPressed(1)
    testSelfCheck.numberPressed(0)
    testSelfCheck.enterPressed()

    testSelfCheck.numberPressed(1)
    testSelfCheck.numberPressed(5)
    testSelfCheck.enterPressed()
    Apple.addModifier(Saless)

    var myTotal = testSelfCheck.total()
    assert(Math.abs(myTotal - 35.0)<epsilon)
  }

  test ("Test computeTax"){
    var myPrice:Double = 0.0
    var newSale: Sale = new Sale(50)
    var SalesTaxi: SalesTax = new SalesTax(50)

    assert(Math.abs(newSale.computeTax(0.0) - myPrice)<epsilon)
    assert(Math.abs(newSale.updatePrice(60.0) - 30.0)< epsilon)


    var theTax:Double = 8.0
    assert(Math.abs(SalesTaxi.updatePrice(8.0) - theTax)< epsilon)
    assert(Math.abs(SalesTaxi.computeTax(100.0) - 50.0)< epsilon)

  }

  test("tax"){
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Fudge: Item = new Item("Grapes", 15.0)
    var Sales: Sale = new Sale(50)
    testSelfCheckout.addItemToStore("645", Fudge)

    testSelfCheckout.numberPressed(6)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.numberPressed(5)

    testSelfCheckout.enterPressed()

    assert(Math.abs(testSelfCheckout.tax() - 0.0)<epsilon)
  }

  test("Bottle Deposit"){
      var myBottle:BottleDeposit = new BottleDeposit(30)
      var Accu:Double = 30.0

    assert(Math.abs(myBottle.updatePrice(30.0) - Accu)< epsilon)
    var myBottle1: BottleDeposit = new BottleDeposit(10)
    var Accu2: Double = 10.0

    assert(Math.abs(myBottle1.computeTax(10.0) - Accu2) < epsilon)
  }

test("test basePrice check"){
  var testSelfCheckout: SelfCheckout = new SelfCheckout()
  var Snapple: Item = new Item("Peach", 6.0)
  var Welch: Item = new Item("Grapes", 10.0)

  testSelfCheckout.addItemToStore("24", Welch)
  testSelfCheckout.addItemToStore("98", Snapple)

  testSelfCheckout.numberPressed(9)
  testSelfCheckout.numberPressed(8)
  testSelfCheckout.enterPressed()
  Snapple.setBasePrice(10.0)

  var changeMod: Modifier = new Sale(50)
  Snapple.addModifier(changeMod)
  println(Snapple.price())
  assert(Math.abs(Snapple.price() - 5.0) < epsilon)
}
  test("test basePrice cart") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Snapple: Item = new Item("Peach", 6.0)
    var Welch: Item = new Item("Grapes", 10.0)
    testSelfCheckout.addItemToStore("98", Snapple)
    testSelfCheckout.addItemToStore("24", Welch)

    testSelfCheckout.numberPressed(9)
    testSelfCheckout.numberPressed(8)
    testSelfCheckout.enterPressed()
    Snapple.setBasePrice(15.0)
    var cart:List[Item] = testSelfCheckout.itemsInCart()


    var changeMod: Modifier = new Sale(50)
    Snapple.addModifier(changeMod)
    cart:+ Snapple
    assert(Math.abs(cart.head.price() - 7.5) < epsilon)
  }
}
