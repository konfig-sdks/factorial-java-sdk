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
import org.openapitools.jackson.nullable.JsonNullable;

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
 * Attendance
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class Attendance {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private Integer id;

  public static final String SERIALIZED_NAME_EMPLOYEE_ID = "employee_id";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_ID)
  private Integer employeeId;

  public static final String SERIALIZED_NAME_CLOCK_IN = "clock_in";
  @SerializedName(SERIALIZED_NAME_CLOCK_IN)
  private String clockIn;

  public static final String SERIALIZED_NAME_CLOCK_OUT = "clock_out";
  @SerializedName(SERIALIZED_NAME_CLOCK_OUT)
  private String clockOut;

  public static final String SERIALIZED_NAME_OBSERVATIONS = "observations";
  @SerializedName(SERIALIZED_NAME_OBSERVATIONS)
  private String observations;

  /**
   * Gets or Sets locationType
   */
  @JsonAdapter(LocationTypeEnum.Adapter.class)
 public enum LocationTypeEnum {
    OFFICE("office"),
    
    BUSINESS_TRIP("business_trip"),
    
    WORK_FROM_HOME("work_from_home");

    private String value;

    LocationTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static LocationTypeEnum fromValue(String value) {
      for (LocationTypeEnum b : LocationTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<LocationTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final LocationTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public LocationTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return LocationTypeEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_LOCATION_TYPE = "location_type";
  @SerializedName(SERIALIZED_NAME_LOCATION_TYPE)
  private LocationTypeEnum locationType;

  /**
   * Gets or Sets halfDay
   */
  @JsonAdapter(HalfDayEnum.Adapter.class)
 public enum HalfDayEnum {
    BEGINNING_OF_DAY("beginning_of_day"),
    
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

  public static final String SERIALIZED_NAME_IN_LOCATION_LATITUDE = "in_location_latitude";
  @SerializedName(SERIALIZED_NAME_IN_LOCATION_LATITUDE)
  private Float inLocationLatitude;

  public static final String SERIALIZED_NAME_IN_LOCATION_LONGITUDE = "in_location_longitude";
  @SerializedName(SERIALIZED_NAME_IN_LOCATION_LONGITUDE)
  private Float inLocationLongitude;

  public static final String SERIALIZED_NAME_IN_LOCATION_ACCURACY = "in_location_accuracy";
  @SerializedName(SERIALIZED_NAME_IN_LOCATION_ACCURACY)
  private Float inLocationAccuracy;

  public static final String SERIALIZED_NAME_OUT_LOCATION_LATITUDE = "out_location_latitude";
  @SerializedName(SERIALIZED_NAME_OUT_LOCATION_LATITUDE)
  private Float outLocationLatitude;

  public static final String SERIALIZED_NAME_OUT_LOCATION_LONGITUDE = "out_location_longitude";
  @SerializedName(SERIALIZED_NAME_OUT_LOCATION_LONGITUDE)
  private Float outLocationLongitude;

  public static final String SERIALIZED_NAME_OUT_LOCATION_ACCURACY = "out_location_accuracy";
  @SerializedName(SERIALIZED_NAME_OUT_LOCATION_ACCURACY)
  private Float outLocationAccuracy;

  public static final String SERIALIZED_NAME_WORKABLE = "workable";
  @SerializedName(SERIALIZED_NAME_WORKABLE)
  private Boolean workable;

  public static final String SERIALIZED_NAME_AUTOMATIC_CLOCK_IN = "automatic_clock_in";
  @SerializedName(SERIALIZED_NAME_AUTOMATIC_CLOCK_IN)
  private Boolean automaticClockIn;

  public static final String SERIALIZED_NAME_AUTOMATIC_CLOCK_OUT = "automatic_clock_out";
  @SerializedName(SERIALIZED_NAME_AUTOMATIC_CLOCK_OUT)
  private Boolean automaticClockOut;

  public static final String SERIALIZED_NAME_TIME_SETTINGS_BREAK_CONFIGURATION_ID = "time_settings_break_configuration_id";
  @SerializedName(SERIALIZED_NAME_TIME_SETTINGS_BREAK_CONFIGURATION_ID)
  private Integer timeSettingsBreakConfigurationId;

  public Attendance() {
  }

  public Attendance id(Integer id) {
    
    
    
    
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


  public Attendance employeeId(Integer employeeId) {
    
    
    
    
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "5", value = "")

  public Integer getEmployeeId() {
    return employeeId;
  }


  public void setEmployeeId(Integer employeeId) {
    
    
    
    this.employeeId = employeeId;
  }


  public Attendance clockIn(String clockIn) {
    
    
    
    
    this.clockIn = clockIn;
    return this;
  }

   /**
   * Get clockIn
   * @return clockIn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-23T18:00:33.000Z", value = "")

  public String getClockIn() {
    return clockIn;
  }


  public void setClockIn(String clockIn) {
    
    
    
    this.clockIn = clockIn;
  }


  public Attendance clockOut(String clockOut) {
    
    
    
    
    this.clockOut = clockOut;
    return this;
  }

   /**
   * Get clockOut
   * @return clockOut
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-06-23T20:00:33.000Z", value = "")

  public String getClockOut() {
    return clockOut;
  }


  public void setClockOut(String clockOut) {
    
    
    
    this.clockOut = clockOut;
  }


  public Attendance observations(String observations) {
    
    
    
    
    this.observations = observations;
    return this;
  }

   /**
   * Get observations
   * @return observations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "First shift", value = "")

  public String getObservations() {
    return observations;
  }


  public void setObservations(String observations) {
    
    
    
    this.observations = observations;
  }


  public Attendance locationType(LocationTypeEnum locationType) {
    
    
    
    
    this.locationType = locationType;
    return this;
  }

   /**
   * Get locationType
   * @return locationType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "OFFICE", value = "")

  public LocationTypeEnum getLocationType() {
    return locationType;
  }


  public void setLocationType(LocationTypeEnum locationType) {
    
    
    
    this.locationType = locationType;
  }


  public Attendance halfDay(HalfDayEnum halfDay) {
    
    
    
    
    this.halfDay = halfDay;
    return this;
  }

   /**
   * Get halfDay
   * @return halfDay
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "BEGINNING_OF_DAY", value = "")

  public HalfDayEnum getHalfDay() {
    return halfDay;
  }


  public void setHalfDay(HalfDayEnum halfDay) {
    
    
    
    this.halfDay = halfDay;
  }


  public Attendance inLocationLatitude(Float inLocationLatitude) {
    
    
    
    
    this.inLocationLatitude = inLocationLatitude;
    return this;
  }

   /**
   * Get inLocationLatitude
   * @return inLocationLatitude
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "-34.8601369070693", value = "")

  public Float getInLocationLatitude() {
    return inLocationLatitude;
  }


  public void setInLocationLatitude(Float inLocationLatitude) {
    
    
    
    this.inLocationLatitude = inLocationLatitude;
  }


  public Attendance inLocationLongitude(Float inLocationLongitude) {
    
    
    
    
    this.inLocationLongitude = inLocationLongitude;
    return this;
  }

   /**
   * Get inLocationLongitude
   * @return inLocationLongitude
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "56.0008344819525", value = "")

  public Float getInLocationLongitude() {
    return inLocationLongitude;
  }


  public void setInLocationLongitude(Float inLocationLongitude) {
    
    
    
    this.inLocationLongitude = inLocationLongitude;
  }


  public Attendance inLocationAccuracy(Float inLocationAccuracy) {
    
    
    
    
    this.inLocationAccuracy = inLocationAccuracy;
    return this;
  }

   /**
   * Get inLocationAccuracy
   * @return inLocationAccuracy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1.4", value = "")

  public Float getInLocationAccuracy() {
    return inLocationAccuracy;
  }


  public void setInLocationAccuracy(Float inLocationAccuracy) {
    
    
    
    this.inLocationAccuracy = inLocationAccuracy;
  }


  public Attendance outLocationLatitude(Float outLocationLatitude) {
    
    
    
    
    this.outLocationLatitude = outLocationLatitude;
    return this;
  }

   /**
   * Get outLocationLatitude
   * @return outLocationLatitude
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "-34.8601369070693", value = "")

  public Float getOutLocationLatitude() {
    return outLocationLatitude;
  }


  public void setOutLocationLatitude(Float outLocationLatitude) {
    
    
    
    this.outLocationLatitude = outLocationLatitude;
  }


  public Attendance outLocationLongitude(Float outLocationLongitude) {
    
    
    
    
    this.outLocationLongitude = outLocationLongitude;
    return this;
  }

   /**
   * Get outLocationLongitude
   * @return outLocationLongitude
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "56.0008344819525", value = "")

  public Float getOutLocationLongitude() {
    return outLocationLongitude;
  }


  public void setOutLocationLongitude(Float outLocationLongitude) {
    
    
    
    this.outLocationLongitude = outLocationLongitude;
  }


  public Attendance outLocationAccuracy(Float outLocationAccuracy) {
    
    
    
    
    this.outLocationAccuracy = outLocationAccuracy;
    return this;
  }

   /**
   * Get outLocationAccuracy
   * @return outLocationAccuracy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1.4", value = "")

  public Float getOutLocationAccuracy() {
    return outLocationAccuracy;
  }


  public void setOutLocationAccuracy(Float outLocationAccuracy) {
    
    
    
    this.outLocationAccuracy = outLocationAccuracy;
  }


  public Attendance workable(Boolean workable) {
    
    
    
    
    this.workable = workable;
    return this;
  }

   /**
   * Get workable
   * @return workable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getWorkable() {
    return workable;
  }


  public void setWorkable(Boolean workable) {
    
    
    
    this.workable = workable;
  }


  public Attendance automaticClockIn(Boolean automaticClockIn) {
    
    
    
    
    this.automaticClockIn = automaticClockIn;
    return this;
  }

   /**
   * Get automaticClockIn
   * @return automaticClockIn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getAutomaticClockIn() {
    return automaticClockIn;
  }


  public void setAutomaticClockIn(Boolean automaticClockIn) {
    
    
    
    this.automaticClockIn = automaticClockIn;
  }


  public Attendance automaticClockOut(Boolean automaticClockOut) {
    
    
    
    
    this.automaticClockOut = automaticClockOut;
    return this;
  }

   /**
   * Get automaticClockOut
   * @return automaticClockOut
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getAutomaticClockOut() {
    return automaticClockOut;
  }


  public void setAutomaticClockOut(Boolean automaticClockOut) {
    
    
    
    this.automaticClockOut = automaticClockOut;
  }


  public Attendance timeSettingsBreakConfigurationId(Integer timeSettingsBreakConfigurationId) {
    
    
    
    
    this.timeSettingsBreakConfigurationId = timeSettingsBreakConfigurationId;
    return this;
  }

   /**
   * Get timeSettingsBreakConfigurationId
   * @return timeSettingsBreakConfigurationId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getTimeSettingsBreakConfigurationId() {
    return timeSettingsBreakConfigurationId;
  }


  public void setTimeSettingsBreakConfigurationId(Integer timeSettingsBreakConfigurationId) {
    
    
    
    this.timeSettingsBreakConfigurationId = timeSettingsBreakConfigurationId;
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
   * @return the Attendance instance itself
   */
  public Attendance putAdditionalProperty(String key, Object value) {
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
    Attendance attendance = (Attendance) o;
    return Objects.equals(this.id, attendance.id) &&
        Objects.equals(this.employeeId, attendance.employeeId) &&
        Objects.equals(this.clockIn, attendance.clockIn) &&
        Objects.equals(this.clockOut, attendance.clockOut) &&
        Objects.equals(this.observations, attendance.observations) &&
        Objects.equals(this.locationType, attendance.locationType) &&
        Objects.equals(this.halfDay, attendance.halfDay) &&
        Objects.equals(this.inLocationLatitude, attendance.inLocationLatitude) &&
        Objects.equals(this.inLocationLongitude, attendance.inLocationLongitude) &&
        Objects.equals(this.inLocationAccuracy, attendance.inLocationAccuracy) &&
        Objects.equals(this.outLocationLatitude, attendance.outLocationLatitude) &&
        Objects.equals(this.outLocationLongitude, attendance.outLocationLongitude) &&
        Objects.equals(this.outLocationAccuracy, attendance.outLocationAccuracy) &&
        Objects.equals(this.workable, attendance.workable) &&
        Objects.equals(this.automaticClockIn, attendance.automaticClockIn) &&
        Objects.equals(this.automaticClockOut, attendance.automaticClockOut) &&
        Objects.equals(this.timeSettingsBreakConfigurationId, attendance.timeSettingsBreakConfigurationId)&&
        Objects.equals(this.additionalProperties, attendance.additionalProperties);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, employeeId, clockIn, clockOut, observations, locationType, halfDay, inLocationLatitude, inLocationLongitude, inLocationAccuracy, outLocationLatitude, outLocationLongitude, outLocationAccuracy, workable, automaticClockIn, automaticClockOut, timeSettingsBreakConfigurationId, additionalProperties);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attendance {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    clockIn: ").append(toIndentedString(clockIn)).append("\n");
    sb.append("    clockOut: ").append(toIndentedString(clockOut)).append("\n");
    sb.append("    observations: ").append(toIndentedString(observations)).append("\n");
    sb.append("    locationType: ").append(toIndentedString(locationType)).append("\n");
    sb.append("    halfDay: ").append(toIndentedString(halfDay)).append("\n");
    sb.append("    inLocationLatitude: ").append(toIndentedString(inLocationLatitude)).append("\n");
    sb.append("    inLocationLongitude: ").append(toIndentedString(inLocationLongitude)).append("\n");
    sb.append("    inLocationAccuracy: ").append(toIndentedString(inLocationAccuracy)).append("\n");
    sb.append("    outLocationLatitude: ").append(toIndentedString(outLocationLatitude)).append("\n");
    sb.append("    outLocationLongitude: ").append(toIndentedString(outLocationLongitude)).append("\n");
    sb.append("    outLocationAccuracy: ").append(toIndentedString(outLocationAccuracy)).append("\n");
    sb.append("    workable: ").append(toIndentedString(workable)).append("\n");
    sb.append("    automaticClockIn: ").append(toIndentedString(automaticClockIn)).append("\n");
    sb.append("    automaticClockOut: ").append(toIndentedString(automaticClockOut)).append("\n");
    sb.append("    timeSettingsBreakConfigurationId: ").append(toIndentedString(timeSettingsBreakConfigurationId)).append("\n");
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
    openapiFields.add("clock_in");
    openapiFields.add("clock_out");
    openapiFields.add("observations");
    openapiFields.add("location_type");
    openapiFields.add("half_day");
    openapiFields.add("in_location_latitude");
    openapiFields.add("in_location_longitude");
    openapiFields.add("in_location_accuracy");
    openapiFields.add("out_location_latitude");
    openapiFields.add("out_location_longitude");
    openapiFields.add("out_location_accuracy");
    openapiFields.add("workable");
    openapiFields.add("automatic_clock_in");
    openapiFields.add("automatic_clock_out");
    openapiFields.add("time_settings_break_configuration_id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to Attendance
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!Attendance.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in Attendance is not found in the empty JSON string", Attendance.openapiRequiredFields.toString()));
        }
      }
      if ((jsonObj.get("clock_in") != null && !jsonObj.get("clock_in").isJsonNull()) && !jsonObj.get("clock_in").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `clock_in` to be a primitive type in the JSON string but got `%s`", jsonObj.get("clock_in").toString()));
      }
      if ((jsonObj.get("clock_out") != null && !jsonObj.get("clock_out").isJsonNull()) && !jsonObj.get("clock_out").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `clock_out` to be a primitive type in the JSON string but got `%s`", jsonObj.get("clock_out").toString()));
      }
      if ((jsonObj.get("observations") != null && !jsonObj.get("observations").isJsonNull()) && !jsonObj.get("observations").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `observations` to be a primitive type in the JSON string but got `%s`", jsonObj.get("observations").toString()));
      }
      if ((jsonObj.get("location_type") != null && !jsonObj.get("location_type").isJsonNull()) && !jsonObj.get("location_type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `location_type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("location_type").toString()));
      }
      if ((jsonObj.get("half_day") != null && !jsonObj.get("half_day").isJsonNull()) && !jsonObj.get("half_day").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `half_day` to be a primitive type in the JSON string but got `%s`", jsonObj.get("half_day").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!Attendance.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'Attendance' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<Attendance> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(Attendance.class));

       return (TypeAdapter<T>) new TypeAdapter<Attendance>() {
           @Override
           public void write(JsonWriter out, Attendance value) throws IOException {
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
           public Attendance read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             Attendance instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of Attendance given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Attendance
  * @throws IOException if the JSON string is invalid with respect to Attendance
  */
  public static Attendance fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, Attendance.class);
  }

 /**
  * Convert an instance of Attendance to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

