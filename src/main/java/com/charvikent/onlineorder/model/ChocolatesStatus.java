package com.charvikent.onlineorder.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chstatus")
public class ChocolatesStatus 
{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer  id;
		@Column private String chocostatus;
		
		public Integer getId() 
		{
			return id;
		}
		public void setId(Integer id) 
		{
			this.id = id;
		}
		public String getChocostatus() 
		{
			return chocostatus;
		}
		public void setChocostatus(String chocostatus) 
		{
			this.chocostatus = chocostatus;
		}
		
		@Override
		public String toString() 
		{
			return "ChocolatesStatus [id=" + id + ", chocostatus=" + chocostatus + "]";
		}
		

		

}
