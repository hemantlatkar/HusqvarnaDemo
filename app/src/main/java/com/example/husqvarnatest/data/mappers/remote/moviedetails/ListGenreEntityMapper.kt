package com.example.husqvarnatest.data.mappers.remote.moviedetails

import com.example.husqvarnatest.data.mappers.MapperData
import com.example.husqvarnatest.data.remote.moviedetails.Genre
import com.example.husqvarnatest.domain.models.moviedetails.GenreD

class ListGenreEntityMapper : MapperData<List<Genre>, List<GenreD>> {

    override fun mapFromEntity(type: List<Genre>): List<GenreD> {
        val listGenreD = ArrayList<GenreD>()

        type.forEach { genre ->
            listGenreD.add(
                GenreD(
                    id = genre.id ?: 0,
                    name = genre.name ?: ""
                )
            )
        }

        return listGenreD.toList()
    }
}