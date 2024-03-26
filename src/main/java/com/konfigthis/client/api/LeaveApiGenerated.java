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


import com.konfigthis.client.model.Leave;
import com.konfigthis.client.model.LeaveCreateNewLeaveRequest;
import com.konfigthis.client.model.LeaveCreateNewLeaveRequest1;
import com.konfigthis.client.model.LeaveType;
import com.konfigthis.client.model.LeaveTypeCreateRequest;
import com.konfigthis.client.model.LeaveUpdateByIdRequest;
import com.konfigthis.client.model.LeaveUpdateLeaveByIdRequest;
import com.konfigthis.client.model.LeaveUpdateTypeRequest;
import com.konfigthis.client.model.LeaveV2;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class LeaveApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public LeaveApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public LeaveApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createNewLeaveCall(LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = leaveCreateNewLeaveRequest;

        // create path and map variables
        String localVarPath = "/v1/time/leaves";

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
    private okhttp3.Call createNewLeaveValidateBeforeCall(LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest, final ApiCallback _callback) throws ApiException {
        return createNewLeaveCall(leaveCreateNewLeaveRequest, _callback);

    }


    private ApiResponse<Leave> createNewLeaveWithHttpInfo(LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewLeaveValidateBeforeCall(leaveCreateNewLeaveRequest, null);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewLeaveAsync(LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest, final ApiCallback<Leave> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewLeaveValidateBeforeCall(leaveCreateNewLeaveRequest, _callback);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewLeaveRequestBuilder {
        private final String startOn;
        private final String finishOn;
        private final Integer employeeId;
        private String description;
        private Integer leaveTypeId;
        private String halfDay;

        private CreateNewLeaveRequestBuilder(String startOn, String finishOn, Integer employeeId) {
            this.startOn = startOn;
            this.finishOn = finishOn;
            this.employeeId = employeeId;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return CreateNewLeaveRequestBuilder
         */
        public CreateNewLeaveRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set leaveTypeId
         * @param leaveTypeId  (optional)
         * @return CreateNewLeaveRequestBuilder
         */
        public CreateNewLeaveRequestBuilder leaveTypeId(Integer leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
            return this;
        }
        
        /**
         * Set halfDay
         * @param halfDay  (optional)
         * @return CreateNewLeaveRequestBuilder
         */
        public CreateNewLeaveRequestBuilder halfDay(String halfDay) {
            this.halfDay = halfDay;
            return this;
        }
        
        /**
         * Build call for createNewLeave
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
            LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest = buildBodyParams();
            return createNewLeaveCall(leaveCreateNewLeaveRequest, _callback);
        }

        private LeaveCreateNewLeaveRequest buildBodyParams() {
            LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest = new LeaveCreateNewLeaveRequest();
            leaveCreateNewLeaveRequest.description(this.description);
            leaveCreateNewLeaveRequest.startOn(this.startOn);
            leaveCreateNewLeaveRequest.finishOn(this.finishOn);
            leaveCreateNewLeaveRequest.employeeId(this.employeeId);
            leaveCreateNewLeaveRequest.leaveTypeId(this.leaveTypeId);
            if (this.halfDay != null)
            leaveCreateNewLeaveRequest.halfDay(LeaveCreateNewLeaveRequest.HalfDayEnum.fromValue(this.halfDay));
            return leaveCreateNewLeaveRequest;
        }

        /**
         * Execute createNewLeave request
         * @return Leave
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Leave execute() throws ApiException {
            LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest = buildBodyParams();
            ApiResponse<Leave> localVarResp = createNewLeaveWithHttpInfo(leaveCreateNewLeaveRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewLeave request with HTTP info returned
         * @return ApiResponse&lt;Leave&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Leave> executeWithHttpInfo() throws ApiException {
            LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest = buildBodyParams();
            return createNewLeaveWithHttpInfo(leaveCreateNewLeaveRequest);
        }

        /**
         * Execute createNewLeave request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Leave> _callback) throws ApiException {
            LeaveCreateNewLeaveRequest leaveCreateNewLeaveRequest = buildBodyParams();
            return createNewLeaveAsync(leaveCreateNewLeaveRequest, _callback);
        }
    }

    /**
     * Create a Leave
     * Creates a Leave
     * @return CreateNewLeaveRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewLeaveRequestBuilder createNewLeave(String startOn, String finishOn, Integer employeeId) throws IllegalArgumentException {
        if (startOn == null) throw new IllegalArgumentException("\"startOn\" is required but got null");
            

        if (finishOn == null) throw new IllegalArgumentException("\"finishOn\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new CreateNewLeaveRequestBuilder(startOn, finishOn, employeeId);
    }
    private okhttp3.Call createNewLeave_0Call(LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = leaveCreateNewLeaveRequest1;

        // create path and map variables
        String localVarPath = "/v2/time/leaves";

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
    private okhttp3.Call createNewLeave_0ValidateBeforeCall(LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1, final ApiCallback _callback) throws ApiException {
        return createNewLeave_0Call(leaveCreateNewLeaveRequest1, _callback);

    }


    private ApiResponse<Leave> createNewLeave_0WithHttpInfo(LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1) throws ApiException {
        okhttp3.Call localVarCall = createNewLeave_0ValidateBeforeCall(leaveCreateNewLeaveRequest1, null);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewLeave_0Async(LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1, final ApiCallback<Leave> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewLeave_0ValidateBeforeCall(leaveCreateNewLeaveRequest1, _callback);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewLeave0RequestBuilder {
        private final String startOn;
        private final String finishOn;
        private final Integer employeeId;
        private String description;
        private Integer leaveTypeId;
        private String halfDay;
        private String startTime;
        private Integer hoursAmountInCents;
        private Integer medicalLeaveType;
        private String effectiveOn;
        private String medicalDischargeReason;
        private Integer colegiateNumber;
        private Boolean hasPreviousRelapse;
        private Integer relapseLeaveId;
        private String relapseOn;
        private String accidentOn;
        private String paternityBirthOn;

        private CreateNewLeave0RequestBuilder(String startOn, String finishOn, Integer employeeId) {
            this.startOn = startOn;
            this.finishOn = finishOn;
            this.employeeId = employeeId;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set leaveTypeId
         * @param leaveTypeId  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder leaveTypeId(Integer leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
            return this;
        }
        
        /**
         * Set halfDay
         * @param halfDay  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder halfDay(String halfDay) {
            this.halfDay = halfDay;
            return this;
        }
        
        /**
         * Set startTime
         * @param startTime  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }
        
        /**
         * Set hoursAmountInCents
         * @param hoursAmountInCents  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder hoursAmountInCents(Integer hoursAmountInCents) {
            this.hoursAmountInCents = hoursAmountInCents;
            return this;
        }
        
        /**
         * Set medicalLeaveType
         * @param medicalLeaveType  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder medicalLeaveType(Integer medicalLeaveType) {
            this.medicalLeaveType = medicalLeaveType;
            return this;
        }
        
        /**
         * Set effectiveOn
         * @param effectiveOn  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder effectiveOn(String effectiveOn) {
            this.effectiveOn = effectiveOn;
            return this;
        }
        
        /**
         * Set medicalDischargeReason
         * @param medicalDischargeReason  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder medicalDischargeReason(String medicalDischargeReason) {
            this.medicalDischargeReason = medicalDischargeReason;
            return this;
        }
        
        /**
         * Set colegiateNumber
         * @param colegiateNumber  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder colegiateNumber(Integer colegiateNumber) {
            this.colegiateNumber = colegiateNumber;
            return this;
        }
        
        /**
         * Set hasPreviousRelapse
         * @param hasPreviousRelapse  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder hasPreviousRelapse(Boolean hasPreviousRelapse) {
            this.hasPreviousRelapse = hasPreviousRelapse;
            return this;
        }
        
        /**
         * Set relapseLeaveId
         * @param relapseLeaveId  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder relapseLeaveId(Integer relapseLeaveId) {
            this.relapseLeaveId = relapseLeaveId;
            return this;
        }
        
        /**
         * Set relapseOn
         * @param relapseOn  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder relapseOn(String relapseOn) {
            this.relapseOn = relapseOn;
            return this;
        }
        
        /**
         * Set accidentOn
         * @param accidentOn  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder accidentOn(String accidentOn) {
            this.accidentOn = accidentOn;
            return this;
        }
        
        /**
         * Set paternityBirthOn
         * @param paternityBirthOn  (optional)
         * @return CreateNewLeave0RequestBuilder
         */
        public CreateNewLeave0RequestBuilder paternityBirthOn(String paternityBirthOn) {
            this.paternityBirthOn = paternityBirthOn;
            return this;
        }
        
        /**
         * Build call for createNewLeave_0
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
            LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1 = buildBodyParams();
            return createNewLeave_0Call(leaveCreateNewLeaveRequest1, _callback);
        }

        private LeaveCreateNewLeaveRequest1 buildBodyParams() {
            LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1 = new LeaveCreateNewLeaveRequest1();
            leaveCreateNewLeaveRequest1.description(this.description);
            leaveCreateNewLeaveRequest1.startOn(this.startOn);
            leaveCreateNewLeaveRequest1.finishOn(this.finishOn);
            leaveCreateNewLeaveRequest1.employeeId(this.employeeId);
            leaveCreateNewLeaveRequest1.leaveTypeId(this.leaveTypeId);
            if (this.halfDay != null)
            leaveCreateNewLeaveRequest1.halfDay(LeaveCreateNewLeaveRequest1.HalfDayEnum.fromValue(this.halfDay));
            leaveCreateNewLeaveRequest1.startTime(this.startTime);
            leaveCreateNewLeaveRequest1.hoursAmountInCents(this.hoursAmountInCents);
            leaveCreateNewLeaveRequest1.medicalLeaveType(this.medicalLeaveType);
            leaveCreateNewLeaveRequest1.effectiveOn(this.effectiveOn);
            leaveCreateNewLeaveRequest1.medicalDischargeReason(this.medicalDischargeReason);
            leaveCreateNewLeaveRequest1.colegiateNumber(this.colegiateNumber);
            leaveCreateNewLeaveRequest1.hasPreviousRelapse(this.hasPreviousRelapse);
            leaveCreateNewLeaveRequest1.relapseLeaveId(this.relapseLeaveId);
            leaveCreateNewLeaveRequest1.relapseOn(this.relapseOn);
            leaveCreateNewLeaveRequest1.accidentOn(this.accidentOn);
            leaveCreateNewLeaveRequest1.paternityBirthOn(this.paternityBirthOn);
            return leaveCreateNewLeaveRequest1;
        }

        /**
         * Execute createNewLeave_0 request
         * @return Leave
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Leave execute() throws ApiException {
            LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1 = buildBodyParams();
            ApiResponse<Leave> localVarResp = createNewLeave_0WithHttpInfo(leaveCreateNewLeaveRequest1);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewLeave_0 request with HTTP info returned
         * @return ApiResponse&lt;Leave&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Leave> executeWithHttpInfo() throws ApiException {
            LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1 = buildBodyParams();
            return createNewLeave_0WithHttpInfo(leaveCreateNewLeaveRequest1);
        }

        /**
         * Execute createNewLeave_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Leave> _callback) throws ApiException {
            LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1 = buildBodyParams();
            return createNewLeave_0Async(leaveCreateNewLeaveRequest1, _callback);
        }
    }

    /**
     * Create a Leave
     * Creates a Leave
     * @return CreateNewLeave0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewLeave0RequestBuilder createNewLeave_0(String startOn, String finishOn, Integer employeeId) throws IllegalArgumentException {
        if (startOn == null) throw new IllegalArgumentException("\"startOn\" is required but got null");
            

        if (finishOn == null) throw new IllegalArgumentException("\"finishOn\" is required but got null");
            

        if (employeeId == null) throw new IllegalArgumentException("\"employeeId\" is required but got null");
        return new CreateNewLeave0RequestBuilder(startOn, finishOn, employeeId);
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
        String localVarPath = "/v1/time/leaves/{id}"
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


    private ApiResponse<Leave> deleteByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteByIdAsync(String id, final ApiCallback<Leave> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
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
         * @return Leave
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Leave execute() throws ApiException {
            ApiResponse<Leave> localVarResp = deleteByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteById request with HTTP info returned
         * @return ApiResponse&lt;Leave&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Leave> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Leave> _callback) throws ApiException {
            return deleteByIdAsync(id, _callback);
        }
    }

    /**
     * Delete a Leave by ID
     * Delete a Leave by ID
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
    private okhttp3.Call deleteById_0Call(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/time/leaves/{id}"
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
    private okhttp3.Call deleteById_0ValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteById_0(Async)");
        }

        return deleteById_0Call(id, _callback);

    }


    private ApiResponse<LeaveV2> deleteById_0WithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteById_0ValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<LeaveV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteById_0Async(String id, final ApiCallback<LeaveV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteById_0ValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<LeaveV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteById0RequestBuilder {
        private final String id;

        private DeleteById0RequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for deleteById_0
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
            return deleteById_0Call(id, _callback);
        }


        /**
         * Execute deleteById_0 request
         * @return LeaveV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public LeaveV2 execute() throws ApiException {
            ApiResponse<LeaveV2> localVarResp = deleteById_0WithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteById_0 request with HTTP info returned
         * @return ApiResponse&lt;LeaveV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LeaveV2> executeWithHttpInfo() throws ApiException {
            return deleteById_0WithHttpInfo(id);
        }

        /**
         * Execute deleteById_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<LeaveV2> _callback) throws ApiException {
            return deleteById_0Async(id, _callback);
        }
    }

    /**
     * Delete a Leave by ID
     * Delete a Leave by ID
     * @param id (Required) (required)
     * @return DeleteById0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteById0RequestBuilder deleteById_0(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteById0RequestBuilder(id);
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
        String localVarPath = "/v1/time/leaves/{id}"
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


    private ApiResponse<Leave> getByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(String id, final ApiCallback<Leave> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
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
         * @return Leave
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Leave execute() throws ApiException {
            ApiResponse<Leave> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;Leave&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Leave> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Leave> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get a Leave by ID
     * Get a Leave by ID
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
    private okhttp3.Call getById_0Call(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/time/leaves/{id}"
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
    private okhttp3.Call getById_0ValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getById_0(Async)");
        }

        return getById_0Call(id, _callback);

    }


    private ApiResponse<LeaveV2> getById_0WithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getById_0ValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<LeaveV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getById_0Async(String id, final ApiCallback<LeaveV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = getById_0ValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<LeaveV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetById0RequestBuilder {
        private final String id;

        private GetById0RequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for getById_0
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
            return getById_0Call(id, _callback);
        }


        /**
         * Execute getById_0 request
         * @return LeaveV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public LeaveV2 execute() throws ApiException {
            ApiResponse<LeaveV2> localVarResp = getById_0WithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById_0 request with HTTP info returned
         * @return ApiResponse&lt;LeaveV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LeaveV2> executeWithHttpInfo() throws ApiException {
            return getById_0WithHttpInfo(id);
        }

        /**
         * Execute getById_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<LeaveV2> _callback) throws ApiException {
            return getById_0Async(id, _callback);
        }
    }

    /**
     * Get a Leave by ID
     * Get a Leave by ID
     * @param id (Required) (required)
     * @return GetById0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetById0RequestBuilder getById_0(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new GetById0RequestBuilder(id);
    }
    private okhttp3.Call getCompanyLeavesCall(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/time/leaves";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (employeeIds != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "employee_ids[]", employeeIds));
        }

        if (leaveTypeIds != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "leave_type_ids[]", leaveTypeIds));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
        }

        if (includeLeaveType != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include_leave_type", includeLeaveType));
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
    private okhttp3.Call getCompanyLeavesValidateBeforeCall(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType, final ApiCallback _callback) throws ApiException {
        return getCompanyLeavesCall(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);

    }


    private ApiResponse<List<Leave>> getCompanyLeavesWithHttpInfo(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType) throws ApiException {
        okhttp3.Call localVarCall = getCompanyLeavesValidateBeforeCall(employeeIds, leaveTypeIds, from, to, includeLeaveType, null);
        Type localVarReturnType = new TypeToken<List<Leave>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getCompanyLeavesAsync(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType, final ApiCallback<List<Leave>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCompanyLeavesValidateBeforeCall(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);
        Type localVarReturnType = new TypeToken<List<Leave>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetCompanyLeavesRequestBuilder {
        private List<Integer> employeeIds;
        private List<Integer> leaveTypeIds;
        private String from;
        private String to;
        private Boolean includeLeaveType;

        private GetCompanyLeavesRequestBuilder() {
        }

        /**
         * Set employeeIds
         * @param employeeIds Employees id array (optional)
         * @return GetCompanyLeavesRequestBuilder
         */
        public GetCompanyLeavesRequestBuilder employeeIds(List<Integer> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        
        /**
         * Set leaveTypeIds
         * @param leaveTypeIds Leave type id array (optional)
         * @return GetCompanyLeavesRequestBuilder
         */
        public GetCompanyLeavesRequestBuilder leaveTypeIds(List<Integer> leaveTypeIds) {
            this.leaveTypeIds = leaveTypeIds;
            return this;
        }
        
        /**
         * Set from
         * @param from It should be a valid date following the format YYYY-MM-DD (optional)
         * @return GetCompanyLeavesRequestBuilder
         */
        public GetCompanyLeavesRequestBuilder from(String from) {
            this.from = from;
            return this;
        }
        
        /**
         * Set to
         * @param to It should be a valid date following the format YYYY-MM-DD (optional)
         * @return GetCompanyLeavesRequestBuilder
         */
        public GetCompanyLeavesRequestBuilder to(String to) {
            this.to = to;
            return this;
        }
        
        /**
         * Set includeLeaveType
         * @param includeLeaveType Include leave type name (optional, default to false)
         * @return GetCompanyLeavesRequestBuilder
         */
        public GetCompanyLeavesRequestBuilder includeLeaveType(Boolean includeLeaveType) {
            this.includeLeaveType = includeLeaveType;
            return this;
        }
        
        /**
         * Build call for getCompanyLeaves
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
            return getCompanyLeavesCall(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);
        }


        /**
         * Execute getCompanyLeaves request
         * @return List&lt;Leave&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Leave> execute() throws ApiException {
            ApiResponse<List<Leave>> localVarResp = getCompanyLeavesWithHttpInfo(employeeIds, leaveTypeIds, from, to, includeLeaveType);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getCompanyLeaves request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Leave&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Leave>> executeWithHttpInfo() throws ApiException {
            return getCompanyLeavesWithHttpInfo(employeeIds, leaveTypeIds, from, to, includeLeaveType);
        }

        /**
         * Execute getCompanyLeaves request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Leave>> _callback) throws ApiException {
            return getCompanyLeavesAsync(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);
        }
    }

    /**
     * Get Leaves
     * Get Leaves from a company
     * @return GetCompanyLeavesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetCompanyLeavesRequestBuilder getCompanyLeaves() throws IllegalArgumentException {
        return new GetCompanyLeavesRequestBuilder();
    }
    private okhttp3.Call getCompanyLeaves_0Call(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v2/time/leaves";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (employeeIds != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "employee_ids[]", employeeIds));
        }

        if (leaveTypeIds != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "leave_type_ids[]", leaveTypeIds));
        }

        if (from != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("from", from));
        }

        if (to != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("to", to));
        }

        if (includeLeaveType != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("include_leave_type", includeLeaveType));
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
    private okhttp3.Call getCompanyLeaves_0ValidateBeforeCall(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType, final ApiCallback _callback) throws ApiException {
        return getCompanyLeaves_0Call(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);

    }


    private ApiResponse<List<LeaveV2>> getCompanyLeaves_0WithHttpInfo(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType) throws ApiException {
        okhttp3.Call localVarCall = getCompanyLeaves_0ValidateBeforeCall(employeeIds, leaveTypeIds, from, to, includeLeaveType, null);
        Type localVarReturnType = new TypeToken<List<LeaveV2>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getCompanyLeaves_0Async(List<Integer> employeeIds, List<Integer> leaveTypeIds, String from, String to, Boolean includeLeaveType, final ApiCallback<List<LeaveV2>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCompanyLeaves_0ValidateBeforeCall(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);
        Type localVarReturnType = new TypeToken<List<LeaveV2>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetCompanyLeaves0RequestBuilder {
        private List<Integer> employeeIds;
        private List<Integer> leaveTypeIds;
        private String from;
        private String to;
        private Boolean includeLeaveType;

        private GetCompanyLeaves0RequestBuilder() {
        }

        /**
         * Set employeeIds
         * @param employeeIds Employees id array (optional)
         * @return GetCompanyLeaves0RequestBuilder
         */
        public GetCompanyLeaves0RequestBuilder employeeIds(List<Integer> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        
        /**
         * Set leaveTypeIds
         * @param leaveTypeIds Leave type id array (optional)
         * @return GetCompanyLeaves0RequestBuilder
         */
        public GetCompanyLeaves0RequestBuilder leaveTypeIds(List<Integer> leaveTypeIds) {
            this.leaveTypeIds = leaveTypeIds;
            return this;
        }
        
        /**
         * Set from
         * @param from It should be a valid date following the format YYYY-MM-DD (optional)
         * @return GetCompanyLeaves0RequestBuilder
         */
        public GetCompanyLeaves0RequestBuilder from(String from) {
            this.from = from;
            return this;
        }
        
        /**
         * Set to
         * @param to It should be a valid date following the format YYYY-MM-DD (optional)
         * @return GetCompanyLeaves0RequestBuilder
         */
        public GetCompanyLeaves0RequestBuilder to(String to) {
            this.to = to;
            return this;
        }
        
        /**
         * Set includeLeaveType
         * @param includeLeaveType Include leave type name (optional, default to false)
         * @return GetCompanyLeaves0RequestBuilder
         */
        public GetCompanyLeaves0RequestBuilder includeLeaveType(Boolean includeLeaveType) {
            this.includeLeaveType = includeLeaveType;
            return this;
        }
        
        /**
         * Build call for getCompanyLeaves_0
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
            return getCompanyLeaves_0Call(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);
        }


        /**
         * Execute getCompanyLeaves_0 request
         * @return List&lt;LeaveV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<LeaveV2> execute() throws ApiException {
            ApiResponse<List<LeaveV2>> localVarResp = getCompanyLeaves_0WithHttpInfo(employeeIds, leaveTypeIds, from, to, includeLeaveType);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getCompanyLeaves_0 request with HTTP info returned
         * @return ApiResponse&lt;List&lt;LeaveV2&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<LeaveV2>> executeWithHttpInfo() throws ApiException {
            return getCompanyLeaves_0WithHttpInfo(employeeIds, leaveTypeIds, from, to, includeLeaveType);
        }

        /**
         * Execute getCompanyLeaves_0 request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<LeaveV2>> _callback) throws ApiException {
            return getCompanyLeaves_0Async(employeeIds, leaveTypeIds, from, to, includeLeaveType, _callback);
        }
    }

    /**
     * Get Leaves
     * Get Leaves from a company
     * @return GetCompanyLeaves0RequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetCompanyLeaves0RequestBuilder getCompanyLeaves_0() throws IllegalArgumentException {
        return new GetCompanyLeaves0RequestBuilder();
    }
    private okhttp3.Call getTypesCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/time/leave_types";

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
    private okhttp3.Call getTypesValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return getTypesCall(_callback);

    }


    private ApiResponse<List<LeaveType>> getTypesWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = getTypesValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<LeaveType>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getTypesAsync(final ApiCallback<List<LeaveType>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getTypesValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<LeaveType>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetTypesRequestBuilder {

        private GetTypesRequestBuilder() {
        }

        /**
         * Build call for getTypes
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
            return getTypesCall(_callback);
        }


        /**
         * Execute getTypes request
         * @return List&lt;LeaveType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<LeaveType> execute() throws ApiException {
            ApiResponse<List<LeaveType>> localVarResp = getTypesWithHttpInfo();
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getTypes request with HTTP info returned
         * @return ApiResponse&lt;List&lt;LeaveType&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<LeaveType>> executeWithHttpInfo() throws ApiException {
            return getTypesWithHttpInfo();
        }

        /**
         * Execute getTypes request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<LeaveType>> _callback) throws ApiException {
            return getTypesAsync(_callback);
        }
    }

    /**
     * Get Leave types
     * Get Leave types from a company
     * @return GetTypesRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetTypesRequestBuilder getTypes() throws IllegalArgumentException {
        return new GetTypesRequestBuilder();
    }
    private okhttp3.Call typeCreateCall(LeaveTypeCreateRequest leaveTypeCreateRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = leaveTypeCreateRequest;

        // create path and map variables
        String localVarPath = "/v1/time/leave_types";

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
    private okhttp3.Call typeCreateValidateBeforeCall(LeaveTypeCreateRequest leaveTypeCreateRequest, final ApiCallback _callback) throws ApiException {
        return typeCreateCall(leaveTypeCreateRequest, _callback);

    }


    private ApiResponse<LeaveType> typeCreateWithHttpInfo(LeaveTypeCreateRequest leaveTypeCreateRequest) throws ApiException {
        okhttp3.Call localVarCall = typeCreateValidateBeforeCall(leaveTypeCreateRequest, null);
        Type localVarReturnType = new TypeToken<LeaveType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call typeCreateAsync(LeaveTypeCreateRequest leaveTypeCreateRequest, final ApiCallback<LeaveType> _callback) throws ApiException {

        okhttp3.Call localVarCall = typeCreateValidateBeforeCall(leaveTypeCreateRequest, _callback);
        Type localVarReturnType = new TypeToken<LeaveType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class TypeCreateRequestBuilder {
        private final String name;
        private final String color;
        private Boolean accrues;
        private Boolean active;
        private Boolean approvalRequired;
        private Boolean attachment;
        private Boolean visibility;
        private Boolean workable;

        private TypeCreateRequestBuilder(String name, String color) {
            this.name = name;
            this.color = color;
        }

        /**
         * Set accrues
         * @param accrues  (optional)
         * @return TypeCreateRequestBuilder
         */
        public TypeCreateRequestBuilder accrues(Boolean accrues) {
            this.accrues = accrues;
            return this;
        }
        
        /**
         * Set active
         * @param active  (optional)
         * @return TypeCreateRequestBuilder
         */
        public TypeCreateRequestBuilder active(Boolean active) {
            this.active = active;
            return this;
        }
        
        /**
         * Set approvalRequired
         * @param approvalRequired  (optional)
         * @return TypeCreateRequestBuilder
         */
        public TypeCreateRequestBuilder approvalRequired(Boolean approvalRequired) {
            this.approvalRequired = approvalRequired;
            return this;
        }
        
        /**
         * Set attachment
         * @param attachment  (optional)
         * @return TypeCreateRequestBuilder
         */
        public TypeCreateRequestBuilder attachment(Boolean attachment) {
            this.attachment = attachment;
            return this;
        }
        
        /**
         * Set visibility
         * @param visibility  (optional)
         * @return TypeCreateRequestBuilder
         */
        public TypeCreateRequestBuilder visibility(Boolean visibility) {
            this.visibility = visibility;
            return this;
        }
        
        /**
         * Set workable
         * @param workable  (optional)
         * @return TypeCreateRequestBuilder
         */
        public TypeCreateRequestBuilder workable(Boolean workable) {
            this.workable = workable;
            return this;
        }
        
        /**
         * Build call for typeCreate
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
            LeaveTypeCreateRequest leaveTypeCreateRequest = buildBodyParams();
            return typeCreateCall(leaveTypeCreateRequest, _callback);
        }

        private LeaveTypeCreateRequest buildBodyParams() {
            LeaveTypeCreateRequest leaveTypeCreateRequest = new LeaveTypeCreateRequest();
            leaveTypeCreateRequest.name(this.name);
            leaveTypeCreateRequest.color(this.color);
            leaveTypeCreateRequest.accrues(this.accrues);
            leaveTypeCreateRequest.active(this.active);
            leaveTypeCreateRequest.approvalRequired(this.approvalRequired);
            leaveTypeCreateRequest.attachment(this.attachment);
            leaveTypeCreateRequest.visibility(this.visibility);
            leaveTypeCreateRequest.workable(this.workable);
            return leaveTypeCreateRequest;
        }

        /**
         * Execute typeCreate request
         * @return LeaveType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public LeaveType execute() throws ApiException {
            LeaveTypeCreateRequest leaveTypeCreateRequest = buildBodyParams();
            ApiResponse<LeaveType> localVarResp = typeCreateWithHttpInfo(leaveTypeCreateRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute typeCreate request with HTTP info returned
         * @return ApiResponse&lt;LeaveType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LeaveType> executeWithHttpInfo() throws ApiException {
            LeaveTypeCreateRequest leaveTypeCreateRequest = buildBodyParams();
            return typeCreateWithHttpInfo(leaveTypeCreateRequest);
        }

        /**
         * Execute typeCreate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<LeaveType> _callback) throws ApiException {
            LeaveTypeCreateRequest leaveTypeCreateRequest = buildBodyParams();
            return typeCreateAsync(leaveTypeCreateRequest, _callback);
        }
    }

    /**
     * Create a Leave Type
     * Create a Leave Type
     * @return TypeCreateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public TypeCreateRequestBuilder typeCreate(String name, String color) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (color == null) throw new IllegalArgumentException("\"color\" is required but got null");
            

        return new TypeCreateRequestBuilder(name, color);
    }
    private okhttp3.Call updateByIdCall(String id, LeaveUpdateByIdRequest leaveUpdateByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = leaveUpdateByIdRequest;

        // create path and map variables
        String localVarPath = "/v2/time/leaves/{id}"
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
    private okhttp3.Call updateByIdValidateBeforeCall(String id, LeaveUpdateByIdRequest leaveUpdateByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateById(Async)");
        }

        return updateByIdCall(id, leaveUpdateByIdRequest, _callback);

    }


    private ApiResponse<LeaveV2> updateByIdWithHttpInfo(String id, LeaveUpdateByIdRequest leaveUpdateByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateByIdValidateBeforeCall(id, leaveUpdateByIdRequest, null);
        Type localVarReturnType = new TypeToken<LeaveV2>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateByIdAsync(String id, LeaveUpdateByIdRequest leaveUpdateByIdRequest, final ApiCallback<LeaveV2> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateByIdValidateBeforeCall(id, leaveUpdateByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<LeaveV2>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateByIdRequestBuilder {
        private final String id;
        private String description;
        private Integer employeeId;
        private String finishOn;
        private String startOn;
        private String startTime;
        private Integer hourAmountInCents;

        private UpdateByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set employeeId
         * @param employeeId  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder employeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        
        /**
         * Set finishOn
         * @param finishOn  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder finishOn(String finishOn) {
            this.finishOn = finishOn;
            return this;
        }
        
        /**
         * Set startOn
         * @param startOn  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder startOn(String startOn) {
            this.startOn = startOn;
            return this;
        }
        
        /**
         * Set startTime
         * @param startTime  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }
        
        /**
         * Set hourAmountInCents
         * @param hourAmountInCents  (optional)
         * @return UpdateByIdRequestBuilder
         */
        public UpdateByIdRequestBuilder hourAmountInCents(Integer hourAmountInCents) {
            this.hourAmountInCents = hourAmountInCents;
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
            LeaveUpdateByIdRequest leaveUpdateByIdRequest = buildBodyParams();
            return updateByIdCall(id, leaveUpdateByIdRequest, _callback);
        }

        private LeaveUpdateByIdRequest buildBodyParams() {
            LeaveUpdateByIdRequest leaveUpdateByIdRequest = new LeaveUpdateByIdRequest();
            leaveUpdateByIdRequest.description(this.description);
            leaveUpdateByIdRequest.employeeId(this.employeeId);
            leaveUpdateByIdRequest.finishOn(this.finishOn);
            leaveUpdateByIdRequest.startOn(this.startOn);
            leaveUpdateByIdRequest.startTime(this.startTime);
            leaveUpdateByIdRequest.hourAmountInCents(this.hourAmountInCents);
            return leaveUpdateByIdRequest;
        }

        /**
         * Execute updateById request
         * @return LeaveV2
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public LeaveV2 execute() throws ApiException {
            LeaveUpdateByIdRequest leaveUpdateByIdRequest = buildBodyParams();
            ApiResponse<LeaveV2> localVarResp = updateByIdWithHttpInfo(id, leaveUpdateByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateById request with HTTP info returned
         * @return ApiResponse&lt;LeaveV2&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LeaveV2> executeWithHttpInfo() throws ApiException {
            LeaveUpdateByIdRequest leaveUpdateByIdRequest = buildBodyParams();
            return updateByIdWithHttpInfo(id, leaveUpdateByIdRequest);
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
        public okhttp3.Call executeAsync(final ApiCallback<LeaveV2> _callback) throws ApiException {
            LeaveUpdateByIdRequest leaveUpdateByIdRequest = buildBodyParams();
            return updateByIdAsync(id, leaveUpdateByIdRequest, _callback);
        }
    }

    /**
     * Update a Leave
     * Update a Leave
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
    private okhttp3.Call updateLeaveByIdCall(String id, LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = leaveUpdateLeaveByIdRequest;

        // create path and map variables
        String localVarPath = "/v1/time/leaves/{id}"
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
    private okhttp3.Call updateLeaveByIdValidateBeforeCall(String id, LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateLeaveById(Async)");
        }

        return updateLeaveByIdCall(id, leaveUpdateLeaveByIdRequest, _callback);

    }


    private ApiResponse<Leave> updateLeaveByIdWithHttpInfo(String id, LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest) throws ApiException {
        okhttp3.Call localVarCall = updateLeaveByIdValidateBeforeCall(id, leaveUpdateLeaveByIdRequest, null);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateLeaveByIdAsync(String id, LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest, final ApiCallback<Leave> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateLeaveByIdValidateBeforeCall(id, leaveUpdateLeaveByIdRequest, _callback);
        Type localVarReturnType = new TypeToken<Leave>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateLeaveByIdRequestBuilder {
        private final String id;
        private String description;
        private Integer employeeId;
        private Integer finishOn;
        private String startOn;
        private String halfDay;
        private Integer leaveTypeId;

        private UpdateLeaveByIdRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return UpdateLeaveByIdRequestBuilder
         */
        public UpdateLeaveByIdRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set employeeId
         * @param employeeId  (optional)
         * @return UpdateLeaveByIdRequestBuilder
         */
        public UpdateLeaveByIdRequestBuilder employeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        
        /**
         * Set finishOn
         * @param finishOn  (optional)
         * @return UpdateLeaveByIdRequestBuilder
         */
        public UpdateLeaveByIdRequestBuilder finishOn(Integer finishOn) {
            this.finishOn = finishOn;
            return this;
        }
        
        /**
         * Set startOn
         * @param startOn  (optional)
         * @return UpdateLeaveByIdRequestBuilder
         */
        public UpdateLeaveByIdRequestBuilder startOn(String startOn) {
            this.startOn = startOn;
            return this;
        }
        
        /**
         * Set halfDay
         * @param halfDay  (optional)
         * @return UpdateLeaveByIdRequestBuilder
         */
        public UpdateLeaveByIdRequestBuilder halfDay(String halfDay) {
            this.halfDay = halfDay;
            return this;
        }
        
        /**
         * Set leaveTypeId
         * @param leaveTypeId  (optional)
         * @return UpdateLeaveByIdRequestBuilder
         */
        public UpdateLeaveByIdRequestBuilder leaveTypeId(Integer leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
            return this;
        }
        
        /**
         * Build call for updateLeaveById
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
            LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest = buildBodyParams();
            return updateLeaveByIdCall(id, leaveUpdateLeaveByIdRequest, _callback);
        }

        private LeaveUpdateLeaveByIdRequest buildBodyParams() {
            LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest = new LeaveUpdateLeaveByIdRequest();
            leaveUpdateLeaveByIdRequest.description(this.description);
            leaveUpdateLeaveByIdRequest.employeeId(this.employeeId);
            leaveUpdateLeaveByIdRequest.finishOn(this.finishOn);
            leaveUpdateLeaveByIdRequest.startOn(this.startOn);
            if (this.halfDay != null)
            leaveUpdateLeaveByIdRequest.halfDay(LeaveUpdateLeaveByIdRequest.HalfDayEnum.fromValue(this.halfDay));
            leaveUpdateLeaveByIdRequest.leaveTypeId(this.leaveTypeId);
            return leaveUpdateLeaveByIdRequest;
        }

        /**
         * Execute updateLeaveById request
         * @return Leave
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Leave execute() throws ApiException {
            LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest = buildBodyParams();
            ApiResponse<Leave> localVarResp = updateLeaveByIdWithHttpInfo(id, leaveUpdateLeaveByIdRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateLeaveById request with HTTP info returned
         * @return ApiResponse&lt;Leave&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Leave> executeWithHttpInfo() throws ApiException {
            LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest = buildBodyParams();
            return updateLeaveByIdWithHttpInfo(id, leaveUpdateLeaveByIdRequest);
        }

        /**
         * Execute updateLeaveById request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Leave> _callback) throws ApiException {
            LeaveUpdateLeaveByIdRequest leaveUpdateLeaveByIdRequest = buildBodyParams();
            return updateLeaveByIdAsync(id, leaveUpdateLeaveByIdRequest, _callback);
        }
    }

    /**
     * Update a Leave
     * Update a Leave
     * @param id (Required) (required)
     * @return UpdateLeaveByIdRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateLeaveByIdRequestBuilder updateLeaveById(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateLeaveByIdRequestBuilder(id);
    }
    private okhttp3.Call updateTypeCall(String id, LeaveUpdateTypeRequest leaveUpdateTypeRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = leaveUpdateTypeRequest;

        // create path and map variables
        String localVarPath = "/v1/time/leave_types/{id}"
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
    private okhttp3.Call updateTypeValidateBeforeCall(String id, LeaveUpdateTypeRequest leaveUpdateTypeRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateType(Async)");
        }

        return updateTypeCall(id, leaveUpdateTypeRequest, _callback);

    }


    private ApiResponse<LeaveType> updateTypeWithHttpInfo(String id, LeaveUpdateTypeRequest leaveUpdateTypeRequest) throws ApiException {
        okhttp3.Call localVarCall = updateTypeValidateBeforeCall(id, leaveUpdateTypeRequest, null);
        Type localVarReturnType = new TypeToken<LeaveType>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateTypeAsync(String id, LeaveUpdateTypeRequest leaveUpdateTypeRequest, final ApiCallback<LeaveType> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateTypeValidateBeforeCall(id, leaveUpdateTypeRequest, _callback);
        Type localVarReturnType = new TypeToken<LeaveType>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateTypeRequestBuilder {
        private final String name;
        private final String color;
        private final String id;
        private Boolean accrues;
        private Boolean active;
        private Boolean approvalRequired;
        private Boolean attachment;
        private Boolean visibility;
        private Boolean workable;

        private UpdateTypeRequestBuilder(String name, String color, String id) {
            this.name = name;
            this.color = color;
            this.id = id;
        }

        /**
         * Set accrues
         * @param accrues  (optional)
         * @return UpdateTypeRequestBuilder
         */
        public UpdateTypeRequestBuilder accrues(Boolean accrues) {
            this.accrues = accrues;
            return this;
        }
        
        /**
         * Set active
         * @param active  (optional)
         * @return UpdateTypeRequestBuilder
         */
        public UpdateTypeRequestBuilder active(Boolean active) {
            this.active = active;
            return this;
        }
        
        /**
         * Set approvalRequired
         * @param approvalRequired  (optional)
         * @return UpdateTypeRequestBuilder
         */
        public UpdateTypeRequestBuilder approvalRequired(Boolean approvalRequired) {
            this.approvalRequired = approvalRequired;
            return this;
        }
        
        /**
         * Set attachment
         * @param attachment  (optional)
         * @return UpdateTypeRequestBuilder
         */
        public UpdateTypeRequestBuilder attachment(Boolean attachment) {
            this.attachment = attachment;
            return this;
        }
        
        /**
         * Set visibility
         * @param visibility  (optional)
         * @return UpdateTypeRequestBuilder
         */
        public UpdateTypeRequestBuilder visibility(Boolean visibility) {
            this.visibility = visibility;
            return this;
        }
        
        /**
         * Set workable
         * @param workable  (optional)
         * @return UpdateTypeRequestBuilder
         */
        public UpdateTypeRequestBuilder workable(Boolean workable) {
            this.workable = workable;
            return this;
        }
        
        /**
         * Build call for updateType
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
            LeaveUpdateTypeRequest leaveUpdateTypeRequest = buildBodyParams();
            return updateTypeCall(id, leaveUpdateTypeRequest, _callback);
        }

        private LeaveUpdateTypeRequest buildBodyParams() {
            LeaveUpdateTypeRequest leaveUpdateTypeRequest = new LeaveUpdateTypeRequest();
            leaveUpdateTypeRequest.name(this.name);
            leaveUpdateTypeRequest.color(this.color);
            leaveUpdateTypeRequest.accrues(this.accrues);
            leaveUpdateTypeRequest.active(this.active);
            leaveUpdateTypeRequest.approvalRequired(this.approvalRequired);
            leaveUpdateTypeRequest.attachment(this.attachment);
            leaveUpdateTypeRequest.visibility(this.visibility);
            leaveUpdateTypeRequest.workable(this.workable);
            return leaveUpdateTypeRequest;
        }

        /**
         * Execute updateType request
         * @return LeaveType
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public LeaveType execute() throws ApiException {
            LeaveUpdateTypeRequest leaveUpdateTypeRequest = buildBodyParams();
            ApiResponse<LeaveType> localVarResp = updateTypeWithHttpInfo(id, leaveUpdateTypeRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateType request with HTTP info returned
         * @return ApiResponse&lt;LeaveType&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<LeaveType> executeWithHttpInfo() throws ApiException {
            LeaveUpdateTypeRequest leaveUpdateTypeRequest = buildBodyParams();
            return updateTypeWithHttpInfo(id, leaveUpdateTypeRequest);
        }

        /**
         * Execute updateType request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<LeaveType> _callback) throws ApiException {
            LeaveUpdateTypeRequest leaveUpdateTypeRequest = buildBodyParams();
            return updateTypeAsync(id, leaveUpdateTypeRequest, _callback);
        }
    }

    /**
     * Update a Leave Type
     * Update a Leave Type
     * @param id (Required) (required)
     * @return UpdateTypeRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public UpdateTypeRequestBuilder updateType(String name, String color, String id) throws IllegalArgumentException {
        if (name == null) throw new IllegalArgumentException("\"name\" is required but got null");
            

        if (color == null) throw new IllegalArgumentException("\"color\" is required but got null");
            

        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateTypeRequestBuilder(name, color, id);
    }
}
