# IntegrationCodeApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createPayrollIntegrationCode**](IntegrationCodeApi.md#createPayrollIntegrationCode) | **POST** /v2/payroll_integrations/codes | Create a Payroll Integration Code |


<a name="createPayrollIntegrationCode"></a>
# **createPayrollIntegrationCode**
> Code createPayrollIntegrationCode().integrationCodeCreatePayrollIntegrationCodeRequest(integrationCodeCreatePayrollIntegrationCodeRequest).execute();

Create a Payroll Integration Code

This endpoint allows you create and store Payroll Integrations Codes in Factorial.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.IntegrationCodeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String code = "code_example";
    Integer codeableId = 56;
    String codeableType = "Company";
    String integration = "a3innuva";
    Boolean forfaitJours = true;
    try {
      Code result = client
              .integrationCode
              .createPayrollIntegrationCode(code, codeableId, codeableType, integration)
              .forfaitJours(forfaitJours)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getCodeableId());
      System.out.println(result.getIntegration());
      System.out.println(result.getCodeableType());
      System.out.println(result.getCode());
      System.out.println(result.getCompanyId());
      System.out.println(result.getForfaitJours());
    } catch (ApiException e) {
      System.err.println("Exception when calling IntegrationCodeApi#createPayrollIntegrationCode");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Code> response = client
              .integrationCode
              .createPayrollIntegrationCode(code, codeableId, codeableType, integration)
              .forfaitJours(forfaitJours)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling IntegrationCodeApi#createPayrollIntegrationCode");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **integrationCodeCreatePayrollIntegrationCodeRequest** | [**IntegrationCodeCreatePayrollIntegrationCodeRequest**](IntegrationCodeCreatePayrollIntegrationCodeRequest.md)|  | [optional] |

### Return type

[**Code**](Code.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

