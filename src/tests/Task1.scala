package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item

class Task1 extends FunSuite {

  test("Test one") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Snapple: Item = new Item("Peach", 6.0)
    var Welch: Item = new Item("Grapes", 10.0)
    var Cookies: Item = new Item("Oreos", 12.0)

    testSelfCheckout.addItemToStore("19", Snapple)
    testSelfCheckout.addItemToStore("23", Welch)
    testSelfCheckout.addItemToStore("65", Cookies)
    var mycart: List[Item] = testSelfCheckout.itemsInCart()
    var epsilon = 0.001
    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(9)
    testSelfCheckout.enterPressed()
    Snapple.setBasePrice(10.0)
    mycart = mycart:+ Snapple
    assert(Math.abs(mycart.head.price() - 10.0)< epsilon)
  }

    test("Test snappler") {
      var testSelfCheckout: SelfCheckout = new SelfCheckout()
      var Snapple: Item = new Item("Peach", 6.0)
      var Welch: Item = new Item("Grapes", 10.0)
      var Cookies: Item = new Item("Oreos", 12.0)

      testSelfCheckout.addItemToStore("19", Snapple)
      testSelfCheckout.addItemToStore("23", Welch)
      testSelfCheckout.addItemToStore("65", Cookies)
      assert(testSelfCheckout.displayString == "")

      testSelfCheckout.numberPressed(1)
      testSelfCheckout.numberPressed(9)
      assert(testSelfCheckout.displayString == "19")
      testSelfCheckout.enterPressed()

      var testItem2 = Snapple
      Snapple.setBasePrice(7.0)
      var epsilon = 0.0001
      assert(Math.abs(testItem2.price() - 7.0) < epsilon)
    }

  test("test 4") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    val mycart: List[Item] = testSelfCheckout.itemsInCart()
    assert(mycart.length == 0)
    var Cookies: Item = new Item("Oreos", 12.0)
    testSelfCheckout.addItemToStore("02", Cookies)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(2)
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString == "")

  }

  test("test 5") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Snapple: Item = new Item("Peach", 6.0)
    var errorItem: Item = new Item("MyError", 10.0)
    var Cookies: Item = new Item("Oreos", 12.0)

    testSelfCheckout.addItemToStore("19", Snapple)
    testSelfCheckout.addItemToStore("004", errorItem)
    testSelfCheckout.addItemToStore("055", Cookies)
    assert(testSelfCheckout.displayString() == "")

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(4)
    assert(testSelfCheckout.displayString() == "004")
    testSelfCheckout.enterPressed()
    var cart = testSelfCheckout.itemsInCart()

    assert(cart.head.description()== "MyError")

    assert(testSelfCheckout.displayString() == "")

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(5)
    testSelfCheckout.numberPressed(5)
    assert(testSelfCheckout.displayString == "055")
     testSelfCheckout.enterPressed()
    assert(cart.last.description()== "MyError")

  }
  test("tes 5"){
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Snapple: Item = new Item("Peach", 6.0)
    var Welch: Item = new Item("Grapes", 10.0)
    var Cookies: Item = new Item("Oreos", 12.0)
    var epsilon = 0.001

    testSelfCheckout.addItemToStore("19", Snapple)
    testSelfCheckout.addItemToStore("23", Welch)
    testSelfCheckout.addItemToStore("056", Cookies)

    testSelfCheckout.numberPressed(2)
    assert(testSelfCheckout.displayString =="2")
    testSelfCheckout.enterPressed()
    var cart = testSelfCheckout.itemsInCart()
    assert(cart.head.description == "error")
    assert(cart.head.price() - 0.0 < epsilon)

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(5)
    testSelfCheckout.numberPressed(6)
    assert(testSelfCheckout.displayString == "056")
    testSelfCheckout.enterPressed()
  }
    test("test 6") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()
    var Snapple: Item = new Item("Peach", 6.0)
    var Welch: Item = new Item("Grapes", 10.0)
    var Cookies: Item = new Item("Oreos", 12.0)

    testSelfCheckout.addItemToStore("19", Snapple)
    testSelfCheckout.addItemToStore("23", Welch)
    testSelfCheckout.addItemToStore("65", Cookies)

    testSelfCheckout.numberPressed(6)
    testSelfCheckout.numberPressed(5)
      testSelfCheckout.enterPressed()
      assert(testSelfCheckout.itemsInCart()== List(Cookies))

    testSelfCheckout.numberPressed(1)
    testSelfCheckout.numberPressed(9)
    testSelfCheckout.enterPressed()
      assert(testSelfCheckout.itemsInCart()== List(Cookies,Snapple))

    var epsilon = 0.01
    val cart: List[Item] = testSelfCheckout.itemsInCart()
    assert(cart.length == 2)
    assert(Math.abs(cart.head.price() - 12.0) < epsilon)
      Cookies.setBasePrice(8.0)
      assert(Math.abs(cart.head.price() - 8.0) < epsilon)
      cart(1).setBasePrice(5.0)
    assert(Math.abs(cart(1).price() - 5.0)< epsilon)
  }
  }
