package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.Fact

interface FooApi {

    @Tag(name = "Тестовый запрос на получение фактов")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun foo(
        @Schema(
            description = "Количество фактов",
            defaultValue = "10"
        )
        amount: Int = 10
    ): List<Fact>
}