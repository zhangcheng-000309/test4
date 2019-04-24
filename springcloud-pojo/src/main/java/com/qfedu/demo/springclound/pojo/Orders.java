package com.qfedu.demo.springclound.pojo;

public class Orders {
	
	private String id;
	
	private Double price;
	
	private String consumerId;

	private Consumer consumer;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
}
