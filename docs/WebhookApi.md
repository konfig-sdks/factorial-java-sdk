# WebhookApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSubscription**](WebhookApi.md#createSubscription) | **POST** /v1/core/webhooks | Create a webhook |
| [**deleteWebhook**](WebhookApi.md#deleteWebhook) | **DELETE** /v2/core/webhooks/{id} | Delete a Webhook |
| [**deleteWebhookById**](WebhookApi.md#deleteWebhookById) | **DELETE** /v1/core/webhooks/{id} | Delete a Webhook |
| [**subscriptionCreate**](WebhookApi.md#subscriptionCreate) | **POST** /v2/core/webhooks | Create a webhook |
| [**updateWebhookById**](WebhookApi.md#updateWebhookById) | **PUT** /v2/core/webhooks/{id} | Update a Webhook |


<a name="createSubscription"></a>
# **createSubscription**
> List&lt;Webhook&gt; createSubscription().webhookCreateSubscriptionRequest(webhookCreateSubscriptionRequest).execute();

Create a webhook

&gt; Creates a subscription for a determined webhook type. If webhook already exists, it just changes the target_url.   ## Webhooks Types  | **Type** | **Information** | | --- | --- | | employee_invited | When creating a new employee, optionally you can send an invitation to create an account in Factorial. If you send an invitation, this event gets triggered. | | employee_created | When creating a new employee, after submitting the form, this event gets triggered. | | employee_updated| When updating personal protected employee information such has birthday, this event gets triggered. | | employee_terminated | When terminating an employee, after submitting the form, this event gets triggered | | employee_unterminated | When un terminating an employee, after submitting the form, this event gets triggered | | attendance_clockin | When the user clocks in and starts the timer, this event is triggered. | | attendance_clockout | When the user clocks out and stops the timer, this event is triggered | | attendance_shift_created | When the user creates a shift, this event is triggered | | attendance_shift_updated | When the user edits a shift, this event is triggered | | attendance_shift_deleted | When the user deletes a shift, this event is triggered | | ats_application_created | When a candidate applies for a posting. | | ats_application_updated | When a candidates application for a posting suffers changes. | | ats_job_posting_created | When a job posting is created. | | ats_job_posting_updated | When a job posting is updated. | | ats_job_posting_deleted | When a job posting is deleted. | | timeoff_leave_created | When a Timeoff Leave is created. | | timeoff_leave_destroyed | When a Timeoff Leave is destroyed. | | timeoff_leave_updated | When a Timeoff Leave suffers any changes. | | timeoff_leave_approved | When a Timeoff Leave is explicitly approved. | | timeoff_leave_rejected | When a Timeoff Leave is rejected. | | shift_management_shift_destroyed | When a single Shift Management Shift is destroyed. | | shift_management_shift_bulk_destroyed | When Shift Management Shifts are destroyed in bulk. | | document_created | When a document is created. | | task_created | When a task is created. | | contract_version_created | When a contract version is created. |

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhookApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String type = "type_example";
    String targetUrl = "targetUrl_example";
    try {
      List<Webhook> result = client
              .webhook
              .createSubscription(type, targetUrl)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#createSubscription");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Webhook>> response = client
              .webhook
              .createSubscription(type, targetUrl)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#createSubscription");
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
| **webhookCreateSubscriptionRequest** | [**WebhookCreateSubscriptionRequest**](WebhookCreateSubscriptionRequest.md)|  | [optional] |

### Return type

[**List&lt;Webhook&gt;**](Webhook.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="deleteWebhook"></a>
# **deleteWebhook**
> WebhookV2 deleteWebhook(id).execute();

Delete a Webhook

Delete a Webook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhookApi;
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
      WebhookV2 result = client
              .webhook
              .deleteWebhook(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getSubscriptionType());
      System.out.println(result.getName());
      System.out.println(result.getChallenge());
      System.out.println(result.getTargetUrl());
      System.out.println(result.getCompanyId());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#deleteWebhook");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhookV2> response = client
              .webhook
              .deleteWebhook(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#deleteWebhook");
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

[**WebhookV2**](WebhookV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="deleteWebhookById"></a>
# **deleteWebhookById**
> List&lt;Webhook&gt; deleteWebhookById(id).execute();

Delete a Webhook

Delete a Webhook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhookApi;
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
      List<Webhook> result = client
              .webhook
              .deleteWebhookById(id)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#deleteWebhookById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Webhook>> response = client
              .webhook
              .deleteWebhookById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#deleteWebhookById");
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

[**List&lt;Webhook&gt;**](Webhook.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="subscriptionCreate"></a>
# **subscriptionCreate**
> List&lt;WebhookV2&gt; subscriptionCreate().webhookSubscriptionCreateRequest(webhookSubscriptionCreateRequest).execute();

Create a webhook

&gt; Creates a subscription for a determined webhook type. If webhook already exists, it just changes the target_url.   ## Webhooks Types  | **Subscription Type** | **Information** | | --- | --- | | Authentication::Events::AccessInvited | When creating a new employee, optionally you can send an invitation to create an account in Factorial. If you send an invitation, this event gets triggered. | | Employees::Events::EmployeeCreated | When creating a new employee, after submitting the form, this event gets triggered. | | Employees::Events::EmployeeUpdated| When updating personal protected employee information such has birthday, this event gets triggered. | | Employees::Events::EmployeeTerminated | When terminating an employee, after submitting the form, this event gets triggered | | Employees::Events::EmployeeUnterminated | When un terminating an employee, after submitting the form, this event gets triggered | | Attendance::Events::ClockIn | When the user clocks in and starts the timer, this event is triggered. | | Attendance::Events::ClockOut | When the user clocks out and stops the timer, this event is triggered | | Attendance::Events::AttendanceShiftCreated | When the user creates a shift, this event is triggered | | Attendance::Events::AttendanceShiftUpdated | When the user edits a shift, this event is triggered | | Attendance::Events::AttendanceShiftDeleted | When the user deletes a shift, this event is triggered | | Ats::Events::ApplicationCreated | When a candidate applies for a posting. | | Ats::Events::ApplicationUpdated | When a candidates application for a posting suffers changes. | | Ats::Events::JobPostingCreated | When a job posting is created. | | Ats::Events::JobPostingUpdated | When a job posting is updated. | | Ats::Events::JobPostingDeleted | When a job posting is deleted. | | Timeoff::Events::LeaveCreated | When a Timeoff Leave is created. | | Timeoff::Events::LeaveDestroyed | When a Timeoff Leave is destroyed. | | Timeoff::Events::LeaveUpdated | When a Timeoff Leave suffers any changes. | | Timeoff::Events::LeaveApproved | When a Timeoff Leave is explicitly approved. | | Timeoff::Events::LeaveRejected | When a Timeoff Leave is rejected. | | Documents::Events::Created | When a document is created. | | Tasks::Events::Created | When a task is created. | | Contracts::Events::ContractVersionCreated | When a contract version is created. | | Payroll::Events::SupplementCreated | When a payroll supplement is created. | | Payroll::Events::SupplementUpdated | When a payroll supplement is updated. | | Payroll::Events::SupplementDeleted | When a payroll supplement is deleted. |

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhookApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String subscriptionType = "subscriptionType_example";
    String targetUrl = "targetUrl_example";
    String name = "name_example";
    String challenge = "challenge_example";
    try {
      List<WebhookV2> result = client
              .webhook
              .subscriptionCreate(subscriptionType, targetUrl)
              .name(name)
              .challenge(challenge)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#subscriptionCreate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<WebhookV2>> response = client
              .webhook
              .subscriptionCreate(subscriptionType, targetUrl)
              .name(name)
              .challenge(challenge)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#subscriptionCreate");
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
| **webhookSubscriptionCreateRequest** | [**WebhookSubscriptionCreateRequest**](WebhookSubscriptionCreateRequest.md)|  | [optional] |

### Return type

[**List&lt;WebhookV2&gt;**](WebhookV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateWebhookById"></a>
# **updateWebhookById**
> WebhookV2 updateWebhookById(id).webhookUpdateWebhookByIdRequest(webhookUpdateWebhookByIdRequest).execute();

Update a Webhook

Update a Webook

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.WebhookApi;
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
    String targetUrl = "targetUrl_example";
    String name = "name_example";
    String challenge = "challenge_example";
    try {
      WebhookV2 result = client
              .webhook
              .updateWebhookById(id)
              .targetUrl(targetUrl)
              .name(name)
              .challenge(challenge)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getSubscriptionType());
      System.out.println(result.getName());
      System.out.println(result.getChallenge());
      System.out.println(result.getTargetUrl());
      System.out.println(result.getCompanyId());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#updateWebhookById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<WebhookV2> response = client
              .webhook
              .updateWebhookById(id)
              .targetUrl(targetUrl)
              .name(name)
              .challenge(challenge)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling WebhookApi#updateWebhookById");
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
| **webhookUpdateWebhookByIdRequest** | [**WebhookUpdateWebhookByIdRequest**](WebhookUpdateWebhookByIdRequest.md)|  | [optional] |

### Return type

[**WebhookV2**](WebhookV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

