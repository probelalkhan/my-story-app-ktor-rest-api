package net.simplifiedcoding.data.models.common

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PaginatedResult<T : Any>(
    val pageCount: Long,
    val nextPage: Long?,
    val data: List<T>
)