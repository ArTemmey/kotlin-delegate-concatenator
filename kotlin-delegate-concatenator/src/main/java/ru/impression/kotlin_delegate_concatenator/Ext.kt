package ru.impression.kotlin_delegate_concatenator

import kotlin.properties.ReadWriteProperty

operator fun <R, T> ReadWriteProperty<R, T>.plus(other: ReadWriteProperty<R, T>) =
    DelegateSum(this, other)