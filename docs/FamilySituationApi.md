# FamilySituationApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNew**](FamilySituationApi.md#createNew) | **POST** /v1/payroll/family_situation | Create a Family Situation |
| [**updateFamilySituation**](FamilySituationApi.md#updateFamilySituation) | **PUT** /v1/payroll/family_situation/{id} | Update a Family Situation |


<a name="createNew"></a>
# **createNew**
> FamilySituation createNew().familySituationCreateNewRequest(familySituationCreateNewRequest).execute();

Create a Family Situation

Create a Family Situation

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.FamilySituationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer employeeId = 56;
    String civilStatus = "single";
    Integer numberOfDependants = 56;
    try {
      FamilySituation result = client
              .familySituation
              .createNew(employeeId, civilStatus)
              .numberOfDependants(numberOfDependants)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCivilStatus());
      System.out.println(result.getNumberOfDependants());
    } catch (ApiException e) {
      System.err.println("Exception when calling FamilySituationApi#createNew");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<FamilySituation> response = client
              .familySituation
              .createNew(employeeId, civilStatus)
              .numberOfDependants(numberOfDependants)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling FamilySituationApi#createNew");
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
| **familySituationCreateNewRequest** | [**FamilySituationCreateNewRequest**](FamilySituationCreateNewRequest.md)|  | [optional] |

### Return type

[**FamilySituation**](FamilySituation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="updateFamilySituation"></a>
# **updateFamilySituation**
> FamilySituation updateFamilySituation(id).familySituationUpdateFamilySituationRequest(familySituationUpdateFamilySituationRequest).execute();

Update a Family Situation

Update a Family Situation

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.FamilySituationApi;
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
    Integer employeeId = 56;
    String civilStatus = "single";
    Integer numberOfDependants = 56;
    try {
      FamilySituation result = client
              .familySituation
              .updateFamilySituation(id)
              .employeeId(employeeId)
              .civilStatus(civilStatus)
              .numberOfDependants(numberOfDependants)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCivilStatus());
      System.out.println(result.getNumberOfDependants());
    } catch (ApiException e) {
      System.err.println("Exception when calling FamilySituationApi#updateFamilySituation");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<FamilySituation> response = client
              .familySituation
              .updateFamilySituation(id)
              .employeeId(employeeId)
              .civilStatus(civilStatus)
              .numberOfDependants(numberOfDependants)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling FamilySituationApi#updateFamilySituation");
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
| **familySituationUpdateFamilySituationRequest** | [**FamilySituationUpdateFamilySituationRequest**](FamilySituationUpdateFamilySituationRequest.md)|  | [optional] |

### Return type

[**FamilySituation**](FamilySituation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

