[1mdiff --git a/src/main/java/com/sunshine/PSC/PscApplication.java b/src/main/java/com/sunshine/PSC/PscApplication.java[m
[1mindex 3fab3b1..5877933 100644[m
[1m--- a/src/main/java/com/sunshine/PSC/PscApplication.java[m
[1m+++ b/src/main/java/com/sunshine/PSC/PscApplication.java[m
[36m@@ -36,11 +36,11 @@[m [mpublic class PscApplication implements CommandLineRunner {[m
 		Quarto q2 = new Quarto("Quarto 202", 2, "Casal", StatusQuarto.disponivel);[m
 		Quarto q3 = new Quarto("Quarto 303", 4, "Misto", StatusQuarto.disponivel);[m
 		[m
[31m-		Cliente c1 = new Cliente("Adalberto", "057.665.234-03", "Adalberto@teste.com", "$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");[m
[32m+[m		[32mCliente c1 = new Cliente("Adalberto", "410.211.230-80", "Adalberto@teste.com", "$2a$10$UActTpkVD9GI5xwSC/F3vus46CGqFIScgLG9011m6lTB8KMdNhZXO");[m
 [m
 		quartoDao.saveAll(Arrays.asList(q1, q2, q3));[m
 		clienteDao.save(c1);[m
 [m
 	}[m
 [m
[31m-}[m
\ No newline at end of file[m
[32m+[m[32m}[m
[1mdiff --git a/src/main/resources/application.properties b/src/main/resources/application.properties[m
[1mindex c160164..29e0a5c 100644[m
[1m--- a/src/main/resources/application.properties[m
[1m+++ b/src/main/resources/application.properties[m
[36m@@ -14,14 +14,4 @@[m [mspring.jpa.hibernate.ddl-auto=update[m
 spring.jpa.show-sql=true[m
 spring.jpa.properties.hibernate.format_sql=true[m
 spring.jpa.open-in-view=true[m
[31m-=======[m
[31m-spring.datasource.url=jdbc:h2:mem:testdb[m
[31m-spring.datasource.username=sa[m
[31m-spring.datasource.password=[m
[31m-[m
[31m-spring.h2.console.enabled=true[m
[31m-spring.h2.console.path=/h2-Console[m
 [m
[31m-spring.jpa.show-sql=true[m
[31m-spring.jpa.properties.hibernate.format_sql=true[m
[31m->>>>>>> master[m
