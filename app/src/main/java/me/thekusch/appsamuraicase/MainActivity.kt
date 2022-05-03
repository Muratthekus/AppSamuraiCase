package me.thekusch.appsamuraicase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.thekusch.assignmentview.ui.list.AssignmentListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<AssignmentListView>(R.id.list)

        list.setup(
            listOf(
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-5mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-5mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image2-5mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image3-5mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image4-5mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-3mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-500kb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-1_5mb.png"),
                AssignmentListView.ItemEntity("https://db62cod6cnasq.cloudfront.net/user-media/0/image1-2mb.png")
            )
        )
    }
}