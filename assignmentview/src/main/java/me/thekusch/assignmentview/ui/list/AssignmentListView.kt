package me.thekusch.assignmentview.ui.list

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.thekusch.assignmentview.R
import me.thekusch.assignmentview.base.BaseEntity
import me.thekusch.assignmentview.base.BaseListComponent

public class AssignmentListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.assignmentListViewStyle
) : RecyclerView(context, attrs, defStyleAttr), BaseListComponent<AssignmentListView.ItemEntity> {

    private val listAdapter = AssignmentListViewAdapter()

    init {
        layoutManager = LinearLayoutManager(context)
        adapter = listAdapter
    }

    override fun setup(itemList: List<ItemEntity>?) {
        listAdapter.updateItems(itemList)
    }

    public data class ItemEntity(
        val imageUrl: String
    ) : BaseEntity()

}