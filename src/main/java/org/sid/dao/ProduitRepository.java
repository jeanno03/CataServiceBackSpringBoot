package org.sid.dao;

import java.util.Optional;

import org.sid.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
	
	Optional<Produit> findById(Long id);
	

}
