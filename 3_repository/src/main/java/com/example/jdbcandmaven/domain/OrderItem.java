package com.example.jdbcandmaven.domain;

public class OrderItem {

		private long id;
		private String name;
		private String description;
		private double price;
		
		public OrderItem() {
			
		}
		
		public OrderItem(long id, String name, String description, double price) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
		
		
		
}
