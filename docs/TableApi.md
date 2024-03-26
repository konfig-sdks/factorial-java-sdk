# TableApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCustomTable**](TableApi.md#createCustomTable) | **POST** /v1/core/custom/tables | Creates a custom table |
| [**createField**](TableApi.md#createField) | **POST** /v1/core/custom/tables/{id}/fields | Creates a custom table field |
| [**getCustomTable**](TableApi.md#getCustomTable) | **GET** /v1/core/custom/tables/{id} | Get Custom Table |
| [**getFields**](TableApi.md#getFields) | **GET** /v1/core/custom/tables/{id}/fields | Get Custom Table Fields |


<a name="createCustomTable"></a>
# **createCustomTable**
> CustomResource createCustomTable().tableCreateCustomTableRequest(tableCreateCustomTableRequest).execute();

Creates a custom table

This endpoint is used to create and store custom table

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TableApi;
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
    try {
      CustomResource result = client
              .table
              .createCustomTable(name)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getTopicName());
      System.out.println(result.getCustomResourcesTopicId());
      System.out.println(result.getReportable());
      System.out.println(result.getHidden());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#createCustomTable");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomResource> response = client
              .table
              .createCustomTable(name)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#createCustomTable");
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
| **tableCreateCustomTableRequest** | [**TableCreateCustomTableRequest**](TableCreateCustomTableRequest.md)|  | [optional] |

### Return type

[**CustomResource**](CustomResource.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="createField"></a>
# **createField**
> CustomFieldV2 createField(id).tableCreateFieldRequest(tableCreateFieldRequest).execute();

Creates a custom table field

This endpoint is used to create and store custom fields on custom tables. See custom fields v2 for more information.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TableApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer id = 56; // The id of the custom table
    Integer id = 1; // Custom Table ID (Required)
    TableCreateFieldRequestCustomField customField = new TableCreateFieldRequestCustomField();
    try {
      CustomFieldV2 result = client
              .table
              .createField(id, id)
              .customField(customField)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getLabel());
      System.out.println(result.getIdentifier());
      System.out.println(result.getPosition());
      System.out.println(result.getRequired());
      System.out.println(result.getFieldType());
      System.out.println(result.getMinValue());
      System.out.println(result.getMaxValue());
      System.out.println(result.getSlugId());
      System.out.println(result.getSlugName());
      System.out.println(result.getChoiceOptions());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#createField");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomFieldV2> response = client
              .table
              .createField(id, id)
              .customField(customField)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#createField");
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
| **id** | **Integer**| Custom Table ID (Required) | |
| **tableCreateFieldRequest** | [**TableCreateFieldRequest**](TableCreateFieldRequest.md)|  | [optional] |

### Return type

[**CustomFieldV2**](CustomFieldV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getCustomTable"></a>
# **getCustomTable**
> CustomResource getCustomTable(id).execute();

Get Custom Table

This endpoint allows you retrieve a Custom Table

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TableApi;
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
      CustomResource result = client
              .table
              .getCustomTable(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getTopicName());
      System.out.println(result.getCustomResourcesTopicId());
      System.out.println(result.getReportable());
      System.out.println(result.getHidden());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#getCustomTable");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomResource> response = client
              .table
              .getCustomTable(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#getCustomTable");
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

[**CustomResource**](CustomResource.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getFields"></a>
# **getFields**
> List&lt;CustomHeader&gt; getFields(id).execute();

Get Custom Table Fields

This endpoint allows you retrieve Custom Table Fields

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TableApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer id = 1; // Custom Table ID (Required)
    try {
      List<CustomHeader> result = client
              .table
              .getFields(id)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#getFields");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<CustomHeader>> response = client
              .table
              .getFields(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TableApi#getFields");
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
| **id** | **Integer**| Custom Table ID (Required) | |

### Return type

[**List&lt;CustomHeader&gt;**](CustomHeader.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

