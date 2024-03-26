# TaskApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addFileToTask**](TaskApi.md#addFileToTask) | **POST** /v1/core/tasks/{id}/files | Create a File in a Task |
| [**copyById**](TaskApi.md#copyById) | **POST** /v1/core/tasks/{id}/copy | Copy Task by ID |
| [**createNewTask**](TaskApi.md#createNewTask) | **POST** /v1/core/tasks | Create a Task |
| [**deleteById**](TaskApi.md#deleteById) | **DELETE** /v1/core/tasks/{id} | Delete a Task by ID |
| [**deleteFileInTask**](TaskApi.md#deleteFileInTask) | **POST** /v1/core/tasks/{task_id}/files/{id} | Delete a File in a Task |
| [**getAllTasks**](TaskApi.md#getAllTasks) | **GET** /v1/core/tasks | Get Tasks |
| [**getById**](TaskApi.md#getById) | **GET** /v1/core/tasks/{id} | Get a Task by ID |
| [**getFile**](TaskApi.md#getFile) | **GET** /v1/core/tasks/{task_id}/files/{id} | Get a file from one Task |
| [**getFiles**](TaskApi.md#getFiles) | **GET** /v1/core/tasks/{id}/files | Get files from a Task |
| [**resolveById**](TaskApi.md#resolveById) | **POST** /v1/core/tasks/{id}/resolve | Resolve Task by ID |
| [**updateById**](TaskApi.md#updateById) | **PUT** /v1/core/tasks/{id} | Update a Task by ID |


<a name="addFileToTask"></a>
# **addFileToTask**
> Task addFileToTask(id).taskAddFileToTaskRequest(taskAddFileToTaskRequest).execute();

Create a File in a Task

Create a File in a Task

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "15"; // (Required)
    File _file = new File("/path/to/file");
    try {
      Task result = client
              .task
              .addFileToTask(id)
              ._file(_file)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#addFileToTask");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .addFileToTask(id)
              ._file(_file)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#addFileToTask");
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
| **taskAddFileToTaskRequest** | [**TaskAddFileToTaskRequest**](TaskAddFileToTaskRequest.md)|  | [optional] |

### Return type

[**Task**](Task.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="copyById"></a>
# **copyById**
> Task copyById(id).taskCopyByIdRequest(taskCopyByIdRequest).execute();

Copy Task by ID

Copy Task by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
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
    String name = "name_example";
    try {
      Task result = client
              .task
              .copyById(id)
              .name(name)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#copyById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .copyById(id)
              .name(name)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#copyById");
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
| **taskCopyByIdRequest** | [**TaskCopyByIdRequest**](TaskCopyByIdRequest.md)|  | [optional] |

### Return type

[**Task**](Task.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="createNewTask"></a>
# **createNewTask**
> Task createNewTask().taskCreateNewTaskRequest(taskCreateNewTaskRequest).execute();

Create a Task

Create a Task

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
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
    String dueOn = "dueOn_example";
    String content = "content_example";
    List<Integer> assigneeIds = Arrays.asList();
    try {
      Task result = client
              .task
              .createNewTask(name)
              .dueOn(dueOn)
              .content(content)
              .assigneeIds(assigneeIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#createNewTask");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .createNewTask(name)
              .dueOn(dueOn)
              .content(content)
              .assigneeIds(assigneeIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#createNewTask");
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
| **taskCreateNewTaskRequest** | [**TaskCreateNewTaskRequest**](TaskCreateNewTaskRequest.md)|  | [optional] |

### Return type

[**Task**](Task.md)

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
> Task deleteById(id).execute();

Delete a Task by ID

Delete a Task by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
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
      Task result = client
              .task
              .deleteById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#deleteById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .deleteById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#deleteById");
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

[**Task**](Task.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="deleteFileInTask"></a>
# **deleteFileInTask**
> TaskFile deleteFileInTask(taskId, id).execute();

Delete a File in a Task

Delete a File in a Task

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String taskId = "15"; // (Required)
    String id = "1"; // (Required)
    try {
      TaskFile result = client
              .task
              .deleteFileInTask(taskId, id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getTaskId());
      System.out.println(result.getFilename());
      System.out.println(result.getPath());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#deleteFileInTask");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<TaskFile> response = client
              .task
              .deleteFileInTask(taskId, id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#deleteFileInTask");
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
| **taskId** | **String**| (Required) | |
| **id** | **String**| (Required) | |

### Return type

[**TaskFile**](TaskFile.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getAllTasks"></a>
# **getAllTasks**
> List&lt;Task&gt; getAllTasks().assigneeId(assigneeId).execute();

Get Tasks

Get Tasks

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    Integer assigneeId = 3; // Retrieves the list of tasks by assignee
    try {
      List<Task> result = client
              .task
              .getAllTasks()
              .assigneeId(assigneeId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getAllTasks");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Task>> response = client
              .task
              .getAllTasks()
              .assigneeId(assigneeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getAllTasks");
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
| **assigneeId** | **Integer**| Retrieves the list of tasks by assignee | [optional] |

### Return type

[**List&lt;Task&gt;**](Task.md)

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
> Task getById(id).execute();

Get a Task by ID

Get a Task by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
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
      Task result = client
              .task
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getById");
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

[**Task**](Task.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getFile"></a>
# **getFile**
> TaskFile getFile(taskId, id).execute();

Get a file from one Task

Get files from one Task

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String taskId = "15"; // (Required)
    String id = "1"; // (Required)
    try {
      TaskFile result = client
              .task
              .getFile(taskId, id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getTaskId());
      System.out.println(result.getFilename());
      System.out.println(result.getPath());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getFile");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<TaskFile> response = client
              .task
              .getFile(taskId, id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getFile");
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
| **taskId** | **String**| (Required) | |
| **id** | **String**| (Required) | |

### Return type

[**TaskFile**](TaskFile.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getFiles"></a>
# **getFiles**
> TaskFile getFiles(id).execute();

Get files from a Task

Get files from a Task

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "15"; // (Required)
    try {
      TaskFile result = client
              .task
              .getFiles(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getTaskId());
      System.out.println(result.getFilename());
      System.out.println(result.getPath());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getFiles");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<TaskFile> response = client
              .task
              .getFiles(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#getFiles");
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

[**TaskFile**](TaskFile.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="resolveById"></a>
# **resolveById**
> Task resolveById(id).taskResolveByIdRequest(taskResolveByIdRequest).execute();

Resolve Task by ID

Resolve Task by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
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
    Boolean done = true;
    try {
      Task result = client
              .task
              .resolveById(id)
              .done(done)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#resolveById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .resolveById(id)
              .done(done)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#resolveById");
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
| **taskResolveByIdRequest** | [**TaskResolveByIdRequest**](TaskResolveByIdRequest.md)|  | [optional] |

### Return type

[**Task**](Task.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateById"></a>
# **updateById**
> Task updateById(id).taskUpdateByIdRequest(taskUpdateByIdRequest).execute();

Update a Task by ID

Update a Task by ID

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.TaskApi;
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
    String dueOn = "dueOn_example";
    String name = "name_example";
    String content = "content_example";
    List<Integer> assigneeIds = Arrays.asList();
    try {
      Task result = client
              .task
              .updateById(id)
              .dueOn(dueOn)
              .name(name)
              .content(content)
              .assigneeIds(assigneeIds)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getContent());
      System.out.println(result.getDueOn());
      System.out.println(result.getAssigneeIds());
      System.out.println(result.getCompletedAt());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#updateById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Task> response = client
              .task
              .updateById(id)
              .dueOn(dueOn)
              .name(name)
              .content(content)
              .assigneeIds(assigneeIds)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskApi#updateById");
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
| **taskUpdateByIdRequest** | [**TaskUpdateByIdRequest**](TaskUpdateByIdRequest.md)|  | [optional] |

### Return type

[**Task**](Task.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

