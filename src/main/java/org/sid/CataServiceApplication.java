package org.sid;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataServiceApplication {
	
	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataServiceApplication.class, args);
	ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
	produitRepository.save(new Produit("Lx 564",900,23));
	produitRepository.save(new Produit("Lx 565",800,27));
	produitRepository.save(new Produit("Lx 567",100,100));
	
	List<Produit> prods = produitRepository.findAll();
	prods.forEach(p->System.out.println(p.getDesignation()));
	}

}
