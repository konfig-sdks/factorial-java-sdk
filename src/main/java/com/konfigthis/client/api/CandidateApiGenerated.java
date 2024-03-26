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


import com.konfigthis.client.model.AtsCandidate;
import com.konfigthis.client.model.CandidateCreateNewCandidateRequest;
import com.konfigthis.client.model.CandidateUpdateCandidateDataRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class CandidateApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public CandidateApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public CandidateApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createNewCandidateCall(CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = candidateCreateNewCandidateRequest;

        // create path and map variables
        String localVarPath = "/v1/ats/candidates";

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
    private okhttp3.Call createNewCandidateValidateBeforeCall(CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest, final ApiCallback _callback) throws ApiException {
        return createNewCandidateCall(candidateCreateNewCandidateRequest, _callback);

    }


    private ApiResponse<AtsCandidate> createNewCandidateWithHttpInfo(CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewCandidateValidateBeforeCall(candidateCreateNewCandidateRequest, null);
        Type localVarReturnType = new TypeToken<AtsCandidate>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewCandidateAsync(CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest, final ApiCallback<AtsCandidate> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewCandidateValidateBeforeCall(candidateCreateNewCandidateRequest, _callback);
        Type localVarReturnType = new TypeToken<AtsCandidate>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewCandidateRequestBuilder {
        private final String firstName;
        private final String lastName;
        private final String email;
        private String source;
        private String medium;

        private CreateNewCandidateRequestBuilder(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        /**
         * Set source
         * @param source  (optional)
         * @return CreateNewCandidateRequestBuilder
         */
        public CreateNewCandidateRequestBuilder source(String source) {
            this.source = source;
            return this;
        }
        
        /**
         * Set medium
         * @param medium  (optional)
         * @return CreateNewCandidateRequestBuilder
         */
        public CreateNewCandidateRequestBuilder medium(String medium) {
            this.medium = medium;
            return this;
        }
        
        /**
         * Build call for createNewCandidate
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
            CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest = buildBodyParams();
            return createNewCandidateCall(candidateCreateNewCandidateRequest, _callback);
        }

        private CandidateCreateNewCandidateRequest buildBodyParams() {
            CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest = new CandidateCreateNewCandidateRequest();
            candidateCreateNewCandidateRequest.firstName(this.firstName);
            candidateCreateNewCandidateRequest.lastName(this.lastName);
            candidateCreateNewCandidateRequest.email(this.email);
            if (this.source != null)
            candidateCreateNewCandidateRequest.source(CandidateCreateNewCandidateRequest.SourceEnum.fromValue(this.source));
            candidateCreateNewCandidateRequest.medium(this.medium);
            return candidateCreateNewCandidateRequest;
        }

        /**
         * Execute createNewCandidate request
         * @return AtsCandidate
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public AtsCandidate execute() throws ApiException {
            CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest = buildBodyParams();
            ApiResponse<AtsCandidate> localVarResp = createNewCandidateWithHttpInfo(candidateCreateNewCandidateRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewCandidate request with HTTP info returned
         * @return ApiResponse&lt;AtsCandidate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsCandidate> executeWithHttpInfo() throws ApiException {
            CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest = buildBodyParams();
            return createNewCandidateWithHttpInfo(candidateCreateNewCandidateRequest);
        }

        /**
         * Execute createNewCandidate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsCandidate> _callback) throws ApiException {
            CandidateCreateNewCandidateRequest candidateCreateNewCandidateRequest = buildBodyParams();
            return createNewCandidateAsync(candidateCreateNewCandidateRequest, _callback);
        }
    }

    /**
     * Create a candidate
     * Create candidates related to a particular company in an ATS
     * @return CreateNewCandidateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewCandidateRequestBuilder createNewCandidate(String firstName, String lastName, String email) throws IllegalArgumentException {
        if (firstName == null) throw new IllegalArgumentException("\"firstName\" is required but got null");
            

        if (lastName == null) throw new IllegalArgumentException("\"lastName\" is required but got null");
            

        if (email == null) throw new IllegalArgumentException("\"email\" is required but got null");
            

        return new CreateNewCandidateRequestBuilder(firstName, lastName, email);
    }
    private okhttp3.Call deleteExistingCandidateCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/ats/candidates/{id}"
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
    private okhttp3.Call deleteExistingCandidateValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteExistingCandidate(Async)");
        }

        return deleteExistingCandidateCall(id, _callback);

    }


    private ApiResponse<AtsCandidate> deleteExistingCandidateWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteExistingCandidateValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<AtsCandidate>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteExistingCandidateAsync(String id, final ApiCallback<AtsCandidate> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteExistingCandidateValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<AtsCandidate>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteExistingCandidateRequestBuilder {
        private final String id;

        private DeleteExistingCandidateRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for deleteExistingCandidate
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
            return deleteExistingCandidateCall(id, _callback);
        }


        /**
         * Execute deleteExistingCandidate request
         * @return AtsCandidate
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public AtsCandidate execute() throws ApiException {
            ApiResponse<AtsCandidate> localVarResp = deleteExistingCandidateWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteExistingCandidate request with HTTP info returned
         * @return ApiResponse&lt;AtsCandidate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsCandidate> executeWithHttpInfo() throws ApiException {
            return deleteExistingCandidateWithHttpInfo(id);
        }

        /**
         * Execute deleteExistingCandidate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsCandidate> _callback) throws ApiException {
            return deleteExistingCandidateAsync(id, _callback);
        }
    }

    /**
     * Delete a Candidate
     * Deletes an existing candidate
     * @param id (Required) (required)
     * @return DeleteExistingCandidateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteExistingCandidateRequestBuilder deleteExistingCandidate(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteExistingCandidateRequestBuilder(id);
    }
    private okhttp3.Call listAllCandidatesCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/ats/candidates";

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
    private okhttp3.Call listAllCandidatesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return listAllCandidatesCall(_callback);

    }


    private ApiResponse<List<AtsCandidate>> listAllCandidatesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listAllCandidatesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<AtsCandidate>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listAllCandidatesAsync(final ApiCallback<List<AtsCandidate>> _callback) throws ApiException {

        okhttp3.Call localVarCall = listAllCandidatesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<AtsCandidate>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListAllCandidatesRequestBuilder {

        private ListAllCandidatesRequestBuilder() {
        }

        /**
         * Build call for listAllCandidates
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
            return listAllCandidatesCall(_callback);
        }


        /**
         * Execute listAllCandidates request
         * @return List&lt;AtsCandidate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<AtsCandidate> execute() throws ApiException {
            ApiResponse<List<AtsCandidate>> localVarResp = listAllCandidatesWithHttpInfo();
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listAllCandidates request with HTTP info returned
         * @return ApiResponse&lt;List&lt;AtsCandidate&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<AtsCandidate>> executeWithHttpInfo() throws ApiException {
            return listAllCandidatesWithHttpInfo();
        }

        /**
         * Execute listAllCandidates request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<AtsCandidate>> _callback) throws ApiException {
            return listAllCandidatesAsync(_callback);
        }
    }

    /**
     * Get all candidates
     * Fetch candidates data from Factorial. When using administrator-level API Credentials, all candidates associated with a company will be returned. When using non-admin level API credentials, only candidates that applied to a job for which the user is a hiring manager will be returned.
     * @return ListAllCandidatesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ListAllCandidatesRequestBuilder listAllCandidates() throws IllegalArgumentException {
        return new ListAllCandidatesRequestBuilder();
    }
    private okhttp3.Call updateCandidateDataCall(String id, CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = candidateUpdateCandidateDataRequest;

        // create path and map variables
        String localVarPath = "/v1/ats/candidates/{id}"
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
    private okhttp3.Call updateCandidateDataValidateBeforeCall(String id, CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateCandidateData(Async)");
        }

        return updateCandidateDataCall(id, candidateUpdateCandidateDataRequest, _callback);

    }


    private ApiResponse<AtsCandidate> updateCandidateDataWithHttpInfo(String id, CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest) throws ApiException {
        okhttp3.Call localVarCall = updateCandidateDataValidateBeforeCall(id, candidateUpdateCandidateDataRequest, null);
        Type localVarReturnType = new TypeToken<AtsCandidate>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateCandidateDataAsync(String id, CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest, final ApiCallback<AtsCandidate> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateCandidateDataValidateBeforeCall(id, candidateUpdateCandidateDataRequest, _callback);
        Type localVarReturnType = new TypeToken<AtsCandidate>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateCandidateDataRequestBuilder {
        private final String id;
        private String firstName;
        private String lastName;
        private String email;
        private Boolean talentPool;
        private Boolean consentToTalentPool;

        private UpdateCandidateDataRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set firstName
         * @param firstName  (optional)
         * @return UpdateCandidateDataRequestBuilder
         */
        public UpdateCandidateDataRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        /**
         * Set lastName
         * @param lastName  (optional)
         * @return UpdateCandidateDataRequestBuilder
         */
        public UpdateCandidateDataRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        /**
         * Set email
         * @param email  (optional)
         * @return UpdateCandidateDataRequestBuilder
         */
        public UpdateCandidateDataRequestBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        /**
         * Set talentPool
         * @param talentPool  (optional)
         * @return UpdateCandidateDataRequestBuilder
         */
        public UpdateCandidateDataRequestBuilder talentPool(Boolean talentPool) {
            this.talentPool = talentPool;
            return this;
        }
        
        /**
         * Set consentToTalentPool
         * @param consentToTalentPool  (optional)
         * @return UpdateCandidateDataRequestBuilder
         */
        public UpdateCandidateDataRequestBuilder consentToTalentPool(Boolean consentToTalentPool) {
            this.consentToTalentPool = consentToTalentPool;
            return this;
        }
        
        /**
         * Build call for updateCandidateData
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
            CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest = buildBodyParams();
            return updateCandidateDataCall(id, candidateUpdateCandidateDataRequest, _callback);
        }

        private CandidateUpdateCandidateDataRequest buildBodyParams() {
            CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest = new CandidateUpdateCandidateDataRequest();
            candidateUpdateCandidateDataRequest.firstName(this.firstName);
            candidateUpdateCandidateDataRequest.lastName(this.lastName);
            candidateUpdateCandidateDataRequest.email(this.email);
            candidateUpdateCandidateDataRequest.talentPool(this.talentPool);
            candidateUpdateCandidateDataRequest.consentToTalentPool(this.consentToTalentPool);
            return candidateUpdateCandidateDataRequest;
        }

        /**
         * Execute updateCandidateData request
         * @return AtsCandidate
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public AtsCandidate execute() throws ApiException {
            CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest = buildBodyParams();
            ApiResponse<AtsCandidate> localVarResp = updateCandidateDataWithHttpInfo(id, candidateUpdateCandidateDataRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateCandidateData request with HTTP info returned
         * @return ApiResponse&lt;AtsCandidate&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsCandidate> executeWithHttpInfo() throws ApiException {
            CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest = buildBodyParams();
            return updateCandidateDataWithHttpInfo(id, candidateUpdateCandidateDataRequest);
        }

        /**
         * Execute updateCandidateData request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsCandidate> _callback) throws ApiException {
            CandidateUpdateCandidateDataRequest candidateUpdateCandidateDataRequest = buildBodyParams();
            return updateCandidateDataAsync(id, candidateUpdateCandidateDataRequest, _callback);
        }
    }

    /**
     * Update candidate
     * Update ATS Candidates data
     * @param id (Required) (required)
     * @return UpdateCandidateDataRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateCandidateDataRequestBuilder updateCandidateData(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateCandidateDataRequestBuilder(id);
    }
}
