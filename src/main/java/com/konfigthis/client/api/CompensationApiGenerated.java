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


import com.konfigthis.client.model.Compensation;
import com.konfigthis.client.model.CompensationCreateContractCompensationRequest;
import com.konfigthis.client.model.CompensationUpdateForContractRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class CompensationApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public CompensationApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public CompensationApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createContractCompensationCall(CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = compensationCreateContractCompensationRequest;

        // create path and map variables
        String localVarPath = "/v1/payroll/compensations";

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
    private okhttp3.Call createContractCompensationValidateBeforeCall(CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest, final ApiCallback _callback) throws ApiException {
        return createContractCompensationCall(compensationCreateContractCompensationRequest, _callback);

    }


    private ApiResponse<Compensation> createContractCompensationWithHttpInfo(CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest) throws ApiException {
        okhttp3.Call localVarCall = createContractCompensationValidateBeforeCall(compensationCreateContractCompensationRequest, null);
        Type localVarReturnType = new TypeToken<Compensation>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createContractCompensationAsync(CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest, final ApiCallback<Compensation> _callback) throws ApiException {

        okhttp3.Call localVarCall = createContractCompensationValidateBeforeCall(compensationCreateContractCompensationRequest, _callback);
        Type localVarReturnType = new TypeToken<Compensation>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateContractCompensationRequestBuilder {
        private final Integer contractVersionId;
        private String description;
        private Integer contractsTaxonomyId;
        private String compensationType;
        private Integer amount;
        private String unit;
        private Boolean syncWithSupplements;
        private Integer payrollPolicyId;
        private Integer recurrenceCount;
        private String startsOn;
        private String recurrence;
        private String firstPaymentOn;
        private String calculation;

        private CreateContractCompensationRequestBuilder(Integer contractVersionId) {
            this.contractVersionId = contractVersionId;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set contractsTaxonomyId
         * @param contractsTaxonomyId  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder contractsTaxonomyId(Integer contractsTaxonomyId) {
            this.contractsTaxonomyId = contractsTaxonomyId;
            return this;
        }
        
        /**
         * Set compensationType
         * @param compensationType  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder compensationType(String compensationType) {
            this.compensationType = compensationType;
            return this;
        }
        
        /**
         * Set amount
         * @param amount  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder amount(Integer amount) {
            this.amount = amount;
            return this;
        }
        
        /**
         * Set unit
         * @param unit  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder unit(String unit) {
            this.unit = unit;
            return this;
        }
        
        /**
         * Set syncWithSupplements
         * @param syncWithSupplements  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder syncWithSupplements(Boolean syncWithSupplements) {
            this.syncWithSupplements = syncWithSupplements;
            return this;
        }
        
        /**
         * Set payrollPolicyId
         * @param payrollPolicyId  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder payrollPolicyId(Integer payrollPolicyId) {
            this.payrollPolicyId = payrollPolicyId;
            return this;
        }
        
        /**
         * Set recurrenceCount
         * @param recurrenceCount  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder recurrenceCount(Integer recurrenceCount) {
            this.recurrenceCount = recurrenceCount;
            return this;
        }
        
        /**
         * Set startsOn
         * @param startsOn  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder startsOn(String startsOn) {
            this.startsOn = startsOn;
            return this;
        }
        
        /**
         * Set recurrence
         * @param recurrence  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder recurrence(String recurrence) {
            this.recurrence = recurrence;
            return this;
        }
        
        /**
         * Set firstPaymentOn
         * @param firstPaymentOn  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder firstPaymentOn(String firstPaymentOn) {
            this.firstPaymentOn = firstPaymentOn;
            return this;
        }
        
        /**
         * Set calculation
         * @param calculation  (optional)
         * @return CreateContractCompensationRequestBuilder
         */
        public CreateContractCompensationRequestBuilder calculation(String calculation) {
            this.calculation = calculation;
            return this;
        }
        
        /**
         * Build call for createContractCompensation
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
            CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest = buildBodyParams();
            return createContractCompensationCall(compensationCreateContractCompensationRequest, _callback);
        }

        private CompensationCreateContractCompensationRequest buildBodyParams() {
            CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest = new CompensationCreateContractCompensationRequest();
            compensationCreateContractCompensationRequest.description(this.description);
            compensationCreateContractCompensationRequest.contractVersionId(this.contractVersionId);
            compensationCreateContractCompensationRequest.contractsTaxonomyId(this.contractsTaxonomyId);
            if (this.compensationType != null)
            compensationCreateContractCompensationRequest.compensationType(CompensationCreateContractCompensationRequest.CompensationTypeEnum.fromValue(this.compensationType));
            compensationCreateContractCompensationRequest.amount(this.amount);
            if (this.unit != null)
            compensationCreateContractCompensationRequest.unit(CompensationCreateContractCompensationRequest.UnitEnum.fromValue(this.unit));
            compensationCreateContractCompensationRequest.syncWithSupplements(this.syncWithSupplements);
            compensationCreateContractCompensationRequest.payrollPolicyId(this.payrollPolicyId);
            compensationCreateContractCompensationRequest.recurrenceCount(this.recurrenceCount);
            compensationCreateContractCompensationRequest.startsOn(this.startsOn);
            if (this.recurrence != null)
            compensationCreateContractCompensationRequest.recurrence(CompensationCreateContractCompensationRequest.RecurrenceEnum.fromValue(this.recurrence));
            compensationCreateContractCompensationRequest.firstPaymentOn(this.firstPaymentOn);
            if (this.calculation != null)
            compensationCreateContractCompensationRequest.calculation(CompensationCreateContractCompensationRequest.CalculationEnum.fromValue(this.calculation));
            return compensationCreateContractCompensationRequest;
        }

        /**
         * Execute createContractCompensation request
         * @return Compensation
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public Compensation execute() throws ApiException {
            CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest = buildBodyParams();
            ApiResponse<Compensation> localVarResp = createContractCompensationWithHttpInfo(compensationCreateContractCompensationRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createContractCompensation request with HTTP info returned
         * @return ApiResponse&lt;Compensation&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Compensation> executeWithHttpInfo() throws ApiException {
            CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest = buildBodyParams();
            return createContractCompensationWithHttpInfo(compensationCreateContractCompensationRequest);
        }

        /**
         * Execute createContractCompensation request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Compensation> _callback) throws ApiException {
            CompensationCreateContractCompensationRequest compensationCreateContractCompensationRequest = buildBodyParams();
            return createContractCompensationAsync(compensationCreateContractCompensationRequest, _callback);
        }
    }

    /**
     * Create a compensation
     * Creates a compensation for a contract.
     * @return CreateContractCompensationRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateContractCompensationRequestBuilder createContractCompensation(Integer contractVersionId) throws IllegalArgumentException {
        if (contractVersionId == null) throw new IllegalArgumentException("\"contractVersionId\" is required but got null");
        return new CreateContractCompensationRequestBuilder(contractVersionId);
    }
    private okhttp3.Call deleteCompensationCall(Integer id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payroll/compensations/{id}"
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
    private okhttp3.Call deleteCompensationValidateBeforeCall(Integer id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteCompensation(Async)");
        }

        return deleteCompensationCall(id, _callback);

    }


    private ApiResponse<List<Compensation>> deleteCompensationWithHttpInfo(Integer id) throws ApiException {
        okhttp3.Call localVarCall = deleteCompensationValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<List<Compensation>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteCompensationAsync(Integer id, final ApiCallback<List<Compensation>> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteCompensationValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<List<Compensation>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteCompensationRequestBuilder {
        private final Integer id;

        private DeleteCompensationRequestBuilder(Integer id) {
            this.id = id;
        }

        /**
         * Build call for deleteCompensation
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
            return deleteCompensationCall(id, _callback);
        }


        /**
         * Execute deleteCompensation request
         * @return List&lt;Compensation&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Compensation> execute() throws ApiException {
            ApiResponse<List<Compensation>> localVarResp = deleteCompensationWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteCompensation request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Compensation&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Compensation>> executeWithHttpInfo() throws ApiException {
            return deleteCompensationWithHttpInfo(id);
        }

        /**
         * Execute deleteCompensation request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Compensation>> _callback) throws ApiException {
            return deleteCompensationAsync(id, _callback);
        }
    }

    /**
     * Delete a Compensation
     * Delete a compensation
     * @param id (Required) (required)
     * @return DeleteCompensationRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteCompensationRequestBuilder deleteCompensation(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new DeleteCompensationRequestBuilder(id);
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
        String localVarPath = "/v1/payroll/compensations/{id}"
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


    private ApiResponse<Compensation> getByIdWithHttpInfo(Integer id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Compensation>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(Integer id, final ApiCallback<Compensation> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Compensation>(){}.getType();
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
         * @return Compensation
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Compensation execute() throws ApiException {
            ApiResponse<Compensation> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;Compensation&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Compensation> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Compensation> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get a compensation
     * This endpoint allows you to retrieve a compensation by id
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
    private okhttp3.Call getCompensationsCall(List<Integer> ids, List<Integer> contractVersionIds, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payroll/compensations";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (ids != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "ids", ids));
        }

        if (contractVersionIds != null) {
            localVarCollectionQueryParams.addAll(localVarApiClient.parameterToPairs("multi", "contract_version_ids", contractVersionIds));
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
    private okhttp3.Call getCompensationsValidateBeforeCall(List<Integer> ids, List<Integer> contractVersionIds, final ApiCallback _callback) throws ApiException {
        return getCompensationsCall(ids, contractVersionIds, _callback);

    }


    private ApiResponse<List<Compensation>> getCompensationsWithHttpInfo(List<Integer> ids, List<Integer> contractVersionIds) throws ApiException {
        okhttp3.Call localVarCall = getCompensationsValidateBeforeCall(ids, contractVersionIds, null);
        Type localVarReturnType = new TypeToken<List<Compensation>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getCompensationsAsync(List<Integer> ids, List<Integer> contractVersionIds, final ApiCallback<List<Compensation>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getCompensationsValidateBeforeCall(ids, contractVersionIds, _callback);
        Type localVarReturnType = new TypeToken<List<Compensation>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetCompensationsRequestBuilder {
        private List<Integer> ids;
        private List<Integer> contractVersionIds;

        private GetCompensationsRequestBuilder() {
        }

        /**
         * Set ids
         * @param ids Compensations id array (optional)
         * @return GetCompensationsRequestBuilder
         */
        public GetCompensationsRequestBuilder ids(List<Integer> ids) {
            this.ids = ids;
            return this;
        }
        
        /**
         * Set contractVersionIds
         * @param contractVersionIds Contract versions id array (optional)
         * @return GetCompensationsRequestBuilder
         */
        public GetCompensationsRequestBuilder contractVersionIds(List<Integer> contractVersionIds) {
            this.contractVersionIds = contractVersionIds;
            return this;
        }
        
        /**
         * Build call for getCompensations
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
            return getCompensationsCall(ids, contractVersionIds, _callback);
        }


        /**
         * Execute getCompensations request
         * @return List&lt;Compensation&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Compensation> execute() throws ApiException {
            ApiResponse<List<Compensation>> localVarResp = getCompensationsWithHttpInfo(ids, contractVersionIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getCompensations request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Compensation&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Compensation>> executeWithHttpInfo() throws ApiException {
            return getCompensationsWithHttpInfo(ids, contractVersionIds);
        }

        /**
         * Execute getCompensations request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Compensation>> _callback) throws ApiException {
            return getCompensationsAsync(ids, contractVersionIds, _callback);
        }
    }

    /**
     * Get Compensations
     * This endpoint allows you to retrieve compensations for a company
     * @return GetCompensationsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetCompensationsRequestBuilder getCompensations() throws IllegalArgumentException {
        return new GetCompensationsRequestBuilder();
    }
    private okhttp3.Call updateForContractCall(Integer id, CompensationUpdateForContractRequest compensationUpdateForContractRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = compensationUpdateForContractRequest;

        // create path and map variables
        String localVarPath = "/v1/payroll/compensations/{id}"
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
    private okhttp3.Call updateForContractValidateBeforeCall(Integer id, CompensationUpdateForContractRequest compensationUpdateForContractRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateForContract(Async)");
        }

        return updateForContractCall(id, compensationUpdateForContractRequest, _callback);

    }


    private ApiResponse<Compensation> updateForContractWithHttpInfo(Integer id, CompensationUpdateForContractRequest compensationUpdateForContractRequest) throws ApiException {
        okhttp3.Call localVarCall = updateForContractValidateBeforeCall(id, compensationUpdateForContractRequest, null);
        Type localVarReturnType = new TypeToken<Compensation>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateForContractAsync(Integer id, CompensationUpdateForContractRequest compensationUpdateForContractRequest, final ApiCallback<Compensation> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateForContractValidateBeforeCall(id, compensationUpdateForContractRequest, _callback);
        Type localVarReturnType = new TypeToken<Compensation>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateForContractRequestBuilder {
        private final Integer id;
        private String description;
        private Integer contractsTaxonomyId;
        private String compensationType;
        private Integer amount;
        private String unit;
        private Boolean syncWithSupplements;
        private Integer payrollPolicyId;
        private Integer recurrenceCount;
        private String startsOn;
        private String recurrence;
        private String firstPaymentOn;
        private String calculation;

        private UpdateForContractRequestBuilder(Integer id) {
            this.id = id;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set contractsTaxonomyId
         * @param contractsTaxonomyId  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder contractsTaxonomyId(Integer contractsTaxonomyId) {
            this.contractsTaxonomyId = contractsTaxonomyId;
            return this;
        }
        
        /**
         * Set compensationType
         * @param compensationType  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder compensationType(String compensationType) {
            this.compensationType = compensationType;
            return this;
        }
        
        /**
         * Set amount
         * @param amount  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder amount(Integer amount) {
            this.amount = amount;
            return this;
        }
        
        /**
         * Set unit
         * @param unit  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder unit(String unit) {
            this.unit = unit;
            return this;
        }
        
        /**
         * Set syncWithSupplements
         * @param syncWithSupplements  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder syncWithSupplements(Boolean syncWithSupplements) {
            this.syncWithSupplements = syncWithSupplements;
            return this;
        }
        
        /**
         * Set payrollPolicyId
         * @param payrollPolicyId  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder payrollPolicyId(Integer payrollPolicyId) {
            this.payrollPolicyId = payrollPolicyId;
            return this;
        }
        
        /**
         * Set recurrenceCount
         * @param recurrenceCount  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder recurrenceCount(Integer recurrenceCount) {
            this.recurrenceCount = recurrenceCount;
            return this;
        }
        
        /**
         * Set startsOn
         * @param startsOn  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder startsOn(String startsOn) {
            this.startsOn = startsOn;
            return this;
        }
        
        /**
         * Set recurrence
         * @param recurrence  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder recurrence(String recurrence) {
            this.recurrence = recurrence;
            return this;
        }
        
        /**
         * Set firstPaymentOn
         * @param firstPaymentOn  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder firstPaymentOn(String firstPaymentOn) {
            this.firstPaymentOn = firstPaymentOn;
            return this;
        }
        
        /**
         * Set calculation
         * @param calculation  (optional)
         * @return UpdateForContractRequestBuilder
         */
        public UpdateForContractRequestBuilder calculation(String calculation) {
            this.calculation = calculation;
            return this;
        }
        
        /**
         * Build call for updateForContract
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
            CompensationUpdateForContractRequest compensationUpdateForContractRequest = buildBodyParams();
            return updateForContractCall(id, compensationUpdateForContractRequest, _callback);
        }

        private CompensationUpdateForContractRequest buildBodyParams() {
            CompensationUpdateForContractRequest compensationUpdateForContractRequest = new CompensationUpdateForContractRequest();
            compensationUpdateForContractRequest.description(this.description);
            compensationUpdateForContractRequest.contractsTaxonomyId(this.contractsTaxonomyId);
            if (this.compensationType != null)
            compensationUpdateForContractRequest.compensationType(CompensationUpdateForContractRequest.CompensationTypeEnum.fromValue(this.compensationType));
            compensationUpdateForContractRequest.amount(this.amount);
            if (this.unit != null)
            compensationUpdateForContractRequest.unit(CompensationUpdateForContractRequest.UnitEnum.fromValue(this.unit));
            compensationUpdateForContractRequest.syncWithSupplements(this.syncWithSupplements);
            compensationUpdateForContractRequest.payrollPolicyId(this.payrollPolicyId);
            compensationUpdateForContractRequest.recurrenceCount(this.recurrenceCount);
            compensationUpdateForContractRequest.startsOn(this.startsOn);
            if (this.recurrence != null)
            compensationUpdateForContractRequest.recurrence(CompensationUpdateForContractRequest.RecurrenceEnum.fromValue(this.recurrence));
            compensationUpdateForContractRequest.firstPaymentOn(this.firstPaymentOn);
            if (this.calculation != null)
            compensationUpdateForContractRequest.calculation(CompensationUpdateForContractRequest.CalculationEnum.fromValue(this.calculation));
            return compensationUpdateForContractRequest;
        }

        /**
         * Execute updateForContract request
         * @return Compensation
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Compensation execute() throws ApiException {
            CompensationUpdateForContractRequest compensationUpdateForContractRequest = buildBodyParams();
            ApiResponse<Compensation> localVarResp = updateForContractWithHttpInfo(id, compensationUpdateForContractRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateForContract request with HTTP info returned
         * @return ApiResponse&lt;Compensation&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Compensation> executeWithHttpInfo() throws ApiException {
            CompensationUpdateForContractRequest compensationUpdateForContractRequest = buildBodyParams();
            return updateForContractWithHttpInfo(id, compensationUpdateForContractRequest);
        }

        /**
         * Execute updateForContract request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Compensation> _callback) throws ApiException {
            CompensationUpdateForContractRequest compensationUpdateForContractRequest = buildBodyParams();
            return updateForContractAsync(id, compensationUpdateForContractRequest, _callback);
        }
    }

    /**
     * Updates a compensation
     * Updates a compensation for a contract.
     * @param id  (required)
     * @return UpdateForContractRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateForContractRequestBuilder updateForContract(Integer id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        return new UpdateForContractRequestBuilder(id);
    }
}
