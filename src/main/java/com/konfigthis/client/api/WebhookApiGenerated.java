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


import com.konfigthis.client.model.Webhook;
import com.konfigthis.client.model.WebhookCreateSubscriptionRequest;
import com.konfigthis.client.model.WebhookSubscriptionCreateRequest;
import com.konfigthis.client.model.WebhookUpdateWebhookByIdRequest;
import com.konfigthis.client.model.WebhookV2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class WebhookApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public WebhookApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public WebhookApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createSubscriptionCall(WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = webhookCreateSubscriptionRequest;

        // create path and map variables
        String localVarPath = "/v1/core/webhooks";

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
    private okhttp3.Call createSubscriptionValidateBeforeCall(WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest, final ApiCallback _callback) throws ApiException {
        return createSubscriptionCall(webhookCreateSubscriptionRequest, _callback);

    }


    private ApiResponse<List<Webhook>> createSubscriptionWithHttpInfo(WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest) throws ApiException {
        okhttp3.Call localVarCall = createSubscriptionValidateBeforeCall(webhookCreateSubscriptionRequest, null);
        Type localVarReturnType = new TypeToken<List<Webhook>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createSubscriptionAsync(WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest, final ApiCallback<List<Webhook>> _callback) throws ApiException {

        okhttp3.Call localVarCall = createSubscriptionValidateBeforeCall(webhookCreateSubscriptionRequest, _callback);
        Type localVarReturnType = new TypeToken<List<Webhook>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateSubscriptionRequestBuilder {
        private final String type;
        private final String targetUrl;

        private CreateSubscriptionRequestBuilder(String type, String targetUrl) {
            this.type = type;
            this.targetUrl = targetUrl;
        }

        /**
         * Build call for createSubscription
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
            WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest = buildBodyParams();
            return createSubscriptionCall(webhookCreateSubscriptionRequest, _callback);
        }

        private WebhookCreateSubscriptionRequest buildBodyParams() {
            WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest = new WebhookCreateSubscriptionRequest();
            webhookCreateSubscriptionRequest.type(this.type);
            webhookCreateSubscriptionRequest.targetUrl(this.targetUrl);
            return webhookCreateSubscriptionRequest;
        }

        /**
         * Execute createSubscription request
         * @return List&lt;Webhook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Webhook> execute() throws ApiException {
            WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest = buildBodyParams();
            ApiResponse<List<Webhook>> localVarResp = createSubscriptionWithHttpInfo(webhookCreateSubscriptionRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createSubscription request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Webhook&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Webhook>> executeWithHttpInfo() throws ApiException {
            WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest = buildBodyParams();
            return createSubscriptionWithHttpInfo(webhookCreateSubscriptionRequest);
        }

        /**
         * Execute createSubscription request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Webhook>> _callback) throws ApiException {
            WebhookCreateSubscriptionRequest webhookCreateSubscriptionRequest = buildBodyParams();
            return createSubscriptionAsync(webhookCreateSubscriptionRequest, _callback);
        }
    }

    /**
     * Create a webhook
     * &gt; Creates a subscription for a determined webhook type. If webhook already exists, it just changes the target_url.   ## Webhooks Types  | **Type** | **Information** | | --- | --- | | employee_invited | When creating a new employee, optionally you can send an invitation to create an account in Factorial. If you send an invitation, this event gets triggered. | | employee_created | When creating a new employee, after submitting the form, this event gets triggered. | | employee_updated| When updating personal protected employee information such has birthday, this event gets triggered. | | employee_terminated | When terminating an employee, after submitting the form, this event gets triggered | | employee_unterminated | When un terminating an employee, after submitting the form, this event gets triggered | | attendance_clockin | When the user clocks in and starts the timer, this event is triggered. | | attendance_clockout | When the user clocks out and stops the timer, this event is triggered | | attendance_shift_created | When the user creates a shift, this event is triggered | | attendance_shift_updated | When the user edits a shift, this event is triggered | | attendance_shift_deleted | When the user deletes a shift, this event is triggered | | ats_application_created | When a candidate applies for a posting. | | ats_application_updated | When a candidates application for a posting suffers changes. | | ats_job_posting_created | When a job posting is created. | | ats_job_posting_updated | When a job posting is updated. | | ats_job_posting_deleted | When a job posting is deleted. | | timeoff_leave_created | When a Timeoff Leave is created. | | timeoff_leave_destroyed | When a Timeoff Leave is destroyed. | | timeoff_leave_updated | When a Timeoff Leave suffers any changes. | | timeoff_leave_approved | When a Timeoff Leave is explicitly approved. | | timeoff_leave_rejected | When a Timeoff Leave is rejected. | | shift_management_shift_destroyed | When a single Shift Management Shift is destroyed. | | shift_management_shift_bulk_destroyed | When Shift Management Shifts are destroyed in bulk. | | document_created | When a document is created. | | task_created | When a task is created. | | contract_version_created | When a contract version is created. |
     * @return CreateSubscriptionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CreateSubscriptionRequestBuilder createSubscription(String type, String targetUrl) throws IllegalArgumentException {
        if (type == null) throw new IllegalArgumentException("\"type\" is required but got null");
            

        if (targetUrl == null) throw new IllegalArgumentException("\"targetUrl\" is required but got null");
            

        return new CreateSubscriptionRequestBuilder(type, targetUrl);
    }
    private okhttp3.Call deleteWebhookCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/core/webhooks/{id}"
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
    private okhttp3.Call deleteWebhookValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteWebhook(Async)");
        }

        return deleteWebhookCall(id, _callback);

    }


    private ApiResponse<WebhookV2> deleteWebhookWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteWebhookValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<WebhookV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteWebhookAsync(String id, final ApiCallback<WebhookV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteWebhookValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<WebhookV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteWebhookRequestBuilder {
        private final String id;

        private DeleteWebhookRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for deleteWebhook
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
            return deleteWebhookCall(id, _callback);
        }


        /**
         * Execute deleteWebhook request
         * @return WebhookV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public WebhookV2 execute() throws ApiException {
            ApiResponse<WebhookV2> localVarResp = deleteWebhookWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteWebhook request with HTTP info returned
         * @return ApiResponse&lt;WebhookV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhookV2> executeWithHttpInfo() throws ApiException {
            return deleteWebhookWithHttpInfo(id);
        }

        /**
         * Execute deleteWebhook request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<WebhookV2> _callback) throws ApiException {
            return deleteWebhookAsync(id, _callback);
        }
    }

    /**
     * Delete a Webhook
     * Delete a Webook
     * @param id (Required) (required)
     * @return DeleteWebhookRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteWebhookRequestBuilder deleteWebhook(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteWebhookRequestBuilder(id);
    }
    private okhttp3.Call deleteWebhookByIdCall(Integer id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/core/webhooks/{id}"
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
    private okhttp3.Call deleteWebhookByIdValidateBeforeCall(Integer id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteWebhookById(Async)");
        }

        return deleteWebhookByIdCall(id, _callback);

    }


    private ApiResponse<List<Webhook>> deleteWebhookByIdWithHttpInfo(Integer id) throws ApiException {
        okhttp3.Call localVarCall = deleteWebhookByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<List<Webhook>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteWebhookByIdAsync(Integer id, final ApiCallback<List<Webhook>> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteWebhookByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<List<Webhook>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteWebhookByIdRequestBuilder {
        private final Integer id;

        private DeleteWebhookByIdRequestBuilder(Integer id) {
            this.id = id;
        }

        /**
         * Build call for deleteWebhookById
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
            return deleteWebhookByIdCall(id, _callback);
        }


        /**
         * Execute deleteWebhookById request
         * @return List&lt;Webhook&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Webhook> execute() throws ApiException {
            ApiResponse<List<Webhook>> localVarResp = deleteWebhookByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteWebhookById request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Webhook&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Webhook>> executeWithHttpInfo() throws ApiException {
            return deleteWebhookByIdWithHttpInfo(id);
        }

        /**
         * Execute deleteWebhookById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Webhook>> _callback) throws ApiException {
            return deleteWebhookByIdAsync(id, _callback);
        }
    }

    /**
     * Delete a Webhook
     * Delete a Webhook
     * @param id (Required) (required)
     * @return DeleteWebhookByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteWebhookByIdRequestBuilder deleteWebhookById(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new DeleteWebhookByIdRequestBuilder(id);
    }
    private okhttp3.Call subscriptionCreateCall(WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = webhookSubscriptionCreateRequest;

        // create path and map variables
        String localVarPath = "/v2/core/webhooks";

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
    private okhttp3.Call subscriptionCreateValidateBeforeCall(WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest, final ApiCallback _callback) throws ApiException {
        return subscriptionCreateCall(webhookSubscriptionCreateRequest, _callback);

    }


    private ApiResponse<List<WebhookV2>> subscriptionCreateWithHttpInfo(WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest) throws ApiException {
        okhttp3.Call localVarCall = subscriptionCreateValidateBeforeCall(webhookSubscriptionCreateRequest, null);
        Type localVarReturnType = new TypeToken<List<WebhookV2>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call subscriptionCreateAsync(WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest, final ApiCallback<List<WebhookV2>> _callback) throws ApiException {

        okhttp3.Call localVarCall = subscriptionCreateValidateBeforeCall(webhookSubscriptionCreateRequest, _callback);
        Type localVarReturnType = new TypeToken<List<WebhookV2>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class SubscriptionCreateRequestBuilder {
        private final String subscriptionType;
        private final String targetUrl;
        private String name;
        private String challenge;

        private SubscriptionCreateRequestBuilder(String subscriptionType, String targetUrl) {
            this.subscriptionType = subscriptionType;
            this.targetUrl = targetUrl;
        }

        /**
         * Set name
         * @param name  (optional)
         * @return SubscriptionCreateRequestBuilder
         */
        public SubscriptionCreateRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Set challenge
         * @param challenge  (optional)
         * @return SubscriptionCreateRequestBuilder
         */
        public SubscriptionCreateRequestBuilder challenge(String challenge) {
            this.challenge = challenge;
            return this;
        }
        
        /**
         * Build call for subscriptionCreate
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
            WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest = buildBodyParams();
            return subscriptionCreateCall(webhookSubscriptionCreateRequest, _callback);
        }

        private WebhookSubscriptionCreateRequest buildBodyParams() {
            WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest = new WebhookSubscriptionCreateRequest();
            webhookSubscriptionCreateRequest.subscriptionType(this.subscriptionType);
            webhookSubscriptionCreateRequest.targetUrl(this.targetUrl);
            webhookSubscriptionCreateRequest.name(this.name);
            webhookSubscriptionCreateRequest.challenge(this.challenge);
            return webhookSubscriptionCreateRequest;
        }

        /**
         * Execute subscriptionCreate request
         * @return List&lt;WebhookV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<WebhookV2> execute() throws ApiException {
            WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest = buildBodyParams();
            ApiResponse<List<WebhookV2>> localVarResp = subscriptionCreateWithHttpInfo(webhookSubscriptionCreateRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute subscriptionCreate request with HTTP info returned
         * @return ApiResponse&lt;List&lt;WebhookV2&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<WebhookV2>> executeWithHttpInfo() throws ApiException {
            WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest = buildBodyParams();
            return subscriptionCreateWithHttpInfo(webhookSubscriptionCreateRequest);
        }

        /**
         * Execute subscriptionCreate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<WebhookV2>> _callback) throws ApiException {
            WebhookSubscriptionCreateRequest webhookSubscriptionCreateRequest = buildBodyParams();
            return subscriptionCreateAsync(webhookSubscriptionCreateRequest, _callback);
        }
    }

    /**
     * Create a webhook
     * &gt; Creates a subscription for a determined webhook type. If webhook already exists, it just changes the target_url.   ## Webhooks Types  | **Subscription Type** | **Information** | | --- | --- | | Authentication::Events::AccessInvited | When creating a new employee, optionally you can send an invitation to create an account in Factorial. If you send an invitation, this event gets triggered. | | Employees::Events::EmployeeCreated | When creating a new employee, after submitting the form, this event gets triggered. | | Employees::Events::EmployeeUpdated| When updating personal protected employee information such has birthday, this event gets triggered. | | Employees::Events::EmployeeTerminated | When terminating an employee, after submitting the form, this event gets triggered | | Employees::Events::EmployeeUnterminated | When un terminating an employee, after submitting the form, this event gets triggered | | Attendance::Events::ClockIn | When the user clocks in and starts the timer, this event is triggered. | | Attendance::Events::ClockOut | When the user clocks out and stops the timer, this event is triggered | | Attendance::Events::AttendanceShiftCreated | When the user creates a shift, this event is triggered | | Attendance::Events::AttendanceShiftUpdated | When the user edits a shift, this event is triggered | | Attendance::Events::AttendanceShiftDeleted | When the user deletes a shift, this event is triggered | | Ats::Events::ApplicationCreated | When a candidate applies for a posting. | | Ats::Events::ApplicationUpdated | When a candidates application for a posting suffers changes. | | Ats::Events::JobPostingCreated | When a job posting is created. | | Ats::Events::JobPostingUpdated | When a job posting is updated. | | Ats::Events::JobPostingDeleted | When a job posting is deleted. | | Timeoff::Events::LeaveCreated | When a Timeoff Leave is created. | | Timeoff::Events::LeaveDestroyed | When a Timeoff Leave is destroyed. | | Timeoff::Events::LeaveUpdated | When a Timeoff Leave suffers any changes. | | Timeoff::Events::LeaveApproved | When a Timeoff Leave is explicitly approved. | | Timeoff::Events::LeaveRejected | When a Timeoff Leave is rejected. | | Documents::Events::Created | When a document is created. | | Tasks::Events::Created | When a task is created. | | Contracts::Events::ContractVersionCreated | When a contract version is created. | | Payroll::Events::SupplementCreated | When a payroll supplement is created. | | Payroll::Events::SupplementUpdated | When a payroll supplement is updated. | | Payroll::Events::SupplementDeleted | When a payroll supplement is deleted. |
     * @return SubscriptionCreateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public SubscriptionCreateRequestBuilder subscriptionCreate(String subscriptionType, String targetUrl) throws IllegalArgumentException {
        if (subscriptionType == null) throw new IllegalArgumentException("\"subscriptionType\" is required but got null");
            

        if (targetUrl == null) throw new IllegalArgumentException("\"targetUrl\" is required but got null");
            

        return new SubscriptionCreateRequestBuilder(subscriptionType, targetUrl);
    }
    private okhttp3.Call updateWebhookByIdCall(String id, WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = webhookUpdateWebhookByIdRequest;

        // create path and map variables
        String localVarPath = "/v2/core/webhooks/{id}"
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
    private okhttp3.Call updateWebhookByIdValidateBeforeCall(String id, WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateWebhookById(Async)");
        }

        return updateWebhookByIdCall(id, webhookUpdateWebhookByIdRequest, _callback);

    }


    private ApiResponse<WebhookV2> updateWebhookByIdWithHttpInfo(String id, WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateWebhookByIdValidateBeforeCall(id, webhookUpdateWebhookByIdRequest, null);
        Type localVarReturnType = new TypeToken<WebhookV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateWebhookByIdAsync(String id, WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest, final ApiCallback<WebhookV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateWebhookByIdValidateBeforeCall(id, webhookUpdateWebhookByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<WebhookV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateWebhookByIdRequestBuilder {
        private final String id;
        private String targetUrl;
        private String name;
        private String challenge;

        private UpdateWebhookByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set targetUrl
         * @param targetUrl  (optional)
         * @return UpdateWebhookByIdRequestBuilder
         */
        public UpdateWebhookByIdRequestBuilder targetUrl(String targetUrl) {
            this.targetUrl = targetUrl;
            return this;
        }
        
        /**
         * Set name
         * @param name  (optional)
         * @return UpdateWebhookByIdRequestBuilder
         */
        public UpdateWebhookByIdRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Set challenge
         * @param challenge  (optional)
         * @return UpdateWebhookByIdRequestBuilder
         */
        public UpdateWebhookByIdRequestBuilder challenge(String challenge) {
            this.challenge = challenge;
            return this;
        }
        
        /**
         * Build call for updateWebhookById
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
            WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest = buildBodyParams();
            return updateWebhookByIdCall(id, webhookUpdateWebhookByIdRequest, _callback);
        }

        private WebhookUpdateWebhookByIdRequest buildBodyParams() {
            WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest = new WebhookUpdateWebhookByIdRequest();
            webhookUpdateWebhookByIdRequest.targetUrl(this.targetUrl);
            webhookUpdateWebhookByIdRequest.name(this.name);
            webhookUpdateWebhookByIdRequest.challenge(this.challenge);
            return webhookUpdateWebhookByIdRequest;
        }

        /**
         * Execute updateWebhookById request
         * @return WebhookV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public WebhookV2 execute() throws ApiException {
            WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest = buildBodyParams();
            ApiResponse<WebhookV2> localVarResp = updateWebhookByIdWithHttpInfo(id, webhookUpdateWebhookByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateWebhookById request with HTTP info returned
         * @return ApiResponse&lt;WebhookV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<WebhookV2> executeWithHttpInfo() throws ApiException {
            WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest = buildBodyParams();
            return updateWebhookByIdWithHttpInfo(id, webhookUpdateWebhookByIdRequest);
        }

        /**
         * Execute updateWebhookById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<WebhookV2> _callback) throws ApiException {
            WebhookUpdateWebhookByIdRequest webhookUpdateWebhookByIdRequest = buildBodyParams();
            return updateWebhookByIdAsync(id, webhookUpdateWebhookByIdRequest, _callback);
        }
    }

    /**
     * Update a Webhook
     * Update a Webook
     * @param id (Required) (required)
     * @return UpdateWebhookByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateWebhookByIdRequestBuilder updateWebhookById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateWebhookByIdRequestBuilder(id);
    }
}
