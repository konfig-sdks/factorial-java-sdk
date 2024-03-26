# CustomFieldApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createField**](CustomFieldApi.md#createField) | **POST** /v2/custom_fields/fields | Create a custom field |
| [**deleteById**](CustomFieldApi.md#deleteById) | **DELETE** /v2/custom_fields/fields/{id} | Delete a custom field |
| [**getFieldsByGroup**](CustomFieldApi.md#getFieldsByGroup) | **GET** /v1/custom_fields | Get Custom Fields |
| [**getFieldsBySlug**](CustomFieldApi.md#getFieldsBySlug) | **GET** /v2/custom_fields/fields | Get custom fields |


<a name="createField"></a>
# **createField**
> CustomFieldV2 createField().customFieldCreateFieldRequest(customFieldCreateFieldRequest).execute();

Create a custom field

This endpoint allows you to create custom fields you must provide these parameters - label: custom field visible name for example &#x60;T shirt size&#x60; - slug_name: the resource that you want to save the custom field, for example to save &#x60;t-shirt size&#x60; field in employee you must use &#x60;employees-questions&#x60; value - field_type: the kind of field value you want to store: text (input), long text (text area), number (input number) or single choice (select input) - required: You can set if the field is mandatory - visible: You can set the roles can see the field (own, reportees, team leader or everybody) - editable: You can set the roles can edit the field (own, reportees, team leader or everybody) - choice_options: You can provide an array of choices to set the options of a single choice field

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String label = "label_example";
    String slugName = "slugName_example";
    String fieldType = "text";
    Boolean required = true;
    String editable = "owned";
    String visible = "owned";
    Integer minValue = 56;
    Integer maxValue = 56;
    List<CustomFieldCreateFieldRequestChoiceOptionsInner> choiceOptions = Arrays.asList();
    try {
      CustomFieldV2 result = client
              .customField
              .createField(label, slugName, fieldType, required, editable, visible)
              .minValue(minValue)
              .maxValue(maxValue)
              .choiceOptions(choiceOptions)
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
      System.err.println("Exception when calling CustomFieldApi#createField");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomFieldV2> response = client
              .customField
              .createField(label, slugName, fieldType, required, editable, visible)
              .minValue(minValue)
              .maxValue(maxValue)
              .choiceOptions(choiceOptions)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#createField");
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
| **customFieldCreateFieldRequest** | [**CustomFieldCreateFieldRequest**](CustomFieldCreateFieldRequest.md)|  | [optional] |

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

<a name="deleteById"></a>
# **deleteById**
> List&lt;CustomFieldV2&gt; deleteById(id).execute();

Delete a custom field

Delete a custom field by its id

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldApi;
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
      List<CustomFieldV2> result = client
              .customField
              .deleteById(id)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#deleteById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<CustomFieldV2>> response = client
              .customField
              .deleteById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#deleteById");
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

[**List&lt;CustomFieldV2&gt;**](CustomFieldV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getFieldsByGroup"></a>
# **getFieldsByGroup**
> List&lt;CustomField&gt; getFieldsByGroup(fieldGroup).execute();

Get Custom Fields

This endpoint allows you to fetch a collection of custom fields. The fields you receive in the response are governed by the &#x60;field_group&#x60; you supply in the body of your request. For now, there are 2 acceptable field groups:   - &#x60;employees-questions&#x60; which refers to fields relating to an employee   - &#x60;time-tracking-projects&#x60; which refers to fields relating to time tracking data   - &#x60;contract-versions&#x60; which refers to fields relating to employee contract versions

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldApi;
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
    String fieldGroup = "employees-questions"; // Available options: employees-questions (Employee's fields) time-tracking-projects (Shift's project)' contract-versions (Contract versions)'
    try {
      List<CustomField> result = client
              .customField
              .getFieldsByGroup(fieldGroup)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#getFieldsByGroup");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<CustomField>> response = client
              .customField
              .getFieldsByGroup(fieldGroup)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#getFieldsByGroup");
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
| **fieldGroup** | **String**| Available options: employees-questions (Employee&#39;s fields) time-tracking-projects (Shift&#39;s project)&#39; contract-versions (Contract versions)&#39; | |

### Return type

[**List&lt;CustomField&gt;**](CustomField.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getFieldsBySlug"></a>
# **getFieldsBySlug**
> List&lt;CustomFieldV2&gt; getFieldsBySlug().id(id).label(label).slugId(slugId).slugName(slugName).execute();

Get custom fields

This endpoint allows you to retrieve custom fields by id, label, slug name, slug name. You receive fields tagged in the response by a slug. For now, there is one acceptable slug name:   - &#x60;employees-questions&#x60; which refers to fields relating to an employee   You can filter by:   - id: You can query a field by its id. For example &#x60;T-shirt size&#x60; identifier is 4. you can search the custom field by the id 4.  - label: you can query a field by its label for example &#x60;T shirt size&#x60;  - slug_name: You can use the available slug &#x60;employees-questions&#x60; in the &#x60;slug_name&#x60; field to filter fields that belong to this slug.  - slug_id: It is the identifier of the slug_name. You can use the id of a slug to query custom fields by its id instead of its name.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CustomFieldApi;
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
    String label = "tshirt size";
    Integer slugId = 1;
    String slugName = "employees-questions";
    try {
      List<CustomFieldV2> result = client
              .customField
              .getFieldsBySlug()
              .id(id)
              .label(label)
              .slugId(slugId)
              .slugName(slugName)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#getFieldsBySlug");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<CustomFieldV2>> response = client
              .customField
              .getFieldsBySlug()
              .id(id)
              .label(label)
              .slugId(slugId)
              .slugName(slugName)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CustomFieldApi#getFieldsBySlug");
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
| **label** | **String**|  | [optional] |
| **slugId** | **Integer**|  | [optional] |
| **slugName** | **String**|  | [optional] |

### Return type

[**List&lt;CustomFieldV2&gt;**](CustomFieldV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

