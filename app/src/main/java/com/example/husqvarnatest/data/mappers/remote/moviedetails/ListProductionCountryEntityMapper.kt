package com.example.husqvarnatest.data.mappers.remote.moviedetails

import com.example.husqvarnatest.data.mappers.MapperData
import com.example.husqvarnatest.data.remote.moviedetails.ProductionCountry
import com.example.husqvarnatest.domain.models.moviedetails.ProductionCountryD

class ListProductionCountryEntityMapper :
    MapperData<List<ProductionCountry>, List<ProductionCountryD>> {

    override fun mapFromEntity(type: List<ProductionCountry>): List<ProductionCountryD> {
        val listProductionCompanyD = ArrayList<ProductionCountryD>()

        type.forEach { productionCountry ->
            listProductionCompanyD.add(
                ProductionCountryD(
                    iso_3166_1 = productionCountry.iso_3166_1 ?: "",
                    name = productionCountry.name ?: ""
                )
            )
        }

        return listProductionCompanyD.toList()
    }
}