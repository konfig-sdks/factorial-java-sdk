# SupplementApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewSupplement**](SupplementApi.md#createNewSupplement) | **POST** /v1/payroll/supplements | Create supplements |
| [**deleteById**](SupplementApi.md#deleteById) | **DELETE** /v1/payroll/supplements/{id} | Delete supplements |
| [**getAll**](SupplementApi.md#getAll) | **GET** /v1/payroll/supplements | Get all supplements |
| [**updateById**](SupplementApi.md#updateById) | **PUT** /v1/payroll/supplements/{id} | Update supplements |


<a name="createNewSupplement"></a>
# **createNewSupplement**
> Supplement createNewSupplement().supplementCreateNewSupplementRequest(supplementCreateNewSupplementRequest).execute();

Create supplements

Create supplements

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SupplementApi;
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
    Integer amountInCents = 56;
    String effectiveOn = "effectiveOn_example";
    Integer contractsTaxonomyId = 56;
    Integer payrollPolicyPeriodId = 56;
    String unit = "unit_example";
    Integer contractsCompensationId = 56;
    try {
      Supplement result = client
              .supplement
              .createNewSupplement()
              .employeeId(employeeId)
              .amountInCents(amountInCents)
              .effectiveOn(effectiveOn)
              .contractsTaxonomyId(contractsTaxonomyId)
              .payrollPolicyPeriodId(payrollPolicyPeriodId)
              .unit(unit)
              .contractsCompensationId(contractsCompensationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getContractsCompensationId());
      System.out.println(result.getContractsTaxonomyId());
      System.out.println(result.getAmountInCents());
      System.out.println(result.getUnit());
      System.out.println(result.getEffectiveOn());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getDescriptionEntity());
      System.out.println(result.getCreatedByAccessId());
      System.out.println(result.getPayrollPolicyPeriodId());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#createNewSupplement");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Supplement> response = client
              .supplement
              .createNewSupplement()
              .employeeId(employeeId)
              .amountInCents(amountInCents)
              .effectiveOn(effectiveOn)
              .contractsTaxonomyId(contractsTaxonomyId)
              .payrollPolicyPeriodId(payrollPolicyPeriodId)
              .unit(unit)
              .contractsCompensationId(contractsCompensationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#createNewSupplement");
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
| **supplementCreateNewSupplementRequest** | [**SupplementCreateNewSupplementRequest**](SupplementCreateNewSupplementRequest.md)|  | [optional] |

### Return type

[**Supplement**](Supplement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="deleteById"></a>
# **deleteById**
> Supplement deleteById(id).execute();

Delete supplements

Delete supplements

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SupplementApi;
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
      Supplement result = client
              .supplement
              .deleteById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getContractsCompensationId());
      System.out.println(result.getContractsTaxonomyId());
      System.out.println(result.getAmountInCents());
      System.out.println(result.getUnit());
      System.out.println(result.getEffectiveOn());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getDescriptionEntity());
      System.out.println(result.getCreatedByAccessId());
      System.out.println(result.getPayrollPolicyPeriodId());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#deleteById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Supplement> response = client
              .supplement
              .deleteById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#deleteById");
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

[**Supplement**](Supplement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getAll"></a>
# **getAll**
> List&lt;Supplement&gt; getAll().execute();

Get all supplements

Get all supplements

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SupplementApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    try {
      List<Supplement> result = client
              .supplement
              .getAll()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#getAll");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Supplement>> response = client
              .supplement
              .getAll()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#getAll");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}

```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Supplement&gt;**](Supplement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateById"></a>
# **updateById**
> Supplement updateById(id).supplementUpdateByIdRequest(supplementUpdateByIdRequest).execute();

Update supplements

Update supplements

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.SupplementApi;
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
    Integer amountInCents = 56;
    String effectiveOn = "effectiveOn_example";
    Integer contractsTaxonomyId = 56;
    Integer payrollPolicyPeriodId = 56;
    String unit = "unit_example";
    Integer contractsCompensationId = 56;
    try {
      Supplement result = client
              .supplement
              .updateById(id)
              .employeeId(employeeId)
              .amountInCents(amountInCents)
              .effectiveOn(effectiveOn)
              .contractsTaxonomyId(contractsTaxonomyId)
              .payrollPolicyPeriodId(payrollPolicyPeriodId)
              .unit(unit)
              .contractsCompensationId(contractsCompensationId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getContractsCompensationId());
      System.out.println(result.getContractsTaxonomyId());
      System.out.println(result.getAmountInCents());
      System.out.println(result.getUnit());
      System.out.println(result.getEffectiveOn());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getDescriptionEntity());
      System.out.println(result.getCreatedByAccessId());
      System.out.println(result.getPayrollPolicyPeriodId());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#updateById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Supplement> response = client
              .supplement
              .updateById(id)
              .employeeId(employeeId)
              .amountInCents(amountInCents)
              .effectiveOn(effectiveOn)
              .contractsTaxonomyId(contractsTaxonomyId)
              .payrollPolicyPeriodId(payrollPolicyPeriodId)
              .unit(unit)
              .contractsCompensationId(contractsCompensationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling SupplementApi#updateById");
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
| **supplementUpdateByIdRequest** | [**SupplementUpdateByIdRequest**](SupplementUpdateByIdRequest.md)|  | [optional] |

### Return type

[**Supplement**](Supplement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

