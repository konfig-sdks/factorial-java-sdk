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


import com.konfigthis.client.model.AtsJobPosting;
import java.io.File;
import com.konfigthis.client.model.Post;
import com.konfigthis.client.model.PostAtsJobPostingRequest;
import com.konfigthis.client.model.PostCreateNewPostRequest;
import com.konfigthis.client.model.PostJobPostingUpdateRequest;
import com.konfigthis.client.model.PostUpdateExistingPostRequest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class PostApiGenerated {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PostApiGenerated() throws IllegalArgumentException {
        this(Configuration.getDefaultApiClient());
    }

    public PostApiGenerated(ApiClient apiClient) throws IllegalArgumentException {
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

    private okhttp3.Call atsJobPostingCall(PostAtsJobPostingRequest postAtsJobPostingRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = postAtsJobPostingRequest;

        // create path and map variables
        String localVarPath = "/v1/ats/job_postings";

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
    private okhttp3.Call atsJobPostingValidateBeforeCall(PostAtsJobPostingRequest postAtsJobPostingRequest, final ApiCallback _callback) throws ApiException {
        return atsJobPostingCall(postAtsJobPostingRequest, _callback);

    }


    private ApiResponse<AtsJobPosting> atsJobPostingWithHttpInfo(PostAtsJobPostingRequest postAtsJobPostingRequest) throws ApiException {
        okhttp3.Call localVarCall = atsJobPostingValidateBeforeCall(postAtsJobPostingRequest, null);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call atsJobPostingAsync(PostAtsJobPostingRequest postAtsJobPostingRequest, final ApiCallback<AtsJobPosting> _callback) throws ApiException {

        okhttp3.Call localVarCall = atsJobPostingValidateBeforeCall(postAtsJobPostingRequest, _callback);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class AtsJobPostingRequestBuilder {
        private final String title;
        private final String status;
        private String description;
        private String contractType;
        private Boolean remote;
        private String scheduleType;
        private Integer teamId;
        private Integer locationId;
        private String salaryFormat;
        private Integer salaryFromAmountInCents;
        private Integer salaryToAmountInCents;
        private String cvRequirement;
        private String coverLetterRequirement;
        private String phoneRequirement;
        private String photoRequirement;

        private AtsJobPostingRequestBuilder(String title, String status) {
            this.title = title;
            this.status = status;
        }

        /**
         * Set description
         * @param description  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set contractType
         * @param contractType  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder contractType(String contractType) {
            this.contractType = contractType;
            return this;
        }
        
        /**
         * Set remote
         * @param remote  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder remote(Boolean remote) {
            this.remote = remote;
            return this;
        }
        
        /**
         * Set scheduleType
         * @param scheduleType  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder scheduleType(String scheduleType) {
            this.scheduleType = scheduleType;
            return this;
        }
        
        /**
         * Set teamId
         * @param teamId  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder teamId(Integer teamId) {
            this.teamId = teamId;
            return this;
        }
        
        /**
         * Set locationId
         * @param locationId  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder locationId(Integer locationId) {
            this.locationId = locationId;
            return this;
        }
        
        /**
         * Set salaryFormat
         * @param salaryFormat  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder salaryFormat(String salaryFormat) {
            this.salaryFormat = salaryFormat;
            return this;
        }
        
        /**
         * Set salaryFromAmountInCents
         * @param salaryFromAmountInCents  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder salaryFromAmountInCents(Integer salaryFromAmountInCents) {
            this.salaryFromAmountInCents = salaryFromAmountInCents;
            return this;
        }
        
        /**
         * Set salaryToAmountInCents
         * @param salaryToAmountInCents  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder salaryToAmountInCents(Integer salaryToAmountInCents) {
            this.salaryToAmountInCents = salaryToAmountInCents;
            return this;
        }
        
        /**
         * Set cvRequirement
         * @param cvRequirement  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder cvRequirement(String cvRequirement) {
            this.cvRequirement = cvRequirement;
            return this;
        }
        
        /**
         * Set coverLetterRequirement
         * @param coverLetterRequirement  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder coverLetterRequirement(String coverLetterRequirement) {
            this.coverLetterRequirement = coverLetterRequirement;
            return this;
        }
        
        /**
         * Set phoneRequirement
         * @param phoneRequirement  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder phoneRequirement(String phoneRequirement) {
            this.phoneRequirement = phoneRequirement;
            return this;
        }
        
        /**
         * Set photoRequirement
         * @param photoRequirement  (optional)
         * @return AtsJobPostingRequestBuilder
         */
        public AtsJobPostingRequestBuilder photoRequirement(String photoRequirement) {
            this.photoRequirement = photoRequirement;
            return this;
        }
        
        /**
         * Build call for atsJobPosting
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
            PostAtsJobPostingRequest postAtsJobPostingRequest = buildBodyParams();
            return atsJobPostingCall(postAtsJobPostingRequest, _callback);
        }

        private PostAtsJobPostingRequest buildBodyParams() {
            PostAtsJobPostingRequest postAtsJobPostingRequest = new PostAtsJobPostingRequest();
            postAtsJobPostingRequest.title(this.title);
            postAtsJobPostingRequest.description(this.description);
            if (this.contractType != null)
            postAtsJobPostingRequest.contractType(PostAtsJobPostingRequest.ContractTypeEnum.fromValue(this.contractType));
            postAtsJobPostingRequest.remote(this.remote);
            if (this.status != null)
            postAtsJobPostingRequest.status(PostAtsJobPostingRequest.StatusEnum.fromValue(this.status));
            if (this.scheduleType != null)
            postAtsJobPostingRequest.scheduleType(PostAtsJobPostingRequest.ScheduleTypeEnum.fromValue(this.scheduleType));
            postAtsJobPostingRequest.teamId(this.teamId);
            postAtsJobPostingRequest.locationId(this.locationId);
            if (this.salaryFormat != null)
            postAtsJobPostingRequest.salaryFormat(PostAtsJobPostingRequest.SalaryFormatEnum.fromValue(this.salaryFormat));
            postAtsJobPostingRequest.salaryFromAmountInCents(this.salaryFromAmountInCents);
            postAtsJobPostingRequest.salaryToAmountInCents(this.salaryToAmountInCents);
            if (this.cvRequirement != null)
            postAtsJobPostingRequest.cvRequirement(PostAtsJobPostingRequest.CvRequirementEnum.fromValue(this.cvRequirement));
            if (this.coverLetterRequirement != null)
            postAtsJobPostingRequest.coverLetterRequirement(PostAtsJobPostingRequest.CoverLetterRequirementEnum.fromValue(this.coverLetterRequirement));
            if (this.phoneRequirement != null)
            postAtsJobPostingRequest.phoneRequirement(PostAtsJobPostingRequest.PhoneRequirementEnum.fromValue(this.phoneRequirement));
            if (this.photoRequirement != null)
            postAtsJobPostingRequest.photoRequirement(PostAtsJobPostingRequest.PhotoRequirementEnum.fromValue(this.photoRequirement));
            return postAtsJobPostingRequest;
        }

        /**
         * Execute atsJobPosting request
         * @return AtsJobPosting
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public AtsJobPosting execute() throws ApiException {
            PostAtsJobPostingRequest postAtsJobPostingRequest = buildBodyParams();
            ApiResponse<AtsJobPosting> localVarResp = atsJobPostingWithHttpInfo(postAtsJobPostingRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute atsJobPosting request with HTTP info returned
         * @return ApiResponse&lt;AtsJobPosting&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsJobPosting> executeWithHttpInfo() throws ApiException {
            PostAtsJobPostingRequest postAtsJobPostingRequest = buildBodyParams();
            return atsJobPostingWithHttpInfo(postAtsJobPostingRequest);
        }

        /**
         * Execute atsJobPosting request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsJobPosting> _callback) throws ApiException {
            PostAtsJobPostingRequest postAtsJobPostingRequest = buildBodyParams();
            return atsJobPostingAsync(postAtsJobPostingRequest, _callback);
        }
    }

    /**
     * Create a Job Posting
     * This endpoint allows you create and store Ats Job Postings in Factorial.
     * @return AtsJobPostingRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public AtsJobPostingRequestBuilder atsJobPosting(String title, String status) throws IllegalArgumentException {
        if (title == null) throw new IllegalArgumentException("\"title\" is required but got null");
            

        if (status == null) throw new IllegalArgumentException("\"status\" is required but got null");
            

        return new AtsJobPostingRequestBuilder(title, status);
    }
    private okhttp3.Call createNewPostCall(PostCreateNewPostRequest postCreateNewPostRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = postCreateNewPostRequest;

        // create path and map variables
        String localVarPath = "/v1/posts";

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
    private okhttp3.Call createNewPostValidateBeforeCall(PostCreateNewPostRequest postCreateNewPostRequest, final ApiCallback _callback) throws ApiException {
        return createNewPostCall(postCreateNewPostRequest, _callback);

    }


    private ApiResponse<List<Post>> createNewPostWithHttpInfo(PostCreateNewPostRequest postCreateNewPostRequest) throws ApiException {
        okhttp3.Call localVarCall = createNewPostValidateBeforeCall(postCreateNewPostRequest, null);
        Type localVarReturnType = new TypeToken<List<Post>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call createNewPostAsync(PostCreateNewPostRequest postCreateNewPostRequest, final ApiCallback<List<Post>> _callback) throws ApiException {

        okhttp3.Call localVarCall = createNewPostValidateBeforeCall(postCreateNewPostRequest, _callback);
        Type localVarReturnType = new TypeToken<List<Post>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class CreateNewPostRequestBuilder {
        private final String title;
        private final String description;
        private final Integer postsGroupId;
        private final String type;
        private final String publishedAt;
        private String starsAt;
        private String endsAt;
        private String location;
        private Integer targetId;
        private Boolean sendNotifications;
        private File image;
        private Boolean allowCommentsAndReactions;
        private File attachments;

        private CreateNewPostRequestBuilder(String title, String description, Integer postsGroupId, String type, String publishedAt) {
            this.title = title;
            this.description = description;
            this.postsGroupId = postsGroupId;
            this.type = type;
            this.publishedAt = publishedAt;
        }

        /**
         * Set starsAt
         * @param starsAt  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder starsAt(String starsAt) {
            this.starsAt = starsAt;
            return this;
        }
        
        /**
         * Set endsAt
         * @param endsAt  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder endsAt(String endsAt) {
            this.endsAt = endsAt;
            return this;
        }
        
        /**
         * Set location
         * @param location  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder location(String location) {
            this.location = location;
            return this;
        }
        
        /**
         * Set targetId
         * @param targetId  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder targetId(Integer targetId) {
            this.targetId = targetId;
            return this;
        }
        
        /**
         * Set sendNotifications
         * @param sendNotifications  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder sendNotifications(Boolean sendNotifications) {
            this.sendNotifications = sendNotifications;
            return this;
        }
        
        /**
         * Set image
         * @param image  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder image(File image) {
            this.image = image;
            return this;
        }
        
        /**
         * Set allowCommentsAndReactions
         * @param allowCommentsAndReactions  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder allowCommentsAndReactions(Boolean allowCommentsAndReactions) {
            this.allowCommentsAndReactions = allowCommentsAndReactions;
            return this;
        }
        
        /**
         * Set attachments
         * @param attachments  (optional)
         * @return CreateNewPostRequestBuilder
         */
        public CreateNewPostRequestBuilder attachments(File attachments) {
            this.attachments = attachments;
            return this;
        }
        
        /**
         * Build call for createNewPost
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
            PostCreateNewPostRequest postCreateNewPostRequest = buildBodyParams();
            return createNewPostCall(postCreateNewPostRequest, _callback);
        }

        private PostCreateNewPostRequest buildBodyParams() {
            PostCreateNewPostRequest postCreateNewPostRequest = new PostCreateNewPostRequest();
            postCreateNewPostRequest.title(this.title);
            postCreateNewPostRequest.description(this.description);
            postCreateNewPostRequest.postsGroupId(this.postsGroupId);
            if (this.type != null)
            postCreateNewPostRequest.type(PostCreateNewPostRequest.TypeEnum.fromValue(this.type));
            postCreateNewPostRequest.publishedAt(this.publishedAt);
            postCreateNewPostRequest.starsAt(this.starsAt);
            postCreateNewPostRequest.endsAt(this.endsAt);
            postCreateNewPostRequest.location(this.location);
            postCreateNewPostRequest.targetId(this.targetId);
            postCreateNewPostRequest.sendNotifications(this.sendNotifications);
            postCreateNewPostRequest.image(this.image);
            postCreateNewPostRequest.allowCommentsAndReactions(this.allowCommentsAndReactions);
            postCreateNewPostRequest.attachments(this.attachments);
            return postCreateNewPostRequest;
        }

        /**
         * Execute createNewPost request
         * @return List&lt;Post&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Post> execute() throws ApiException {
            PostCreateNewPostRequest postCreateNewPostRequest = buildBodyParams();
            ApiResponse<List<Post>> localVarResp = createNewPostWithHttpInfo(postCreateNewPostRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute createNewPost request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Post&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Post>> executeWithHttpInfo() throws ApiException {
            PostCreateNewPostRequest postCreateNewPostRequest = buildBodyParams();
            return createNewPostWithHttpInfo(postCreateNewPostRequest);
        }

        /**
         * Execute createNewPost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Post>> _callback) throws ApiException {
            PostCreateNewPostRequest postCreateNewPostRequest = buildBodyParams();
            return createNewPostAsync(postCreateNewPostRequest, _callback);
        }
    }

    /**
     * Create a Post
     * Create a Post
     * @return CreateNewPostRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public CreateNewPostRequestBuilder createNewPost(String title, String description, Integer postsGroupId, String type, String publishedAt) throws IllegalArgumentException {
        if (title == null) throw new IllegalArgumentException("\"title\" is required but got null");
            

        if (description == null) throw new IllegalArgumentException("\"description\" is required but got null");
            

        if (postsGroupId == null) throw new IllegalArgumentException("\"postsGroupId\" is required but got null");
        if (type == null) throw new IllegalArgumentException("\"type\" is required but got null");
            

        if (publishedAt == null) throw new IllegalArgumentException("\"publishedAt\" is required but got null");
            

        return new CreateNewPostRequestBuilder(title, description, postsGroupId, type, publishedAt);
    }
    private okhttp3.Call duplicateJobPostingCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/ats/job_postings/{id}/duplicate"
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
    private okhttp3.Call duplicateJobPostingValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling duplicateJobPosting(Async)");
        }

        return duplicateJobPostingCall(id, _callback);

    }


    private ApiResponse<AtsJobPosting> duplicateJobPostingWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = duplicateJobPostingValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call duplicateJobPostingAsync(String id, final ApiCallback<AtsJobPosting> _callback) throws ApiException {

        okhttp3.Call localVarCall = duplicateJobPostingValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class DuplicateJobPostingRequestBuilder {
        private final String id;

        private DuplicateJobPostingRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for duplicateJobPosting
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
            return duplicateJobPostingCall(id, _callback);
        }


        /**
         * Execute duplicateJobPosting request
         * @return AtsJobPosting
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public AtsJobPosting execute() throws ApiException {
            ApiResponse<AtsJobPosting> localVarResp = duplicateJobPostingWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute duplicateJobPosting request with HTTP info returned
         * @return ApiResponse&lt;AtsJobPosting&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsJobPosting> executeWithHttpInfo() throws ApiException {
            return duplicateJobPostingWithHttpInfo(id);
        }

        /**
         * Execute duplicateJobPosting request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsJobPosting> _callback) throws ApiException {
            return duplicateJobPostingAsync(id, _callback);
        }
    }

    /**
     * Duplicate a Job Posting
     * Make a duplicate of a job posting. The only parameter required for this operation is the id of the posting you wish to duplicate. One thing to note about this operation is that the id of the resulting posting will be different from the original, the title will have Copy appended to it, so if your origin title was Don&#39;t buy a the title of the duplicate will be Don&#39;t buy a Copy in addition to this, the status of the duplicate will default to draft. All this being said, kindly inspect the duplicate and ensure you get it into your desired state.
     * @param id (Required) (required)
     * @return DuplicateJobPostingRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 201 </td><td> Created </td><td>  -  </td></tr>
     </table>
     */
    public DuplicateJobPostingRequestBuilder duplicateJobPosting(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new DuplicateJobPostingRequestBuilder(id);
    }
    private okhttp3.Call getAllPostingsCall(String status, Integer teamId, String locationId, Integer legalEntityId, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/ats/job_postings";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (status != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("status", status));
        }

        if (teamId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("team_id", teamId));
        }

        if (locationId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("location_id", locationId));
        }

        if (legalEntityId != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("legal_entity_id", legalEntityId));
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
    private okhttp3.Call getAllPostingsValidateBeforeCall(String status, Integer teamId, String locationId, Integer legalEntityId, final ApiCallback _callback) throws ApiException {
        return getAllPostingsCall(status, teamId, locationId, legalEntityId, _callback);

    }


    private ApiResponse<List<AtsJobPosting>> getAllPostingsWithHttpInfo(String status, Integer teamId, String locationId, Integer legalEntityId) throws ApiException {
        okhttp3.Call localVarCall = getAllPostingsValidateBeforeCall(status, teamId, locationId, legalEntityId, null);
        Type localVarReturnType = new TypeToken<List<AtsJobPosting>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getAllPostingsAsync(String status, Integer teamId, String locationId, Integer legalEntityId, final ApiCallback<List<AtsJobPosting>> _callback) throws ApiException {

        okhttp3.Call localVarCall = getAllPostingsValidateBeforeCall(status, teamId, locationId, legalEntityId, _callback);
        Type localVarReturnType = new TypeToken<List<AtsJobPosting>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class GetAllPostingsRequestBuilder {
        private String status;
        private Integer teamId;
        private String locationId;
        private Integer legalEntityId;

        private GetAllPostingsRequestBuilder() {
        }

        /**
         * Set status
         * @param status Job posting status (optional)
         * @return GetAllPostingsRequestBuilder
         */
        public GetAllPostingsRequestBuilder status(String status) {
            this.status = status;
            return this;
        }
        
        /**
         * Set teamId
         * @param teamId An id of any teams that the ats company has in Factorial (optional)
         * @return GetAllPostingsRequestBuilder
         */
        public GetAllPostingsRequestBuilder teamId(Integer teamId) {
            this.teamId = teamId;
            return this;
        }
        
        /**
         * Set locationId
         * @param locationId An id of any location associated with the ats company in Factorial (optional)
         * @return GetAllPostingsRequestBuilder
         */
        public GetAllPostingsRequestBuilder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        
        /**
         * Set legalEntityId
         * @param legalEntityId An id of any legal entity associated with the company in Factorial (optional)
         * @return GetAllPostingsRequestBuilder
         */
        public GetAllPostingsRequestBuilder legalEntityId(Integer legalEntityId) {
            this.legalEntityId = legalEntityId;
            return this;
        }
        
        /**
         * Build call for getAllPostings
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
            return getAllPostingsCall(status, teamId, locationId, legalEntityId, _callback);
        }


        /**
         * Execute getAllPostings request
         * @return List&lt;AtsJobPosting&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<AtsJobPosting> execute() throws ApiException {
            ApiResponse<List<AtsJobPosting>> localVarResp = getAllPostingsWithHttpInfo(status, teamId, locationId, legalEntityId);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getAllPostings request with HTTP info returned
         * @return ApiResponse&lt;List&lt;AtsJobPosting&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<AtsJobPosting>> executeWithHttpInfo() throws ApiException {
            return getAllPostingsWithHttpInfo(status, teamId, locationId, legalEntityId);
        }

        /**
         * Execute getAllPostings request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<AtsJobPosting>> _callback) throws ApiException {
            return getAllPostingsAsync(status, teamId, locationId, legalEntityId, _callback);
        }
    }

    /**
     * Get all job postings
     * This endpoint allows fetching all available Ats Job Postings, scoped to the user credentials and company of that user.
     * @return GetAllPostingsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public GetAllPostingsRequestBuilder getAllPostings() throws IllegalArgumentException {
        return new GetAllPostingsRequestBuilder();
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
        String localVarPath = "/v1/posts/{id}"
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

        String[] localVarAuthNames = new String[] { "oauth2" };
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


    private ApiResponse<Post> getByIdWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Post>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call getByIdAsync(String id, final ApiCallback<Post> _callback) throws ApiException {

        okhttp3.Call localVarCall = getByIdValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Post>(){}.getType();
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
         * @return Post
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Post execute() throws ApiException {
            ApiResponse<Post> localVarResp = getByIdWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute getById request with HTTP info returned
         * @return ApiResponse&lt;Post&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Post> executeWithHttpInfo() throws ApiException {
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
        public okhttp3.Call executeAsync(final ApiCallback<Post> _callback) throws ApiException {
            return getByIdAsync(id, _callback);
        }
    }

    /**
     * Get Post
     * 
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
    private okhttp3.Call jobPostingUpdateCall(String id, PostJobPostingUpdateRequest postJobPostingUpdateRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = postJobPostingUpdateRequest;

        // create path and map variables
        String localVarPath = "/v1/ats/job_postings/{id}"
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
    private okhttp3.Call jobPostingUpdateValidateBeforeCall(String id, PostJobPostingUpdateRequest postJobPostingUpdateRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling jobPostingUpdate(Async)");
        }

        return jobPostingUpdateCall(id, postJobPostingUpdateRequest, _callback);

    }


    private ApiResponse<AtsJobPosting> jobPostingUpdateWithHttpInfo(String id, PostJobPostingUpdateRequest postJobPostingUpdateRequest) throws ApiException {
        okhttp3.Call localVarCall = jobPostingUpdateValidateBeforeCall(id, postJobPostingUpdateRequest, null);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call jobPostingUpdateAsync(String id, PostJobPostingUpdateRequest postJobPostingUpdateRequest, final ApiCallback<AtsJobPosting> _callback) throws ApiException {

        okhttp3.Call localVarCall = jobPostingUpdateValidateBeforeCall(id, postJobPostingUpdateRequest, _callback);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class JobPostingUpdateRequestBuilder {
        private final String id;
        private String title;
        private String description;
        private String contractType;
        private Boolean remote;
        private String status;
        private String scheduleType;
        private Integer teamId;
        private Integer locationId;
        private String salaryFormat;
        private Integer salaryFromAmountInCents;
        private Integer salaryToAmountInCents;
        private String cvRequirement;
        private String coverLetterRequirement;
        private String phoneRequirement;
        private String photoRequirement;

        private JobPostingUpdateRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Set title
         * @param title  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        /**
         * Set description
         * @param description  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set contractType
         * @param contractType  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder contractType(String contractType) {
            this.contractType = contractType;
            return this;
        }
        
        /**
         * Set remote
         * @param remote  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder remote(Boolean remote) {
            this.remote = remote;
            return this;
        }
        
        /**
         * Set status
         * @param status  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder status(String status) {
            this.status = status;
            return this;
        }
        
        /**
         * Set scheduleType
         * @param scheduleType  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder scheduleType(String scheduleType) {
            this.scheduleType = scheduleType;
            return this;
        }
        
        /**
         * Set teamId
         * @param teamId  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder teamId(Integer teamId) {
            this.teamId = teamId;
            return this;
        }
        
        /**
         * Set locationId
         * @param locationId  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder locationId(Integer locationId) {
            this.locationId = locationId;
            return this;
        }
        
        /**
         * Set salaryFormat
         * @param salaryFormat  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder salaryFormat(String salaryFormat) {
            this.salaryFormat = salaryFormat;
            return this;
        }
        
        /**
         * Set salaryFromAmountInCents
         * @param salaryFromAmountInCents  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder salaryFromAmountInCents(Integer salaryFromAmountInCents) {
            this.salaryFromAmountInCents = salaryFromAmountInCents;
            return this;
        }
        
        /**
         * Set salaryToAmountInCents
         * @param salaryToAmountInCents  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder salaryToAmountInCents(Integer salaryToAmountInCents) {
            this.salaryToAmountInCents = salaryToAmountInCents;
            return this;
        }
        
        /**
         * Set cvRequirement
         * @param cvRequirement  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder cvRequirement(String cvRequirement) {
            this.cvRequirement = cvRequirement;
            return this;
        }
        
        /**
         * Set coverLetterRequirement
         * @param coverLetterRequirement  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder coverLetterRequirement(String coverLetterRequirement) {
            this.coverLetterRequirement = coverLetterRequirement;
            return this;
        }
        
        /**
         * Set phoneRequirement
         * @param phoneRequirement  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder phoneRequirement(String phoneRequirement) {
            this.phoneRequirement = phoneRequirement;
            return this;
        }
        
        /**
         * Set photoRequirement
         * @param photoRequirement  (optional)
         * @return JobPostingUpdateRequestBuilder
         */
        public JobPostingUpdateRequestBuilder photoRequirement(String photoRequirement) {
            this.photoRequirement = photoRequirement;
            return this;
        }
        
        /**
         * Build call for jobPostingUpdate
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
            PostJobPostingUpdateRequest postJobPostingUpdateRequest = buildBodyParams();
            return jobPostingUpdateCall(id, postJobPostingUpdateRequest, _callback);
        }

        private PostJobPostingUpdateRequest buildBodyParams() {
            PostJobPostingUpdateRequest postJobPostingUpdateRequest = new PostJobPostingUpdateRequest();
            postJobPostingUpdateRequest.title(this.title);
            postJobPostingUpdateRequest.description(this.description);
            if (this.contractType != null)
            postJobPostingUpdateRequest.contractType(PostJobPostingUpdateRequest.ContractTypeEnum.fromValue(this.contractType));
            postJobPostingUpdateRequest.remote(this.remote);
            if (this.status != null)
            postJobPostingUpdateRequest.status(PostJobPostingUpdateRequest.StatusEnum.fromValue(this.status));
            if (this.scheduleType != null)
            postJobPostingUpdateRequest.scheduleType(PostJobPostingUpdateRequest.ScheduleTypeEnum.fromValue(this.scheduleType));
            postJobPostingUpdateRequest.teamId(this.teamId);
            postJobPostingUpdateRequest.locationId(this.locationId);
            if (this.salaryFormat != null)
            postJobPostingUpdateRequest.salaryFormat(PostJobPostingUpdateRequest.SalaryFormatEnum.fromValue(this.salaryFormat));
            postJobPostingUpdateRequest.salaryFromAmountInCents(this.salaryFromAmountInCents);
            postJobPostingUpdateRequest.salaryToAmountInCents(this.salaryToAmountInCents);
            if (this.cvRequirement != null)
            postJobPostingUpdateRequest.cvRequirement(PostJobPostingUpdateRequest.CvRequirementEnum.fromValue(this.cvRequirement));
            if (this.coverLetterRequirement != null)
            postJobPostingUpdateRequest.coverLetterRequirement(PostJobPostingUpdateRequest.CoverLetterRequirementEnum.fromValue(this.coverLetterRequirement));
            if (this.phoneRequirement != null)
            postJobPostingUpdateRequest.phoneRequirement(PostJobPostingUpdateRequest.PhoneRequirementEnum.fromValue(this.phoneRequirement));
            if (this.photoRequirement != null)
            postJobPostingUpdateRequest.photoRequirement(PostJobPostingUpdateRequest.PhotoRequirementEnum.fromValue(this.photoRequirement));
            return postJobPostingUpdateRequest;
        }

        /**
         * Execute jobPostingUpdate request
         * @return AtsJobPosting
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public AtsJobPosting execute() throws ApiException {
            PostJobPostingUpdateRequest postJobPostingUpdateRequest = buildBodyParams();
            ApiResponse<AtsJobPosting> localVarResp = jobPostingUpdateWithHttpInfo(id, postJobPostingUpdateRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute jobPostingUpdate request with HTTP info returned
         * @return ApiResponse&lt;AtsJobPosting&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsJobPosting> executeWithHttpInfo() throws ApiException {
            PostJobPostingUpdateRequest postJobPostingUpdateRequest = buildBodyParams();
            return jobPostingUpdateWithHttpInfo(id, postJobPostingUpdateRequest);
        }

        /**
         * Execute jobPostingUpdate request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsJobPosting> _callback) throws ApiException {
            PostJobPostingUpdateRequest postJobPostingUpdateRequest = buildBodyParams();
            return jobPostingUpdateAsync(id, postJobPostingUpdateRequest, _callback);
        }
    }

    /**
     * Update a Job Posting
     * Update a Job Posting
     * @param id (Required) (required)
     * @return JobPostingUpdateRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public JobPostingUpdateRequestBuilder jobPostingUpdate(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new JobPostingUpdateRequestBuilder(id);
    }
    private okhttp3.Call listPostsCall(final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/posts";

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
    private okhttp3.Call listPostsValidateBeforeCall(final ApiCallback _callback) throws ApiException {
        return listPostsCall(_callback);

    }


    private ApiResponse<List<Post>> listPostsWithHttpInfo() throws ApiException {
        okhttp3.Call localVarCall = listPostsValidateBeforeCall(null);
        Type localVarReturnType = new TypeToken<List<Post>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call listPostsAsync(final ApiCallback<List<Post>> _callback) throws ApiException {

        okhttp3.Call localVarCall = listPostsValidateBeforeCall(_callback);
        Type localVarReturnType = new TypeToken<List<Post>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class ListPostsRequestBuilder {

        private ListPostsRequestBuilder() {
        }

        /**
         * Build call for listPosts
         * @param _callback ApiCallback API callback
         * @return Call to execute
         * @throws ApiException If fail to serialize the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
            return listPostsCall(_callback);
        }


        /**
         * Execute listPosts request
         * @return List&lt;Post&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
         </table>
         */
        public List<Post> execute() throws ApiException {
            ApiResponse<List<Post>> localVarResp = listPostsWithHttpInfo();
            return localVarResp.getResponseBody();
        }

        /**
         * Execute listPosts request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Post&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Post>> executeWithHttpInfo() throws ApiException {
            return listPostsWithHttpInfo();
        }

        /**
         * Execute listPosts request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
            <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Post>> _callback) throws ApiException {
            return listPostsAsync(_callback);
        }
    }

    /**
     * Get Posts
     * This endpoint allows you to fetch a collection of posts.
     * @return ListPostsRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> Internal Server Error </td><td>  -  </td></tr>
     </table>
     */
    public ListPostsRequestBuilder listPosts() throws IllegalArgumentException {
        return new ListPostsRequestBuilder();
    }
    private okhttp3.Call removeJobPostingCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/ats/job_postings/{id}"
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
    private okhttp3.Call removeJobPostingValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling removeJobPosting(Async)");
        }

        return removeJobPostingCall(id, _callback);

    }


    private ApiResponse<AtsJobPosting> removeJobPostingWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = removeJobPostingValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call removeJobPostingAsync(String id, final ApiCallback<AtsJobPosting> _callback) throws ApiException {

        okhttp3.Call localVarCall = removeJobPostingValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<AtsJobPosting>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RemoveJobPostingRequestBuilder {
        private final String id;

        private RemoveJobPostingRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for removeJobPosting
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
            return removeJobPostingCall(id, _callback);
        }


        /**
         * Execute removeJobPosting request
         * @return AtsJobPosting
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public AtsJobPosting execute() throws ApiException {
            ApiResponse<AtsJobPosting> localVarResp = removeJobPostingWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute removeJobPosting request with HTTP info returned
         * @return ApiResponse&lt;AtsJobPosting&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<AtsJobPosting> executeWithHttpInfo() throws ApiException {
            return removeJobPostingWithHttpInfo(id);
        }

        /**
         * Execute removeJobPosting request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<AtsJobPosting> _callback) throws ApiException {
            return removeJobPostingAsync(id, _callback);
        }
    }

    /**
     * Delete a Job Posting
     * Deletes an existing job posting
     * @param id (Required) (required)
     * @return RemoveJobPostingRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public RemoveJobPostingRequestBuilder removeJobPosting(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new RemoveJobPostingRequestBuilder(id);
    }
    private okhttp3.Call removePostCall(String id, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/v1/posts/{id}"
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

        String[] localVarAuthNames = new String[] { "oauth2" };
        return localVarApiClient.buildCall(basePath, localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call removePostValidateBeforeCall(String id, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling removePost(Async)");
        }

        return removePostCall(id, _callback);

    }


    private ApiResponse<Post> removePostWithHttpInfo(String id) throws ApiException {
        okhttp3.Call localVarCall = removePostValidateBeforeCall(id, null);
        Type localVarReturnType = new TypeToken<Post>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call removePostAsync(String id, final ApiCallback<Post> _callback) throws ApiException {

        okhttp3.Call localVarCall = removePostValidateBeforeCall(id, _callback);
        Type localVarReturnType = new TypeToken<Post>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class RemovePostRequestBuilder {
        private final String id;

        private RemovePostRequestBuilder(String id) {
            this.id = id;
        }

        /**
         * Build call for removePost
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
            return removePostCall(id, _callback);
        }


        /**
         * Execute removePost request
         * @return Post
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public Post execute() throws ApiException {
            ApiResponse<Post> localVarResp = removePostWithHttpInfo(id);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute removePost request with HTTP info returned
         * @return ApiResponse&lt;Post&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<Post> executeWithHttpInfo() throws ApiException {
            return removePostWithHttpInfo(id);
        }

        /**
         * Execute removePost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<Post> _callback) throws ApiException {
            return removePostAsync(id, _callback);
        }
    }

    /**
     * Delete Post
     * 
     * @param id (Required) (required)
     * @return RemovePostRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public RemovePostRequestBuilder removePost(String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new RemovePostRequestBuilder(id);
    }
    private okhttp3.Call updateExistingPostCall(String id, PostUpdateExistingPostRequest postUpdateExistingPostRequest, final ApiCallback _callback) throws ApiException {
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

        Object localVarPostBody = postUpdateExistingPostRequest;

        // create path and map variables
        String localVarPath = "/v1/posts/{id}"
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
    private okhttp3.Call updateExistingPostValidateBeforeCall(String id, PostUpdateExistingPostRequest postUpdateExistingPostRequest, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updateExistingPost(Async)");
        }

        return updateExistingPostCall(id, postUpdateExistingPostRequest, _callback);

    }


    private ApiResponse<List<Post>> updateExistingPostWithHttpInfo(String id, PostUpdateExistingPostRequest postUpdateExistingPostRequest) throws ApiException {
        okhttp3.Call localVarCall = updateExistingPostValidateBeforeCall(id, postUpdateExistingPostRequest, null);
        Type localVarReturnType = new TypeToken<List<Post>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    private okhttp3.Call updateExistingPostAsync(String id, PostUpdateExistingPostRequest postUpdateExistingPostRequest, final ApiCallback<List<Post>> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateExistingPostValidateBeforeCall(id, postUpdateExistingPostRequest, _callback);
        Type localVarReturnType = new TypeToken<List<Post>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    public class UpdateExistingPostRequestBuilder {
        private final Integer id;
        private final String id;
        private String title;
        private String description;
        private String starsAt;
        private String location;
        private Boolean sendNotifications;
        private Boolean deleteCoverImage;
        private File image;
        private Boolean allowCommentsAndReactions;
        private File attachments;
        private List<Integer> deletedAttachments;

        private UpdateExistingPostRequestBuilder(Integer id, String id) {
            this.id = id;
            this.id = id;
        }

        /**
         * Set title
         * @param title  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        /**
         * Set description
         * @param description  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder description(String description) {
            this.description = description;
            return this;
        }
        
        /**
         * Set starsAt
         * @param starsAt  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder starsAt(String starsAt) {
            this.starsAt = starsAt;
            return this;
        }
        
        /**
         * Set location
         * @param location  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder location(String location) {
            this.location = location;
            return this;
        }
        
        /**
         * Set sendNotifications
         * @param sendNotifications  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder sendNotifications(Boolean sendNotifications) {
            this.sendNotifications = sendNotifications;
            return this;
        }
        
        /**
         * Set deleteCoverImage
         * @param deleteCoverImage  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder deleteCoverImage(Boolean deleteCoverImage) {
            this.deleteCoverImage = deleteCoverImage;
            return this;
        }
        
        /**
         * Set image
         * @param image  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder image(File image) {
            this.image = image;
            return this;
        }
        
        /**
         * Set allowCommentsAndReactions
         * @param allowCommentsAndReactions  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder allowCommentsAndReactions(Boolean allowCommentsAndReactions) {
            this.allowCommentsAndReactions = allowCommentsAndReactions;
            return this;
        }
        
        /**
         * Set attachments
         * @param attachments  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder attachments(File attachments) {
            this.attachments = attachments;
            return this;
        }
        
        /**
         * Set deletedAttachments
         * @param deletedAttachments  (optional)
         * @return UpdateExistingPostRequestBuilder
         */
        public UpdateExistingPostRequestBuilder deletedAttachments(List<Integer> deletedAttachments) {
            this.deletedAttachments = deletedAttachments;
            return this;
        }
        
        /**
         * Build call for updateExistingPost
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
            PostUpdateExistingPostRequest postUpdateExistingPostRequest = buildBodyParams();
            return updateExistingPostCall(id, postUpdateExistingPostRequest, _callback);
        }

        private PostUpdateExistingPostRequest buildBodyParams() {
            PostUpdateExistingPostRequest postUpdateExistingPostRequest = new PostUpdateExistingPostRequest();
            postUpdateExistingPostRequest.title(this.title);
            postUpdateExistingPostRequest.description(this.description);
            postUpdateExistingPostRequest.id(this.id);
            postUpdateExistingPostRequest.starsAt(this.starsAt);
            postUpdateExistingPostRequest.location(this.location);
            postUpdateExistingPostRequest.sendNotifications(this.sendNotifications);
            postUpdateExistingPostRequest.deleteCoverImage(this.deleteCoverImage);
            postUpdateExistingPostRequest.image(this.image);
            postUpdateExistingPostRequest.allowCommentsAndReactions(this.allowCommentsAndReactions);
            postUpdateExistingPostRequest.attachments(this.attachments);
            postUpdateExistingPostRequest.deletedAttachments(this.deletedAttachments);
            return postUpdateExistingPostRequest;
        }

        /**
         * Execute updateExistingPost request
         * @return List&lt;Post&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public List<Post> execute() throws ApiException {
            PostUpdateExistingPostRequest postUpdateExistingPostRequest = buildBodyParams();
            ApiResponse<List<Post>> localVarResp = updateExistingPostWithHttpInfo(id, postUpdateExistingPostRequest);
            return localVarResp.getResponseBody();
        }

        /**
         * Execute updateExistingPost request with HTTP info returned
         * @return ApiResponse&lt;List&lt;Post&gt;&gt;
         * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public ApiResponse<List<Post>> executeWithHttpInfo() throws ApiException {
            PostUpdateExistingPostRequest postUpdateExistingPostRequest = buildBodyParams();
            return updateExistingPostWithHttpInfo(id, postUpdateExistingPostRequest);
        }

        /**
         * Execute updateExistingPost request (asynchronously)
         * @param _callback The callback to be executed when the API call finishes
         * @return The request call
         * @throws ApiException If fail to process the API call, e.g. serializing the request body object
         * @http.response.details
         <table summary="Response Details" border="1">
            <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
            <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
         </table>
         */
        public okhttp3.Call executeAsync(final ApiCallback<List<Post>> _callback) throws ApiException {
            PostUpdateExistingPostRequest postUpdateExistingPostRequest = buildBodyParams();
            return updateExistingPostAsync(id, postUpdateExistingPostRequest, _callback);
        }
    }

    /**
     * Create a Post
     * Create a Post
     * @param id (Required) (required)
     * @return UpdateExistingPostRequestBuilder
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> OK </td><td>  -  </td></tr>
     </table>
     */
    public UpdateExistingPostRequestBuilder updateExistingPost(Integer id, String id) throws IllegalArgumentException {
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
        if (id == null) throw new IllegalArgumentException("\"id\" is required but got null");
            

        return new UpdateExistingPostRequestBuilder(id, id);
    }
}
