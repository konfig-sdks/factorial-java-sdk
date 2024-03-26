# PostApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**atsJobPosting**](PostApi.md#atsJobPosting) | **POST** /v1/ats/job_postings | Create a Job Posting |
| [**createNewPost**](PostApi.md#createNewPost) | **POST** /v1/posts | Create a Post |
| [**duplicateJobPosting**](PostApi.md#duplicateJobPosting) | **POST** /v1/ats/job_postings/{id}/duplicate | Duplicate a Job Posting |
| [**getAllPostings**](PostApi.md#getAllPostings) | **GET** /v1/ats/job_postings | Get all job postings |
| [**getById**](PostApi.md#getById) | **GET** /v1/posts/{id} | Get Post |
| [**jobPostingUpdate**](PostApi.md#jobPostingUpdate) | **PUT** /v1/ats/job_postings/{id} | Update a Job Posting |
| [**listPosts**](PostApi.md#listPosts) | **GET** /v1/posts | Get Posts |
| [**removeJobPosting**](PostApi.md#removeJobPosting) | **DELETE** /v1/ats/job_postings/{id} | Delete a Job Posting |
| [**removePost**](PostApi.md#removePost) | **DELETE** /v1/posts/{id} | Delete Post |
| [**updateExistingPost**](PostApi.md#updateExistingPost) | **PUT** /v1/posts/{id} | Create a Post |


<a name="atsJobPosting"></a>
# **atsJobPosting**
> AtsJobPosting atsJobPosting().postAtsJobPostingRequest(postAtsJobPostingRequest).execute();

Create a Job Posting

This endpoint allows you create and store Ats Job Postings in Factorial.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String title = "title_example";
    String status = "draft";
    String description = "description_example";
    String contractType = "indefinite";
    Boolean remote = true;
    String scheduleType = "full_time";
    Integer teamId = 56;
    Integer locationId = 56;
    String salaryFormat = "range";
    Integer salaryFromAmountInCents = 56;
    Integer salaryToAmountInCents = 56;
    String cvRequirement = "mandatory";
    String coverLetterRequirement = "mandatory";
    String phoneRequirement = "mandatory";
    String photoRequirement = "mandatory";
    try {
      AtsJobPosting result = client
              .post
              .atsJobPosting(title, status)
              .description(description)
              .contractType(contractType)
              .remote(remote)
              .scheduleType(scheduleType)
              .teamId(teamId)
              .locationId(locationId)
              .salaryFormat(salaryFormat)
              .salaryFromAmountInCents(salaryFromAmountInCents)
              .salaryToAmountInCents(salaryToAmountInCents)
              .cvRequirement(cvRequirement)
              .coverLetterRequirement(coverLetterRequirement)
              .phoneRequirement(phoneRequirement)
              .photoRequirement(photoRequirement)
              .execute();
      System.out.println(result);
      System.out.println(result.getTitle());
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getCreationDate());
      System.out.println(result.getRemote());
      System.out.println(result.getStatus());
      System.out.println(result.getScheduleType());
      System.out.println(result.getTeamId());
      System.out.println(result.getLocationId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getAtsCompanyId());
      System.out.println(result.getSalaryFormat());
      System.out.println(result.getSalaryFromAmountInCents());
      System.out.println(result.getSalaryToAmountInCents());
      System.out.println(result.getCvRequirement());
      System.out.println(result.getCoverLetterRequirement());
      System.out.println(result.getPhoneRequirement());
      System.out.println(result.getPhotoRequirement());
      System.out.println(result.getQuestions());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#atsJobPosting");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsJobPosting> response = client
              .post
              .atsJobPosting(title, status)
              .description(description)
              .contractType(contractType)
              .remote(remote)
              .scheduleType(scheduleType)
              .teamId(teamId)
              .locationId(locationId)
              .salaryFormat(salaryFormat)
              .salaryFromAmountInCents(salaryFromAmountInCents)
              .salaryToAmountInCents(salaryToAmountInCents)
              .cvRequirement(cvRequirement)
              .coverLetterRequirement(coverLetterRequirement)
              .phoneRequirement(phoneRequirement)
              .photoRequirement(photoRequirement)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#atsJobPosting");
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
| **postAtsJobPostingRequest** | [**PostAtsJobPostingRequest**](PostAtsJobPostingRequest.md)|  | [optional] |

### Return type

[**AtsJobPosting**](AtsJobPosting.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="createNewPost"></a>
# **createNewPost**
> List&lt;Post&gt; createNewPost().postCreateNewPostRequest(postCreateNewPostRequest).execute();

Create a Post

Create a Post

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String title = "title_example";
    String description = "description_example";
    Integer postsGroupId = 56;
    String type = "event";
    String publishedAt = "publishedAt_example";
    String starsAt = "starsAt_example";
    String endsAt = "endsAt_example";
    String location = "location_example";
    Integer targetId = 56;
    Boolean sendNotifications = true;
    File image = new File("/path/to/file");
    Boolean allowCommentsAndReactions = true;
    File attachments = new File("/path/to/file");
    try {
      List<Post> result = client
              .post
              .createNewPost(title, description, postsGroupId, type, publishedAt)
              .starsAt(starsAt)
              .endsAt(endsAt)
              .location(location)
              .targetId(targetId)
              .sendNotifications(sendNotifications)
              .image(image)
              .allowCommentsAndReactions(allowCommentsAndReactions)
              .attachments(attachments)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#createNewPost");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Post>> response = client
              .post
              .createNewPost(title, description, postsGroupId, type, publishedAt)
              .starsAt(starsAt)
              .endsAt(endsAt)
              .location(location)
              .targetId(targetId)
              .sendNotifications(sendNotifications)
              .image(image)
              .allowCommentsAndReactions(allowCommentsAndReactions)
              .attachments(attachments)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#createNewPost");
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
| **postCreateNewPostRequest** | [**PostCreateNewPostRequest**](PostCreateNewPostRequest.md)|  | [optional] |

### Return type

[**List&lt;Post&gt;**](Post.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="duplicateJobPosting"></a>
# **duplicateJobPosting**
> AtsJobPosting duplicateJobPosting(id).execute();

Duplicate a Job Posting

Make a duplicate of a job posting. The only parameter required for this operation is the id of the posting you wish to duplicate. One thing to note about this operation is that the id of the resulting posting will be different from the original, the title will have Copy appended to it, so if your origin title was Don&#39;t buy a the title of the duplicate will be Don&#39;t buy a Copy in addition to this, the status of the duplicate will default to draft. All this being said, kindly inspect the duplicate and ensure you get it into your desired state.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
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
      AtsJobPosting result = client
              .post
              .duplicateJobPosting(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getTitle());
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getCreationDate());
      System.out.println(result.getRemote());
      System.out.println(result.getStatus());
      System.out.println(result.getScheduleType());
      System.out.println(result.getTeamId());
      System.out.println(result.getLocationId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getAtsCompanyId());
      System.out.println(result.getSalaryFormat());
      System.out.println(result.getSalaryFromAmountInCents());
      System.out.println(result.getSalaryToAmountInCents());
      System.out.println(result.getCvRequirement());
      System.out.println(result.getCoverLetterRequirement());
      System.out.println(result.getPhoneRequirement());
      System.out.println(result.getPhotoRequirement());
      System.out.println(result.getQuestions());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#duplicateJobPosting");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsJobPosting> response = client
              .post
              .duplicateJobPosting(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#duplicateJobPosting");
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

[**AtsJobPosting**](AtsJobPosting.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getAllPostings"></a>
# **getAllPostings**
> List&lt;AtsJobPosting&gt; getAllPostings().status(status).teamId(teamId).locationId(locationId).legalEntityId(legalEntityId).execute();

Get all job postings

This endpoint allows fetching all available Ats Job Postings, scoped to the user credentials and company of that user.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String status = "draft"; // Job posting status
    Integer teamId = 3; // An id of any teams that the ats company has in Factorial
    String locationId = "1"; // An id of any location associated with the ats company in Factorial
    Integer legalEntityId = 1; // An id of any legal entity associated with the company in Factorial
    try {
      List<AtsJobPosting> result = client
              .post
              .getAllPostings()
              .status(status)
              .teamId(teamId)
              .locationId(locationId)
              .legalEntityId(legalEntityId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#getAllPostings");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<AtsJobPosting>> response = client
              .post
              .getAllPostings()
              .status(status)
              .teamId(teamId)
              .locationId(locationId)
              .legalEntityId(legalEntityId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#getAllPostings");
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
| **status** | **String**| Job posting status | [optional] [enum: draft, published, unlisted, archived, cancelled] |
| **teamId** | **Integer**| An id of any teams that the ats company has in Factorial | [optional] |
| **locationId** | **String**| An id of any location associated with the ats company in Factorial | [optional] |
| **legalEntityId** | **Integer**| An id of any legal entity associated with the company in Factorial | [optional] |

### Return type

[**List&lt;AtsJobPosting&gt;**](AtsJobPosting.md)

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
> Post getById(id).execute();

Get Post

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
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
    String id = "1"; // (Required)
    try {
      Post result = client
              .post
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getTitle());
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getType());
      System.out.println(result.getAllowCommentsAndReactions());
      System.out.println(result.getLocation());
      System.out.println(result.getPublishedAt());
      System.out.println(result.getStartsAt());
      System.out.println(result.getEndsAt());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getVisitsCount());
      System.out.println(result.getCommentsCount());
      System.out.println(result.getReactionsCount());
      System.out.println(result.getCoverImageUrl());
      System.out.println(result.getAuthorId());
      System.out.println(result.getPostsGroupId());
      System.out.println(result.getTargetId());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Post> response = client
              .post
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#getById");
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

[**Post**](Post.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="jobPostingUpdate"></a>
# **jobPostingUpdate**
> AtsJobPosting jobPostingUpdate(id).postJobPostingUpdateRequest(postJobPostingUpdateRequest).execute();

Update a Job Posting

Update a Job Posting

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
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
    String title = "title_example";
    String description = "description_example";
    String contractType = "indefinite";
    Boolean remote = true;
    String status = "draft";
    String scheduleType = "full_time";
    Integer teamId = 56;
    Integer locationId = 56;
    String salaryFormat = "range";
    Integer salaryFromAmountInCents = 56;
    Integer salaryToAmountInCents = 56;
    String cvRequirement = "mandatory";
    String coverLetterRequirement = "mandatory";
    String phoneRequirement = "mandatory";
    String photoRequirement = "mandatory";
    try {
      AtsJobPosting result = client
              .post
              .jobPostingUpdate(id)
              .title(title)
              .description(description)
              .contractType(contractType)
              .remote(remote)
              .status(status)
              .scheduleType(scheduleType)
              .teamId(teamId)
              .locationId(locationId)
              .salaryFormat(salaryFormat)
              .salaryFromAmountInCents(salaryFromAmountInCents)
              .salaryToAmountInCents(salaryToAmountInCents)
              .cvRequirement(cvRequirement)
              .coverLetterRequirement(coverLetterRequirement)
              .phoneRequirement(phoneRequirement)
              .photoRequirement(photoRequirement)
              .execute();
      System.out.println(result);
      System.out.println(result.getTitle());
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getCreationDate());
      System.out.println(result.getRemote());
      System.out.println(result.getStatus());
      System.out.println(result.getScheduleType());
      System.out.println(result.getTeamId());
      System.out.println(result.getLocationId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getAtsCompanyId());
      System.out.println(result.getSalaryFormat());
      System.out.println(result.getSalaryFromAmountInCents());
      System.out.println(result.getSalaryToAmountInCents());
      System.out.println(result.getCvRequirement());
      System.out.println(result.getCoverLetterRequirement());
      System.out.println(result.getPhoneRequirement());
      System.out.println(result.getPhotoRequirement());
      System.out.println(result.getQuestions());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#jobPostingUpdate");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsJobPosting> response = client
              .post
              .jobPostingUpdate(id)
              .title(title)
              .description(description)
              .contractType(contractType)
              .remote(remote)
              .status(status)
              .scheduleType(scheduleType)
              .teamId(teamId)
              .locationId(locationId)
              .salaryFormat(salaryFormat)
              .salaryFromAmountInCents(salaryFromAmountInCents)
              .salaryToAmountInCents(salaryToAmountInCents)
              .cvRequirement(cvRequirement)
              .coverLetterRequirement(coverLetterRequirement)
              .phoneRequirement(phoneRequirement)
              .photoRequirement(photoRequirement)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#jobPostingUpdate");
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
| **postJobPostingUpdateRequest** | [**PostJobPostingUpdateRequest**](PostJobPostingUpdateRequest.md)|  | [optional] |

### Return type

[**AtsJobPosting**](AtsJobPosting.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listPosts"></a>
# **listPosts**
> List&lt;Post&gt; listPosts().execute();

Get Posts

This endpoint allows you to fetch a collection of posts.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
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
      List<Post> result = client
              .post
              .listPosts()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#listPosts");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Post>> response = client
              .post
              .listPosts()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#listPosts");
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

[**List&lt;Post&gt;**](Post.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |
| **500** | Internal Server Error |  -  |

<a name="removeJobPosting"></a>
# **removeJobPosting**
> AtsJobPosting removeJobPosting(id).execute();

Delete a Job Posting

Deletes an existing job posting

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
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
      AtsJobPosting result = client
              .post
              .removeJobPosting(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getTitle());
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getCreationDate());
      System.out.println(result.getRemote());
      System.out.println(result.getStatus());
      System.out.println(result.getScheduleType());
      System.out.println(result.getTeamId());
      System.out.println(result.getLocationId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getAtsCompanyId());
      System.out.println(result.getSalaryFormat());
      System.out.println(result.getSalaryFromAmountInCents());
      System.out.println(result.getSalaryToAmountInCents());
      System.out.println(result.getCvRequirement());
      System.out.println(result.getCoverLetterRequirement());
      System.out.println(result.getPhoneRequirement());
      System.out.println(result.getPhotoRequirement());
      System.out.println(result.getQuestions());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#removeJobPosting");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<AtsJobPosting> response = client
              .post
              .removeJobPosting(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#removeJobPosting");
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

[**AtsJobPosting**](AtsJobPosting.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="removePost"></a>
# **removePost**
> Post removePost(id).execute();

Delete Post

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
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
    String id = "1"; // (Required)
    try {
      Post result = client
              .post
              .removePost(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getTitle());
      System.out.println(result.getDescription());
      System.out.println(result.getId());
      System.out.println(result.getType());
      System.out.println(result.getAllowCommentsAndReactions());
      System.out.println(result.getLocation());
      System.out.println(result.getPublishedAt());
      System.out.println(result.getStartsAt());
      System.out.println(result.getEndsAt());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getVisitsCount());
      System.out.println(result.getCommentsCount());
      System.out.println(result.getReactionsCount());
      System.out.println(result.getCoverImageUrl());
      System.out.println(result.getAuthorId());
      System.out.println(result.getPostsGroupId());
      System.out.println(result.getTargetId());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#removePost");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Post> response = client
              .post
              .removePost(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#removePost");
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

[**Post**](Post.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateExistingPost"></a>
# **updateExistingPost**
> List&lt;Post&gt; updateExistingPost(id).postUpdateExistingPostRequest(postUpdateExistingPostRequest).execute();

Create a Post

Create a Post

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.PostApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer id = 56;
    String id = "1"; // (Required)
    String title = "title_example";
    String description = "description_example";
    String starsAt = "starsAt_example";
    String location = "location_example";
    Boolean sendNotifications = true;
    Boolean deleteCoverImage = true;
    File image = new File("/path/to/file");
    Boolean allowCommentsAndReactions = true;
    File attachments = new File("/path/to/file");
    List<Integer> deletedAttachments = Arrays.asList();
    try {
      List<Post> result = client
              .post
              .updateExistingPost(id, id)
              .title(title)
              .description(description)
              .starsAt(starsAt)
              .location(location)
              .sendNotifications(sendNotifications)
              .deleteCoverImage(deleteCoverImage)
              .image(image)
              .allowCommentsAndReactions(allowCommentsAndReactions)
              .attachments(attachments)
              .deletedAttachments(deletedAttachments)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#updateExistingPost");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Post>> response = client
              .post
              .updateExistingPost(id, id)
              .title(title)
              .description(description)
              .starsAt(starsAt)
              .location(location)
              .sendNotifications(sendNotifications)
              .deleteCoverImage(deleteCoverImage)
              .image(image)
              .allowCommentsAndReactions(allowCommentsAndReactions)
              .attachments(attachments)
              .deletedAttachments(deletedAttachments)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling PostApi#updateExistingPost");
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
| **postUpdateExistingPostRequest** | [**PostUpdateExistingPostRequest**](PostUpdateExistingPostRequest.md)|  | [optional] |

### Return type

[**List&lt;Post&gt;**](Post.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

