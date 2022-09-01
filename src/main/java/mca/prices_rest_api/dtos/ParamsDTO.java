package mca.prices_rest_api.dtos;

import java.io.Serializable;

import lombok.Data;

@Data
public class ParamsDTO implements Serializable {

	private static final long serialVersionUID = 3241079598564122030L;

	private int brandId;
	private int productId;
	private String applyDate;

}
