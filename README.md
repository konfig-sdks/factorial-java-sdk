<div align="left">

[![Visit Factorial](./header.png)](https://factorialhr.com)

# [Factorial](https://factorialhr.com)

Open Api Specifications available at [https://github.com/factorialco/oas](https://github.com/factorialco/oasLooking)

Guides and support available at [https://help.factorialhr.com/integrations](https://help.factorialhr.com/integrations)

# Authentication

The public API provides two methods of authentication, ApiKeys and OAuth2. The following sections provide information regarding each one and their intent.

## OAuth2

> OAuth2 is used to identify individual users, not applications or platforms.

OAuth2 is available for authenticating to the public API and making requests via third parties **on behalf of a user**. All actions are authored on behalf of the user that creates the token. This means the intent is to be used mainly to do submit actions the actual user is performing on an alternative interface.

To generate a token you will require opening an authorization dialog that returns a code, this code can then be exchanged for a token.

### Configuration

In order to create an OAuth application, you must be an admin, head over to your [personal repository of OAuth applications](https://api.factorialhr.com/oauth/applications), click on `New application` and follow the creation process.

The Factorial API enforces the same permissions at the user level than the Factorial web application. This means that Factorial API users will only be able to perform the same actions they are allowed to do in the Factorial platform.

Next step will be to generate the Authorization Code you will need in order to generate an OAuth2 Token.

### OAuth2 Code Generation

Should be generated via browser by opening the following url. The user should be already logged in to Factorial beforehand.

`https://api.factorialhr.com/oauth/authorize?client_id=&redirect_uri=&response_type=code&scope=`

YOUR_CLIENT_ID: OAuth2 Application Id
REDIRECT_URI: OAuth2 Redirect URL

#### State Parameter

An optional query parameter called `state` can be added to the code generation url. Any string can be used and will be sent on the callback url.

> Authorization protocols provide a `state` parameter that allows you to restore the previous state of your application. The `state` parameter preserves some state objects set by the client in the Authorization request and makes it available to the client in the response.

### OAuth2 Token Generation

Once you have the authorization code, you can request their access token to Factorial.

`curl -X POST 'https://api.factorialhr.com/oauth/token' -d 'client_id=&client_secret=&code=&grant_type=authorization_code&redirect_uri='`

YOUR_CLIENT_ID: OAuth2 Application Id
YOUR_CLIENT_SECRET: OAuth2 Application Secret
AUTHORIZATION_CODE: OAuth2 CODE
REDIRECT_URI: OAuth2 Redirect URL

> You can generate only one OAuth2 token per Code, that means that if you want to generate a new token for a Code that already have one you should refresh your token.

Every time a new token is generated a refresh token is generated as well, so that you can use it on the OAuth2 Refresh Token, and an expire date is also provided.

### OAuth2 Refresh Token

You can generate a new token under the same Code with a new expire date (you can do it as many times as you need). A refresh token is also returned here so that you can use it on the OAuth2 Refresh Token again.

`curl -X POST 'https://api.factorialhr.com/oauth/token' -d 'client_id=&client_secret=&refresh_token=&grant_type=refresh_token'`

YOUR_CLIENT_ID: OAuth2 Application Id
YOUR_CLIENT_SECRET: OAuth2 Application Secret
REFRESH_TOKEN: OAuth2 Refresh Token

### OAuth2 Revoke Token

You can revoke an access/refresh token if you do not want it to be active anylonger. This can happen in cases where you have refreshed your token and would like to revoke the previous token if you haven't used the new token yet, as using the new token automatically revokes the previous one.

`curl -X POST 'https://api.factorialhr.com/oauth/revoke' -d 'client_id=&client_secret=&token='`

YOUR_CLIENT_ID: OAuth2 Application Id
YOUR_CLIENT_SECRET: OAuth2 Application Secret
TOKEN: OAuth2 Access/Refresh Token (whichever you wish to revoke)

### OAuth2 Token Usage

The generated token is the credential for performing authenticated requests to Factorial. This token should be included in the Authorization header prefixed with the word Bearer and a separating space.
As an example, if your token is `12345` then the header content should be `Bearer 12345`.

### Maintaining a persistent connection

To maintain a persistent connection, you should not let the token expire. You can avoid this by simply refreshing your token before the expiration date. This will give you another token with a new expiration date, before that token expires you should refresh it again, and so on...
If you want to do this automatically, you should provide something in your code that will help you perform the update every time the token expires. Otherwise, you would have to do the update manually and make sure you refresh your token before the expiration date to maintain the connection.

## ApiKeys

> API keys are used to identify systems, not the individual users that access.

ApiKeys have **TOTAL ACCESS** to everything and never expire. Its the creators responsibility to generate them and store them securely.

### Generation

In the `Core>Keys` section of this documentation you can access the apis for managing this resource.

### Usage

ApiKeys are a single string of symbols that must be added as a custom header on the request. The header name must be `x-api-key` and the key must be the value without any prefixes.

### Disclaimer

ApiKey management require full admin permissions as the resource itself allows for full admin access to the entire platform on behalf of the company and not of a user, therefore any operations are not linked to any user in particular.

# Development

## SDKs

Coming soon

## Sandbox

A sandbox/demo environment is available for testing integrations via public API calls. Developers can request provisioning with full access to a demo company where to test code before actually interacting with a production environment.

Contact your account manager or account executive to request this environment and get OAuth2 credentials for generating tokens.

Note: the domain for sandbox is different than that from production. Sandbox base domain is `http://api.demo.factorialhr.com`

## Postman

Click the "Run in Postman" button to open the full list of endpoints on your Postman workspace as a Postman Collection.
Inside the collection lookout for the Collection's Variables, configure your variables accordingly.

### Delegating Token Generation To Postman

Coming soon

# Changelog

Coming soon

# How to...

## Custom Fields

Custom fields are useful when you want to add some fields that are not the default ones, to every employee of the company.

For that, you have to create via Factorial App the base custom field in order to have all the employees with it. That option is available in customization, inside the company menu

Once you have that, via API, you can [Create a value for a custom field](https://apidoc.factorialhr.com/#72f3f786-e37d-4e80-ada2-0beedd03b171) to each employee. You should know the custom field id in order to make that, you can check it by [getting a collection of custom fields](https://apidoc.factorialhr.com/#f98dae5a-a8d0-474e-a181-7e9603409b42)

</div>

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven (3.8.3+)/Gradle (7.2+)

If you are adding this library to an Android Application or Library:

3. Android 8.0+ (API Level 26+)

## Installation<a id="installation"></a>
<div align="center">
  <a href="https://konfigthis.com/sdk-sign-up?company=Factorial&language=Java">
    <img src="https://raw.githubusercontent.com/konfig-dev/brand-assets/HEAD/cta-images/java-cta.png" width="70%">
  </a>
</div>

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.konfigthis</groupId>
  <artifactId>factorial-java-sdk</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your `build.gradle`:

```groovy
// build.gradle
repositories {
  mavenCentral()
}

dependencies {
   implementation "com.konfigthis:factorial-java-sdk:1.0.0"
}
```

### Android users

Make sure your `build.gradle` file as a `minSdk` version of at least 26:
```groovy
// build.gradle
android {
    defaultConfig {
        minSdk 26
    }
}
```

Also make sure your library or application has internet permissions in your `AndroidManifest.xml`:

```xml
<!--AndroidManifest.xml-->
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET"/>
</manifest>
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/factorial-java-sdk-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

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

## Documentation for API Endpoints

All URIs are relative to *https://api.factorialhr.com/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ApplicationApi* | [**createAtsApplication**](docs/ApplicationApi.md#createAtsApplication) | **POST** /v1/ats/applications | Creates an application
*ApplicationApi* | [**updateData**](docs/ApplicationApi.md#updateData) | **PUT** /v1/ats/applications/{id} | Update application
*AttendanceApi* | [**createNew**](docs/AttendanceApi.md#createNew) | **POST** /v2/time/attendance | Create Attendance
*AttendanceApi* | [**getBulkV2**](docs/AttendanceApi.md#getBulkV2) | **POST** /v2/core/bulk/attendance | Get Bulk Attendance
*AttendanceApi* | [**getCompanyAttendance**](docs/AttendanceApi.md#getCompanyAttendance) | **GET** /v2/time/attendance | Get attendance from a company
*BreakApi* | [**createBreak**](docs/BreakApi.md#createBreak) | **POST** /v1/time/breaks | Create a break
*BreakApi* | [**endBreak**](docs/BreakApi.md#endBreak) | **POST** /v1/time/breaks/end | End a break
*BreakApi* | [**startBreak**](docs/BreakApi.md#startBreak) | **POST** /v1/time/breaks/start | Start a break
*CandidateApi* | [**createNewCandidate**](docs/CandidateApi.md#createNewCandidate) | **POST** /v1/ats/candidates | Create a candidate
*CandidateApi* | [**deleteExistingCandidate**](docs/CandidateApi.md#deleteExistingCandidate) | **DELETE** /v1/ats/candidates/{id} | Delete a Candidate
*CandidateApi* | [**listAllCandidates**](docs/CandidateApi.md#listAllCandidates) | **GET** /v1/ats/candidates | Get all candidates
*CandidateApi* | [**updateCandidateData**](docs/CandidateApi.md#updateCandidateData) | **PUT** /v1/ats/candidates/{id} | Update candidate
*CompensationApi* | [**createContractCompensation**](docs/CompensationApi.md#createContractCompensation) | **POST** /v1/payroll/compensations | Create a compensation
*CompensationApi* | [**deleteCompensation**](docs/CompensationApi.md#deleteCompensation) | **DELETE** /v1/payroll/compensations/{id} | Delete a Compensation
*CompensationApi* | [**getById**](docs/CompensationApi.md#getById) | **GET** /v1/payroll/compensations/{id} | Get a compensation
*CompensationApi* | [**getCompensations**](docs/CompensationApi.md#getCompensations) | **GET** /v1/payroll/compensations | Get Compensations
*CompensationApi* | [**updateForContract**](docs/CompensationApi.md#updateForContract) | **PUT** /v1/payroll/compensations/{id} | Updates a compensation
*ContractApi* | [**deleteVersion**](docs/ContractApi.md#deleteVersion) | **DELETE** /v1/payroll/contract_versions/{id} | Delete contract version
*ContractApi* | [**getAllReferenceContracts**](docs/ContractApi.md#getAllReferenceContracts) | **GET** /v1/payroll/reference_contracts | Get all reference contracts
*ContractApi* | [**updateVersion**](docs/ContractApi.md#updateVersion) | **PUT** /v1/payroll/contract_versions/{id} | Update contract version
*ContractVersionApi* | [**createNewVersion**](docs/ContractVersionApi.md#createNewVersion) | **POST** /v1/payroll/contract_versions | Create contract versions
*ContractVersionApi* | [**getAllVersions**](docs/ContractVersionApi.md#getAllVersions) | **GET** /v1/payroll/contract_versions | Get all contract versions
*ContractVersionApi* | [**getBulkVersions**](docs/ContractVersionApi.md#getBulkVersions) | **POST** /v2/core/bulk/contract_version | Get Bulk Contract Versions
*CustomFieldApi* | [**createField**](docs/CustomFieldApi.md#createField) | **POST** /v2/custom_fields/fields | Create a custom field
*CustomFieldApi* | [**deleteById**](docs/CustomFieldApi.md#deleteById) | **DELETE** /v2/custom_fields/fields/{id} | Delete a custom field
*CustomFieldApi* | [**getFieldsByGroup**](docs/CustomFieldApi.md#getFieldsByGroup) | **GET** /v1/custom_fields | Get Custom Fields
*CustomFieldApi* | [**getFieldsBySlug**](docs/CustomFieldApi.md#getFieldsBySlug) | **GET** /v2/custom_fields/fields | Get custom fields
*CustomFieldValueApi* | [**createCustomValue**](docs/CustomFieldValueApi.md#createCustomValue) | **POST** /v1/custom_fields/values | Create a value for a custom field
*CustomFieldValueApi* | [**getBySlugName**](docs/CustomFieldValueApi.md#getBySlugName) | **GET** /v2/custom_fields/values | Get custom field values
*CustomFieldValueApi* | [**getInstanceValue**](docs/CustomFieldValueApi.md#getInstanceValue) | **GET** /v1/custom_fields/values | Given a custom field, get the value for a specific instance
*CustomFieldValueApi* | [**updateValue**](docs/CustomFieldValueApi.md#updateValue) | **PUT** /v2/custom_fields/values/{id} | Update custom field value
*CustomTableApi* | [**get**](docs/CustomTableApi.md#get) | **GET** /v1/core/custom/tables | Get Custom Tables
*DocumentApi* | [**createNewDocument**](docs/DocumentApi.md#createNewDocument) | **POST** /v1/core/documents | Create a Document
*DocumentApi* | [**deleteById**](docs/DocumentApi.md#deleteById) | **DELETE** /v1/core/documents/{id} | Delete a Document by ID
*DocumentApi* | [**getById**](docs/DocumentApi.md#getById) | **GET** /v1/core/documents/{id} | Get a Document by ID
*DocumentApi* | [**listGivenEmployeeOrFolder**](docs/DocumentApi.md#listGivenEmployeeOrFolder) | **GET** /v1/core/documents | Get a collection of Documents
*DocumentApi* | [**updateById**](docs/DocumentApi.md#updateById) | **PUT** /v1/core/documents/{id} | Update a Document by ID
*EmployeeApi* | [**assignToTeam**](docs/EmployeeApi.md#assignToTeam) | **POST** /v1/core/teams/{id}/employees/{employee_id} | Assign an employee to a team
*EmployeeApi* | [**changeEmail**](docs/EmployeeApi.md#changeEmail) | **PUT** /v2/core/employees/{id}/email | Change employee email
*EmployeeApi* | [**createCustomTableValue**](docs/EmployeeApi.md#createCustomTableValue) | **POST** /v1/core/custom/tables/{id}/values/{employee_id} | Creates a custom table value
*EmployeeApi* | [**createEmployee**](docs/EmployeeApi.md#createEmployee) | **POST** /v1/employees | Create employee
*EmployeeApi* | [**createNew**](docs/EmployeeApi.md#createNew) | **POST** /v2/core/employees | Create employee
*EmployeeApi* | [**getAllEmployees**](docs/EmployeeApi.md#getAllEmployees) | **GET** /v2/core/employees | Get employees from a company
*EmployeeApi* | [**getBulkV2**](docs/EmployeeApi.md#getBulkV2) | **POST** /v2/core/bulk/employee | Get Bulk Employees
*EmployeeApi* | [**getById**](docs/EmployeeApi.md#getById) | **GET** /v2/core/employees/{id} | Get employee
*EmployeeApi* | [**getByPayrollIntegrationCode**](docs/EmployeeApi.md#getByPayrollIntegrationCode) | **GET** /v2/payroll_integrations/codes/{id}/find_employee | Find Employee assigned to a Payroll Integration Code
*EmployeeApi* | [**getCustomTableValues**](docs/EmployeeApi.md#getCustomTableValues) | **GET** /v1/core/custom/tables/{id}/values/{employee_id} | Get Custom Table Fields
*EmployeeApi* | [**getEmployeeById**](docs/EmployeeApi.md#getEmployeeById) | **GET** /v1/employees/{id} | Get employee
*EmployeeApi* | [**getEmployees**](docs/EmployeeApi.md#getEmployees) | **GET** /v1/employees | Get employees from a company
*EmployeeApi* | [**listBreakConfigurationsForDates**](docs/EmployeeApi.md#listBreakConfigurationsForDates) | **GET** /v1/time/break_configurations_for_dates | Get break configurations from a employee in a date range
*EmployeeApi* | [**listFamilySituations**](docs/EmployeeApi.md#listFamilySituations) | **GET** /v1/payroll/family_situation | Get all family situations - only FR employees
*EmployeeApi* | [**sendInvitationEmail**](docs/EmployeeApi.md#sendInvitationEmail) | **POST** /v2/core/employees/{id}/invite | Invite employee
*EmployeeApi* | [**setTerminationDetails**](docs/EmployeeApi.md#setTerminationDetails) | **POST** /v2/core/employees/{id}/terminate | Terminate employee
*EmployeeApi* | [**terminateEmployee**](docs/EmployeeApi.md#terminateEmployee) | **POST** /v1/employees/{id}/terminate | Terminate employee
*EmployeeApi* | [**unassignToTeam**](docs/EmployeeApi.md#unassignToTeam) | **DELETE** /v1/core/teams/{id}/employees/{employee_id} | Unassign employee to team
*EmployeeApi* | [**unterminateEmployee**](docs/EmployeeApi.md#unterminateEmployee) | **POST** /v1/employees/{id}/unterminate | Unterminate employee
*EmployeeApi* | [**unterminatePost**](docs/EmployeeApi.md#unterminatePost) | **POST** /v2/core/employees/{id}/unterminate | Unterminate employee
*EmployeeApi* | [**updateById**](docs/EmployeeApi.md#updateById) | **PUT** /v1/employees/{id} | Update employee
*EmployeeApi* | [**updateEmployeeById**](docs/EmployeeApi.md#updateEmployeeById) | **PUT** /v2/core/employees/{id} | Update employee
*EmployeeApi* | [**updateInTeam**](docs/EmployeeApi.md#updateInTeam) | **PUT** /v1/core/teams/{id}/employees/{employee_id} | Update an employee in a team
*EventApi* | [**getTriggeredEvents**](docs/EventApi.md#getTriggeredEvents) | **GET** /v1/core/events | Get triggered events
*ExpenseApi* | [**getById**](docs/ExpenseApi.md#getById) | **GET** /v1/finance/expenses/{id} | Get an expense
*ExpenseApi* | [**getCompanyExpenses**](docs/ExpenseApi.md#getCompanyExpenses) | **GET** /v1/finance/expenses | Get Expenses
*FamilySituationApi* | [**createNew**](docs/FamilySituationApi.md#createNew) | **POST** /v1/payroll/family_situation | Create a Family Situation
*FamilySituationApi* | [**updateFamilySituation**](docs/FamilySituationApi.md#updateFamilySituation) | **PUT** /v1/payroll/family_situation/{id} | Update a Family Situation
*FolderApi* | [**createNewFolder**](docs/FolderApi.md#createNewFolder) | **POST** /v1/core/folders | Create a Folder
*FolderApi* | [**getById**](docs/FolderApi.md#getById) | **GET** /v1/core/folders/{id} | Get a Folder by ID
*FolderApi* | [**getByNameAndStatus**](docs/FolderApi.md#getByNameAndStatus) | **GET** /v1/core/folders | Get Folders
*FolderApi* | [**updateFolderById**](docs/FolderApi.md#updateFolderById) | **PUT** /v1/core/folders/{id} | Update a folder
*HolidayApi* | [**getAllCompanyHolidays**](docs/HolidayApi.md#getAllCompanyHolidays) | **GET** /v1/company_holidays | Get all company holidays
*HolidayApi* | [**getById**](docs/HolidayApi.md#getById) | **GET** /v1/company_holidays/{id} | Get a company holiday by ID
*IntegrationApi* | [**deletePayrollCode**](docs/IntegrationApi.md#deletePayrollCode) | **DELETE** /v2/payroll_integrations/codes/{id} | Delete a Payroll Integration Code
*IntegrationApi* | [**getAllCodes**](docs/IntegrationApi.md#getAllCodes) | **GET** /v2/payroll_integrations/codes | Get all codes for a specific Integration
*IntegrationApi* | [**updatePayrollCode**](docs/IntegrationApi.md#updatePayrollCode) | **PATCH** /v2/payroll_integrations/codes/{id} | Update a Payroll Integration Code
*IntegrationCodeApi* | [**createPayrollIntegrationCode**](docs/IntegrationCodeApi.md#createPayrollIntegrationCode) | **POST** /v2/payroll_integrations/codes | Create a Payroll Integration Code
*KeyApi* | [**createNew**](docs/KeyApi.md#createNew) | **POST** /v1/core/keys | Create a Key
*KeyApi* | [**deleteById**](docs/KeyApi.md#deleteById) | **DELETE** /v1/core/keys/{id} | Delete an API Key by ID
*KeyApi* | [**getCollection**](docs/KeyApi.md#getCollection) | **GET** /v1/core/keys | Get a collection of Keys
*LeaveApi* | [**createNewLeave**](docs/LeaveApi.md#createNewLeave) | **POST** /v1/time/leaves | Create a Leave
*LeaveApi* | [**createNewLeave_0**](docs/LeaveApi.md#createNewLeave_0) | **POST** /v2/time/leaves | Create a Leave
*LeaveApi* | [**deleteById**](docs/LeaveApi.md#deleteById) | **DELETE** /v1/time/leaves/{id} | Delete a Leave by ID
*LeaveApi* | [**deleteById_0**](docs/LeaveApi.md#deleteById_0) | **DELETE** /v2/time/leaves/{id} | Delete a Leave by ID
*LeaveApi* | [**getById**](docs/LeaveApi.md#getById) | **GET** /v1/time/leaves/{id} | Get a Leave by ID
*LeaveApi* | [**getById_0**](docs/LeaveApi.md#getById_0) | **GET** /v2/time/leaves/{id} | Get a Leave by ID
*LeaveApi* | [**getCompanyLeaves**](docs/LeaveApi.md#getCompanyLeaves) | **GET** /v1/time/leaves | Get Leaves
*LeaveApi* | [**getCompanyLeaves_0**](docs/LeaveApi.md#getCompanyLeaves_0) | **GET** /v2/time/leaves | Get Leaves
*LeaveApi* | [**getTypes**](docs/LeaveApi.md#getTypes) | **GET** /v1/time/leave_types | Get Leave types
*LeaveApi* | [**typeCreate**](docs/LeaveApi.md#typeCreate) | **POST** /v1/time/leave_types | Create a Leave Type
*LeaveApi* | [**updateById**](docs/LeaveApi.md#updateById) | **PUT** /v2/time/leaves/{id} | Update a Leave
*LeaveApi* | [**updateLeaveById**](docs/LeaveApi.md#updateLeaveById) | **PUT** /v1/time/leaves/{id} | Update a Leave
*LeaveApi* | [**updateType**](docs/LeaveApi.md#updateType) | **PUT** /v1/time/leave_types/{id} | Update a Leave Type
*LegalEntityApi* | [**getById**](docs/LegalEntityApi.md#getById) | **GET** /v1/core/legal_entities/{id} | Get a Legal Entity by ID
*LegalEntityApi* | [**listLegalEntities**](docs/LegalEntityApi.md#listLegalEntities) | **GET** /v1/core/legal_entities | Get a collection of Legal Entities
*LocationApi* | [**getAllLocations**](docs/LocationApi.md#getAllLocations) | **GET** /v1/locations | Get all locations
*LocationApi* | [**getById**](docs/LocationApi.md#getById) | **GET** /v1/locations/{id} | Get a Location by ID
*LocationApi* | [**updateShiftLocation**](docs/LocationApi.md#updateShiftLocation) | **PUT** /v1/time/shifts_management/{id}/locations | Update shift location
*MessageApi* | [**createAtsMessage**](docs/MessageApi.md#createAtsMessage) | **POST** /v1/ats/messages | Creates an ats messsage
*MessageApi* | [**getAllMessages**](docs/MessageApi.md#getAllMessages) | **GET** /v1/ats/messages | Get all ATS Messages
*PolicyApi* | [**getTimeOff**](docs/PolicyApi.md#getTimeOff) | **GET** /v1/time/policies/{id} | Get a Time off Policy
*PolicyApi* | [**getTimeOffPolicies**](docs/PolicyApi.md#getTimeOffPolicies) | **GET** /v1/time/policies | Get Time off Policies
*PostApi* | [**atsJobPosting**](docs/PostApi.md#atsJobPosting) | **POST** /v1/ats/job_postings | Create a Job Posting
*PostApi* | [**createNewPost**](docs/PostApi.md#createNewPost) | **POST** /v1/posts | Create a Post
*PostApi* | [**duplicateJobPosting**](docs/PostApi.md#duplicateJobPosting) | **POST** /v1/ats/job_postings/{id}/duplicate | Duplicate a Job Posting
*PostApi* | [**getAllPostings**](docs/PostApi.md#getAllPostings) | **GET** /v1/ats/job_postings | Get all job postings
*PostApi* | [**getById**](docs/PostApi.md#getById) | **GET** /v1/posts/{id} | Get Post
*PostApi* | [**jobPostingUpdate**](docs/PostApi.md#jobPostingUpdate) | **PUT** /v1/ats/job_postings/{id} | Update a Job Posting
*PostApi* | [**listPosts**](docs/PostApi.md#listPosts) | **GET** /v1/posts | Get Posts
*PostApi* | [**removeJobPosting**](docs/PostApi.md#removeJobPosting) | **DELETE** /v1/ats/job_postings/{id} | Delete a Job Posting
*PostApi* | [**removePost**](docs/PostApi.md#removePost) | **DELETE** /v1/posts/{id} | Delete Post
*PostApi* | [**updateExistingPost**](docs/PostApi.md#updateExistingPost) | **PUT** /v1/posts/{id} | Create a Post
*ShiftApi* | [**createClockInShift**](docs/ShiftApi.md#createClockInShift) | **POST** /v1/time/shifts/clock_in | Clock in
*ShiftApi* | [**createNewShift**](docs/ShiftApi.md#createNewShift) | **POST** /v1/time/shifts_management | Create a shift
*ShiftApi* | [**deleteById**](docs/ShiftApi.md#deleteById) | **DELETE** /v1/time/shifts_management/{id} | Delete Shift
*ShiftApi* | [**deleteShiftById**](docs/ShiftApi.md#deleteShiftById) | **DELETE** /v1/time/shifts/{id} | Delete Shift (time registry)
*ShiftApi* | [**getAllShifts**](docs/ShiftApi.md#getAllShifts) | **GET** /v1/time/shifts_management | Get all shifts from a company
*ShiftApi* | [**getById**](docs/ShiftApi.md#getById) | **GET** /v1/time/shifts_management/{id} | Get Shift
*ShiftApi* | [**getFromCompany**](docs/ShiftApi.md#getFromCompany) | **GET** /v1/time/shifts | Get shifts (time registries) from a company
*ShiftApi* | [**publishShiftsInsideTimeRange**](docs/ShiftApi.md#publishShiftsInsideTimeRange) | **POST** /v1/time/shifts_management/publish | Publish shifts inside time range
*ShiftApi* | [**toggleShiftStatus**](docs/ShiftApi.md#toggleShiftStatus) | **POST** /v1/time/shifts/toggle | Toggle
*ShiftApi* | [**updateClockOutShift**](docs/ShiftApi.md#updateClockOutShift) | **POST** /v1/time/shifts/clock_out | Clock out
*ShiftApi* | [**updateNotes**](docs/ShiftApi.md#updateNotes) | **PUT** /v1/time/shifts_management/{id}/notes | Update shift notes
*ShiftApi* | [**updateShift**](docs/ShiftApi.md#updateShift) | **PUT** /v1/time/shifts/{id} | Update Shift (time registry)
*SupplementApi* | [**createNewSupplement**](docs/SupplementApi.md#createNewSupplement) | **POST** /v1/payroll/supplements | Create supplements
*SupplementApi* | [**deleteById**](docs/SupplementApi.md#deleteById) | **DELETE** /v1/payroll/supplements/{id} | Delete supplements
*SupplementApi* | [**getAll**](docs/SupplementApi.md#getAll) | **GET** /v1/payroll/supplements | Get all supplements
*SupplementApi* | [**updateById**](docs/SupplementApi.md#updateById) | **PUT** /v1/payroll/supplements/{id} | Update supplements
*TableApi* | [**createCustomTable**](docs/TableApi.md#createCustomTable) | **POST** /v1/core/custom/tables | Creates a custom table
*TableApi* | [**createField**](docs/TableApi.md#createField) | **POST** /v1/core/custom/tables/{id}/fields | Creates a custom table field
*TableApi* | [**getCustomTable**](docs/TableApi.md#getCustomTable) | **GET** /v1/core/custom/tables/{id} | Get Custom Table
*TableApi* | [**getFields**](docs/TableApi.md#getFields) | **GET** /v1/core/custom/tables/{id}/fields | Get Custom Table Fields
*TaskApi* | [**addFileToTask**](docs/TaskApi.md#addFileToTask) | **POST** /v1/core/tasks/{id}/files | Create a File in a Task
*TaskApi* | [**copyById**](docs/TaskApi.md#copyById) | **POST** /v1/core/tasks/{id}/copy | Copy Task by ID
*TaskApi* | [**createNewTask**](docs/TaskApi.md#createNewTask) | **POST** /v1/core/tasks | Create a Task
*TaskApi* | [**deleteById**](docs/TaskApi.md#deleteById) | **DELETE** /v1/core/tasks/{id} | Delete a Task by ID
*TaskApi* | [**deleteFileInTask**](docs/TaskApi.md#deleteFileInTask) | **POST** /v1/core/tasks/{task_id}/files/{id} | Delete a File in a Task
*TaskApi* | [**getAllTasks**](docs/TaskApi.md#getAllTasks) | **GET** /v1/core/tasks | Get Tasks
*TaskApi* | [**getById**](docs/TaskApi.md#getById) | **GET** /v1/core/tasks/{id} | Get a Task by ID
*TaskApi* | [**getFile**](docs/TaskApi.md#getFile) | **GET** /v1/core/tasks/{task_id}/files/{id} | Get a file from one Task
*TaskApi* | [**getFiles**](docs/TaskApi.md#getFiles) | **GET** /v1/core/tasks/{id}/files | Get files from a Task
*TaskApi* | [**resolveById**](docs/TaskApi.md#resolveById) | **POST** /v1/core/tasks/{id}/resolve | Resolve Task by ID
*TaskApi* | [**updateById**](docs/TaskApi.md#updateById) | **PUT** /v1/core/tasks/{id} | Update a Task by ID
*TaxonomyApi* | [**getById**](docs/TaxonomyApi.md#getById) | **GET** /v1/payroll/taxonomies/{id} | Get a taxonomy
*TaxonomyApi* | [**getCompanyTaxonomies**](docs/TaxonomyApi.md#getCompanyTaxonomies) | **GET** /v1/payroll/taxonomies | Get Taxonomies
*TeamApi* | [**createNewTeam**](docs/TeamApi.md#createNewTeam) | **POST** /v1/core/teams | Create a team
*TeamApi* | [**getAllTeams**](docs/TeamApi.md#getAllTeams) | **GET** /v1/core/teams | Get teams
*TeamApi* | [**getById**](docs/TeamApi.md#getById) | **GET** /v1/core/teams/{id} | Get a team by ID
*TeamApi* | [**removeTeam**](docs/TeamApi.md#removeTeam) | **DELETE** /v1/core/teams/{id} | Delete a team
*TeamApi* | [**updateTeamById**](docs/TeamApi.md#updateTeamById) | **PUT** /v1/core/teams/{id} | Update a team
*UserApi* | [**infoGet**](docs/UserApi.md#infoGet) | **GET** /v1/me | Get information about current user
*UserApi* | [**subscribedWebhooksList**](docs/UserApi.md#subscribedWebhooksList) | **GET** /v2/core/webhooks | Get a list of all subscribed webhooks for current user
*UserApi* | [**subscribedWebhooksList_0**](docs/UserApi.md#subscribedWebhooksList_0) | **GET** /v1/core/webhooks | Get a list of all subscribed webhooks for current user
*WebhookApi* | [**createSubscription**](docs/WebhookApi.md#createSubscription) | **POST** /v1/core/webhooks | Create a webhook
*WebhookApi* | [**deleteWebhook**](docs/WebhookApi.md#deleteWebhook) | **DELETE** /v2/core/webhooks/{id} | Delete a Webhook
*WebhookApi* | [**deleteWebhookById**](docs/WebhookApi.md#deleteWebhookById) | **DELETE** /v1/core/webhooks/{id} | Delete a Webhook
*WebhookApi* | [**subscriptionCreate**](docs/WebhookApi.md#subscriptionCreate) | **POST** /v2/core/webhooks | Create a webhook
*WebhookApi* | [**updateWebhookById**](docs/WebhookApi.md#updateWebhookById) | **PUT** /v2/core/webhooks/{id} | Update a Webhook
*WorkplaceApi* | [**createNewWorkplace**](docs/WorkplaceApi.md#createNewWorkplace) | **POST** /v2/core/workplaces | Create a workplace
*WorkplaceApi* | [**getById**](docs/WorkplaceApi.md#getById) | **GET** /v2/core/workplaces/{id} | Get a workplace
*WorkplaceApi* | [**listAllWorkplaces**](docs/WorkplaceApi.md#listAllWorkplaces) | **GET** /v2/core/workplaces | Get all workplaces
*WorkplaceApi* | [**removeWorkplace**](docs/WorkplaceApi.md#removeWorkplace) | **DELETE** /v2/core/workplaces/{id} | Delete a workplace
*WorkplaceApi* | [**updateWorkplaceById**](docs/WorkplaceApi.md#updateWorkplaceById) | **PUT** /v2/core/workplaces/{id} | Updates a workplace


## Documentation for Models

 - [Access](docs/Access.md)
 - [ApiKey](docs/ApiKey.md)
 - [ApiKeyCreate](docs/ApiKeyCreate.md)
 - [ApplicationCreateAtsApplicationRequest](docs/ApplicationCreateAtsApplicationRequest.md)
 - [ApplicationCreateAtsApplicationRequestAnswersInner](docs/ApplicationCreateAtsApplicationRequestAnswersInner.md)
 - [ApplicationUpdateDataRequest](docs/ApplicationUpdateDataRequest.md)
 - [AtsAnswer](docs/AtsAnswer.md)
 - [AtsApplication](docs/AtsApplication.md)
 - [AtsApplicationCv](docs/AtsApplicationCv.md)
 - [AtsCandidate](docs/AtsCandidate.md)
 - [AtsJobPosting](docs/AtsJobPosting.md)
 - [AtsMessage](docs/AtsMessage.md)
 - [AtsQuestion](docs/AtsQuestion.md)
 - [Attendance](docs/Attendance.md)
 - [AttendanceCreateNewRequest](docs/AttendanceCreateNewRequest.md)
 - [BreakConfiguration](docs/BreakConfiguration.md)
 - [BreakConfigurationsForDate](docs/BreakConfigurationsForDate.md)
 - [BreakCreateBreakRequest](docs/BreakCreateBreakRequest.md)
 - [BreakEndBreakRequest](docs/BreakEndBreakRequest.md)
 - [BreakStartBreakRequest](docs/BreakStartBreakRequest.md)
 - [CandidateCreateNewCandidateRequest](docs/CandidateCreateNewCandidateRequest.md)
 - [CandidateUpdateCandidateDataRequest](docs/CandidateUpdateCandidateDataRequest.md)
 - [Code](docs/Code.md)
 - [Company](docs/Company.md)
 - [CompanyHoliday](docs/CompanyHoliday.md)
 - [Compensation](docs/Compensation.md)
 - [CompensationCreateContractCompensationRequest](docs/CompensationCreateContractCompensationRequest.md)
 - [CompensationUpdateForContractRequest](docs/CompensationUpdateForContractRequest.md)
 - [ContractUpdateVersionRequest](docs/ContractUpdateVersionRequest.md)
 - [ContractVersion](docs/ContractVersion.md)
 - [ContractVersionCreateNewVersionRequest](docs/ContractVersionCreateNewVersionRequest.md)
 - [CustomField](docs/CustomField.md)
 - [CustomFieldChoiceOptions](docs/CustomFieldChoiceOptions.md)
 - [CustomFieldCreateFieldRequest](docs/CustomFieldCreateFieldRequest.md)
 - [CustomFieldCreateFieldRequestChoiceOptionsInner](docs/CustomFieldCreateFieldRequestChoiceOptionsInner.md)
 - [CustomFieldV2](docs/CustomFieldV2.md)
 - [CustomFieldV2ChoiceOptions](docs/CustomFieldV2ChoiceOptions.md)
 - [CustomFieldValueCreateCustomValueRequest](docs/CustomFieldValueCreateCustomValueRequest.md)
 - [CustomFieldValueUpdateValueRequest](docs/CustomFieldValueUpdateValueRequest.md)
 - [CustomHeader](docs/CustomHeader.md)
 - [CustomResource](docs/CustomResource.md)
 - [CustomResourceValue](docs/CustomResourceValue.md)
 - [CustomValue](docs/CustomValue.md)
 - [CustomValueV2](docs/CustomValueV2.md)
 - [Document](docs/Document.md)
 - [DocumentCreateNewDocumentRequest](docs/DocumentCreateNewDocumentRequest.md)
 - [DocumentUpdateByIdRequest](docs/DocumentUpdateByIdRequest.md)
 - [Employee](docs/Employee.md)
 - [EmployeeChangeEmailRequest](docs/EmployeeChangeEmailRequest.md)
 - [EmployeeCreateCustomTableValueRequest](docs/EmployeeCreateCustomTableValueRequest.md)
 - [EmployeeCreateCustomTableValueRequestTableValuesInner](docs/EmployeeCreateCustomTableValueRequestTableValuesInner.md)
 - [EmployeeCreateEmployeeRequest](docs/EmployeeCreateEmployeeRequest.md)
 - [EmployeeCreateNewRequest](docs/EmployeeCreateNewRequest.md)
 - [EmployeeHiring](docs/EmployeeHiring.md)
 - [EmployeeSetTerminationDetailsRequest](docs/EmployeeSetTerminationDetailsRequest.md)
 - [EmployeeTerminateEmployeeRequest](docs/EmployeeTerminateEmployeeRequest.md)
 - [EmployeeUpdateByIdRequest](docs/EmployeeUpdateByIdRequest.md)
 - [EmployeeUpdateEmployeeByIdRequest](docs/EmployeeUpdateEmployeeByIdRequest.md)
 - [EmployeeUpdateInTeamRequest](docs/EmployeeUpdateInTeamRequest.md)
 - [EmployeeV2](docs/EmployeeV2.md)
 - [EmployeeWebhook](docs/EmployeeWebhook.md)
 - [Event](docs/Event.md)
 - [Expense](docs/Expense.md)
 - [FamilySituation](docs/FamilySituation.md)
 - [FamilySituationCreateNewRequest](docs/FamilySituationCreateNewRequest.md)
 - [FamilySituationUpdateFamilySituationRequest](docs/FamilySituationUpdateFamilySituationRequest.md)
 - [Folder](docs/Folder.md)
 - [FolderCreateNewFolderRequest](docs/FolderCreateNewFolderRequest.md)
 - [FolderUpdateFolderByIdRequest](docs/FolderUpdateFolderByIdRequest.md)
 - [Forbidden](docs/Forbidden.md)
 - [HiringVersion](docs/HiringVersion.md)
 - [InstallationSettings](docs/InstallationSettings.md)
 - [InstallationSettingsDataInner](docs/InstallationSettingsDataInner.md)
 - [InstallationSettingsDataInnerLeaveTypesInner](docs/InstallationSettingsDataInnerLeaveTypesInner.md)
 - [IntegrationCodeCreatePayrollIntegrationCodeRequest](docs/IntegrationCodeCreatePayrollIntegrationCodeRequest.md)
 - [IntegrationUpdatePayrollCodeRequest](docs/IntegrationUpdatePayrollCodeRequest.md)
 - [KeyCreateNewRequest](docs/KeyCreateNewRequest.md)
 - [Leave](docs/Leave.md)
 - [LeaveCreateNewLeaveRequest](docs/LeaveCreateNewLeaveRequest.md)
 - [LeaveCreateNewLeaveRequest1](docs/LeaveCreateNewLeaveRequest1.md)
 - [LeaveType](docs/LeaveType.md)
 - [LeaveTypeCreateRequest](docs/LeaveTypeCreateRequest.md)
 - [LeaveUpdateByIdRequest](docs/LeaveUpdateByIdRequest.md)
 - [LeaveUpdateLeaveByIdRequest](docs/LeaveUpdateLeaveByIdRequest.md)
 - [LeaveUpdateTypeRequest](docs/LeaveUpdateTypeRequest.md)
 - [LeaveV2](docs/LeaveV2.md)
 - [LeaveWebhook](docs/LeaveWebhook.md)
 - [LegalEntity](docs/LegalEntity.md)
 - [Location](docs/Location.md)
 - [LocationUpdateShiftLocationRequest](docs/LocationUpdateShiftLocationRequest.md)
 - [MessageCreateAtsMessageRequest](docs/MessageCreateAtsMessageRequest.md)
 - [Policy](docs/Policy.md)
 - [Post](docs/Post.md)
 - [PostAtsJobPostingRequest](docs/PostAtsJobPostingRequest.md)
 - [PostCreateNewPostRequest](docs/PostCreateNewPostRequest.md)
 - [PostJobPostingUpdateRequest](docs/PostJobPostingUpdateRequest.md)
 - [PostUpdateExistingPostRequest](docs/PostUpdateExistingPostRequest.md)
 - [Shift](docs/Shift.md)
 - [ShiftCreateClockInShiftRequest](docs/ShiftCreateClockInShiftRequest.md)
 - [ShiftCreateNewShiftRequest](docs/ShiftCreateNewShiftRequest.md)
 - [ShiftManagement](docs/ShiftManagement.md)
 - [ShiftPublishShiftsInsideTimeRangeRequest](docs/ShiftPublishShiftsInsideTimeRangeRequest.md)
 - [ShiftToggleShiftStatusRequest](docs/ShiftToggleShiftStatusRequest.md)
 - [ShiftUpdateClockOutShiftRequest](docs/ShiftUpdateClockOutShiftRequest.md)
 - [ShiftUpdateNotesRequest](docs/ShiftUpdateNotesRequest.md)
 - [ShiftUpdateShiftRequest](docs/ShiftUpdateShiftRequest.md)
 - [Supplement](docs/Supplement.md)
 - [SupplementCreateNewSupplementRequest](docs/SupplementCreateNewSupplementRequest.md)
 - [SupplementUpdateByIdRequest](docs/SupplementUpdateByIdRequest.md)
 - [TableCreateCustomTableRequest](docs/TableCreateCustomTableRequest.md)
 - [TableCreateFieldRequest](docs/TableCreateFieldRequest.md)
 - [TableCreateFieldRequestCustomField](docs/TableCreateFieldRequestCustomField.md)
 - [TableCreateFieldRequestCustomFieldChoiceOptions](docs/TableCreateFieldRequestCustomFieldChoiceOptions.md)
 - [Task](docs/Task.md)
 - [TaskAddFileToTaskRequest](docs/TaskAddFileToTaskRequest.md)
 - [TaskCopyByIdRequest](docs/TaskCopyByIdRequest.md)
 - [TaskCreateNewTaskRequest](docs/TaskCreateNewTaskRequest.md)
 - [TaskFile](docs/TaskFile.md)
 - [TaskResolveByIdRequest](docs/TaskResolveByIdRequest.md)
 - [TaskUpdateByIdRequest](docs/TaskUpdateByIdRequest.md)
 - [Taxonomy](docs/Taxonomy.md)
 - [Team](docs/Team.md)
 - [TeamCreateNewTeamRequest](docs/TeamCreateNewTeamRequest.md)
 - [TeamUpdateTeamByIdRequest](docs/TeamUpdateTeamByIdRequest.md)
 - [Webhook](docs/Webhook.md)
 - [WebhookCreateSubscriptionRequest](docs/WebhookCreateSubscriptionRequest.md)
 - [WebhookSubscriptionCreateRequest](docs/WebhookSubscriptionCreateRequest.md)
 - [WebhookUpdateWebhookByIdRequest](docs/WebhookUpdateWebhookByIdRequest.md)
 - [WebhookV2](docs/WebhookV2.md)
 - [Workplace](docs/Workplace.md)
 - [WorkplaceCreateNewWorkplaceRequest](docs/WorkplaceCreateNewWorkplaceRequest.md)
 - [WorkplaceUpdateWorkplaceByIdRequest](docs/WorkplaceUpdateWorkplaceByIdRequest.md)


## Author
This Java package is automatically generated by [Konfig](https://konfigthis.com)
