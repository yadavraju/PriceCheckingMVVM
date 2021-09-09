package com.raju.caperpricechecker.ui.activity

import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.data.mockCartListData
import com.raju.caperpricechecker.repository.CartRepository
import com.raju.caperpricechecker.ui.adapter.CartAdapter
import com.raju.caperpricechecker.ui.adapter.CommonAdapter
import com.raju.caperpricechecker.ui.factory.AppFactory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

  @Mock private lateinit var repository: CartRepository

  @Mock private lateinit var adapter: CommonAdapter

  @Mock private lateinit var appFactory: AppFactory

  @Mock private lateinit var cartAdapter: CartAdapter

  private lateinit var testObject: MainViewModel

  @Before
  fun setUp() {
    `when`(repository.getCartListData()).thenReturn(mockCartListData)
    testObject = MainViewModel(adapter, appFactory, repository)
  }

  @Test
  fun loadDefaultCartData() {
    testObject.loadDefaultCartData()
    verify(adapter, times(2)).setDataBoundAdapter(any())
    assertNotNull(testObject.getAdapterObservableField())
  }

  @Test
  fun addItemToCart() {
    `when`(appFactory.createCartAdapter(any(), any())).thenReturn(cartAdapter)
    testObject.addItemToCart(CartListDataItem(name = "test", price = "$4.00"))
    verify(adapter).addItem(cartAdapter)
    assertNotNull(testObject.getTotalPrice())
  }

  @Test
  fun calculateTotalPrice() {
    val testTotal = 16.00
    val calculateTotalPrice = testObject.calculateTotalPrice(mockCartListData)
    assertEquals(testTotal.toFloat(), calculateTotalPrice.toFloat())
  }

  @Test
  fun getAdapterObservableField() {
    assertNotNull(testObject.getAdapterObservableField())
  }

  @Test
  fun getTotalPrice() {
    assertNotNull(testObject.getTotalPrice())
  }
}
