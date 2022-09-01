package mca.prices_rest_api.services;

import java.util.Date;

import org.json.simple.JSONObject;

public interface PricesService {

	/**
	 * 
	 * Devuelve los precios que se tienen que aplicar para un producto determinado
	 * en una fecha determinada
	 * 
	 * @param brandId
	 * @param productId
	 * @param applyDate
	 * @return
	 */
	public JSONObject getPrices(int brandId, int productId, Date applyDate);

}
