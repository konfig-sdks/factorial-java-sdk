# ContractVersionApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewVersion**](ContractVersionApi.md#createNewVersion) | **POST** /v1/payroll/contract_versions | Create contract versions |
| [**getAllVersions**](ContractVersionApi.md#getAllVersions) | **GET** /v1/payroll/contract_versions | Get all contract versions |
| [**getBulkVersions**](ContractVersionApi.md#getBulkVersions) | **POST** /v2/core/bulk/contract_version | Get Bulk Contract Versions |


<a name="createNewVersion"></a>
# **createNewVersion**
> ContractVersion createNewVersion().contractVersionCreateNewVersionRequest(contractVersionCreateNewVersionRequest).execute();

Create contract versions

Create contract Versions

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ContractVersionApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String effectiveOn = "effectiveOn_example";
    Integer employeeId = 56;
    String startsOn = "startsOn_example";
    String endsOn = "endsOn_example";
    String workingHoursFrequency = "week";
    String workingWeekDays = "workingWeekDays_example";
    Integer workingHours = 56;
    String salaryFrequency = "yearly";
    Integer salaryAmount = 56;
    String jobTitle = "jobTitle_example";
    try {
      ContractVersion result = client
              .contractVersion
              .createNewVersion()
              .effectiveOn(effectiveOn)
              .employeeId(employeeId)
              .startsOn(startsOn)
              .endsOn(endsOn)
              .workingHoursFrequency(workingHoursFrequency)
              .workingWeekDays(workingWeekDays)
              .workingHours(workingHours)
              .salaryFrequency(salaryFrequency)
              .salaryAmount(salaryAmount)
              .jobTitle(jobTitle)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCountry());
      System.out.println(result.getJobTitle());
      System.out.println(result.getRole());
      System.out.println(result.getLevel());
      System.out.println(result.getEffectiveOn());
      System.out.println(result.getStartsOn());
      System.out.println(result.getEndsOn());
      System.out.println(result.getHasPayroll());
      System.out.println(result.getSalaryAmount());
      System.out.println(result.getSalaryFrequency());
      System.out.println(result.getWorkingWeekDays());
      System.out.println(result.getWorkingHours());
      System.out.println(result.getWorkingHoursFrequency());
      System.out.println(result.getEsHasTeleworkingContract());
      System.out.println(result.getEsCotizationGroup());
      System.out.println(result.getEsContractObservations());
      System.out.println(result.getEsJobDescription());
      System.out.println(result.getEsTrialPeriodEndsOn());
      System.out.println(result.getEsContractTypeId());
      System.out.println(result.getEsWorkingDayTypeId());
      System.out.println(result.getEsEducationLevelId());
      System.out.println(result.getEsProfessionalCategoryId());
      System.out.println(result.getFrEmployeeType());
      System.out.println(result.getFrForfaitJours());
      System.out.println(result.getFrJoursParAn());
      System.out.println(result.getFrCoefficient());
      System.out.println(result.getFrContractTypeId());
      System.out.println(result.getFrLevelId());
      System.out.println(result.getFrStepId());
      System.out.println(result.getFrMutualId());
      System.out.println(result.getFrProfessionalCategoryId());
      System.out.println(result.getFrWorkTypeId());
      System.out.println(result.getCompensationIds());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractVersionApi#createNewVersion");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ContractVersion> response = client
              .contractVersion
              .createNewVersion()
              .effectiveOn(effectiveOn)
              .employeeId(employeeId)
              .startsOn(startsOn)
              .endsOn(endsOn)
              .workingHoursFrequency(workingHoursFrequency)
              .workingWeekDays(workingWeekDays)
              .workingHours(workingHours)
              .salaryFrequency(salaryFrequency)
              .salaryAmount(salaryAmount)
              .jobTitle(jobTitle)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractVersionApi#createNewVersion");
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
| **contractVersionCreateNewVersionRequest** | [**ContractVersionCreateNewVersionRequest**](ContractVersionCreateNewVersionRequest.md)|  | [optional] |

### Return type

[**ContractVersion**](ContractVersion.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getAllVersions"></a>
# **getAllVersions**
> List&lt;ContractVersion&gt; getAllVersions().execute();

Get all contract versions

Get all contract Versions

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ContractVersionApi;
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
      List<ContractVersion> result = client
              .contractVersion
              .getAllVersions()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractVersionApi#getAllVersions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<ContractVersion>> response = client
              .contractVersion
              .getAllVersions()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractVersionApi#getAllVersions");
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

[**List&lt;ContractVersion&gt;**](ContractVersion.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getBulkVersions"></a>
# **getBulkVersions**
> List&lt;ContractVersion&gt; getBulkVersions().execute();

Get Bulk Contract Versions

This endpoint allows you retrieve bulk contract versions

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ContractVersionApi;
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
      List<ContractVersion> result = client
              .contractVersion
              .getBulkVersions()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractVersionApi#getBulkVersions");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<ContractVersion>> response = client
              .contractVersion
              .getBulkVersions()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractVersionApi#getBulkVersions");
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

[**List&lt;ContractVersion&gt;**](ContractVersion.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

