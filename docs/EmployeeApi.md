# EmployeeApi

All URIs are relative to *https://api.factorialhr.com/api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**assignToTeam**](EmployeeApi.md#assignToTeam) | **POST** /v1/core/teams/{id}/employees/{employee_id} | Assign an employee to a team |
| [**changeEmail**](EmployeeApi.md#changeEmail) | **PUT** /v2/core/employees/{id}/email | Change employee email |
| [**createCustomTableValue**](EmployeeApi.md#createCustomTableValue) | **POST** /v1/core/custom/tables/{id}/values/{employee_id} | Creates a custom table value |
| [**createEmployee**](EmployeeApi.md#createEmployee) | **POST** /v1/employees | Create employee |
| [**createNew**](EmployeeApi.md#createNew) | **POST** /v2/core/employees | Create employee |
| [**getAllEmployees**](EmployeeApi.md#getAllEmployees) | **GET** /v2/core/employees | Get employees from a company |
| [**getBulkV2**](EmployeeApi.md#getBulkV2) | **POST** /v2/core/bulk/employee | Get Bulk Employees |
| [**getById**](EmployeeApi.md#getById) | **GET** /v2/core/employees/{id} | Get employee |
| [**getByPayrollIntegrationCode**](EmployeeApi.md#getByPayrollIntegrationCode) | **GET** /v2/payroll_integrations/codes/{id}/find_employee | Find Employee assigned to a Payroll Integration Code |
| [**getCustomTableValues**](EmployeeApi.md#getCustomTableValues) | **GET** /v1/core/custom/tables/{id}/values/{employee_id} | Get Custom Table Fields |
| [**getEmployeeById**](EmployeeApi.md#getEmployeeById) | **GET** /v1/employees/{id} | Get employee |
| [**getEmployees**](EmployeeApi.md#getEmployees) | **GET** /v1/employees | Get employees from a company |
| [**listBreakConfigurationsForDates**](EmployeeApi.md#listBreakConfigurationsForDates) | **GET** /v1/time/break_configurations_for_dates | Get break configurations from a employee in a date range |
| [**listFamilySituations**](EmployeeApi.md#listFamilySituations) | **GET** /v1/payroll/family_situation | Get all family situations - only FR employees |
| [**sendInvitationEmail**](EmployeeApi.md#sendInvitationEmail) | **POST** /v2/core/employees/{id}/invite | Invite employee |
| [**setTerminationDetails**](EmployeeApi.md#setTerminationDetails) | **POST** /v2/core/employees/{id}/terminate | Terminate employee |
| [**terminateEmployee**](EmployeeApi.md#terminateEmployee) | **POST** /v1/employees/{id}/terminate | Terminate employee |
| [**unassignToTeam**](EmployeeApi.md#unassignToTeam) | **DELETE** /v1/core/teams/{id}/employees/{employee_id} | Unassign employee to team |
| [**unterminateEmployee**](EmployeeApi.md#unterminateEmployee) | **POST** /v1/employees/{id}/unterminate | Unterminate employee |
| [**unterminatePost**](EmployeeApi.md#unterminatePost) | **POST** /v2/core/employees/{id}/unterminate | Unterminate employee |
| [**updateById**](EmployeeApi.md#updateById) | **PUT** /v1/employees/{id} | Update employee |
| [**updateEmployeeById**](EmployeeApi.md#updateEmployeeById) | **PUT** /v2/core/employees/{id} | Update employee |
| [**updateInTeam**](EmployeeApi.md#updateInTeam) | **PUT** /v1/core/teams/{id}/employees/{employee_id} | Update an employee in a team |


<a name="assignToTeam"></a>
# **assignToTeam**
> Team assignToTeam(id, employeeId).execute();

Assign an employee to a team

Assign an employee to a team

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String employeeId = "1"; // (Required)
    try {
      Team result = client
              .employee
              .assignToTeam(id, employeeId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getEmployeeIds());
      System.out.println(result.getLeadIds());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#assignToTeam");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Team> response = client
              .employee
              .assignToTeam(id, employeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#assignToTeam");
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
| **employeeId** | **String**| (Required) | |

### Return type

[**Team**](Team.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="changeEmail"></a>
# **changeEmail**
> EmployeeV2 changeEmail(id).employeeChangeEmailRequest(employeeChangeEmailRequest).execute();

Change employee email

Changes the email only if the employee has not been confirmed and it does not exist another employee with the requested email.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String email = "email_example";
    String id = "5"; // (Required)
    try {
      EmployeeV2 result = client
              .employee
              .changeEmail(email, id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#changeEmail");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .changeEmail(email, id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#changeEmail");
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
| **employeeChangeEmailRequest** | [**EmployeeChangeEmailRequest**](EmployeeChangeEmailRequest.md)|  | [optional] |

### Return type

[**EmployeeV2**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="createCustomTableValue"></a>
# **createCustomTableValue**
> CustomResourceValue createCustomTableValue(id, employeeId).employeeCreateCustomTableValueRequest(employeeCreateCustomTableValueRequest).execute();

Creates a custom table value

This endpoint is used to create and store custom values on custom fields used in custom tables. See custom values for more information.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    Integer emloyeeId = 56; // The id of the employee whos custom value we are creating for custom resource
    Integer id = 1; // (Required)
    Integer employeeId = 3; // (Required)
    List<EmployeeCreateCustomTableValueRequestTableValuesInner> tableValues = Arrays.asList();
    try {
      CustomResourceValue result = client
              .employee
              .createCustomTableValue(id, emloyeeId, id, employeeId)
              .tableValues(tableValues)
              .execute();
      System.out.println(result);
      System.out.println(result.get1());
      System.out.println(result.get2());
      System.out.println(result.getId());
      System.out.println(result.getEmployeeId());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#createCustomTableValue");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<CustomResourceValue> response = client
              .employee
              .createCustomTableValue(id, emloyeeId, id, employeeId)
              .tableValues(tableValues)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#createCustomTableValue");
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
| **employeeId** | **Integer**| (Required) | |
| **employeeCreateCustomTableValueRequest** | [**EmployeeCreateCustomTableValueRequest**](EmployeeCreateCustomTableValueRequest.md)|  | [optional] |

### Return type

[**CustomResourceValue**](CustomResourceValue.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="createEmployee"></a>
# **createEmployee**
> Employee createEmployee().employeeCreateEmployeeRequest(employeeCreateEmployeeRequest).execute();

Create employee

Create employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String email = "email_example";
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String birthdayOn = "birthdayOn_example";
    String startDate = "startDate_example";
    String regularAccessStartsOn = "regularAccessStartsOn_example";
    Integer managerId = 56;
    String role = "basic";
    Integer timeoffManagerId = 56;
    String terminatedOn = "terminatedOn_example";
    String terminationReason = "terminationReason_example";
    String companyIdentifier = "companyIdentifier_example";
    String phoneNumber = "phoneNumber_example";
    try {
      Employee result = client
              .employee
              .createEmployee(email, firstName, lastName)
              .birthdayOn(birthdayOn)
              .startDate(startDate)
              .regularAccessStartsOn(regularAccessStartsOn)
              .managerId(managerId)
              .role(role)
              .timeoffManagerId(timeoffManagerId)
              .terminatedOn(terminatedOn)
              .terminationReason(terminationReason)
              .companyIdentifier(companyIdentifier)
              .phoneNumber(phoneNumber)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getRole());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getManagerId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getRegularAccessStartsOn());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getStartDate());
      System.out.println(result.getLocationId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getCompanyHolidayIds());
      System.out.println(result.getAvatar());
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getHiring());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#createEmployee");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Employee> response = client
              .employee
              .createEmployee(email, firstName, lastName)
              .birthdayOn(birthdayOn)
              .startDate(startDate)
              .regularAccessStartsOn(regularAccessStartsOn)
              .managerId(managerId)
              .role(role)
              .timeoffManagerId(timeoffManagerId)
              .terminatedOn(terminatedOn)
              .terminationReason(terminationReason)
              .companyIdentifier(companyIdentifier)
              .phoneNumber(phoneNumber)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#createEmployee");
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
| **employeeCreateEmployeeRequest** | [**EmployeeCreateEmployeeRequest**](EmployeeCreateEmployeeRequest.md)|  | [optional] |

### Return type

[**Employee**](Employee.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="createNew"></a>
# **createNew**
> EmployeeV2 createNew().employeeCreateNewRequest(employeeCreateNewRequest).execute();

Create employee

Create employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String email = "email_example";
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String birthdayOn = "birthdayOn_example";
    String role = "basic";
    String gender = "male";
    String identifier = "identifier_example";
    String identifierType = "dni";
    String nationality = "nationality_example";
    String bankNumber = "bankNumber_example";
    String country = "country_example";
    String city = "city_example";
    String state = "state_example";
    String postalCode = "postalCode_example";
    String addressLine1 = "addressLine1_example";
    String addressLine2 = "addressLine2_example";
    String swiftBic = "swiftBic_example";
    Integer companyId = 56;
    Integer managerId = 56;
    Integer locationId = 56;
    Integer timeoffManagerId = 56;
    Integer legalEntityId = 56;
    String companyIdentifier = "companyIdentifier_example";
    String phoneNumber = "phoneNumber_example";
    String socialSecurityNumber = "socialSecurityNumber_example";
    String taxId = "taxId_example";
    try {
      EmployeeV2 result = client
              .employee
              .createNew(email, firstName, lastName)
              .birthdayOn(birthdayOn)
              .role(role)
              .gender(gender)
              .identifier(identifier)
              .identifierType(identifierType)
              .nationality(nationality)
              .bankNumber(bankNumber)
              .country(country)
              .city(city)
              .state(state)
              .postalCode(postalCode)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .swiftBic(swiftBic)
              .companyId(companyId)
              .managerId(managerId)
              .locationId(locationId)
              .timeoffManagerId(timeoffManagerId)
              .legalEntityId(legalEntityId)
              .companyIdentifier(companyIdentifier)
              .phoneNumber(phoneNumber)
              .socialSecurityNumber(socialSecurityNumber)
              .taxId(taxId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#createNew");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .createNew(email, firstName, lastName)
              .birthdayOn(birthdayOn)
              .role(role)
              .gender(gender)
              .identifier(identifier)
              .identifierType(identifierType)
              .nationality(nationality)
              .bankNumber(bankNumber)
              .country(country)
              .city(city)
              .state(state)
              .postalCode(postalCode)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .swiftBic(swiftBic)
              .companyId(companyId)
              .managerId(managerId)
              .locationId(locationId)
              .timeoffManagerId(timeoffManagerId)
              .legalEntityId(legalEntityId)
              .companyIdentifier(companyIdentifier)
              .phoneNumber(phoneNumber)
              .socialSecurityNumber(socialSecurityNumber)
              .taxId(taxId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#createNew");
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
| **employeeCreateNewRequest** | [**EmployeeCreateNewRequest**](EmployeeCreateNewRequest.md)|  | [optional] |

### Return type

[**EmployeeV2**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Created |  -  |

<a name="getAllEmployees"></a>
# **getAllEmployees**
> List&lt;EmployeeV2&gt; getAllEmployees().fullTextName(fullTextName).execute();

Get employees from a company

Only &#x60;admins&#x60; can see all the employees&#39; information, &#x60;regular users&#x60; will get a restricted version of the payload as a response based on the permission set by the admin

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String fullTextName = "Bob Stone"; // Retrieves the list of employees by full names
    try {
      List<EmployeeV2> result = client
              .employee
              .getAllEmployees()
              .fullTextName(fullTextName)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getAllEmployees");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<EmployeeV2>> response = client
              .employee
              .getAllEmployees()
              .fullTextName(fullTextName)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getAllEmployees");
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
| **fullTextName** | **String**| Retrieves the list of employees by full names | [optional] |

### Return type

[**List&lt;EmployeeV2&gt;**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getBulkV2"></a>
# **getBulkV2**
> List&lt;EmployeeV2&gt; getBulkV2().execute();

Get Bulk Employees

This endpoint allows you retrieve bulk employees V2

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
      List<EmployeeV2> result = client
              .employee
              .getBulkV2()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getBulkV2");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<EmployeeV2>> response = client
              .employee
              .getBulkV2()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getBulkV2");
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

[**List&lt;EmployeeV2&gt;**](EmployeeV2.md)

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
> EmployeeV2 getById(id).execute();

Get employee

Only admins can see all the employees&#39; information, regular users will get a restricted version of the payload as a response based on the permission set by the admin

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "5"; // (Required)
    try {
      EmployeeV2 result = client
              .employee
              .getById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .getById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getById");
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

[**EmployeeV2**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getByPayrollIntegrationCode"></a>
# **getByPayrollIntegrationCode**
> List&lt;EmployeeV2&gt; getByPayrollIntegrationCode(id).integration(integration).execute();

Find Employee assigned to a Payroll Integration Code

This endpoint allows fetching an Employee through a Payroll Integration Code

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String integration = "a3innuva"; // Payroll Integration name
    try {
      List<EmployeeV2> result = client
              .employee
              .getByPayrollIntegrationCode(id)
              .integration(integration)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getByPayrollIntegrationCode");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<EmployeeV2>> response = client
              .employee
              .getByPayrollIntegrationCode(id)
              .integration(integration)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getByPayrollIntegrationCode");
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
| **integration** | **String**| Payroll Integration name | [optional] [enum: a3innuva, a3nom, silae, datev, zuccheti, kombo, parieh] |

### Return type

[**List&lt;EmployeeV2&gt;**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getCustomTableValues"></a>
# **getCustomTableValues**
> List&lt;CustomResourceValue&gt; getCustomTableValues(id, employeeId).execute();

Get Custom Table Fields

This endpoint allows you retrieve Custom Table Values for an employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    Integer employeeId = 3; // (Required)
    try {
      List<CustomResourceValue> result = client
              .employee
              .getCustomTableValues(id, employeeId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getCustomTableValues");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<CustomResourceValue>> response = client
              .employee
              .getCustomTableValues(id, employeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getCustomTableValues");
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
| **employeeId** | **Integer**| (Required) | |

### Return type

[**List&lt;CustomResourceValue&gt;**](CustomResourceValue.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getEmployeeById"></a>
# **getEmployeeById**
> Employee getEmployeeById(id).execute();

Get employee

Only admins can see all the employees&#39; information, regular users will get a restricted version of the payload as a response based on the permission set by the admin

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String id = "5"; // (Required)
    try {
      Employee result = client
              .employee
              .getEmployeeById(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getRole());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getManagerId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getRegularAccessStartsOn());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getStartDate());
      System.out.println(result.getLocationId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getCompanyHolidayIds());
      System.out.println(result.getAvatar());
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getHiring());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getEmployeeById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Employee> response = client
              .employee
              .getEmployeeById(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getEmployeeById");
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

[**Employee**](Employee.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="getEmployees"></a>
# **getEmployees**
> List&lt;Employee&gt; getEmployees().execute();

Get employees from a company

Only &#x60;admins&#x60; can see all the employees&#39; information, &#x60;regular users&#x60; will get a restricted version of the payload as a response based on the permission set by the admin

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
      List<Employee> result = client
              .employee
              .getEmployees()
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getEmployees");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<Employee>> response = client
              .employee
              .getEmployees()
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#getEmployees");
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

[**List&lt;Employee&gt;**](Employee.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listBreakConfigurationsForDates"></a>
# **listBreakConfigurationsForDates**
> List&lt;BreakConfigurationsForDate&gt; listBreakConfigurationsForDates().startAt(startAt).endAt(endAt).employeeId(employeeId).execute();

Get break configurations from a employee in a date range

List all the posible break configurations to be used optionally in the break start

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String startAt = "2023-09-30";
    String endAt = "2023-09-30";
    Integer employeeId = 1;
    try {
      List<BreakConfigurationsForDate> result = client
              .employee
              .listBreakConfigurationsForDates()
              .startAt(startAt)
              .endAt(endAt)
              .employeeId(employeeId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#listBreakConfigurationsForDates");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<BreakConfigurationsForDate>> response = client
              .employee
              .listBreakConfigurationsForDates()
              .startAt(startAt)
              .endAt(endAt)
              .employeeId(employeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#listBreakConfigurationsForDates");
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
| **startAt** | **String**|  | [optional] |
| **endAt** | **String**|  | [optional] |
| **employeeId** | **Integer**|  | [optional] |

### Return type

[**List&lt;BreakConfigurationsForDate&gt;**](BreakConfigurationsForDate.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="listFamilySituations"></a>
# **listFamilySituations**
> List&lt;FamilySituation&gt; listFamilySituations().employeeId(employeeId).execute();

Get all family situations - only FR employees

Get all family situations - only FR employees

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String employeeId = "3"; // Get all family situations given an employee
    try {
      List<FamilySituation> result = client
              .employee
              .listFamilySituations()
              .employeeId(employeeId)
              .execute();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#listFamilySituations");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<List<FamilySituation>> response = client
              .employee
              .listFamilySituations()
              .employeeId(employeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#listFamilySituations");
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
| **employeeId** | **String**| Get all family situations given an employee | [optional] |

### Return type

[**List&lt;FamilySituation&gt;**](FamilySituation.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="sendInvitationEmail"></a>
# **sendInvitationEmail**
> EmployeeV2 sendInvitationEmail(id).execute();

Invite employee

When inviting an employee an email is sent to their email. You can resend the email as long as the employee has not accepted the invitation yet.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "5"; // (Required)
    try {
      EmployeeV2 result = client
              .employee
              .sendInvitationEmail(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#sendInvitationEmail");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .sendInvitationEmail(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#sendInvitationEmail");
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

[**EmployeeV2**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="setTerminationDetails"></a>
# **setTerminationDetails**
> EmployeeV2 setTerminationDetails(id).employeeSetTerminationDetailsRequest(employeeSetTerminationDetailsRequest).execute();

Terminate employee

Set the termination date and other termination related parameters for an employee. The employee will finally terminate on the date provided.

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String terminatedOn = "terminatedOn_example";
    String id = "5"; // (Required)
    String terminationReason = "terminationReason_example";
    String terminationReasonType = "company";
    Integer terminationAssignedManagerId = 56;
    try {
      EmployeeV2 result = client
              .employee
              .setTerminationDetails(terminatedOn, id)
              .terminationReason(terminationReason)
              .terminationReasonType(terminationReasonType)
              .terminationAssignedManagerId(terminationAssignedManagerId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#setTerminationDetails");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .setTerminationDetails(terminatedOn, id)
              .terminationReason(terminationReason)
              .terminationReasonType(terminationReasonType)
              .terminationAssignedManagerId(terminationAssignedManagerId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#setTerminationDetails");
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
| **employeeSetTerminationDetailsRequest** | [**EmployeeSetTerminationDetailsRequest**](EmployeeSetTerminationDetailsRequest.md)|  | [optional] |

### Return type

[**EmployeeV2**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="terminateEmployee"></a>
# **terminateEmployee**
> Employee terminateEmployee(id).employeeTerminateEmployeeRequest(employeeTerminateEmployeeRequest).execute();

Terminate employee

Terminate employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String id = "5"; // (Required)
    String terminatedOn = "terminatedOn_example";
    String terminationReason = "terminationReason_example";
    Integer terminationAssignedManagerId = 56;
    try {
      Employee result = client
              .employee
              .terminateEmployee(id)
              .terminatedOn(terminatedOn)
              .terminationReason(terminationReason)
              .terminationAssignedManagerId(terminationAssignedManagerId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getRole());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getManagerId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getRegularAccessStartsOn());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getStartDate());
      System.out.println(result.getLocationId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getCompanyHolidayIds());
      System.out.println(result.getAvatar());
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getHiring());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#terminateEmployee");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Employee> response = client
              .employee
              .terminateEmployee(id)
              .terminatedOn(terminatedOn)
              .terminationReason(terminationReason)
              .terminationAssignedManagerId(terminationAssignedManagerId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#terminateEmployee");
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
| **employeeTerminateEmployeeRequest** | [**EmployeeTerminateEmployeeRequest**](EmployeeTerminateEmployeeRequest.md)|  | [optional] |

### Return type

[**Employee**](Employee.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="unassignToTeam"></a>
# **unassignToTeam**
> Team unassignToTeam(id, employeeId).execute();

Unassign employee to team

Unassign employee to team

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String employeeId = "5"; // (Required)
    try {
      Team result = client
              .employee
              .unassignToTeam(id, employeeId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getEmployeeIds());
      System.out.println(result.getLeadIds());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#unassignToTeam");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Team> response = client
              .employee
              .unassignToTeam(id, employeeId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#unassignToTeam");
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
| **employeeId** | **String**| (Required) | |

### Return type

[**Team**](Team.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="unterminateEmployee"></a>
# **unterminateEmployee**
> Employee unterminateEmployee(id).execute();

Unterminate employee

Unterminate employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String id = "5"; // (Required)
    try {
      Employee result = client
              .employee
              .unterminateEmployee(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getRole());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getManagerId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getRegularAccessStartsOn());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getStartDate());
      System.out.println(result.getLocationId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getCompanyHolidayIds());
      System.out.println(result.getAvatar());
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getHiring());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#unterminateEmployee");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Employee> response = client
              .employee
              .unterminateEmployee(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#unterminateEmployee");
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

[**Employee**](Employee.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="unterminatePost"></a>
# **unterminatePost**
> EmployeeV2 unterminatePost(id).execute();

Unterminate employee

Unterminate the employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "5"; // (Required)
    try {
      EmployeeV2 result = client
              .employee
              .unterminatePost(id)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#unterminatePost");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .unterminatePost(id)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#unterminatePost");
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

[**EmployeeV2**](EmployeeV2.md)

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
> Employee updateById(id).employeeUpdateByIdRequest(employeeUpdateByIdRequest).execute();

Update employee

Update employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String id = "5"; // (Required)
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    Integer managerId = 56;
    String role = "basic";
    Integer timeoffManagerId = 56;
    String companyIdentifier = "companyIdentifier_example";
    try {
      Employee result = client
              .employee
              .updateById(id)
              .firstName(firstName)
              .lastName(lastName)
              .managerId(managerId)
              .role(role)
              .timeoffManagerId(timeoffManagerId)
              .companyIdentifier(companyIdentifier)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getEmail());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getRole());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getManagerId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getRegularAccessStartsOn());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getStartDate());
      System.out.println(result.getLocationId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getCompanyHolidayIds());
      System.out.println(result.getAvatar());
      System.out.println(result.getCompanyIdentifier());
      System.out.println(result.getHiring());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#updateById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Employee> response = client
              .employee
              .updateById(id)
              .firstName(firstName)
              .lastName(lastName)
              .managerId(managerId)
              .role(role)
              .timeoffManagerId(timeoffManagerId)
              .companyIdentifier(companyIdentifier)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#updateById");
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
| **employeeUpdateByIdRequest** | [**EmployeeUpdateByIdRequest**](EmployeeUpdateByIdRequest.md)|  | [optional] |

### Return type

[**Employee**](Employee.md)

### Authorization

[oauth2](../README.md#oauth2)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateEmployeeById"></a>
# **updateEmployeeById**
> EmployeeV2 updateEmployeeById(id).employeeUpdateEmployeeByIdRequest(employeeUpdateEmployeeByIdRequest).execute();

Update employee

Update employee

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Example {
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.host = "https://api.factorialhr.com/api";
    
    configuration.apikey  = "YOUR API KEY";
    Factorial client = new Factorial(configuration);
    String id = "5"; // (Required)
    String email = "email_example";
    String firstName = "firstName_example";
    String lastName = "lastName_example";
    String birthdayOn = "birthdayOn_example";
    String role = "basic";
    String gender = "male";
    String identifier = "identifier_example";
    String identifierType = "dni";
    String nationality = "nationality_example";
    String bankNumber = "bankNumber_example";
    String country = "country_example";
    String city = "city_example";
    String state = "state_example";
    String postalCode = "postalCode_example";
    String addressLine1 = "addressLine1_example";
    String addressLine2 = "addressLine2_example";
    String swiftBic = "swiftBic_example";
    Integer managerId = 56;
    Integer locationId = 56;
    Integer timeoffManagerId = 56;
    String phoneNumber = "phoneNumber_example";
    Integer socialSecurityNumber = 56;
    Integer legalEntityId = 56;
    String companyIdentifier = "companyIdentifier_example";
    String contactName = "contactName_example";
    String contactNumber = "contactNumber_example";
    String taxId = "taxId_example";
    try {
      EmployeeV2 result = client
              .employee
              .updateEmployeeById(id)
              .email(email)
              .firstName(firstName)
              .lastName(lastName)
              .birthdayOn(birthdayOn)
              .role(role)
              .gender(gender)
              .identifier(identifier)
              .identifierType(identifierType)
              .nationality(nationality)
              .bankNumber(bankNumber)
              .country(country)
              .city(city)
              .state(state)
              .postalCode(postalCode)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .swiftBic(swiftBic)
              .managerId(managerId)
              .locationId(locationId)
              .timeoffManagerId(timeoffManagerId)
              .phoneNumber(phoneNumber)
              .socialSecurityNumber(socialSecurityNumber)
              .legalEntityId(legalEntityId)
              .companyIdentifier(companyIdentifier)
              .contactName(contactName)
              .contactNumber(contactNumber)
              .taxId(taxId)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getFirstName());
      System.out.println(result.getLastName());
      System.out.println(result.getFullName());
      System.out.println(result.getEmail());
      System.out.println(result.getBirthdayOn());
      System.out.println(result.getTerminatedOn());
      System.out.println(result.getTerminationReason());
      System.out.println(result.getTerminationObservations());
      System.out.println(result.getIdentifier());
      System.out.println(result.getIdentifierType());
      System.out.println(result.getGender());
      System.out.println(result.getNationality());
      System.out.println(result.getBankNumber());
      System.out.println(result.getCountry());
      System.out.println(result.getCity());
      System.out.println(result.getState());
      System.out.println(result.getPostalCode());
      System.out.println(result.getAddressLine1());
      System.out.println(result.getAddressLine2());
      System.out.println(result.getSwiftBic());
      System.out.println(result.getCompanyId());
      System.out.println(result.getLegalEntityId());
      System.out.println(result.getCreatedAt());
      System.out.println(result.getUpdatedAt());
      System.out.println(result.getManagerId());
      System.out.println(result.getLocationId());
      System.out.println(result.getTimeoffManagerId());
      System.out.println(result.getSocialSecurityNumber());
      System.out.println(result.getTaxId());
      System.out.println(result.getTimeoffPolicyId());
      System.out.println(result.getTeamIds());
      System.out.println(result.getPhoneNumber());
      System.out.println(result.getCompanyIdentifier());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#updateEmployeeById");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<EmployeeV2> response = client
              .employee
              .updateEmployeeById(id)
              .email(email)
              .firstName(firstName)
              .lastName(lastName)
              .birthdayOn(birthdayOn)
              .role(role)
              .gender(gender)
              .identifier(identifier)
              .identifierType(identifierType)
              .nationality(nationality)
              .bankNumber(bankNumber)
              .country(country)
              .city(city)
              .state(state)
              .postalCode(postalCode)
              .addressLine1(addressLine1)
              .addressLine2(addressLine2)
              .swiftBic(swiftBic)
              .managerId(managerId)
              .locationId(locationId)
              .timeoffManagerId(timeoffManagerId)
              .phoneNumber(phoneNumber)
              .socialSecurityNumber(socialSecurityNumber)
              .legalEntityId(legalEntityId)
              .companyIdentifier(companyIdentifier)
              .contactName(contactName)
              .contactNumber(contactNumber)
              .taxId(taxId)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#updateEmployeeById");
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
| **employeeUpdateEmployeeByIdRequest** | [**EmployeeUpdateEmployeeByIdRequest**](EmployeeUpdateEmployeeByIdRequest.md)|  | [optional] |

### Return type

[**EmployeeV2**](EmployeeV2.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a name="updateInTeam"></a>
# **updateInTeam**
> Team updateInTeam(id, employeeId).employeeUpdateInTeamRequest(employeeUpdateInTeamRequest).execute();

Update an employee in a team

Update an employee in a team

### Example
```java
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Factorial;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.auth.*;
import com.konfigthis.client.model.*;
import com.konfigthis.client.api.EmployeeApi;
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
    String employeeId = "1"; // (Required)
    Boolean lead = true;
    try {
      Team result = client
              .employee
              .updateInTeam(id, employeeId)
              .lead(lead)
              .execute();
      System.out.println(result);
      System.out.println(result.getId());
      System.out.println(result.getName());
      System.out.println(result.getEmployeeIds());
      System.out.println(result.getLeadIds());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#updateInTeam");
      System.err.println("Status code: " + e.getStatusCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }

    // Use .executeWithHttpInfo() to retrieve HTTP Status Code, Headers and Request
    try {
      ApiResponse<Team> response = client
              .employee
              .updateInTeam(id, employeeId)
              .lead(lead)
              .executeWithHttpInfo();
      System.out.println(response.getResponseBody());
      System.out.println(response.getResponseHeaders());
      System.out.println(response.getStatusCode());
      System.out.println(response.getRoundTripTime());
      System.out.println(response.getRequest());
    } catch (ApiException e) {
      System.err.println("Exception when calling EmployeeApi#updateInTeam");
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
| **employeeId** | **String**| (Required) | |
| **employeeUpdateInTeamRequest** | [**EmployeeUpdateInTeamRequest**](EmployeeUpdateInTeamRequest.md)|  | [optional] |

### Return type

[**Team**](Team.md)

### Authorization

[apikey](../README.md#apikey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

