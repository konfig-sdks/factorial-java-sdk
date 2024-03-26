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

import com.konfigthis.client.ApiCallback;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiResponse;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.Pair;
import com.konfigthis.client.ProgressRequestBody;
import com.konfigthis.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class EmployeeApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public EmployeeApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public EmployeeApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    private okhttp3.Call assignToTeamCall(String id, String employeeId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/core/teams/{id}/employees/{employee_id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()))
            .replace("{" + "employee_id" + "}", localVarApiClient.escapeString(employeeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call assignToTeamValidateBeforeCall(String id, String employeeId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling assignToTeam(Async)");
        }

        // verify the required parameter 'employeeId' is set
        if (employeeId == null) {
            throw new ApiException("Missing the required parameter 'employeeId' when calling assignToTeam(Async)");
        }

        return assignToTeamCall(id, employeeId, _callback);

    }


    private ApiResponse<Team> assignToTeamWithHttpInfo(String id, String employeeId) throws ApiException {
        okhttp3.Call localVarCall = assignToTeamValidateBeforeCall(id, employeeId, null);
        Type localVarReturnType = new TypeToken<Team>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call assignToTeamAsync(String id, String employeeId, final ApiCallback<Team> _callback) throws ApiException {

        okhttp3.Call localVarCall = assignToTeamValidateBeforeCall(id, employeeId, _callback);
        Type localVarReturnType = new TypeToken<Team>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class AssignToTeamRequestBuilder {
        private final String id;
        private final String employeeId;

        private AssignToTeamRequestBuilder(String id, String employeeId) {
            this.id = id;
            this.employeeId = employeeId;
        }

        /**
         * Build call for assignToTeam
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return assignToTeamCall(id, employeeId, _callback);
        }


        /**
         * Execute assignToTeam request
         * @return Team
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Team execute() throws ApiException {
            ApiResponse<Team> localVarResp = assignToTeamWithHttpInfo(id, employeeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute assignToTeam request with HTTP info returned
         * @return ApiResponse&lt;Team&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Team> executeWithHttpInfo() throws ApiException {
            return assignToTeamWithHttpInfo(id, employeeId);
        }

        /**
         * Execute assignToTeam request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Team> _callback) throws ApiException {
            return assignToTeamAsync(id, employeeId, _callback);
        }
    }

    /**
     * Assign an employee to a team
     * Assign an employee to a team
     * @param id (Required) (required)
     * @param employeeId (Required) (required)
     * @return AssignToTeamRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public AssignToTeamRequestBuilder assignToTeam(String id, String employeeId) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
            

        return new AssignToTeamRequestBuilder(id, employeeId);
    }
    private okhttp3.Call changeEmailCall(String id, EmployeeChangeEmailRequest employeeChangeEmailRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeChangeEmailRequest;

        // create path and map variables
        String localVarPath = "/v2/core/employees/{id}/email"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call changeEmailValidateBeforeCall(String id, EmployeeChangeEmailRequest employeeChangeEmailRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling changeEmail(Async)");
        }

        return changeEmailCall(id, employeeChangeEmailRequest, _callback);

    }


    private ApiResponse<EmployeeV2> changeEmailWithHttpInfo(String id, EmployeeChangeEmailRequest employeeChangeEmailRequest) throws ApiException {
        okhttp3.Call localVarCall = changeEmailValidateBeforeCall(id, employeeChangeEmailRequest, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call changeEmailAsync(String id, EmployeeChangeEmailRequest employeeChangeEmailRequest, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = changeEmailValidateBeforeCall(id, employeeChangeEmailRequest, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ChangeEmailRequestBuilder {
        private final String email;
        private final String id;

        private ChangeEmailRequestBuilder(String email, String id) {
            this.email = email;
            this.id = id;
        }

        /**
         * Build call for changeEmail
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeChangeEmailRequest employeeChangeEmailRequest = buildBodyParams();
            return changeEmailCall(id, employeeChangeEmailRequest, _callback);
        }

        private EmployeeChangeEmailRequest buildBodyParams() {
            EmployeeChangeEmailRequest employeeChangeEmailRequest = new EmployeeChangeEmailRequest();
            employeeChangeEmailRequest.email(this.email);
            return employeeChangeEmailRequest;
        }

        /**
         * Execute changeEmail request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            EmployeeChangeEmailRequest employeeChangeEmailRequest = buildBodyParams();
            ApiResponse<EmployeeV2> localVarResp = changeEmailWithHttpInfo(id, employeeChangeEmailRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute changeEmail request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            EmployeeChangeEmailRequest employeeChangeEmailRequest = buildBodyParams();
            return changeEmailWithHttpInfo(id, employeeChangeEmailRequest);
        }

        /**
         * Execute changeEmail request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            EmployeeChangeEmailRequest employeeChangeEmailRequest = buildBodyParams();
            return changeEmailAsync(id, employeeChangeEmailRequest, _callback);
        }
    }

    /**
     * Change employee email
     * Changes the email only if the employee has not been confirmed and it does not exist another employee with the requested email.
     * @param id (Required) (required)
     * @return ChangeEmailRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ChangeEmailRequestBuilder changeEmail(String email, String id) throws IllegalArgumentException {
        if (email == null) throw new IllegalArgumentException("\"email\" is required but got null");
            

        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new ChangeEmailRequestBuilder(email, id);
    }
    private okhttp3.Call createCustomTableValueCall(Integer id, Integer employeeId, EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeCreateCustomTableValueRequest;

        // create path and map variables
        String localVarPath = "/v1/core/custom/tables/{id}/values/{employee_id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()))
            .replace("{" + "employee_id" + "}", localVarApiClient.escapeString(employeeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createCustomTableValueValidateBeforeCall(Integer id, Integer employeeId, EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling createCustomTableValue(Async)");
        }

        // verify the required parameter 'employeeId' is set
        if (employeeId == null) {
            throw new ApiException("Missing the required parameter 'employeeId' when calling createCustomTableValue(Async)");
        }

        return createCustomTableValueCall(id, employeeId, employeeCreateCustomTableValueRequest, _callback);

    }


    private ApiResponse<CustomResourceValue> createCustomTableValueWithHttpInfo(Integer id, Integer employeeId, EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest) throws ApiException {
        okhttp3.Call localVarCall = createCustomTableValueValidateBeforeCall(id, employeeId, employeeCreateCustomTableValueRequest, null);
        Type localVarReturnType = new TypeToken<CustomResourceValue>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createCustomTableValueAsync(Integer id, Integer employeeId, EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest, final ApiCallback<CustomResourceValue> _callback) throws ApiException {

        okhttp3.Call localVarCall = createCustomTableValueValidateBeforeCall(id, employeeId, employeeCreateCustomTableValueRequest, _callback);
        Type localVarReturnType = new TypeToken<CustomResourceValue>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateCustomTableValueRequestBuilder {
        private final Integer id;
        private final Integer emloyeeId;
        private final Integer id;
        private final Integer employeeId;
        private List<EmployeeCreateCustomTableValueRequestTableValuesInner> tableValues;

        private CreateCustomTableValueRequestBuilder(Integer id, Integer emloyeeId, Integer id, Integer employeeId) {
            this.id = id;
            this.emloyeeId = emloyeeId;
            this.id = id;
            this.employeeId = employeeId;
        }

        /**
         * Set tableValues
         * @param tableValues  (optional)
         * @return CreateCustomTableValueRequestBuilder
         */
        public CreateCustomTableValueRequestBuilder tableValues(List<EmployeeCreateCustomTableValueRequestTableValuesInner> tableValues) {
            this.tableValues = tableValues;
            return this;
        }
        
        /**
         * Build call for createCustomTableValue
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest = buildBodyParams();
            return createCustomTableValueCall(id, employeeId, employeeCreateCustomTableValueRequest, _callback);
        }

        private EmployeeCreateCustomTableValueRequest buildBodyParams() {
            EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest = new EmployeeCreateCustomTableValueRequest();
            employeeCreateCustomTableValueRequest.id(this.id);
            employeeCreateCustomTableValueRequest.emloyeeId(this.emloyeeId);
            employeeCreateCustomTableValueRequest.tableValues(this.tableValues);
            return employeeCreateCustomTableValueRequest;
        }

        /**
         * Execute createCustomTableValue request
         * @return CustomResourceValue
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public CustomResourceValue execute() throws ApiException {
            EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest = buildBodyParams();
            ApiResponse<CustomResourceValue> localVarResp = createCustomTableValueWithHttpInfo(id, employeeId, employeeCreateCustomTableValueRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createCustomTableValue request with HTTP info returned
         * @return ApiResponse&lt;CustomResourceValue&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<CustomResourceValue> executeWithHttpInfo() throws ApiException {
            EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest = buildBodyParams();
            return createCustomTableValueWithHttpInfo(id, employeeId, employeeCreateCustomTableValueRequest);
        }

        /**
         * Execute createCustomTableValue request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<CustomResourceValue> _callback) throws ApiException {
            EmployeeCreateCustomTableValueRequest employeeCreateCustomTableValueRequest = buildBodyParams();
            return createCustomTableValueAsync(id, employeeId, employeeCreateCustomTableValueRequest, _callback);
        }
    }

    /**
     * Creates a custom table value
     * This endpoint is used to create and store custom values on custom fields used in custom tables. See custom values for more information.
     * @param id (Required) (required)
     * @param employeeId (Required) (required)
     * @return CreateCustomTableValueRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateCustomTableValueRequestBuilder createCustomTableValue(Integer id, Integer emloyeeId, Integer id, Integer employeeId) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        if (emloyeeId == null) throw new IllegalArgumentException("\"emloyeeId\" is required but got null");
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new CreateCustomTableValueRequestBuilder(id, emloyeeId, id, employeeId);
    }
    private okhttp3.Call createEmployeeCall(EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeCreateEmployeeRequest;

        // create path and map variables
        String localVarPath = "/v1/employees";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createEmployeeValidateBeforeCall(EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest, final ApiCallback _callback) throws ApiException {
        return createEmployeeCall(employeeCreateEmployeeRequest, _callback);

    }


    private ApiResponse<Employee> createEmployeeWithHttpInfo(EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest) throws ApiException {
        okhttp3.Call localVarCall = createEmployeeValidateBeforeCall(employeeCreateEmployeeRequest, null);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createEmployeeAsync(EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest, final ApiCallback<Employee> _callback) throws ApiException {

        okhttp3.Call localVarCall = createEmployeeValidateBeforeCall(employeeCreateEmployeeRequest, _callback);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateEmployeeRequestBuilder {
        private final String email;
        private final String firstName;
        private final String lastName;
        private String birthdayOn;
        private String startDate;
        private String regularAccessStartsOn;
        private Integer managerId;
        private String role;
        private Integer timeoffManagerId;
        private String terminatedOn;
        private String terminationReason;
        private String companyIdentifier;
        private String phoneNumber;

        private CreateEmployeeRequestBuilder(String email, String firstName, String lastName) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /**
         * Set birthdayOn
         * @param birthdayOn  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder birthdayOn(String birthdayOn) {
            this.birthdayOn = birthdayOn;
            return this;
        }
        
        /**
         * Set startDate
         * @param startDate  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }
        
        /**
         * Set regularAccessStartsOn
         * @param regularAccessStartsOn  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder regularAccessStartsOn(String regularAccessStartsOn) {
            this.regularAccessStartsOn = regularAccessStartsOn;
            return this;
        }
        
        /**
         * Set managerId
         * @param managerId  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder managerId(Integer managerId) {
            this.managerId = managerId;
            return this;
        }
        
        /**
         * Set role
         * @param role  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder role(String role) {
            this.role = role;
            return this;
        }
        
        /**
         * Set timeoffManagerId
         * @param timeoffManagerId  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder timeoffManagerId(Integer timeoffManagerId) {
            this.timeoffManagerId = timeoffManagerId;
            return this;
        }
        
        /**
         * Set terminatedOn
         * @param terminatedOn  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder terminatedOn(String terminatedOn) {
            this.terminatedOn = terminatedOn;
            return this;
        }
        
        /**
         * Set terminationReason
         * @param terminationReason  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder terminationReason(String terminationReason) {
            this.terminationReason = terminationReason;
            return this;
        }
        
        /**
         * Set companyIdentifier
         * @param companyIdentifier  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder companyIdentifier(String companyIdentifier) {
            this.companyIdentifier = companyIdentifier;
            return this;
        }
        
        /**
         * Set phoneNumber
         * @param phoneNumber  (optional)
         * @return CreateEmployeeRequestBuilder
         */
        public CreateEmployeeRequestBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        /**
         * Build call for createEmployee
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest = buildBodyParams();
            return createEmployeeCall(employeeCreateEmployeeRequest, _callback);
        }

        private EmployeeCreateEmployeeRequest buildBodyParams() {
            EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest = new EmployeeCreateEmployeeRequest();
            employeeCreateEmployeeRequest.email(this.email);
            employeeCreateEmployeeRequest.firstName(this.firstName);
            employeeCreateEmployeeRequest.lastName(this.lastName);
            employeeCreateEmployeeRequest.birthdayOn(this.birthdayOn);
            employeeCreateEmployeeRequest.startDate(this.startDate);
            employeeCreateEmployeeRequest.regularAccessStartsOn(this.regularAccessStartsOn);
            employeeCreateEmployeeRequest.managerId(this.managerId);
            if (this.role != null)
            employeeCreateEmployeeRequest.role(EmployeeCreateEmployeeRequest.RoleEnum.fromValue(this.role));
            employeeCreateEmployeeRequest.timeoffManagerId(this.timeoffManagerId);
            employeeCreateEmployeeRequest.terminatedOn(this.terminatedOn);
            employeeCreateEmployeeRequest.terminationReason(this.terminationReason);
            employeeCreateEmployeeRequest.companyIdentifier(this.companyIdentifier);
            employeeCreateEmployeeRequest.phoneNumber(this.phoneNumber);
            return employeeCreateEmployeeRequest;
        }

        /**
         * Execute createEmployee request
         * @return Employee
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Employee execute() throws ApiException {
            EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest = buildBodyParams();
            ApiResponse<Employee> localVarResp = createEmployeeWithHttpInfo(employeeCreateEmployeeRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createEmployee request with HTTP info returned
         * @return ApiResponse&lt;Employee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Employee> executeWithHttpInfo() throws ApiException {
            EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest = buildBodyParams();
            return createEmployeeWithHttpInfo(employeeCreateEmployeeRequest);
        }

        /**
         * Execute createEmployee request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Employee> _callback) throws ApiException {
            EmployeeCreateEmployeeRequest employeeCreateEmployeeRequest = buildBodyParams();
            return createEmployeeAsync(employeeCreateEmployeeRequest, _callback);
        }
    }

    /**
     * Create employee
     * Create employee
     * @return CreateEmployeeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateEmployeeRequestBuilder createEmployee(String email, String firstName, String lastName) throws IllegalArgumentException {
        if (email == null) throw new IllegalArgumentException("\"email\" is required but got null");
            

        if (firstName == null) throw new IllegalArgumentException("\"firstName\" is required but got null");
            

        if (lastName == null) throw new IllegalArgumentException("\"lastName\" is required but got null");
            

        return new CreateEmployeeRequestBuilder(email, firstName, lastName);
    }
    private okhttp3.Call createNewCall(EmployeeCreateNewRequest employeeCreateNewRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeCreateNewRequest;

        // create path and map variables
        String localVarPath = "/v2/core/employees";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createNewValidateBeforeCall(EmployeeCreateNewRequest employeeCreateNewRequest, final ApiCallback _callback) throws ApiException {
        return createNewCall(employeeCreateNewRequest, _callback);

    }


    private ApiResponse<EmployeeV2> createNewWithHttpInfo(EmployeeCreateNewRequest employeeCreateNewRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewValidateBeforeCall(employeeCreateNewRequest, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewAsync(EmployeeCreateNewRequest employeeCreateNewRequest, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewValidateBeforeCall(employeeCreateNewRequest, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewRequestBuilder {
        private final String email;
        private final String firstName;
        private final String lastName;
        private String birthdayOn;
        private String role;
        private String gender;
        private String identifier;
        private String identifierType;
        private String nationality;
        private String bankNumber;
        private String country;
        private String city;
        private String state;
        private String postalCode;
        private String addressLine1;
        private String addressLine2;
        private String swiftBic;
        private Integer companyId;
        private Integer managerId;
        private Integer locationId;
        private Integer timeoffManagerId;
        private Integer legalEntityId;
        private String companyIdentifier;
        private String phoneNumber;
        private String socialSecurityNumber;
        private String taxId;

        private CreateNewRequestBuilder(String email, String firstName, String lastName) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /**
         * Set birthdayOn
         * @param birthdayOn  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder birthdayOn(String birthdayOn) {
            this.birthdayOn = birthdayOn;
            return this;
        }
        
        /**
         * Set role
         * @param role  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder role(String role) {
            this.role = role;
            return this;
        }
        
        /**
         * Set gender
         * @param gender  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }
        
        /**
         * Set identifier
         * @param identifier  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }
        
        /**
         * Set identifierType
         * @param identifierType  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder identifierType(String identifierType) {
            this.identifierType = identifierType;
            return this;
        }
        
        /**
         * Set nationality
         * @param nationality  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }
        
        /**
         * Set bankNumber
         * @param bankNumber  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder bankNumber(String bankNumber) {
            this.bankNumber = bankNumber;
            return this;
        }
        
        /**
         * Set country
         * @param country  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder country(String country) {
            this.country = country;
            return this;
        }
        
        /**
         * Set city
         * @param city  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder city(String city) {
            this.city = city;
            return this;
        }
        
        /**
         * Set state
         * @param state  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder state(String state) {
            this.state = state;
            return this;
        }
        
        /**
         * Set postalCode
         * @param postalCode  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        
        /**
         * Set addressLine1
         * @param addressLine1  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }
        
        /**
         * Set addressLine2
         * @param addressLine2  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }
        
        /**
         * Set swiftBic
         * @param swiftBic  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder swiftBic(String swiftBic) {
            this.swiftBic = swiftBic;
            return this;
        }
        
        /**
         * Set companyId
         * @param companyId  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder companyId(Integer companyId) {
            this.companyId = companyId;
            return this;
        }
        
        /**
         * Set managerId
         * @param managerId  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder managerId(Integer managerId) {
            this.managerId = managerId;
            return this;
        }
        
        /**
         * Set locationId
         * @param locationId  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder locationId(Integer locationId) {
            this.locationId = locationId;
            return this;
        }
        
        /**
         * Set timeoffManagerId
         * @param timeoffManagerId  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder timeoffManagerId(Integer timeoffManagerId) {
            this.timeoffManagerId = timeoffManagerId;
            return this;
        }
        
        /**
         * Set legalEntityId
         * @param legalEntityId  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder legalEntityId(Integer legalEntityId) {
            this.legalEntityId = legalEntityId;
            return this;
        }
        
        /**
         * Set companyIdentifier
         * @param companyIdentifier  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder companyIdentifier(String companyIdentifier) {
            this.companyIdentifier = companyIdentifier;
            return this;
        }
        
        /**
         * Set phoneNumber
         * @param phoneNumber  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        /**
         * Set socialSecurityNumber
         * @param socialSecurityNumber  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder socialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
            return this;
        }
        
        /**
         * Set taxId
         * @param taxId  (optional)
         * @return CreateNewRequestBuilder
         */
        public CreateNewRequestBuilder taxId(String taxId) {
            this.taxId = taxId;
            return this;
        }
        
        /**
         * Build call for createNew
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeCreateNewRequest employeeCreateNewRequest = buildBodyParams();
            return createNewCall(employeeCreateNewRequest, _callback);
        }

        private EmployeeCreateNewRequest buildBodyParams() {
            EmployeeCreateNewRequest employeeCreateNewRequest = new EmployeeCreateNewRequest();
            employeeCreateNewRequest.email(this.email);
            employeeCreateNewRequest.firstName(this.firstName);
            employeeCreateNewRequest.lastName(this.lastName);
            employeeCreateNewRequest.birthdayOn(this.birthdayOn);
            if (this.role != null)
            employeeCreateNewRequest.role(EmployeeCreateNewRequest.RoleEnum.fromValue(this.role));
            if (this.gender != null)
            employeeCreateNewRequest.gender(EmployeeCreateNewRequest.GenderEnum.fromValue(this.gender));
            employeeCreateNewRequest.identifier(this.identifier);
            if (this.identifierType != null)
            employeeCreateNewRequest.identifierType(EmployeeCreateNewRequest.IdentifierTypeEnum.fromValue(this.identifierType));
            employeeCreateNewRequest.nationality(this.nationality);
            employeeCreateNewRequest.bankNumber(this.bankNumber);
            employeeCreateNewRequest.country(this.country);
            employeeCreateNewRequest.city(this.city);
            employeeCreateNewRequest.state(this.state);
            employeeCreateNewRequest.postalCode(this.postalCode);
            employeeCreateNewRequest.addressLine1(this.addressLine1);
            employeeCreateNewRequest.addressLine2(this.addressLine2);
            employeeCreateNewRequest.swiftBic(this.swiftBic);
            employeeCreateNewRequest.companyId(this.companyId);
            employeeCreateNewRequest.managerId(this.managerId);
            employeeCreateNewRequest.locationId(this.locationId);
            employeeCreateNewRequest.timeoffManagerId(this.timeoffManagerId);
            employeeCreateNewRequest.legalEntityId(this.legalEntityId);
            employeeCreateNewRequest.companyIdentifier(this.companyIdentifier);
            employeeCreateNewRequest.phoneNumber(this.phoneNumber);
            employeeCreateNewRequest.socialSecurityNumber(this.socialSecurityNumber);
            employeeCreateNewRequest.taxId(this.taxId);
            return employeeCreateNewRequest;
        }

        /**
         * Execute createNew request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            EmployeeCreateNewRequest employeeCreateNewRequest = buildBodyParams();
            ApiResponse<EmployeeV2> localVarResp = createNewWithHttpInfo(employeeCreateNewRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNew request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            EmployeeCreateNewRequest employeeCreateNewRequest = buildBodyParams();
            return createNewWithHttpInfo(employeeCreateNewRequest);
        }

        /**
         * Execute createNew request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            EmployeeCreateNewRequest employeeCreateNewRequest = buildBodyParams();
            return createNewAsync(employeeCreateNewRequest, _callback);
        }
    }

    /**
     * Create employee
     * Create employee
     * @return CreateNewRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewRequestBuilder createNew(String email, String firstName, String lastName) throws IllegalArgumentException {
        if (email == null) throw new IllegalArgumentException("\"email\" is required but got null");
            

        if (firstName == null) throw new IllegalArgumentException("\"firstName\" is required but got null");
            

        if (lastName == null) throw new IllegalArgumentException("\"lastName\" is required but got null");
            

        return new CreateNewRequestBuilder(email, firstName, lastName);
    }
    private okhttp3.Call getAllEmployeesCall(String fullTextName, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/core/employees";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (fullTextName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("full_text_name", fullTextName));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getAllEmployeesValidateBeforeCall(String fullTextName, final ApiCallback _callback) throws ApiException {
        return getAllEmployeesCall(fullTextName, _callback);

    }


    private ApiResponse<List<EmployeeV2>> getAllEmployeesWithHttpInfo(String fullTextName) throws ApiException {
        okhttp3.Call localVarCall = getAllEmployeesValidateBeforeCall(fullTextName, null);
        Type localVarReturnType = new TypeToken<List<EmployeeV2>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllEmployeesAsync(String fullTextName, final ApiCallback<List<EmployeeV2>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllEmployeesValidateBeforeCall(fullTextName, _callback);
        Type localVarReturnType = new TypeToken<List<EmployeeV2>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllEmployeesRequestBuilder {
        private String fullTextName;

        private GetAllEmployeesRequestBuilder() {
        }

        /**
         * Set fullTextName
         * @param fullTextName Retrieves the list of employees by full names (optional)
         * @return GetAllEmployeesRequestBuilder
         */
        public GetAllEmployeesRequestBuilder fullTextName(String fullTextName) {
            this.fullTextName = fullTextName;
            return this;
        }
        
        /**
         * Build call for getAllEmployees
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getAllEmployeesCall(fullTextName, _callback);
        }


        /**
         * Execute getAllEmployees request
         * @return List&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<EmployeeV2> execute() throws ApiException {
            ApiResponse<List<EmployeeV2>> localVarResp = getAllEmployeesWithHttpInfo(fullTextName);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAllEmployees request with HTTP info returned
         * @return ApiResponse&lt;List&lt;EmployeeV2&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<EmployeeV2>> executeWithHttpInfo() throws ApiException {
            return getAllEmployeesWithHttpInfo(fullTextName);
        }

        /**
         * Execute getAllEmployees request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<EmployeeV2>> _callback) throws ApiException {
            return getAllEmployeesAsync(fullTextName, _callback);
        }
    }

    /**
     * Get employees from a company
     * Only &#x60;admins&#x60; can see all the employees&#39; information, &#x60;regular users&#x60; will get a restricted version of the payload as a response based on the permission set by the admin
     * @return GetAllEmployeesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetAllEmployeesRequestBuilder getAllEmployees() throws IllegalArgumentException {
        return new GetAllEmployeesRequestBuilder();
    }
    private okhttp3.Call getBulkV2Call(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/core/bulk/employee";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBulkV2ValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getBulkV2Call(_callback);

    }


    private ApiResponse<List<EmployeeV2>> getBulkV2WithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getBulkV2ValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<EmployeeV2>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getBulkV2Async(final ApiCallback<List<EmployeeV2>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBulkV2ValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<EmployeeV2>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetBulkV2RequestBuilder {

        private GetBulkV2RequestBuilder() {
        }

        /**
         * Build call for getBulkV2
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getBulkV2Call(_callback);
        }


        /**
         * Execute getBulkV2 request
         * @return List&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<EmployeeV2> execute() throws ApiException {
            ApiResponse<List<EmployeeV2>> localVarResp = getBulkV2WithHttpInfo();
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getBulkV2 request with HTTP info returned
         * @return ApiResponse&lt;List&lt;EmployeeV2&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<EmployeeV2>> executeWithHttpInfo() throws ApiException {
            return getBulkV2WithHttpInfo();
        }

        /**
         * Execute getBulkV2 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<EmployeeV2>> _callback) throws ApiException {
            return getBulkV2Async(_callback);
        }
    }

    /**
     * Get Bulk Employees
     * This endpoint allows you retrieve bulk employees V2
     * @return GetBulkV2RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetBulkV2RequestBuilder getBulkV2() throws IllegalArgumentException {
        return new GetBulkV2RequestBuilder();
    }
    private okhttp3.Call getByIdCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/core/employees/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getByIdValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getById(Async)");
        }

        return getByIdCall(id, _callback);

    }


    private ApiResponse<EmployeeV2> getByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(String id, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetByIdRequestBuilder {
        private final String id;

        private GetByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for getById
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getByIdCall(id, _callback);
        }


        /**
         * Execute getById request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            ApiResponse<EmployeeV2> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            return getByIdWithHttpInfo(id);
        }

        /**
         * Execute getById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get employee
     * Only admins can see all the employees&#39; information, regular users will get a restricted version of the payload as a response based on the permission set by the admin
     * @param id (Required) (required)
     * @return GetByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetByIdRequestBuilder getById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GetByIdRequestBuilder(id);
    }
    private okhttp3.Call getByPayrollIntegrationCodeCall(String id, String integration, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/payroll_integrations/codes/{id}/find_employee"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (integration != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("integration", integration));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getByPayrollIntegrationCodeValidateBeforeCall(String id, String integration, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getByPayrollIntegrationCode(Async)");
        }

        return getByPayrollIntegrationCodeCall(id, integration, _callback);

    }


    private ApiResponse<List<EmployeeV2>> getByPayrollIntegrationCodeWithHttpInfo(String id, String integration) throws ApiException {
        okhttp3.Call localVarCall = getByPayrollIntegrationCodeValidateBeforeCall(id, integration, null);
        Type localVarReturnType = new TypeToken<List<EmployeeV2>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByPayrollIntegrationCodeAsync(String id, String integration, final ApiCallback<List<EmployeeV2>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByPayrollIntegrationCodeValidateBeforeCall(id, integration, _callback);
        Type localVarReturnType = new TypeToken<List<EmployeeV2>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetByPayrollIntegrationCodeRequestBuilder {
        private final String id;
        private String integration;

        private GetByPayrollIntegrationCodeRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set integration
         * @param integration Payroll Integration name (optional)
         * @return GetByPayrollIntegrationCodeRequestBuilder
         */
        public GetByPayrollIntegrationCodeRequestBuilder integration(String integration) {
            this.integration = integration;
            return this;
        }
        
        /**
         * Build call for getByPayrollIntegrationCode
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getByPayrollIntegrationCodeCall(id, integration, _callback);
        }


        /**
         * Execute getByPayrollIntegrationCode request
         * @return List&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<EmployeeV2> execute() throws ApiException {
            ApiResponse<List<EmployeeV2>> localVarResp = getByPayrollIntegrationCodeWithHttpInfo(id, integration);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getByPayrollIntegrationCode request with HTTP info returned
         * @return ApiResponse&lt;List&lt;EmployeeV2&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<EmployeeV2>> executeWithHttpInfo() throws ApiException {
            return getByPayrollIntegrationCodeWithHttpInfo(id, integration);
        }

        /**
         * Execute getByPayrollIntegrationCode request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<EmployeeV2>> _callback) throws ApiException {
            return getByPayrollIntegrationCodeAsync(id, integration, _callback);
        }
    }

    /**
     * Find Employee assigned to a Payroll Integration Code
     * This endpoint allows fetching an Employee through a Payroll Integration Code
     * @param id (Required) (required)
     * @return GetByPayrollIntegrationCodeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetByPayrollIntegrationCodeRequestBuilder getByPayrollIntegrationCode(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GetByPayrollIntegrationCodeRequestBuilder(id);
    }
    private okhttp3.Call getCustomTableValuesCall(Integer id, Integer employeeId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/core/custom/tables/{id}/values/{employee_id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()))
            .replace("{" + "employee_id" + "}", localVarApiClient.escapeString(employeeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getCustomTableValuesValidateBeforeCall(Integer id, Integer employeeId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getCustomTableValues(Async)");
        }

        // verify the required parameter 'employeeId' is set
        if (employeeId == null) {
            throw new ApiException("Missing the required parameter 'employeeId' when calling getCustomTableValues(Async)");
        }

        return getCustomTableValuesCall(id, employeeId, _callback);

    }


    private ApiResponse<List<CustomResourceValue>> getCustomTableValuesWithHttpInfo(Integer id, Integer employeeId) throws ApiException {
        okhttp3.Call localVarCall = getCustomTableValuesValidateBeforeCall(id, employeeId, null);
        Type localVarReturnType = new TypeToken<List<CustomResourceValue>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getCustomTableValuesAsync(Integer id, Integer employeeId, final ApiCallback<List<CustomResourceValue>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCustomTableValuesValidateBeforeCall(id, employeeId, _callback);
        Type localVarReturnType = new TypeToken<List<CustomResourceValue>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetCustomTableValuesRequestBuilder {
        private final Integer id;
        private final Integer employeeId;

        private GetCustomTableValuesRequestBuilder(Integer id, Integer employeeId) {
            this.id = id;
            this.employeeId = employeeId;
        }

        /**
         * Build call for getCustomTableValues
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getCustomTableValuesCall(id, employeeId, _callback);
        }


        /**
         * Execute getCustomTableValues request
         * @return List&lt;CustomResourceValue&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<CustomResourceValue> execute() throws ApiException {
            ApiResponse<List<CustomResourceValue>> localVarResp = getCustomTableValuesWithHttpInfo(id, employeeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getCustomTableValues request with HTTP info returned
         * @return ApiResponse&lt;List&lt;CustomResourceValue&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<CustomResourceValue>> executeWithHttpInfo() throws ApiException {
            return getCustomTableValuesWithHttpInfo(id, employeeId);
        }

        /**
         * Execute getCustomTableValues request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<CustomResourceValue>> _callback) throws ApiException {
            return getCustomTableValuesAsync(id, employeeId, _callback);
        }
    }

    /**
     * Get Custom Table Fields
     * This endpoint allows you retrieve Custom Table Values for an employee
     * @param id (Required) (required)
     * @param employeeId (Required) (required)
     * @return GetCustomTableValuesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetCustomTableValuesRequestBuilder getCustomTableValues(Integer id, Integer employeeId) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new GetCustomTableValuesRequestBuilder(id, employeeId);
    }
    private okhttp3.Call getEmployeeByIdCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/employees/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getEmployeeByIdValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getEmployeeById(Async)");
        }

        return getEmployeeByIdCall(id, _callback);

    }


    private ApiResponse<Employee> getEmployeeByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getEmployeeByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getEmployeeByIdAsync(String id, final ApiCallback<Employee> _callback) throws ApiException {

        okhttp3.Call localVarCall = getEmployeeByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetEmployeeByIdRequestBuilder {
        private final String id;

        private GetEmployeeByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for getEmployeeById
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getEmployeeByIdCall(id, _callback);
        }


        /**
         * Execute getEmployeeById request
         * @return Employee
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Employee execute() throws ApiException {
            ApiResponse<Employee> localVarResp = getEmployeeByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getEmployeeById request with HTTP info returned
         * @return ApiResponse&lt;Employee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Employee> executeWithHttpInfo() throws ApiException {
            return getEmployeeByIdWithHttpInfo(id);
        }

        /**
         * Execute getEmployeeById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Employee> _callback) throws ApiException {
            return getEmployeeByIdAsync(id, _callback);
        }
    }

    /**
     * Get employee
     * Only admins can see all the employees&#39; information, regular users will get a restricted version of the payload as a response based on the permission set by the admin
     * @param id (Required) (required)
     * @return GetEmployeeByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetEmployeeByIdRequestBuilder getEmployeeById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GetEmployeeByIdRequestBuilder(id);
    }
    private okhttp3.Call getEmployeesCall(final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/employees";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getEmployeesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getEmployeesCall(_callback);

    }


    private ApiResponse<List<Employee>> getEmployeesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getEmployeesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<Employee>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getEmployeesAsync(final ApiCallback<List<Employee>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getEmployeesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<Employee>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetEmployeesRequestBuilder {

        private GetEmployeesRequestBuilder() {
        }

        /**
         * Build call for getEmployees
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return getEmployeesCall(_callback);
        }


        /**
         * Execute getEmployees request
         * @return List&lt;Employee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Employee> execute() throws ApiException {
            ApiResponse<List<Employee>> localVarResp = getEmployeesWithHttpInfo();
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getEmployees request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Employee&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Employee>> executeWithHttpInfo() throws ApiException {
            return getEmployeesWithHttpInfo();
        }

        /**
         * Execute getEmployees request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Employee>> _callback) throws ApiException {
            return getEmployeesAsync(_callback);
        }
    }

    /**
     * Get employees from a company
     * Only &#x60;admins&#x60; can see all the employees&#39; information, &#x60;regular users&#x60; will get a restricted version of the payload as a response based on the permission set by the admin
     * @return GetEmployeesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetEmployeesRequestBuilder getEmployees() throws IllegalArgumentException {
        return new GetEmployeesRequestBuilder();
    }
    private okhttp3.Call listBreakConfigurationsForDatesCall(String startAt, String endAt, Integer employeeId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/time/break_configurations_for_dates";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (startAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("start_at", startAt));
        }

        if (endAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("end_at", endAt));
        }

        if (employeeId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("employee_id", employeeId));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listBreakConfigurationsForDatesValidateBeforeCall(String startAt, String endAt, Integer employeeId, final ApiCallback _callback) throws ApiException {
        return listBreakConfigurationsForDatesCall(startAt, endAt, employeeId, _callback);

    }


    private ApiResponse<List<BreakConfigurationsForDate>> listBreakConfigurationsForDatesWithHttpInfo(String startAt, String endAt, Integer employeeId) throws ApiException {
        okhttp3.Call localVarCall = listBreakConfigurationsForDatesValidateBeforeCall(startAt, endAt, employeeId, null);
        Type localVarReturnType = new TypeToken<List<BreakConfigurationsForDate>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listBreakConfigurationsForDatesAsync(String startAt, String endAt, Integer employeeId, final ApiCallback<List<BreakConfigurationsForDate>> _callback) throws ApiException {

        okhttp3.Call localVarCall = listBreakConfigurationsForDatesValidateBeforeCall(startAt, endAt, employeeId, _callback);
        Type localVarReturnType = new TypeToken<List<BreakConfigurationsForDate>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListBreakConfigurationsForDatesRequestBuilder {
        private String startAt;
        private String endAt;
        private Integer employeeId;

        private ListBreakConfigurationsForDatesRequestBuilder() {
        }

        /**
         * Set startAt
         * @param startAt  (optional)
         * @return ListBreakConfigurationsForDatesRequestBuilder
         */
        public ListBreakConfigurationsForDatesRequestBuilder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }
        
        /**
         * Set endAt
         * @param endAt  (optional)
         * @return ListBreakConfigurationsForDatesRequestBuilder
         */
        public ListBreakConfigurationsForDatesRequestBuilder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }
        
        /**
         * Set employeeId
         * @param employeeId  (optional)
         * @return ListBreakConfigurationsForDatesRequestBuilder
         */
        public ListBreakConfigurationsForDatesRequestBuilder employeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        
        /**
         * Build call for listBreakConfigurationsForDates
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listBreakConfigurationsForDatesCall(startAt, endAt, employeeId, _callback);
        }


        /**
         * Execute listBreakConfigurationsForDates request
         * @return List&lt;BreakConfigurationsForDate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<BreakConfigurationsForDate> execute() throws ApiException {
            ApiResponse<List<BreakConfigurationsForDate>> localVarResp = listBreakConfigurationsForDatesWithHttpInfo(startAt, endAt, employeeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listBreakConfigurationsForDates request with HTTP info returned
         * @return ApiResponse&lt;List&lt;BreakConfigurationsForDate&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<BreakConfigurationsForDate>> executeWithHttpInfo() throws ApiException {
            return listBreakConfigurationsForDatesWithHttpInfo(startAt, endAt, employeeId);
        }

        /**
         * Execute listBreakConfigurationsForDates request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<BreakConfigurationsForDate>> _callback) throws ApiException {
            return listBreakConfigurationsForDatesAsync(startAt, endAt, employeeId, _callback);
        }
    }

    /**
     * Get break configurations from a employee in a date range
     * List all the posible break configurations to be used optionally in the break start
     * @return ListBreakConfigurationsForDatesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ListBreakConfigurationsForDatesRequestBuilder listBreakConfigurationsForDates() throws IllegalArgumentException {
        return new ListBreakConfigurationsForDatesRequestBuilder();
    }
    private okhttp3.Call listFamilySituationsCall(String employeeId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/payroll/family_situation";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (employeeId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("employee_id", employeeId));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call listFamilySituationsValidateBeforeCall(String employeeId, final ApiCallback _callback) throws ApiException {
        return listFamilySituationsCall(employeeId, _callback);

    }


    private ApiResponse<List<FamilySituation>> listFamilySituationsWithHttpInfo(String employeeId) throws ApiException {
        okhttp3.Call localVarCall = listFamilySituationsValidateBeforeCall(employeeId, null);
        Type localVarReturnType = new TypeToken<List<FamilySituation>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listFamilySituationsAsync(String employeeId, final ApiCallback<List<FamilySituation>> _callback) throws ApiException {

        okhttp3.Call localVarCall = listFamilySituationsValidateBeforeCall(employeeId, _callback);
        Type localVarReturnType = new TypeToken<List<FamilySituation>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListFamilySituationsRequestBuilder {
        private String employeeId;

        private ListFamilySituationsRequestBuilder() {
        }

        /**
         * Set employeeId
         * @param employeeId Get all family situations given an employee (optional)
         * @return ListFamilySituationsRequestBuilder
         */
        public ListFamilySituationsRequestBuilder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        
        /**
         * Build call for listFamilySituations
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listFamilySituationsCall(employeeId, _callback);
        }


        /**
         * Execute listFamilySituations request
         * @return List&lt;FamilySituation&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<FamilySituation> execute() throws ApiException {
            ApiResponse<List<FamilySituation>> localVarResp = listFamilySituationsWithHttpInfo(employeeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listFamilySituations request with HTTP info returned
         * @return ApiResponse&lt;List&lt;FamilySituation&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<FamilySituation>> executeWithHttpInfo() throws ApiException {
            return listFamilySituationsWithHttpInfo(employeeId);
        }

        /**
         * Execute listFamilySituations request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<FamilySituation>> _callback) throws ApiException {
            return listFamilySituationsAsync(employeeId, _callback);
        }
    }

    /**
     * Get all family situations - only FR employees
     * Get all family situations - only FR employees
     * @return ListFamilySituationsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ListFamilySituationsRequestBuilder listFamilySituations() throws IllegalArgumentException {
        return new ListFamilySituationsRequestBuilder();
    }
    private okhttp3.Call sendInvitationEmailCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/core/employees/{id}/invite"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call sendInvitationEmailValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling sendInvitationEmail(Async)");
        }

        return sendInvitationEmailCall(id, _callback);

    }


    private ApiResponse<EmployeeV2> sendInvitationEmailWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = sendInvitationEmailValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call sendInvitationEmailAsync(String id, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = sendInvitationEmailValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SendInvitationEmailRequestBuilder {
        private final String id;

        private SendInvitationEmailRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for sendInvitationEmail
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return sendInvitationEmailCall(id, _callback);
        }


        /**
         * Execute sendInvitationEmail request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            ApiResponse<EmployeeV2> localVarResp = sendInvitationEmailWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute sendInvitationEmail request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            return sendInvitationEmailWithHttpInfo(id);
        }

        /**
         * Execute sendInvitationEmail request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            return sendInvitationEmailAsync(id, _callback);
        }
    }

    /**
     * Invite employee
     * When inviting an employee an email is sent to their email. You can resend the email as long as the employee has not accepted the invitation yet.
     * @param id (Required) (required)
     * @return SendInvitationEmailRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public SendInvitationEmailRequestBuilder sendInvitationEmail(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new SendInvitationEmailRequestBuilder(id);
    }
    private okhttp3.Call setTerminationDetailsCall(String id, EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeSetTerminationDetailsRequest;

        // create path and map variables
        String localVarPath = "/v2/core/employees/{id}/terminate"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setTerminationDetailsValidateBeforeCall(String id, EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling setTerminationDetails(Async)");
        }

        return setTerminationDetailsCall(id, employeeSetTerminationDetailsRequest, _callback);

    }


    private ApiResponse<EmployeeV2> setTerminationDetailsWithHttpInfo(String id, EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest) throws ApiException {
        okhttp3.Call localVarCall = setTerminationDetailsValidateBeforeCall(id, employeeSetTerminationDetailsRequest, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call setTerminationDetailsAsync(String id, EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = setTerminationDetailsValidateBeforeCall(id, employeeSetTerminationDetailsRequest, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SetTerminationDetailsRequestBuilder {
        private final String terminatedOn;
        private final String id;
        private String terminationReason;
        private String terminationReasonType;
        private Integer terminationAssignedManagerId;

        private SetTerminationDetailsRequestBuilder(String terminatedOn, String id) {
            this.terminatedOn = terminatedOn;
            this.id = id;
        }

        /**
         * Set terminationReason
         * @param terminationReason  (optional)
         * @return SetTerminationDetailsRequestBuilder
         */
        public SetTerminationDetailsRequestBuilder terminationReason(String terminationReason) {
            this.terminationReason = terminationReason;
            return this;
        }
        
        /**
         * Set terminationReasonType
         * @param terminationReasonType  (optional)
         * @return SetTerminationDetailsRequestBuilder
         */
        public SetTerminationDetailsRequestBuilder terminationReasonType(String terminationReasonType) {
            this.terminationReasonType = terminationReasonType;
            return this;
        }
        
        /**
         * Set terminationAssignedManagerId
         * @param terminationAssignedManagerId  (optional)
         * @return SetTerminationDetailsRequestBuilder
         */
        public SetTerminationDetailsRequestBuilder terminationAssignedManagerId(Integer terminationAssignedManagerId) {
            this.terminationAssignedManagerId = terminationAssignedManagerId;
            return this;
        }
        
        /**
         * Build call for setTerminationDetails
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest = buildBodyParams();
            return setTerminationDetailsCall(id, employeeSetTerminationDetailsRequest, _callback);
        }

        private EmployeeSetTerminationDetailsRequest buildBodyParams() {
            EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest = new EmployeeSetTerminationDetailsRequest();
            employeeSetTerminationDetailsRequest.terminatedOn(this.terminatedOn);
            employeeSetTerminationDetailsRequest.terminationReason(this.terminationReason);
            if (this.terminationReasonType != null)
            employeeSetTerminationDetailsRequest.terminationReasonType(EmployeeSetTerminationDetailsRequest.TerminationReasonTypeEnum.fromValue(this.terminationReasonType));
            employeeSetTerminationDetailsRequest.terminationAssignedManagerId(this.terminationAssignedManagerId);
            return employeeSetTerminationDetailsRequest;
        }

        /**
         * Execute setTerminationDetails request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest = buildBodyParams();
            ApiResponse<EmployeeV2> localVarResp = setTerminationDetailsWithHttpInfo(id, employeeSetTerminationDetailsRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute setTerminationDetails request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest = buildBodyParams();
            return setTerminationDetailsWithHttpInfo(id, employeeSetTerminationDetailsRequest);
        }

        /**
         * Execute setTerminationDetails request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            EmployeeSetTerminationDetailsRequest employeeSetTerminationDetailsRequest = buildBodyParams();
            return setTerminationDetailsAsync(id, employeeSetTerminationDetailsRequest, _callback);
        }
    }

    /**
     * Terminate employee
     * Set the termination date and other termination related parameters for an employee. The employee will finally terminate on the date provided.
     * @param id (Required) (required)
     * @return SetTerminationDetailsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public SetTerminationDetailsRequestBuilder setTerminationDetails(String terminatedOn, String id) throws IllegalArgumentException {
        if (terminatedOn == null) throw new IllegalArgumentException("\"terminatedOn\" is required but got null");
            

        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new SetTerminationDetailsRequestBuilder(terminatedOn, id);
    }
    private okhttp3.Call terminateEmployeeCall(String id, EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeTerminateEmployeeRequest;

        // create path and map variables
        String localVarPath = "/v1/employees/{id}/terminate"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call terminateEmployeeValidateBeforeCall(String id, EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling terminateEmployee(Async)");
        }

        return terminateEmployeeCall(id, employeeTerminateEmployeeRequest, _callback);

    }


    private ApiResponse<Employee> terminateEmployeeWithHttpInfo(String id, EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest) throws ApiException {
        okhttp3.Call localVarCall = terminateEmployeeValidateBeforeCall(id, employeeTerminateEmployeeRequest, null);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call terminateEmployeeAsync(String id, EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest, final ApiCallback<Employee> _callback) throws ApiException {

        okhttp3.Call localVarCall = terminateEmployeeValidateBeforeCall(id, employeeTerminateEmployeeRequest, _callback);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class TerminateEmployeeRequestBuilder {
        private final String id;
        private String terminatedOn;
        private String terminationReason;
        private Integer terminationAssignedManagerId;

        private TerminateEmployeeRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set terminatedOn
         * @param terminatedOn  (optional)
         * @return TerminateEmployeeRequestBuilder
         */
        public TerminateEmployeeRequestBuilder terminatedOn(String terminatedOn) {
            this.terminatedOn = terminatedOn;
            return this;
        }
        
        /**
         * Set terminationReason
         * @param terminationReason  (optional)
         * @return TerminateEmployeeRequestBuilder
         */
        public TerminateEmployeeRequestBuilder terminationReason(String terminationReason) {
            this.terminationReason = terminationReason;
            return this;
        }
        
        /**
         * Set terminationAssignedManagerId
         * @param terminationAssignedManagerId  (optional)
         * @return TerminateEmployeeRequestBuilder
         */
        public TerminateEmployeeRequestBuilder terminationAssignedManagerId(Integer terminationAssignedManagerId) {
            this.terminationAssignedManagerId = terminationAssignedManagerId;
            return this;
        }
        
        /**
         * Build call for terminateEmployee
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest = buildBodyParams();
            return terminateEmployeeCall(id, employeeTerminateEmployeeRequest, _callback);
        }

        private EmployeeTerminateEmployeeRequest buildBodyParams() {
            EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest = new EmployeeTerminateEmployeeRequest();
            employeeTerminateEmployeeRequest.terminatedOn(this.terminatedOn);
            employeeTerminateEmployeeRequest.terminationReason(this.terminationReason);
            employeeTerminateEmployeeRequest.terminationAssignedManagerId(this.terminationAssignedManagerId);
            return employeeTerminateEmployeeRequest;
        }

        /**
         * Execute terminateEmployee request
         * @return Employee
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Employee execute() throws ApiException {
            EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest = buildBodyParams();
            ApiResponse<Employee> localVarResp = terminateEmployeeWithHttpInfo(id, employeeTerminateEmployeeRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute terminateEmployee request with HTTP info returned
         * @return ApiResponse&lt;Employee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Employee> executeWithHttpInfo() throws ApiException {
            EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest = buildBodyParams();
            return terminateEmployeeWithHttpInfo(id, employeeTerminateEmployeeRequest);
        }

        /**
         * Execute terminateEmployee request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Employee> _callback) throws ApiException {
            EmployeeTerminateEmployeeRequest employeeTerminateEmployeeRequest = buildBodyParams();
            return terminateEmployeeAsync(id, employeeTerminateEmployeeRequest, _callback);
        }
    }

    /**
     * Terminate employee
     * Terminate employee
     * @param id (Required) (required)
     * @return TerminateEmployeeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public TerminateEmployeeRequestBuilder terminateEmployee(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new TerminateEmployeeRequestBuilder(id);
    }
    private okhttp3.Call unassignToTeamCall(String id, String employeeId, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/core/teams/{id}/employees/{employee_id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()))
            .replace("{" + "employee_id" + "}", localVarApiClient.escapeString(employeeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call unassignToTeamValidateBeforeCall(String id, String employeeId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling unassignToTeam(Async)");
        }

        // verify the required parameter 'employeeId' is set
        if (employeeId == null) {
            throw new ApiException("Missing the required parameter 'employeeId' when calling unassignToTeam(Async)");
        }

        return unassignToTeamCall(id, employeeId, _callback);

    }


    private ApiResponse<Team> unassignToTeamWithHttpInfo(String id, String employeeId) throws ApiException {
        okhttp3.Call localVarCall = unassignToTeamValidateBeforeCall(id, employeeId, null);
        Type localVarReturnType = new TypeToken<Team>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call unassignToTeamAsync(String id, String employeeId, final ApiCallback<Team> _callback) throws ApiException {

        okhttp3.Call localVarCall = unassignToTeamValidateBeforeCall(id, employeeId, _callback);
        Type localVarReturnType = new TypeToken<Team>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UnassignToTeamRequestBuilder {
        private final String id;
        private final String employeeId;

        private UnassignToTeamRequestBuilder(String id, String employeeId) {
            this.id = id;
            this.employeeId = employeeId;
        }

        /**
         * Build call for unassignToTeam
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return unassignToTeamCall(id, employeeId, _callback);
        }


        /**
         * Execute unassignToTeam request
         * @return Team
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Team execute() throws ApiException {
            ApiResponse<Team> localVarResp = unassignToTeamWithHttpInfo(id, employeeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute unassignToTeam request with HTTP info returned
         * @return ApiResponse&lt;Team&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Team> executeWithHttpInfo() throws ApiException {
            return unassignToTeamWithHttpInfo(id, employeeId);
        }

        /**
         * Execute unassignToTeam request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Team> _callback) throws ApiException {
            return unassignToTeamAsync(id, employeeId, _callback);
        }
    }

    /**
     * Unassign employee to team
     * Unassign employee to team
     * @param id (Required) (required)
     * @param employeeId (Required) (required)
     * @return UnassignToTeamRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UnassignToTeamRequestBuilder unassignToTeam(String id, String employeeId) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
            

        return new UnassignToTeamRequestBuilder(id, employeeId);
    }
    private okhttp3.Call unterminateEmployeeCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v1/employees/{id}/unterminate"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call unterminateEmployeeValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling unterminateEmployee(Async)");
        }

        return unterminateEmployeeCall(id, _callback);

    }


    private ApiResponse<Employee> unterminateEmployeeWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = unterminateEmployeeValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call unterminateEmployeeAsync(String id, final ApiCallback<Employee> _callback) throws ApiException {

        okhttp3.Call localVarCall = unterminateEmployeeValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UnterminateEmployeeRequestBuilder {
        private final String id;

        private UnterminateEmployeeRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for unterminateEmployee
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return unterminateEmployeeCall(id, _callback);
        }


        /**
         * Execute unterminateEmployee request
         * @return Employee
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Employee execute() throws ApiException {
            ApiResponse<Employee> localVarResp = unterminateEmployeeWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute unterminateEmployee request with HTTP info returned
         * @return ApiResponse&lt;Employee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Employee> executeWithHttpInfo() throws ApiException {
            return unterminateEmployeeWithHttpInfo(id);
        }

        /**
         * Execute unterminateEmployee request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Employee> _callback) throws ApiException {
            return unterminateEmployeeAsync(id, _callback);
        }
    }

    /**
     * Unterminate employee
     * Unterminate employee
     * @param id (Required) (required)
     * @return UnterminateEmployeeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UnterminateEmployeeRequestBuilder unterminateEmployee(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UnterminateEmployeeRequestBuilder(id);
    }
    private okhttp3.Call unterminatePostCall(String id, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/v2/core/employees/{id}/unterminate"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call unterminatePostValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling unterminatePost(Async)");
        }

        return unterminatePostCall(id, _callback);

    }


    private ApiResponse<EmployeeV2> unterminatePostWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = unterminatePostValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call unterminatePostAsync(String id, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = unterminatePostValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UnterminatePostRequestBuilder {
        private final String id;

        private UnterminatePostRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for unterminatePost
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return unterminatePostCall(id, _callback);
        }


        /**
         * Execute unterminatePost request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            ApiResponse<EmployeeV2> localVarResp = unterminatePostWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute unterminatePost request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            return unterminatePostWithHttpInfo(id);
        }

        /**
         * Execute unterminatePost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            return unterminatePostAsync(id, _callback);
        }
    }

    /**
     * Unterminate employee
     * Unterminate the employee
     * @param id (Required) (required)
     * @return UnterminatePostRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UnterminatePostRequestBuilder unterminatePost(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UnterminatePostRequestBuilder(id);
    }
    private okhttp3.Call updateByIdCall(String id, EmployeeUpdateByIdRequest employeeUpdateByIdRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeUpdateByIdRequest;

        // create path and map variables
        String localVarPath = "/v1/employees/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateByIdValidateBeforeCall(String id, EmployeeUpdateByIdRequest employeeUpdateByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateById(Async)");
        }

        return updateByIdCall(id, employeeUpdateByIdRequest, _callback);

    }


    private ApiResponse<Employee> updateByIdWithHttpInfo(String id, EmployeeUpdateByIdRequest employeeUpdateByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateByIdValidateBeforeCall(id, employeeUpdateByIdRequest, null);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateByIdAsync(String id, EmployeeUpdateByIdRequest employeeUpdateByIdRequest, final ApiCallback<Employee> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateByIdValidateBeforeCall(id, employeeUpdateByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<Employee>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateByIdRequestBuilder {
        private final String id;
        private String firstName;
        private String lastName;
        private Integer managerId;
        private String role;
        private Integer timeoffManagerId;
        private String companyIdentifier;

        private UpdateByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set firstName
         * @param firstName  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        /**
         * Set lastName
         * @param lastName  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        /**
         * Set managerId
         * @param managerId  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder managerId(Integer managerId) {
            this.managerId = managerId;
            return this;
        }
        
        /**
         * Set role
         * @param role  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder role(String role) {
            this.role = role;
            return this;
        }
        
        /**
         * Set timeoffManagerId
         * @param timeoffManagerId  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder timeoffManagerId(Integer timeoffManagerId) {
            this.timeoffManagerId = timeoffManagerId;
            return this;
        }
        
        /**
         * Set companyIdentifier
         * @param companyIdentifier  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder companyIdentifier(String companyIdentifier) {
            this.companyIdentifier = companyIdentifier;
            return this;
        }
        
        /**
         * Build call for updateById
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeUpdateByIdRequest employeeUpdateByIdRequest = buildBodyParams();
            return updateByIdCall(id, employeeUpdateByIdRequest, _callback);
        }

        private EmployeeUpdateByIdRequest buildBodyParams() {
            EmployeeUpdateByIdRequest employeeUpdateByIdRequest = new EmployeeUpdateByIdRequest();
            employeeUpdateByIdRequest.firstName(this.firstName);
            employeeUpdateByIdRequest.lastName(this.lastName);
            employeeUpdateByIdRequest.managerId(this.managerId);
            if (this.role != null)
            employeeUpdateByIdRequest.role(EmployeeUpdateByIdRequest.RoleEnum.fromValue(this.role));
            employeeUpdateByIdRequest.timeoffManagerId(this.timeoffManagerId);
            employeeUpdateByIdRequest.companyIdentifier(this.companyIdentifier);
            return employeeUpdateByIdRequest;
        }

        /**
         * Execute updateById request
         * @return Employee
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Employee execute() throws ApiException {
            EmployeeUpdateByIdRequest employeeUpdateByIdRequest = buildBodyParams();
            ApiResponse<Employee> localVarResp = updateByIdWithHttpInfo(id, employeeUpdateByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateById request with HTTP info returned
         * @return ApiResponse&lt;Employee&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Employee> executeWithHttpInfo() throws ApiException {
            EmployeeUpdateByIdRequest employeeUpdateByIdRequest = buildBodyParams();
            return updateByIdWithHttpInfo(id, employeeUpdateByIdRequest);
        }

        /**
         * Execute updateById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Employee> _callback) throws ApiException {
            EmployeeUpdateByIdRequest employeeUpdateByIdRequest = buildBodyParams();
            return updateByIdAsync(id, employeeUpdateByIdRequest, _callback);
        }
    }

    /**
     * Update employee
     * Update employee
     * @param id (Required) (required)
     * @return UpdateByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateByIdRequestBuilder updateById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateByIdRequestBuilder(id);
    }
    private okhttp3.Call updateEmployeeByIdCall(String id, EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeUpdateEmployeeByIdRequest;

        // create path and map variables
        String localVarPath = "/v2/core/employees/{id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateEmployeeByIdValidateBeforeCall(String id, EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateEmployeeById(Async)");
        }

        return updateEmployeeByIdCall(id, employeeUpdateEmployeeByIdRequest, _callback);

    }


    private ApiResponse<EmployeeV2> updateEmployeeByIdWithHttpInfo(String id, EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateEmployeeByIdValidateBeforeCall(id, employeeUpdateEmployeeByIdRequest, null);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateEmployeeByIdAsync(String id, EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest, final ApiCallback<EmployeeV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateEmployeeByIdValidateBeforeCall(id, employeeUpdateEmployeeByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<EmployeeV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateEmployeeByIdRequestBuilder {
        private final String id;
        private String email;
        private String firstName;
        private String lastName;
        private String birthdayOn;
        private String role;
        private String gender;
        private String identifier;
        private String identifierType;
        private String nationality;
        private String bankNumber;
        private String country;
        private String city;
        private String state;
        private String postalCode;
        private String addressLine1;
        private String addressLine2;
        private String swiftBic;
        private Integer managerId;
        private Integer locationId;
        private Integer timeoffManagerId;
        private String phoneNumber;
        private Integer socialSecurityNumber;
        private Integer legalEntityId;
        private String companyIdentifier;
        private String contactName;
        private String contactNumber;
        private String taxId;

        private UpdateEmployeeByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set email
         * @param email  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        /**
         * Set firstName
         * @param firstName  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        /**
         * Set lastName
         * @param lastName  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        /**
         * Set birthdayOn
         * @param birthdayOn  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder birthdayOn(String birthdayOn) {
            this.birthdayOn = birthdayOn;
            return this;
        }
        
        /**
         * Set role
         * @param role  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder role(String role) {
            this.role = role;
            return this;
        }
        
        /**
         * Set gender
         * @param gender  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }
        
        /**
         * Set identifier
         * @param identifier  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }
        
        /**
         * Set identifierType
         * @param identifierType  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder identifierType(String identifierType) {
            this.identifierType = identifierType;
            return this;
        }
        
        /**
         * Set nationality
         * @param nationality  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }
        
        /**
         * Set bankNumber
         * @param bankNumber  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder bankNumber(String bankNumber) {
            this.bankNumber = bankNumber;
            return this;
        }
        
        /**
         * Set country
         * @param country  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder country(String country) {
            this.country = country;
            return this;
        }
        
        /**
         * Set city
         * @param city  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder city(String city) {
            this.city = city;
            return this;
        }
        
        /**
         * Set state
         * @param state  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder state(String state) {
            this.state = state;
            return this;
        }
        
        /**
         * Set postalCode
         * @param postalCode  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        
        /**
         * Set addressLine1
         * @param addressLine1  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }
        
        /**
         * Set addressLine2
         * @param addressLine2  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }
        
        /**
         * Set swiftBic
         * @param swiftBic  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder swiftBic(String swiftBic) {
            this.swiftBic = swiftBic;
            return this;
        }
        
        /**
         * Set managerId
         * @param managerId  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder managerId(Integer managerId) {
            this.managerId = managerId;
            return this;
        }
        
        /**
         * Set locationId
         * @param locationId  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder locationId(Integer locationId) {
            this.locationId = locationId;
            return this;
        }
        
        /**
         * Set timeoffManagerId
         * @param timeoffManagerId  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder timeoffManagerId(Integer timeoffManagerId) {
            this.timeoffManagerId = timeoffManagerId;
            return this;
        }
        
        /**
         * Set phoneNumber
         * @param phoneNumber  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        /**
         * Set socialSecurityNumber
         * @param socialSecurityNumber  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder socialSecurityNumber(Integer socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
            return this;
        }
        
        /**
         * Set legalEntityId
         * @param legalEntityId  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder legalEntityId(Integer legalEntityId) {
            this.legalEntityId = legalEntityId;
            return this;
        }
        
        /**
         * Set companyIdentifier
         * @param companyIdentifier  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder companyIdentifier(String companyIdentifier) {
            this.companyIdentifier = companyIdentifier;
            return this;
        }
        
        /**
         * Set contactName
         * @param contactName  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder contactName(String contactName) {
            this.contactName = contactName;
            return this;
        }
        
        /**
         * Set contactNumber
         * @param contactNumber  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }
        
        /**
         * Set taxId
         * @param taxId  (optional)
         * @return UpdateEmployeeByIdRequestBuilder
         */
        public UpdateEmployeeByIdRequestBuilder taxId(String taxId) {
            this.taxId = taxId;
            return this;
        }
        
        /**
         * Build call for updateEmployeeById
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest = buildBodyParams();
            return updateEmployeeByIdCall(id, employeeUpdateEmployeeByIdRequest, _callback);
        }

        private EmployeeUpdateEmployeeByIdRequest buildBodyParams() {
            EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest = new EmployeeUpdateEmployeeByIdRequest();
            employeeUpdateEmployeeByIdRequest.email(this.email);
            employeeUpdateEmployeeByIdRequest.firstName(this.firstName);
            employeeUpdateEmployeeByIdRequest.lastName(this.lastName);
            employeeUpdateEmployeeByIdRequest.birthdayOn(this.birthdayOn);
            if (this.role != null)
            employeeUpdateEmployeeByIdRequest.role(EmployeeUpdateEmployeeByIdRequest.RoleEnum.fromValue(this.role));
            if (this.gender != null)
            employeeUpdateEmployeeByIdRequest.gender(EmployeeUpdateEmployeeByIdRequest.GenderEnum.fromValue(this.gender));
            employeeUpdateEmployeeByIdRequest.identifier(this.identifier);
            if (this.identifierType != null)
            employeeUpdateEmployeeByIdRequest.identifierType(EmployeeUpdateEmployeeByIdRequest.IdentifierTypeEnum.fromValue(this.identifierType));
            employeeUpdateEmployeeByIdRequest.nationality(this.nationality);
            employeeUpdateEmployeeByIdRequest.bankNumber(this.bankNumber);
            employeeUpdateEmployeeByIdRequest.country(this.country);
            employeeUpdateEmployeeByIdRequest.city(this.city);
            employeeUpdateEmployeeByIdRequest.state(this.state);
            employeeUpdateEmployeeByIdRequest.postalCode(this.postalCode);
            employeeUpdateEmployeeByIdRequest.addressLine1(this.addressLine1);
            employeeUpdateEmployeeByIdRequest.addressLine2(this.addressLine2);
            employeeUpdateEmployeeByIdRequest.swiftBic(this.swiftBic);
            employeeUpdateEmployeeByIdRequest.managerId(this.managerId);
            employeeUpdateEmployeeByIdRequest.locationId(this.locationId);
            employeeUpdateEmployeeByIdRequest.timeoffManagerId(this.timeoffManagerId);
            employeeUpdateEmployeeByIdRequest.phoneNumber(this.phoneNumber);
            employeeUpdateEmployeeByIdRequest.socialSecurityNumber(this.socialSecurityNumber);
            employeeUpdateEmployeeByIdRequest.legalEntityId(this.legalEntityId);
            employeeUpdateEmployeeByIdRequest.companyIdentifier(this.companyIdentifier);
            employeeUpdateEmployeeByIdRequest.contactName(this.contactName);
            employeeUpdateEmployeeByIdRequest.contactNumber(this.contactNumber);
            employeeUpdateEmployeeByIdRequest.taxId(this.taxId);
            return employeeUpdateEmployeeByIdRequest;
        }

        /**
         * Execute updateEmployeeById request
         * @return EmployeeV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public EmployeeV2 execute() throws ApiException {
            EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest = buildBodyParams();
            ApiResponse<EmployeeV2> localVarResp = updateEmployeeByIdWithHttpInfo(id, employeeUpdateEmployeeByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateEmployeeById request with HTTP info returned
         * @return ApiResponse&lt;EmployeeV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<EmployeeV2> executeWithHttpInfo() throws ApiException {
            EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest = buildBodyParams();
            return updateEmployeeByIdWithHttpInfo(id, employeeUpdateEmployeeByIdRequest);
        }

        /**
         * Execute updateEmployeeById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<EmployeeV2> _callback) throws ApiException {
            EmployeeUpdateEmployeeByIdRequest employeeUpdateEmployeeByIdRequest = buildBodyParams();
            return updateEmployeeByIdAsync(id, employeeUpdateEmployeeByIdRequest, _callback);
        }
    }

    /**
     * Update employee
     * Update employee
     * @param id (Required) (required)
     * @return UpdateEmployeeByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateEmployeeByIdRequestBuilder updateEmployeeById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateEmployeeByIdRequestBuilder(id);
    }
    private okhttp3.Call updateInTeamCall(String id, String employeeId, EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = employeeUpdateInTeamRequest;

        // create path and map variables
        String localVarPath = "/v1/core/teams/{id}/employees/{employee_id}"
            .replace("{" + "id" + "}", localVarApiClient.escapeString(id.toString()))
            .replace("{" + "employee_id" + "}", localVarApiClient.escapeString(employeeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call updateInTeamValidateBeforeCall(String id, String employeeId, EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateInTeam(Async)");
        }

        // verify the required parameter 'employeeId' is set
        if (employeeId == null) {
            throw new ApiException("Missing the required parameter 'employeeId' when calling updateInTeam(Async)");
        }

        return updateInTeamCall(id, employeeId, employeeUpdateInTeamRequest, _callback);

    }


    private ApiResponse<Team> updateInTeamWithHttpInfo(String id, String employeeId, EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest) throws ApiException {
        okhttp3.Call localVarCall = updateInTeamValidateBeforeCall(id, employeeId, employeeUpdateInTeamRequest, null);
        Type localVarReturnType = new TypeToken<Team>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateInTeamAsync(String id, String employeeId, EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest, final ApiCallback<Team> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateInTeamValidateBeforeCall(id, employeeId, employeeUpdateInTeamRequest, _callback);
        Type localVarReturnType = new TypeToken<Team>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateInTeamRequestBuilder {
        private final String id;
        private final String employeeId;
        private Boolean lead;

        private UpdateInTeamRequestBuilder(String id, String employeeId) {
            this.id = id;
            this.employeeId = employeeId;
        }

        /**
         * Set lead
         * @param lead  (optional)
         * @return UpdateInTeamRequestBuilder
         */
        public UpdateInTeamRequestBuilder lead(Boolean lead) {
            this.lead = lead;
            return this;
        }
        
        /**
         * Build call for updateInTeam
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest = buildBodyParams();
            return updateInTeamCall(id, employeeId, employeeUpdateInTeamRequest, _callback);
        }

        private EmployeeUpdateInTeamRequest buildBodyParams() {
            EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest = new EmployeeUpdateInTeamRequest();
            employeeUpdateInTeamRequest.lead(this.lead);
            return employeeUpdateInTeamRequest;
        }

        /**
         * Execute updateInTeam request
         * @return Team
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Team execute() throws ApiException {
            EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest = buildBodyParams();
            ApiResponse<Team> localVarResp = updateInTeamWithHttpInfo(id, employeeId, employeeUpdateInTeamRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateInTeam request with HTTP info returned
         * @return ApiResponse&lt;Team&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Team> executeWithHttpInfo() throws ApiException {
            EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest = buildBodyParams();
            return updateInTeamWithHttpInfo(id, employeeId, employeeUpdateInTeamRequest);
        }

        /**
         * Execute updateInTeam request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Team> _callback) throws ApiException {
            EmployeeUpdateInTeamRequest employeeUpdateInTeamRequest = buildBodyParams();
            return updateInTeamAsync(id, employeeId, employeeUpdateInTeamRequest, _callback);
        }
    }

    /**
     * Update an employee in a team
     * Update an employee in a team
     * @param id (Required) (required)
     * @param employeeId (Required) (required)
     * @return UpdateInTeamRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateInTeamRequestBuilder updateInTeam(String id, String employeeId) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
            

        return new UpdateInTeamRequestBuilder(id, employeeId);
    }
}
