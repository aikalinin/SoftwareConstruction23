package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@Schema(description = "Факт о кошках")
data class Fact(
    @JsonProperty("_id")
    @Schema(description = "Идентификатор")
    var id: String,
    @Schema(description = "Текст")
    var text: String,
    @DateTimeFormat(style = "yyyy-MM-ddThh:mm:ss.sssZ")
    var updatedAt: LocalDateTime,
    var deleted: Boolean?,
    var source: String?,
    var sentCount: Int?
)
