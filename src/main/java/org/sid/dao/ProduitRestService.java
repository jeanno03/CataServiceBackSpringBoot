package org.sid.dao;

import java.util.List;
import java.util.Optional;

import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	public List<Produit> listProduit(){
		return produitRepository.findAll();
	}

	@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	public Optional<Produit> getProduit(@PathVariable ("id")Long id){
		return produitRepository.findById(id);
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.POST)
	public Produit save(@RequestBody Produit p) {
		return produitRepository.save(p);
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT)
	public Produit update(@RequestBody Produit p, @PathVariable Long id) {
		p.setId(id);
		return produitRepository.saveAndFlush(p);
	}	
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		produitRepository.deleteById(id);
	}
	
}
