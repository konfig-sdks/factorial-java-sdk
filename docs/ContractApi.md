# ContractApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteVersion**](ContractApi.md#deleteVersion) | **DELETE** /v1/payroll/contract_versions/{id} | Delete contract version |
| [**getAllReferenceContracts**](ContractApi.md#getAllReferenceContracts) | **GET** /v1/payroll/reference_contracts | Get all reference contracts |
| [**updateVersion**](ContractApi.md#updateVersion) | **PUT** /v1/payroll/contract_versions/{id} | Update contract version |


<a name="deleteVersion"></a>
# **deleteVersion**
> ContractVersion deleteVersion(id).execute();

Delete contract version

Delete contract Version

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ContractApi;
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
      ContractVersion result = client
              .contract
              .deleteVersion(id)
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
      System.err.println("Exception when calling ContractApi#deleteVersion");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ContractVersion> response = client
              .contract
              .deleteVersion(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractApi#deleteVersion");
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

[**ContractVersion**](ContractVersion.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getAllReferenceContracts"></a>
# **getAllReferenceContracts**
> List&lt;ContractVersion&gt; getAllReferenceContracts().employeeIds(employeeIds).execute();

Get all reference contracts

The reference contract is the contract that applies today. If no contract applies today, we will return the nearest upcoming contract. If there are no upcoming contracts, we will provide the most recent past contract.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ContractApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    List<Integer> employeeIds = Arrays.asList(); // Employees id array
    try {
      List<ContractVersion> result = client
              .contract
              .getAllReferenceContracts()
              .employeeIds(employeeIds)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractApi#getAllReferenceContracts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<ContractVersion>> response = client
              .contract
              .getAllReferenceContracts()
              .employeeIds(employeeIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractApi#getAllReferenceContracts");
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
| **employeeIds** | [**List&lt;Integer&gt;**](Integer.md)| Employees id array | [optional] |

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

<a name="updateVersion"></a>
# **updateVersion**
> ContractVersion updateVersion(id).contractUpdateVersionRequest(contractUpdateVersionRequest).execute();

Update contract version

Update contract Version

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ContractApi;
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
    String id = "3"; // (Required)
    Integer employeeId = 56;
    String startsOn = "startsOn_example";
    String endsOn = "endsOn_example";
    String workingHoursFrequency = "week";
    String workingWeekDays = "workingWeekDays_example";
    Integer workingHours = 56;
    String salaryFrequency = "yearly";
    Integer salaryAmount = 56;
    String jobTitle = "jobTitle_example";
    Integer esCotizationGroup = 56; // the cotization group id for Spain contracts
    Integer esProfessionalCategoryId = 56; // the professional category id for Spain contracts
    Integer esEducationLevelId = 56; // the education level id for Spain contracts
    Integer esContractTypeId = 56; // the contract type id for Spain contracts
    try {
      ContractVersion result = client
              .contract
              .updateVersion(effectiveOn, id)
              .employeeId(employeeId)
              .startsOn(startsOn)
              .endsOn(endsOn)
              .workingHoursFrequency(workingHoursFrequency)
              .workingWeekDays(workingWeekDays)
              .workingHours(workingHours)
              .salaryFrequency(salaryFrequency)
              .salaryAmount(salaryAmount)
              .jobTitle(jobTitle)
              .esCotizationGroup(esCotizationGroup)
              .esProfessionalCategoryId(esProfessionalCategoryId)
              .esEducationLevelId(esEducationLevelId)
              .esContractTypeId(esContractTypeId)
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
      System.err.println("Exception when calling ContractApi#updateVersion");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ContractVersion> response = client
              .contract
              .updateVersion(effectiveOn, id)
              .employeeId(employeeId)
              .startsOn(startsOn)
              .endsOn(endsOn)
              .workingHoursFrequency(workingHoursFrequency)
              .workingWeekDays(workingWeekDays)
              .workingHours(workingHours)
              .salaryFrequency(salaryFrequency)
              .salaryAmount(salaryAmount)
              .jobTitle(jobTitle)
              .esCotizationGroup(esCotizationGroup)
              .esProfessionalCategoryId(esProfessionalCategoryId)
              .esEducationLevelId(esEducationLevelId)
              .esContractTypeId(esContractTypeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ContractApi#updateVersion");
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
| **contractUpdateVersionRequest** | [**ContractUpdateVersionRequest**](ContractUpdateVersionRequest.md)|  | [optional] |

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
| **200** | OK |  -  |

