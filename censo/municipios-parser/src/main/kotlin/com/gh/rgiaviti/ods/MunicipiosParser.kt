package com.gh.rgiaviti.ods

import com.gh.rgiaviti.ods.domains.OpenDataMunicipio
import com.gh.rgiaviti.ods.services.CSVService
import com.gh.rgiaviti.ods.services.FileOutService
import com.gh.rgiaviti.ods.services.JSONService
import com.gh.rgiaviti.ods.services.MetaInfoService

object MunicipiosParser {

    @JvmStatic
    fun main(args: Array<String>) {
        val municipios = CSVService.parse().sortedBy { it.nome }
        val metaInfo = MetaInfoService.metaInfo(municipios.size)
        val json = JSONService.toJSON(OpenDataMunicipio(metaInfo, municipios))
        FileOutService.save(json)
    }
}