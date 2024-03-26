# DocumentApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createNewDocument**](DocumentApi.md#createNewDocument) | **POST** /v1/core/documents | Create a Document |
| [**deleteById**](DocumentApi.md#deleteById) | **DELETE** /v1/core/documents/{id} | Delete a Document by ID |
| [**getById**](DocumentApi.md#getById) | **GET** /v1/core/documents/{id} | Get a Document by ID |
| [**listGivenEmployeeOrFolder**](DocumentApi.md#listGivenEmployeeOrFolder) | **GET** /v1/core/documents | Get a collection of Documents |
| [**updateById**](DocumentApi.md#updateById) | **PUT** /v1/core/documents/{id} | Update a Document by ID |


<a name="createNewDocument"></a>
# **createNewDocument**
> Document createNewDocument(filename, _file).employeeId(employeeId).folderId(folderId).requestEsignature(requestEsignature)._public(_public).signees(signees).isPendingAssignment(isPendingAssignment).documentCreateNewDocumentRequest(documentCreateNewDocumentRequest).execute();

Create a Document

Create a Document

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String filename = "filename_example";
    File _file = new File("/path/to/file");
    Integer employeeId = 56;
    Integer folderId = 56;
    Boolean requestEsignature = true;
    Boolean _public = true;
    List<Integer> signees = Arrays.asList();
    Boolean isPendingAssignment = true;
    try {
      Document result = client
              .document
              .createNewDocument(filename, _file)
              .employeeId(employeeId)
              .folderId(folderId)
              .requestEsignature(requestEsignature)
              ._public(_public)
              .signees(signees)
              .isPendingAssignment(isPendingAssignment)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCompanyId());
      System.out.println(result.getFolderId());
      System.out.println(result.getUrl());
      System.out.println(result.getFilename());
      System.out.println(result.getPublic());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#createNewDocument");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Document> response = client
              .document
              .createNewDocument(filename, _file)
              .employeeId(employeeId)
              .folderId(folderId)
              .requestEsignature(requestEsignature)
              ._public(_public)
              .signees(signees)
              .isPendingAssignment(isPendingAssignment)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#createNewDocument");
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
| **filename** | **String**|  | |
| **_file** | **File**|  | |
| **employeeId** | **Integer**|  | [optional] |
| **folderId** | **Integer**|  | [optional] |
| **requestEsignature** | **Boolean**|  | [optional] |
| **_public** | **Boolean**|  | [optional] |
| **signees** | [**List&lt;Integer&gt;**](Integer.md)|  | [optional] |
| **isPendingAssignment** | **Boolean**|  | [optional] |
| **documentCreateNewDocumentRequest** | [**DocumentCreateNewDocumentRequest**](DocumentCreateNewDocumentRequest.md)|  | [optional] |

### Return type

[**Document**](Document.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="deleteById"></a>
# **deleteById**
> Document deleteById(id).execute();

Delete a Document by ID

Delete a Document by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
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
      Document result = client
              .document
              .deleteById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCompanyId());
      System.out.println(result.getFolderId());
      System.out.println(result.getUrl());
      System.out.println(result.getFilename());
      System.out.println(result.getPublic());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#deleteById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Document> response = client
              .document
              .deleteById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#deleteById");
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

[**Document**](Document.md)

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
> Document getById(id).execute();

Get a Document by ID

Get a Document by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
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
      Document result = client
              .document
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCompanyId());
      System.out.println(result.getFolderId());
      System.out.println(result.getUrl());
      System.out.println(result.getFilename());
      System.out.println(result.getPublic());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Document> response = client
              .document
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#getById");
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

[**Document**](Document.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listGivenEmployeeOrFolder"></a>
# **listGivenEmployeeOrFolder**
> List&lt;Document&gt; listGivenEmployeeOrFolder().employeeId(employeeId).folderId(folderId).execute();

Get a collection of Documents

Get a collection of Documents given an employee or a folder

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer employeeId = 1; // Retrieves the list of documents by employee id
    Integer folderId = 1; // Retrieves the list of documents by folder id
    try {
      List<Document> result = client
              .document
              .listGivenEmployeeOrFolder()
              .employeeId(employeeId)
              .folderId(folderId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#listGivenEmployeeOrFolder");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Document>> response = client
              .document
              .listGivenEmployeeOrFolder()
              .employeeId(employeeId)
              .folderId(folderId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#listGivenEmployeeOrFolder");
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
| **employeeId** | **Integer**| Retrieves the list of documents by employee id | [optional] |
| **folderId** | **Integer**| Retrieves the list of documents by folder id | [optional] |

### Return type

[**List&lt;Document&gt;**](Document.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateById"></a>
# **updateById**
> Document updateById(id).documentUpdateByIdRequest(documentUpdateByIdRequest).execute();

Update a Document by ID

Update a Document by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.DocumentApi;
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
    Boolean _public = true;
    Integer employeeId = 56;
    Integer folderId = 56;
    Boolean requestEsignature = true;
    List<Integer> signees = Arrays.asList();
    try {
      Document result = client
              .document
              .updateById(id)
              ._public(_public)
              .employeeId(employeeId)
              .folderId(folderId)
              .requestEsignature(requestEsignature)
              .signees(signees)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
      System.out.println(result.getCompanyId());
      System.out.println(result.getFolderId());
      System.out.println(result.getUrl());
      System.out.println(result.getFilename());
      System.out.println(result.getPublic());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#updateById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Document> response = client
              .document
              .updateById(id)
              ._public(_public)
              .employeeId(employeeId)
              .folderId(folderId)
              .requestEsignature(requestEsignature)
              .signees(signees)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling DocumentApi#updateById");
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
| **documentUpdateByIdRequest** | [**DocumentUpdateByIdRequest**](DocumentUpdateByIdRequest.md)|  | [optional] |

### Return type

[**Document**](Document.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

