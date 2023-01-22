package com.example.demo.approverorder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ApproverOrderRespository extends PagingAndSortingRepository<ApproverOrder, Integer> {
	Page<ApproverOrder> findByStatus(@Param("status") String status, Pageable page);
	Page<ApproverOrder> findByOrderId(@Param("orderId") Integer orderId, Pageable page);
}
