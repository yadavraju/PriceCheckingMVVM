package com.raju.caperpricechecker.ui.factory

import com.raju.caperpricechecker.data.CartListDataItem
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AppFactoryTest {

  lateinit var testObject: AppFactory

  @Before
  fun setUp() {
    testObject = AppFactory()
  }

  @Test
  fun createGiphyAdapter() {
    assertNotNull(testObject.createCartAdapter(CartListDataItem(), ::itemClicked))
  }

  private fun itemClicked(position: Int) {}
}
