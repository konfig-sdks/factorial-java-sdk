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
import com.konfigthis.client.model.CustomFieldCreateFieldRequestChoiceOptionsInner;
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
 * CustomFieldCreateFieldRequest
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class CustomFieldCreateFieldRequest {
  public static final String SERIALIZED_NAME_LABEL = "label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_SLUG_NAME = "slug_name";
  @SerializedName(SERIALIZED_NAME_SLUG_NAME)
  private String slugName;

  /**
   * Gets or Sets fieldType
   */
  @JsonAdapter(FieldTypeEnum.Adapter.class)
 public enum FieldTypeEnum {
    TEXT("text"),
    
    LONG_TEXT("long_text"),
    
    NUMBER("number"),
    
    SINGLE_CHOICE("single_choice");

    private String value;

    FieldTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static FieldTypeEnum fromValue(String value) {
      for (FieldTypeEnum b : FieldTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<FieldTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final FieldTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public FieldTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return FieldTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_FIELD_TYPE = "field_type";
  @SerializedName(SERIALIZED_NAME_FIELD_TYPE)
  private FieldTypeEnum fieldType;

  public static final String SERIALIZED_NAME_MIN_VALUE = "min_value";
  @SerializedName(SERIALIZED_NAME_MIN_VALUE)
  private Integer minValue;

  public static final String SERIALIZED_NAME_MAX_VALUE = "max_value";
  @SerializedName(SERIALIZED_NAME_MAX_VALUE)
  private Integer maxValue;

  public static final String SERIALIZED_NAME_REQUIRED = "required";
  @SerializedName(SERIALIZED_NAME_REQUIRED)
  private Boolean required;

  /**
   * Gets or Sets editable
   */
  @JsonAdapter(EditableEnum.Adapter.class)
 public enum EditableEnum {
    OWNED("owned"),
    
    REPORTEES("reportees"),
    
    TEAM_LEADER("team_leader"),
    
    EVERYBODY("everybody");

    private String value;

    EditableEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static EditableEnum fromValue(String value) {
      for (EditableEnum b : EditableEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<EditableEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EditableEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EditableEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return EditableEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_EDITABLE = "editable";
  @SerializedName(SERIALIZED_NAME_EDITABLE)
  private EditableEnum editable;

  /**
   * Gets or Sets visible
   */
  @JsonAdapter(VisibleEnum.Adapter.class)
 public enum VisibleEnum {
    OWNED("owned"),
    
    REPORTEES("reportees"),
    
    TEAM_LEADER("team_leader"),
    
    EVERYBODY("everybody");

    private String value;

    VisibleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static VisibleEnum fromValue(String value) {
      for (VisibleEnum b : VisibleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<VisibleEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final VisibleEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public VisibleEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return VisibleEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_VISIBLE = "visible";
  @SerializedName(SERIALIZED_NAME_VISIBLE)
  private VisibleEnum visible;

  public static final String SERIALIZED_NAME_CHOICE_OPTIONS = "choice_options";
  @SerializedName(SERIALIZED_NAME_CHOICE_OPTIONS)
  private List<CustomFieldCreateFieldRequestChoiceOptionsInner> choiceOptions = null;

  public CustomFieldCreateFieldRequest() {
  }

  public CustomFieldCreateFieldRequest label(String label) {
    
    
    
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "t shirt", required = true, value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    
    
    
    this.label = label;
  }


  public CustomFieldCreateFieldRequest slugName(String slugName) {
    
    
    
    
    this.slugName = slugName;
    return this;
  }

   /**
   * Get slugName
   * @return slugName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "employees-questions", required = true, value = "")

  public String getSlugName() {
    return slugName;
  }


  public void setSlugName(String slugName) {
    
    
    
    this.slugName = slugName;
  }


  public CustomFieldCreateFieldRequest fieldType(FieldTypeEnum fieldType) {
    
    
    
    
    this.fieldType = fieldType;
    return this;
  }

   /**
   * Get fieldType
   * @return fieldType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "TEXT", required = true, value = "")

  public FieldTypeEnum getFieldType() {
    return fieldType;
  }


  public void setFieldType(FieldTypeEnum fieldType) {
    
    
    
    this.fieldType = fieldType;
  }


  public CustomFieldCreateFieldRequest minValue(Integer minValue) {
    
    
    
    
    this.minValue = minValue;
    return this;
  }

   /**
   * Get minValue
   * @return minValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getMinValue() {
    return minValue;
  }


  public void setMinValue(Integer minValue) {
    
    
    
    this.minValue = minValue;
  }


  public CustomFieldCreateFieldRequest maxValue(Integer maxValue) {
    
    
    
    
    this.maxValue = maxValue;
    return this;
  }

   /**
   * Get maxValue
   * @return maxValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "100", value = "")

  public Integer getMaxValue() {
    return maxValue;
  }


  public void setMaxValue(Integer maxValue) {
    
    
    
    this.maxValue = maxValue;
  }


  public CustomFieldCreateFieldRequest required(Boolean required) {
    
    
    
    
    this.required = required;
    return this;
  }

   /**
   * Get required
   * @return required
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "true", required = true, value = "")

  public Boolean getRequired() {
    return required;
  }


  public void setRequired(Boolean required) {
    
    
    
    this.required = required;
  }


  public CustomFieldCreateFieldRequest editable(EditableEnum editable) {
    
    
    
    
    this.editable = editable;
    return this;
  }

   /**
   * Get editable
   * @return editable
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "text", required = true, value = "")

  public EditableEnum getEditable() {
    return editable;
  }


  public void setEditable(EditableEnum editable) {
    
    
    
    this.editable = editable;
  }


  public CustomFieldCreateFieldRequest visible(VisibleEnum visible) {
    
    
    
    
    this.visible = visible;
    return this;
  }

   /**
   * Get visible
   * @return visible
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "text", required = true, value = "")

  public VisibleEnum getVisible() {
    return visible;
  }


  public void setVisible(VisibleEnum visible) {
    
    
    
    this.visible = visible;
  }


  public CustomFieldCreateFieldRequest choiceOptions(List<CustomFieldCreateFieldRequestChoiceOptionsInner> choiceOptions) {
    
    
    
    
    this.choiceOptions = choiceOptions;
    return this;
  }

  public CustomFieldCreateFieldRequest addChoiceOptionsItem(CustomFieldCreateFieldRequestChoiceOptionsInner choiceOptionsItem) {
    if (this.choiceOptions == null) {
      this.choiceOptions = new ArrayList<>();
    }
    this.choiceOptions.add(choiceOptionsItem);
    return this;
  }

   /**
   * Get choiceOptions
   * @return choiceOptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<CustomFieldCreateFieldRequestChoiceOptionsInner> getChoiceOptions() {
    return choiceOptions;
  }


  public void setChoiceOptions(List<CustomFieldCreateFieldRequestChoiceOptionsInner> choiceOptions) {
    
    
    
    this.choiceOptions = choiceOptions;
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
   * @return the CustomFieldCreateFieldRequest instance itself
   */
  public CustomFieldCreateFieldRequest putAdditionalProperty(String key, Object value) {
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
    CustomFieldCreateFieldRequest customFieldCreateFieldRequest = (CustomFieldCreateFieldRequest) o;
    return Objects.equals(this.label, customFieldCreateFieldRequest.label) &&
        Objects.equals(this.slugName, customFieldCreateFieldRequest.slugName) &&
        Objects.equals(this.fieldType, customFieldCreateFieldRequest.fieldType) &&
        Objects.equals(this.minValue, customFieldCreateFieldRequest.minValue) &&
        Objects.equals(this.maxValue, customFieldCreateFieldRequest.maxValue) &&
        Objects.equals(this.required, customFieldCreateFieldRequest.required) &&
        Objects.equals(this.editable, customFieldCreateFieldRequest.editable) &&
        Objects.equals(this.visible, customFieldCreateFieldRequest.visible) &&
        Objects.equals(this.choiceOptions, customFieldCreateFieldRequest.choiceOptions)&&
        Objects.equals(this.additionalProperties, customFieldCreateFieldRequest.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, slugName, fieldType, minValue, maxValue, required, editable, visible, choiceOptions, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomFieldCreateFieldRequest {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    slugName: ").append(toIndentedString(slugName)).append("\n");
    sb.append("    fieldType: ").append(toIndentedString(fieldType)).append("\n");
    sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
    sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
    sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
    sb.append("    visible: ").append(toIndentedString(visible)).append("\n");
    sb.append("    choiceOptions: ").append(toIndentedString(choiceOptions)).append("\n");
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
    openapiFields.add("label");
    openapiFields.add("slug_name");
    openapiFields.add("field_type");
    openapiFields.add("min_value");
    openapiFields.add("max_value");
    openapiFields.add("required");
    openapiFields.add("editable");
    openapiFields.add("visible");
    openapiFields.add("choice_options");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("label");
    openapiRequiredFields.add("slug_name");
    openapiRequiredFields.add("field_type");
    openapiRequiredFields.add("required");
    openapiRequiredFields.add("editable");
    openapiRequiredFields.add("visible");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to CustomFieldCreateFieldRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!CustomFieldCreateFieldRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in CustomFieldCreateFieldRequest is not found in the empty JSON string", CustomFieldCreateFieldRequest.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : CustomFieldCreateFieldRequest.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (!jsonObj.get("label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("label").toString()));
      }
      if (!jsonObj.get("slug_name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `slug_name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("slug_name").toString()));
      }
      if (!jsonObj.get("field_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `field_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("field_type").toString()));
      }
      if (!jsonObj.get("editable").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `editable` to be a primitive type in the JSON string but got `%s`", jsonObj.get("editable").toString()));
      }
      if (!jsonObj.get("visible").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `visible` to be a primitive type in the JSON string but got `%s`", jsonObj.get("visible").toString()));
      }
      if (jsonObj.get("choice_options") != null && !jsonObj.get("choice_options").isJsonNull()) {
        JsonArray jsonArraychoiceOptions = jsonObj.getAsJsonArray("choice_options");
        if (jsonArraychoiceOptions != null) {
          // ensure the json data is an array
          if (!jsonObj.get("choice_options").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `choice_options` to be an array in the JSON string but got `%s`", jsonObj.get("choice_options").toString()));
          }

          // validate the optional field `choice_options` (array)
          for (int i = 0; i < jsonArraychoiceOptions.size(); i++) {
            CustomFieldCreateFieldRequestChoiceOptionsInner.validateJsonObject(jsonArraychoiceOptions.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!CustomFieldCreateFieldRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'CustomFieldCreateFieldRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<CustomFieldCreateFieldRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(CustomFieldCreateFieldRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<CustomFieldCreateFieldRequest>() {
           @Override
           public void write(JsonWriter out, CustomFieldCreateFieldRequest value) throws IOException {
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
           public CustomFieldCreateFieldRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             CustomFieldCreateFieldRequest instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of CustomFieldCreateFieldRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of CustomFieldCreateFieldRequest
  * @throws IOException if the JSON string is invalid with respect to CustomFieldCreateFieldRequest
  */
  public static CustomFieldCreateFieldRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, CustomFieldCreateFieldRequest.class);
  }

 /**
  * Convert an instance of CustomFieldCreateFieldRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

