# LeaveApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewLeave**](LeaveApi.md#createNewLeave) | **POST** /v1/time/leaves | Create a Leave |
| [**createNewLeave_0**](LeaveApi.md#createNewLeave_0) | **POST** /v2/time/leaves | Create a Leave |
| [**deleteById**](LeaveApi.md#deleteById) | **DELETE** /v1/time/leaves/{id} | Delete a Leave by ID |
| [**deleteById_0**](LeaveApi.md#deleteById_0) | **DELETE** /v2/time/leaves/{id} | Delete a Leave by ID |
| [**getById**](LeaveApi.md#getById) | **GET** /v1/time/leaves/{id} | Get a Leave by ID |
| [**getById_0**](LeaveApi.md#getById_0) | **GET** /v2/time/leaves/{id} | Get a Leave by ID |
| [**getCompanyLeaves**](LeaveApi.md#getCompanyLeaves) | **GET** /v1/time/leaves | Get Leaves |
| [**getCompanyLeaves_0**](LeaveApi.md#getCompanyLeaves_0) | **GET** /v2/time/leaves | Get Leaves |
| [**getTypes**](LeaveApi.md#getTypes) | **GET** /v1/time/leave_types | Get Leave types |
| [**typeCreate**](LeaveApi.md#typeCreate) | **POST** /v1/time/leave_types | Create a Leave Type |
| [**updateById**](LeaveApi.md#updateById) | **PUT** /v2/time/leaves/{id} | Update a Leave |
| [**updateLeaveById**](LeaveApi.md#updateLeaveById) | **PUT** /v1/time/leaves/{id} | Update a Leave |
| [**updateType**](LeaveApi.md#updateType) | **PUT** /v1/time/leave_types/{id} | Update a Leave Type |


<a name="createNewLeave"></a>
# **createNewLeave**
> Leave createNewLeave().leaveCreateNewLeaveRequest(leaveCreateNewLeaveRequest).execute();

Create a Leave

Creates a Leave

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String startOn = "startOn_example";
    String finishOn = "finishOn_example";
    Integer employeeId = 56;
    String description = "description_example";
    Integer leaveTypeId = 56;
    String halfDay = "beggining_of_day";
    try {
      Leave result = client
              .leave
              .createNewLeave(startOn, finishOn, employeeId)
              .description(description)
              .leaveTypeId(leaveTypeId)
              .halfDay(halfDay)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getEmployeeFullName());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getHoursAmountInCents());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#createNewLeave");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Leave> response = client
              .leave
              .createNewLeave(startOn, finishOn, employeeId)
              .description(description)
              .leaveTypeId(leaveTypeId)
              .halfDay(halfDay)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#createNewLeave");
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
| **leaveCreateNewLeaveRequest** | [**LeaveCreateNewLeaveRequest**](LeaveCreateNewLeaveRequest.md)|  | [optional] |

### Return type

[**Leave**](Leave.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="createNewLeave_0"></a>
# **createNewLeave_0**
> Leave createNewLeave_0().leaveCreateNewLeaveRequest1(leaveCreateNewLeaveRequest1).execute();

Create a Leave

Creates a Leave

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String startOn = "startOn_example";
    String finishOn = "finishOn_example";
    Integer employeeId = 56;
    String description = "description_example";
    Integer leaveTypeId = 56;
    String halfDay = "beggining_of_day";
    String startTime = "startTime_example";
    Integer hoursAmountInCents = 56;
    Integer medicalLeaveType = 56;
    String effectiveOn = "effectiveOn_example";
    String medicalDischargeReason = "medicalDischargeReason_example";
    Integer colegiateNumber = 56;
    Boolean hasPreviousRelapse = true;
    Integer relapseLeaveId = 56;
    String relapseOn = "relapseOn_example";
    String accidentOn = "accidentOn_example";
    String paternityBirthOn = "paternityBirthOn_example";
    try {
      Leave result = client
              .leave
              .createNewLeave_0(startOn, finishOn, employeeId)
              .description(description)
              .leaveTypeId(leaveTypeId)
              .halfDay(halfDay)
              .startTime(startTime)
              .hoursAmountInCents(hoursAmountInCents)
              .medicalLeaveType(medicalLeaveType)
              .effectiveOn(effectiveOn)
              .medicalDischargeReason(medicalDischargeReason)
              .colegiateNumber(colegiateNumber)
              .hasPreviousRelapse(hasPreviousRelapse)
              .relapseLeaveId(relapseLeaveId)
              .relapseOn(relapseOn)
              .accidentOn(accidentOn)
              .paternityBirthOn(paternityBirthOn)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getEmployeeFullName());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getHoursAmountInCents());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#createNewLeave_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Leave> response = client
              .leave
              .createNewLeave_0(startOn, finishOn, employeeId)
              .description(description)
              .leaveTypeId(leaveTypeId)
              .halfDay(halfDay)
              .startTime(startTime)
              .hoursAmountInCents(hoursAmountInCents)
              .medicalLeaveType(medicalLeaveType)
              .effectiveOn(effectiveOn)
              .medicalDischargeReason(medicalDischargeReason)
              .colegiateNumber(colegiateNumber)
              .hasPreviousRelapse(hasPreviousRelapse)
              .relapseLeaveId(relapseLeaveId)
              .relapseOn(relapseOn)
              .accidentOn(accidentOn)
              .paternityBirthOn(paternityBirthOn)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#createNewLeave_0");
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
| **leaveCreateNewLeaveRequest1** | [**LeaveCreateNewLeaveRequest1**](LeaveCreateNewLeaveRequest1.md)|  | [optional] |

### Return type

[**Leave**](Leave.md)

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
> Leave deleteById(id).execute();

Delete a Leave by ID

Delete a Leave by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "1"; // (Required)
    try {
      Leave result = client
              .leave
              .deleteById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getEmployeeFullName());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getHoursAmountInCents());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#deleteById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Leave> response = client
              .leave
              .deleteById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#deleteById");
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

[**Leave**](Leave.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="deleteById_0"></a>
# **deleteById_0**
> LeaveV2 deleteById_0(id).execute();

Delete a Leave by ID

Delete a Leave by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "1"; // (Required)
    try {
      LeaveV2 result = client
              .leave
              .deleteById_0(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getEmployeeFullName());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#deleteById_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LeaveV2> response = client
              .leave
              .deleteById_0(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#deleteById_0");
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

[**LeaveV2**](LeaveV2.md)

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
> Leave getById(id).execute();

Get a Leave by ID

Get a Leave by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "1"; // (Required)
    try {
      Leave result = client
              .leave
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getEmployeeFullName());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getHoursAmountInCents());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Leave> response = client
              .leave
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getById");
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

[**Leave**](Leave.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getById_0"></a>
# **getById_0**
> LeaveV2 getById_0(id).execute();

Get a Leave by ID

Get a Leave by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "1"; // (Required)
    try {
      LeaveV2 result = client
              .leave
              .getById_0(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getEmployeeFullName());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getById_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LeaveV2> response = client
              .leave
              .getById_0(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getById_0");
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

[**LeaveV2**](LeaveV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getCompanyLeaves"></a>
# **getCompanyLeaves**
> List&lt;Leave&gt; getCompanyLeaves().employeeIds(employeeIds).leaveTypeIds(leaveTypeIds).from(from).to(to).includeLeaveType(includeLeaveType).execute();

Get Leaves

Get Leaves from a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
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
    List<Integer> leaveTypeIds = Arrays.asList(); // Leave type id array
    String from = "2023-01-03"; // It should be a valid date following the format YYYY-MM-DD
    String to = "2023-01-04"; // It should be a valid date following the format YYYY-MM-DD
    Boolean includeLeaveType = false; // Include leave type name
    try {
      List<Leave> result = client
              .leave
              .getCompanyLeaves()
              .employeeIds(employeeIds)
              .leaveTypeIds(leaveTypeIds)
              .from(from)
              .to(to)
              .includeLeaveType(includeLeaveType)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getCompanyLeaves");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Leave>> response = client
              .leave
              .getCompanyLeaves()
              .employeeIds(employeeIds)
              .leaveTypeIds(leaveTypeIds)
              .from(from)
              .to(to)
              .includeLeaveType(includeLeaveType)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getCompanyLeaves");
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
| **leaveTypeIds** | [**List&lt;Integer&gt;**](Integer.md)| Leave type id array | [optional] |
| **from** | **String**| It should be a valid date following the format YYYY-MM-DD | [optional] |
| **to** | **String**| It should be a valid date following the format YYYY-MM-DD | [optional] |
| **includeLeaveType** | **Boolean**| Include leave type name | [optional] [default to false] |

### Return type

[**List&lt;Leave&gt;**](Leave.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getCompanyLeaves_0"></a>
# **getCompanyLeaves_0**
> List&lt;LeaveV2&gt; getCompanyLeaves_0().employeeIds(employeeIds).leaveTypeIds(leaveTypeIds).from(from).to(to).includeLeaveType(includeLeaveType).execute();

Get Leaves

Get Leaves from a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
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
    List<Integer> leaveTypeIds = Arrays.asList(); // Leave type id array
    String from = "2023-01-03"; // It should be a valid date following the format YYYY-MM-DD
    String to = "2023-01-04"; // It should be a valid date following the format YYYY-MM-DD
    Boolean includeLeaveType = false; // Include leave type name
    try {
      List<LeaveV2> result = client
              .leave
              .getCompanyLeaves_0()
              .employeeIds(employeeIds)
              .leaveTypeIds(leaveTypeIds)
              .from(from)
              .to(to)
              .includeLeaveType(includeLeaveType)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getCompanyLeaves_0");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<LeaveV2>> response = client
              .leave
              .getCompanyLeaves_0()
              .employeeIds(employeeIds)
              .leaveTypeIds(leaveTypeIds)
              .from(from)
              .to(to)
              .includeLeaveType(includeLeaveType)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getCompanyLeaves_0");
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
| **leaveTypeIds** | [**List&lt;Integer&gt;**](Integer.md)| Leave type id array | [optional] |
| **from** | **String**| It should be a valid date following the format YYYY-MM-DD | [optional] |
| **to** | **String**| It should be a valid date following the format YYYY-MM-DD | [optional] |
| **includeLeaveType** | **Boolean**| Include leave type name | [optional] [default to false] |

### Return type

[**List&lt;LeaveV2&gt;**](LeaveV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getTypes"></a>
# **getTypes**
> List&lt;LeaveType&gt; getTypes().execute();

Get Leave types

Get Leave types from a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
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
      List<LeaveType> result = client
              .leave
              .getTypes()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getTypes");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<LeaveType>> response = client
              .leave
              .getTypes()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#getTypes");
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

[**List&lt;LeaveType&gt;**](LeaveType.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="typeCreate"></a>
# **typeCreate**
> LeaveType typeCreate().leaveTypeCreateRequest(leaveTypeCreateRequest).execute();

Create a Leave Type

Create a Leave Type

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
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
    String color = "color_example";
    Boolean accrues = true;
    Boolean active = true;
    Boolean approvalRequired = true;
    Boolean attachment = true;
    Boolean visibility = true;
    Boolean workable = true;
    try {
      LeaveType result = client
              .leave
              .typeCreate(name, color)
              .accrues(accrues)
              .active(active)
              .approvalRequired(approvalRequired)
              .attachment(attachment)
              .visibility(visibility)
              .workable(workable)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getAccrues());
      System.out.println(result.getActive());
      System.out.println(result.getApprovalRequired());
      System.out.println(result.getAttachment());
      System.out.println(result.getColor());
      System.out.println(result.getIdentifier());
      System.out.println(result.getName());
      System.out.println(result.getVisibility());
      System.out.println(result.getWorkable());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#typeCreate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LeaveType> response = client
              .leave
              .typeCreate(name, color)
              .accrues(accrues)
              .active(active)
              .approvalRequired(approvalRequired)
              .attachment(attachment)
              .visibility(visibility)
              .workable(workable)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#typeCreate");
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
| **leaveTypeCreateRequest** | [**LeaveTypeCreateRequest**](LeaveTypeCreateRequest.md)|  | [optional] |

### Return type

[**LeaveType**](LeaveType.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="updateById"></a>
# **updateById**
> LeaveV2 updateById(id).leaveUpdateByIdRequest(leaveUpdateByIdRequest).execute();

Update a Leave

Update a Leave

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "1"; // (Required)
    String description = "description_example";
    Integer employeeId = 56;
    String finishOn = "finishOn_example";
    String startOn = "startOn_example";
    String startTime = "startTime_example";
    Integer hourAmountInCents = 56;
    try {
      LeaveV2 result = client
              .leave
              .updateById(id)
              .description(description)
              .employeeId(employeeId)
              .finishOn(finishOn)
              .startOn(startOn)
              .startTime(startTime)
              .hourAmountInCents(hourAmountInCents)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getEmployeeFullName());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#updateById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LeaveV2> response = client
              .leave
              .updateById(id)
              .description(description)
              .employeeId(employeeId)
              .finishOn(finishOn)
              .startOn(startOn)
              .startTime(startTime)
              .hourAmountInCents(hourAmountInCents)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#updateById");
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
| **leaveUpdateByIdRequest** | [**LeaveUpdateByIdRequest**](LeaveUpdateByIdRequest.md)|  | [optional] |

### Return type

[**LeaveV2**](LeaveV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateLeaveById"></a>
# **updateLeaveById**
> Leave updateLeaveById(id).leaveUpdateLeaveByIdRequest(leaveUpdateLeaveByIdRequest).execute();

Update a Leave

Update a Leave

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "1"; // (Required)
    String description = "description_example";
    Integer employeeId = 56;
    Integer finishOn = 56;
    String startOn = "startOn_example";
    String halfDay = "beggining_of_day";
    Integer leaveTypeId = 56;
    try {
      Leave result = client
              .leave
              .updateLeaveById(id)
              .description(description)
              .employeeId(employeeId)
              .finishOn(finishOn)
              .startOn(startOn)
              .halfDay(halfDay)
              .leaveTypeId(leaveTypeId)
              .execute();
      System.out.println(result);
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getApproved());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getFinishOn());
      System.out.println(result.getHalfDay());
      System.out.println(result.getLeaveTypeId());
      System.out.println(result.getStartOn());
      System.out.println(result.getEmployeeFullName());
      System.out.println(result.getLeaveTypeName());
      System.out.println(result.getHoursAmountInCents());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#updateLeaveById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Leave> response = client
              .leave
              .updateLeaveById(id)
              .description(description)
              .employeeId(employeeId)
              .finishOn(finishOn)
              .startOn(startOn)
              .halfDay(halfDay)
              .leaveTypeId(leaveTypeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#updateLeaveById");
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
| **leaveUpdateLeaveByIdRequest** | [**LeaveUpdateLeaveByIdRequest**](LeaveUpdateLeaveByIdRequest.md)|  | [optional] |

### Return type

[**Leave**](Leave.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateType"></a>
# **updateType**
> LeaveType updateType(id).leaveUpdateTypeRequest(leaveUpdateTypeRequest).execute();

Update a Leave Type

Update a Leave Type

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.LeaveApi;
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
    String color = "color_example";
    String id = "5"; // (Required)
    Boolean accrues = true;
    Boolean active = true;
    Boolean approvalRequired = true;
    Boolean attachment = true;
    Boolean visibility = true;
    Boolean workable = true;
    try {
      LeaveType result = client
              .leave
              .updateType(name, color, id)
              .accrues(accrues)
              .active(active)
              .approvalRequired(approvalRequired)
              .attachment(attachment)
              .visibility(visibility)
              .workable(workable)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getAccrues());
      System.out.println(result.getActive());
      System.out.println(result.getApprovalRequired());
      System.out.println(result.getAttachment());
      System.out.println(result.getColor());
      System.out.println(result.getIdentifier());
      System.out.println(result.getName());
      System.out.println(result.getVisibility());
      System.out.println(result.getWorkable());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#updateType");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<LeaveType> response = client
              .leave
              .updateType(name, color, id)
              .accrues(accrues)
              .active(active)
              .approvalRequired(approvalRequired)
              .attachment(attachment)
              .visibility(visibility)
              .workable(workable)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaveApi#updateType");
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
| **leaveUpdateTypeRequest** | [**LeaveUpdateTypeRequest**](LeaveUpdateTypeRequest.md)|  | [optional] |

### Return type

[**LeaveType**](LeaveType.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

