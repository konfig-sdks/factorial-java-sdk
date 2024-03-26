# ApplicationApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAtsApplication**](ApplicationApi.md#createAtsApplication) | **POST** /v1/ats/applications | Creates an application |
| [**updateData**](ApplicationApi.md#updateData) | **PUT** /v1/ats/applications/{id} | Update application |


<a name="createAtsApplication"></a>
# **createAtsApplication**
> AtsApplication createAtsApplication(atsJobPostingId, source).medium(medium).atsCandidateId(atsCandidateId).coverLetter(coverLetter).firstName(firstName).lastName(lastName).phone(phone).email(email).cv(cv).photo(photo).answers(answers).applicationCreateAtsApplicationRequest(applicationCreateAtsApplicationRequest).execute();

Creates an application

This endpoint allows a consumer to create and store Ats Applications in Factorial

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ApplicationApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer atsJobPostingId = 56;
    String source = "indeed";
    String medium = "medium_example";
    Integer atsCandidateId = 56;
    String coverLetter = "coverLetter_example";
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String phone = "phone_example";
    String email = "email_example";
    File cv = new File("/path/to/file");
    File photo = new File("/path/to/file");
    List<ApplicationCreateAtsApplicationRequestAnswersInner> answers = Arrays.asList();
    try {
      AtsApplication result = client
              .application
              .createAtsApplication(atsJobPostingId, source)
              .medium(medium)
              .atsCandidateId(atsCandidateId)
              .coverLetter(coverLetter)
              .firstName(firstName)
              .lastName(lastName)
              .phone(phone)
              .email(email)
              .cv(cv)
              .photo(photo)
              .answers(answers)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getAtsCandidateId());
      System.out.println(result.getAtsJobPostingId());
      System.out.println(result.getAtsApplicationPhaseId());
      System.out.println(result.getAtsApplicationPhaseName());
      System.out.println(result.getAtsApplicationPhaseType());
      System.out.println(result.getAtsJobPostingTitle());
      System.out.println(result.getConversationId());
      System.out.println(result.getCoverLetter());
      System.out.println(result.getCv());
      System.out.println(result.getPhoto());
      System.out.println(result.getDisqualifiedReason());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getFullName());
      System.out.println(result.getLastName());
      System.out.println(result.getMedium());
      System.out.println(result.getPersonalUrl());
      System.out.println(result.getPhone());
      System.out.println(result.getQualified());
      System.out.println(result.getRatingAverage());
      System.out.println(result.getSource());
      System.out.println(result.getTalentPool());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getAnswers());
    } catch (ApiException e) {
      System.err.println("Exception when calling ApplicationApi#createAtsApplication");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsApplication> response = client
              .application
              .createAtsApplication(atsJobPostingId, source)
              .medium(medium)
              .atsCandidateId(atsCandidateId)
              .coverLetter(coverLetter)
              .firstName(firstName)
              .lastName(lastName)
              .phone(phone)
              .email(email)
              .cv(cv)
              .photo(photo)
              .answers(answers)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ApplicationApi#createAtsApplication");
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
| **atsJobPostingId** | **Integer**|  | |
| **source** | **String**|  | [enum: indeed, linkedin, JobTarget, manually_added, organic, jobposting, JOIN] |
| **medium** | **String**|  | [optional] |
| **atsCandidateId** | **Integer**|  | [optional] |
| **coverLetter** | **String**|  | [optional] |
| **firstName** | **String**|  | [optional] |
| **lastName** | **String**|  | [optional] |
| **phone** | **String**|  | [optional] |
| **email** | **String**|  | [optional] |
| **cv** | **File**|  | [optional] |
| **photo** | **File**|  | [optional] |
| **answers** | [**List&lt;ApplicationCreateAtsApplicationRequestAnswersInner&gt;**](ApplicationCreateAtsApplicationRequestAnswersInner.md)|  | [optional] |
| **applicationCreateAtsApplicationRequest** | [**ApplicationCreateAtsApplicationRequest**](ApplicationCreateAtsApplicationRequest.md)|  | [optional] |

### Return type

[**AtsApplication**](AtsApplication.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="updateData"></a>
# **updateData**
> AtsApplication updateData(id).applicationUpdateDataRequest(applicationUpdateDataRequest).execute();

Update application

Update ATS Application data

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.ApplicationApi;
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
    Integer atsApplicationPhaseId = 56;
    Boolean qualified = true;
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String phone = "phone_example";
    String email = "email_example";
    String personalUrl = "personalUrl_example";
    String disqualifiedReason = "not_a_fit";
    File cv = new File("/path/to/file");
    File photo = new File("/path/to/file");
    try {
      AtsApplication result = client
              .application
              .updateData(id)
              .atsApplicationPhaseId(atsApplicationPhaseId)
              .qualified(qualified)
              .firstName(firstName)
              .lastName(lastName)
              .phone(phone)
              .email(email)
              .personalUrl(personalUrl)
              .disqualifiedReason(disqualifiedReason)
              .cv(cv)
              .photo(photo)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getAtsCandidateId());
      System.out.println(result.getAtsJobPostingId());
      System.out.println(result.getAtsApplicationPhaseId());
      System.out.println(result.getAtsApplicationPhaseName());
      System.out.println(result.getAtsApplicationPhaseType());
      System.out.println(result.getAtsJobPostingTitle());
      System.out.println(result.getConversationId());
      System.out.println(result.getCoverLetter());
      System.out.println(result.getCv());
      System.out.println(result.getPhoto());
      System.out.println(result.getDisqualifiedReason());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getFullName());
      System.out.println(result.getLastName());
      System.out.println(result.getMedium());
      System.out.println(result.getPersonalUrl());
      System.out.println(result.getPhone());
      System.out.println(result.getQualified());
      System.out.println(result.getRatingAverage());
      System.out.println(result.getSource());
      System.out.println(result.getTalentPool());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getAnswers());
    } catch (ApiException e) {
      System.err.println("Exception when calling ApplicationApi#updateData");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsApplication> response = client
              .application
              .updateData(id)
              .atsApplicationPhaseId(atsApplicationPhaseId)
              .qualified(qualified)
              .firstName(firstName)
              .lastName(lastName)
              .phone(phone)
              .email(email)
              .personalUrl(personalUrl)
              .disqualifiedReason(disqualifiedReason)
              .cv(cv)
              .photo(photo)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling ApplicationApi#updateData");
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
| **applicationUpdateDataRequest** | [**ApplicationUpdateDataRequest**](ApplicationUpdateDataRequest.md)|  | [optional] |

### Return type

[**AtsApplication**](AtsApplication.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

