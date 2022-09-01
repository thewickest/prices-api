package mca.prices_rest_api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "PRICES")
@Data
public class Price {

	@Column(name = "brand_id")
	private int brandId;
	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startDate;
	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	@Id
	@Column(name = "prices_list")
	private int priceId;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "priority")
	private int priority;
	@Column(name = "price")
	private double price;
	@Column(name = "currency")
	private String currency;

	public Price() {
		super();
	}

	public Price(int brandId, Date startDate, Date endDate, int priceId, int productId, int priority, double price,
			String currency) {
		super();
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceId = priceId;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.currency = currency;
	}
}
