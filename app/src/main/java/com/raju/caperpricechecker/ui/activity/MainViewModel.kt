package com.raju.caperpricechecker.ui.activity

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.repository.CartRepository
import com.raju.caperpricechecker.ui.adapter.CommonAdapter
import com.raju.caperpricechecker.ui.factory.AppFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val adapter: CommonAdapter,
    private val factory: AppFactory,
    repository: CartRepository
) : ViewModel() {

  private val adapterObservableField: ObservableField<CommonAdapter> = ObservableField()
  private val totalPriceObservableField: ObservableField<String> = ObservableField()
  private val mutableListOf = repository.getCartListData()

  init {
    loadDefaultCartData()
    totalPriceObservableField.set(calculateTotalPrice(mutableListOf).toString())
  }

  fun loadDefaultCartData() {
    setContactAdapterData(mutableListOf)
  }

  private fun setContactAdapterData(dataList: MutableList<CartListDataItem>) {
    val contactAdapter = dataList.map { factory.createCartAdapter(it, ::performClick) }
    adapter.setDataBoundAdapter(contactAdapter)
    adapterObservableField.set(adapter)
  }

  fun addItemToCart(cartListDataItem: CartListDataItem) {
    mutableListOf.add(cartListDataItem)
    val contactAdapter = factory.createCartAdapter(cartListDataItem, ::performClick)
    adapter.addItem(contactAdapter)
    totalPriceObservableField.set(calculateTotalPrice(mutableListOf).toString())
  }

  fun calculateTotalPrice(mutableListOf: MutableList<CartListDataItem>): Double {
    var sum = 0.00
    mutableListOf.forEach { data ->
      val price = data.price
      val priceValue = price.substring(1).toDouble()
      sum += priceValue
    }
    return sum
  }

  private fun performClick(position: Int) {
    mutableListOf.removeAt(position)
    setContactAdapterData(mutableListOf)
    totalPriceObservableField.set(calculateTotalPrice(mutableListOf).toString())
  }

  fun getAdapterObservableField(): ObservableField<CommonAdapter> = adapterObservableField
  fun getTotalPrice(): ObservableField<String> = totalPriceObservableField
}
