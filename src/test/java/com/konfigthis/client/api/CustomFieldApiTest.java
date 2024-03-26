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

import com.konfigthis.client.ApiException;
import com.konfigthis.client.ApiClient;
import com.konfigthis.client.ApiException;
import com.konfigthis.client.Configuration;
import com.konfigthis.client.model.CustomField;
import com.konfigthis.client.model.CustomFieldCreateFieldRequest;
import com.konfigthis.client.model.CustomFieldCreateFieldRequestChoiceOptionsInner;
import com.konfigthis.client.model.CustomFieldV2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CustomFieldApi
 */
@Disabled
public class CustomFieldApiTest {

    private static CustomFieldApi api;

    
    @BeforeAll
    public static void beforeClass() {
        ApiClient apiClient = Configuration.getDefaultApiClient();
        api = new CustomFieldApi(apiClient);
    }

    /**
     * Create a custom field
     *
     * This endpoint allows you to create custom fields you must provide these parameters - label: custom field visible name for example &#x60;T shirt size&#x60; - slug_name: the resource that you want to save the custom field, for example to save &#x60;t-shirt size&#x60; field in employee you must use &#x60;employees-questions&#x60; value - field_type: the kind of field value you want to store: text (input), long text (text area), number (input number) or single choice (select input) - required: You can set if the field is mandatory - visible: You can set the roles can see the field (own, reportees, team leader or everybody) - editable: You can set the roles can edit the field (own, reportees, team leader or everybody) - choice_options: You can provide an array of choices to set the options of a single choice field
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void createFieldTest() throws ApiException {
        String label = null;
        String slugName = null;
        String fieldType = null;
        Boolean required = null;
        String editable = null;
        String visible = null;
        Integer minValue = null;
        Integer maxValue = null;
        List<CustomFieldCreateFieldRequestChoiceOptionsInner> choiceOptions = null;
        CustomFieldV2 response = api.createField(label, slugName, fieldType, required, editable, visible)
                .minValue(minValue)
                .maxValue(maxValue)
                .choiceOptions(choiceOptions)
                .execute();
        // TODO: test validations
    }

    /**
     * Delete a custom field
     *
     * Delete a custom field by its id
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteByIdTest() throws ApiException {
        Integer id = null;
        List<CustomFieldV2> response = api.deleteById(id)
                .execute();
        // TODO: test validations
    }

    /**
     * Get Custom Fields
     *
     * This endpoint allows you to fetch a collection of custom fields. The fields you receive in the response are governed by the &#x60;field_group&#x60; you supply in the body of your request. For now, there are 2 acceptable field groups:   - &#x60;employees-questions&#x60; which refers to fields relating to an employee   - &#x60;time-tracking-projects&#x60; which refers to fields relating to time tracking data   - &#x60;contract-versions&#x60; which refers to fields relating to employee contract versions
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getFieldsByGroupTest() throws ApiException {
        String fieldGroup = null;
        List<CustomField> response = api.getFieldsByGroup(fieldGroup)
                .execute();
        // TODO: test validations
    }

    /**
     * Get custom fields
     *
     * This endpoint allows you to retrieve custom fields by id, label, slug name, slug name. You receive fields tagged in the response by a slug. For now, there is one acceptable slug name:   - &#x60;employees-questions&#x60; which refers to fields relating to an employee   You can filter by:   - id: You can query a field by its id. For example &#x60;T-shirt size&#x60; identifier is 4. you can search the custom field by the id 4.  - label: you can query a field by its label for example &#x60;T shirt size&#x60;  - slug_name: You can use the available slug &#x60;employees-questions&#x60; in the &#x60;slug_name&#x60; field to filter fields that belong to this slug.  - slug_id: It is the identifier of the slug_name. You can use the id of a slug to query custom fields by its id instead of its name.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getFieldsBySlugTest() throws ApiException {
        Integer id = null;
        String label = null;
        Integer slugId = null;
        String slugName = null;
        List<CustomFieldV2> response = api.getFieldsBySlug()
                .id(id)
                .label(label)
                .slugId(slugId)
                .slugName(slugName)
                .execute();
        // TODO: test validations
    }

}
