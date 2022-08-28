package com.example.husqvarnatest.data.mappers.remote.moviedetails

import com.example.husqvarnatest.data.mappers.MapperData
import com.example.husqvarnatest.data.remote.moviedetails.BelongsToCollection
import com.example.husqvarnatest.domain.models.moviedetails.BelongsToCollectionD

class BelongToCollectionEntityMapper : MapperData<BelongsToCollection, BelongsToCollectionD> {

    override fun mapFromEntity(type: BelongsToCollection): BelongsToCollectionD =
        BelongsToCollectionD(
            backdrop_path = type.backdrop_path ?: "",
            id = type.id ?: 0,
            name = type.name ?: "",
            poster_path = type.poster_path ?: ""
        )
}