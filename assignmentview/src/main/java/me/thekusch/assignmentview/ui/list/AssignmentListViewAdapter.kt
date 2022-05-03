package me.thekusch.assignmentview.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.thekusch.assignmentview.R
import me.thekusch.assignmentview.base.BaseViewHolder
import me.thekusch.assignmentview.base.DefaultBaseAdapter
import me.thekusch.assignmentview.service.LoggingInterceptor
import me.thekusch.assignmentview.ui.AssignmentImageView
import okhttp3.*
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

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
                    sendLoadTimeToServer()
                }
            }
        }
    }

    private fun sendLoadTimeToServer() {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(LoggingInterceptor.TIME_OUT_DURATION,TimeUnit.SECONDS)
            .readTimeout(LoggingInterceptor.TIME_OUT_DURATION,TimeUnit.SECONDS)
            .writeTimeout(LoggingInterceptor.TIME_OUT_DURATION,TimeUnit.SECONDS)
            .addInterceptor(LoggingInterceptor())
            .build()

        val formBody = FormBody
            .Builder()

        itemList?.forEachIndexed { index, itemEntity ->
            formBody.add(itemEntity.imageUrl, _loadList[index].toString())
        }

        val requestBody: RequestBody = formBody
            .build()

        val request: Request = Request.Builder()
            .url("https://httpbin.org/")
            .post(requestBody)
            .build()


        val executor: ExecutorService = Executors.newSingleThreadExecutor()
        executor.execute {
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    //
                }

                override fun onResponse(call: Call, response: Response) {
                    //
                }
            })
        }
    }
}