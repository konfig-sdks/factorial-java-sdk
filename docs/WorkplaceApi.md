# WorkplaceApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewWorkplace**](WorkplaceApi.md#createNewWorkplace) | **POST** /v2/core/workplaces | Create a workplace |
| [**getById**](WorkplaceApi.md#getById) | **GET** /v2/core/workplaces/{id} | Get a workplace |
| [**listAllWorkplaces**](WorkplaceApi.md#listAllWorkplaces) | **GET** /v2/core/workplaces | Get all workplaces |
| [**removeWorkplace**](WorkplaceApi.md#removeWorkplace) | **DELETE** /v2/core/workplaces/{id} | Delete a workplace |
| [**updateWorkplaceById**](WorkplaceApi.md#updateWorkplaceById) | **PUT** /v2/core/workplaces/{id} | Updates a workplace |


<a name="createNewWorkplace"></a>
# **createNewWorkplace**
> Workplace createNewWorkplace().workplaceCreateNewWorkplaceRequest(workplaceCreateNewWorkplaceRequest).execute();

Create a workplace

Creates a workplace for a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WorkplaceApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String name = "name_example";
    String country = "country_example";
    String timezone = "timezone_example";
    String state = "state_example";
    String city = "city_example";
    String addressLine1 = "addressLine1_example";
    String addressLine2 = "addressLine2_example";
    String postalCode = "postalCode_example";
    String phoneNumber = "phoneNumber_example";
    Integer companyId = 56;
    Integer legalEntityId = 56;
    Boolean main = true;
    Float latitude = 3.4F;
    Float longitude = 3.4F;
    try {
      Workplace result = client
              .workplace
              .createNewWorkplace(name, country, timezone)
              .state(state)
              .city(city)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .postalCode(postalCode)
              .phoneNumber(phoneNumber)
              .companyId(companyId)
              .legalEntityId(legalEntityId)
              .main(main)
              .latitude(latitude)
              .longitude(longitude)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getCountry());
      System.out.println(result.getState());
      System.out.println(result.getCity());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getPostalCode());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyId());
      System.out.println(result.getPayrollPolicyId());
      System.out.println(result.getMain());
      System.out.println(result.getTimezone());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#createNewWorkplace");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Workplace> response = client
              .workplace
              .createNewWorkplace(name, country, timezone)
              .state(state)
              .city(city)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .postalCode(postalCode)
              .phoneNumber(phoneNumber)
              .companyId(companyId)
              .legalEntityId(legalEntityId)
              .main(main)
              .latitude(latitude)
              .longitude(longitude)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#createNewWorkplace");
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
| **workplaceCreateNewWorkplaceRequest** | [**WorkplaceCreateNewWorkplaceRequest**](WorkplaceCreateNewWorkplaceRequest.md)|  | [optional] |

### Return type

[**Workplace**](Workplace.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getById"></a>
# **getById**
> Workplace getById(id).execute();

Get a workplace

This endpoint allows you to retrieve a workplace by id

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WorkplaceApi;
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
      Workplace result = client
              .workplace
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getCountry());
      System.out.println(result.getState());
      System.out.println(result.getCity());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getPostalCode());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyId());
      System.out.println(result.getPayrollPolicyId());
      System.out.println(result.getMain());
      System.out.println(result.getTimezone());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Workplace> response = client
              .workplace
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#getById");
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

[**Workplace**](Workplace.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listAllWorkplaces"></a>
# **listAllWorkplaces**
> List&lt;Workplace&gt; listAllWorkplaces().ids(ids).employeeIds(employeeIds).execute();

Get all workplaces

This endpoint allows you to retrieve all workplaces for a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WorkplaceApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String ids = "1,2"; // Workplaces id comma separated values
    String employeeIds = "1,2"; // Employees id comma separated values
    try {
      List<Workplace> result = client
              .workplace
              .listAllWorkplaces()
              .ids(ids)
              .employeeIds(employeeIds)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#listAllWorkplaces");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Workplace>> response = client
              .workplace
              .listAllWorkplaces()
              .ids(ids)
              .employeeIds(employeeIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#listAllWorkplaces");
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
| **ids** | **String**| Workplaces id comma separated values | [optional] |
| **employeeIds** | **String**| Employees id comma separated values | [optional] |

### Return type

[**List&lt;Workplace&gt;**](Workplace.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="removeWorkplace"></a>
# **removeWorkplace**
> List&lt;Workplace&gt; removeWorkplace(id).execute();

Delete a workplace

Delete a workplace

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WorkplaceApi;
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
      List<Workplace> result = client
              .workplace
              .removeWorkplace(id)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#removeWorkplace");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Workplace>> response = client
              .workplace
              .removeWorkplace(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#removeWorkplace");
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

[**List&lt;Workplace&gt;**](Workplace.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateWorkplaceById"></a>
# **updateWorkplaceById**
> Workplace updateWorkplaceById(id).workplaceUpdateWorkplaceByIdRequest(workplaceUpdateWorkplaceByIdRequest).execute();

Updates a workplace

Updates a workplace of a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WorkplaceApi;
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
    String name = "name_example";
    String country = "country_example";
    String state = "state_example";
    String city = "city_example";
    String addressLine1 = "addressLine1_example";
    String addressLine2 = "addressLine2_example";
    String postalCode = "postalCode_example";
    String phoneNumber = "phoneNumber_example";
    Integer payrollPolicyId = 56;
    Boolean main = true;
    String timezone = "timezone_example";
    try {
      Workplace result = client
              .workplace
              .updateWorkplaceById(id)
              .name(name)
              .country(country)
              .state(state)
              .city(city)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .postalCode(postalCode)
              .phoneNumber(phoneNumber)
              .payrollPolicyId(payrollPolicyId)
              .main(main)
              .timezone(timezone)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getCountry());
      System.out.println(result.getState());
      System.out.println(result.getCity());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getPostalCode());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyId());
      System.out.println(result.getPayrollPolicyId());
      System.out.println(result.getMain());
      System.out.println(result.getTimezone());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#updateWorkplaceById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Workplace> response = client
              .workplace
              .updateWorkplaceById(id)
              .name(name)
              .country(country)
              .state(state)
              .city(city)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .postalCode(postalCode)
              .phoneNumber(phoneNumber)
              .payrollPolicyId(payrollPolicyId)
              .main(main)
              .timezone(timezone)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WorkplaceApi#updateWorkplaceById");
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
| **workplaceUpdateWorkplaceByIdRequest** | [**WorkplaceUpdateWorkplaceByIdRequest**](WorkplaceUpdateWorkplaceByIdRequest.md)|  | [optional] |

### Return type

[**Workplace**](Workplace.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

