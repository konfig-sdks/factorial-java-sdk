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


import java.io.File;
import com.konfigthis.client.model.Task;
import com.konfigthis.client.model.TaskAddFileToTaskRequest;
import com.konfigthis.client.model.TaskCopyByIdRequest;
import com.konfigthis.client.model.TaskCreateNewTaskRequest;
import com.konfigthis.client.model.TaskFile;
import com.konfigthis.client.model.TaskResolveByIdRequest;
import com.konfigthis.client.model.TaskUpdateByIdRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class TaskApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TaskApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public TaskApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call addFileToTaskCall(String id, TaskAddFileToTaskRequest taskAddFileToTaskRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = taskAddFileToTaskRequest;

        // create path and map variables
        String localVarPath = "/v1/core/tasks/{id}/files"
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
    private okhttp3.Call addFileToTaskValidateBeforeCall(String id, TaskAddFileToTaskRequest taskAddFileToTaskRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling addFileToTask(Async)");
        }

        return addFileToTaskCall(id, taskAddFileToTaskRequest, _callback);

    }


    private ApiResponse<Task> addFileToTaskWithHttpInfo(String id, TaskAddFileToTaskRequest taskAddFileToTaskRequest) throws ApiException {
        okhttp3.Call localVarCall = addFileToTaskValidateBeforeCall(id, taskAddFileToTaskRequest, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call addFileToTaskAsync(String id, TaskAddFileToTaskRequest taskAddFileToTaskRequest, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = addFileToTaskValidateBeforeCall(id, taskAddFileToTaskRequest, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class AddFileToTaskRequestBuilder {
        private final String id;
        private File _file;

        private AddFileToTaskRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set _file
         * @param _file  (optional)
         * @return AddFileToTaskRequestBuilder
         */
        public AddFileToTaskRequestBuilder _file(File _file) {
            this._file = _file;
            return this;
        }
        
        /**
         * Build call for addFileToTask
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
            TaskAddFileToTaskRequest taskAddFileToTaskRequest = buildBodyParams();
            return addFileToTaskCall(id, taskAddFileToTaskRequest, _callback);
        }

        private TaskAddFileToTaskRequest buildBodyParams() {
            TaskAddFileToTaskRequest taskAddFileToTaskRequest = new TaskAddFileToTaskRequest();
            taskAddFileToTaskRequest._file(this._file);
            return taskAddFileToTaskRequest;
        }

        /**
         * Execute addFileToTask request
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            TaskAddFileToTaskRequest taskAddFileToTaskRequest = buildBodyParams();
            ApiResponse<Task> localVarResp = addFileToTaskWithHttpInfo(id, taskAddFileToTaskRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute addFileToTask request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
            TaskAddFileToTaskRequest taskAddFileToTaskRequest = buildBodyParams();
            return addFileToTaskWithHttpInfo(id, taskAddFileToTaskRequest);
        }

        /**
         * Execute addFileToTask request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            TaskAddFileToTaskRequest taskAddFileToTaskRequest = buildBodyParams();
            return addFileToTaskAsync(id, taskAddFileToTaskRequest, _callback);
        }
    }

    /**
     * Create a File in a Task
     * Create a File in a Task
     * @param id (Required) (required)
     * @return AddFileToTaskRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public AddFileToTaskRequestBuilder addFileToTask(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new AddFileToTaskRequestBuilder(id);
    }
    private okhttp3.Call copyByIdCall(String id, TaskCopyByIdRequest taskCopyByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = taskCopyByIdRequest;

        // create path and map variables
        String localVarPath = "/v1/core/tasks/{id}/copy"
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
    private okhttp3.Call copyByIdValidateBeforeCall(String id, TaskCopyByIdRequest taskCopyByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling copyById(Async)");
        }

        return copyByIdCall(id, taskCopyByIdRequest, _callback);

    }


    private ApiResponse<Task> copyByIdWithHttpInfo(String id, TaskCopyByIdRequest taskCopyByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = copyByIdValidateBeforeCall(id, taskCopyByIdRequest, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call copyByIdAsync(String id, TaskCopyByIdRequest taskCopyByIdRequest, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = copyByIdValidateBeforeCall(id, taskCopyByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CopyByIdRequestBuilder {
        private final String id;
        private String name;

        private CopyByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set name
         * @param name  (optional)
         * @return CopyByIdRequestBuilder
         */
        public CopyByIdRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Build call for copyById
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
            TaskCopyByIdRequest taskCopyByIdRequest = buildBodyParams();
            return copyByIdCall(id, taskCopyByIdRequest, _callback);
        }

        private TaskCopyByIdRequest buildBodyParams() {
            TaskCopyByIdRequest taskCopyByIdRequest = new TaskCopyByIdRequest();
            taskCopyByIdRequest.name(this.name);
            return taskCopyByIdRequest;
        }

        /**
         * Execute copyById request
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            TaskCopyByIdRequest taskCopyByIdRequest = buildBodyParams();
            ApiResponse<Task> localVarResp = copyByIdWithHttpInfo(id, taskCopyByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute copyById request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
            TaskCopyByIdRequest taskCopyByIdRequest = buildBodyParams();
            return copyByIdWithHttpInfo(id, taskCopyByIdRequest);
        }

        /**
         * Execute copyById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            TaskCopyByIdRequest taskCopyByIdRequest = buildBodyParams();
            return copyByIdAsync(id, taskCopyByIdRequest, _callback);
        }
    }

    /**
     * Copy Task by ID
     * Copy Task by ID
     * @param id (Required) (required)
     * @return CopyByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CopyByIdRequestBuilder copyById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new CopyByIdRequestBuilder(id);
    }
    private okhttp3.Call createNewTaskCall(TaskCreateNewTaskRequest taskCreateNewTaskRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = taskCreateNewTaskRequest;

        // create path and map variables
        String localVarPath = "/v1/core/tasks";

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
    private okhttp3.Call createNewTaskValidateBeforeCall(TaskCreateNewTaskRequest taskCreateNewTaskRequest, final ApiCallback _callback) throws ApiException {
        return createNewTaskCall(taskCreateNewTaskRequest, _callback);

    }


    private ApiResponse<Task> createNewTaskWithHttpInfo(TaskCreateNewTaskRequest taskCreateNewTaskRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewTaskValidateBeforeCall(taskCreateNewTaskRequest, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewTaskAsync(TaskCreateNewTaskRequest taskCreateNewTaskRequest, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewTaskValidateBeforeCall(taskCreateNewTaskRequest, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewTaskRequestBuilder {
        private final String name;
        private String dueOn;
        private String content;
        private List<Integer> assigneeIds;

        private CreateNewTaskRequestBuilder(String name) {
            this.name = name;
        }

        /**
         * Set dueOn
         * @param dueOn  (optional)
         * @return CreateNewTaskRequestBuilder
         */
        public CreateNewTaskRequestBuilder dueOn(String dueOn) {
            this.dueOn = dueOn;
            return this;
        }
        
        /**
         * Set content
         * @param content  (optional)
         * @return CreateNewTaskRequestBuilder
         */
        public CreateNewTaskRequestBuilder content(String content) {
            this.content = content;
            return this;
        }
        
        /**
         * Set assigneeIds
         * @param assigneeIds  (optional)
         * @return CreateNewTaskRequestBuilder
         */
        public CreateNewTaskRequestBuilder assigneeIds(List<Integer> assigneeIds) {
            this.assigneeIds = assigneeIds;
            return this;
        }
        
        /**
         * Build call for createNewTask
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
            TaskCreateNewTaskRequest taskCreateNewTaskRequest = buildBodyParams();
            return createNewTaskCall(taskCreateNewTaskRequest, _callback);
        }

        private TaskCreateNewTaskRequest buildBodyParams() {
            TaskCreateNewTaskRequest taskCreateNewTaskRequest = new TaskCreateNewTaskRequest();
            taskCreateNewTaskRequest.name(this.name);
            taskCreateNewTaskRequest.dueOn(this.dueOn);
            taskCreateNewTaskRequest.content(this.content);
            taskCreateNewTaskRequest.assigneeIds(this.assigneeIds);
            return taskCreateNewTaskRequest;
        }

        /**
         * Execute createNewTask request
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            TaskCreateNewTaskRequest taskCreateNewTaskRequest = buildBodyParams();
            ApiResponse<Task> localVarResp = createNewTaskWithHttpInfo(taskCreateNewTaskRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewTask request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
            TaskCreateNewTaskRequest taskCreateNewTaskRequest = buildBodyParams();
            return createNewTaskWithHttpInfo(taskCreateNewTaskRequest);
        }

        /**
         * Execute createNewTask request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            TaskCreateNewTaskRequest taskCreateNewTaskRequest = buildBodyParams();
            return createNewTaskAsync(taskCreateNewTaskRequest, _callback);
        }
    }

    /**
     * Create a Task
     * Create a Task
     * @return CreateNewTaskRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewTaskRequestBuilder createNewTask(String name) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        return new CreateNewTaskRequestBuilder(name);
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
        String localVarPath = "/v1/core/tasks/{id}"
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


    private ApiResponse<Task> deleteByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteByIdAsync(String id, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
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
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            ApiResponse<Task> localVarResp = deleteByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteById request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            return deleteByIdAsync(id, _callback);
        }
    }

    /**
     * Delete a Task by ID
     * Delete a Task by ID
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
    private okhttp3.Call deleteFileInTaskCall(String taskId, String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/core/tasks/{task_id}/files/{id}"
            .replace("{" + "task_id" + "}", localVarApiClient.escapeString(taskId.toString()))
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
    private okhttp3.Call deleteFileInTaskValidateBeforeCall(String taskId, String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling deleteFileInTask(Async)");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteFileInTask(Async)");
        }

        return deleteFileInTaskCall(taskId, id, _callback);

    }


    private ApiResponse<TaskFile> deleteFileInTaskWithHttpInfo(String taskId, String id) throws ApiException {
        okhttp3.Call localVarCall = deleteFileInTaskValidateBeforeCall(taskId, id, null);
        Type localVarReturnType = new TypeToken<TaskFile>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteFileInTaskAsync(String taskId, String id, final ApiCallback<TaskFile> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteFileInTaskValidateBeforeCall(taskId, id, _callback);
        Type localVarReturnType = new TypeToken<TaskFile>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteFileInTaskRequestBuilder {
        private final String taskId;
        private final String id;

        private DeleteFileInTaskRequestBuilder(String taskId, String id) {
            this.taskId = taskId;
            this.id = id;
        }

        /**
         * Build call for deleteFileInTask
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
            return deleteFileInTaskCall(taskId, id, _callback);
        }


        /**
         * Execute deleteFileInTask request
         * @return TaskFile
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public TaskFile execute() throws ApiException {
            ApiResponse<TaskFile> localVarResp = deleteFileInTaskWithHttpInfo(taskId, id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteFileInTask request with HTTP info returned
         * @return ApiResponse&lt;TaskFile&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TaskFile> executeWithHttpInfo() throws ApiException {
            return deleteFileInTaskWithHttpInfo(taskId, id);
        }

        /**
         * Execute deleteFileInTask request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TaskFile> _callback) throws ApiException {
            return deleteFileInTaskAsync(taskId, id, _callback);
        }
    }

    /**
     * Delete a File in a Task
     * Delete a File in a Task
     * @param taskId (Required) (required)
     * @param id (Required) (required)
     * @return DeleteFileInTaskRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteFileInTaskRequestBuilder deleteFileInTask(String taskId, String id) throws IllegalArgumentException {
        if (taskId == null) throw new IllegalArgumentException("\"taskId\" is required but got null");
            

        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteFileInTaskRequestBuilder(taskId, id);
    }
    private okhttp3.Call getAllTasksCall(Integer assigneeId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/core/tasks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (assigneeId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("assignee_id", assigneeId));
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
    private okhttp3.Call getAllTasksValidateBeforeCall(Integer assigneeId, final ApiCallback _callback) throws ApiException {
        return getAllTasksCall(assigneeId, _callback);

    }


    private ApiResponse<List<Task>> getAllTasksWithHttpInfo(Integer assigneeId) throws ApiException {
        okhttp3.Call localVarCall = getAllTasksValidateBeforeCall(assigneeId, null);
        Type localVarReturnType = new TypeToken<List<Task>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllTasksAsync(Integer assigneeId, final ApiCallback<List<Task>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllTasksValidateBeforeCall(assigneeId, _callback);
        Type localVarReturnType = new TypeToken<List<Task>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllTasksRequestBuilder {
        private Integer assigneeId;

        private GetAllTasksRequestBuilder() {
        }

        /**
         * Set assigneeId
         * @param assigneeId Retrieves the list of tasks by assignee (optional)
         * @return GetAllTasksRequestBuilder
         */
        public GetAllTasksRequestBuilder assigneeId(Integer assigneeId) {
            this.assigneeId = assigneeId;
            return this;
        }
        
        /**
         * Build call for getAllTasks
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
            return getAllTasksCall(assigneeId, _callback);
        }


        /**
         * Execute getAllTasks request
         * @return List&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Task> execute() throws ApiException {
            ApiResponse<List<Task>> localVarResp = getAllTasksWithHttpInfo(assigneeId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAllTasks request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Task&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Task>> executeWithHttpInfo() throws ApiException {
            return getAllTasksWithHttpInfo(assigneeId);
        }

        /**
         * Execute getAllTasks request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Task>> _callback) throws ApiException {
            return getAllTasksAsync(assigneeId, _callback);
        }
    }

    /**
     * Get Tasks
     * Get Tasks
     * @return GetAllTasksRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetAllTasksRequestBuilder getAllTasks() throws IllegalArgumentException {
        return new GetAllTasksRequestBuilder();
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
        String localVarPath = "/v1/core/tasks/{id}"
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


    private ApiResponse<Task> getByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(String id, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
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
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            ApiResponse<Task> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get a Task by ID
     * Get a Task by ID
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
    private okhttp3.Call getFileCall(String taskId, String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/core/tasks/{task_id}/files/{id}"
            .replace("{" + "task_id" + "}", localVarApiClient.escapeString(taskId.toString()))
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
    private okhttp3.Call getFileValidateBeforeCall(String taskId, String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'taskId' is set
        if (taskId == null) {
            throw new ApiException("Missing the required parameter 'taskId' when calling getFile(Async)");
        }

        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getFile(Async)");
        }

        return getFileCall(taskId, id, _callback);

    }


    private ApiResponse<TaskFile> getFileWithHttpInfo(String taskId, String id) throws ApiException {
        okhttp3.Call localVarCall = getFileValidateBeforeCall(taskId, id, null);
        Type localVarReturnType = new TypeToken<TaskFile>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getFileAsync(String taskId, String id, final ApiCallback<TaskFile> _callback) throws ApiException {

        okhttp3.Call localVarCall = getFileValidateBeforeCall(taskId, id, _callback);
        Type localVarReturnType = new TypeToken<TaskFile>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetFileRequestBuilder {
        private final String taskId;
        private final String id;

        private GetFileRequestBuilder(String taskId, String id) {
            this.taskId = taskId;
            this.id = id;
        }

        /**
         * Build call for getFile
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
            return getFileCall(taskId, id, _callback);
        }


        /**
         * Execute getFile request
         * @return TaskFile
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public TaskFile execute() throws ApiException {
            ApiResponse<TaskFile> localVarResp = getFileWithHttpInfo(taskId, id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getFile request with HTTP info returned
         * @return ApiResponse&lt;TaskFile&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TaskFile> executeWithHttpInfo() throws ApiException {
            return getFileWithHttpInfo(taskId, id);
        }

        /**
         * Execute getFile request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TaskFile> _callback) throws ApiException {
            return getFileAsync(taskId, id, _callback);
        }
    }

    /**
     * Get a file from one Task
     * Get files from one Task
     * @param taskId (Required) (required)
     * @param id (Required) (required)
     * @return GetFileRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetFileRequestBuilder getFile(String taskId, String id) throws IllegalArgumentException {
        if (taskId == null) throw new IllegalArgumentException("\"taskId\" is required but got null");
            

        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GetFileRequestBuilder(taskId, id);
    }
    private okhttp3.Call getFilesCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/core/tasks/{id}/files"
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
    private okhttp3.Call getFilesValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getFiles(Async)");
        }

        return getFilesCall(id, _callback);

    }


    private ApiResponse<TaskFile> getFilesWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getFilesValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<TaskFile>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getFilesAsync(String id, final ApiCallback<TaskFile> _callback) throws ApiException {

        okhttp3.Call localVarCall = getFilesValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<TaskFile>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetFilesRequestBuilder {
        private final String id;

        private GetFilesRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for getFiles
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
            return getFilesCall(id, _callback);
        }


        /**
         * Execute getFiles request
         * @return TaskFile
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public TaskFile execute() throws ApiException {
            ApiResponse<TaskFile> localVarResp = getFilesWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getFiles request with HTTP info returned
         * @return ApiResponse&lt;TaskFile&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<TaskFile> executeWithHttpInfo() throws ApiException {
            return getFilesWithHttpInfo(id);
        }

        /**
         * Execute getFiles request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<TaskFile> _callback) throws ApiException {
            return getFilesAsync(id, _callback);
        }
    }

    /**
     * Get files from a Task
     * Get files from a Task
     * @param id (Required) (required)
     * @return GetFilesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetFilesRequestBuilder getFiles(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GetFilesRequestBuilder(id);
    }
    private okhttp3.Call resolveByIdCall(String id, TaskResolveByIdRequest taskResolveByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = taskResolveByIdRequest;

        // create path and map variables
        String localVarPath = "/v1/core/tasks/{id}/resolve"
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
    private okhttp3.Call resolveByIdValidateBeforeCall(String id, TaskResolveByIdRequest taskResolveByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling resolveById(Async)");
        }

        return resolveByIdCall(id, taskResolveByIdRequest, _callback);

    }


    private ApiResponse<Task> resolveByIdWithHttpInfo(String id, TaskResolveByIdRequest taskResolveByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = resolveByIdValidateBeforeCall(id, taskResolveByIdRequest, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call resolveByIdAsync(String id, TaskResolveByIdRequest taskResolveByIdRequest, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = resolveByIdValidateBeforeCall(id, taskResolveByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ResolveByIdRequestBuilder {
        private final String id;
        private Boolean done;

        private ResolveByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set done
         * @param done  (optional)
         * @return ResolveByIdRequestBuilder
         */
        public ResolveByIdRequestBuilder done(Boolean done) {
            this.done = done;
            return this;
        }
        
        /**
         * Build call for resolveById
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
            TaskResolveByIdRequest taskResolveByIdRequest = buildBodyParams();
            return resolveByIdCall(id, taskResolveByIdRequest, _callback);
        }

        private TaskResolveByIdRequest buildBodyParams() {
            TaskResolveByIdRequest taskResolveByIdRequest = new TaskResolveByIdRequest();
            taskResolveByIdRequest.done(this.done);
            return taskResolveByIdRequest;
        }

        /**
         * Execute resolveById request
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            TaskResolveByIdRequest taskResolveByIdRequest = buildBodyParams();
            ApiResponse<Task> localVarResp = resolveByIdWithHttpInfo(id, taskResolveByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute resolveById request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
            TaskResolveByIdRequest taskResolveByIdRequest = buildBodyParams();
            return resolveByIdWithHttpInfo(id, taskResolveByIdRequest);
        }

        /**
         * Execute resolveById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            TaskResolveByIdRequest taskResolveByIdRequest = buildBodyParams();
            return resolveByIdAsync(id, taskResolveByIdRequest, _callback);
        }
    }

    /**
     * Resolve Task by ID
     * Resolve Task by ID
     * @param id (Required) (required)
     * @return ResolveByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public ResolveByIdRequestBuilder resolveById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new ResolveByIdRequestBuilder(id);
    }
    private okhttp3.Call updateByIdCall(String id, TaskUpdateByIdRequest taskUpdateByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = taskUpdateByIdRequest;

        // create path and map variables
        String localVarPath = "/v1/core/tasks/{id}"
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
    private okhttp3.Call updateByIdValidateBeforeCall(String id, TaskUpdateByIdRequest taskUpdateByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateById(Async)");
        }

        return updateByIdCall(id, taskUpdateByIdRequest, _callback);

    }


    private ApiResponse<Task> updateByIdWithHttpInfo(String id, TaskUpdateByIdRequest taskUpdateByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateByIdValidateBeforeCall(id, taskUpdateByIdRequest, null);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateByIdAsync(String id, TaskUpdateByIdRequest taskUpdateByIdRequest, final ApiCallback<Task> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateByIdValidateBeforeCall(id, taskUpdateByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<Task>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateByIdRequestBuilder {
        private final String id;
        private String dueOn;
        private String name;
        private String content;
        private List<Integer> assigneeIds;

        private UpdateByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set dueOn
         * @param dueOn  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder dueOn(String dueOn) {
            this.dueOn = dueOn;
            return this;
        }
        
        /**
         * Set name
         * @param name  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        /**
         * Set content
         * @param content  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder content(String content) {
            this.content = content;
            return this;
        }
        
        /**
         * Set assigneeIds
         * @param assigneeIds  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder assigneeIds(List<Integer> assigneeIds) {
            this.assigneeIds = assigneeIds;
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
            TaskUpdateByIdRequest taskUpdateByIdRequest = buildBodyParams();
            return updateByIdCall(id, taskUpdateByIdRequest, _callback);
        }

        private TaskUpdateByIdRequest buildBodyParams() {
            TaskUpdateByIdRequest taskUpdateByIdRequest = new TaskUpdateByIdRequest();
            taskUpdateByIdRequest.dueOn(this.dueOn);
            taskUpdateByIdRequest.name(this.name);
            taskUpdateByIdRequest.content(this.content);
            taskUpdateByIdRequest.assigneeIds(this.assigneeIds);
            return taskUpdateByIdRequest;
        }

        /**
         * Execute updateById request
         * @return Task
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Task execute() throws ApiException {
            TaskUpdateByIdRequest taskUpdateByIdRequest = buildBodyParams();
            ApiResponse<Task> localVarResp = updateByIdWithHttpInfo(id, taskUpdateByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateById request with HTTP info returned
         * @return ApiResponse&lt;Task&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Task> executeWithHttpInfo() throws ApiException {
            TaskUpdateByIdRequest taskUpdateByIdRequest = buildBodyParams();
            return updateByIdWithHttpInfo(id, taskUpdateByIdRequest);
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
        public okhttp3.Call executeAsync(final ApiCallback<Task> _callback) throws ApiException {
            TaskUpdateByIdRequest taskUpdateByIdRequest = buildBodyParams();
            return updateByIdAsync(id, taskUpdateByIdRequest, _callback);
        }
    }

    /**
     * Update a Task by ID
     * Update a Task by ID
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
}
