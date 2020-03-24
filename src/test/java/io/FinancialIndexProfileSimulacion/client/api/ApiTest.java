package io.FinancialIndexProfileSimulacion.client.api;

import io.FinancialIndexProfileSimulacion.client.ApiClient;
import io.FinancialIndexProfileSimulacion.client.ApiException;
import io.FinancialIndexProfileSimulacion.client.api.ApiTest;
import io.FinancialIndexProfileSimulacion.client.api.MadurezApi;
import io.FinancialIndexProfileSimulacion.client.model.Respuesta;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;

import java.util.concurrent.TimeUnit;

public class ApiTest {
	
	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());
	 private final MadurezApi api = new MadurezApi();
	private ApiClient apiClient = null;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
		apiClient.setHttpClient(okHttpClient);
	}
    
    @Test
    public void madurezTest() throws ApiException {
    	
    	String xApiKey = "your_api_key";
        String folioConsulta = "000000000";
        
		try {
			Respuesta response = api.madurez(xApiKey, folioConsulta);
	        Assert.assertTrue(response != null);
	        if(response != null) {
	        	logger.info(response.toString());
	        }
		} catch (ApiException e) {
			logger.info(e.getResponseBody());
		}
    }
    
}
