package me.thekusch.assignmentview.base

internal interface BaseListComponent<T: BaseEntity> {

    // Component setup
    fun setup(itemList: List<T>?)
}