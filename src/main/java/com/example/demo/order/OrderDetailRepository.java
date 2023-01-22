package com.example.demo.order;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderDetailRepository extends PagingAndSortingRepository<OrderDetail, Integer> {

}
