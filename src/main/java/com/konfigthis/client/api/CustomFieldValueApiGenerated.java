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


import com.konfigthis.client.model.CustomFieldV2;
import com.konfigthis.client.model.CustomFieldValueCreateCustomValueRequest;
import com.konfigthis.client.model.CustomFieldValueUpdateValueRequest;
import com.konfigthis.client.model.CustomValue;
import com.konfigthis.client.model.CustomValueV2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class CustomFieldValueApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public CustomFieldValueApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public CustomFieldValueApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createCustomValueCall(Integer fieldId, Integer instanceId, CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = customFieldValueCreateCustomValueRequest;

        // create path and map variables
        String localVarPath = "/v1/custom_fields/values";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (fieldId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("field_id", fieldId));
        }

        if (instanceId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("instance_id", instanceId));
        }

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
    private okhttp3.Call createCustomValueValidateBeforeCall(Integer fieldId, Integer instanceId, CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new ApiException("Missing the required parameter 'fieldId' when calling createCustomValue(Async)");
        }

        // verify the required parameter 'instanceId' is set
        if (instanceId == null) {
            throw new ApiException("Missing the required parameter 'instanceId' when calling createCustomValue(Async)");
        }

        return createCustomValueCall(fieldId, instanceId, customFieldValueCreateCustomValueRequest, _callback);

    }


    private ApiResponse<CustomValue> createCustomValueWithHttpInfo(Integer fieldId, Integer instanceId, CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest) throws ApiException {
        okhttp3.Call localVarCall = createCustomValueValidateBeforeCall(fieldId, instanceId, customFieldValueCreateCustomValueRequest, null);
        Type localVarReturnType = new TypeToken<CustomValue>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createCustomValueAsync(Integer fieldId, Integer instanceId, CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest, final ApiCallback<CustomValue> _callback) throws ApiException {

        okhttp3.Call localVarCall = createCustomValueValidateBeforeCall(fieldId, instanceId, customFieldValueCreateCustomValueRequest, _callback);
        Type localVarReturnType = new TypeToken<CustomValue>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateCustomValueRequestBuilder {
        private final String value;
        private final Integer fieldId;
        private final Integer instanceId;

        private CreateCustomValueRequestBuilder(String value, Integer fieldId, Integer instanceId) {
            this.value = value;
            this.fieldId = fieldId;
            this.instanceId = instanceId;
        }

        /**
         * Build call for createCustomValue
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
            CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest = buildBodyParams();
            return createCustomValueCall(fieldId, instanceId, customFieldValueCreateCustomValueRequest, _callback);
        }

        private CustomFieldValueCreateCustomValueRequest buildBodyParams() {
            CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest = new CustomFieldValueCreateCustomValueRequest();
            customFieldValueCreateCustomValueRequest.value(this.value);
            return customFieldValueCreateCustomValueRequest;
        }

        /**
         * Execute createCustomValue request
         * @return CustomValue
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public CustomValue execute() throws ApiException {
            CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest = buildBodyParams();
            ApiResponse<CustomValue> localVarResp = createCustomValueWithHttpInfo(fieldId, instanceId, customFieldValueCreateCustomValueRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createCustomValue request with HTTP info returned
         * @return ApiResponse&lt;CustomValue&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<CustomValue> executeWithHttpInfo() throws ApiException {
            CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest = buildBodyParams();
            return createCustomValueWithHttpInfo(fieldId, instanceId, customFieldValueCreateCustomValueRequest);
        }

        /**
         * Execute createCustomValue request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<CustomValue> _callback) throws ApiException {
            CustomFieldValueCreateCustomValueRequest customFieldValueCreateCustomValueRequest = buildBodyParams();
            return createCustomValueAsync(fieldId, instanceId, customFieldValueCreateCustomValueRequest, _callback);
        }
    }

    /**
     * Create a value for a custom field
     * As described, a &#x60;Custom Field Value&#x60; can be thought of as an answer/response to a &#x60;Custom Field&#x60; these answers/responses belong to the entity that inputed the values e.g. an employee who answered the t-shirt size question by filling it out in their factorial dashboard. This endpoint allows you to create values for custom fields. It requires an &#x60;instance_id&#x60; which refers to the &#x60;id&#x60; of the entity that owns this &#x60;Custom Value&#x60; e.g. an Employee for which the &#x60;employee_id&#x60; will correspond to the &#x60;instance_id&#x60;. It also requires a &#x60;field_id&#x60; to reference the &#x60;Custom Field&#x60; which this value is related to. You can think of &#x60;Custom Fields&#x60; and &#x60;Custom Values&#x60; as questions and answers.
     * @param fieldId  (required)
     * @param instanceId  (required)
     * @return CreateCustomValueRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CreateCustomValueRequestBuilder createCustomValue(String value, Integer fieldId, Integer instanceId) throws IllegalArgumentException {
        if (value == null) throw new IllegalArgumentException("\"value\" is required but got null");
            

        if (fieldId == null) throw new IllegalArgumentException("\"fieldId\" is required but got null");
        if (instanceId == null) throw new IllegalArgumentException("\"instanceId\" is required but got null");
        return new CreateCustomValueRequestBuilder(value, fieldId, instanceId);
    }
    private okhttp3.Call getBySlugNameCall(Integer id, Integer slugId, Integer fieldId, String slugName, String fieldValue, List<Integer> employeeIds, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/custom_fields/values";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (id != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("id", id));
        }

        if (slugId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("slug_id", slugId));
        }

        if (fieldId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("field_id", fieldId));
        }

        if (slugName != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("slug_name", slugName));
        }

        if (fieldValue != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("field_value", fieldValue));
        }

        if (employeeIds != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "employee_ids[]", employeeIds));
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
    private okhttp3.Call getBySlugNameValidateBeforeCall(Integer id, Integer slugId, Integer fieldId, String slugName, String fieldValue, List<Integer> employeeIds, final ApiCallback _callback) throws ApiException {
        return getBySlugNameCall(id, slugId, fieldId, slugName, fieldValue, employeeIds, _callback);

    }


    private ApiResponse<List<CustomValueV2>> getBySlugNameWithHttpInfo(Integer id, Integer slugId, Integer fieldId, String slugName, String fieldValue, List<Integer> employeeIds) throws ApiException {
        okhttp3.Call localVarCall = getBySlugNameValidateBeforeCall(id, slugId, fieldId, slugName, fieldValue, employeeIds, null);
        Type localVarReturnType = new TypeToken<List<CustomValueV2>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getBySlugNameAsync(Integer id, Integer slugId, Integer fieldId, String slugName, String fieldValue, List<Integer> employeeIds, final ApiCallback<List<CustomValueV2>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBySlugNameValidateBeforeCall(id, slugId, fieldId, slugName, fieldValue, employeeIds, _callback);
        Type localVarReturnType = new TypeToken<List<CustomValueV2>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetBySlugNameRequestBuilder {
        private Integer id;
        private Integer slugId;
        private Integer fieldId;
        private String slugName;
        private String fieldValue;
        private List<Integer> employeeIds;

        private GetBySlugNameRequestBuilder() {
        }

        /**
         * Set id
         * @param id  (optional)
         * @return GetBySlugNameRequestBuilder
         */
        public GetBySlugNameRequestBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        
        /**
         * Set slugId
         * @param slugId  (optional)
         * @return GetBySlugNameRequestBuilder
         */
        public GetBySlugNameRequestBuilder slugId(Integer slugId) {
            this.slugId = slugId;
            return this;
        }
        
        /**
         * Set fieldId
         * @param fieldId  (optional)
         * @return GetBySlugNameRequestBuilder
         */
        public GetBySlugNameRequestBuilder fieldId(Integer fieldId) {
            this.fieldId = fieldId;
            return this;
        }
        
        /**
         * Set slugName
         * @param slugName  (optional)
         * @return GetBySlugNameRequestBuilder
         */
        public GetBySlugNameRequestBuilder slugName(String slugName) {
            this.slugName = slugName;
            return this;
        }
        
        /**
         * Set fieldValue
         * @param fieldValue  (optional)
         * @return GetBySlugNameRequestBuilder
         */
        public GetBySlugNameRequestBuilder fieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
            return this;
        }
        
        /**
         * Set employeeIds
         * @param employeeIds Employees id array (optional)
         * @return GetBySlugNameRequestBuilder
         */
        public GetBySlugNameRequestBuilder employeeIds(List<Integer> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        
        /**
         * Build call for getBySlugName
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
            return getBySlugNameCall(id, slugId, fieldId, slugName, fieldValue, employeeIds, _callback);
        }


        /**
         * Execute getBySlugName request
         * @return List&lt;CustomValueV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<CustomValueV2> execute() throws ApiException {
            ApiResponse<List<CustomValueV2>> localVarResp = getBySlugNameWithHttpInfo(id, slugId, fieldId, slugName, fieldValue, employeeIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getBySlugName request with HTTP info returned
         * @return ApiResponse&lt;List&lt;CustomValueV2&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<CustomValueV2>> executeWithHttpInfo() throws ApiException {
            return getBySlugNameWithHttpInfo(id, slugId, fieldId, slugName, fieldValue, employeeIds);
        }

        /**
         * Execute getBySlugName request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<CustomValueV2>> _callback) throws ApiException {
            return getBySlugNameAsync(id, slugId, fieldId, slugName, fieldValue, employeeIds, _callback);
        }
    }

    /**
     * Get custom field values
     * This endpoint allows you to retrieve custom fields by id, label, slug name, slug name. You receive fields tagged in the response by a slug. For now, there is one acceptable slug name:   - &#x60;employees-questions&#x60; which refers to fields relating to an employee   You can filter by:   - id: You can query a field value by its id. For example identity card value &#x60;12345678Z&#x60; identifier is 4. you can search the custom field by the id 4.  - value: You can query a field by value. For example an employee have a custom field which is \&quot;Computer\&quot; and it&#39;s value is \&quot;PC\&quot; you can search it by this value.  - slug_name: You can use the available slug &#x60;employees-questions&#x60; in the &#x60;slug_name&#x60; field to filter custom field values that belong to this slug.  - slug_id: It is the identifier of the slug_name. You can use the id of a slug to query custom fields values by its slug id instead of its slug name.  - field_id: You can use the available field id to filter custom field values that belong to this field.  - employee_ids: You can use the available employee ids to filter custom field values that belong to these employees.
     * @return GetBySlugNameRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetBySlugNameRequestBuilder getBySlugName() throws IllegalArgumentException {
        return new GetBySlugNameRequestBuilder();
    }
    private okhttp3.Call getInstanceValueCall(Integer fieldId, Integer instanceId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/custom_fields/values";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (fieldId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("field_id", fieldId));
        }

        if (instanceId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("instance_id", instanceId));
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

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getInstanceValueValidateBeforeCall(Integer fieldId, Integer instanceId, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'fieldId' is set
        if (fieldId == null) {
            throw new ApiException("Missing the required parameter 'fieldId' when calling getInstanceValue(Async)");
        }

        // verify the required parameter 'instanceId' is set
        if (instanceId == null) {
            throw new ApiException("Missing the required parameter 'instanceId' when calling getInstanceValue(Async)");
        }

        return getInstanceValueCall(fieldId, instanceId, _callback);

    }


    private ApiResponse<CustomValue> getInstanceValueWithHttpInfo(Integer fieldId, Integer instanceId) throws ApiException {
        okhttp3.Call localVarCall = getInstanceValueValidateBeforeCall(fieldId, instanceId, null);
        Type localVarReturnType = new TypeToken<CustomValue>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getInstanceValueAsync(Integer fieldId, Integer instanceId, final ApiCallback<CustomValue> _callback) throws ApiException {

        okhttp3.Call localVarCall = getInstanceValueValidateBeforeCall(fieldId, instanceId, _callback);
        Type localVarReturnType = new TypeToken<CustomValue>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetInstanceValueRequestBuilder {
        private final Integer fieldId;
        private final Integer instanceId;

        private GetInstanceValueRequestBuilder(Integer fieldId, Integer instanceId) {
            this.fieldId = fieldId;
            this.instanceId = instanceId;
        }

        /**
         * Build call for getInstanceValue
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
            return getInstanceValueCall(fieldId, instanceId, _callback);
        }


        /**
         * Execute getInstanceValue request
         * @return CustomValue
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public CustomValue execute() throws ApiException {
            ApiResponse<CustomValue> localVarResp = getInstanceValueWithHttpInfo(fieldId, instanceId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getInstanceValue request with HTTP info returned
         * @return ApiResponse&lt;CustomValue&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<CustomValue> executeWithHttpInfo() throws ApiException {
            return getInstanceValueWithHttpInfo(fieldId, instanceId);
        }

        /**
         * Execute getInstanceValue request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<CustomValue> _callback) throws ApiException {
            return getInstanceValueAsync(fieldId, instanceId, _callback);
        }
    }

    /**
     * Given a custom field, get the value for a specific instance
     * Given a custom field, get the value for a specific instance
     * @param fieldId  (required)
     * @param instanceId  (required)
     * @return GetInstanceValueRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetInstanceValueRequestBuilder getInstanceValue(Integer fieldId, Integer instanceId) throws IllegalArgumentException {
        if (fieldId == null) throw new IllegalArgumentException("\"fieldId\" is required but got null");
        if (instanceId == null) throw new IllegalArgumentException("\"instanceId\" is required but got null");
        return new GetInstanceValueRequestBuilder(fieldId, instanceId);
    }
    private okhttp3.Call updateValueCall(Integer id, CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = customFieldValueUpdateValueRequest;

        // create path and map variables
        String localVarPath = "/v2/custom_fields/values/{id}"
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
    private okhttp3.Call updateValueValidateBeforeCall(Integer id, CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateValue(Async)");
        }

        return updateValueCall(id, customFieldValueUpdateValueRequest, _callback);

    }


    private ApiResponse<CustomFieldV2> updateValueWithHttpInfo(Integer id, CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest) throws ApiException {
        okhttp3.Call localVarCall = updateValueValidateBeforeCall(id, customFieldValueUpdateValueRequest, null);
        Type localVarReturnType = new TypeToken<CustomFieldV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateValueAsync(Integer id, CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest, final ApiCallback<CustomFieldV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateValueValidateBeforeCall(id, customFieldValueUpdateValueRequest, _callback);
        Type localVarReturnType = new TypeToken<CustomFieldV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateValueRequestBuilder {
        private final Integer id;
        private String value;

        private UpdateValueRequestBuilder(Integer id) {
            this.id = id;
        }

        /**
         * Set value
         * @param value  (optional)
         * @return UpdateValueRequestBuilder
         */
        public UpdateValueRequestBuilder value(String value) {
            this.value = value;
            return this;
        }
        
        /**
         * Build call for updateValue
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
            CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest = buildBodyParams();
            return updateValueCall(id, customFieldValueUpdateValueRequest, _callback);
        }

        private CustomFieldValueUpdateValueRequest buildBodyParams() {
            CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest = new CustomFieldValueUpdateValueRequest();
            customFieldValueUpdateValueRequest.value(this.value);
            return customFieldValueUpdateValueRequest;
        }

        /**
         * Execute updateValue request
         * @return CustomFieldV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public CustomFieldV2 execute() throws ApiException {
            CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest = buildBodyParams();
            ApiResponse<CustomFieldV2> localVarResp = updateValueWithHttpInfo(id, customFieldValueUpdateValueRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateValue request with HTTP info returned
         * @return ApiResponse&lt;CustomFieldV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<CustomFieldV2> executeWithHttpInfo() throws ApiException {
            CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest = buildBodyParams();
            return updateValueWithHttpInfo(id, customFieldValueUpdateValueRequest);
        }

        /**
         * Execute updateValue request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<CustomFieldV2> _callback) throws ApiException {
            CustomFieldValueUpdateValueRequest customFieldValueUpdateValueRequest = buildBodyParams();
            return updateValueAsync(id, customFieldValueUpdateValueRequest, _callback);
        }
    }

    /**
     * Update custom field value
     * This endpoint allows you to update custom fields values
     * @param id (Required) (required)
     * @return UpdateValueRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateValueRequestBuilder updateValue(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new UpdateValueRequestBuilder(id);
    }
}
