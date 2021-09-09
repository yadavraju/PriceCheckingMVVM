package com.raju.caperpricechecker.ui.fragment

import TOAST
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.databinding.DialogAddProductBinding
import kotlinx.android.synthetic.main.dialog_add_product.*

class AddContactDialog : BottomSheetDialogFragment() {

  private lateinit var binding: DialogAddProductBinding
  private var listener: ProductListener? = null

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {
    binding = DialogAddProductBinding.inflate(LayoutInflater.from(this.activity), container, false)
    addContactData()
    return binding.root
  }

  private fun addContactData() {
    binding.addContact.setOnClickListener {
      val productName = etProductName.text.toString()
      val productPrice = etProductPrice.text.toString()
      if (productName.isNotBlank() && productPrice.isNotBlank()) {
        listener?.addProduct(CartListDataItem(name = productName, price = "$$productPrice.00")) // For now only i am concating like this
        dismiss()
      } else {
        TOAST("Please enter all field")
      }
    }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is ProductListener) {
      listener = context
    } else {
      throw RuntimeException("$context must implement listener")
    }
  }

  override fun onDetach() {
    super.onDetach()
    listener = null
  }

  companion object {
    fun newInstance(): AddContactDialog = AddContactDialog()
  }

  interface ProductListener {
    fun addProduct(contact: CartListDataItem)
  }
}
