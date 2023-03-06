package fr.formation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement // Permet d'activer AOP sur les annotations @Transactional
public class JpaConfig {
	// Bean pour la DataSource (DBCP2)
	@Bean // Attention à ne pas oublier cette annotation ... sinon Spring ne va pas la créer / gérer
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springjpa");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setMaxTotal(10); // nb connexions simultanées autorisées
		
		return dataSource;
	}
	
	// Bean pour l'EntityManagerFactory
	@Bean
	public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		Properties props = new Properties();

		props.setProperty("hibernate.hbm2ddl", "update");
		props.setProperty("hibernate.show_sql", "true");
		
		emf.setDataSource(dataSource); // On donne la DataSource
		emf.setPackagesToScan("fr.formation.model"); // On donne la localisation des classes modèle
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter()); // On donne le fournisseur d'ORM
		emf.setJpaProperties(props); // On donne les propriétés JPA
		
		return emf;
	}
	
	
	// Bean pour le gestionnaire de transactions
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
