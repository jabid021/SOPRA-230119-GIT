package fr.formation.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // Classe d'Aspect
public class TransactionAspect {
//	@Before("execution(* fr.formation.dao.DAOBiome.save(..))")
	@Before("@within(fr.formation.annotation.CustomTransactional)")
	public void beforeSave() {
		System.out.println("DEMARRAGE DE LA TRANSACTION ...");
	}
	
//	@After("execution(* fr.formation.dao.DAOBiome.save(..))")
	@After("@within(fr.formation.annotation.CustomTransactional)")
	public void afterSave() {
		System.out.println("COMMIT DE LA TRANSACTION ...");
	}
}
