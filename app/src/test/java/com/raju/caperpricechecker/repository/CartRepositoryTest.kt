package com.raju.caperpricechecker.repository

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CartRepositoryTest {

  private lateinit var testObject: CartRepository

  @Before
  fun setUp() {
    testObject = CartRepository()
  }

  @Test
  fun getCartListData() {
    val cartListData = testObject.getCartListData()
    assertEquals("Banana", cartListData[0].name)
  }
}
