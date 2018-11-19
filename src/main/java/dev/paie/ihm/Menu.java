package dev.paie.ihm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import dev.paie.service.CotisationService;

@Controller
public class Menu {

	private Map<Integer, OptionMenu> options = new HashMap<>();
	private Scanner scanner;

//	@Autowired
//	private ApplicationContext context; // On l'a intégré en entré de méthode.

	// @Autowired cet autowired est un élément par défaut, il n'est pas nécessaire
	// de le repréciser.
	public Menu(Scanner scanner, CotisationService cotisService, ApplicationContext context) {
		init(scanner, cotisService, context);
		this.scanner = scanner;
	}

	private void init(Scanner scanner, CotisationService cotisService, ApplicationContext context) {

		// Je cherche tous les beans de type Option Recherche. Je les associe à une clé
		// (String) indiquant l'identifiant spring du bean.
		Map<String, OptionMenu> beansTrouves = context.getBeansOfType(OptionMenu.class);

		// ==========================================================
		// Méthode avec for :

		Collection<OptionMenu> optionsTrouve = beansTrouves.values();

		int i = 1;

		for (OptionMenu opt : optionsTrouve) {
			this.options.put(i, opt);
			i++;
		}

//		//==========================================================
//		// Méthode sans le for :
//		// Création d'un incrément
//		// remplace le i++ à cause de la lambda.
//		AtomicInteger increment = new AtomicInteger();
//		beansTrouves.forEach((idSpring, valeur) -> {
//			this.options.put(increment.incrementAndGet(), valeur);
//		});
//
//		//==========================================================

//		this.options.put(1, new ListerCotisationsOptionMenu(cotisService));
//		this.options.put(2, new CreerCotisationOptionMenu(scanner));
	}

	public void demarrer() {

		while (true) {

			// Afficher les libellés des options
			this.options.forEach((key, option) -> {
				System.out.println(key + ". " + option.getLibelle());
			});

			int optionMenuChoisie = this.scanner.nextInt();

			this.options.get(optionMenuChoisie).executer();

		}

	}

}
