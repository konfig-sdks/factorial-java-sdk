# IntegrationApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deletePayrollCode**](IntegrationApi.md#deletePayrollCode) | **DELETE** /v2/payroll_integrations/codes/{id} | Delete a Payroll Integration Code |
| [**getAllCodes**](IntegrationApi.md#getAllCodes) | **GET** /v2/payroll_integrations/codes | Get all codes for a specific Integration |
| [**updatePayrollCode**](IntegrationApi.md#updatePayrollCode) | **PATCH** /v2/payroll_integrations/codes/{id} | Update a Payroll Integration Code |


<a name="deletePayrollCode"></a>
# **deletePayrollCode**
> Code deletePayrollCode(id).execute();

Delete a Payroll Integration Code

Deletes an existing payroll code

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.IntegrationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "3"; // (Required)
    try {
      Code result = client
              .integration
              .deletePayrollCode(id)
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
      System.err.println("Exception when calling IntegrationApi#deletePayrollCode");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Code> response = client
              .integration
              .deletePayrollCode(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling IntegrationApi#deletePayrollCode");
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
| **id** | **String**| (Required) | |

### Return type

[**Code**](Code.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getAllCodes"></a>
# **getAllCodes**
> List&lt;Code&gt; getAllCodes().integration(integration).code(code).execute();

Get all codes for a specific Integration

This endpoint allows fetching all available Codes, scoped to the integration name

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.IntegrationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String integration = "a3innuva"; // Payroll Integration name
    String code = "TEST_CODE"; // Unique identifier to relate Factorial with different payroll softwares
    try {
      List<Code> result = client
              .integration
              .getAllCodes()
              .integration(integration)
              .code(code)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IntegrationApi#getAllCodes");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Code>> response = client
              .integration
              .getAllCodes()
              .integration(integration)
              .code(code)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling IntegrationApi#getAllCodes");
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
| **integration** | **String**| Payroll Integration name | [optional] [enum: a3innuva, a3nom, silae, datev, zuccheti, kombo, parieh] |
| **code** | **String**| Unique identifier to relate Factorial with different payroll softwares | [optional] |

### Return type

[**List&lt;Code&gt;**](Code.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updatePayrollCode"></a>
# **updatePayrollCode**
> Code updatePayrollCode(id).integrationUpdatePayrollCodeRequest(integrationUpdatePayrollCodeRequest).execute();

Update a Payroll Integration Code

Update a Payroll Integration Code

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.IntegrationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "3"; // (Required)
    Integer id = 56;
    String code = "code_example";
    try {
      Code result = client
              .integration
              .updatePayrollCode(id)
              .id(id)
              .code(code)
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
      System.err.println("Exception when calling IntegrationApi#updatePayrollCode");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Code> response = client
              .integration
              .updatePayrollCode(id)
              .id(id)
              .code(code)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling IntegrationApi#updatePayrollCode");
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
| **id** | **String**| (Required) | |
| **integrationUpdatePayrollCodeRequest** | [**IntegrationUpdatePayrollCodeRequest**](IntegrationUpdatePayrollCodeRequest.md)|  | [optional] |

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
| **200** | OK |  -  |

