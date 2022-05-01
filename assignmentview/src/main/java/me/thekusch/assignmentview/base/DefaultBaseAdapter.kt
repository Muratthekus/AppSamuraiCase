package me.thekusch.assignmentview.base

import androidx.recyclerview.widget.RecyclerView

internal abstract class DefaultBaseAdapter<T : BaseEntity, VH> :
    ItemAdapter<T>,
    RecyclerView.Adapter<VH>() where VH : BaseViewHolder<T> {

    var itemList: List<T>? = null

    override fun getItemCount() = itemList?.size ?: 0

    override fun updateItems(itemList: List<T>?) {
        itemList?.let {
            this.itemList = it
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(itemList?.get(position))
    }

}