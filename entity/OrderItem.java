package com.assetmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
	@Table(name="order_item_tbl")
    
	public class OrderItem {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="order_item_id")
		private int orderItemId;
		
		private int assetId;
		
		@Column(name="quantity")
		private int quantity;
			
		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="order_id")
		private Order order;

		public int getOrderItemId() {
			return orderItemId;
		}

		public void setOrderItemId(int orderItemId) {
			this.orderItemId = orderItemId;
		}

		public int getAssetId() {
			return assetId;
		}

		public void setAssetId(int assetId) {
			this.assetId = assetId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}
	
}
