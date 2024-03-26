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
 * CompensationUpdateForContractRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CompensationUpdateForContractRequest {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_CONTRACTS_TAXONOMY_ID = "contracts_taxonomy_id";
  @SerializedName(SERIALIZED_NAME_CONTRACTS_TAXONOMY_ID)
  private Integer contractsTaxonomyId;

  /**
   * Gets or Sets compensationType
   */
  @JsonAdapter(CompensationTypeEnum.Adapter.class)
 public enum CompensationTypeEnum {
    FIXED("fixed"),
    
    UP_TO("up_to");

    private String value;

    CompensationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CompensationTypeEnum fromValue(String value) {
      for (CompensationTypeEnum b : CompensationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CompensationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CompensationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CompensationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CompensationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_COMPENSATION_TYPE = "compensation_type";
  @SerializedName(SERIALIZED_NAME_COMPENSATION_TYPE)
  private CompensationTypeEnum compensationType;

  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Integer amount;

  /**
   * Gets or Sets unit
   */
  @JsonAdapter(UnitEnum.Adapter.class)
 public enum UnitEnum {
    MONEY("money"),
    
    UNITS("units");

    private String value;

    UnitEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static UnitEnum fromValue(String value) {
      for (UnitEnum b : UnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<UnitEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final UnitEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public UnitEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return UnitEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_UNIT = "unit";
  @SerializedName(SERIALIZED_NAME_UNIT)
  private UnitEnum unit;

  public static final String SERIALIZED_NAME_SYNC_WITH_SUPPLEMENTS = "sync_with_supplements";
  @SerializedName(SERIALIZED_NAME_SYNC_WITH_SUPPLEMENTS)
  private Boolean syncWithSupplements;

  public static final String SERIALIZED_NAME_PAYROLL_POLICY_ID = "payroll_policy_id";
  @SerializedName(SERIALIZED_NAME_PAYROLL_POLICY_ID)
  private Integer payrollPolicyId;

  public static final String SERIALIZED_NAME_RECURRENCE_COUNT = "recurrence_count";
  @SerializedName(SERIALIZED_NAME_RECURRENCE_COUNT)
  private Integer recurrenceCount;

  public static final String SERIALIZED_NAME_STARTS_ON = "starts_on";
  @SerializedName(SERIALIZED_NAME_STARTS_ON)
  private String startsOn;

  /**
   * Gets or Sets recurrence
   */
  @JsonAdapter(RecurrenceEnum.Adapter.class)
 public enum RecurrenceEnum {
    MONTHLY("monthly"),
    
    EVERY_2_MONTHS("every_2_months"),
    
    EVERY_3_MONTHS("every_3_months"),
    
    EVERY_4_MONTHS("every_4_months"),
    
    EVERY_5_MONTHS("every_5_months"),
    
    EVERY_6_MONTHS("every_6_months"),
    
    EVERY_7_MONTHS("every_7_months"),
    
    EVERY_8_MONTHS("every_8_months"),
    
    EVERY_9_MONTHS("every_9_months"),
    
    EVERY_10_MONTHS("every_10_months"),
    
    EVERY_11_MONTHS("every_11_months"),
    
    EVERY_12_MONTHS("every_12_months");

    private String value;

    RecurrenceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RecurrenceEnum fromValue(String value) {
      for (RecurrenceEnum b : RecurrenceEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<RecurrenceEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final RecurrenceEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public RecurrenceEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return RecurrenceEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_RECURRENCE = "recurrence";
  @SerializedName(SERIALIZED_NAME_RECURRENCE)
  private RecurrenceEnum recurrence;

  public static final String SERIALIZED_NAME_FIRST_PAYMENT_ON = "first_payment_on";
  @SerializedName(SERIALIZED_NAME_FIRST_PAYMENT_ON)
  private String firstPaymentOn;

  /**
   * Gets or Sets calculation
   */
  @JsonAdapter(CalculationEnum.Adapter.class)
 public enum CalculationEnum {
    CURRENT_PERIOD("current_period"),
    
    PREVIOUS_PERIOD_("previous_period'");

    private String value;

    CalculationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CalculationEnum fromValue(String value) {
      for (CalculationEnum b : CalculationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<CalculationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CalculationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CalculationEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return CalculationEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_CALCULATION = "calculation";
  @SerializedName(SERIALIZED_NAME_CALCULATION)
  private CalculationEnum calculation;

  public CompensationUpdateForContractRequest() {
  }

  public CompensationUpdateForContractRequest description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Meal 2", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public CompensationUpdateForContractRequest contractsTaxonomyId(Integer contractsTaxonomyId) {
    
    
    
    
    this.contractsTaxonomyId = contractsTaxonomyId;
    return this;
  }

   /**
   * Get contractsTaxonomyId
   * @return contractsTaxonomyId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getContractsTaxonomyId() {
    return contractsTaxonomyId;
  }


  public void setContractsTaxonomyId(Integer contractsTaxonomyId) {
    
    
    
    this.contractsTaxonomyId = contractsTaxonomyId;
  }


  public CompensationUpdateForContractRequest compensationType(CompensationTypeEnum compensationType) {
    
    
    
    
    this.compensationType = compensationType;
    return this;
  }

   /**
   * Get compensationType
   * @return compensationType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "FIXED", value = "")

  public CompensationTypeEnum getCompensationType() {
    return compensationType;
  }


  public void setCompensationType(CompensationTypeEnum compensationType) {
    
    
    
    this.compensationType = compensationType;
  }


  public CompensationUpdateForContractRequest amount(Integer amount) {
    
    
    
    
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2112", value = "")

  public Integer getAmount() {
    return amount;
  }


  public void setAmount(Integer amount) {
    
    
    
    this.amount = amount;
  }


  public CompensationUpdateForContractRequest unit(UnitEnum unit) {
    
    
    
    
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "MONEY", value = "")

  public UnitEnum getUnit() {
    return unit;
  }


  public void setUnit(UnitEnum unit) {
    
    
    
    this.unit = unit;
  }


  public CompensationUpdateForContractRequest syncWithSupplements(Boolean syncWithSupplements) {
    
    
    
    
    this.syncWithSupplements = syncWithSupplements;
    return this;
  }

   /**
   * Get syncWithSupplements
   * @return syncWithSupplements
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getSyncWithSupplements() {
    return syncWithSupplements;
  }


  public void setSyncWithSupplements(Boolean syncWithSupplements) {
    
    
    
    this.syncWithSupplements = syncWithSupplements;
  }


  public CompensationUpdateForContractRequest payrollPolicyId(Integer payrollPolicyId) {
    
    
    
    
    this.payrollPolicyId = payrollPolicyId;
    return this;
  }

   /**
   * Get payrollPolicyId
   * @return payrollPolicyId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getPayrollPolicyId() {
    return payrollPolicyId;
  }


  public void setPayrollPolicyId(Integer payrollPolicyId) {
    
    
    
    this.payrollPolicyId = payrollPolicyId;
  }


  public CompensationUpdateForContractRequest recurrenceCount(Integer recurrenceCount) {
    
    
    
    
    this.recurrenceCount = recurrenceCount;
    return this;
  }

   /**
   * Get recurrenceCount
   * @return recurrenceCount
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getRecurrenceCount() {
    return recurrenceCount;
  }


  public void setRecurrenceCount(Integer recurrenceCount) {
    
    
    
    this.recurrenceCount = recurrenceCount;
  }


  public CompensationUpdateForContractRequest startsOn(String startsOn) {
    
    
    
    
    this.startsOn = startsOn;
    return this;
  }

   /**
   * Get startsOn
   * @return startsOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-08-02", value = "")

  public String getStartsOn() {
    return startsOn;
  }


  public void setStartsOn(String startsOn) {
    
    
    
    this.startsOn = startsOn;
  }


  public CompensationUpdateForContractRequest recurrence(RecurrenceEnum recurrence) {
    
    
    
    
    this.recurrence = recurrence;
    return this;
  }

   /**
   * Get recurrence
   * @return recurrence
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "MONTHLY", value = "")

  public RecurrenceEnum getRecurrence() {
    return recurrence;
  }


  public void setRecurrence(RecurrenceEnum recurrence) {
    
    
    
    this.recurrence = recurrence;
  }


  public CompensationUpdateForContractRequest firstPaymentOn(String firstPaymentOn) {
    
    
    
    
    this.firstPaymentOn = firstPaymentOn;
    return this;
  }

   /**
   * Get firstPaymentOn
   * @return firstPaymentOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-08-02", value = "")

  public String getFirstPaymentOn() {
    return firstPaymentOn;
  }


  public void setFirstPaymentOn(String firstPaymentOn) {
    
    
    
    this.firstPaymentOn = firstPaymentOn;
  }


  public CompensationUpdateForContractRequest calculation(CalculationEnum calculation) {
    
    
    
    
    this.calculation = calculation;
    return this;
  }

   /**
   * Get calculation
   * @return calculation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "CURRENT_PERIOD", value = "")

  public CalculationEnum getCalculation() {
    return calculation;
  }


  public void setCalculation(CalculationEnum calculation) {
    
    
    
    this.calculation = calculation;
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
   * @return the CompensationUpdateForContractRequest instance itself
   */
  public CompensationUpdateForContractRequest putAdditionalProperty(String key, Object value) {
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
    CompensationUpdateForContractRequest compensationUpdateForContractRequest = (CompensationUpdateForContractRequest) o;
    return Objects.equals(this.description, compensationUpdateForContractRequest.description) &&
        Objects.equals(this.contractsTaxonomyId, compensationUpdateForContractRequest.contractsTaxonomyId) &&
        Objects.equals(this.compensationType, compensationUpdateForContractRequest.compensationType) &&
        Objects.equals(this.amount, compensationUpdateForContractRequest.amount) &&
        Objects.equals(this.unit, compensationUpdateForContractRequest.unit) &&
        Objects.equals(this.syncWithSupplements, compensationUpdateForContractRequest.syncWithSupplements) &&
        Objects.equals(this.payrollPolicyId, compensationUpdateForContractRequest.payrollPolicyId) &&
        Objects.equals(this.recurrenceCount, compensationUpdateForContractRequest.recurrenceCount) &&
        Objects.equals(this.startsOn, compensationUpdateForContractRequest.startsOn) &&
        Objects.equals(this.recurrence, compensationUpdateForContractRequest.recurrence) &&
        Objects.equals(this.firstPaymentOn, compensationUpdateForContractRequest.firstPaymentOn) &&
        Objects.equals(this.calculation, compensationUpdateForContractRequest.calculation)&&
        Objects.equals(this.additionalProperties, compensationUpdateForContractRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, contractsTaxonomyId, compensationType, amount, unit, syncWithSupplements, payrollPolicyId, recurrenceCount, startsOn, recurrence, firstPaymentOn, calculation, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompensationUpdateForContractRequest {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    contractsTaxonomyId: ").append(toIndentedString(contractsTaxonomyId)).append("\n");
    sb.append("    compensationType: ").append(toIndentedString(compensationType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    syncWithSupplements: ").append(toIndentedString(syncWithSupplements)).append("\n");
    sb.append("    payrollPolicyId: ").append(toIndentedString(payrollPolicyId)).append("\n");
    sb.append("    recurrenceCount: ").append(toIndentedString(recurrenceCount)).append("\n");
    sb.append("    startsOn: ").append(toIndentedString(startsOn)).append("\n");
    sb.append("    recurrence: ").append(toIndentedString(recurrence)).append("\n");
    sb.append("    firstPaymentOn: ").append(toIndentedString(firstPaymentOn)).append("\n");
    sb.append("    calculation: ").append(toIndentedString(calculation)).append("\n");
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
    openapiFields.add("description");
    openapiFields.add("contracts_taxonomy_id");
    openapiFields.add("compensation_type");
    openapiFields.add("amount");
    openapiFields.add("unit");
    openapiFields.add("sync_with_supplements");
    openapiFields.add("payroll_policy_id");
    openapiFields.add("recurrence_count");
    openapiFields.add("starts_on");
    openapiFields.add("recurrence");
    openapiFields.add("first_payment_on");
    openapiFields.add("calculation");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CompensationUpdateForContractRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CompensationUpdateForContractRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CompensationUpdateForContractRequest is not found in the empty JSON string", CompensationUpdateForContractRequest.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("compensation_type") != null && !jsonObj.get("compensation_type").isJsonNull()) && !jsonObj.get("compensation_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `compensation_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("compensation_type").toString()));
      }
      if ((jsonObj.get("unit") != null && !jsonObj.get("unit").isJsonNull()) && !jsonObj.get("unit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unit").toString()));
      }
      if ((jsonObj.get("starts_on") != null && !jsonObj.get("starts_on").isJsonNull()) && !jsonObj.get("starts_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `starts_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("starts_on").toString()));
      }
      if ((jsonObj.get("recurrence") != null && !jsonObj.get("recurrence").isJsonNull()) && !jsonObj.get("recurrence").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `recurrence` to be a primitive type in the JSON string but got `%s`", jsonObj.get("recurrence").toString()));
      }
      if ((jsonObj.get("first_payment_on") != null && !jsonObj.get("first_payment_on").isJsonNull()) && !jsonObj.get("first_payment_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `first_payment_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("first_payment_on").toString()));
      }
      if ((jsonObj.get("calculation") != null && !jsonObj.get("calculation").isJsonNull()) && !jsonObj.get("calculation").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `calculation` to be a primitive type in the JSON string but got `%s`", jsonObj.get("calculation").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CompensationUpdateForContractRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CompensationUpdateForContractRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CompensationUpdateForContractRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CompensationUpdateForContractRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CompensationUpdateForContractRequest>() {
           @Override
           public void write(JsonWriter out, CompensationUpdateForContractRequest value) throws IOException {
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
           public CompensationUpdateForContractRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CompensationUpdateForContractRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CompensationUpdateForContractRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CompensationUpdateForContractRequest
  * @throws IOException if the JSON string is invalid with respect to CompensationUpdateForContractRequest
  */
  public static CompensationUpdateForContractRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CompensationUpdateForContractRequest.class);
  }

 /**
  * Convert an instance of CompensationUpdateForContractRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

