package mca.prices_rest_api.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mca.prices_rest_api.dtos.ParamsDTO;
import mca.prices_rest_api.services.PricesService;

/**
 *
 * An api controller
 */
@RestController
public class ApiController {

	@Autowired
	private PricesService pricesService;

	/**
	 * Este método recibe un DTO con los campos por los que hay que buscar
	 * 
	 * @param params Parametros de búsqueda
	 * @return resultado de la búsqueda
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/price", produces = "application/json")
	public JSONObject postPrice(@RequestBody ParamsDTO params) throws ParseException {
		
		JSONObject response = new JSONObject();
		
		try {
			response = pricesService.getPrice(params.getBrandId(), params.getProductId(),
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(params.getApplyDate()));
		}catch(ParseException e) {
			response.put("error", "La fecha indicada no corresponde con el formato: 'yyyy-MM-dd HH:mm:ss'");
		}
		return response;
		
	}
}
