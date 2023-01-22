package com.example.demo.approverorder;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.approver.Approver;
import com.example.demo.order.Order;

@Entity
@Table(name = "approver_orders")
public class ApproverOrder {
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
	private String status = "rejected";
	
    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column
	private Boolean active = true;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@ManyToOne
    @JoinColumn(name = "approver_id")
	private Approver approver;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
	private Order order;

	public Approver getApprover() {
		return approver;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
