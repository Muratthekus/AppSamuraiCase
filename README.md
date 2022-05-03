# **Assignment View**
A custom list view to display the list of images along with tracking and logging load time of the images


### Usage
All you need to do is simply adding AssignmentListView to your xml file
```xml
<me.thekusch.assignmentview.ui.list.AssignmentListView
    android:id="@+id/list"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

```kotlin
 val list = findViewById<AssignmentListView>(R.id.list)
 list.setup(
    listOf(
        AssignmentListView.ItemEntity(imageResourceUrl),
        ...
        ...
        ...
    )
)

```
