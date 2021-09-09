package com.raju.caperpricechecker.ui.adapter

import android.view.View
import com.raju.caperpricechecker.R
import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.ui.adapter.viewholder.CartViewHolder

class CartAdapter(private val data: CartListDataItem, private val clickListener: (Int) -> Unit)
    : BaseDataBoundAdapter<CartViewHolder>(R.layout.item_view_layout) {

    override fun createItemViewHolder(view: View): CartViewHolder {
        return CartViewHolder(view)
    }

    override fun bindItemViewHolder(holder: CartViewHolder) {
        holder.bind(data, clickListener)
    }

    override val viewType: ViewType
        get() = ViewType.CART_ITEM_VIEW
}
