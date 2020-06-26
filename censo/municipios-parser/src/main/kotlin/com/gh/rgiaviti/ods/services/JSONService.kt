package com.gh.rgiaviti.ods.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.gh.rgiaviti.ods.domains.OpenDataMunicipio

object JSONService {

    private val mapper: ObjectMapper = ObjectMapper()

    init {
        enableModules()
        enableOrDisableFeatures()
    }

    fun toJSON(openDataMunicipio: OpenDataMunicipio): String {
        return mapper.writeValueAsString(openDataMunicipio)
    }

    private fun enableModules() {
        mapper.registerModule(KotlinModule())
        mapper.registerModule(JavaTimeModule())
    }

    private fun enableOrDisableFeatures() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    }
}