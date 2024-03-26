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


import com.konfigthis.client.model.Shift;
import com.konfigthis.client.model.ShiftCreateClockInShiftRequest;
import com.konfigthis.client.model.ShiftCreateNewShiftRequest;
import com.konfigthis.client.model.ShiftManagement;
import com.konfigthis.client.model.ShiftPublishShiftsInsideTimeRangeRequest;
import com.konfigthis.client.model.ShiftToggleShiftStatusRequest;
import com.konfigthis.client.model.ShiftUpdateClockOutShiftRequest;
import com.konfigthis.client.model.ShiftUpdateNotesRequest;
import com.konfigthis.client.model.ShiftUpdateShiftRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ShiftApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ShiftApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public ShiftApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createClockInShiftCall(ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftCreateClockInShiftRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts/clock_in";

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
    private okhttp3.Call createClockInShiftValidateBeforeCall(ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest, final ApiCallback _callback) throws ApiException {
        return createClockInShiftCall(shiftCreateClockInShiftRequest, _callback);

    }


    private ApiResponse<Shift> createClockInShiftWithHttpInfo(ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest) throws ApiException {
        okhttp3.Call localVarCall = createClockInShiftValidateBeforeCall(shiftCreateClockInShiftRequest, null);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createClockInShiftAsync(ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest, final ApiCallback<Shift> _callback) throws ApiException {

        okhttp3.Call localVarCall = createClockInShiftValidateBeforeCall(shiftCreateClockInShiftRequest, _callback);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateClockInShiftRequestBuilder {
        private final Integer employeeId;
        private final String now;
        private String observations;
        private String locationType;

        private CreateClockInShiftRequestBuilder(Integer employeeId, String now) {
            this.employeeId = employeeId;
            this.now = now;
        }

        /**
         * Set observations
         * @param observations  (optional)
         * @return CreateClockInShiftRequestBuilder
         */
        public CreateClockInShiftRequestBuilder observations(String observations) {
            this.observations = observations;
            return this;
        }
        
        /**
         * Set locationType
         * @param locationType  (optional)
         * @return CreateClockInShiftRequestBuilder
         */
        public CreateClockInShiftRequestBuilder locationType(String locationType) {
            this.locationType = locationType;
            return this;
        }
        
        /**
         * Build call for createClockInShift
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
            ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest = buildBodyParams();
            return createClockInShiftCall(shiftCreateClockInShiftRequest, _callback);
        }

        private ShiftCreateClockInShiftRequest buildBodyParams() {
            ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest = new ShiftCreateClockInShiftRequest();
            shiftCreateClockInShiftRequest.employeeId(this.employeeId);
            shiftCreateClockInShiftRequest.now(this.now);
            shiftCreateClockInShiftRequest.observations(this.observations);
            if (this.locationType != null)
            shiftCreateClockInShiftRequest.locationType(ShiftCreateClockInShiftRequest.LocationTypeEnum.fromValue(this.locationType));
            return shiftCreateClockInShiftRequest;
        }

        /**
         * Execute createClockInShift request
         * @return Shift
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Shift execute() throws ApiException {
            ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest = buildBodyParams();
            ApiResponse<Shift> localVarResp = createClockInShiftWithHttpInfo(shiftCreateClockInShiftRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createClockInShift request with HTTP info returned
         * @return ApiResponse&lt;Shift&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Shift> executeWithHttpInfo() throws ApiException {
            ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest = buildBodyParams();
            return createClockInShiftWithHttpInfo(shiftCreateClockInShiftRequest);
        }

        /**
         * Execute createClockInShift request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Shift> _callback) throws ApiException {
            ShiftCreateClockInShiftRequest shiftCreateClockInShiftRequest = buildBodyParams();
            return createClockInShiftAsync(shiftCreateClockInShiftRequest, _callback);
        }
    }

    /**
     * Clock in
     * Creates a shift (time registry) for the current user with the clock_in time of the request and nil clock_out
     * @return CreateClockInShiftRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateClockInShiftRequestBuilder createClockInShift(Integer employeeId, String now) throws IllegalArgumentException {
        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        if (now == null) throw new IllegalArgumentException("\"now\" is required but got null");
            

        return new CreateClockInShiftRequestBuilder(employeeId, now);
    }
    private okhttp3.Call createNewShiftCall(ShiftCreateNewShiftRequest shiftCreateNewShiftRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftCreateNewShiftRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts_management";

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
    private okhttp3.Call createNewShiftValidateBeforeCall(ShiftCreateNewShiftRequest shiftCreateNewShiftRequest, final ApiCallback _callback) throws ApiException {
        return createNewShiftCall(shiftCreateNewShiftRequest, _callback);

    }


    private ApiResponse<ShiftManagement> createNewShiftWithHttpInfo(ShiftCreateNewShiftRequest shiftCreateNewShiftRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewShiftValidateBeforeCall(shiftCreateNewShiftRequest, null);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewShiftAsync(ShiftCreateNewShiftRequest shiftCreateNewShiftRequest, final ApiCallback<ShiftManagement> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewShiftValidateBeforeCall(shiftCreateNewShiftRequest, _callback);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewShiftRequestBuilder {
        private final String startAt;
        private final String endAt;
        private final Integer employeeId;
        private String notes;
        private Integer locationId;
        private Integer workAreaId;

        private CreateNewShiftRequestBuilder(String startAt, String endAt, Integer employeeId) {
            this.startAt = startAt;
            this.endAt = endAt;
            this.employeeId = employeeId;
        }

        /**
         * Set notes
         * @param notes  (optional)
         * @return CreateNewShiftRequestBuilder
         */
        public CreateNewShiftRequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }
        
        /**
         * Set locationId
         * @param locationId  (optional)
         * @return CreateNewShiftRequestBuilder
         */
        public CreateNewShiftRequestBuilder locationId(Integer locationId) {
            this.locationId = locationId;
            return this;
        }
        
        /**
         * Set workAreaId
         * @param workAreaId  (optional)
         * @return CreateNewShiftRequestBuilder
         */
        public CreateNewShiftRequestBuilder workAreaId(Integer workAreaId) {
            this.workAreaId = workAreaId;
            return this;
        }
        
        /**
         * Build call for createNewShift
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
            ShiftCreateNewShiftRequest shiftCreateNewShiftRequest = buildBodyParams();
            return createNewShiftCall(shiftCreateNewShiftRequest, _callback);
        }

        private ShiftCreateNewShiftRequest buildBodyParams() {
            ShiftCreateNewShiftRequest shiftCreateNewShiftRequest = new ShiftCreateNewShiftRequest();
            shiftCreateNewShiftRequest.startAt(this.startAt);
            shiftCreateNewShiftRequest.endAt(this.endAt);
            shiftCreateNewShiftRequest.employeeId(this.employeeId);
            shiftCreateNewShiftRequest.notes(this.notes);
            shiftCreateNewShiftRequest.locationId(this.locationId);
            shiftCreateNewShiftRequest.workAreaId(this.workAreaId);
            return shiftCreateNewShiftRequest;
        }

        /**
         * Execute createNewShift request
         * @return ShiftManagement
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ShiftManagement execute() throws ApiException {
            ShiftCreateNewShiftRequest shiftCreateNewShiftRequest = buildBodyParams();
            ApiResponse<ShiftManagement> localVarResp = createNewShiftWithHttpInfo(shiftCreateNewShiftRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewShift request with HTTP info returned
         * @return ApiResponse&lt;ShiftManagement&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ShiftManagement> executeWithHttpInfo() throws ApiException {
            ShiftCreateNewShiftRequest shiftCreateNewShiftRequest = buildBodyParams();
            return createNewShiftWithHttpInfo(shiftCreateNewShiftRequest);
        }

        /**
         * Execute createNewShift request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ShiftManagement> _callback) throws ApiException {
            ShiftCreateNewShiftRequest shiftCreateNewShiftRequest = buildBodyParams();
            return createNewShiftAsync(shiftCreateNewShiftRequest, _callback);
        }
    }

    /**
     * Create a shift
     * Create a shift
     * @return CreateNewShiftRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewShiftRequestBuilder createNewShift(String startAt, String endAt, Integer employeeId) throws IllegalArgumentException {
        if (startAt == null) throw new IllegalArgumentException("\"startAt\" is required but got null");
            

        if (endAt == null) throw new IllegalArgumentException("\"endAt\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new CreateNewShiftRequestBuilder(startAt, endAt, employeeId);
    }
    private okhttp3.Call deleteByIdCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/time/shifts_management/{id}"
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
    private okhttp3.Call deleteByIdValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteById(Async)");
        }

        return deleteByIdCall(id, _callback);

    }


    private ApiResponse<ShiftManagement> deleteByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteByIdAsync(String id, final ApiCallback<ShiftManagement> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteByIdRequestBuilder {
        private final String id;

        private DeleteByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for deleteById
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
            return deleteByIdCall(id, _callback);
        }


        /**
         * Execute deleteById request
         * @return ShiftManagement
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ShiftManagement execute() throws ApiException {
            ApiResponse<ShiftManagement> localVarResp = deleteByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteById request with HTTP info returned
         * @return ApiResponse&lt;ShiftManagement&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ShiftManagement> executeWithHttpInfo() throws ApiException {
            return deleteByIdWithHttpInfo(id);
        }

        /**
         * Execute deleteById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ShiftManagement> _callback) throws ApiException {
            return deleteByIdAsync(id, _callback);
        }
    }

    /**
     * Delete Shift
     * Delete Shift
     * @param id (Required) (required)
     * @return DeleteByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteByIdRequestBuilder deleteById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteByIdRequestBuilder(id);
    }
    private okhttp3.Call deleteShiftByIdCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/time/shifts/{id}"
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
    private okhttp3.Call deleteShiftByIdValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteShiftById(Async)");
        }

        return deleteShiftByIdCall(id, _callback);

    }


    private ApiResponse<Shift> deleteShiftByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteShiftByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteShiftByIdAsync(String id, final ApiCallback<Shift> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteShiftByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteShiftByIdRequestBuilder {
        private final String id;

        private DeleteShiftByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for deleteShiftById
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
            return deleteShiftByIdCall(id, _callback);
        }


        /**
         * Execute deleteShiftById request
         * @return Shift
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Shift execute() throws ApiException {
            ApiResponse<Shift> localVarResp = deleteShiftByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteShiftById request with HTTP info returned
         * @return ApiResponse&lt;Shift&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Shift> executeWithHttpInfo() throws ApiException {
            return deleteShiftByIdWithHttpInfo(id);
        }

        /**
         * Execute deleteShiftById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Shift> _callback) throws ApiException {
            return deleteShiftByIdAsync(id, _callback);
        }
    }

    /**
     * Delete Shift (time registry)
     * Delete Shift (time registry)
     * @param id (Required) (required)
     * @return DeleteShiftByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteShiftByIdRequestBuilder deleteShiftById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteShiftByIdRequestBuilder(id);
    }
    private okhttp3.Call getAllShiftsCall(Integer employeeId, List<Integer> employeeIdsPercent5BPercent5D, String startAt, String endAt, Boolean onlyPublished, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/time/shifts_management";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (employeeId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("employee_id", employeeId));
        }

        if (employeeIdsPercent5BPercent5D != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "employee_ids%5B%5D", employeeIdsPercent5BPercent5D));
        }

        if (startAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("start_at", startAt));
        }

        if (endAt != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("end_at", endAt));
        }

        if (onlyPublished != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("only_published", onlyPublished));
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
    private okhttp3.Call getAllShiftsValidateBeforeCall(Integer employeeId, List<Integer> employeeIdsPercent5BPercent5D, String startAt, String endAt, Boolean onlyPublished, final ApiCallback _callback) throws ApiException {
        return getAllShiftsCall(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished, _callback);

    }


    private ApiResponse<List<ShiftManagement>> getAllShiftsWithHttpInfo(Integer employeeId, List<Integer> employeeIdsPercent5BPercent5D, String startAt, String endAt, Boolean onlyPublished) throws ApiException {
        okhttp3.Call localVarCall = getAllShiftsValidateBeforeCall(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished, null);
        Type localVarReturnType = new TypeToken<List<ShiftManagement>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllShiftsAsync(Integer employeeId, List<Integer> employeeIdsPercent5BPercent5D, String startAt, String endAt, Boolean onlyPublished, final ApiCallback<List<ShiftManagement>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllShiftsValidateBeforeCall(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished, _callback);
        Type localVarReturnType = new TypeToken<List<ShiftManagement>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllShiftsRequestBuilder {
        private Integer employeeId;
        private List<Integer> employeeIdsPercent5BPercent5D;
        private String startAt;
        private String endAt;
        private Boolean onlyPublished;

        private GetAllShiftsRequestBuilder() {
        }

        /**
         * Set employeeId
         * @param employeeId Employee ID to find shifts from (optional)
         * @return GetAllShiftsRequestBuilder
         */
        public GetAllShiftsRequestBuilder employeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        
        /**
         * Set employeeIdsPercent5BPercent5D
         * @param employeeIdsPercent5BPercent5D Employee IDs to find shifts from (optional)
         * @return GetAllShiftsRequestBuilder
         */
        public GetAllShiftsRequestBuilder employeeIdsPercent5BPercent5D(List<Integer> employeeIdsPercent5BPercent5D) {
            this.employeeIdsPercent5BPercent5D = employeeIdsPercent5BPercent5D;
            return this;
        }
        
        /**
         * Set startAt
         * @param startAt Start date to find shifts from (optional)
         * @return GetAllShiftsRequestBuilder
         */
        public GetAllShiftsRequestBuilder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }
        
        /**
         * Set endAt
         * @param endAt End date to find shifts to (optional)
         * @return GetAllShiftsRequestBuilder
         */
        public GetAllShiftsRequestBuilder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }
        
        /**
         * Set onlyPublished
         * @param onlyPublished To return only published shifts (optional)
         * @return GetAllShiftsRequestBuilder
         */
        public GetAllShiftsRequestBuilder onlyPublished(Boolean onlyPublished) {
            this.onlyPublished = onlyPublished;
            return this;
        }
        
        /**
         * Build call for getAllShifts
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
            return getAllShiftsCall(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished, _callback);
        }


        /**
         * Execute getAllShifts request
         * @return List&lt;ShiftManagement&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<ShiftManagement> execute() throws ApiException {
            ApiResponse<List<ShiftManagement>> localVarResp = getAllShiftsWithHttpInfo(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAllShifts request with HTTP info returned
         * @return ApiResponse&lt;List&lt;ShiftManagement&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<ShiftManagement>> executeWithHttpInfo() throws ApiException {
            return getAllShiftsWithHttpInfo(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished);
        }

        /**
         * Execute getAllShifts request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<ShiftManagement>> _callback) throws ApiException {
            return getAllShiftsAsync(employeeId, employeeIdsPercent5BPercent5D, startAt, endAt, onlyPublished, _callback);
        }
    }

    /**
     * Get all shifts from a company
     * By default, it returns all the shifts for the current week
     * @return GetAllShiftsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetAllShiftsRequestBuilder getAllShifts() throws IllegalArgumentException {
        return new GetAllShiftsRequestBuilder();
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
        String localVarPath = "/v1/time/shifts_management/{id}"
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


    private ApiResponse<ShiftManagement> getByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(String id, final ApiCallback<ShiftManagement> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
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
         * @return ShiftManagement
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ShiftManagement execute() throws ApiException {
            ApiResponse<ShiftManagement> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;ShiftManagement&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ShiftManagement> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<ShiftManagement> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get Shift
     * Get Shift
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
    private okhttp3.Call getFromCompanyCall(String year, String month, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/time/shifts";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (year != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("year", year));
        }

        if (month != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("month", month));
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
    private okhttp3.Call getFromCompanyValidateBeforeCall(String year, String month, final ApiCallback _callback) throws ApiException {
        return getFromCompanyCall(year, month, _callback);

    }


    private ApiResponse<List<Shift>> getFromCompanyWithHttpInfo(String year, String month) throws ApiException {
        okhttp3.Call localVarCall = getFromCompanyValidateBeforeCall(year, month, null);
        Type localVarReturnType = new TypeToken<List<Shift>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getFromCompanyAsync(String year, String month, final ApiCallback<List<Shift>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getFromCompanyValidateBeforeCall(year, month, _callback);
        Type localVarReturnType = new TypeToken<List<Shift>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetFromCompanyRequestBuilder {
        private String year;
        private String month;

        private GetFromCompanyRequestBuilder() {
        }

        /**
         * Set year
         * @param year It should be valid year in the format &#x60;YYYY&#x60; (optional)
         * @return GetFromCompanyRequestBuilder
         */
        public GetFromCompanyRequestBuilder year(String year) {
            this.year = year;
            return this;
        }
        
        /**
         * Set month
         * @param month It should be valid month in the calendar ranging rom &#x60;01 to 12&#x60;. The month format is &#x60;MM&#x60; (optional)
         * @return GetFromCompanyRequestBuilder
         */
        public GetFromCompanyRequestBuilder month(String month) {
            this.month = month;
            return this;
        }
        
        /**
         * Build call for getFromCompany
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
            return getFromCompanyCall(year, month, _callback);
        }


        /**
         * Execute getFromCompany request
         * @return List&lt;Shift&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Shift> execute() throws ApiException {
            ApiResponse<List<Shift>> localVarResp = getFromCompanyWithHttpInfo(year, month);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getFromCompany request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Shift&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Shift>> executeWithHttpInfo() throws ApiException {
            return getFromCompanyWithHttpInfo(year, month);
        }

        /**
         * Execute getFromCompany request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Shift>> _callback) throws ApiException {
            return getFromCompanyAsync(year, month, _callback);
        }
    }

    /**
     * Get shifts (time registries) from a company
     * Get shifts (time registries) from a company
     * @return GetFromCompanyRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetFromCompanyRequestBuilder getFromCompany() throws IllegalArgumentException {
        return new GetFromCompanyRequestBuilder();
    }
    private okhttp3.Call publishShiftsInsideTimeRangeCall(ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftPublishShiftsInsideTimeRangeRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts_management/publish";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
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
    private okhttp3.Call publishShiftsInsideTimeRangeValidateBeforeCall(ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest, final ApiCallback _callback) throws ApiException {
        return publishShiftsInsideTimeRangeCall(shiftPublishShiftsInsideTimeRangeRequest, _callback);

    }


    private ApiResponse<Void> publishShiftsInsideTimeRangeWithHttpInfo(ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest) throws ApiException {
        okhttp3.Call localVarCall = publishShiftsInsideTimeRangeValidateBeforeCall(shiftPublishShiftsInsideTimeRangeRequest, null);
        return localVarApiClient.execute(localVarCall);
    }

    private okhttp3.Call publishShiftsInsideTimeRangeAsync(ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest, final ApiCallback<Void> _callback) throws ApiException {

        okhttp3.Call localVarCall = publishShiftsInsideTimeRangeValidateBeforeCall(shiftPublishShiftsInsideTimeRangeRequest, _callback);
        localVarApiClient.executeAsync(localVarCall, _callback);
        return localVarCall;
    }

    public class PublishShiftsInsideTimeRangeRequestBuilder {
        private String startAt;
        private String endAt;
        private List<Integer> employeeIds;
        private Boolean sendNotification;

        private PublishShiftsInsideTimeRangeRequestBuilder() {
        }

        /**
         * Set startAt
         * @param startAt  (optional)
         * @return PublishShiftsInsideTimeRangeRequestBuilder
         */
        public PublishShiftsInsideTimeRangeRequestBuilder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }
        
        /**
         * Set endAt
         * @param endAt  (optional)
         * @return PublishShiftsInsideTimeRangeRequestBuilder
         */
        public PublishShiftsInsideTimeRangeRequestBuilder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }
        
        /**
         * Set employeeIds
         * @param employeeIds  (optional)
         * @return PublishShiftsInsideTimeRangeRequestBuilder
         */
        public PublishShiftsInsideTimeRangeRequestBuilder employeeIds(List<Integer> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        
        /**
         * Set sendNotification
         * @param sendNotification  (optional)
         * @return PublishShiftsInsideTimeRangeRequestBuilder
         */
        public PublishShiftsInsideTimeRangeRequestBuilder sendNotification(Boolean sendNotification) {
            this.sendNotification = sendNotification;
            return this;
        }
        
        /**
         * Build call for publishShiftsInsideTimeRange
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
            ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest = buildBodyParams();
            return publishShiftsInsideTimeRangeCall(shiftPublishShiftsInsideTimeRangeRequest, _callback);
        }

        private ShiftPublishShiftsInsideTimeRangeRequest buildBodyParams() {
            ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest = new ShiftPublishShiftsInsideTimeRangeRequest();
            shiftPublishShiftsInsideTimeRangeRequest.startAt(this.startAt);
            shiftPublishShiftsInsideTimeRangeRequest.endAt(this.endAt);
            shiftPublishShiftsInsideTimeRangeRequest.employeeIds(this.employeeIds);
            shiftPublishShiftsInsideTimeRangeRequest.sendNotification(this.sendNotification);
            return shiftPublishShiftsInsideTimeRangeRequest;
        }

        /**
         * Execute publishShiftsInsideTimeRange request
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public void execute() throws ApiException {
            ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest = buildBodyParams();
            publishShiftsInsideTimeRangeWithHttpInfo(shiftPublishShiftsInsideTimeRangeRequest);
        }

        /**
         * Execute publishShiftsInsideTimeRange request with HTTP info returned
         * @return ApiResponse&lt;Void&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Void> executeWithHttpInfo() throws ApiException {
            ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest = buildBodyParams();
            return publishShiftsInsideTimeRangeWithHttpInfo(shiftPublishShiftsInsideTimeRangeRequest);
        }

        /**
         * Execute publishShiftsInsideTimeRange request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Void> _callback) throws ApiException {
            ShiftPublishShiftsInsideTimeRangeRequest shiftPublishShiftsInsideTimeRangeRequest = buildBodyParams();
            return publishShiftsInsideTimeRangeAsync(shiftPublishShiftsInsideTimeRangeRequest, _callback);
        }
    }

    /**
     * Publish shifts inside time range
     * Publish shifts inside time range
     * @return PublishShiftsInsideTimeRangeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public PublishShiftsInsideTimeRangeRequestBuilder publishShiftsInsideTimeRange() throws IllegalArgumentException {
        return new PublishShiftsInsideTimeRangeRequestBuilder();
    }
    private okhttp3.Call toggleShiftStatusCall(ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftToggleShiftStatusRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts/toggle";

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
    private okhttp3.Call toggleShiftStatusValidateBeforeCall(ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest, final ApiCallback _callback) throws ApiException {
        return toggleShiftStatusCall(shiftToggleShiftStatusRequest, _callback);

    }


    private ApiResponse<Shift> toggleShiftStatusWithHttpInfo(ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest) throws ApiException {
        okhttp3.Call localVarCall = toggleShiftStatusValidateBeforeCall(shiftToggleShiftStatusRequest, null);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call toggleShiftStatusAsync(ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest, final ApiCallback<Shift> _callback) throws ApiException {

        okhttp3.Call localVarCall = toggleShiftStatusValidateBeforeCall(shiftToggleShiftStatusRequest, _callback);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ToggleShiftStatusRequestBuilder {
        private final Integer employeeId;
        private final String now;

        private ToggleShiftStatusRequestBuilder(Integer employeeId, String now) {
            this.employeeId = employeeId;
            this.now = now;
        }

        /**
         * Build call for toggleShiftStatus
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
            ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest = buildBodyParams();
            return toggleShiftStatusCall(shiftToggleShiftStatusRequest, _callback);
        }

        private ShiftToggleShiftStatusRequest buildBodyParams() {
            ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest = new ShiftToggleShiftStatusRequest();
            shiftToggleShiftStatusRequest.employeeId(this.employeeId);
            shiftToggleShiftStatusRequest.now(this.now);
            return shiftToggleShiftStatusRequest;
        }

        /**
         * Execute toggleShiftStatus request
         * @return Shift
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Shift execute() throws ApiException {
            ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest = buildBodyParams();
            ApiResponse<Shift> localVarResp = toggleShiftStatusWithHttpInfo(shiftToggleShiftStatusRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute toggleShiftStatus request with HTTP info returned
         * @return ApiResponse&lt;Shift&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Shift> executeWithHttpInfo() throws ApiException {
            ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest = buildBodyParams();
            return toggleShiftStatusWithHttpInfo(shiftToggleShiftStatusRequest);
        }

        /**
         * Execute toggleShiftStatus request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Shift> _callback) throws ApiException {
            ShiftToggleShiftStatusRequest shiftToggleShiftStatusRequest = buildBodyParams();
            return toggleShiftStatusAsync(shiftToggleShiftStatusRequest, _callback);
        }
    }

    /**
     * Toggle
     * Updates a shift (time registry) for the current user with the time of the request. It will clock out if the user wasn&#39;t previously clocked in. Else it will clock in.
     * @return ToggleShiftStatusRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public ToggleShiftStatusRequestBuilder toggleShiftStatus(Integer employeeId, String now) throws IllegalArgumentException {
        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        if (now == null) throw new IllegalArgumentException("\"now\" is required but got null");
            

        return new ToggleShiftStatusRequestBuilder(employeeId, now);
    }
    private okhttp3.Call updateClockOutShiftCall(ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftUpdateClockOutShiftRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts/clock_out";

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
    private okhttp3.Call updateClockOutShiftValidateBeforeCall(ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest, final ApiCallback _callback) throws ApiException {
        return updateClockOutShiftCall(shiftUpdateClockOutShiftRequest, _callback);

    }


    private ApiResponse<Shift> updateClockOutShiftWithHttpInfo(ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest) throws ApiException {
        okhttp3.Call localVarCall = updateClockOutShiftValidateBeforeCall(shiftUpdateClockOutShiftRequest, null);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateClockOutShiftAsync(ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest, final ApiCallback<Shift> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateClockOutShiftValidateBeforeCall(shiftUpdateClockOutShiftRequest, _callback);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateClockOutShiftRequestBuilder {
        private final Integer employeeId;
        private final String now;
        private String observations;

        private UpdateClockOutShiftRequestBuilder(Integer employeeId, String now) {
            this.employeeId = employeeId;
            this.now = now;
        }

        /**
         * Set observations
         * @param observations  (optional)
         * @return UpdateClockOutShiftRequestBuilder
         */
        public UpdateClockOutShiftRequestBuilder observations(String observations) {
            this.observations = observations;
            return this;
        }
        
        /**
         * Build call for updateClockOutShift
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
            ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest = buildBodyParams();
            return updateClockOutShiftCall(shiftUpdateClockOutShiftRequest, _callback);
        }

        private ShiftUpdateClockOutShiftRequest buildBodyParams() {
            ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest = new ShiftUpdateClockOutShiftRequest();
            shiftUpdateClockOutShiftRequest.employeeId(this.employeeId);
            shiftUpdateClockOutShiftRequest.now(this.now);
            shiftUpdateClockOutShiftRequest.observations(this.observations);
            return shiftUpdateClockOutShiftRequest;
        }

        /**
         * Execute updateClockOutShift request
         * @return Shift
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Shift execute() throws ApiException {
            ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest = buildBodyParams();
            ApiResponse<Shift> localVarResp = updateClockOutShiftWithHttpInfo(shiftUpdateClockOutShiftRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateClockOutShift request with HTTP info returned
         * @return ApiResponse&lt;Shift&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Shift> executeWithHttpInfo() throws ApiException {
            ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest = buildBodyParams();
            return updateClockOutShiftWithHttpInfo(shiftUpdateClockOutShiftRequest);
        }

        /**
         * Execute updateClockOutShift request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Shift> _callback) throws ApiException {
            ShiftUpdateClockOutShiftRequest shiftUpdateClockOutShiftRequest = buildBodyParams();
            return updateClockOutShiftAsync(shiftUpdateClockOutShiftRequest, _callback);
        }
    }

    /**
     * Clock out
     * Updates a shift (time registry) for the current user with the clock_out time of the request. It will fail if the user wasn&#39;t previously clocked in.
     * @return UpdateClockOutShiftRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public UpdateClockOutShiftRequestBuilder updateClockOutShift(Integer employeeId, String now) throws IllegalArgumentException {
        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        if (now == null) throw new IllegalArgumentException("\"now\" is required but got null");
            

        return new UpdateClockOutShiftRequestBuilder(employeeId, now);
    }
    private okhttp3.Call updateNotesCall(String id, ShiftUpdateNotesRequest shiftUpdateNotesRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftUpdateNotesRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts_management/{id}/notes"
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
    private okhttp3.Call updateNotesValidateBeforeCall(String id, ShiftUpdateNotesRequest shiftUpdateNotesRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateNotes(Async)");
        }

        return updateNotesCall(id, shiftUpdateNotesRequest, _callback);

    }


    private ApiResponse<ShiftManagement> updateNotesWithHttpInfo(String id, ShiftUpdateNotesRequest shiftUpdateNotesRequest) throws ApiException {
        okhttp3.Call localVarCall = updateNotesValidateBeforeCall(id, shiftUpdateNotesRequest, null);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateNotesAsync(String id, ShiftUpdateNotesRequest shiftUpdateNotesRequest, final ApiCallback<ShiftManagement> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateNotesValidateBeforeCall(id, shiftUpdateNotesRequest, _callback);
        Type localVarReturnType = new TypeToken<ShiftManagement>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateNotesRequestBuilder {
        private final String id;
        private String notes;

        private UpdateNotesRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set notes
         * @param notes  (optional)
         * @return UpdateNotesRequestBuilder
         */
        public UpdateNotesRequestBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }
        
        /**
         * Build call for updateNotes
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
            ShiftUpdateNotesRequest shiftUpdateNotesRequest = buildBodyParams();
            return updateNotesCall(id, shiftUpdateNotesRequest, _callback);
        }

        private ShiftUpdateNotesRequest buildBodyParams() {
            ShiftUpdateNotesRequest shiftUpdateNotesRequest = new ShiftUpdateNotesRequest();
            shiftUpdateNotesRequest.notes(this.notes);
            return shiftUpdateNotesRequest;
        }

        /**
         * Execute updateNotes request
         * @return ShiftManagement
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ShiftManagement execute() throws ApiException {
            ShiftUpdateNotesRequest shiftUpdateNotesRequest = buildBodyParams();
            ApiResponse<ShiftManagement> localVarResp = updateNotesWithHttpInfo(id, shiftUpdateNotesRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateNotes request with HTTP info returned
         * @return ApiResponse&lt;ShiftManagement&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ShiftManagement> executeWithHttpInfo() throws ApiException {
            ShiftUpdateNotesRequest shiftUpdateNotesRequest = buildBodyParams();
            return updateNotesWithHttpInfo(id, shiftUpdateNotesRequest);
        }

        /**
         * Execute updateNotes request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ShiftManagement> _callback) throws ApiException {
            ShiftUpdateNotesRequest shiftUpdateNotesRequest = buildBodyParams();
            return updateNotesAsync(id, shiftUpdateNotesRequest, _callback);
        }
    }

    /**
     * Update shift notes
     * Update shift notes
     * @param id (Required) (required)
     * @return UpdateNotesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateNotesRequestBuilder updateNotes(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateNotesRequestBuilder(id);
    }
    private okhttp3.Call updateShiftCall(String id, ShiftUpdateShiftRequest shiftUpdateShiftRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = shiftUpdateShiftRequest;

        // create path and map variables
        String localVarPath = "/v1/time/shifts/{id}"
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
    private okhttp3.Call updateShiftValidateBeforeCall(String id, ShiftUpdateShiftRequest shiftUpdateShiftRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateShift(Async)");
        }

        return updateShiftCall(id, shiftUpdateShiftRequest, _callback);

    }


    private ApiResponse<Shift> updateShiftWithHttpInfo(String id, ShiftUpdateShiftRequest shiftUpdateShiftRequest) throws ApiException {
        okhttp3.Call localVarCall = updateShiftValidateBeforeCall(id, shiftUpdateShiftRequest, null);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateShiftAsync(String id, ShiftUpdateShiftRequest shiftUpdateShiftRequest, final ApiCallback<Shift> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateShiftValidateBeforeCall(id, shiftUpdateShiftRequest, _callback);
        Type localVarReturnType = new TypeToken<Shift>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateShiftRequestBuilder {
        private final String id;
        private String clockIn;
        private String clockOut;
        private String observations;

        private UpdateShiftRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set clockIn
         * @param clockIn  (optional)
         * @return UpdateShiftRequestBuilder
         */
        public UpdateShiftRequestBuilder clockIn(String clockIn) {
            this.clockIn = clockIn;
            return this;
        }
        
        /**
         * Set clockOut
         * @param clockOut  (optional)
         * @return UpdateShiftRequestBuilder
         */
        public UpdateShiftRequestBuilder clockOut(String clockOut) {
            this.clockOut = clockOut;
            return this;
        }
        
        /**
         * Set observations
         * @param observations  (optional)
         * @return UpdateShiftRequestBuilder
         */
        public UpdateShiftRequestBuilder observations(String observations) {
            this.observations = observations;
            return this;
        }
        
        /**
         * Build call for updateShift
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
            ShiftUpdateShiftRequest shiftUpdateShiftRequest = buildBodyParams();
            return updateShiftCall(id, shiftUpdateShiftRequest, _callback);
        }

        private ShiftUpdateShiftRequest buildBodyParams() {
            ShiftUpdateShiftRequest shiftUpdateShiftRequest = new ShiftUpdateShiftRequest();
            shiftUpdateShiftRequest.clockIn(this.clockIn);
            shiftUpdateShiftRequest.clockOut(this.clockOut);
            shiftUpdateShiftRequest.observations(this.observations);
            return shiftUpdateShiftRequest;
        }

        /**
         * Execute updateShift request
         * @return Shift
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Shift execute() throws ApiException {
            ShiftUpdateShiftRequest shiftUpdateShiftRequest = buildBodyParams();
            ApiResponse<Shift> localVarResp = updateShiftWithHttpInfo(id, shiftUpdateShiftRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateShift request with HTTP info returned
         * @return ApiResponse&lt;Shift&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Shift> executeWithHttpInfo() throws ApiException {
            ShiftUpdateShiftRequest shiftUpdateShiftRequest = buildBodyParams();
            return updateShiftWithHttpInfo(id, shiftUpdateShiftRequest);
        }

        /**
         * Execute updateShift request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Shift> _callback) throws ApiException {
            ShiftUpdateShiftRequest shiftUpdateShiftRequest = buildBodyParams();
            return updateShiftAsync(id, shiftUpdateShiftRequest, _callback);
        }
    }

    /**
     * Update Shift (time registry)
     * Updates a shift (time registry).
     * @param id (Required) (required)
     * @return UpdateShiftRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public UpdateShiftRequestBuilder updateShift(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateShiftRequestBuilder(id);
    }
}
