package com.example.husqvarnatest.data.mappers.remote.moviespopular

import com.example.husqvarnatest.data.mappers.MapperData
import com.example.husqvarnatest.data.remote.moviespopular.ListMoviesPopularEntity
import com.example.husqvarnatest.domain.models.moviespopular.ListMoviesPopularD

class ListMoviesPopularEntityMapper : MapperData<ListMoviesPopularEntity, ListMoviesPopularD> {

    override fun mapFromEntity(type: ListMoviesPopularEntity): ListMoviesPopularD =
        ListMoviesPopularD(
            page = type.page,
            moviesPopularDetails = ResultListMoviesEntityMapper().mapFromEntity(type.results),
            total_pages = type.total_pages,
            total_results = type.total_results
        )
}