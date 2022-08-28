package com.example.husqvarnatest.data.mappers

interface MapperData<E, D> {

    fun mapFromEntity(type: E): D
}