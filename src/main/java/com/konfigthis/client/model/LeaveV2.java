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
 * LeaveV2
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class LeaveV2 {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_APPROVED = "approved";
  @SerializedName(SERIALIZED_NAME_APPROVED)
  private Boolean approved;

  public static final String SERIALIZED_NAME_EMPLOYEE_ID = "employee_id";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_ID)
  private Integer employeeId;

  public static final String SERIALIZED_NAME_START_ON = "start_on";
  @SerializedName(SERIALIZED_NAME_START_ON)
  private String startOn;

  public static final String SERIALIZED_NAME_FINISH_ON = "finish_on";
  @SerializedName(SERIALIZED_NAME_FINISH_ON)
  private String finishOn;

  /**
   * Gets or Sets halfDay
   */
  @JsonAdapter(HalfDayEnum.Adapter.class)
 public enum HalfDayEnum {
    BEGGINING_OF_DAY("beggining_of_day"),
    
    END_OF_DAY("end_of_day");

    private String value;

    HalfDayEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static HalfDayEnum fromValue(String value) {
      for (HalfDayEnum b : HalfDayEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<HalfDayEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final HalfDayEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public HalfDayEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return HalfDayEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_HALF_DAY = "half_day";
  @SerializedName(SERIALIZED_NAME_HALF_DAY)
  private HalfDayEnum halfDay;

  public static final String SERIALIZED_NAME_LEAVE_TYPE_ID = "leave_type_id";
  @SerializedName(SERIALIZED_NAME_LEAVE_TYPE_ID)
  private Integer leaveTypeId;

  public static final String SERIALIZED_NAME_LEAVE_TYPE_NAME = "leave_type_name";
  @SerializedName(SERIALIZED_NAME_LEAVE_TYPE_NAME)
  private String leaveTypeName;

  public static final String SERIALIZED_NAME_EMPLOYEE_FULL_NAME = "employee_full_name";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_FULL_NAME)
  private String employeeFullName;

  public LeaveV2() {
  }

  public LeaveV2 description(String description) {
    
    
    
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Medical appointment for 4 hours", value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    
    
    
    this.description = description;
  }


  public LeaveV2 id(Integer id) {
    
    
    
    
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


  public LeaveV2 approved(Boolean approved) {
    
    
    
    
    this.approved = approved;
    return this;
  }

   /**
   * Get approved
   * @return approved
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "true", value = "")

  public Boolean getApproved() {
    return approved;
  }


  public void setApproved(Boolean approved) {
    
    
    
    this.approved = approved;
  }


  public LeaveV2 employeeId(Integer employeeId) {
    
    
    
    
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "7", value = "")

  public Integer getEmployeeId() {
    return employeeId;
  }


  public void setEmployeeId(Integer employeeId) {
    
    
    
    this.employeeId = employeeId;
  }


  public LeaveV2 startOn(String startOn) {
    
    
    
    
    this.startOn = startOn;
    return this;
  }

   /**
   * Get startOn
   * @return startOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-04-29T12:00:00.000+00:00", value = "")

  public String getStartOn() {
    return startOn;
  }


  public void setStartOn(String startOn) {
    
    
    
    this.startOn = startOn;
  }


  public LeaveV2 finishOn(String finishOn) {
    
    
    
    
    this.finishOn = finishOn;
    return this;
  }

   /**
   * Get finishOn
   * @return finishOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-04-29T16:00:00.000+00:00", value = "")

  public String getFinishOn() {
    return finishOn;
  }


  public void setFinishOn(String finishOn) {
    
    
    
    this.finishOn = finishOn;
  }


  public LeaveV2 halfDay(HalfDayEnum halfDay) {
    
    
    
    
    this.halfDay = halfDay;
    return this;
  }

   /**
   * Get halfDay
   * @return halfDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "END_OF_DAY", value = "")

  public HalfDayEnum getHalfDay() {
    return halfDay;
  }


  public void setHalfDay(HalfDayEnum halfDay) {
    
    
    
    this.halfDay = halfDay;
  }


  public LeaveV2 leaveTypeId(Integer leaveTypeId) {
    
    
    
    
    this.leaveTypeId = leaveTypeId;
    return this;
  }

   /**
   * Get leaveTypeId
   * @return leaveTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getLeaveTypeId() {
    return leaveTypeId;
  }


  public void setLeaveTypeId(Integer leaveTypeId) {
    
    
    
    this.leaveTypeId = leaveTypeId;
  }


  public LeaveV2 leaveTypeName(String leaveTypeName) {
    
    
    
    
    this.leaveTypeName = leaveTypeName;
    return this;
  }

   /**
   * Get leaveTypeName
   * @return leaveTypeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Medical appointment", value = "")

  public String getLeaveTypeName() {
    return leaveTypeName;
  }


  public void setLeaveTypeName(String leaveTypeName) {
    
    
    
    this.leaveTypeName = leaveTypeName;
  }


  public LeaveV2 employeeFullName(String employeeFullName) {
    
    
    
    
    this.employeeFullName = employeeFullName;
    return this;
  }

   /**
   * Get employeeFullName
   * @return employeeFullName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "Hellen Factorial", value = "")

  public String getEmployeeFullName() {
    return employeeFullName;
  }


  public void setEmployeeFullName(String employeeFullName) {
    
    
    
    this.employeeFullName = employeeFullName;
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
   * @return the LeaveV2 instance itself
   */
  public LeaveV2 putAdditionalProperty(String key, Object value) {
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
    LeaveV2 leaveV2 = (LeaveV2) o;
    return Objects.equals(this.description, leaveV2.description) &&
        Objects.equals(this.id, leaveV2.id) &&
        Objects.equals(this.approved, leaveV2.approved) &&
        Objects.equals(this.employeeId, leaveV2.employeeId) &&
        Objects.equals(this.startOn, leaveV2.startOn) &&
        Objects.equals(this.finishOn, leaveV2.finishOn) &&
        Objects.equals(this.halfDay, leaveV2.halfDay) &&
        Objects.equals(this.leaveTypeId, leaveV2.leaveTypeId) &&
        Objects.equals(this.leaveTypeName, leaveV2.leaveTypeName) &&
        Objects.equals(this.employeeFullName, leaveV2.employeeFullName)&&
        Objects.equals(this.additionalProperties, leaveV2.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, id, approved, employeeId, startOn, finishOn, halfDay, leaveTypeId, leaveTypeName, employeeFullName, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LeaveV2 {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    approved: ").append(toIndentedString(approved)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    startOn: ").append(toIndentedString(startOn)).append("\n");
    sb.append("    finishOn: ").append(toIndentedString(finishOn)).append("\n");
    sb.append("    halfDay: ").append(toIndentedString(halfDay)).append("\n");
    sb.append("    leaveTypeId: ").append(toIndentedString(leaveTypeId)).append("\n");
    sb.append("    leaveTypeName: ").append(toIndentedString(leaveTypeName)).append("\n");
    sb.append("    employeeFullName: ").append(toIndentedString(employeeFullName)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("approved");
    openapiFields.add("employee_id");
    openapiFields.add("start_on");
    openapiFields.add("finish_on");
    openapiFields.add("half_day");
    openapiFields.add("leave_type_id");
    openapiFields.add("leave_type_name");
    openapiFields.add("employee_full_name");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to LeaveV2
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!LeaveV2.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LeaveV2 is not found in the empty JSON string", LeaveV2.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if ((jsonObj.get("start_on") != null && !jsonObj.get("start_on").isJsonNull()) && !jsonObj.get("start_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `start_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("start_on").toString()));
      }
      if ((jsonObj.get("finish_on") != null && !jsonObj.get("finish_on").isJsonNull()) && !jsonObj.get("finish_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `finish_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("finish_on").toString()));
      }
      if ((jsonObj.get("half_day") != null && !jsonObj.get("half_day").isJsonNull()) && !jsonObj.get("half_day").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `half_day` to be a primitive type in the JSON string but got `%s`", jsonObj.get("half_day").toString()));
      }
      if ((jsonObj.get("leave_type_name") != null && !jsonObj.get("leave_type_name").isJsonNull()) && !jsonObj.get("leave_type_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `leave_type_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("leave_type_name").toString()));
      }
      if ((jsonObj.get("employee_full_name") != null && !jsonObj.get("employee_full_name").isJsonNull()) && !jsonObj.get("employee_full_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `employee_full_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("employee_full_name").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LeaveV2.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LeaveV2' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LeaveV2> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LeaveV2.class));

       return (TypeAdapter<T>) new TypeAdapter<LeaveV2>() {
           @Override
           public void write(JsonWriter out, LeaveV2 value) throws IOException {
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
           public LeaveV2 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             LeaveV2 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of LeaveV2 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of LeaveV2
  * @throws IOException if the JSON string is invalid with respect to LeaveV2
  */
  public static LeaveV2 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LeaveV2.class);
  }

 /**
  * Convert an instance of LeaveV2 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

