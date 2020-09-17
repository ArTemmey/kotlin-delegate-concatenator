package ru.impression.kotlin_delegate_concatenator

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

operator fun <R, T> ReadWriteProperty<R, T>.plus(other: ReadWriteProperty<R, T>) =
    DelegateSum(this, other)

inline fun <reified D> KProperty0<*>.getDelegateFromSum(): D? {
    val delegate = getDelegate()
    return delegate as? D ?: with(
        delegate as? DelegateSum<*, *> ?: return null
    ) { delegate1 as? D ?: delegate2 as? D }
}

inline fun <R, reified D> KProperty1<R, *>.getDelegateFromSum(receiver: R): D? {
    val delegate = getDelegate(receiver)
    return delegate as? D ?: with(
        delegate as? DelegateSum<*, *> ?: return null
    ) { delegate1 as? D ?: delegate2 as? D }
}