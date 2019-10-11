package com.regis.cachenamemoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CacheNaMemoriaApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(CacheNaMemoriaApplication.class, args);
		
		CacheNaMemoriaApplication crunchifyCache = new CacheNaMemoriaApplication();
		 
        System.out.println("\n\n==========Test1: crunchifyTestAddRemoveObjects ==========");
        crunchifyCache.crunchifyTestAddRemoveObjects();
        System.out.println("\n\n==========Test2: crunchifyTestExpiredCacheObjects ==========");
        crunchifyCache.crunchifyTestExpiredCacheObjects();
        System.out.println("\n\n==========Test3: crunchifyTestObjectsCleanupTime ==========");
        crunchifyCache.crunchifyTestObjectsCleanupTime();
	}
	
	private void crunchifyTestAddRemoveObjects() {
        // Teste com crunchifyTimeToLive = 200 segundos
        // crunchifyTimerInterval = 500 segundos
        // maxItems = 6
        CrunchifyInMemoryCache<String, String> cache = new CrunchifyInMemoryCache<String, String>(200, 500, 6);
 
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("IBM", "IBM");
        cache.put("Facebook", "Facebook");
        System.out.println("6 objetos adicionados no cache.. cache.size(): " + cache.size());
        System.out.println("Cache: " + cache + "\n");
        
        cache.remove("IBM");
        System.out.println("1 objeto removido do cache... cache.size(): " + cache.size());
        System.out.println("Cache: " + cache + "\n");
        
        cache.put("Twitter", "Twitter");
        cache.put("SAP", "SAP");
        System.out.println("2 objetos adicionados no cache, mas chegou ao maxItems... cache.size(): " + cache.size());
        System.out.println("Cache: " + cache + "\n");
    }
	
	private void crunchifyTestExpiredCacheObjects() throws InterruptedException {
		 
        // Teste com crunchifyTimeToLive = 1 segundo
        // crunchifyTimerInterval = 1 segundo
        // maxItems = 10
        CrunchifyInMemoryCache<String, String> cache = new CrunchifyInMemoryCache<String, String>(1, 1, 10);
 
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        System.out.println("Cache: " + cache + "\n");
        // Adicionando 3 segundos sleep.. Os dois objetos acima serão removidos do
        // Cache devido ao valor timeToLiveInSeconds
        Thread.sleep(3000);
 
        System.out.println("2 objetos foram adicionados, mas alcançaram o timeToLive... cache.size(): " + cache.size());
        System.out.println("Cache: " + cache + "\n");
 
    }
 
    private void crunchifyTestObjectsCleanupTime() throws InterruptedException {
        int size = 500000;
 
        // Teste com timeToLiveInSeconds = 2 segundos
        // timerIntervalInSeconds = 2 segundos
        // maxItems = 500000
 
        CrunchifyInMemoryCache<String, String> cache = new CrunchifyInMemoryCache<String, String>(2, 2, 500000);
 
        for (int i = 0; i < size; i++) {
            String value = Integer.toString(i);
            cache.put(value, value);
        }

        System.out.println("Inseridos 500000 objetos no cache... cache.size(): " + cache.size());

        Thread.sleep(5000);
        
        System.out.println("Removendo objetos do cache... cache.size(): " + cache.size());
    }

}