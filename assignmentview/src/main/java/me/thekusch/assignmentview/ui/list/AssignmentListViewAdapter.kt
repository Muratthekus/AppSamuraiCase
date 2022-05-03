package me.thekusch.assignmentview.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.thekusch.assignmentview.R
import me.thekusch.assignmentview.base.BaseViewHolder
import me.thekusch.assignmentview.base.DefaultBaseAdapter
import me.thekusch.assignmentview.ui.AssignmentImageView

internal class AssignmentListViewAdapter :
    DefaultBaseAdapter<AssignmentListView.ItemEntity, AssignmentListViewAdapter.ItemViewHolder>() {

    private var _loadList = mutableListOf<Long>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_component_list_view, parent, false)
        return ItemViewHolder(itemView)
    }

    internal inner class ItemViewHolder(listView: View) :
        BaseViewHolder<AssignmentListView.ItemEntity>(listView) {

        private val imageView: AssignmentImageView =
            listView.findViewById(R.id.imageViewAssignment)

        override fun bind(item: AssignmentListView.ItemEntity?) {
            super.bind(item)
            imageView.loadResource(item?.imageUrl)
            imageView.onImageLoad = { loadTime ->
                _loadList.add(loadTime)
                if(_loadList.size == itemList?.size) {
                    // make request

                }

            }
        }
    }
}