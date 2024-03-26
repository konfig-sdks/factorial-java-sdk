# MessageApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAtsMessage**](MessageApi.md#createAtsMessage) | **POST** /v1/ats/messages | Creates an ats messsage |
| [**getAllMessages**](MessageApi.md#getAllMessages) | **GET** /v1/ats/messages | Get all ATS Messages |


<a name="createAtsMessage"></a>
# **createAtsMessage**
> AtsMessage createAtsMessage().messageCreateAtsMessageRequest(messageCreateAtsMessageRequest).execute();

Creates an ats messsage

This endpoint allows you create and store Ats Messages in Factorial, while using your own user interface to display them.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MessageApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer jobApplicationId = 56;
    String content = "content_example";
    try {
      AtsMessage result = client
              .message
              .createAtsMessage(jobApplicationId, content)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getConversationId());
      System.out.println(result.getContent());
      System.out.println(result.getSentByType());
      System.out.println(result.getSentAt());
      System.out.println(result.getSentById());
      System.out.println(result.getAttachments());
    } catch (ApiException e) {
      System.err.println("Exception when calling MessageApi#createAtsMessage");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsMessage> response = client
              .message
              .createAtsMessage(jobApplicationId, content)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MessageApi#createAtsMessage");
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
| **messageCreateAtsMessageRequest** | [**MessageCreateAtsMessageRequest**](MessageCreateAtsMessageRequest.md)|  | [optional] |

### Return type

[**AtsMessage**](AtsMessage.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getAllMessages"></a>
# **getAllMessages**
> List&lt;AtsMessage&gt; getAllMessages(conversationId).execute();

Get all ATS Messages

Get all ATS Messages

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.MessageApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String conversationId = "3"; // (Required)
    try {
      List<AtsMessage> result = client
              .message
              .getAllMessages(conversationId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MessageApi#getAllMessages");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<AtsMessage>> response = client
              .message
              .getAllMessages(conversationId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling MessageApi#getAllMessages");
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
| **conversationId** | **String**| (Required) | |

### Return type

[**List&lt;AtsMessage&gt;**](AtsMessage.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

