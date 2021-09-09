package com.raju.caperpricechecker.ui.adapter

import android.view.View
import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.ui.adapter.viewholder.CartViewHolder
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class CartAdapterTest {

  private lateinit var testObject: CartAdapter

  @Before
  fun setUp() {
    testObject = CartAdapter(CartListDataItem(), ::itemClicked)
  }

  private fun itemClicked(position: Int) {}

  @Test
  fun createItemViewHolder() {
    val view = mock<View> {}
    assertNotNull(testObject.createItemViewHolder(view))
  }

  @Test
  fun bindItemViewHolder() {
    val holder = mock<CartViewHolder> {}
    testObject.bindItemViewHolder(holder)
    verify(holder).bind(any(), any())
  }

  @Test
  fun getViewType() {
    assertEquals(ViewType.CART_ITEM_VIEW, testObject.viewType)
  }
}
