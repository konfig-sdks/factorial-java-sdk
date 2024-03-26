# AttendanceApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNew**](AttendanceApi.md#createNew) | **POST** /v2/time/attendance | Create Attendance |
| [**getBulkV2**](AttendanceApi.md#getBulkV2) | **POST** /v2/core/bulk/attendance | Get Bulk Attendance |
| [**getCompanyAttendance**](AttendanceApi.md#getCompanyAttendance) | **GET** /v2/time/attendance | Get attendance from a company |


<a name="createNew"></a>
# **createNew**
> Attendance createNew().attendanceCreateNewRequest(attendanceCreateNewRequest).execute();

Create Attendance

Creates Attendance

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AttendanceApi;
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
    String clockIn = "clockIn_example";
    String clockOut = "clockOut_example";
    String observations = "observations_example";
    String locationType = "office";
    try {
      Attendance result = client
              .attendance
              .createNew(employeeId, clockIn, clockOut)
              .observations(observations)
              .locationType(locationType)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getClockIn());
      System.out.println(result.getClockOut());
      System.out.println(result.getObservations());
      System.out.println(result.getLocationType());
      System.out.println(result.getHalfDay());
      System.out.println(result.getInLocationLatitude());
      System.out.println(result.getInLocationLongitude());
      System.out.println(result.getInLocationAccuracy());
      System.out.println(result.getOutLocationLatitude());
      System.out.println(result.getOutLocationLongitude());
      System.out.println(result.getOutLocationAccuracy());
      System.out.println(result.getWorkable());
      System.out.println(result.getAutomaticClockIn());
      System.out.println(result.getAutomaticClockOut());
      System.out.println(result.getTimeSettingsBreakConfigurationId());
    } catch (ApiException e) {
      System.err.println("Exception when calling AttendanceApi#createNew");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Attendance> response = client
              .attendance
              .createNew(employeeId, clockIn, clockOut)
              .observations(observations)
              .locationType(locationType)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling AttendanceApi#createNew");
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
| **attendanceCreateNewRequest** | [**AttendanceCreateNewRequest**](AttendanceCreateNewRequest.md)|  | [optional] |

### Return type

[**Attendance**](Attendance.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getBulkV2"></a>
# **getBulkV2**
> List&lt;Attendance&gt; getBulkV2().execute();

Get Bulk Attendance

This endpoint allows you retrieve bulk attendance V2

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AttendanceApi;
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
      List<Attendance> result = client
              .attendance
              .getBulkV2()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttendanceApi#getBulkV2");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Attendance>> response = client
              .attendance
              .getBulkV2()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling AttendanceApi#getBulkV2");
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

[**List&lt;Attendance&gt;**](Attendance.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getCompanyAttendance"></a>
# **getCompanyAttendance**
> List&lt;Attendance&gt; getCompanyAttendance().employeeIds(employeeIds).dateFrom(dateFrom).dateTo(dateTo).execute();

Get attendance from a company

Get attendance from a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.AttendanceApi;
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
    String dateFrom = "2023-01-03"; // It should be a valid date following the format YYYY-MM-DD
    String dateTo = "2023-01-04"; // It should be a valid date following the format YYYY-MM-DD
    try {
      List<Attendance> result = client
              .attendance
              .getCompanyAttendance()
              .employeeIds(employeeIds)
              .dateFrom(dateFrom)
              .dateTo(dateTo)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AttendanceApi#getCompanyAttendance");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Attendance>> response = client
              .attendance
              .getCompanyAttendance()
              .employeeIds(employeeIds)
              .dateFrom(dateFrom)
              .dateTo(dateTo)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling AttendanceApi#getCompanyAttendance");
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
| **dateFrom** | **String**| It should be a valid date following the format YYYY-MM-DD | [optional] |
| **dateTo** | **String**| It should be a valid date following the format YYYY-MM-DD | [optional] |

### Return type

[**List&lt;Attendance&gt;**](Attendance.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

