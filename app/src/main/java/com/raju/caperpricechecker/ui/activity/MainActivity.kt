package com.raju.caperpricechecker.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.raju.caperpricechecker.base.BaseActivity
import com.raju.caperpricechecker.data.CartListDataItem
import com.raju.caperpricechecker.databinding.ActivityMainBinding
import com.raju.caperpricechecker.ui.fragment.AddContactDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity(), AddContactDialog.ProductListener {

  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.viewModel = viewModel
    addItemManually()
  }

  private fun addItemManually() {
    btnAdd.setOnClickListener {
      AddContactDialog.newInstance().show(supportFragmentManager, BOTTOM_DIALOG_TAG)
    }
  }

  override fun addProduct(contact: CartListDataItem) {
    viewModel.addItemToCart(contact)
  }
}
