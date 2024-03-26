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


import com.konfigthis.client.model.ContractUpdateVersionRequest;
import com.konfigthis.client.model.ContractVersion;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ContractApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ContractApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public ContractApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call deleteVersionCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payroll/contract_versions/{id}"
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
    private okhttp3.Call deleteVersionValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling deleteVersion(Async)");
        }

        return deleteVersionCall(id, _callback);

    }


    private ApiResponse<ContractVersion> deleteVersionWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = deleteVersionValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<ContractVersion>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call deleteVersionAsync(String id, final ApiCallback<ContractVersion> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteVersionValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<ContractVersion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DeleteVersionRequestBuilder {
        private final String id;

        private DeleteVersionRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for deleteVersion
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
            return deleteVersionCall(id, _callback);
        }


        /**
         * Execute deleteVersion request
         * @return ContractVersion
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ContractVersion execute() throws ApiException {
            ApiResponse<ContractVersion> localVarResp = deleteVersionWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute deleteVersion request with HTTP info returned
         * @return ApiResponse&lt;ContractVersion&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ContractVersion> executeWithHttpInfo() throws ApiException {
            return deleteVersionWithHttpInfo(id);
        }

        /**
         * Execute deleteVersion request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ContractVersion> _callback) throws ApiException {
            return deleteVersionAsync(id, _callback);
        }
    }

    /**
     * Delete contract version
     * Delete contract Version
     * @param id (Required) (required)
     * @return DeleteVersionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public DeleteVersionRequestBuilder deleteVersion(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DeleteVersionRequestBuilder(id);
    }
    private okhttp3.Call getAllReferenceContractsCall(List<Integer> employeeIds, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/payroll/reference_contracts";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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
    private okhttp3.Call getAllReferenceContractsValidateBeforeCall(List<Integer> employeeIds, final ApiCallback _callback) throws ApiException {
        return getAllReferenceContractsCall(employeeIds, _callback);

    }


    private ApiResponse<List<ContractVersion>> getAllReferenceContractsWithHttpInfo(List<Integer> employeeIds) throws ApiException {
        okhttp3.Call localVarCall = getAllReferenceContractsValidateBeforeCall(employeeIds, null);
        Type localVarReturnType = new TypeToken<List<ContractVersion>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllReferenceContractsAsync(List<Integer> employeeIds, final ApiCallback<List<ContractVersion>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllReferenceContractsValidateBeforeCall(employeeIds, _callback);
        Type localVarReturnType = new TypeToken<List<ContractVersion>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllReferenceContractsRequestBuilder {
        private List<Integer> employeeIds;

        private GetAllReferenceContractsRequestBuilder() {
        }

        /**
         * Set employeeIds
         * @param employeeIds Employees id array (optional)
         * @return GetAllReferenceContractsRequestBuilder
         */
        public GetAllReferenceContractsRequestBuilder employeeIds(List<Integer> employeeIds) {
            this.employeeIds = employeeIds;
            return this;
        }
        
        /**
         * Build call for getAllReferenceContracts
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
            return getAllReferenceContractsCall(employeeIds, _callback);
        }


        /**
         * Execute getAllReferenceContracts request
         * @return List&lt;ContractVersion&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<ContractVersion> execute() throws ApiException {
            ApiResponse<List<ContractVersion>> localVarResp = getAllReferenceContractsWithHttpInfo(employeeIds);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAllReferenceContracts request with HTTP info returned
         * @return ApiResponse&lt;List&lt;ContractVersion&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<ContractVersion>> executeWithHttpInfo() throws ApiException {
            return getAllReferenceContractsWithHttpInfo(employeeIds);
        }

        /**
         * Execute getAllReferenceContracts request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<ContractVersion>> _callback) throws ApiException {
            return getAllReferenceContractsAsync(employeeIds, _callback);
        }
    }

    /**
     * Get all reference contracts
     * The reference contract is the contract that applies today. If no contract applies today, we will return the nearest upcoming contract. If there are no upcoming contracts, we will provide the most recent past contract.
     * @return GetAllReferenceContractsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetAllReferenceContractsRequestBuilder getAllReferenceContracts() throws IllegalArgumentException {
        return new GetAllReferenceContractsRequestBuilder();
    }
    private okhttp3.Call updateVersionCall(String id, ContractUpdateVersionRequest contractUpdateVersionRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = contractUpdateVersionRequest;

        // create path and map variables
        String localVarPath = "/v1/payroll/contract_versions/{id}"
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
    private okhttp3.Call updateVersionValidateBeforeCall(String id, ContractUpdateVersionRequest contractUpdateVersionRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateVersion(Async)");
        }

        return updateVersionCall(id, contractUpdateVersionRequest, _callback);

    }


    private ApiResponse<ContractVersion> updateVersionWithHttpInfo(String id, ContractUpdateVersionRequest contractUpdateVersionRequest) throws ApiException {
        okhttp3.Call localVarCall = updateVersionValidateBeforeCall(id, contractUpdateVersionRequest, null);
        Type localVarReturnType = new TypeToken<ContractVersion>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateVersionAsync(String id, ContractUpdateVersionRequest contractUpdateVersionRequest, final ApiCallback<ContractVersion> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateVersionValidateBeforeCall(id, contractUpdateVersionRequest, _callback);
        Type localVarReturnType = new TypeToken<ContractVersion>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateVersionRequestBuilder {
        private final String effectiveOn;
        private final String id;
        private Integer employeeId;
        private String startsOn;
        private String endsOn;
        private String workingHoursFrequency;
        private String workingWeekDays;
        private Integer workingHours;
        private String salaryFrequency;
        private Integer salaryAmount;
        private String jobTitle;
        private Integer esCotizationGroup;
        private Integer esProfessionalCategoryId;
        private Integer esEducationLevelId;
        private Integer esContractTypeId;

        private UpdateVersionRequestBuilder(String effectiveOn, String id) {
            this.effectiveOn = effectiveOn;
            this.id = id;
        }

        /**
         * Set employeeId
         * @param employeeId  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder employeeId(Integer employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        
        /**
         * Set startsOn
         * @param startsOn  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder startsOn(String startsOn) {
            this.startsOn = startsOn;
            return this;
        }
        
        /**
         * Set endsOn
         * @param endsOn  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder endsOn(String endsOn) {
            this.endsOn = endsOn;
            return this;
        }
        
        /**
         * Set workingHoursFrequency
         * @param workingHoursFrequency  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder workingHoursFrequency(String workingHoursFrequency) {
            this.workingHoursFrequency = workingHoursFrequency;
            return this;
        }
        
        /**
         * Set workingWeekDays
         * @param workingWeekDays  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder workingWeekDays(String workingWeekDays) {
            this.workingWeekDays = workingWeekDays;
            return this;
        }
        
        /**
         * Set workingHours
         * @param workingHours  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder workingHours(Integer workingHours) {
            this.workingHours = workingHours;
            return this;
        }
        
        /**
         * Set salaryFrequency
         * @param salaryFrequency  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder salaryFrequency(String salaryFrequency) {
            this.salaryFrequency = salaryFrequency;
            return this;
        }
        
        /**
         * Set salaryAmount
         * @param salaryAmount  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder salaryAmount(Integer salaryAmount) {
            this.salaryAmount = salaryAmount;
            return this;
        }
        
        /**
         * Set jobTitle
         * @param jobTitle  (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder jobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
            return this;
        }
        
        /**
         * Set esCotizationGroup
         * @param esCotizationGroup the cotization group id for Spain contracts (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder esCotizationGroup(Integer esCotizationGroup) {
            this.esCotizationGroup = esCotizationGroup;
            return this;
        }
        
        /**
         * Set esProfessionalCategoryId
         * @param esProfessionalCategoryId the professional category id for Spain contracts (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder esProfessionalCategoryId(Integer esProfessionalCategoryId) {
            this.esProfessionalCategoryId = esProfessionalCategoryId;
            return this;
        }
        
        /**
         * Set esEducationLevelId
         * @param esEducationLevelId the education level id for Spain contracts (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder esEducationLevelId(Integer esEducationLevelId) {
            this.esEducationLevelId = esEducationLevelId;
            return this;
        }
        
        /**
         * Set esContractTypeId
         * @param esContractTypeId the contract type id for Spain contracts (optional)
         * @return UpdateVersionRequestBuilder
         */
        public UpdateVersionRequestBuilder esContractTypeId(Integer esContractTypeId) {
            this.esContractTypeId = esContractTypeId;
            return this;
        }
        
        /**
         * Build call for updateVersion
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
            ContractUpdateVersionRequest contractUpdateVersionRequest = buildBodyParams();
            return updateVersionCall(id, contractUpdateVersionRequest, _callback);
        }

        private ContractUpdateVersionRequest buildBodyParams() {
            ContractUpdateVersionRequest contractUpdateVersionRequest = new ContractUpdateVersionRequest();
            contractUpdateVersionRequest.effectiveOn(this.effectiveOn);
            contractUpdateVersionRequest.employeeId(this.employeeId);
            contractUpdateVersionRequest.startsOn(this.startsOn);
            contractUpdateVersionRequest.endsOn(this.endsOn);
            if (this.workingHoursFrequency != null)
            contractUpdateVersionRequest.workingHoursFrequency(ContractUpdateVersionRequest.WorkingHoursFrequencyEnum.fromValue(this.workingHoursFrequency));
            contractUpdateVersionRequest.workingWeekDays(this.workingWeekDays);
            contractUpdateVersionRequest.workingHours(this.workingHours);
            if (this.salaryFrequency != null)
            contractUpdateVersionRequest.salaryFrequency(ContractUpdateVersionRequest.SalaryFrequencyEnum.fromValue(this.salaryFrequency));
            contractUpdateVersionRequest.salaryAmount(this.salaryAmount);
            contractUpdateVersionRequest.jobTitle(this.jobTitle);
            contractUpdateVersionRequest.esCotizationGroup(this.esCotizationGroup);
            contractUpdateVersionRequest.esProfessionalCategoryId(this.esProfessionalCategoryId);
            contractUpdateVersionRequest.esEducationLevelId(this.esEducationLevelId);
            contractUpdateVersionRequest.esContractTypeId(this.esContractTypeId);
            return contractUpdateVersionRequest;
        }

        /**
         * Execute updateVersion request
         * @return ContractVersion
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ContractVersion execute() throws ApiException {
            ContractUpdateVersionRequest contractUpdateVersionRequest = buildBodyParams();
            ApiResponse<ContractVersion> localVarResp = updateVersionWithHttpInfo(id, contractUpdateVersionRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateVersion request with HTTP info returned
         * @return ApiResponse&lt;ContractVersion&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<ContractVersion> executeWithHttpInfo() throws ApiException {
            ContractUpdateVersionRequest contractUpdateVersionRequest = buildBodyParams();
            return updateVersionWithHttpInfo(id, contractUpdateVersionRequest);
        }

        /**
         * Execute updateVersion request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<ContractVersion> _callback) throws ApiException {
            ContractUpdateVersionRequest contractUpdateVersionRequest = buildBodyParams();
            return updateVersionAsync(id, contractUpdateVersionRequest, _callback);
        }
    }

    /**
     * Update contract version
     * Update contract Version
     * @param id (Required) (required)
     * @return UpdateVersionRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateVersionRequestBuilder updateVersion(String effectiveOn, String id) throws IllegalArgumentException {
        if (effectiveOn == null) throw new IllegalArgumentException("\"effectiveOn\" is required but got null");
            

        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateVersionRequestBuilder(effectiveOn, id);
    }
}
