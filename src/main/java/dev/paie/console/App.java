package dev.paie.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.paie.ihm.Menu;

/**
 * 1- Ajouter dépendence spring-context
 * 2- Créer un context (pas de context, pas de spring) -> ici context annotation
 * 3- Configurer le context soit à partir d'une classe soit à partir d'un fichier .xml (ici une classe).
 *
 */
public class App {
	
	
	public static void main(String[] args) {
		
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)){ // auto-closable
			
			Menu menu = context.getBean(Menu.class);
			menu.demarrer();
			
		}
		
//		Scanner scanner = new Scanner(System.in);
//		CotisationService cotisService = new CotisationServiceMemoire();
//		
//		Menu menu = new Menu(scanner, cotisService);
//		menu.demarrer();
//	
//		scanner.close();
	}
}
