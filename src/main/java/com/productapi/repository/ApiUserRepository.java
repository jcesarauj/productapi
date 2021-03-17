package com.productapi.repository;

import com.productapi.domain.models.core.auth.ApiUser;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApiUserRepository extends PagingAndSortingRepository<ApiUser, Long> {
    ApiUser findByUserName(String username);
}