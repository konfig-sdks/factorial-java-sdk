# ShiftApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createClockInShift**](ShiftApi.md#createClockInShift) | **POST** /v1/time/shifts/clock_in | Clock in |
| [**createNewShift**](ShiftApi.md#createNewShift) | **POST** /v1/time/shifts_management | Create a shift |
| [**deleteById**](ShiftApi.md#deleteById) | **DELETE** /v1/time/shifts_management/{id} | Delete Shift |
| [**deleteShiftById**](ShiftApi.md#deleteShiftById) | **DELETE** /v1/time/shifts/{id} | Delete Shift (time registry) |
| [**getAllShifts**](ShiftApi.md#getAllShifts) | **GET** /v1/time/shifts_management | Get all shifts from a company |
| [**getById**](ShiftApi.md#getById) | **GET** /v1/time/shifts_management/{id} | Get Shift |
| [**getFromCompany**](ShiftApi.md#getFromCompany) | **GET** /v1/time/shifts | Get shifts (time registries) from a company |
| [**publishShiftsInsideTimeRange**](ShiftApi.md#publishShiftsInsideTimeRange) | **POST** /v1/time/shifts_management/publish | Publish shifts inside time range |
| [**toggleShiftStatus**](ShiftApi.md#toggleShiftStatus) | **POST** /v1/time/shifts/toggle | Toggle |
| [**updateClockOutShift**](ShiftApi.md#updateClockOutShift) | **POST** /v1/time/shifts/clock_out | Clock out |
| [**updateNotes**](ShiftApi.md#updateNotes) | **PUT** /v1/time/shifts_management/{id}/notes | Update shift notes |
| [**updateShift**](ShiftApi.md#updateShift) | **PUT** /v1/time/shifts/{id} | Update Shift (time registry) |


<a name="createClockInShift"></a>
# **createClockInShift**
> Shift createClockInShift().shiftCreateClockInShiftRequest(shiftCreateClockInShiftRequest).execute();

Clock in

Creates a shift (time registry) for the current user with the clock_in time of the request and nil clock_out

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
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
    String now = "now_example";
    String observations = "observations_example";
    String locationType = "office";
    try {
      Shift result = client
              .shift
              .createClockInShift(employeeId, now)
              .observations(observations)
              .locationType(locationType)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getDay());
      System.out.println(result.getMonth());
      System.out.println(result.getYear());
      System.out.println(result.getClockIn());
      System.out.println(result.getClockOut());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getObservations());
      System.out.println(result.getLocationType());
      System.out.println(result.getInLocationLatitude());
      System.out.println(result.getInLocationLongitude());
      System.out.println(result.getInLocationAccuracy());
      System.out.println(result.getOutLocationLatitude());
      System.out.println(result.getOutLocationLongitude());
      System.out.println(result.getOutLocationAccuracy());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#createClockInShift");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Shift> response = client
              .shift
              .createClockInShift(employeeId, now)
              .observations(observations)
              .locationType(locationType)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#createClockInShift");
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
| **shiftCreateClockInShiftRequest** | [**ShiftCreateClockInShiftRequest**](ShiftCreateClockInShiftRequest.md)|  | [optional] |

### Return type

[**Shift**](Shift.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="createNewShift"></a>
# **createNewShift**
> ShiftManagement createNewShift().shiftCreateNewShiftRequest(shiftCreateNewShiftRequest).execute();

Create a shift

Create a shift

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String startAt = "startAt_example";
    String endAt = "endAt_example";
    Integer employeeId = 56;
    String notes = "notes_example";
    Integer locationId = 56;
    Integer workAreaId = 56;
    try {
      ShiftManagement result = client
              .shift
              .createNewShift(startAt, endAt, employeeId)
              .notes(notes)
              .locationId(locationId)
              .workAreaId(workAreaId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartAt());
      System.out.println(result.getEndAt());
      System.out.println(result.getState());
      System.out.println(result.getNotes());
      System.out.println(result.getLocationId());
      System.out.println(result.getWorkAreaId());
      System.out.println(result.getExtraHours());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#createNewShift");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ShiftManagement> response = client
              .shift
              .createNewShift(startAt, endAt, employeeId)
              .notes(notes)
              .locationId(locationId)
              .workAreaId(workAreaId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#createNewShift");
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
| **shiftCreateNewShiftRequest** | [**ShiftCreateNewShiftRequest**](ShiftCreateNewShiftRequest.md)|  | [optional] |

### Return type

[**ShiftManagement**](ShiftManagement.md)

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
> ShiftManagement deleteById(id).execute();

Delete Shift

Delete Shift

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
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
      ShiftManagement result = client
              .shift
              .deleteById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartAt());
      System.out.println(result.getEndAt());
      System.out.println(result.getState());
      System.out.println(result.getNotes());
      System.out.println(result.getLocationId());
      System.out.println(result.getWorkAreaId());
      System.out.println(result.getExtraHours());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#deleteById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ShiftManagement> response = client
              .shift
              .deleteById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#deleteById");
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

[**ShiftManagement**](ShiftManagement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="deleteShiftById"></a>
# **deleteShiftById**
> Shift deleteShiftById(id).execute();

Delete Shift (time registry)

Delete Shift (time registry)

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "5"; // (Required)
    try {
      Shift result = client
              .shift
              .deleteShiftById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getDay());
      System.out.println(result.getMonth());
      System.out.println(result.getYear());
      System.out.println(result.getClockIn());
      System.out.println(result.getClockOut());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getObservations());
      System.out.println(result.getLocationType());
      System.out.println(result.getInLocationLatitude());
      System.out.println(result.getInLocationLongitude());
      System.out.println(result.getInLocationAccuracy());
      System.out.println(result.getOutLocationLatitude());
      System.out.println(result.getOutLocationLongitude());
      System.out.println(result.getOutLocationAccuracy());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#deleteShiftById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Shift> response = client
              .shift
              .deleteShiftById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#deleteShiftById");
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

[**Shift**](Shift.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getAllShifts"></a>
# **getAllShifts**
> List&lt;ShiftManagement&gt; getAllShifts().employeeId(employeeId).employeeIdsPercent5BPercent5D(employeeIdsPercent5BPercent5D).startAt(startAt).endAt(endAt).onlyPublished(onlyPublished).execute();

Get all shifts from a company

By default, it returns all the shifts for the current week

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer employeeId = 5; // Employee ID to find shifts from
    List<Integer> employeeIdsPercent5BPercent5D = Arrays.asList(); // Employee IDs to find shifts from
    String startAt = "2023-07-24"; // Start date to find shifts from
    String endAt = "2023-07-30"; // End date to find shifts to
    Boolean onlyPublished = false; // To return only published shifts
    try {
      List<ShiftManagement> result = client
              .shift
              .getAllShifts()
              .employeeId(employeeId)
              .employeeIdsPercent5BPercent5D(employeeIdsPercent5BPercent5D)
              .startAt(startAt)
              .endAt(endAt)
              .onlyPublished(onlyPublished)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#getAllShifts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<ShiftManagement>> response = client
              .shift
              .getAllShifts()
              .employeeId(employeeId)
              .employeeIdsPercent5BPercent5D(employeeIdsPercent5BPercent5D)
              .startAt(startAt)
              .endAt(endAt)
              .onlyPublished(onlyPublished)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#getAllShifts");
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
| **employeeId** | **Integer**| Employee ID to find shifts from | [optional] |
| **employeeIdsPercent5BPercent5D** | [**List&lt;Integer&gt;**](Integer.md)| Employee IDs to find shifts from | [optional] |
| **startAt** | **String**| Start date to find shifts from | [optional] |
| **endAt** | **String**| End date to find shifts to | [optional] |
| **onlyPublished** | **Boolean**| To return only published shifts | [optional] |

### Return type

[**List&lt;ShiftManagement&gt;**](ShiftManagement.md)

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
> ShiftManagement getById(id).execute();

Get Shift

Get Shift

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
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
      ShiftManagement result = client
              .shift
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartAt());
      System.out.println(result.getEndAt());
      System.out.println(result.getState());
      System.out.println(result.getNotes());
      System.out.println(result.getLocationId());
      System.out.println(result.getWorkAreaId());
      System.out.println(result.getExtraHours());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ShiftManagement> response = client
              .shift
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#getById");
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

[**ShiftManagement**](ShiftManagement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getFromCompany"></a>
# **getFromCompany**
> List&lt;Shift&gt; getFromCompany().year(year).month(month).execute();

Get shifts (time registries) from a company

Get shifts (time registries) from a company

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String year = "2022"; // It should be valid year in the format `YYYY`
    String month = "11"; // It should be valid month in the calendar ranging rom `01 to 12`. The month format is `MM`
    try {
      List<Shift> result = client
              .shift
              .getFromCompany()
              .year(year)
              .month(month)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#getFromCompany");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Shift>> response = client
              .shift
              .getFromCompany()
              .year(year)
              .month(month)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#getFromCompany");
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
| **year** | **String**| It should be valid year in the format &#x60;YYYY&#x60; | [optional] |
| **month** | **String**| It should be valid month in the calendar ranging rom &#x60;01 to 12&#x60;. The month format is &#x60;MM&#x60; | [optional] |

### Return type

[**List&lt;Shift&gt;**](Shift.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="publishShiftsInsideTimeRange"></a>
# **publishShiftsInsideTimeRange**
> publishShiftsInsideTimeRange().shiftPublishShiftsInsideTimeRangeRequest(shiftPublishShiftsInsideTimeRangeRequest).execute();

Publish shifts inside time range

Publish shifts inside time range

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String startAt = "startAt_example";
    String endAt = "endAt_example";
    List<Integer> employeeIds = Arrays.asList();
    Boolean sendNotification = true;
    try {
      client
              .shift
              .publishShiftsInsideTimeRange()
              .startAt(startAt)
              .endAt(endAt)
              .employeeIds(employeeIds)
              .sendNotification(sendNotification)
              .execute();
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#publishShiftsInsideTimeRange");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      client
              .shift
              .publishShiftsInsideTimeRange()
              .startAt(startAt)
              .endAt(endAt)
              .employeeIds(employeeIds)
              .sendNotification(sendNotification)
              .executeWithHttpInfo();
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#publishShiftsInsideTimeRange");
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
| **shiftPublishShiftsInsideTimeRangeRequest** | [**ShiftPublishShiftsInsideTimeRangeRequest**](ShiftPublishShiftsInsideTimeRangeRequest.md)|  | [optional] |

### Return type

null (empty response body)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="toggleShiftStatus"></a>
# **toggleShiftStatus**
> Shift toggleShiftStatus().shiftToggleShiftStatusRequest(shiftToggleShiftStatusRequest).execute();

Toggle

Updates a shift (time registry) for the current user with the time of the request. It will clock out if the user wasn&#39;t previously clocked in. Else it will clock in.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
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
    String now = "now_example";
    try {
      Shift result = client
              .shift
              .toggleShiftStatus(employeeId, now)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getDay());
      System.out.println(result.getMonth());
      System.out.println(result.getYear());
      System.out.println(result.getClockIn());
      System.out.println(result.getClockOut());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getObservations());
      System.out.println(result.getLocationType());
      System.out.println(result.getInLocationLatitude());
      System.out.println(result.getInLocationLongitude());
      System.out.println(result.getInLocationAccuracy());
      System.out.println(result.getOutLocationLatitude());
      System.out.println(result.getOutLocationLongitude());
      System.out.println(result.getOutLocationAccuracy());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#toggleShiftStatus");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Shift> response = client
              .shift
              .toggleShiftStatus(employeeId, now)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#toggleShiftStatus");
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
| **shiftToggleShiftStatusRequest** | [**ShiftToggleShiftStatusRequest**](ShiftToggleShiftStatusRequest.md)|  | [optional] |

### Return type

[**Shift**](Shift.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="updateClockOutShift"></a>
# **updateClockOutShift**
> Shift updateClockOutShift().shiftUpdateClockOutShiftRequest(shiftUpdateClockOutShiftRequest).execute();

Clock out

Updates a shift (time registry) for the current user with the clock_out time of the request. It will fail if the user wasn&#39;t previously clocked in.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
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
    String now = "now_example";
    String observations = "observations_example";
    try {
      Shift result = client
              .shift
              .updateClockOutShift(employeeId, now)
              .observations(observations)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getDay());
      System.out.println(result.getMonth());
      System.out.println(result.getYear());
      System.out.println(result.getClockIn());
      System.out.println(result.getClockOut());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getObservations());
      System.out.println(result.getLocationType());
      System.out.println(result.getInLocationLatitude());
      System.out.println(result.getInLocationLongitude());
      System.out.println(result.getInLocationAccuracy());
      System.out.println(result.getOutLocationLatitude());
      System.out.println(result.getOutLocationLongitude());
      System.out.println(result.getOutLocationAccuracy());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#updateClockOutShift");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Shift> response = client
              .shift
              .updateClockOutShift(employeeId, now)
              .observations(observations)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#updateClockOutShift");
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
| **shiftUpdateClockOutShiftRequest** | [**ShiftUpdateClockOutShiftRequest**](ShiftUpdateClockOutShiftRequest.md)|  | [optional] |

### Return type

[**Shift**](Shift.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="updateNotes"></a>
# **updateNotes**
> ShiftManagement updateNotes(id).shiftUpdateNotesRequest(shiftUpdateNotesRequest).execute();

Update shift notes

Update shift notes

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
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
    String notes = "notes_example";
    try {
      ShiftManagement result = client
              .shift
              .updateNotes(id)
              .notes(notes)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getStartAt());
      System.out.println(result.getEndAt());
      System.out.println(result.getState());
      System.out.println(result.getNotes());
      System.out.println(result.getLocationId());
      System.out.println(result.getWorkAreaId());
      System.out.println(result.getExtraHours());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#updateNotes");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<ShiftManagement> response = client
              .shift
              .updateNotes(id)
              .notes(notes)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#updateNotes");
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
| **shiftUpdateNotesRequest** | [**ShiftUpdateNotesRequest**](ShiftUpdateNotesRequest.md)|  | [optional] |

### Return type

[**ShiftManagement**](ShiftManagement.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateShift"></a>
# **updateShift**
> Shift updateShift(id).shiftUpdateShiftRequest(shiftUpdateShiftRequest).execute();

Update Shift (time registry)

Updates a shift (time registry).

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ShiftApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "5"; // (Required)
    String clockIn = "clockIn_example";
    String clockOut = "clockOut_example";
    String observations = "observations_example";
    try {
      Shift result = client
              .shift
              .updateShift(id)
              .clockIn(clockIn)
              .clockOut(clockOut)
              .observations(observations)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getDay());
      System.out.println(result.getMonth());
      System.out.println(result.getYear());
      System.out.println(result.getClockIn());
      System.out.println(result.getClockOut());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getObservations());
      System.out.println(result.getLocationType());
      System.out.println(result.getInLocationLatitude());
      System.out.println(result.getInLocationLongitude());
      System.out.println(result.getInLocationAccuracy());
      System.out.println(result.getOutLocationLatitude());
      System.out.println(result.getOutLocationLongitude());
      System.out.println(result.getOutLocationAccuracy());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#updateShift");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Shift> response = client
              .shift
              .updateShift(id)
              .clockIn(clockIn)
              .clockOut(clockOut)
              .observations(observations)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ShiftApi#updateShift");
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
| **shiftUpdateShiftRequest** | [**ShiftUpdateShiftRequest**](ShiftUpdateShiftRequest.md)|  | [optional] |

### Return type

[**Shift**](Shift.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

