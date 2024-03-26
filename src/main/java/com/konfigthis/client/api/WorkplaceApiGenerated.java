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


import com.konfigthis.client.model.Workplace;
import com.konfigthis.client.model.WorkplaceCreateNewWorkplaceRequest;
import com.konfigthis.client.model.WorkplaceUpdateWorkplaceByIdRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class WorkplaceApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public WorkplaceApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public WorkplaceApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createNewWorkplaceCall(WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = workplaceCreateNewWorkplaceRequest;

        // create path and map variables
        String localVarPath = "/v2/core/workplaces";

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
    private okhttp3.Call createNewWorkplaceValidateBeforeCall(WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest, final ApiCallback _callback) throws ApiException {
        return createNewWorkplaceCall(workplaceCreateNewWorkplaceRequest, _callback);

    }


    private ApiResponse<Workplace> createNewWorkplaceWithHttpInfo(WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewWorkplaceValidateBeforeCall(workplaceCreateNewWorkplaceRequest, null);
        Type localVarReturnType = new TypeToken<Workplace>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewWorkplaceAsync(WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest, final ApiCallback<Workplace> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewWorkplaceValidateBeforeCall(workplaceCreateNewWorkplaceRequest, _callback);
        Type localVarReturnType = new TypeToken<Workplace>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewWorkplaceRequestBuilder {
        private final String name;
        private final String country;
        private final String timezone;
        private String state;
        private String city;
        private String addressLine1;
        private String addressLine2;
        private String postalCode;
        private String phoneNumber;
        private Integer companyId;
        private Integer legalEntityId;
        private Boolean main;
        private Float latitude;
        private Float longitude;

        private CreateNewWorkplaceRequestBuilder(String name, String country, String timezone) {
            this.name = name;
            this.country = country;
            this.timezone = timezone;
        }

        /**
         * Set state
         * @param state  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder state(String state) {
            this.state = state;
            return this;
        }
        
        /**
         * Set city
         * @param city  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder city(String city) {
            this.city = city;
            return this;
        }
        
        /**
         * Set addressLine1
         * @param addressLine1  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }
        
        /**
         * Set addressLine2
         * @param addressLine2  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }
        
        /**
         * Set postalCode
         * @param postalCode  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        
        /**
         * Set phoneNumber
         * @param phoneNumber  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        /**
         * Set companyId
         * @param companyId  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder companyId(Integer companyId) {
            this.companyId = companyId;
            return this;
        }
        
        /**
         * Set legalEntityId
         * @param legalEntityId  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder legalEntityId(Integer legalEntityId) {
            this.legalEntityId = legalEntityId;
            return this;
        }
        
        /**
         * Set main
         * @param main  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder main(Boolean main) {
            this.main = main;
            return this;
        }
        
        /**
         * Set latitude
         * @param latitude  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder latitude(Float latitude) {
            this.latitude = latitude;
            return this;
        }
        
        /**
         * Set longitude
         * @param longitude  (optional)
         * @return CreateNewWorkplaceRequestBuilder
         */
        public CreateNewWorkplaceRequestBuilder longitude(Float longitude) {
            this.longitude = longitude;
            return this;
        }
        
        /**
         * Build call for createNewWorkplace
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
            WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest = buildBodyParams();
            return createNewWorkplaceCall(workplaceCreateNewWorkplaceRequest, _callback);
        }

        private WorkplaceCreateNewWorkplaceRequest buildBodyParams() {
            WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest = new WorkplaceCreateNewWorkplaceRequest();
            workplaceCreateNewWorkplaceRequest.name(this.name);
            workplaceCreateNewWorkplaceRequest.country(this.country);
            workplaceCreateNewWorkplaceRequest.state(this.state);
            workplaceCreateNewWorkplaceRequest.city(this.city);
            workplaceCreateNewWorkplaceRequest.addressLine1(this.addressLine1);
            workplaceCreateNewWorkplaceRequest.addressLine2(this.addressLine2);
            workplaceCreateNewWorkplaceRequest.postalCode(this.postalCode);
            workplaceCreateNewWorkplaceRequest.phoneNumber(this.phoneNumber);
            workplaceCreateNewWorkplaceRequest.companyId(this.companyId);
            workplaceCreateNewWorkplaceRequest.legalEntityId(this.legalEntityId);
            workplaceCreateNewWorkplaceRequest.main(this.main);
            workplaceCreateNewWorkplaceRequest.latitude(this.latitude);
            workplaceCreateNewWorkplaceRequest.longitude(this.longitude);
            workplaceCreateNewWorkplaceRequest.timezone(this.timezone);
            return workplaceCreateNewWorkplaceRequest;
        }

        /**
         * Execute createNewWorkplace request
         * @return Workplace
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Workplace execute() throws ApiException {
            WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest = buildBodyParams();
            ApiResponse<Workplace> localVarResp = createNewWorkplaceWithHttpInfo(workplaceCreateNewWorkplaceRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewWorkplace request with HTTP info returned
         * @return ApiResponse&lt;Workplace&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Workplace> executeWithHttpInfo() throws ApiException {
            WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest = buildBodyParams();
            return createNewWorkplaceWithHttpInfo(workplaceCreateNewWorkplaceRequest);
        }

        /**
         * Execute createNewWorkplace request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Workplace> _callback) throws ApiException {
            WorkplaceCreateNewWorkplaceRequest workplaceCreateNewWorkplaceRequest = buildBodyParams();
            return createNewWorkplaceAsync(workplaceCreateNewWorkplaceRequest, _callback);
        }
    }

    /**
     * Create a workplace
     * Creates a workplace for a company
     * @return CreateNewWorkplaceRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewWorkplaceRequestBuilder createNewWorkplace(String name, String country, String timezone) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (country == null) throw new IllegalArgumentException("\"country\" is required but got null");
            

        if (timezone == null) throw new IllegalArgumentException("\"timezone\" is required but got null");
            

        return new CreateNewWorkplaceRequestBuilder(name, country, timezone);
    }
    private okhttp3.Call getByIdCall(Integer id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/core/workplaces/{id}"
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
    private okhttp3.Call getByIdValidateBeforeCall(Integer id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getById(Async)");
        }

        return getByIdCall(id, _callback);

    }


    private ApiResponse<Workplace> getByIdWithHttpInfo(Integer id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Workplace>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(Integer id, final ApiCallback<Workplace> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Workplace>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetByIdRequestBuilder {
        private final Integer id;

        private GetByIdRequestBuilder(Integer id) {
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
         * @return Workplace
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Workplace execute() throws ApiException {
            ApiResponse<Workplace> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;Workplace&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Workplace> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Workplace> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get a workplace
     * This endpoint allows you to retrieve a workplace by id
     * @param id  (required)
     * @return GetByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetByIdRequestBuilder getById(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new GetByIdRequestBuilder(id);
    }
    private okhttp3.Call listAllWorkplacesCall(String ids, String employeeIds, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/core/workplaces";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (ids != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("ids", ids));
        }

        if (employeeIds != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("employee_ids", employeeIds));
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
    private okhttp3.Call listAllWorkplacesValidateBeforeCall(String ids, String employeeIds, final ApiCallback _callback) throws ApiException {
        return listAllWorkplacesCall(ids, employeeIds, _callback);

    }


    private ApiResponse<List<Workplace>> listAllWorkplacesWithHttpInfo(String ids, String employeeIds) throws ApiException {
        okhttp3.Call localVarCall = listAllWorkplacesValidateBeforeCall(ids, employeeIds, null);
        Type localVarReturnType = new TypeToken<List<Workplace>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listAllWorkplacesAsync(String ids, String employeeIds, final ApiCallback<List<Workplace>> _callback) throws ApiException {

        okhttp3.Call localVarCall = listAllWorkplacesValidateBeforeCall(ids, employeeIds, _callback);
        Type localVarReturnType = new TypeToken<List<Workplace>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListAllWorkplacesRequestBuilder {
        private String ids;
        private String employeeIds;

        private ListAllWorkplacesRequestBuilder() {
        }

        /**
         * Set ids
         * @param ids Workplaces id comma separated values (optional)
         * @return ListAllWorkplacesRequestBuilder
         */
        public ListAllWorkplacesRequestBuilder ids(String ids) {
            this.ids = ids;
            return this;
        }
        
        /**
         * Set employeeIds
         * @param employeeIds Employees id comma separated values (optional)
         * @return ListAllWorkplacesRequestBuilder
         */
        public ListAllWorkplacesRequestBuilder employeeIds(String employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        
        /**
         * Build call for listAllWorkplaces
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
            return listAllWorkplacesCall(ids, employeeIds, _callback);
        }


        /**
         * Execute listAllWorkplaces request
         * @return List&lt;Workplace&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Workplace> execute() throws ApiException {
            ApiResponse<List<Workplace>> localVarResp = listAllWorkplacesWithHttpInfo(ids, employeeIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listAllWorkplaces request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Workplace&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Workplace>> executeWithHttpInfo() throws ApiException {
            return listAllWorkplacesWithHttpInfo(ids, employeeIds);
        }

        /**
         * Execute listAllWorkplaces request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Workplace>> _callback) throws ApiException {
            return listAllWorkplacesAsync(ids, employeeIds, _callback);
        }
    }

    /**
     * Get all workplaces
     * This endpoint allows you to retrieve all workplaces for a company
     * @return ListAllWorkplacesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ListAllWorkplacesRequestBuilder listAllWorkplaces() throws IllegalArgumentException {
        return new ListAllWorkplacesRequestBuilder();
    }
    private okhttp3.Call removeWorkplaceCall(Integer id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/core/workplaces/{id}"
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
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call removeWorkplaceValidateBeforeCall(Integer id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling removeWorkplace(Async)");
        }

        return removeWorkplaceCall(id, _callback);

    }


    private ApiResponse<List<Workplace>> removeWorkplaceWithHttpInfo(Integer id) throws ApiException {
        okhttp3.Call localVarCall = removeWorkplaceValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<List<Workplace>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call removeWorkplaceAsync(Integer id, final ApiCallback<List<Workplace>> _callback) throws ApiException {

        okhttp3.Call localVarCall = removeWorkplaceValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<List<Workplace>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RemoveWorkplaceRequestBuilder {
        private final Integer id;

        private RemoveWorkplaceRequestBuilder(Integer id) {
            this.id = id;
        }

        /**
         * Build call for removeWorkplace
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
            return removeWorkplaceCall(id, _callback);
        }


        /**
         * Execute removeWorkplace request
         * @return List&lt;Workplace&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Workplace> execute() throws ApiException {
            ApiResponse<List<Workplace>> localVarResp = removeWorkplaceWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute removeWorkplace request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Workplace&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Workplace>> executeWithHttpInfo() throws ApiException {
            return removeWorkplaceWithHttpInfo(id);
        }

        /**
         * Execute removeWorkplace request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Workplace>> _callback) throws ApiException {
            return removeWorkplaceAsync(id, _callback);
        }
    }

    /**
     * Delete a workplace
     * Delete a workplace
     * @param id (Required) (required)
     * @return RemoveWorkplaceRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public RemoveWorkplaceRequestBuilder removeWorkplace(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new RemoveWorkplaceRequestBuilder(id);
    }
    private okhttp3.Call updateWorkplaceByIdCall(Integer id, WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = workplaceUpdateWorkplaceByIdRequest;

        // create path and map variables
        String localVarPath = "/v2/core/workplaces/{id}"
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
    private okhttp3.Call updateWorkplaceByIdValidateBeforeCall(Integer id, WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateWorkplaceById(Async)");
        }

        return updateWorkplaceByIdCall(id, workplaceUpdateWorkplaceByIdRequest, _callback);

    }


    private ApiResponse<Workplace> updateWorkplaceByIdWithHttpInfo(Integer id, WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateWorkplaceByIdValidateBeforeCall(id, workplaceUpdateWorkplaceByIdRequest, null);
        Type localVarReturnType = new TypeToken<Workplace>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateWorkplaceByIdAsync(Integer id, WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest, final ApiCallback<Workplace> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateWorkplaceByIdValidateBeforeCall(id, workplaceUpdateWorkplaceByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<Workplace>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateWorkplaceByIdRequestBuilder {
        private final Integer id;
        private String name;
        private String country;
        private String state;
        private String city;
        private String addressLine1;
        private String addressLine2;
        private String postalCode;
        private String phoneNumber;
        private Integer payrollPolicyId;
        private Boolean main;
        private String timezone;

        private UpdateWorkplaceByIdRequestBuilder(Integer id) {
            this.id = id;
        }

        /**
         * Set name
         * @param name  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Set country
         * @param country  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder country(String country) {
            this.country = country;
            return this;
        }
        
        /**
         * Set state
         * @param state  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder state(String state) {
            this.state = state;
            return this;
        }
        
        /**
         * Set city
         * @param city  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder city(String city) {
            this.city = city;
            return this;
        }
        
        /**
         * Set addressLine1
         * @param addressLine1  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder addressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }
        
        /**
         * Set addressLine2
         * @param addressLine2  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder addressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }
        
        /**
         * Set postalCode
         * @param postalCode  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }
        
        /**
         * Set phoneNumber
         * @param phoneNumber  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        
        /**
         * Set payrollPolicyId
         * @param payrollPolicyId  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder payrollPolicyId(Integer payrollPolicyId) {
            this.payrollPolicyId = payrollPolicyId;
            return this;
        }
        
        /**
         * Set main
         * @param main  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder main(Boolean main) {
            this.main = main;
            return this;
        }
        
        /**
         * Set timezone
         * @param timezone  (optional)
         * @return UpdateWorkplaceByIdRequestBuilder
         */
        public UpdateWorkplaceByIdRequestBuilder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }
        
        /**
         * Build call for updateWorkplaceById
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
            WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest = buildBodyParams();
            return updateWorkplaceByIdCall(id, workplaceUpdateWorkplaceByIdRequest, _callback);
        }

        private WorkplaceUpdateWorkplaceByIdRequest buildBodyParams() {
            WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest = new WorkplaceUpdateWorkplaceByIdRequest();
            workplaceUpdateWorkplaceByIdRequest.name(this.name);
            workplaceUpdateWorkplaceByIdRequest.country(this.country);
            workplaceUpdateWorkplaceByIdRequest.state(this.state);
            workplaceUpdateWorkplaceByIdRequest.city(this.city);
            workplaceUpdateWorkplaceByIdRequest.addressLine1(this.addressLine1);
            workplaceUpdateWorkplaceByIdRequest.addressLine2(this.addressLine2);
            workplaceUpdateWorkplaceByIdRequest.postalCode(this.postalCode);
            workplaceUpdateWorkplaceByIdRequest.phoneNumber(this.phoneNumber);
            workplaceUpdateWorkplaceByIdRequest.payrollPolicyId(this.payrollPolicyId);
            workplaceUpdateWorkplaceByIdRequest.main(this.main);
            workplaceUpdateWorkplaceByIdRequest.timezone(this.timezone);
            return workplaceUpdateWorkplaceByIdRequest;
        }

        /**
         * Execute updateWorkplaceById request
         * @return Workplace
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Workplace execute() throws ApiException {
            WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest = buildBodyParams();
            ApiResponse<Workplace> localVarResp = updateWorkplaceByIdWithHttpInfo(id, workplaceUpdateWorkplaceByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateWorkplaceById request with HTTP info returned
         * @return ApiResponse&lt;Workplace&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Workplace> executeWithHttpInfo() throws ApiException {
            WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest = buildBodyParams();
            return updateWorkplaceByIdWithHttpInfo(id, workplaceUpdateWorkplaceByIdRequest);
        }

        /**
         * Execute updateWorkplaceById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Workplace> _callback) throws ApiException {
            WorkplaceUpdateWorkplaceByIdRequest workplaceUpdateWorkplaceByIdRequest = buildBodyParams();
            return updateWorkplaceByIdAsync(id, workplaceUpdateWorkplaceByIdRequest, _callback);
        }
    }

    /**
     * Updates a workplace
     * Updates a workplace of a company
     * @param id  (required)
     * @return UpdateWorkplaceByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateWorkplaceByIdRequestBuilder updateWorkplaceById(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new UpdateWorkplaceByIdRequestBuilder(id);
    }
}
