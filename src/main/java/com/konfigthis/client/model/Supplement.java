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
 * Supplement
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class Supplement {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_EMPLOYEE_ID = "employee_id";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_ID)
  private Integer employeeId;

  public static final String SERIALIZED_NAME_CONTRACTS_COMPENSATION_ID = "contracts_compensation_id";
  @SerializedName(SERIALIZED_NAME_CONTRACTS_COMPENSATION_ID)
  private Integer contractsCompensationId;

  public static final String SERIALIZED_NAME_CONTRACTS_TAXONOMY_ID = "contracts_taxonomy_id";
  @SerializedName(SERIALIZED_NAME_CONTRACTS_TAXONOMY_ID)
  private Integer contractsTaxonomyId;

  public static final String SERIALIZED_NAME_AMOUNT_IN_CENTS = "amount_in_cents";
  @SerializedName(SERIALIZED_NAME_AMOUNT_IN_CENTS)
  private Integer amountInCents;

  public static final String SERIALIZED_NAME_UNIT = "unit";
  @SerializedName(SERIALIZED_NAME_UNIT)
  private String unit;

  public static final String SERIALIZED_NAME_EFFECTIVE_ON = "effective_on";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_ON)
  private String effectiveOn;

  public static final String SERIALIZED_NAME_UPDATED_AT = "updated_at";
  @SerializedName(SERIALIZED_NAME_UPDATED_AT)
  private String updatedAt;

  public static final String SERIALIZED_NAME_DESCRIPTION_ENTITY = "description_entity";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION_ENTITY)
  private String descriptionEntity;

  public static final String SERIALIZED_NAME_CREATED_BY_ACCESS_ID = "created_by_access_id";
  @SerializedName(SERIALIZED_NAME_CREATED_BY_ACCESS_ID)
  private Integer createdByAccessId;

  public static final String SERIALIZED_NAME_PAYROLL_POLICY_PERIOD_ID = "payroll_policy_period_id";
  @SerializedName(SERIALIZED_NAME_PAYROLL_POLICY_PERIOD_ID)
  private Integer payrollPolicyPeriodId;

  public Supplement() {
  }

  public Supplement id(Integer id) {
    
    
    
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    
    
    
    this.id = id;
  }


  public Supplement employeeId(Integer employeeId) {
    
    
    
    
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getEmployeeId() {
    return employeeId;
  }


  public void setEmployeeId(Integer employeeId) {
    
    
    
    this.employeeId = employeeId;
  }


  public Supplement contractsCompensationId(Integer contractsCompensationId) {
    
    
    
    
    this.contractsCompensationId = contractsCompensationId;
    return this;
  }

   /**
   * Get contractsCompensationId
   * @return contractsCompensationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getContractsCompensationId() {
    return contractsCompensationId;
  }


  public void setContractsCompensationId(Integer contractsCompensationId) {
    
    
    
    this.contractsCompensationId = contractsCompensationId;
  }


  public Supplement contractsTaxonomyId(Integer contractsTaxonomyId) {
    
    
    
    
    this.contractsTaxonomyId = contractsTaxonomyId;
    return this;
  }

   /**
   * Get contractsTaxonomyId
   * @return contractsTaxonomyId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getContractsTaxonomyId() {
    return contractsTaxonomyId;
  }


  public void setContractsTaxonomyId(Integer contractsTaxonomyId) {
    
    
    
    this.contractsTaxonomyId = contractsTaxonomyId;
  }


  public Supplement amountInCents(Integer amountInCents) {
    
    
    
    
    this.amountInCents = amountInCents;
    return this;
  }

   /**
   * Get amountInCents
   * @return amountInCents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "30000", value = "")

  public Integer getAmountInCents() {
    return amountInCents;
  }


  public void setAmountInCents(Integer amountInCents) {
    
    
    
    this.amountInCents = amountInCents;
  }


  public Supplement unit(String unit) {
    
    
    
    
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "usd", value = "")

  public String getUnit() {
    return unit;
  }


  public void setUnit(String unit) {
    
    
    
    this.unit = unit;
  }


  public Supplement effectiveOn(String effectiveOn) {
    
    
    
    
    this.effectiveOn = effectiveOn;
    return this;
  }

   /**
   * Get effectiveOn
   * @return effectiveOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-03-13", value = "")

  public String getEffectiveOn() {
    return effectiveOn;
  }


  public void setEffectiveOn(String effectiveOn) {
    
    
    
    this.effectiveOn = effectiveOn;
  }


  public Supplement updatedAt(String updatedAt) {
    
    
    
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Get updatedAt
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-03-15", value = "")

  public String getUpdatedAt() {
    return updatedAt;
  }


  public void setUpdatedAt(String updatedAt) {
    
    
    
    this.updatedAt = updatedAt;
  }


  public Supplement descriptionEntity(String descriptionEntity) {
    
    
    
    
    this.descriptionEntity = descriptionEntity;
    return this;
  }

   /**
   * Get descriptionEntity
   * @return descriptionEntity
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Performance supplement", value = "")

  public String getDescriptionEntity() {
    return descriptionEntity;
  }


  public void setDescriptionEntity(String descriptionEntity) {
    
    
    
    this.descriptionEntity = descriptionEntity;
  }


  public Supplement createdByAccessId(Integer createdByAccessId) {
    
    
    
    
    this.createdByAccessId = createdByAccessId;
    return this;
  }

   /**
   * Get createdByAccessId
   * @return createdByAccessId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "6", value = "")

  public Integer getCreatedByAccessId() {
    return createdByAccessId;
  }


  public void setCreatedByAccessId(Integer createdByAccessId) {
    
    
    
    this.createdByAccessId = createdByAccessId;
  }


  public Supplement payrollPolicyPeriodId(Integer payrollPolicyPeriodId) {
    
    
    
    
    this.payrollPolicyPeriodId = payrollPolicyPeriodId;
    return this;
  }

   /**
   * Get payrollPolicyPeriodId
   * @return payrollPolicyPeriodId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "")

  public Integer getPayrollPolicyPeriodId() {
    return payrollPolicyPeriodId;
  }


  public void setPayrollPolicyPeriodId(Integer payrollPolicyPeriodId) {
    
    
    
    this.payrollPolicyPeriodId = payrollPolicyPeriodId;
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
   * @return the Supplement instance itself
   */
  public Supplement putAdditionalProperty(String key, Object value) {
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
    Supplement supplement = (Supplement) o;
    return Objects.equals(this.id, supplement.id) &&
        Objects.equals(this.employeeId, supplement.employeeId) &&
        Objects.equals(this.contractsCompensationId, supplement.contractsCompensationId) &&
        Objects.equals(this.contractsTaxonomyId, supplement.contractsTaxonomyId) &&
        Objects.equals(this.amountInCents, supplement.amountInCents) &&
        Objects.equals(this.unit, supplement.unit) &&
        Objects.equals(this.effectiveOn, supplement.effectiveOn) &&
        Objects.equals(this.updatedAt, supplement.updatedAt) &&
        Objects.equals(this.descriptionEntity, supplement.descriptionEntity) &&
        Objects.equals(this.createdByAccessId, supplement.createdByAccessId) &&
        Objects.equals(this.payrollPolicyPeriodId, supplement.payrollPolicyPeriodId)&&
        Objects.equals(this.additionalProperties, supplement.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, employeeId, contractsCompensationId, contractsTaxonomyId, amountInCents, unit, effectiveOn, updatedAt, descriptionEntity, createdByAccessId, payrollPolicyPeriodId, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Supplement {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    contractsCompensationId: ").append(toIndentedString(contractsCompensationId)).append("\n");
    sb.append("    contractsTaxonomyId: ").append(toIndentedString(contractsTaxonomyId)).append("\n");
    sb.append("    amountInCents: ").append(toIndentedString(amountInCents)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    effectiveOn: ").append(toIndentedString(effectiveOn)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    descriptionEntity: ").append(toIndentedString(descriptionEntity)).append("\n");
    sb.append("    createdByAccessId: ").append(toIndentedString(createdByAccessId)).append("\n");
    sb.append("    payrollPolicyPeriodId: ").append(toIndentedString(payrollPolicyPeriodId)).append("\n");
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
    openapiFields.add("employee_id");
    openapiFields.add("contracts_compensation_id");
    openapiFields.add("contracts_taxonomy_id");
    openapiFields.add("amount_in_cents");
    openapiFields.add("unit");
    openapiFields.add("effective_on");
    openapiFields.add("updated_at");
    openapiFields.add("description_entity");
    openapiFields.add("created_by_access_id");
    openapiFields.add("payroll_policy_period_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Supplement
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Supplement.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Supplement is not found in the empty JSON string", Supplement.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("unit") != null && !jsonObj.get("unit").isJsonNull()) && !jsonObj.get("unit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unit").toString()));
      }
      if ((jsonObj.get("effective_on") != null && !jsonObj.get("effective_on").isJsonNull()) && !jsonObj.get("effective_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `effective_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("effective_on").toString()));
      }
      if ((jsonObj.get("updated_at") != null && !jsonObj.get("updated_at").isJsonNull()) && !jsonObj.get("updated_at").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `updated_at` to be a primitive type in the JSON string but got `%s`", jsonObj.get("updated_at").toString()));
      }
      if ((jsonObj.get("description_entity") != null && !jsonObj.get("description_entity").isJsonNull()) && !jsonObj.get("description_entity").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description_entity` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description_entity").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Supplement.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Supplement' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Supplement> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Supplement.class));

       return (TypeAdapter<T>) new TypeAdapter<Supplement>() {
           @Override
           public void write(JsonWriter out, Supplement value) throws IOException {
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
           public Supplement read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             Supplement instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of Supplement given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Supplement
  * @throws IOException if the JSON string is invalid with respect to Supplement
  */
  public static Supplement fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Supplement.class);
  }

 /**
  * Convert an instance of Supplement to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

