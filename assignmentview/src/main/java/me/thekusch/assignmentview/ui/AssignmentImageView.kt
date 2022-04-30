package me.thekusch.assignmentview.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import me.thekusch.assignmentview.R
import java.lang.Exception

internal class AssignmentImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.assignmentImageView
): AppCompatImageView(context, attrs, defStyleAttr) {


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
}