package ru.impression.kotlin_delegate_concatenator

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class DelegateSum<R, T>(
    val delegate1: ReadWriteProperty<R, T>,
    val delegate2: ReadWriteProperty<R, T>
) : ReadWriteProperty<R, T> {

    override fun getValue(thisRef: R, property: KProperty<*>) =
        delegate1.getValue(thisRef, property)

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        delegate1.setValue(thisRef, property, value)
        delegate2.setValue(thisRef, property, value)
    }
}