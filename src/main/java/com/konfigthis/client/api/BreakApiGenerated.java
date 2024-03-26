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


import com.konfigthis.client.model.Attendance;
import com.konfigthis.client.model.BreakCreateBreakRequest;
import com.konfigthis.client.model.BreakEndBreakRequest;
import com.konfigthis.client.model.BreakStartBreakRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class BreakApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public BreakApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public BreakApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createBreakCall(BreakCreateBreakRequest breakCreateBreakRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = breakCreateBreakRequest;

        // create path and map variables
        String localVarPath = "/v1/time/breaks";

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
    private okhttp3.Call createBreakValidateBeforeCall(BreakCreateBreakRequest breakCreateBreakRequest, final ApiCallback _callback) throws ApiException {
        return createBreakCall(breakCreateBreakRequest, _callback);

    }


    private ApiResponse<Attendance> createBreakWithHttpInfo(BreakCreateBreakRequest breakCreateBreakRequest) throws ApiException {
        okhttp3.Call localVarCall = createBreakValidateBeforeCall(breakCreateBreakRequest, null);
        Type localVarReturnType = new TypeToken<Attendance>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createBreakAsync(BreakCreateBreakRequest breakCreateBreakRequest, final ApiCallback<Attendance> _callback) throws ApiException {

        okhttp3.Call localVarCall = createBreakValidateBeforeCall(breakCreateBreakRequest, _callback);
        Type localVarReturnType = new TypeToken<Attendance>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateBreakRequestBuilder {
        private final Integer employeeId;
        private final String breakStart;
        private final String breakEnd;
        private String observations;

        private CreateBreakRequestBuilder(Integer employeeId, String breakStart, String breakEnd) {
            this.employeeId = employeeId;
            this.breakStart = breakStart;
            this.breakEnd = breakEnd;
        }

        /**
         * Set observations
         * @param observations  (optional)
         * @return CreateBreakRequestBuilder
         */
        public CreateBreakRequestBuilder observations(String observations) {
            this.observations = observations;
            return this;
        }
        
        /**
         * Build call for createBreak
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
            BreakCreateBreakRequest breakCreateBreakRequest = buildBodyParams();
            return createBreakCall(breakCreateBreakRequest, _callback);
        }

        private BreakCreateBreakRequest buildBodyParams() {
            BreakCreateBreakRequest breakCreateBreakRequest = new BreakCreateBreakRequest();
            breakCreateBreakRequest.employeeId(this.employeeId);
            breakCreateBreakRequest.breakStart(this.breakStart);
            breakCreateBreakRequest.breakEnd(this.breakEnd);
            breakCreateBreakRequest.observations(this.observations);
            return breakCreateBreakRequest;
        }

        /**
         * Execute createBreak request
         * @return Attendance
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Attendance execute() throws ApiException {
            BreakCreateBreakRequest breakCreateBreakRequest = buildBodyParams();
            ApiResponse<Attendance> localVarResp = createBreakWithHttpInfo(breakCreateBreakRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createBreak request with HTTP info returned
         * @return ApiResponse&lt;Attendance&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Attendance> executeWithHttpInfo() throws ApiException {
            BreakCreateBreakRequest breakCreateBreakRequest = buildBodyParams();
            return createBreakWithHttpInfo(breakCreateBreakRequest);
        }

        /**
         * Execute createBreak request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Attendance> _callback) throws ApiException {
            BreakCreateBreakRequest breakCreateBreakRequest = buildBodyParams();
            return createBreakAsync(breakCreateBreakRequest, _callback);
        }
    }

    /**
     * Create a break
     * Creates a break with the break_start and break_end time
     * @return CreateBreakRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateBreakRequestBuilder createBreak(Integer employeeId, String breakStart, String breakEnd) throws IllegalArgumentException {
        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        if (breakStart == null) throw new IllegalArgumentException("\"breakStart\" is required but got null");
            

        if (breakEnd == null) throw new IllegalArgumentException("\"breakEnd\" is required but got null");
            

        return new CreateBreakRequestBuilder(employeeId, breakStart, breakEnd);
    }
    private okhttp3.Call endBreakCall(BreakEndBreakRequest breakEndBreakRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = breakEndBreakRequest;

        // create path and map variables
        String localVarPath = "/v1/time/breaks/end";

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
    private okhttp3.Call endBreakValidateBeforeCall(BreakEndBreakRequest breakEndBreakRequest, final ApiCallback _callback) throws ApiException {
        return endBreakCall(breakEndBreakRequest, _callback);

    }


    private ApiResponse<Attendance> endBreakWithHttpInfo(BreakEndBreakRequest breakEndBreakRequest) throws ApiException {
        okhttp3.Call localVarCall = endBreakValidateBeforeCall(breakEndBreakRequest, null);
        Type localVarReturnType = new TypeToken<Attendance>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call endBreakAsync(BreakEndBreakRequest breakEndBreakRequest, final ApiCallback<Attendance> _callback) throws ApiException {

        okhttp3.Call localVarCall = endBreakValidateBeforeCall(breakEndBreakRequest, _callback);
        Type localVarReturnType = new TypeToken<Attendance>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class EndBreakRequestBuilder {
        private final String now;
        private final Integer employeeId;
        private String observations;

        private EndBreakRequestBuilder(String now, Integer employeeId) {
            this.now = now;
            this.employeeId = employeeId;
        }

        /**
         * Set observations
         * @param observations  (optional)
         * @return EndBreakRequestBuilder
         */
        public EndBreakRequestBuilder observations(String observations) {
            this.observations = observations;
            return this;
        }
        
        /**
         * Build call for endBreak
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
            BreakEndBreakRequest breakEndBreakRequest = buildBodyParams();
            return endBreakCall(breakEndBreakRequest, _callback);
        }

        private BreakEndBreakRequest buildBodyParams() {
            BreakEndBreakRequest breakEndBreakRequest = new BreakEndBreakRequest();
            breakEndBreakRequest.now(this.now);
            breakEndBreakRequest.employeeId(this.employeeId);
            breakEndBreakRequest.observations(this.observations);
            return breakEndBreakRequest;
        }

        /**
         * Execute endBreak request
         * @return Attendance
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Attendance execute() throws ApiException {
            BreakEndBreakRequest breakEndBreakRequest = buildBodyParams();
            ApiResponse<Attendance> localVarResp = endBreakWithHttpInfo(breakEndBreakRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute endBreak request with HTTP info returned
         * @return ApiResponse&lt;Attendance&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Attendance> executeWithHttpInfo() throws ApiException {
            BreakEndBreakRequest breakEndBreakRequest = buildBodyParams();
            return endBreakWithHttpInfo(breakEndBreakRequest);
        }

        /**
         * Execute endBreak request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Attendance> _callback) throws ApiException {
            BreakEndBreakRequest breakEndBreakRequest = buildBodyParams();
            return endBreakAsync(breakEndBreakRequest, _callback);
        }
    }

    /**
     * End a break
     * End a break
     * @return EndBreakRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public EndBreakRequestBuilder endBreak(String now, Integer employeeId) throws IllegalArgumentException {
        if (now == null) throw new IllegalArgumentException("\"now\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new EndBreakRequestBuilder(now, employeeId);
    }
    private okhttp3.Call startBreakCall(BreakStartBreakRequest breakStartBreakRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = breakStartBreakRequest;

        // create path and map variables
        String localVarPath = "/v1/time/breaks/start";

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
    private okhttp3.Call startBreakValidateBeforeCall(BreakStartBreakRequest breakStartBreakRequest, final ApiCallback _callback) throws ApiException {
        return startBreakCall(breakStartBreakRequest, _callback);

    }


    private ApiResponse<Attendance> startBreakWithHttpInfo(BreakStartBreakRequest breakStartBreakRequest) throws ApiException {
        okhttp3.Call localVarCall = startBreakValidateBeforeCall(breakStartBreakRequest, null);
        Type localVarReturnType = new TypeToken<Attendance>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call startBreakAsync(BreakStartBreakRequest breakStartBreakRequest, final ApiCallback<Attendance> _callback) throws ApiException {

        okhttp3.Call localVarCall = startBreakValidateBeforeCall(breakStartBreakRequest, _callback);
        Type localVarReturnType = new TypeToken<Attendance>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class StartBreakRequestBuilder {
        private final String now;
        private final Integer employeeId;
        private String observations;
        private Integer timeSettingsBreakConfigurationId;

        private StartBreakRequestBuilder(String now, Integer employeeId) {
            this.now = now;
            this.employeeId = employeeId;
        }

        /**
         * Set observations
         * @param observations  (optional)
         * @return StartBreakRequestBuilder
         */
        public StartBreakRequestBuilder observations(String observations) {
            this.observations = observations;
            return this;
        }
        
        /**
         * Set timeSettingsBreakConfigurationId
         * @param timeSettingsBreakConfigurationId  (optional)
         * @return StartBreakRequestBuilder
         */
        public StartBreakRequestBuilder timeSettingsBreakConfigurationId(Integer timeSettingsBreakConfigurationId) {
            this.timeSettingsBreakConfigurationId = timeSettingsBreakConfigurationId;
            return this;
        }
        
        /**
         * Build call for startBreak
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
            BreakStartBreakRequest breakStartBreakRequest = buildBodyParams();
            return startBreakCall(breakStartBreakRequest, _callback);
        }

        private BreakStartBreakRequest buildBodyParams() {
            BreakStartBreakRequest breakStartBreakRequest = new BreakStartBreakRequest();
            breakStartBreakRequest.now(this.now);
            breakStartBreakRequest.employeeId(this.employeeId);
            breakStartBreakRequest.observations(this.observations);
            breakStartBreakRequest.timeSettingsBreakConfigurationId(this.timeSettingsBreakConfigurationId);
            return breakStartBreakRequest;
        }

        /**
         * Execute startBreak request
         * @return Attendance
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Attendance execute() throws ApiException {
            BreakStartBreakRequest breakStartBreakRequest = buildBodyParams();
            ApiResponse<Attendance> localVarResp = startBreakWithHttpInfo(breakStartBreakRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute startBreak request with HTTP info returned
         * @return ApiResponse&lt;Attendance&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Attendance> executeWithHttpInfo() throws ApiException {
            BreakStartBreakRequest breakStartBreakRequest = buildBodyParams();
            return startBreakWithHttpInfo(breakStartBreakRequest);
        }

        /**
         * Execute startBreak request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Attendance> _callback) throws ApiException {
            BreakStartBreakRequest breakStartBreakRequest = buildBodyParams();
            return startBreakAsync(breakStartBreakRequest, _callback);
        }
    }

    /**
     * Start a break
     * Start a break
     * @return StartBreakRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public StartBreakRequestBuilder startBreak(String now, Integer employeeId) throws IllegalArgumentException {
        if (now == null) throw new IllegalArgumentException("\"now\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new StartBreakRequestBuilder(now, employeeId);
    }
}
