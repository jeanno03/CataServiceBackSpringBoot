package org.sid.dao;

import java.util.Optional;

import org.sid.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
	
	public Optional<Produit> findById(Long id);
	
	@Query("select p from Produit p where LOWER(p.designation) like :x")
	public Page<Produit> chercherProduits(@Param("x")String mc, Pageable pageable);
	

}
