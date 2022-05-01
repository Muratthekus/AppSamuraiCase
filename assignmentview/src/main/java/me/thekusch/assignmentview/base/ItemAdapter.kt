package me.thekusch.assignmentview.base

internal interface ItemAdapter<T: BaseEntity> {

    fun updateItems(itemList: List<T>?)
}