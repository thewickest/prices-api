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
	public JSONObject getPrices(int brandId, int productId, Date applyDate) {

		List<Price> prices = pricesDao.findAllByBrandProductAndApplyDate(brandId, productId, applyDate);
		JSONObject jsonPrice = new JSONObject();

		if (prices != null && !prices.isEmpty()) {
			Price p = pricesDao.findAllByBrandProductAndApplyDate(brandId, productId, applyDate).get(0);

			jsonPrice.put("product_id", p.getProductId());
			jsonPrice.put("brand_id", p.getBrandId());
			jsonPrice.put("prices_list", p.getPriceId());
			jsonPrice.put("start_date", p.getStartDate().toString());
			jsonPrice.put("end_date", p.getEndDate().toString());
			jsonPrice.put("price", p.getPrice() + " " + p.getCurrency());
		} else {
			jsonPrice.put("error", "No prices found");
		}

		return jsonPrice;
	}
}
