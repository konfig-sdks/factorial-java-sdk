# CustomFieldValueApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCustomValue**](CustomFieldValueApi.md#createCustomValue) | **POST** /v1/custom_fields/values | Create a value for a custom field |
| [**getBySlugName**](CustomFieldValueApi.md#getBySlugName) | **GET** /v2/custom_fields/values | Get custom field values |
| [**getInstanceValue**](CustomFieldValueApi.md#getInstanceValue) | **GET** /v1/custom_fields/values | Given a custom field, get the value for a specific instance |
| [**updateValue**](CustomFieldValueApi.md#updateValue) | **PUT** /v2/custom_fields/values/{id} | Update custom field value |


<a name="createCustomValue"></a>
# **createCustomValue**
> CustomValue createCustomValue(fieldId, instanceId).customFieldValueCreateCustomValueRequest(customFieldValueCreateCustomValueRequest).execute();

Create a value for a custom field

As described, a &#x60;Custom Field Value&#x60; can be thought of as an answer/response to a &#x60;Custom Field&#x60; these answers/responses belong to the entity that inputed the values e.g. an employee who answered the t-shirt size question by filling it out in their factorial dashboard. This endpoint allows you to create values for custom fields. It requires an &#x60;instance_id&#x60; which refers to the &#x60;id&#x60; of the entity that owns this &#x60;Custom Value&#x60; e.g. an Employee for which the &#x60;employee_id&#x60; will correspond to the &#x60;instance_id&#x60;. It also requires a &#x60;field_id&#x60; to reference the &#x60;Custom Field&#x60; which this value is related to. You can think of &#x60;Custom Fields&#x60; and &#x60;Custom Values&#x60; as questions and answers.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldValueApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    // Configure OAuth2 access token for authorization: oauth2
    configuration.accessToken = "YOUR ACCESS TOKEN";
    Factorial client = new Factorial(configuration);
    String value = "value_example";
    Integer fieldId = 1;
    Integer instanceId = 23;
    try {
      CustomValue result = client
              .customFieldValue
              .createCustomValue(value, fieldId, instanceId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getLabel());
      System.out.println(result.getValue());
      System.out.println(result.getFieldId());
      System.out.println(result.getRequired());
      System.out.println(result.getInstanceId());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#createCustomValue");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomValue> response = client
              .customFieldValue
              .createCustomValue(value, fieldId, instanceId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#createCustomValue");
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
| **fieldId** | **Integer**|  | |
| **instanceId** | **Integer**|  | |
| **customFieldValueCreateCustomValueRequest** | [**CustomFieldValueCreateCustomValueRequest**](CustomFieldValueCreateCustomValueRequest.md)|  | [optional] |

### Return type

[**CustomValue**](CustomValue.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getBySlugName"></a>
# **getBySlugName**
> List&lt;CustomValueV2&gt; getBySlugName().id(id).slugId(slugId).fieldId(fieldId).slugName(slugName).fieldValue(fieldValue).employeeIds(employeeIds).execute();

Get custom field values

This endpoint allows you to retrieve custom fields by id, label, slug name, slug name. You receive fields tagged in the response by a slug. For now, there is one acceptable slug name:   - &#x60;employees-questions&#x60; which refers to fields relating to an employee   You can filter by:   - id: You can query a field value by its id. For example identity card value &#x60;12345678Z&#x60; identifier is 4. you can search the custom field by the id 4.  - value: You can query a field by value. For example an employee have a custom field which is \&quot;Computer\&quot; and it&#39;s value is \&quot;PC\&quot; you can search it by this value.  - slug_name: You can use the available slug &#x60;employees-questions&#x60; in the &#x60;slug_name&#x60; field to filter custom field values that belong to this slug.  - slug_id: It is the identifier of the slug_name. You can use the id of a slug to query custom fields values by its slug id instead of its slug name.  - field_id: You can use the available field id to filter custom field values that belong to this field.  - employee_ids: You can use the available employee ids to filter custom field values that belong to these employees.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldValueApi;
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
    Integer slugId = 1;
    Integer fieldId = 1;
    String slugName = "employees-questions";
    String fieldValue = "red";
    List<Integer> employeeIds = Arrays.asList(); // Employees id array
    try {
      List<CustomValueV2> result = client
              .customFieldValue
              .getBySlugName()
              .id(id)
              .slugId(slugId)
              .fieldId(fieldId)
              .slugName(slugName)
              .fieldValue(fieldValue)
              .employeeIds(employeeIds)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#getBySlugName");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<CustomValueV2>> response = client
              .customFieldValue
              .getBySlugName()
              .id(id)
              .slugId(slugId)
              .fieldId(fieldId)
              .slugName(slugName)
              .fieldValue(fieldValue)
              .employeeIds(employeeIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#getBySlugName");
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
| **id** | **Integer**|  | [optional] |
| **slugId** | **Integer**|  | [optional] |
| **fieldId** | **Integer**|  | [optional] |
| **slugName** | **String**|  | [optional] |
| **fieldValue** | **String**|  | [optional] |
| **employeeIds** | [**List&lt;Integer&gt;**](Integer.md)| Employees id array | [optional] |

### Return type

[**List&lt;CustomValueV2&gt;**](CustomValueV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getInstanceValue"></a>
# **getInstanceValue**
> CustomValue getInstanceValue(fieldId, instanceId).execute();

Given a custom field, get the value for a specific instance

Given a custom field, get the value for a specific instance

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldValueApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    // Configure OAuth2 access token for authorization: oauth2
    configuration.accessToken = "YOUR ACCESS TOKEN";
    Factorial client = new Factorial(configuration);
    Integer fieldId = 1;
    Integer instanceId = 23;
    try {
      CustomValue result = client
              .customFieldValue
              .getInstanceValue(fieldId, instanceId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getLabel());
      System.out.println(result.getValue());
      System.out.println(result.getFieldId());
      System.out.println(result.getRequired());
      System.out.println(result.getInstanceId());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#getInstanceValue");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomValue> response = client
              .customFieldValue
              .getInstanceValue(fieldId, instanceId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#getInstanceValue");
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
| **fieldId** | **Integer**|  | |
| **instanceId** | **Integer**|  | |

### Return type

[**CustomValue**](CustomValue.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateValue"></a>
# **updateValue**
> CustomFieldV2 updateValue(id).customFieldValueUpdateValueRequest(customFieldValueUpdateValueRequest).execute();

Update custom field value

This endpoint allows you to update custom fields values

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldValueApi;
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
    String value = "value_example";
    try {
      CustomFieldV2 result = client
              .customFieldValue
              .updateValue(id)
              .value(value)
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
      System.err.println("Exception when calling CustomFieldValueApi#updateValue");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomFieldV2> response = client
              .customFieldValue
              .updateValue(id)
              .value(value)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldValueApi#updateValue");
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
| **customFieldValueUpdateValueRequest** | [**CustomFieldValueUpdateValueRequest**](CustomFieldValueUpdateValueRequest.md)|  | [optional] |

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
| **200** | OK |  -  |

