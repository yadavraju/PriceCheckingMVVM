package com.raju.caperpricechecker.ui.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import bindSrcUrl
import com.raju.caperpricechecker.data.CartListDataItem
import kotlinx.android.synthetic.main.item_view_layout.view.*

class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  fun bind(data: CartListDataItem, clickListener: (Int) -> Unit) {
    itemView.tvProductName.text = data.name
    itemView.image.bindSrcUrl(data.thumbnail)
    itemView.tvPrice.text = data.price
    itemView.tvRemove.setOnClickListener { clickListener(layoutPosition) }
  }
}
