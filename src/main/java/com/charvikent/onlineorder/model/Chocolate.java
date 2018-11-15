package com.charvikent.onlineorder.model;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "chocolateordering")
public class Chocolate 
{
	@Id
	@GeneratedValue(generator = "order_id") 
	@GenericGenerator(name = "order_id", strategy = "com.charvikent.onlineorder.config.OrderIdGenerator")
	@Column( name= "orderId", unique=true, nullable=false)
	
	private String orderId=null;
	@CreationTimestamp
	protected Date createdTime ;
	@UpdateTimestamp
	protected Date updatedTime ;
	@Column
	private String customerName;
	private String contact;
	private String deliveryDate;
	private String deliveryLocation;
	private String deliveryMode;
	private String weight;
	private String model;
	private String notes;
	private String modeOfPayment;
	private String quantity;
	private String chocostatus;
	public Chocolate() 
	{
		
	}
	
	public Chocolate(String orderId, Date createdTime, Date updatedTime, String customerName, String contact,
			String deliveryDate, String deliveryLocation, String deliveryMode, String weight, String model,
			String notes, String modeOfPayment, String quantity, String chocostatus) 
	{
		super();
		this.orderId = orderId;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
		this.customerName = customerName;
		this.contact = contact;
		this.deliveryDate = deliveryDate;
		this.deliveryLocation = deliveryLocation;
		this.deliveryMode = deliveryMode;
		this.weight = weight;
		this.model = model;
		this.notes = notes;
		this.modeOfPayment = modeOfPayment;
		this.quantity = quantity;
		this.chocostatus = chocostatus;
	}

	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getChocostatus() {
		return chocostatus;
	}
	public void setChocostatus(String chocostatus) {
		this.chocostatus = chocostatus;
	}

	@Override
	public String toString() 
	{
		return "Chocolate [createdTime=" + createdTime + ", updatedTime=" + updatedTime
				+ ", customerName=" + customerName + ", contact=" + contact + ", deliveryDate=" + deliveryDate
				+ ", deliveryLocation=" + deliveryLocation + ", deliveryMode=" + deliveryMode + ", weight=" + weight
				+ ", model=" + model + ", notes=" + notes + ", modeOfPayment=" + modeOfPayment + ", quantity="
				+ quantity + ", orderId=" + orderId + ", chocostatus=" + chocostatus + "]";
	}

	
	
}
