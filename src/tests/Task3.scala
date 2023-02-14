package tests
import org.scalatest.FunSuite
import store.model.items._
import store.model.checkout.SelfCheckout



class Task3 extends FunSuite {
  var epsilon:Double = 0.001

  test("should return cart size 2"){
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Welch: Item = new Item("Grapes", 20.0)
    testSelfCheckout.addItemToStore("24", Welch)

    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(5)
    testSelfCheckout.clearPressed()
    testSelfCheckout.enterPressed()


    var cart = testSelfCheckout.itemsInCart()
    assert(cart.head.description() == "Grapes")
    assert(cart.last.description() == "error")
    assert(testSelfCheckout.displayString() == "")
    assert(cart.size == 3)
  }


  test("should return cart size 1") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Welch: Item = new Item("Grapes", 20.0)
    var Sale1: Sale = new Sale(25)
    var Sale2: Sale = new Sale(25)
    testSelfCheckout.addItemToStore("24", Welch)

    testSelfCheckout.numberPressed(2)
    testSelfCheckout.numberPressed(4)
    testSelfCheckout.enterPressed()


    var cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.head.description() == "Grapes")
    assert(cart.size == 1)
  }
  test("cash/credit") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Juice: Item = new Item("Apple", 10.0)
    var Sale1: Sale = new Sale(25)
    var Sale2: Sale = new Sale(25)
    testSelfCheckout.addItemToStore("72", Juice)

    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.checkoutPressed()

    var cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.head.description() == "Apple")
    assert(cart.size == 1)
    assert(Math.abs(Juice.price()- 10.0)<epsilon)
    assert(testSelfCheckout.displayString() == "cash or credit")
  }

  test("cant rescan") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Juice: Item = new Item("Apple", 10.0)
    testSelfCheckout.addItemToStore("72", Juice)

    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()


    var cart: List[Item] = testSelfCheckout.itemsInCart()
    println(cart)
    assert(cart.head.description() == "Apple")
    //assert(cart.last.description() == "error")

    assert(cart.size == 3)
    assert(Math.abs(testSelfCheckout.total()-30.0)<epsilon)
    assert(Math.abs(Juice.price() - 10.0) < epsilon)
  }

  test("cart not emptied for next customer") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Juice: Item = new Item("Apple", 10.0)
    var Sale1: Sale = new Sale(25)
    var Sale2: Sale = new Sale(25)
    testSelfCheckout.addItemToStore("72", Juice)

    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.enterPressed()
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.cashPressed()

    var cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(testSelfCheckout.displayString() == "")
    assert(cart.length==0)
  }

}
