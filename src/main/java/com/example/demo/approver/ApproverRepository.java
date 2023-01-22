package com.example.demo.approver;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@JaversSpringDataAuditable
@RepositoryRestResource
public interface ApproverRepository extends PagingAndSortingRepository<Approver, Integer> {

}
