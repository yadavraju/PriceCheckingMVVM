package com.raju.caperpricechecker.repository

import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.data.mockCartListData
import javax.inject.Inject

/*
 * Repository pull data from server also save data to our local db
 * But currently we are directly getting from our mock data
 * */

class CartRepository @Inject constructor() {

  fun getCartListData(): MutableList<CartListDataItem> {
    return mockCartListData
  }
}
