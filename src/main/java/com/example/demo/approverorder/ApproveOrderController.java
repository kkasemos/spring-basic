package com.example.demo.approverorder;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class ApproveOrderController {
	@RequestMapping(method = RequestMethod.GET, value = "/approvers/bulk/add")
	public @ResponseBody ResponseEntity<?> addApprovers() {
		return ResponseEntity.ok("test");
	}
}
