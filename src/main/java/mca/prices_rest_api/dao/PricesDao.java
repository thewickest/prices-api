package mca.prices_rest_api.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mca.prices_rest_api.entity.Price;

public interface PricesDao extends JpaRepository<Price, Long> {

	/**
	 * 
	 * Extrae una lista de precios filtrados por brandId y productId 
	 * con la fecha de aplicaion contenida entre Fecha de Inicio y Fecha Fin
	 * 
	 * @param brandId
	 * @param productId
	 * @param applyDate
	 * @return
	 */	
	@Query(value = "SELECT p FROM Price p WHERE p.brandId = ?1 AND p.productId = ?2 AND p.startDate <= ?3 AND p.endDate > ?3 ORDER BY p.priority DESC")
	public List<Price> findAllByBrandProductAndApplyDate(int brandId, int productId, Date applyDate);

}
