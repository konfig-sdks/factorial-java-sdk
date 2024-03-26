# CompensationApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createContractCompensation**](CompensationApi.md#createContractCompensation) | **POST** /v1/payroll/compensations | Create a compensation |
| [**deleteCompensation**](CompensationApi.md#deleteCompensation) | **DELETE** /v1/payroll/compensations/{id} | Delete a Compensation |
| [**getById**](CompensationApi.md#getById) | **GET** /v1/payroll/compensations/{id} | Get a compensation |
| [**getCompensations**](CompensationApi.md#getCompensations) | **GET** /v1/payroll/compensations | Get Compensations |
| [**updateForContract**](CompensationApi.md#updateForContract) | **PUT** /v1/payroll/compensations/{id} | Updates a compensation |


<a name="createContractCompensation"></a>
# **createContractCompensation**
> Compensation createContractCompensation().compensationCreateContractCompensationRequest(compensationCreateContractCompensationRequest).execute();

Create a compensation

Creates a compensation for a contract.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CompensationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer contractVersionId = 56;
    String description = "description_example";
    Integer contractsTaxonomyId = 56;
    String compensationType = "fixed";
    Integer amount = 56;
    String unit = "money";
    Boolean syncWithSupplements = true;
    Integer payrollPolicyId = 56;
    Integer recurrenceCount = 56;
    String startsOn = "startsOn_example";
    String recurrence = "monthly";
    String firstPaymentOn = "firstPaymentOn_example";
    String calculation = "current_period";
    try {
      Compensation result = client
              .compensation
              .createContractCompensation(contractVersionId)
              .description(description)
              .contractsTaxonomyId(contractsTaxonomyId)
              .compensationType(compensationType)
              .amount(amount)
              .unit(unit)
              .syncWithSupplements(syncWithSupplements)
              .payrollPolicyId(payrollPolicyId)
              .recurrenceCount(recurrenceCount)
              .startsOn(startsOn)
              .recurrence(recurrence)
              .firstPaymentOn(firstPaymentOn)
              .calculation(calculation)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getContractVersionId());
      System.out.println(result.getCompensationType());
      System.out.println(result.getAmount());
      System.out.println(result.getRecurrence());
      System.out.println(result.getFirstPaymentOn());
      System.out.println(result.getSyncWithSupplements());
      System.out.println(result.getContractsTaxonomyId());
      System.out.println(result.getPayrollPolicyId());
      System.out.println(result.getRecurrenceCount());
      System.out.println(result.getStartsOn());
      System.out.println(result.getUnit());
      System.out.println(result.getCalculation());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#createContractCompensation");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Compensation> response = client
              .compensation
              .createContractCompensation(contractVersionId)
              .description(description)
              .contractsTaxonomyId(contractsTaxonomyId)
              .compensationType(compensationType)
              .amount(amount)
              .unit(unit)
              .syncWithSupplements(syncWithSupplements)
              .payrollPolicyId(payrollPolicyId)
              .recurrenceCount(recurrenceCount)
              .startsOn(startsOn)
              .recurrence(recurrence)
              .firstPaymentOn(firstPaymentOn)
              .calculation(calculation)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#createContractCompensation");
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
| **compensationCreateContractCompensationRequest** | [**CompensationCreateContractCompensationRequest**](CompensationCreateContractCompensationRequest.md)|  | [optional] |

### Return type

[**Compensation**](Compensation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="deleteCompensation"></a>
# **deleteCompensation**
> List&lt;Compensation&gt; deleteCompensation(id).execute();

Delete a Compensation

Delete a compensation

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CompensationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer id = 1; // (Required)
    try {
      List<Compensation> result = client
              .compensation
              .deleteCompensation(id)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#deleteCompensation");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Compensation>> response = client
              .compensation
              .deleteCompensation(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#deleteCompensation");
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
| **id** | **Integer**| (Required) | |

### Return type

[**List&lt;Compensation&gt;**](Compensation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getById"></a>
# **getById**
> Compensation getById(id).execute();

Get a compensation

This endpoint allows you to retrieve a compensation by id

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CompensationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer id = 1;
    try {
      Compensation result = client
              .compensation
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getContractVersionId());
      System.out.println(result.getCompensationType());
      System.out.println(result.getAmount());
      System.out.println(result.getRecurrence());
      System.out.println(result.getFirstPaymentOn());
      System.out.println(result.getSyncWithSupplements());
      System.out.println(result.getContractsTaxonomyId());
      System.out.println(result.getPayrollPolicyId());
      System.out.println(result.getRecurrenceCount());
      System.out.println(result.getStartsOn());
      System.out.println(result.getUnit());
      System.out.println(result.getCalculation());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Compensation> response = client
              .compensation
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#getById");
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
| **id** | **Integer**|  | |

### Return type

[**Compensation**](Compensation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getCompensations"></a>
# **getCompensations**
> List&lt;Compensation&gt; getCompensations().ids(ids).contractVersionIds(contractVersionIds).execute();

Get Compensations

This endpoint allows you to retrieve compensations for a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CompensationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    List<Integer> ids = Arrays.asList(); // Compensations id array
    List<Integer> contractVersionIds = Arrays.asList(); // Contract versions id array
    try {
      List<Compensation> result = client
              .compensation
              .getCompensations()
              .ids(ids)
              .contractVersionIds(contractVersionIds)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#getCompensations");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Compensation>> response = client
              .compensation
              .getCompensations()
              .ids(ids)
              .contractVersionIds(contractVersionIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#getCompensations");
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
| **ids** | [**List&lt;Integer&gt;**](Integer.md)| Compensations id array | [optional] |
| **contractVersionIds** | [**List&lt;Integer&gt;**](Integer.md)| Contract versions id array | [optional] |

### Return type

[**List&lt;Compensation&gt;**](Compensation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateForContract"></a>
# **updateForContract**
> Compensation updateForContract(id).compensationUpdateForContractRequest(compensationUpdateForContractRequest).execute();

Updates a compensation

Updates a compensation for a contract.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CompensationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer id = 1;
    String description = "description_example";
    Integer contractsTaxonomyId = 56;
    String compensationType = "fixed";
    Integer amount = 56;
    String unit = "money";
    Boolean syncWithSupplements = true;
    Integer payrollPolicyId = 56;
    Integer recurrenceCount = 56;
    String startsOn = "startsOn_example";
    String recurrence = "monthly";
    String firstPaymentOn = "firstPaymentOn_example";
    String calculation = "current_period";
    try {
      Compensation result = client
              .compensation
              .updateForContract(id)
              .description(description)
              .contractsTaxonomyId(contractsTaxonomyId)
              .compensationType(compensationType)
              .amount(amount)
              .unit(unit)
              .syncWithSupplements(syncWithSupplements)
              .payrollPolicyId(payrollPolicyId)
              .recurrenceCount(recurrenceCount)
              .startsOn(startsOn)
              .recurrence(recurrence)
              .firstPaymentOn(firstPaymentOn)
              .calculation(calculation)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getContractVersionId());
      System.out.println(result.getCompensationType());
      System.out.println(result.getAmount());
      System.out.println(result.getRecurrence());
      System.out.println(result.getFirstPaymentOn());
      System.out.println(result.getSyncWithSupplements());
      System.out.println(result.getContractsTaxonomyId());
      System.out.println(result.getPayrollPolicyId());
      System.out.println(result.getRecurrenceCount());
      System.out.println(result.getStartsOn());
      System.out.println(result.getUnit());
      System.out.println(result.getCalculation());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#updateForContract");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Compensation> response = client
              .compensation
              .updateForContract(id)
              .description(description)
              .contractsTaxonomyId(contractsTaxonomyId)
              .compensationType(compensationType)
              .amount(amount)
              .unit(unit)
              .syncWithSupplements(syncWithSupplements)
              .payrollPolicyId(payrollPolicyId)
              .recurrenceCount(recurrenceCount)
              .startsOn(startsOn)
              .recurrence(recurrence)
              .firstPaymentOn(firstPaymentOn)
              .calculation(calculation)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CompensationApi#updateForContract");
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
| **id** | **Integer**|  | |
| **compensationUpdateForContractRequest** | [**CompensationUpdateForContractRequest**](CompensationUpdateForContractRequest.md)|  | [optional] |

### Return type

[**Compensation**](Compensation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

