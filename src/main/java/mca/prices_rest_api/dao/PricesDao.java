package mca.prices_rest_api.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mca.prices_rest_api.entity.Price;

@Repository
public interface PricesDao extends JpaRepository<Price, Long> {

	@Query(value = "SELECT p FROM Price p WHERE p.brandId = ?1 AND p.productId = ?2 AND p.startDate <= ?3 AND p.endDate > ?3 ORDER BY p.priority DESC")
	public List<Price> findAllByBrandProductAndApplyDate(int brandId, int productId, Date applyDate);

}
