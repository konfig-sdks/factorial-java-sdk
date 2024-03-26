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


import com.konfigthis.client.model.ApplicationCreateAtsApplicationRequest;
import com.konfigthis.client.model.ApplicationCreateAtsApplicationRequestAnswersInner;
import com.konfigthis.client.model.ApplicationUpdateDataRequest;
import com.konfigthis.client.model.AtsApplication;
import java.io.File;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class ApplicationApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public ApplicationApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public ApplicationApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call createAtsApplicationCall(Integer atsJobPostingId, String source, String medium, Integer atsCandidateId, String coverLetter, String firstName, String lastName, String phone, String email, File cv, File photo, List<ApplicationCreateAtsApplicationRequestAnswersInner> answers, ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = applicationCreateAtsApplicationRequest;

        // create path and map variables
        String localVarPath = "/v1/ats/applications";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (atsJobPostingId != null) {
            localVarFormParams.put("ats_job_posting_id", atsJobPostingId);
        }

        if (source != null) {
            localVarFormParams.put("source", source);
        }

        if (medium != null) {
            localVarFormParams.put("medium", medium);
        }

        if (atsCandidateId != null) {
            localVarFormParams.put("ats_candidate_id", atsCandidateId);
        }

        if (coverLetter != null) {
            localVarFormParams.put("cover_letter", coverLetter);
        }

        if (firstName != null) {
            localVarFormParams.put("first_name", firstName);
        }

        if (lastName != null) {
            localVarFormParams.put("last_name", lastName);
        }

        if (phone != null) {
            localVarFormParams.put("phone", phone);
        }

        if (email != null) {
            localVarFormParams.put("email", email);
        }

        if (cv != null) {
            localVarFormParams.put("cv", cv);
        }

        if (photo != null) {
            localVarFormParams.put("photo", photo);
        }

        if (answers != null) {
            localVarFormParams.put("answers", answers);
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            "multipart/form-data"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] { "apikey" };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call createAtsApplicationValidateBeforeCall(Integer atsJobPostingId, String source, String medium, Integer atsCandidateId, String coverLetter, String firstName, String lastName, String phone, String email, File cv, File photo, List<ApplicationCreateAtsApplicationRequestAnswersInner> answers, ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'atsJobPostingId' is set
        if (atsJobPostingId == null) {
            throw new ApiException("Missing the required parameter 'atsJobPostingId' when calling createAtsApplication(Async)");
        }

        // verify the required parameter 'source' is set
        if (source == null) {
            throw new ApiException("Missing the required parameter 'source' when calling createAtsApplication(Async)");
        }

        return createAtsApplicationCall(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest, _callback);

    }


    private ApiResponse<AtsApplication> createAtsApplicationWithHttpInfo(Integer atsJobPostingId, String source, String medium, Integer atsCandidateId, String coverLetter, String firstName, String lastName, String phone, String email, File cv, File photo, List<ApplicationCreateAtsApplicationRequestAnswersInner> answers, ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest) throws ApiException {
        okhttp3.Call localVarCall = createAtsApplicationValidateBeforeCall(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest, null);
        Type localVarReturnType = new TypeToken<AtsApplication>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createAtsApplicationAsync(Integer atsJobPostingId, String source, String medium, Integer atsCandidateId, String coverLetter, String firstName, String lastName, String phone, String email, File cv, File photo, List<ApplicationCreateAtsApplicationRequestAnswersInner> answers, ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest, final ApiCallback<AtsApplication> _callback) throws ApiException {

        okhttp3.Call localVarCall = createAtsApplicationValidateBeforeCall(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest, _callback);
        Type localVarReturnType = new TypeToken<AtsApplication>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateAtsApplicationRequestBuilder {
        private final Integer atsJobPostingId;
        private final String source;
        private String medium;
        private Integer atsCandidateId;
        private String coverLetter;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private File cv;
        private File photo;
        private List<ApplicationCreateAtsApplicationRequestAnswersInner> answers;

        private CreateAtsApplicationRequestBuilder(Integer atsJobPostingId, String source) {
            this.atsJobPostingId = atsJobPostingId;
            this.source = source;
        }

        /**
         * Set medium
         * @param medium  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder medium(String medium) {
            this.medium = medium;
            return this;
        }
        
        /**
         * Set atsCandidateId
         * @param atsCandidateId  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder atsCandidateId(Integer atsCandidateId) {
            this.atsCandidateId = atsCandidateId;
            return this;
        }
        
        /**
         * Set coverLetter
         * @param coverLetter  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder coverLetter(String coverLetter) {
            this.coverLetter = coverLetter;
            return this;
        }
        
        /**
         * Set firstName
         * @param firstName  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        /**
         * Set lastName
         * @param lastName  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        /**
         * Set phone
         * @param phone  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        /**
         * Set email
         * @param email  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        /**
         * Set cv
         * @param cv  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder cv(File cv) {
            this.cv = cv;
            return this;
        }
        
        /**
         * Set photo
         * @param photo  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder photo(File photo) {
            this.photo = photo;
            return this;
        }
        
        /**
         * Set answers
         * @param answers  (optional)
         * @return CreateAtsApplicationRequestBuilder
         */
        public CreateAtsApplicationRequestBuilder answers(List<ApplicationCreateAtsApplicationRequestAnswersInner> answers) {
            this.answers = answers;
            return this;
        }
        
        /**
         * Build call for createAtsApplication
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
            ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest = buildBodyParams();
            return createAtsApplicationCall(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest, _callback);
        }

        private ApplicationCreateAtsApplicationRequest buildBodyParams() {
            ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest = new ApplicationCreateAtsApplicationRequest();
            applicationCreateAtsApplicationRequest.atsJobPostingId(this.atsJobPostingId);
            if (this.source != null)
            applicationCreateAtsApplicationRequest.source(ApplicationCreateAtsApplicationRequest.SourceEnum.fromValue(this.source));
            applicationCreateAtsApplicationRequest.medium(this.medium);
            applicationCreateAtsApplicationRequest.atsCandidateId(this.atsCandidateId);
            applicationCreateAtsApplicationRequest.coverLetter(this.coverLetter);
            applicationCreateAtsApplicationRequest.firstName(this.firstName);
            applicationCreateAtsApplicationRequest.lastName(this.lastName);
            applicationCreateAtsApplicationRequest.phone(this.phone);
            applicationCreateAtsApplicationRequest.email(this.email);
            applicationCreateAtsApplicationRequest.cv(this.cv);
            applicationCreateAtsApplicationRequest.photo(this.photo);
            applicationCreateAtsApplicationRequest.answers(this.answers);
            return applicationCreateAtsApplicationRequest;
        }

        /**
         * Execute createAtsApplication request
         * @return AtsApplication
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public AtsApplication execute() throws ApiException {
            ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest = buildBodyParams();
            ApiResponse<AtsApplication> localVarResp = createAtsApplicationWithHttpInfo(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createAtsApplication request with HTTP info returned
         * @return ApiResponse&lt;AtsApplication&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsApplication> executeWithHttpInfo() throws ApiException {
            ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest = buildBodyParams();
            return createAtsApplicationWithHttpInfo(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest);
        }

        /**
         * Execute createAtsApplication request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsApplication> _callback) throws ApiException {
            ApplicationCreateAtsApplicationRequest applicationCreateAtsApplicationRequest = buildBodyParams();
            return createAtsApplicationAsync(atsJobPostingId, source, medium, atsCandidateId, coverLetter, firstName, lastName, phone, email, cv, photo, answers, applicationCreateAtsApplicationRequest, _callback);
        }
    }

    /**
     * Creates an application
     * This endpoint allows a consumer to create and store Ats Applications in Factorial
     * @param atsJobPostingId  (required)
     * @param source  (required)
     * @return CreateAtsApplicationRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public CreateAtsApplicationRequestBuilder createAtsApplication(Integer atsJobPostingId, String source) throws IllegalArgumentException {
        if (atsJobPostingId == null) throw new IllegalArgumentException("\"atsJobPostingId\" is required but got null");
        if (source == null) throw new IllegalArgumentException("\"source\" is required but got null");
            

        return new CreateAtsApplicationRequestBuilder(atsJobPostingId, source);
    }
    private okhttp3.Call updateDataCall(String id, ApplicationUpdateDataRequest applicationUpdateDataRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = applicationUpdateDataRequest;

        // create path and map variables
        String localVarPath = "/v1/ats/applications/{id}"
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
    private okhttp3.Call updateDataValidateBeforeCall(String id, ApplicationUpdateDataRequest applicationUpdateDataRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateData(Async)");
        }

        return updateDataCall(id, applicationUpdateDataRequest, _callback);

    }


    private ApiResponse<AtsApplication> updateDataWithHttpInfo(String id, ApplicationUpdateDataRequest applicationUpdateDataRequest) throws ApiException {
        okhttp3.Call localVarCall = updateDataValidateBeforeCall(id, applicationUpdateDataRequest, null);
        Type localVarReturnType = new TypeToken<AtsApplication>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateDataAsync(String id, ApplicationUpdateDataRequest applicationUpdateDataRequest, final ApiCallback<AtsApplication> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateDataValidateBeforeCall(id, applicationUpdateDataRequest, _callback);
        Type localVarReturnType = new TypeToken<AtsApplication>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateDataRequestBuilder {
        private final String id;
        private Integer atsApplicationPhaseId;
        private Boolean qualified;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private String personalUrl;
        private String disqualifiedReason;
        private File cv;
        private File photo;

        private UpdateDataRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set atsApplicationPhaseId
         * @param atsApplicationPhaseId  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder atsApplicationPhaseId(Integer atsApplicationPhaseId) {
            this.atsApplicationPhaseId = atsApplicationPhaseId;
            return this;
        }
        
        /**
         * Set qualified
         * @param qualified  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder qualified(Boolean qualified) {
            this.qualified = qualified;
            return this;
        }
        
        /**
         * Set firstName
         * @param firstName  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        /**
         * Set lastName
         * @param lastName  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        /**
         * Set phone
         * @param phone  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        
        /**
         * Set email
         * @param email  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder email(String email) {
            this.email = email;
            return this;
        }
        
        /**
         * Set personalUrl
         * @param personalUrl  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder personalUrl(String personalUrl) {
            this.personalUrl = personalUrl;
            return this;
        }
        
        /**
         * Set disqualifiedReason
         * @param disqualifiedReason  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder disqualifiedReason(String disqualifiedReason) {
            this.disqualifiedReason = disqualifiedReason;
            return this;
        }
        
        /**
         * Set cv
         * @param cv  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder cv(File cv) {
            this.cv = cv;
            return this;
        }
        
        /**
         * Set photo
         * @param photo  (optional)
         * @return UpdateDataRequestBuilder
         */
        public UpdateDataRequestBuilder photo(File photo) {
            this.photo = photo;
            return this;
        }
        
        /**
         * Build call for updateData
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
            ApplicationUpdateDataRequest applicationUpdateDataRequest = buildBodyParams();
            return updateDataCall(id, applicationUpdateDataRequest, _callback);
        }

        private ApplicationUpdateDataRequest buildBodyParams() {
            ApplicationUpdateDataRequest applicationUpdateDataRequest = new ApplicationUpdateDataRequest();
            applicationUpdateDataRequest.atsApplicationPhaseId(this.atsApplicationPhaseId);
            applicationUpdateDataRequest.qualified(this.qualified);
            applicationUpdateDataRequest.firstName(this.firstName);
            applicationUpdateDataRequest.lastName(this.lastName);
            applicationUpdateDataRequest.phone(this.phone);
            applicationUpdateDataRequest.email(this.email);
            applicationUpdateDataRequest.personalUrl(this.personalUrl);
            if (this.disqualifiedReason != null)
            applicationUpdateDataRequest.disqualifiedReason(ApplicationUpdateDataRequest.DisqualifiedReasonEnum.fromValue(this.disqualifiedReason));
            applicationUpdateDataRequest.cv(this.cv);
            applicationUpdateDataRequest.photo(this.photo);
            return applicationUpdateDataRequest;
        }

        /**
         * Execute updateData request
         * @return AtsApplication
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public AtsApplication execute() throws ApiException {
            ApplicationUpdateDataRequest applicationUpdateDataRequest = buildBodyParams();
            ApiResponse<AtsApplication> localVarResp = updateDataWithHttpInfo(id, applicationUpdateDataRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateData request with HTTP info returned
         * @return ApiResponse&lt;AtsApplication&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsApplication> executeWithHttpInfo() throws ApiException {
            ApplicationUpdateDataRequest applicationUpdateDataRequest = buildBodyParams();
            return updateDataWithHttpInfo(id, applicationUpdateDataRequest);
        }

        /**
         * Execute updateData request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsApplication> _callback) throws ApiException {
            ApplicationUpdateDataRequest applicationUpdateDataRequest = buildBodyParams();
            return updateDataAsync(id, applicationUpdateDataRequest, _callback);
        }
    }

    /**
     * Update application
     * Update ATS Application data
     * @param id (Required) (required)
     * @return UpdateDataRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateDataRequestBuilder updateData(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateDataRequestBuilder(id);
    }
}
