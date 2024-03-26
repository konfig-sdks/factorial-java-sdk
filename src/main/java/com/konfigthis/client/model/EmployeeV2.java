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


package com.konfigthis.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.konfigthis.client.JSON;

/**
 * EmployeeV2
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class EmployeeV2 {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_FIRST_NAME = "first_name";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_LAST_NAME = "last_name";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_FULL_NAME = "full_name";
  @SerializedName(SERIALIZED_NAME_FULL_NAME)
  private String fullName;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_BIRTHDAY_ON = "birthday_on";
  @SerializedName(SERIALIZED_NAME_BIRTHDAY_ON)
  private String birthdayOn;

  public static final String SERIALIZED_NAME_TERMINATED_ON = "terminated_on";
  @SerializedName(SERIALIZED_NAME_TERMINATED_ON)
  private String terminatedOn;

  public static final String SERIALIZED_NAME_TERMINATION_REASON = "termination_reason";
  @SerializedName(SERIALIZED_NAME_TERMINATION_REASON)
  private String terminationReason;

  public static final String SERIALIZED_NAME_TERMINATION_OBSERVATIONS = "termination_observations";
  @SerializedName(SERIALIZED_NAME_TERMINATION_OBSERVATIONS)
  private String terminationObservations;

  public static final String SERIALIZED_NAME_IDENTIFIER = "identifier";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER)
  private String identifier;

  public static final String SERIALIZED_NAME_IDENTIFIER_TYPE = "identifier_type";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_TYPE)
  private String identifierType;

  /**
   * Gets or Sets gender
   */
  @JsonAdapter(GenderEnum.Adapter.class)
 public enum GenderEnum {
    MALE("male"),
    
    FEMALE("female");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static GenderEnum fromValue(String value) {
      for (GenderEnum b : GenderEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<GenderEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final GenderEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public GenderEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return GenderEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_GENDER = "gender";
  @SerializedName(SERIALIZED_NAME_GENDER)
  private GenderEnum gender;

  public static final String SERIALIZED_NAME_NATIONALITY = "nationality";
  @SerializedName(SERIALIZED_NAME_NATIONALITY)
  private String nationality;

  public static final String SERIALIZED_NAME_BANK_NUMBER = "bank_number";
  @SerializedName(SERIALIZED_NAME_BANK_NUMBER)
  private String bankNumber;

  public static final String SERIALIZED_NAME_COUNTRY = "country";
  @SerializedName(SERIALIZED_NAME_COUNTRY)
  private String country;

  public static final String SERIALIZED_NAME_CITY = "city";
  @SerializedName(SERIALIZED_NAME_CITY)
  private String city;

  public static final String SERIALIZED_NAME_STATE = "state";
  @SerializedName(SERIALIZED_NAME_STATE)
  private String state;

  public static final String SERIALIZED_NAME_POSTAL_CODE = "postal_code";
  @SerializedName(SERIALIZED_NAME_POSTAL_CODE)
  private String postalCode;

  public static final String SERIALIZED_NAME_ADDRESS_LINE1 = "address_line_1";
  @SerializedName(SERIALIZED_NAME_ADDRESS_LINE1)
  private String addressLine1;

  public static final String SERIALIZED_NAME_ADDRESS_LINE2 = "address_line_2";
  @SerializedName(SERIALIZED_NAME_ADDRESS_LINE2)
  private String addressLine2;

  public static final String SERIALIZED_NAME_SWIFT_BIC = "swift_bic";
  @SerializedName(SERIALIZED_NAME_SWIFT_BIC)
  private String swiftBic;

  public static final String SERIALIZED_NAME_COMPANY_ID = "company_id";
  @SerializedName(SERIALIZED_NAME_COMPANY_ID)
  private Integer companyId;

  public static final String SERIALIZED_NAME_LEGAL_ENTITY_ID = "legal_entity_id";
  @SerializedName(SERIALIZED_NAME_LEGAL_ENTITY_ID)
  private Integer legalEntityId;

  public static final String SERIALIZED_NAME_CREATED_AT = "created_at";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private String createdAt;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public static final String SERIALIZED_NAME_MANAGER_ID = "manager_id";
  @SerializedName(SERIALIZED_NAME_MANAGER_ID)
  private Integer managerId;

  public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
  @SerializedName(SERIALIZED_NAME_LOCATION_ID)
  private Integer locationId;

  public static final String SERIALIZED_NAME_TIMEOFF_MANAGER_ID = "timeoff_manager_id";
  @SerializedName(SERIALIZED_NAME_TIMEOFF_MANAGER_ID)
  private Integer timeoffManagerId;

  public static final String SERIALIZED_NAME_SOCIAL_SECURITY_NUMBER = "social_security_number";
  @SerializedName(SERIALIZED_NAME_SOCIAL_SECURITY_NUMBER)
  private String socialSecurityNumber;

  public static final String SERIALIZED_NAME_TAX_ID = "tax_id";
  @SerializedName(SERIALIZED_NAME_TAX_ID)
  private String taxId;

  public static final String SERIALIZED_NAME_TIMEOFF_POLICY_ID = "timeoff_policy_id";
  @SerializedName(SERIALIZED_NAME_TIMEOFF_POLICY_ID)
  private Integer timeoffPolicyId;

  public static final String SERIALIZED_NAME_TEAM_IDS = "team_ids";
  @SerializedName(SERIALIZED_NAME_TEAM_IDS)
  private List<Integer> teamIds = null;

  public static final String SERIALIZED_NAME_PHONE_NUMBER = "phone_number";
  @SerializedName(SERIALIZED_NAME_PHONE_NUMBER)
  private String phoneNumber;

  public static final String SERIALIZED_NAME_COMPANY_IDENTIFIER = "company_identifier";
  @SerializedName(SERIALIZED_NAME_COMPANY_IDENTIFIER)
  private String companyIdentifier;

  public EmployeeV2() {
  }

  public EmployeeV2 id(Integer id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    
    
    
    this.id = id;
  }


  public EmployeeV2 firstName(String firstName) {
    
    
    
    
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Bob", value = "")

  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    
    
    
    this.firstName = firstName;
  }


  public EmployeeV2 lastName(String lastName) {
    
    
    
    
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Stone", value = "")

  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    
    
    
    this.lastName = lastName;
  }


  public EmployeeV2 fullName(String fullName) {
    
    
    
    
    this.fullName = fullName;
    return this;
  }

   /**
   * Get fullName
   * @return fullName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Bob Stone", value = "")

  public String getFullName() {
    return fullName;
  }


  public void setFullName(String fullName) {
    
    
    
    this.fullName = fullName;
  }


  public EmployeeV2 email(String email) {
    
    
    
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "bob_stone@factorial.co", value = "")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    
    
    
    this.email = email;
  }


  public EmployeeV2 birthdayOn(String birthdayOn) {
    
    
    
    
    this.birthdayOn = birthdayOn;
    return this;
  }

   /**
   * Get birthdayOn
   * @return birthdayOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2000-01-08", value = "")

  public String getBirthdayOn() {
    return birthdayOn;
  }


  public void setBirthdayOn(String birthdayOn) {
    
    
    
    this.birthdayOn = birthdayOn;
  }


  public EmployeeV2 terminatedOn(String terminatedOn) {
    
    
    
    
    this.terminatedOn = terminatedOn;
    return this;
  }

   /**
   * Get terminatedOn
   * @return terminatedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-01-08", value = "")

  public String getTerminatedOn() {
    return terminatedOn;
  }


  public void setTerminatedOn(String terminatedOn) {
    
    
    
    this.terminatedOn = terminatedOn;
  }


  public EmployeeV2 terminationReason(String terminationReason) {
    
    
    
    
    this.terminationReason = terminationReason;
    return this;
  }

   /**
   * Get terminationReason
   * @return terminationReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Behaviour", value = "")

  public String getTerminationReason() {
    return terminationReason;
  }


  public void setTerminationReason(String terminationReason) {
    
    
    
    this.terminationReason = terminationReason;
  }


  public EmployeeV2 terminationObservations(String terminationObservations) {
    
    
    
    
    this.terminationObservations = terminationObservations;
    return this;
  }

   /**
   * Get terminationObservations
   * @return terminationObservations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Behaviour", value = "")

  public String getTerminationObservations() {
    return terminationObservations;
  }


  public void setTerminationObservations(String terminationObservations) {
    
    
    
    this.terminationObservations = terminationObservations;
  }


  public EmployeeV2 identifier(String identifier) {
    
    
    
    
    this.identifier = identifier;
    return this;
  }

   /**
   * Get identifier
   * @return identifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "82649834R", value = "")

  public String getIdentifier() {
    return identifier;
  }


  public void setIdentifier(String identifier) {
    
    
    
    this.identifier = identifier;
  }


  public EmployeeV2 identifierType(String identifierType) {
    
    
    
    
    this.identifierType = identifierType;
    return this;
  }

   /**
   * Get identifierType
   * @return identifierType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "dni", value = "")

  public String getIdentifierType() {
    return identifierType;
  }


  public void setIdentifierType(String identifierType) {
    
    
    
    this.identifierType = identifierType;
  }


  public EmployeeV2 gender(GenderEnum gender) {
    
    
    
    
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FEMALE", value = "")

  public GenderEnum getGender() {
    return gender;
  }


  public void setGender(GenderEnum gender) {
    
    
    
    this.gender = gender;
  }


  public EmployeeV2 nationality(String nationality) {
    
    
    
    
    this.nationality = nationality;
    return this;
  }

   /**
   * Get nationality
   * @return nationality
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "es", value = "")

  public String getNationality() {
    return nationality;
  }


  public void setNationality(String nationality) {
    
    
    
    this.nationality = nationality;
  }


  public EmployeeV2 bankNumber(String bankNumber) {
    
    
    
    
    this.bankNumber = bankNumber;
    return this;
  }

   /**
   * Get bankNumber
   * @return bankNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "ES09 4595 6109 8115 7760 8354", value = "")

  public String getBankNumber() {
    return bankNumber;
  }


  public void setBankNumber(String bankNumber) {
    
    
    
    this.bankNumber = bankNumber;
  }


  public EmployeeV2 country(String country) {
    
    
    
    
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "es", value = "")

  public String getCountry() {
    return country;
  }


  public void setCountry(String country) {
    
    
    
    this.country = country;
  }


  public EmployeeV2 city(String city) {
    
    
    
    
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Barcelona", value = "")

  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    
    
    
    this.city = city;
  }


  public EmployeeV2 state(String state) {
    
    
    
    
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Barcelona", value = "")

  public String getState() {
    return state;
  }


  public void setState(String state) {
    
    
    
    this.state = state;
  }


  public EmployeeV2 postalCode(String postalCode) {
    
    
    
    
    this.postalCode = postalCode;
    return this;
  }

   /**
   * Get postalCode
   * @return postalCode
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "08007", value = "")

  public String getPostalCode() {
    return postalCode;
  }


  public void setPostalCode(String postalCode) {
    
    
    
    this.postalCode = postalCode;
  }


  public EmployeeV2 addressLine1(String addressLine1) {
    
    
    
    
    this.addressLine1 = addressLine1;
    return this;
  }

   /**
   * Get addressLine1
   * @return addressLine1
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "c/ Tallers 123", value = "")

  public String getAddressLine1() {
    return addressLine1;
  }


  public void setAddressLine1(String addressLine1) {
    
    
    
    this.addressLine1 = addressLine1;
  }


  public EmployeeV2 addressLine2(String addressLine2) {
    
    
    
    
    this.addressLine2 = addressLine2;
    return this;
  }

   /**
   * Get addressLine2
   * @return addressLine2
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Atic 5", value = "")

  public String getAddressLine2() {
    return addressLine2;
  }


  public void setAddressLine2(String addressLine2) {
    
    
    
    this.addressLine2 = addressLine2;
  }


  public EmployeeV2 swiftBic(String swiftBic) {
    
    
    
    
    this.swiftBic = swiftBic;
    return this;
  }

   /**
   * Get swiftBic
   * @return swiftBic
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1234567890", value = "")

  public String getSwiftBic() {
    return swiftBic;
  }


  public void setSwiftBic(String swiftBic) {
    
    
    
    this.swiftBic = swiftBic;
  }


  public EmployeeV2 companyId(Integer companyId) {
    
    
    
    
    this.companyId = companyId;
    return this;
  }

   /**
   * Get companyId
   * @return companyId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getCompanyId() {
    return companyId;
  }


  public void setCompanyId(Integer companyId) {
    
    
    
    this.companyId = companyId;
  }


  public EmployeeV2 legalEntityId(Integer legalEntityId) {
    
    
    
    
    this.legalEntityId = legalEntityId;
    return this;
  }

   /**
   * Get legalEntityId
   * @return legalEntityId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getLegalEntityId() {
    return legalEntityId;
  }


  public void setLegalEntityId(Integer legalEntityId) {
    
    
    
    this.legalEntityId = legalEntityId;
  }


  public EmployeeV2 createdAt(String createdAt) {
    
    
    
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-24T18:39:03.515Z", value = "")

  public String getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(String createdAt) {
    
    
    
    this.createdAt = createdAt;
  }


  public EmployeeV2 updatedAt(String updatedAt) {
    
    
    
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-24T18:39:03.515Z", value = "")

  public String getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(String updatedAt) {
    
    
    
    this.updatedAt = updatedAt;
  }


  public EmployeeV2 managerId(Integer managerId) {
    
    
    
    
    this.managerId = managerId;
    return this;
  }

   /**
   * Get managerId
   * @return managerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getManagerId() {
    return managerId;
  }


  public void setManagerId(Integer managerId) {
    
    
    
    this.managerId = managerId;
  }


  public EmployeeV2 locationId(Integer locationId) {
    
    
    
    
    this.locationId = locationId;
    return this;
  }

   /**
   * Get locationId
   * @return locationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getLocationId() {
    return locationId;
  }


  public void setLocationId(Integer locationId) {
    
    
    
    this.locationId = locationId;
  }


  public EmployeeV2 timeoffManagerId(Integer timeoffManagerId) {
    
    
    
    
    this.timeoffManagerId = timeoffManagerId;
    return this;
  }

   /**
   * Get timeoffManagerId
   * @return timeoffManagerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getTimeoffManagerId() {
    return timeoffManagerId;
  }


  public void setTimeoffManagerId(Integer timeoffManagerId) {
    
    
    
    this.timeoffManagerId = timeoffManagerId;
  }


  public EmployeeV2 socialSecurityNumber(String socialSecurityNumber) {
    
    
    
    
    this.socialSecurityNumber = socialSecurityNumber;
    return this;
  }

   /**
   * Get socialSecurityNumber
   * @return socialSecurityNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "223948780514", value = "")

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }


  public void setSocialSecurityNumber(String socialSecurityNumber) {
    
    
    
    this.socialSecurityNumber = socialSecurityNumber;
  }


  public EmployeeV2 taxId(String taxId) {
    
    
    
    
    this.taxId = taxId;
    return this;
  }

   /**
   * Get taxId
   * @return taxId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "121232323", value = "")

  public String getTaxId() {
    return taxId;
  }


  public void setTaxId(String taxId) {
    
    
    
    this.taxId = taxId;
  }


  public EmployeeV2 timeoffPolicyId(Integer timeoffPolicyId) {
    
    
    
    
    this.timeoffPolicyId = timeoffPolicyId;
    return this;
  }

   /**
   * Get timeoffPolicyId
   * @return timeoffPolicyId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getTimeoffPolicyId() {
    return timeoffPolicyId;
  }


  public void setTimeoffPolicyId(Integer timeoffPolicyId) {
    
    
    
    this.timeoffPolicyId = timeoffPolicyId;
  }


  public EmployeeV2 teamIds(List<Integer> teamIds) {
    
    
    
    
    this.teamIds = teamIds;
    return this;
  }

  public EmployeeV2 addTeamIdsItem(Integer teamIdsItem) {
    if (this.teamIds == null) {
      this.teamIds = new ArrayList<>();
    }
    this.teamIds.add(teamIdsItem);
    return this;
  }

   /**
   * Get teamIds
   * @return teamIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Integer> getTeamIds() {
    return teamIds;
  }


  public void setTeamIds(List<Integer> teamIds) {
    
    
    
    this.teamIds = teamIds;
  }


  public EmployeeV2 phoneNumber(String phoneNumber) {
    
    
    
    
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * Get phoneNumber
   * @return phoneNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "9322222222222", value = "")

  public String getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(String phoneNumber) {
    
    
    
    this.phoneNumber = phoneNumber;
  }


  public EmployeeV2 companyIdentifier(String companyIdentifier) {
    
    
    
    
    this.companyIdentifier = companyIdentifier;
    return this;
  }

   /**
   * Get companyIdentifier
   * @return companyIdentifier
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "124ABC", value = "")

  public String getCompanyIdentifier() {
    return companyIdentifier;
  }


  public void setCompanyIdentifier(String companyIdentifier) {
    
    
    
    this.companyIdentifier = companyIdentifier;
  }

  /**
   * A container for additional, undeclared properties.
   * This is a holder for any undeclared properties as specified with
   * the 'additionalProperties' keyword in the OAS document.
   */
  private Map<String, Object> additionalProperties;

  /**
   * Set the additional (undeclared) property with the specified name and value.
   * If the property does not already exist, create it otherwise replace it.
   *
   * @param key name of the property
   * @param value value of the property
   * @return the EmployeeV2 instance itself
   */
  public EmployeeV2 putAdditionalProperty(String key, Object value) {
    if (this.additionalProperties == null) {
        this.additionalProperties = new HashMap<String, Object>();
    }
    this.additionalProperties.put(key, value);
    return this;
  }

  /**
   * Return the additional (undeclared) property.
   *
   * @return a map of objects
   */
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  /**
   * Return the additional (undeclared) property with the specified name.
   *
   * @param key name of the property
   * @return an object
   */
  public Object getAdditionalProperty(String key) {
    if (this.additionalProperties == null) {
        return null;
    }
    return this.additionalProperties.get(key);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmployeeV2 employeeV2 = (EmployeeV2) o;
    return Objects.equals(this.id, employeeV2.id) &&
        Objects.equals(this.firstName, employeeV2.firstName) &&
        Objects.equals(this.lastName, employeeV2.lastName) &&
        Objects.equals(this.fullName, employeeV2.fullName) &&
        Objects.equals(this.email, employeeV2.email) &&
        Objects.equals(this.birthdayOn, employeeV2.birthdayOn) &&
        Objects.equals(this.terminatedOn, employeeV2.terminatedOn) &&
        Objects.equals(this.terminationReason, employeeV2.terminationReason) &&
        Objects.equals(this.terminationObservations, employeeV2.terminationObservations) &&
        Objects.equals(this.identifier, employeeV2.identifier) &&
        Objects.equals(this.identifierType, employeeV2.identifierType) &&
        Objects.equals(this.gender, employeeV2.gender) &&
        Objects.equals(this.nationality, employeeV2.nationality) &&
        Objects.equals(this.bankNumber, employeeV2.bankNumber) &&
        Objects.equals(this.country, employeeV2.country) &&
        Objects.equals(this.city, employeeV2.city) &&
        Objects.equals(this.state, employeeV2.state) &&
        Objects.equals(this.postalCode, employeeV2.postalCode) &&
        Objects.equals(this.addressLine1, employeeV2.addressLine1) &&
        Objects.equals(this.addressLine2, employeeV2.addressLine2) &&
        Objects.equals(this.swiftBic, employeeV2.swiftBic) &&
        Objects.equals(this.companyId, employeeV2.companyId) &&
        Objects.equals(this.legalEntityId, employeeV2.legalEntityId) &&
        Objects.equals(this.createdAt, employeeV2.createdAt) &&
        Objects.equals(this.updatedAt, employeeV2.updatedAt) &&
        Objects.equals(this.managerId, employeeV2.managerId) &&
        Objects.equals(this.locationId, employeeV2.locationId) &&
        Objects.equals(this.timeoffManagerId, employeeV2.timeoffManagerId) &&
        Objects.equals(this.socialSecurityNumber, employeeV2.socialSecurityNumber) &&
        Objects.equals(this.taxId, employeeV2.taxId) &&
        Objects.equals(this.timeoffPolicyId, employeeV2.timeoffPolicyId) &&
        Objects.equals(this.teamIds, employeeV2.teamIds) &&
        Objects.equals(this.phoneNumber, employeeV2.phoneNumber) &&
        Objects.equals(this.companyIdentifier, employeeV2.companyIdentifier)&&
        Objects.equals(this.additionalProperties, employeeV2.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, fullName, email, birthdayOn, terminatedOn, terminationReason, terminationObservations, identifier, identifierType, gender, nationality, bankNumber, country, city, state, postalCode, addressLine1, addressLine2, swiftBic, companyId, legalEntityId, createdAt, updatedAt, managerId, locationId, timeoffManagerId, socialSecurityNumber, taxId, timeoffPolicyId, teamIds, phoneNumber, companyIdentifier, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmployeeV2 {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    birthdayOn: ").append(toIndentedString(birthdayOn)).append("\n");
    sb.append("    terminatedOn: ").append(toIndentedString(terminatedOn)).append("\n");
    sb.append("    terminationReason: ").append(toIndentedString(terminationReason)).append("\n");
    sb.append("    terminationObservations: ").append(toIndentedString(terminationObservations)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    identifierType: ").append(toIndentedString(identifierType)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    bankNumber: ").append(toIndentedString(bankNumber)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    swiftBic: ").append(toIndentedString(swiftBic)).append("\n");
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    legalEntityId: ").append(toIndentedString(legalEntityId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    managerId: ").append(toIndentedString(managerId)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    timeoffManagerId: ").append(toIndentedString(timeoffManagerId)).append("\n");
    sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
    sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
    sb.append("    timeoffPolicyId: ").append(toIndentedString(timeoffPolicyId)).append("\n");
    sb.append("    teamIds: ").append(toIndentedString(teamIds)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    companyIdentifier: ").append(toIndentedString(companyIdentifier)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("id");
    openapiFields.add("first_name");
    openapiFields.add("last_name");
    openapiFields.add("full_name");
    openapiFields.add("email");
    openapiFields.add("birthday_on");
    openapiFields.add("terminated_on");
    openapiFields.add("termination_reason");
    openapiFields.add("termination_observations");
    openapiFields.add("identifier");
    openapiFields.add("identifier_type");
    openapiFields.add("gender");
    openapiFields.add("nationality");
    openapiFields.add("bank_number");
    openapiFields.add("country");
    openapiFields.add("city");
    openapiFields.add("state");
    openapiFields.add("postal_code");
    openapiFields.add("address_line_1");
    openapiFields.add("address_line_2");
    openapiFields.add("swift_bic");
    openapiFields.add("company_id");
    openapiFields.add("legal_entity_id");
    openapiFields.add("created_at");
    openapiFields.add("updated_at");
    openapiFields.add("manager_id");
    openapiFields.add("location_id");
    openapiFields.add("timeoff_manager_id");
    openapiFields.add("social_security_number");
    openapiFields.add("tax_id");
    openapiFields.add("timeoff_policy_id");
    openapiFields.add("team_ids");
    openapiFields.add("phone_number");
    openapiFields.add("company_identifier");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EmployeeV2
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!EmployeeV2.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EmployeeV2 is not found in the empty JSON string", EmployeeV2.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("first_name") != null && !jsonObj.get("first_name").isJsonNull()) && !jsonObj.get("first_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `first_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("first_name").toString()));
      }
      if ((jsonObj.get("last_name") != null && !jsonObj.get("last_name").isJsonNull()) && !jsonObj.get("last_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `last_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("last_name").toString()));
      }
      if ((jsonObj.get("full_name") != null && !jsonObj.get("full_name").isJsonNull()) && !jsonObj.get("full_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `full_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("full_name").toString()));
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
      }
      if ((jsonObj.get("birthday_on") != null && !jsonObj.get("birthday_on").isJsonNull()) && !jsonObj.get("birthday_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `birthday_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("birthday_on").toString()));
      }
      if ((jsonObj.get("terminated_on") != null && !jsonObj.get("terminated_on").isJsonNull()) && !jsonObj.get("terminated_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `terminated_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("terminated_on").toString()));
      }
      if ((jsonObj.get("termination_reason") != null && !jsonObj.get("termination_reason").isJsonNull()) && !jsonObj.get("termination_reason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `termination_reason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("termination_reason").toString()));
      }
      if ((jsonObj.get("termination_observations") != null && !jsonObj.get("termination_observations").isJsonNull()) && !jsonObj.get("termination_observations").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `termination_observations` to be a primitive type in the JSON string but got `%s`", jsonObj.get("termination_observations").toString()));
      }
      if ((jsonObj.get("identifier") != null && !jsonObj.get("identifier").isJsonNull()) && !jsonObj.get("identifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifier").toString()));
      }
      if ((jsonObj.get("identifier_type") != null && !jsonObj.get("identifier_type").isJsonNull()) && !jsonObj.get("identifier_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifier_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifier_type").toString()));
      }
      if ((jsonObj.get("gender") != null && !jsonObj.get("gender").isJsonNull()) && !jsonObj.get("gender").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `gender` to be a primitive type in the JSON string but got `%s`", jsonObj.get("gender").toString()));
      }
      if ((jsonObj.get("nationality") != null && !jsonObj.get("nationality").isJsonNull()) && !jsonObj.get("nationality").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `nationality` to be a primitive type in the JSON string but got `%s`", jsonObj.get("nationality").toString()));
      }
      if ((jsonObj.get("bank_number") != null && !jsonObj.get("bank_number").isJsonNull()) && !jsonObj.get("bank_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `bank_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("bank_number").toString()));
      }
      if ((jsonObj.get("country") != null && !jsonObj.get("country").isJsonNull()) && !jsonObj.get("country").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `country` to be a primitive type in the JSON string but got `%s`", jsonObj.get("country").toString()));
      }
      if ((jsonObj.get("city") != null && !jsonObj.get("city").isJsonNull()) && !jsonObj.get("city").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `city` to be a primitive type in the JSON string but got `%s`", jsonObj.get("city").toString()));
      }
      if ((jsonObj.get("state") != null && !jsonObj.get("state").isJsonNull()) && !jsonObj.get("state").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state").toString()));
      }
      if ((jsonObj.get("postal_code") != null && !jsonObj.get("postal_code").isJsonNull()) && !jsonObj.get("postal_code").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `postal_code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("postal_code").toString()));
      }
      if ((jsonObj.get("address_line_1") != null && !jsonObj.get("address_line_1").isJsonNull()) && !jsonObj.get("address_line_1").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `address_line_1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("address_line_1").toString()));
      }
      if ((jsonObj.get("address_line_2") != null && !jsonObj.get("address_line_2").isJsonNull()) && !jsonObj.get("address_line_2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `address_line_2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("address_line_2").toString()));
      }
      if ((jsonObj.get("swift_bic") != null && !jsonObj.get("swift_bic").isJsonNull()) && !jsonObj.get("swift_bic").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `swift_bic` to be a primitive type in the JSON string but got `%s`", jsonObj.get("swift_bic").toString()));
      }
      if ((jsonObj.get("created_at") != null && !jsonObj.get("created_at").isJsonNull()) && !jsonObj.get("created_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `created_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("created_at").toString()));
      }
      if ((jsonObj.get("updated_at") != null && !jsonObj.get("updated_at").isJsonNull()) && !jsonObj.get("updated_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated_at").toString()));
      }
      if ((jsonObj.get("social_security_number") != null && !jsonObj.get("social_security_number").isJsonNull()) && !jsonObj.get("social_security_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `social_security_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("social_security_number").toString()));
      }
      if ((jsonObj.get("tax_id") != null && !jsonObj.get("tax_id").isJsonNull()) && !jsonObj.get("tax_id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `tax_id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("tax_id").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("team_ids") != null && !jsonObj.get("team_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `team_ids` to be an array in the JSON string but got `%s`", jsonObj.get("team_ids").toString()));
      }
      if ((jsonObj.get("phone_number") != null && !jsonObj.get("phone_number").isJsonNull()) && !jsonObj.get("phone_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `phone_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("phone_number").toString()));
      }
      if ((jsonObj.get("company_identifier") != null && !jsonObj.get("company_identifier").isJsonNull()) && !jsonObj.get("company_identifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `company_identifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("company_identifier").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EmployeeV2.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EmployeeV2' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EmployeeV2> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EmployeeV2.class));

       return (TypeAdapter<T>) new TypeAdapter<EmployeeV2>() {
           @Override
           public void write(JsonWriter out, EmployeeV2 value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             obj.remove("additionalProperties");
             // serialize additonal properties
             if (value.getAdditionalProperties() != null) {
               for (Map.Entry<String, Object> entry : value.getAdditionalProperties().entrySet()) {
                 if (entry.getValue() instanceof String)
                   obj.addProperty(entry.getKey(), (String) entry.getValue());
                 else if (entry.getValue() instanceof Number)
                   obj.addProperty(entry.getKey(), (Number) entry.getValue());
                 else if (entry.getValue() instanceof Boolean)
                   obj.addProperty(entry.getKey(), (Boolean) entry.getValue());
                 else if (entry.getValue() instanceof Character)
                   obj.addProperty(entry.getKey(), (Character) entry.getValue());
                 else {
                   obj.add(entry.getKey(), gson.toJsonTree(entry.getValue()).getAsJsonObject());
                 }
               }
             }
             elementAdapter.write(out, obj);
           }

           @Override
           public EmployeeV2 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             EmployeeV2 instance = thisAdapter.fromJsonTree(jsonObj);
             for (Map.Entry<String, JsonElement> entry : jsonObj.entrySet()) {
               if (!openapiFields.contains(entry.getKey())) {
                 if (entry.getValue().isJsonPrimitive()) { // primitive type
                   if (entry.getValue().getAsJsonPrimitive().isString())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsString());
                   else if (entry.getValue().getAsJsonPrimitive().isNumber())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsNumber());
                   else if (entry.getValue().getAsJsonPrimitive().isBoolean())
                     instance.putAdditionalProperty(entry.getKey(), entry.getValue().getAsBoolean());
                   else
                     throw new IllegalArgumentException(String.format("The field `%s` has unknown primitive type. Value: %s", entry.getKey(), entry.getValue().toString()));
                 } else if (entry.getValue().isJsonArray()) {
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), List.class));
                 } else { // JSON object
                     instance.putAdditionalProperty(entry.getKey(), gson.fromJson(entry.getValue(), HashMap.class));
                 }
               }
             }
             return instance;
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EmployeeV2 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EmployeeV2
  * @throws IOException if the JSON string is invalid with respect to EmployeeV2
  */
  public static EmployeeV2 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EmployeeV2.class);
  }

 /**
  * Convert an instance of EmployeeV2 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

