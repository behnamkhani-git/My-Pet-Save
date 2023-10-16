package com.example.mypetsave.common.domain.model.pagination

import com.example.mypetsave.common.domain.model.animal.details.AnimalWithDetails

data class PaginatedAnimals(
    val animals: List<AnimalWithDetails>,
    val pagination: Pagination              // This indicates which page to request next
)
