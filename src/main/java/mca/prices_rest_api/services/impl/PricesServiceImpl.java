package mca.prices_rest_api.services.impl;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mca.prices_rest_api.dao.PricesDao;
import mca.prices_rest_api.entity.Price;
import mca.prices_rest_api.services.PricesService;

@Service
@SuppressWarnings("unchecked")
public class PricesServiceImpl implements PricesService {

	@Autowired
	private PricesDao pricesDao;

	@Override
	public JSONObject getPrice(int brandId, int productId, Date applyDate) {

		List<Price> prices = pricesDao.getPriceByBrandProductAndApplyDate(brandId, productId, applyDate);
		JSONObject jsonPrice = new JSONObject();

		if (prices != null && !prices.isEmpty()) {
			
			Price price = prices.get(0);

			jsonPrice.put("product_id", price.getProductId());
			jsonPrice.put("brand_id", price.getBrandId());
			jsonPrice.put("prices_list", price.getPriceId());
			jsonPrice.put("start_date", price.getStartDate().toString());
			jsonPrice.put("end_date", price.getEndDate().toString());
			jsonPrice.put("price", price.getPrice() + " " + price.getCurrency());
		} else {
			jsonPrice.put("error", "No prices found");
		}

		return jsonPrice;
	}
}
