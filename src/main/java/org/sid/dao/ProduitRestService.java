package org.sid.dao;

import java.util.List;
import java.util.Optional;

import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitRestService {
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	public Page<Produit> listProduit(int page, int size){
		return produitRepository.findAll(new PageRequest(page, size));
	}
	
	@RequestMapping(value="/chercherProduits",method=RequestMethod.GET)
	public Page<Produit> chercher(
			String mc, 
			@RequestParam(name="page", defaultValue="0")int page, 
			@RequestParam(name="size", defaultValue="5")int size){
		return produitRepository.chercherProduits("%"+mc+"%", new PageRequest(page, size));
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
