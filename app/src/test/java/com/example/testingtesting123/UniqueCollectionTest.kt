package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun getPlacedItemFromList(){
        collection.addItem(Item("Item1"))
        collection.addItem(Item("Item2"))
        assert (collection.get(1).name=="Item2")
    }

    @Test
    fun removePlacedItemFromList(){
        collection.addItem(Item("Item1"))
        collection.addItem(Item("Item2"))
        val initialSize = collection.size()
        collection.remove(Item("Item1"))
        assert (collection.size()==initialSize-1)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size()

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}