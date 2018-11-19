package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.domain.Cotisation;

//@Service //On se place ici dans le service Jpa
public class CotisationServiceMemoire implements CotisationService {

	private List<Cotisation> cotisations = new ArrayList<>();
	
	@Override
	public List<Cotisation> lister() {
		return cotisations;
	}

	@Override
	public Cotisation sauver(String code, String libelle, Boolean imposable, BigDecimal tauxPatronal,
			BigDecimal tauxSalarial) {
		
		Cotisation cotis = new Cotisation();
		cotis.setCode(code);
		cotis.setLibelle(libelle);
		cotis.setImposable(imposable);
		cotis.setTauxSalarial(tauxSalarial);
		cotis.setTauxPatronal(tauxPatronal);
		
		
		cotisations.add(cotis);
	
		return cotis;
	}
	
	@Override
	public void supprimer(Integer id) {
		
	}

}
