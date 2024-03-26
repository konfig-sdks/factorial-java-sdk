# CandidateApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewCandidate**](CandidateApi.md#createNewCandidate) | **POST** /v1/ats/candidates | Create a candidate |
| [**deleteExistingCandidate**](CandidateApi.md#deleteExistingCandidate) | **DELETE** /v1/ats/candidates/{id} | Delete a Candidate |
| [**listAllCandidates**](CandidateApi.md#listAllCandidates) | **GET** /v1/ats/candidates | Get all candidates |
| [**updateCandidateData**](CandidateApi.md#updateCandidateData) | **PUT** /v1/ats/candidates/{id} | Update candidate |


<a name="createNewCandidate"></a>
# **createNewCandidate**
> AtsCandidate createNewCandidate().candidateCreateNewCandidateRequest(candidateCreateNewCandidateRequest).execute();

Create a candidate

Create candidates related to a particular company in an ATS

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CandidateApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String email = "email_example";
    String source = "indeed";
    String medium = "medium_example";
    try {
      AtsCandidate result = client
              .candidate
              .createNewCandidate(firstName, lastName, email)
              .source(source)
              .medium(medium)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getTalentPool());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getSource());
      System.out.println(result.getMedium());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#createNewCandidate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsCandidate> response = client
              .candidate
              .createNewCandidate(firstName, lastName, email)
              .source(source)
              .medium(medium)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#createNewCandidate");
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
| **candidateCreateNewCandidateRequest** | [**CandidateCreateNewCandidateRequest**](CandidateCreateNewCandidateRequest.md)|  | [optional] |

### Return type

[**AtsCandidate**](AtsCandidate.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="deleteExistingCandidate"></a>
# **deleteExistingCandidate**
> AtsCandidate deleteExistingCandidate(id).execute();

Delete a Candidate

Deletes an existing candidate

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CandidateApi;
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
      AtsCandidate result = client
              .candidate
              .deleteExistingCandidate(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getTalentPool());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getSource());
      System.out.println(result.getMedium());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#deleteExistingCandidate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsCandidate> response = client
              .candidate
              .deleteExistingCandidate(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#deleteExistingCandidate");
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

[**AtsCandidate**](AtsCandidate.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listAllCandidates"></a>
# **listAllCandidates**
> List&lt;AtsCandidate&gt; listAllCandidates().execute();

Get all candidates

Fetch candidates data from Factorial. When using administrator-level API Credentials, all candidates associated with a company will be returned. When using non-admin level API credentials, only candidates that applied to a job for which the user is a hiring manager will be returned.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CandidateApi;
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
      List<AtsCandidate> result = client
              .candidate
              .listAllCandidates()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#listAllCandidates");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<AtsCandidate>> response = client
              .candidate
              .listAllCandidates()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#listAllCandidates");
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

[**List&lt;AtsCandidate&gt;**](AtsCandidate.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateCandidateData"></a>
# **updateCandidateData**
> AtsCandidate updateCandidateData(id).candidateUpdateCandidateDataRequest(candidateUpdateCandidateDataRequest).execute();

Update candidate

Update ATS Candidates data

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.CandidateApi;
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
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String email = "email_example";
    Boolean talentPool = true;
    Boolean consentToTalentPool = true;
    try {
      AtsCandidate result = client
              .candidate
              .updateCandidateData(id)
              .firstName(firstName)
              .lastName(lastName)
              .email(email)
              .talentPool(talentPool)
              .consentToTalentPool(consentToTalentPool)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getTalentPool());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getSource());
      System.out.println(result.getMedium());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#updateCandidateData");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsCandidate> response = client
              .candidate
              .updateCandidateData(id)
              .firstName(firstName)
              .lastName(lastName)
              .email(email)
              .talentPool(talentPool)
              .consentToTalentPool(consentToTalentPool)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling CandidateApi#updateCandidateData");
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
| **candidateUpdateCandidateDataRequest** | [**CandidateUpdateCandidateDataRequest**](CandidateUpdateCandidateDataRequest.md)|  | [optional] |

### Return type

[**AtsCandidate**](AtsCandidate.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

