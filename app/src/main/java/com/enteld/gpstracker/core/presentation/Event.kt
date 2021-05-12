package com.enteld.gpstracker.core.presentation

interface EventsDispatcherOwner<T> {
    val eventsDispatcher: EventsDispatcher<T>
}