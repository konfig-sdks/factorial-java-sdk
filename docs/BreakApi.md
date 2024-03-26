# BreakApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createBreak**](BreakApi.md#createBreak) | **POST** /v1/time/breaks | Create a break |
| [**endBreak**](BreakApi.md#endBreak) | **POST** /v1/time/breaks/end | End a break |
| [**startBreak**](BreakApi.md#startBreak) | **POST** /v1/time/breaks/start | Start a break |


<a name="createBreak"></a>
# **createBreak**
> Attendance createBreak().breakCreateBreakRequest(breakCreateBreakRequest).execute();

Create a break

Creates a break with the break_start and break_end time

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BreakApi;
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
    String breakStart = "breakStart_example";
    String breakEnd = "breakEnd_example";
    String observations = "observations_example";
    try {
      Attendance result = client
              .break
              .createBreak(employeeId, breakStart, breakEnd)
              .observations(observations)
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
      System.err.println("Exception when calling BreakApi#createBreak");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Attendance> response = client
              .break
              .createBreak(employeeId, breakStart, breakEnd)
              .observations(observations)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BreakApi#createBreak");
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
| **breakCreateBreakRequest** | [**BreakCreateBreakRequest**](BreakCreateBreakRequest.md)|  | [optional] |

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

<a name="endBreak"></a>
# **endBreak**
> Attendance endBreak().breakEndBreakRequest(breakEndBreakRequest).execute();

End a break

End a break

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BreakApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String now = "now_example";
    Integer employeeId = 56;
    String observations = "observations_example";
    try {
      Attendance result = client
              .break
              .endBreak(now, employeeId)
              .observations(observations)
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
      System.err.println("Exception when calling BreakApi#endBreak");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Attendance> response = client
              .break
              .endBreak(now, employeeId)
              .observations(observations)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BreakApi#endBreak");
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
| **breakEndBreakRequest** | [**BreakEndBreakRequest**](BreakEndBreakRequest.md)|  | [optional] |

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

<a name="startBreak"></a>
# **startBreak**
> Attendance startBreak().breakStartBreakRequest(breakStartBreakRequest).execute();

Start a break

Start a break

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.BreakApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String now = "now_example";
    Integer employeeId = 56;
    String observations = "observations_example";
    Integer timeSettingsBreakConfigurationId = 56;
    try {
      Attendance result = client
              .break
              .startBreak(now, employeeId)
              .observations(observations)
              .timeSettingsBreakConfigurationId(timeSettingsBreakConfigurationId)
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
      System.err.println("Exception when calling BreakApi#startBreak");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Attendance> response = client
              .break
              .startBreak(now, employeeId)
              .observations(observations)
              .timeSettingsBreakConfigurationId(timeSettingsBreakConfigurationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling BreakApi#startBreak");
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
| **breakStartBreakRequest** | [**BreakStartBreakRequest**](BreakStartBreakRequest.md)|  | [optional] |

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

