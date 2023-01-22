package com.example.demo.approver;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.javers.core.metamodel.annotation.DiffIgnore;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.approverorder.ApproverOrder;
import com.example.demo.order.Order;

@Entity
@Table(name = "approvers")
public class Approver {
	@Id()
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany()
	@JoinTable(
			  name = "approver_orders", 
			  joinColumns = @JoinColumn(name = "approver_id"), 
			  inverseJoinColumns = @JoinColumn(name = "order_id"))
	@BatchSize(size=100)
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public List<ApproverOrder> getApproverOrders() {
		return approverOrders;
	}

	public void setApproverOrders(List<ApproverOrder> approverOrders) {
		this.approverOrders = approverOrders;
	}

//	@RestResource(exported = false)
	@OneToMany(mappedBy = "approver")
	@DiffIgnore
	private List<ApproverOrder> approverOrders;
}
