/*
 * Factorial API
 * Open Api Specifications available at [https://github.com/factorialco/oas](https://github.com/factorialco/oasLooking)  Guides and support available at [https://help.factorialhr.com/integrations](https://help.factorialhr.com/integrations)  # Authentication  The public API provides two methods of authentication, ApiKeys and OAuth2. The following sections provide information regarding each one and their intent.  ## OAuth2  > OAuth2 is used to identify individual users, not applications or platforms.  OAuth2 is available for authenticating to the public API and making requests via third parties **on behalf of a user**. All actions are authored on behalf of the user that creates the token. This means the intent is to be used mainly to do submit actions the actual user is performing on an alternative interface.  To generate a token you will require opening an authorization dialog that returns a code, this code can then be exchanged for a token.  ### Configuration  In order to create an OAuth application, you must be an admin, head over to your [personal repository of OAuth applications](https://api.factorialhr.com/oauth/applications), click on `New application` and follow the creation process.  The Factorial API enforces the same permissions at the user level than the Factorial web application. This means that Factorial API users will only be able to perform the same actions they are allowed to do in the Factorial platform.  Next step will be to generate the Authorization Code you will need in order to generate an OAuth2 Token.  ### OAuth2 Code Generation  Should be generated via browser by opening the following url. The user should be already logged in to Factorial beforehand.  `https://api.factorialhr.com/oauth/authorize?client_id=&redirect_uri=&response_type=code&scope=`  YOUR_CLIENT_ID: OAuth2 Application Id REDIRECT_URI: OAuth2 Redirect URL  #### State Parameter  An optional query parameter called `state` can be added to the code generation url. Any string can be used and will be sent on the callback url.  > Authorization protocols provide a `state` parameter that allows you to restore the previous state of your application. The `state` parameter preserves some state objects set by the client in the Authorization request and makes it available to the client in the response.  ### OAuth2 Token Generation  Once you have the authorization code, you can request their access token to Factorial.  `curl -X POST 'https://api.factorialhr.com/oauth/token' -d 'client_id=&client_secret=&code=&grant_type=authorization_code&redirect_uri='`  YOUR_CLIENT_ID: OAuth2 Application Id YOUR_CLIENT_SECRET: OAuth2 Application Secret AUTHORIZATION_CODE: OAuth2 CODE REDIRECT_URI: OAuth2 Redirect URL  > You can generate only one OAuth2 token per Code, that means that if you want to generate a new token for a Code that already have one you should refresh your token.  Every time a new token is generated a refresh token is generated as well, so that you can use it on the OAuth2 Refresh Token, and an expire date is also provided.  ### OAuth2 Refresh Token  You can generate a new token under the same Code with a new expire date (you can do it as many times as you need). A refresh token is also returned here so that you can use it on the OAuth2 Refresh Token again.  `curl -X POST 'https://api.factorialhr.com/oauth/token' -d 'client_id=&client_secret=&refresh_token=&grant_type=refresh_token'`  YOUR_CLIENT_ID: OAuth2 Application Id YOUR_CLIENT_SECRET: OAuth2 Application Secret REFRESH_TOKEN: OAuth2 Refresh Token  ### OAuth2 Revoke Token  You can revoke an access/refresh token if you do not want it to be active anylonger. This can happen in cases where you have refreshed your token and would like to revoke the previous token if you haven't used the new token yet, as using the new token automatically revokes the previous one.  `curl -X POST 'https://api.factorialhr.com/oauth/revoke' -d 'client_id=&client_secret=&token='`  YOUR_CLIENT_ID: OAuth2 Application Id YOUR_CLIENT_SECRET: OAuth2 Application Secret TOKEN: OAuth2 Access/Refresh Token (whichever you wish to revoke)  ### OAuth2 Token Usage  The generated token is the credential for performing authenticated requests to Factorial. This token should be included in the Authorization header prefixed with the word Bearer and a separating space. As an example, if your token is `12345` then the header content should be `Bearer 12345`.  ### Maintaining a persistent connection  To maintain a persistent connection, you should not let the token expire. You can avoid this by simply refreshing your token before the expiration date. This will give you another token with a new expiration date, before that token expires you should refresh it again, and so on... If you want to do this automatically, you should provide something in your code that will help you perform the update every time the token expires. Otherwise, you would have to do the update manually and make sure you refresh your token before the expiration date to maintain the connection.  ## ApiKeys  > API keys are used to identify systems, not the individual users that access.  ApiKeys have **TOTAL ACCESS** to everything and never expire. Its the creators responsibility to generate them and store them securely.  ### Generation  In the `Core>Keys` section of this documentation you can access the apis for managing this resource.  ### Usage  ApiKeys are a single string of symbols that must be added as a custom header on the request. The header name must be `x-api-key` and the key must be the value without any prefixes.  ### Disclaimer  ApiKey management require full admin permissions as the resource itself allows for full admin access to the entire platform on behalf of the company and not of a user, therefore any operations are not linked to any user in particular.  # Development  ## SDKs  Coming soon  ## Sandbox  A sandbox/demo environment is available for testing integrations via public API calls. Developers can request provisioning with full access to a demo company where to test code before actually interacting with a production environment.  Contact your account manager or account executive to request this environment and get OAuth2 credentials for generating tokens.  Note: the domain for sandbox is different than that from production. Sandbox base domain is `http://api.demo.factorialhr.com`  ## Postman  Click the \"Run in Postman\" button to open the full list of endpoints on your Postman workspace as a Postman Collection. Inside the collection lookout for the Collection's Variables, configure your variables accordingly.  ### Delegating Token Generation To Postman  Coming soon  # Changelog  Coming soon  # How to...  ## Custom Fields  Custom fields are useful when you want to add some fields that are not the default ones, to every employee of the company.  For that, you have to create via Factorial App the base custom field in order to have all the employees with it. That option is available in customization, inside the company menu  Once you have that, via API, you can [Create a value for a custom field](https://apidoc.factorialhr.com/#72f3f786-e37d-4e80-ada2-0beedd03b171) to each employee. You should know the custom field id in order to make that, you can check it by [getting a collection of custom fields](https://apidoc.factorialhr.com/#f98dae5a-a8d0-474e-a181-7e9603409b42)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by Konfig (https://konfigthis.com).
 * Do not edit the class manually.
 */


package com.konfigthis.client.api;

import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.BreakConfigurationsForDate;
import com.konfigthis.client.model.CustomResourceValue;
import com.konfigthis.client.model.Employee;
import com.konfigthis.client.model.EmployeeChangeEmailRequest;
import com.konfigthis.client.model.EmployeeCreateCustomTableValueRequest;
import com.konfigthis.client.model.EmployeeCreateCustomTableValueRequestTableValuesInner;
import com.konfigthis.client.model.EmployeeCreateEmployeeRequest;
import com.konfigthis.client.model.EmployeeCreateNewRequest;
import com.konfigthis.client.model.EmployeeSetTerminationDetailsRequest;
import com.konfigthis.client.model.EmployeeTerminateEmployeeRequest;
import com.konfigthis.client.model.EmployeeUpdateByIdRequest;
import com.konfigthis.client.model.EmployeeUpdateEmployeeByIdRequest;
import com.konfigthis.client.model.EmployeeUpdateInTeamRequest;
import com.konfigthis.client.model.EmployeeV2;
import com.konfigthis.client.model.FamilySituation;
import com.konfigthis.client.model.Team;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EmployeeApi
 */
@Disabled
public class EmployeeApiTest {

    private static EmployeeApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new EmployeeApi(apiClient);
    }

    /**
     * Assign an employee to a team
     *
     * Assign an employee to a team
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void assignToTeamTest() throws ApiException {
        String id = null;
        String employeeId = null;
        Team response = api.assignToTeam(id, employeeId)
                .execute();
        // TODO: test validations
    }

    /**
     * Change employee email
     *
     * Changes the email only if the employee has not been confirmed and it does not exist another employee with the requested email.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void changeEmailTest() throws ApiException {
        String email = null;
        String id = null;
        EmployeeV2 response = api.changeEmail(email, id)
                .execute();
        // TODO: test validations
    }

    /**
     * Creates a custom table value
     *
     * This endpoint is used to create and store custom values on custom fields used in custom tables. See custom values for more information.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createCustomTableValueTest() throws ApiException {
        Integer id = null;
        Integer emloyeeId = null;
        Integer id = null;
        Integer employeeId = null;
        List<EmployeeCreateCustomTableValueRequestTableValuesInner> tableValues = null;
        CustomResourceValue response = api.createCustomTableValue(id, emloyeeId, id, employeeId)
                .tableValues(tableValues)
                .execute();
        // TODO: test validations
    }

    /**
     * Create employee
     *
     * Create employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createEmployeeTest() throws ApiException {
        String email = null;
        String firstName = null;
        String lastName = null;
        String birthdayOn = null;
        String startDate = null;
        String regularAccessStartsOn = null;
        Integer managerId = null;
        String role = null;
        Integer timeoffManagerId = null;
        String terminatedOn = null;
        String terminationReason = null;
        String companyIdentifier = null;
        String phoneNumber = null;
        Employee response = api.createEmployee(email, firstName, lastName)
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
        // TODO: test validations
    }

    /**
     * Create employee
     *
     * Create employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createNewTest() throws ApiException {
        String email = null;
        String firstName = null;
        String lastName = null;
        String birthdayOn = null;
        String role = null;
        String gender = null;
        String identifier = null;
        String identifierType = null;
        String nationality = null;
        String bankNumber = null;
        String country = null;
        String city = null;
        String state = null;
        String postalCode = null;
        String addressLine1 = null;
        String addressLine2 = null;
        String swiftBic = null;
        Integer companyId = null;
        Integer managerId = null;
        Integer locationId = null;
        Integer timeoffManagerId = null;
        Integer legalEntityId = null;
        String companyIdentifier = null;
        String phoneNumber = null;
        String socialSecurityNumber = null;
        String taxId = null;
        EmployeeV2 response = api.createNew(email, firstName, lastName)
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
        // TODO: test validations
    }

    /**
     * Get employees from a company
     *
     * Only &#x60;admins&#x60; can see all the employees&#39; information, &#x60;regular users&#x60; will get a restricted version of the payload as a response based on the permission set by the admin
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getAllEmployeesTest() throws ApiException {
        String fullTextName = null;
        List<EmployeeV2> response = api.getAllEmployees()
                .fullTextName(fullTextName)
                .execute();
        // TODO: test validations
    }

    /**
     * Get Bulk Employees
     *
     * This endpoint allows you retrieve bulk employees V2
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getBulkV2Test() throws ApiException {
        List<EmployeeV2> response = api.getBulkV2()
                .execute();
        // TODO: test validations
    }

    /**
     * Get employee
     *
     * Only admins can see all the employees&#39; information, regular users will get a restricted version of the payload as a response based on the permission set by the admin
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getByIdTest() throws ApiException {
        String id = null;
        EmployeeV2 response = api.getById(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Find Employee assigned to a Payroll Integration Code
     *
     * This endpoint allows fetching an Employee through a Payroll Integration Code
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getByPayrollIntegrationCodeTest() throws ApiException {
        String id = null;
        String integration = null;
        List<EmployeeV2> response = api.getByPayrollIntegrationCode(id)
                .integration(integration)
                .execute();
        // TODO: test validations
    }

    /**
     * Get Custom Table Fields
     *
     * This endpoint allows you retrieve Custom Table Values for an employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getCustomTableValuesTest() throws ApiException {
        Integer id = null;
        Integer employeeId = null;
        List<CustomResourceValue> response = api.getCustomTableValues(id, employeeId)
                .execute();
        // TODO: test validations
    }

    /**
     * Get employee
     *
     * Only admins can see all the employees&#39; information, regular users will get a restricted version of the payload as a response based on the permission set by the admin
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getEmployeeByIdTest() throws ApiException {
        String id = null;
        Employee response = api.getEmployeeById(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Get employees from a company
     *
     * Only &#x60;admins&#x60; can see all the employees&#39; information, &#x60;regular users&#x60; will get a restricted version of the payload as a response based on the permission set by the admin
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getEmployeesTest() throws ApiException {
        List<Employee> response = api.getEmployees()
                .execute();
        // TODO: test validations
    }

    /**
     * Get break configurations from a employee in a date range
     *
     * List all the posible break configurations to be used optionally in the break start
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listBreakConfigurationsForDatesTest() throws ApiException {
        String startAt = null;
        String endAt = null;
        Integer employeeId = null;
        List<BreakConfigurationsForDate> response = api.listBreakConfigurationsForDates()
                .startAt(startAt)
                .endAt(endAt)
                .employeeId(employeeId)
                .execute();
        // TODO: test validations
    }

    /**
     * Get all family situations - only FR employees
     *
     * Get all family situations - only FR employees
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void listFamilySituationsTest() throws ApiException {
        String employeeId = null;
        List<FamilySituation> response = api.listFamilySituations()
                .employeeId(employeeId)
                .execute();
        // TODO: test validations
    }

    /**
     * Invite employee
     *
     * When inviting an employee an email is sent to their email. You can resend the email as long as the employee has not accepted the invitation yet.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sendInvitationEmailTest() throws ApiException {
        String id = null;
        EmployeeV2 response = api.sendInvitationEmail(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Terminate employee
     *
     * Set the termination date and other termination related parameters for an employee. The employee will finally terminate on the date provided.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void setTerminationDetailsTest() throws ApiException {
        String terminatedOn = null;
        String id = null;
        String terminationReason = null;
        String terminationReasonType = null;
        Integer terminationAssignedManagerId = null;
        EmployeeV2 response = api.setTerminationDetails(terminatedOn, id)
                .terminationReason(terminationReason)
                .terminationReasonType(terminationReasonType)
                .terminationAssignedManagerId(terminationAssignedManagerId)
                .execute();
        // TODO: test validations
    }

    /**
     * Terminate employee
     *
     * Terminate employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void terminateEmployeeTest() throws ApiException {
        String id = null;
        String terminatedOn = null;
        String terminationReason = null;
        Integer terminationAssignedManagerId = null;
        Employee response = api.terminateEmployee(id)
                .terminatedOn(terminatedOn)
                .terminationReason(terminationReason)
                .terminationAssignedManagerId(terminationAssignedManagerId)
                .execute();
        // TODO: test validations
    }

    /**
     * Unassign employee to team
     *
     * Unassign employee to team
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unassignToTeamTest() throws ApiException {
        String id = null;
        String employeeId = null;
        Team response = api.unassignToTeam(id, employeeId)
                .execute();
        // TODO: test validations
    }

    /**
     * Unterminate employee
     *
     * Unterminate employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unterminateEmployeeTest() throws ApiException {
        String id = null;
        Employee response = api.unterminateEmployee(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Unterminate employee
     *
     * Unterminate the employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unterminatePostTest() throws ApiException {
        String id = null;
        EmployeeV2 response = api.unterminatePost(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Update employee
     *
     * Update employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateByIdTest() throws ApiException {
        String id = null;
        String firstName = null;
        String lastName = null;
        Integer managerId = null;
        String role = null;
        Integer timeoffManagerId = null;
        String companyIdentifier = null;
        Employee response = api.updateById(id)
                .firstName(firstName)
                .lastName(lastName)
                .managerId(managerId)
                .role(role)
                .timeoffManagerId(timeoffManagerId)
                .companyIdentifier(companyIdentifier)
                .execute();
        // TODO: test validations
    }

    /**
     * Update employee
     *
     * Update employee
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateEmployeeByIdTest() throws ApiException {
        String id = null;
        String email = null;
        String firstName = null;
        String lastName = null;
        String birthdayOn = null;
        String role = null;
        String gender = null;
        String identifier = null;
        String identifierType = null;
        String nationality = null;
        String bankNumber = null;
        String country = null;
        String city = null;
        String state = null;
        String postalCode = null;
        String addressLine1 = null;
        String addressLine2 = null;
        String swiftBic = null;
        Integer managerId = null;
        Integer locationId = null;
        Integer timeoffManagerId = null;
        String phoneNumber = null;
        Integer socialSecurityNumber = null;
        Integer legalEntityId = null;
        String companyIdentifier = null;
        String contactName = null;
        String contactNumber = null;
        String taxId = null;
        EmployeeV2 response = api.updateEmployeeById(id)
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
        // TODO: test validations
    }

    /**
     * Update an employee in a team
     *
     * Update an employee in a team
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateInTeamTest() throws ApiException {
        String id = null;
        String employeeId = null;
        Boolean lead = null;
        Team response = api.updateInTeam(id, employeeId)
                .lead(lead)
                .execute();
        // TODO: test validations
    }

}
