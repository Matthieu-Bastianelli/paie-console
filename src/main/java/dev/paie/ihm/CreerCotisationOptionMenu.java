package dev.paie.ihm;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class CreerCotisationOptionMenu extends OptionMenu {

	@Autowired
	private Scanner scanner;
	
	@Autowired
	private CotisationService cotisService;

	public CreerCotisationOptionMenu(Scanner scanner) {
		super("Créer une cotisation");
		this.scanner = scanner;
	}

	@Override
	public void executer() {
		
		System.out.println("Création en cours");
		
		System.out.println("Veuillez saisir le code : ");

		String codeSaisie = this.scanner.next();
		
		System.out.println("Vous avez saisie :" + codeSaisie);
		

		System.out.println("Veuillez saisir le libelle : ");

		String libelleSaisi = this.scanner.next();

		System.out.println("Vous avez saisie :" + libelleSaisi);
		
		System.out.println("indiquer si la cotisation est imposable (i) ou non imposable (ni)");

		String imposableString = this.scanner.next();
		Boolean imposableSaisi=(imposableString.equals("i"))? true : false;
		
		System.out.println("Vous avez saisie :" + imposableSaisi);

		System.out.println("indiquer le montant du taux patronal de la cotisation :");
		
		String tauxPratonalString = this.scanner.next();
		BigDecimal tauxPratonalSaisi = new BigDecimal(tauxPratonalString);
//		BigDecimal tauxPratonalSaisi = this.scanner.nextBigDecimal();
//		System.out.println("Vous avez saisie :" + tauxPratonalSaisi);
		

		System.out.println("indiquer le montant du taux salarial de la cotisation :");
		
		String tauxSalarialString = this.scanner.next();
		BigDecimal tauxSalarialSaisi = new BigDecimal(tauxSalarialString);
//		BigDecimal tauxSalarialSaisi = this.scanner.nextBigDecimal();
//		System.out.println("Vous avez saisie :" + tauxSalarialSaisi);
	
//		
//		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class); 
		
		cotisService.sauver(codeSaisie, libelleSaisi, imposableSaisi, tauxPratonalSaisi, tauxSalarialSaisi);
		
	}

}
