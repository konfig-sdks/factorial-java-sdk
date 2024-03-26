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
import com.konfigthis.client.model.EmployeeHiring;
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
 * Employee
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class Employee {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_EMAIL = "email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_FIRST_NAME = "first_name";
  @SerializedName(SERIALIZED_NAME_FIRST_NAME)
  private String firstName;

  public static final String SERIALIZED_NAME_LAST_NAME = "last_name";
  @SerializedName(SERIALIZED_NAME_LAST_NAME)
  private String lastName;

  public static final String SERIALIZED_NAME_FULL_NAME = "full_name";
  @SerializedName(SERIALIZED_NAME_FULL_NAME)
  private String fullName;

  public static final String SERIALIZED_NAME_BIRTHDAY_ON = "birthday_on";
  @SerializedName(SERIALIZED_NAME_BIRTHDAY_ON)
  private String birthdayOn;

  /**
   * Gets or Sets role
   */
  @JsonAdapter(RoleEnum.Adapter.class)
 public enum RoleEnum {
    BASIC("basic"),
    
    ADMIN("admin");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RoleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RoleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RoleEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RoleEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_ROLE = "role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private RoleEnum role;

  public static final String SERIALIZED_NAME_TERMINATED_ON = "terminated_on";
  @SerializedName(SERIALIZED_NAME_TERMINATED_ON)
  private String terminatedOn;

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

  public static final String SERIALIZED_NAME_IDENTIFIER = "identifier";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER)
  private String identifier;

  public static final String SERIALIZED_NAME_IDENTIFIER_TYPE = "identifier_type";
  @SerializedName(SERIALIZED_NAME_IDENTIFIER_TYPE)
  private String identifierType;

  public static final String SERIALIZED_NAME_COMPANY_ID = "company_id";
  @SerializedName(SERIALIZED_NAME_COMPANY_ID)
  private Integer companyId;

  public static final String SERIALIZED_NAME_LEGAL_ENTITY_ID = "legal_entity_id";
  @SerializedName(SERIALIZED_NAME_LEGAL_ENTITY_ID)
  private Integer legalEntityId;

  public static final String SERIALIZED_NAME_MANAGER_ID = "manager_id";
  @SerializedName(SERIALIZED_NAME_MANAGER_ID)
  private Integer managerId;

  public static final String SERIALIZED_NAME_TIMEOFF_MANAGER_ID = "timeoff_manager_id";
  @SerializedName(SERIALIZED_NAME_TIMEOFF_MANAGER_ID)
  private Integer timeoffManagerId;

  public static final String SERIALIZED_NAME_REGULAR_ACCESS_STARTS_ON = "regular_access_starts_on";
  @SerializedName(SERIALIZED_NAME_REGULAR_ACCESS_STARTS_ON)
  private String regularAccessStartsOn;

  public static final String SERIALIZED_NAME_PHONE_NUMBER = "phone_number";
  @SerializedName(SERIALIZED_NAME_PHONE_NUMBER)
  private String phoneNumber;

  public static final String SERIALIZED_NAME_SOCIAL_SECURITY_NUMBER = "social_security_number";
  @SerializedName(SERIALIZED_NAME_SOCIAL_SECURITY_NUMBER)
  private String socialSecurityNumber;

  public static final String SERIALIZED_NAME_START_DATE = "start_date";
  @SerializedName(SERIALIZED_NAME_START_DATE)
  private String startDate;

  public static final String SERIALIZED_NAME_LOCATION_ID = "location_id";
  @SerializedName(SERIALIZED_NAME_LOCATION_ID)
  private Integer locationId;

  public static final String SERIALIZED_NAME_TEAM_IDS = "team_ids";
  @SerializedName(SERIALIZED_NAME_TEAM_IDS)
  private List<Integer> teamIds = null;

  public static final String SERIALIZED_NAME_COMPANY_HOLIDAY_IDS = "company_holiday_ids";
  @SerializedName(SERIALIZED_NAME_COMPANY_HOLIDAY_IDS)
  private List<Integer> companyHolidayIds = null;

  public static final String SERIALIZED_NAME_AVATAR = "avatar";
  @SerializedName(SERIALIZED_NAME_AVATAR)
  private String avatar;

  public static final String SERIALIZED_NAME_COMPANY_IDENTIFIER = "company_identifier";
  @SerializedName(SERIALIZED_NAME_COMPANY_IDENTIFIER)
  private String companyIdentifier;

  public static final String SERIALIZED_NAME_HIRING = "hiring";
  @SerializedName(SERIALIZED_NAME_HIRING)
  private EmployeeHiring hiring;

  public Employee() {
  }

  public Employee id(Integer id) {
    
    
    
    
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


  public Employee email(String email) {
    
    
    
    
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


  public Employee firstName(String firstName) {
    
    
    
    
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


  public Employee lastName(String lastName) {
    
    
    
    
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


  public Employee fullName(String fullName) {
    
    
    
    
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


  public Employee birthdayOn(String birthdayOn) {
    
    
    
    
    this.birthdayOn = birthdayOn;
    return this;
  }

   /**
   * Get birthdayOn
   * @return birthdayOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2000-06-23", value = "")

  public String getBirthdayOn() {
    return birthdayOn;
  }


  public void setBirthdayOn(String birthdayOn) {
    
    
    
    this.birthdayOn = birthdayOn;
  }


  public Employee role(RoleEnum role) {
    
    
    
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BASIC", value = "")

  public RoleEnum getRole() {
    return role;
  }


  public void setRole(RoleEnum role) {
    
    
    
    this.role = role;
  }


  public Employee terminatedOn(String terminatedOn) {
    
    
    
    
    this.terminatedOn = terminatedOn;
    return this;
  }

   /**
   * Get terminatedOn
   * @return terminatedOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2023-06-23", value = "")

  public String getTerminatedOn() {
    return terminatedOn;
  }


  public void setTerminatedOn(String terminatedOn) {
    
    
    
    this.terminatedOn = terminatedOn;
  }


  public Employee gender(GenderEnum gender) {
    
    
    
    
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


  public Employee nationality(String nationality) {
    
    
    
    
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


  public Employee bankNumber(String bankNumber) {
    
    
    
    
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


  public Employee country(String country) {
    
    
    
    
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


  public Employee city(String city) {
    
    
    
    
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


  public Employee state(String state) {
    
    
    
    
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


  public Employee postalCode(String postalCode) {
    
    
    
    
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


  public Employee addressLine1(String addressLine1) {
    
    
    
    
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


  public Employee addressLine2(String addressLine2) {
    
    
    
    
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


  public Employee identifier(String identifier) {
    
    
    
    
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


  public Employee identifierType(String identifierType) {
    
    
    
    
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


  public Employee companyId(Integer companyId) {
    
    
    
    
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


  public Employee legalEntityId(Integer legalEntityId) {
    
    
    
    
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


  public Employee managerId(Integer managerId) {
    
    
    
    
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


  public Employee timeoffManagerId(Integer timeoffManagerId) {
    
    
    
    
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


  public Employee regularAccessStartsOn(String regularAccessStartsOn) {
    
    
    
    
    this.regularAccessStartsOn = regularAccessStartsOn;
    return this;
  }

   /**
   * Get regularAccessStartsOn
   * @return regularAccessStartsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-23", value = "")

  public String getRegularAccessStartsOn() {
    return regularAccessStartsOn;
  }


  public void setRegularAccessStartsOn(String regularAccessStartsOn) {
    
    
    
    this.regularAccessStartsOn = regularAccessStartsOn;
  }


  public Employee phoneNumber(String phoneNumber) {
    
    
    
    
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


  public Employee socialSecurityNumber(String socialSecurityNumber) {
    
    
    
    
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


  public Employee startDate(String startDate) {
    
    
    
    
    this.startDate = startDate;
    return this;
  }

   /**
   * Get startDate
   * @return startDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-23", value = "")

  public String getStartDate() {
    return startDate;
  }


  public void setStartDate(String startDate) {
    
    
    
    this.startDate = startDate;
  }


  public Employee locationId(Integer locationId) {
    
    
    
    
    this.locationId = locationId;
    return this;
  }

   /**
   * Get locationId
   * @return locationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getLocationId() {
    return locationId;
  }


  public void setLocationId(Integer locationId) {
    
    
    
    this.locationId = locationId;
  }


  public Employee teamIds(List<Integer> teamIds) {
    
    
    
    
    this.teamIds = teamIds;
    return this;
  }

  public Employee addTeamIdsItem(Integer teamIdsItem) {
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


  public Employee companyHolidayIds(List<Integer> companyHolidayIds) {
    
    
    
    
    this.companyHolidayIds = companyHolidayIds;
    return this;
  }

  public Employee addCompanyHolidayIdsItem(Integer companyHolidayIdsItem) {
    if (this.companyHolidayIds == null) {
      this.companyHolidayIds = new ArrayList<>();
    }
    this.companyHolidayIds.add(companyHolidayIdsItem);
    return this;
  }

   /**
   * Get companyHolidayIds
   * @return companyHolidayIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<Integer> getCompanyHolidayIds() {
    return companyHolidayIds;
  }


  public void setCompanyHolidayIds(List<Integer> companyHolidayIds) {
    
    
    
    this.companyHolidayIds = companyHolidayIds;
  }


  public Employee avatar(String avatar) {
    
    
    
    
    this.avatar = avatar;
    return this;
  }

   /**
   * Get avatar
   * @return avatar
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "https://api.factorialhr.com/rails/active_storage/representations/redirect/bob.png", value = "")

  public String getAvatar() {
    return avatar;
  }


  public void setAvatar(String avatar) {
    
    
    
    this.avatar = avatar;
  }


  public Employee companyIdentifier(String companyIdentifier) {
    
    
    
    
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


  public Employee hiring(EmployeeHiring hiring) {
    
    
    
    
    this.hiring = hiring;
    return this;
  }

   /**
   * Get hiring
   * @return hiring
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public EmployeeHiring getHiring() {
    return hiring;
  }


  public void setHiring(EmployeeHiring hiring) {
    
    
    
    this.hiring = hiring;
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
   * @return the Employee instance itself
   */
  public Employee putAdditionalProperty(String key, Object value) {
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
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) &&
        Objects.equals(this.email, employee.email) &&
        Objects.equals(this.firstName, employee.firstName) &&
        Objects.equals(this.lastName, employee.lastName) &&
        Objects.equals(this.fullName, employee.fullName) &&
        Objects.equals(this.birthdayOn, employee.birthdayOn) &&
        Objects.equals(this.role, employee.role) &&
        Objects.equals(this.terminatedOn, employee.terminatedOn) &&
        Objects.equals(this.gender, employee.gender) &&
        Objects.equals(this.nationality, employee.nationality) &&
        Objects.equals(this.bankNumber, employee.bankNumber) &&
        Objects.equals(this.country, employee.country) &&
        Objects.equals(this.city, employee.city) &&
        Objects.equals(this.state, employee.state) &&
        Objects.equals(this.postalCode, employee.postalCode) &&
        Objects.equals(this.addressLine1, employee.addressLine1) &&
        Objects.equals(this.addressLine2, employee.addressLine2) &&
        Objects.equals(this.identifier, employee.identifier) &&
        Objects.equals(this.identifierType, employee.identifierType) &&
        Objects.equals(this.companyId, employee.companyId) &&
        Objects.equals(this.legalEntityId, employee.legalEntityId) &&
        Objects.equals(this.managerId, employee.managerId) &&
        Objects.equals(this.timeoffManagerId, employee.timeoffManagerId) &&
        Objects.equals(this.regularAccessStartsOn, employee.regularAccessStartsOn) &&
        Objects.equals(this.phoneNumber, employee.phoneNumber) &&
        Objects.equals(this.socialSecurityNumber, employee.socialSecurityNumber) &&
        Objects.equals(this.startDate, employee.startDate) &&
        Objects.equals(this.locationId, employee.locationId) &&
        Objects.equals(this.teamIds, employee.teamIds) &&
        Objects.equals(this.companyHolidayIds, employee.companyHolidayIds) &&
        Objects.equals(this.avatar, employee.avatar) &&
        Objects.equals(this.companyIdentifier, employee.companyIdentifier) &&
        Objects.equals(this.hiring, employee.hiring)&&
        Objects.equals(this.additionalProperties, employee.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, firstName, lastName, fullName, birthdayOn, role, terminatedOn, gender, nationality, bankNumber, country, city, state, postalCode, addressLine1, addressLine2, identifier, identifierType, companyId, legalEntityId, managerId, timeoffManagerId, regularAccessStartsOn, phoneNumber, socialSecurityNumber, startDate, locationId, teamIds, companyHolidayIds, avatar, companyIdentifier, hiring, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    birthdayOn: ").append(toIndentedString(birthdayOn)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    terminatedOn: ").append(toIndentedString(terminatedOn)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
    sb.append("    bankNumber: ").append(toIndentedString(bankNumber)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
    sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    identifierType: ").append(toIndentedString(identifierType)).append("\n");
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    legalEntityId: ").append(toIndentedString(legalEntityId)).append("\n");
    sb.append("    managerId: ").append(toIndentedString(managerId)).append("\n");
    sb.append("    timeoffManagerId: ").append(toIndentedString(timeoffManagerId)).append("\n");
    sb.append("    regularAccessStartsOn: ").append(toIndentedString(regularAccessStartsOn)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    socialSecurityNumber: ").append(toIndentedString(socialSecurityNumber)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    locationId: ").append(toIndentedString(locationId)).append("\n");
    sb.append("    teamIds: ").append(toIndentedString(teamIds)).append("\n");
    sb.append("    companyHolidayIds: ").append(toIndentedString(companyHolidayIds)).append("\n");
    sb.append("    avatar: ").append(toIndentedString(avatar)).append("\n");
    sb.append("    companyIdentifier: ").append(toIndentedString(companyIdentifier)).append("\n");
    sb.append("    hiring: ").append(toIndentedString(hiring)).append("\n");
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
    openapiFields.add("email");
    openapiFields.add("first_name");
    openapiFields.add("last_name");
    openapiFields.add("full_name");
    openapiFields.add("birthday_on");
    openapiFields.add("role");
    openapiFields.add("terminated_on");
    openapiFields.add("gender");
    openapiFields.add("nationality");
    openapiFields.add("bank_number");
    openapiFields.add("country");
    openapiFields.add("city");
    openapiFields.add("state");
    openapiFields.add("postal_code");
    openapiFields.add("address_line_1");
    openapiFields.add("address_line_2");
    openapiFields.add("identifier");
    openapiFields.add("identifier_type");
    openapiFields.add("company_id");
    openapiFields.add("legal_entity_id");
    openapiFields.add("manager_id");
    openapiFields.add("timeoff_manager_id");
    openapiFields.add("regular_access_starts_on");
    openapiFields.add("phone_number");
    openapiFields.add("social_security_number");
    openapiFields.add("start_date");
    openapiFields.add("location_id");
    openapiFields.add("team_ids");
    openapiFields.add("company_holiday_ids");
    openapiFields.add("avatar");
    openapiFields.add("company_identifier");
    openapiFields.add("hiring");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Employee
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Employee.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Employee is not found in the empty JSON string", Employee.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("email") != null && !jsonObj.get("email").isJsonNull()) && !jsonObj.get("email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("email").toString()));
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
      if ((jsonObj.get("birthday_on") != null && !jsonObj.get("birthday_on").isJsonNull()) && !jsonObj.get("birthday_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `birthday_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("birthday_on").toString()));
      }
      if ((jsonObj.get("role") != null && !jsonObj.get("role").isJsonNull()) && !jsonObj.get("role").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `role` to be a primitive type in the JSON string but got `%s`", jsonObj.get("role").toString()));
      }
      if ((jsonObj.get("terminated_on") != null && !jsonObj.get("terminated_on").isJsonNull()) && !jsonObj.get("terminated_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `terminated_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("terminated_on").toString()));
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
      if ((jsonObj.get("identifier") != null && !jsonObj.get("identifier").isJsonNull()) && !jsonObj.get("identifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifier").toString()));
      }
      if ((jsonObj.get("identifier_type") != null && !jsonObj.get("identifier_type").isJsonNull()) && !jsonObj.get("identifier_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `identifier_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("identifier_type").toString()));
      }
      if ((jsonObj.get("regular_access_starts_on") != null && !jsonObj.get("regular_access_starts_on").isJsonNull()) && !jsonObj.get("regular_access_starts_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `regular_access_starts_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("regular_access_starts_on").toString()));
      }
      if ((jsonObj.get("phone_number") != null && !jsonObj.get("phone_number").isJsonNull()) && !jsonObj.get("phone_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `phone_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("phone_number").toString()));
      }
      if ((jsonObj.get("social_security_number") != null && !jsonObj.get("social_security_number").isJsonNull()) && !jsonObj.get("social_security_number").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `social_security_number` to be a primitive type in the JSON string but got `%s`", jsonObj.get("social_security_number").toString()));
      }
      if ((jsonObj.get("start_date") != null && !jsonObj.get("start_date").isJsonNull()) && !jsonObj.get("start_date").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `start_date` to be a primitive type in the JSON string but got `%s`", jsonObj.get("start_date").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("team_ids") != null && !jsonObj.get("team_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `team_ids` to be an array in the JSON string but got `%s`", jsonObj.get("team_ids").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("company_holiday_ids") != null && !jsonObj.get("company_holiday_ids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `company_holiday_ids` to be an array in the JSON string but got `%s`", jsonObj.get("company_holiday_ids").toString()));
      }
      if ((jsonObj.get("avatar") != null && !jsonObj.get("avatar").isJsonNull()) && !jsonObj.get("avatar").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `avatar` to be a primitive type in the JSON string but got `%s`", jsonObj.get("avatar").toString()));
      }
      if ((jsonObj.get("company_identifier") != null && !jsonObj.get("company_identifier").isJsonNull()) && !jsonObj.get("company_identifier").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `company_identifier` to be a primitive type in the JSON string but got `%s`", jsonObj.get("company_identifier").toString()));
      }
      // validate the optional field `hiring`
      if (jsonObj.get("hiring") != null && !jsonObj.get("hiring").isJsonNull()) {
        EmployeeHiring.validateJsonObject(jsonObj.getAsJsonObject("hiring"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Employee.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Employee' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Employee> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Employee.class));

       return (TypeAdapter<T>) new TypeAdapter<Employee>() {
           @Override
           public void write(JsonWriter out, Employee value) throws IOException {
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
           public Employee read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             Employee instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of Employee given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Employee
  * @throws IOException if the JSON string is invalid with respect to Employee
  */
  public static Employee fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Employee.class);
  }

 /**
  * Convert an instance of Employee to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

