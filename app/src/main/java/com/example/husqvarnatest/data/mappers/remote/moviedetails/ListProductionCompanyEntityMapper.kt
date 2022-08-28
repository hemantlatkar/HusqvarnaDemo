package com.example.husqvarnatest.data.mappers.remote.moviedetails

import com.example.husqvarnatest.data.mappers.MapperData
import com.example.husqvarnatest.data.remote.moviedetails.ProductionCompany
import com.example.husqvarnatest.domain.models.moviedetails.ProductionCompanyD

class ListProductionCompanyEntityMapper :
    MapperData<List<ProductionCompany>, List<ProductionCompanyD>> {

    override fun mapFromEntity(type: List<ProductionCompany>): List<ProductionCompanyD> {
        val listProductionCompanyD = ArrayList<ProductionCompanyD>()

        type.forEach { productionCompany ->
            listProductionCompanyD.add(
                ProductionCompanyD(
                    id = productionCompany.id ?: 0,
                    logo_path = productionCompany.logo_path ?: "",
                    name = productionCompany.name ?: "",
                    origin_country = productionCompany.origin_country ?: ""
                )
            )
        }

        return listProductionCompanyD.toList()
    }
}