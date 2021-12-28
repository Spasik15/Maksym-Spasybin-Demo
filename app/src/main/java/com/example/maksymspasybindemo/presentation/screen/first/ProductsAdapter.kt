package com.example.maksymspasybindemo.presentation.screen.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.maksymspasybindemo.databinding.ListItemBinding
import com.example.maksymspasybindemo.domain.model.ProductDomainModel
import com.example.maksymspasybindemo.presentation.model.ProductNamePresentationModel
import com.example.maksymspasybindemo.utils.presentation.clickAction
import com.example.maksymspasybindemo.utils.presentation.withGlide

class ProductsAdapter(
    private val productClickListener: (ProductNamePresentationModel) -> Unit
) : ListAdapter<ProductDomainModel, ProductsAdapter.ProductViewHolder>(periodsDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ProductViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(itemModel: ProductDomainModel) {
            with(binding) {
                nameTextView.text = itemModel.name
                priceTextView.text = itemModel.price.toString()
                imageView.withGlide(itemModel.imageUrl)
                root.clickAction {
                    productClickListener.invoke(
                        ProductNamePresentationModel(itemModel.name)
                    )
                }
            }
        }
    }

    companion object {

        private val periodsDiffUtilCallback = object : DiffUtil.ItemCallback<ProductDomainModel>() {
            override fun areItemsTheSame(
                oldItem: ProductDomainModel,
                newItem: ProductDomainModel
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ProductDomainModel,
                newItem: ProductDomainModel
            ): Boolean = oldItem == newItem
        }
    }
}
