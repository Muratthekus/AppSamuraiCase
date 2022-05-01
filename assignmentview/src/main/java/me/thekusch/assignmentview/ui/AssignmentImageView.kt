package me.thekusch.assignmentview.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import me.thekusch.assignmentview.R
import java.lang.Exception

internal class AssignmentImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.assignmentImageViewStyle
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var _loadTime: Long = DEFAULT_LOAD_TIME

    var loadTime: Long
        get() = _loadTime
        set(value) {
            _loadTime = value
        }

    init {
        obtainStyledAttributes(attrs, defStyleAttr)
    }

    private fun obtainStyledAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.AssignmentImageView,
            defStyleAttr,
            0
        )

        try {
            // no-op
        } catch (e: Exception) {
            // ignored
        } finally {
            typedArray.recycle()
        }
    }

    fun loadResource(resourceUrl: String?) {
        val startTime = System.currentTimeMillis()
        Glide.with(context)
            .load(resourceUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    // no-op
                    // load time wil remain same as DEFAULT_LOAD_TIME (-1)
                    imageLoadLog(resourceUrl)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    val resultTime = System.currentTimeMillis()
                    loadTime = resultTime - startTime
                    imageLoadLog(resourceUrl)
                    return false
                }
            })
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .into(this)
    }

    private fun imageLoadLog(resource: String?) {
        val status = if (loadTime == DEFAULT_LOAD_TIME) "FAIL" else "SUCCESS"
        Log.d(TAG, "Status: $status --> resource: $resource trackedLoadTime: $loadTime ms")
    }

    companion object {
        const val DEFAULT_LOAD_TIME = -1L
        const val TAG = "AssignmentImageView"
    }
}