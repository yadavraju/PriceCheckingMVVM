package com.raju.caperpricechecker.ui.factory

import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.ui.adapter.CartAdapter
import javax.inject.Inject

class AppFactory @Inject constructor() {

  fun createCartAdapter(data: CartListDataItem, clickListener: (Int) -> Unit): CartAdapter {
    return CartAdapter(data, clickListener)
  }
}
