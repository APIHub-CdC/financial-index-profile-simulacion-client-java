package io.FinancialIndexProfileSimulacion.client.api;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.FinancialIndexProfileSimulacion.client.ApiClient;
import io.FinancialIndexProfileSimulacion.client.ApiException;
import io.FinancialIndexProfileSimulacion.client.ApiResponse;
import io.FinancialIndexProfileSimulacion.client.Configuration;
import io.FinancialIndexProfileSimulacion.client.Pair;
import io.FinancialIndexProfileSimulacion.client.ProgressRequestBody;
import io.FinancialIndexProfileSimulacion.client.ProgressResponseBody;
import io.FinancialIndexProfileSimulacion.client.model.Respuesta;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MadurezApi {
    private ApiClient apiClient;
    public MadurezApi() {
        this(Configuration.getDefaultApiClient());
    }
    public MadurezApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call madurezCall(String xApiKey, String folioConsulta, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/{folioConsulta}"
            .replaceAll("\\{" + "folioConsulta" + "\\}", apiClient.escapeString(folioConsulta.toString()));
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    private okhttp3.Call madurezValidateBeforeCall(String xApiKey, String folioConsulta, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling madurez(Async)");
        }
        if (folioConsulta == null) {
            throw new ApiException("Missing the required parameter 'folioConsulta' when calling madurez(Async)");
        }
        
        okhttp3.Call call = madurezCall(xApiKey, folioConsulta, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta madurez(String xApiKey, String folioConsulta) throws ApiException {
        ApiResponse<Respuesta> resp = madurezWithHttpInfo(xApiKey, folioConsulta);
        return resp.getData();
    }
    
    public ApiResponse<Respuesta> madurezWithHttpInfo(String xApiKey, String folioConsulta) throws ApiException {
        okhttp3.Call call = madurezValidateBeforeCall(xApiKey, folioConsulta, null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
}
