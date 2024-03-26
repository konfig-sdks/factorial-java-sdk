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
 * LeaveCreateNewLeaveRequest1
 */@javax.annotation.Generated(value = "Generated by https://konfigthis.com")
public class LeaveCreateNewLeaveRequest1 {
  public static final String SERIALIZED_NAME_DESCRIPTION = "description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_START_ON = "start_on";
  @SerializedName(SERIALIZED_NAME_START_ON)
  private String startOn;

  public static final String SERIALIZED_NAME_FINISH_ON = "finish_on";
  @SerializedName(SERIALIZED_NAME_FINISH_ON)
  private String finishOn;

  public static final String SERIALIZED_NAME_EMPLOYEE_ID = "employee_id";
  @SerializedName(SERIALIZED_NAME_EMPLOYEE_ID)
  private Integer employeeId;

  public static final String SERIALIZED_NAME_LEAVE_TYPE_ID = "leave_type_id";
  @SerializedName(SERIALIZED_NAME_LEAVE_TYPE_ID)
  private Integer leaveTypeId;

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

  public static final String SERIALIZED_NAME_START_TIME = "start_time";
  @SerializedName(SERIALIZED_NAME_START_TIME)
  private String startTime;

  public static final String SERIALIZED_NAME_HOURS_AMOUNT_IN_CENTS = "hours_amount_in_cents";
  @SerializedName(SERIALIZED_NAME_HOURS_AMOUNT_IN_CENTS)
  private Integer hoursAmountInCents;

  public static final String SERIALIZED_NAME_MEDICAL_LEAVE_TYPE = "medical_leave_type";
  @SerializedName(SERIALIZED_NAME_MEDICAL_LEAVE_TYPE)
  private Integer medicalLeaveType;

  public static final String SERIALIZED_NAME_EFFECTIVE_ON = "effective_on";
  @SerializedName(SERIALIZED_NAME_EFFECTIVE_ON)
  private String effectiveOn;

  public static final String SERIALIZED_NAME_MEDICAL_DISCHARGE_REASON = "medical_discharge_reason";
  @SerializedName(SERIALIZED_NAME_MEDICAL_DISCHARGE_REASON)
  private String medicalDischargeReason;

  public static final String SERIALIZED_NAME_COLEGIATE_NUMBER = "colegiate_number";
  @SerializedName(SERIALIZED_NAME_COLEGIATE_NUMBER)
  private Integer colegiateNumber;

  public static final String SERIALIZED_NAME_HAS_PREVIOUS_RELAPSE = "has_previous_relapse";
  @SerializedName(SERIALIZED_NAME_HAS_PREVIOUS_RELAPSE)
  private Boolean hasPreviousRelapse;

  public static final String SERIALIZED_NAME_RELAPSE_LEAVE_ID = "relapse_leave_id";
  @SerializedName(SERIALIZED_NAME_RELAPSE_LEAVE_ID)
  private Integer relapseLeaveId;

  public static final String SERIALIZED_NAME_RELAPSE_ON = "relapse_on";
  @SerializedName(SERIALIZED_NAME_RELAPSE_ON)
  private String relapseOn;

  public static final String SERIALIZED_NAME_ACCIDENT_ON = "accident_on";
  @SerializedName(SERIALIZED_NAME_ACCIDENT_ON)
  private String accidentOn;

  public static final String SERIALIZED_NAME_PATERNITY_BIRTH_ON = "paternity_birth_on";
  @SerializedName(SERIALIZED_NAME_PATERNITY_BIRTH_ON)
  private String paternityBirthOn;

  public LeaveCreateNewLeaveRequest1() {
  }

  public LeaveCreateNewLeaveRequest1 description(String description) {
    
    
    
    
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


  public LeaveCreateNewLeaveRequest1 startOn(String startOn) {
    
    
    
    
    this.startOn = startOn;
    return this;
  }

   /**
   * Get startOn
   * @return startOn
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2022-03-03", required = true, value = "")

  public String getStartOn() {
    return startOn;
  }


  public void setStartOn(String startOn) {
    
    
    
    this.startOn = startOn;
  }


  public LeaveCreateNewLeaveRequest1 finishOn(String finishOn) {
    
    
    
    
    this.finishOn = finishOn;
    return this;
  }

   /**
   * Get finishOn
   * @return finishOn
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "2022-03-03", required = true, value = "")

  public String getFinishOn() {
    return finishOn;
  }


  public void setFinishOn(String finishOn) {
    
    
    
    this.finishOn = finishOn;
  }


  public LeaveCreateNewLeaveRequest1 employeeId(Integer employeeId) {
    
    
    
    
    this.employeeId = employeeId;
    return this;
  }

   /**
   * Get employeeId
   * @return employeeId
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(example = "5", required = true, value = "")

  public Integer getEmployeeId() {
    return employeeId;
  }


  public void setEmployeeId(Integer employeeId) {
    
    
    
    this.employeeId = employeeId;
  }


  public LeaveCreateNewLeaveRequest1 leaveTypeId(Integer leaveTypeId) {
    
    
    
    
    this.leaveTypeId = leaveTypeId;
    return this;
  }

   /**
   * Get leaveTypeId
   * @return leaveTypeId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "1", value = "")

  public Integer getLeaveTypeId() {
    return leaveTypeId;
  }


  public void setLeaveTypeId(Integer leaveTypeId) {
    
    
    
    this.leaveTypeId = leaveTypeId;
  }


  public LeaveCreateNewLeaveRequest1 halfDay(HalfDayEnum halfDay) {
    
    
    
    
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


  public LeaveCreateNewLeaveRequest1 startTime(String startTime) {
    
    
    
    
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "840", value = "")

  public String getStartTime() {
    return startTime;
  }


  public void setStartTime(String startTime) {
    
    
    
    this.startTime = startTime;
  }


  public LeaveCreateNewLeaveRequest1 hoursAmountInCents(Integer hoursAmountInCents) {
    
    
    
    
    this.hoursAmountInCents = hoursAmountInCents;
    return this;
  }

   /**
   * Get hoursAmountInCents
   * @return hoursAmountInCents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "400", value = "")

  public Integer getHoursAmountInCents() {
    return hoursAmountInCents;
  }


  public void setHoursAmountInCents(Integer hoursAmountInCents) {
    
    
    
    this.hoursAmountInCents = hoursAmountInCents;
  }


  public LeaveCreateNewLeaveRequest1 medicalLeaveType(Integer medicalLeaveType) {
    
    
    
    
    this.medicalLeaveType = medicalLeaveType;
    return this;
  }

   /**
   * Get medicalLeaveType
   * @return medicalLeaveType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "400", value = "")

  public Integer getMedicalLeaveType() {
    return medicalLeaveType;
  }


  public void setMedicalLeaveType(Integer medicalLeaveType) {
    
    
    
    this.medicalLeaveType = medicalLeaveType;
  }


  public LeaveCreateNewLeaveRequest1 effectiveOn(String effectiveOn) {
    
    
    
    
    this.effectiveOn = effectiveOn;
    return this;
  }

   /**
   * Get effectiveOn
   * @return effectiveOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-03-03", value = "")

  public String getEffectiveOn() {
    return effectiveOn;
  }


  public void setEffectiveOn(String effectiveOn) {
    
    
    
    this.effectiveOn = effectiveOn;
  }


  public LeaveCreateNewLeaveRequest1 medicalDischargeReason(String medicalDischargeReason) {
    
    
    
    
    this.medicalDischargeReason = medicalDischargeReason;
    return this;
  }

   /**
   * Get medicalDischargeReason
   * @return medicalDischargeReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "medical appointment", value = "")

  public String getMedicalDischargeReason() {
    return medicalDischargeReason;
  }


  public void setMedicalDischargeReason(String medicalDischargeReason) {
    
    
    
    this.medicalDischargeReason = medicalDischargeReason;
  }


  public LeaveCreateNewLeaveRequest1 colegiateNumber(Integer colegiateNumber) {
    
    
    
    
    this.colegiateNumber = colegiateNumber;
    return this;
  }

   /**
   * Get colegiateNumber
   * @return colegiateNumber
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getColegiateNumber() {
    return colegiateNumber;
  }


  public void setColegiateNumber(Integer colegiateNumber) {
    
    
    
    this.colegiateNumber = colegiateNumber;
  }


  public LeaveCreateNewLeaveRequest1 hasPreviousRelapse(Boolean hasPreviousRelapse) {
    
    
    
    
    this.hasPreviousRelapse = hasPreviousRelapse;
    return this;
  }

   /**
   * Get hasPreviousRelapse
   * @return hasPreviousRelapse
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "false", value = "")

  public Boolean getHasPreviousRelapse() {
    return hasPreviousRelapse;
  }


  public void setHasPreviousRelapse(Boolean hasPreviousRelapse) {
    
    
    
    this.hasPreviousRelapse = hasPreviousRelapse;
  }


  public LeaveCreateNewLeaveRequest1 relapseLeaveId(Integer relapseLeaveId) {
    
    
    
    
    this.relapseLeaveId = relapseLeaveId;
    return this;
  }

   /**
   * Get relapseLeaveId
   * @return relapseLeaveId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "3", value = "")

  public Integer getRelapseLeaveId() {
    return relapseLeaveId;
  }


  public void setRelapseLeaveId(Integer relapseLeaveId) {
    
    
    
    this.relapseLeaveId = relapseLeaveId;
  }


  public LeaveCreateNewLeaveRequest1 relapseOn(String relapseOn) {
    
    
    
    
    this.relapseOn = relapseOn;
    return this;
  }

   /**
   * Get relapseOn
   * @return relapseOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-03-03", value = "")

  public String getRelapseOn() {
    return relapseOn;
  }


  public void setRelapseOn(String relapseOn) {
    
    
    
    this.relapseOn = relapseOn;
  }


  public LeaveCreateNewLeaveRequest1 accidentOn(String accidentOn) {
    
    
    
    
    this.accidentOn = accidentOn;
    return this;
  }

   /**
   * Get accidentOn
   * @return accidentOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-03-01", value = "")

  public String getAccidentOn() {
    return accidentOn;
  }


  public void setAccidentOn(String accidentOn) {
    
    
    
    this.accidentOn = accidentOn;
  }


  public LeaveCreateNewLeaveRequest1 paternityBirthOn(String paternityBirthOn) {
    
    
    
    
    this.paternityBirthOn = paternityBirthOn;
    return this;
  }

   /**
   * Get paternityBirthOn
   * @return paternityBirthOn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2022-03-02", value = "")

  public String getPaternityBirthOn() {
    return paternityBirthOn;
  }


  public void setPaternityBirthOn(String paternityBirthOn) {
    
    
    
    this.paternityBirthOn = paternityBirthOn;
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
   * @return the LeaveCreateNewLeaveRequest1 instance itself
   */
  public LeaveCreateNewLeaveRequest1 putAdditionalProperty(String key, Object value) {
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
    LeaveCreateNewLeaveRequest1 leaveCreateNewLeaveRequest1 = (LeaveCreateNewLeaveRequest1) o;
    return Objects.equals(this.description, leaveCreateNewLeaveRequest1.description) &&
        Objects.equals(this.startOn, leaveCreateNewLeaveRequest1.startOn) &&
        Objects.equals(this.finishOn, leaveCreateNewLeaveRequest1.finishOn) &&
        Objects.equals(this.employeeId, leaveCreateNewLeaveRequest1.employeeId) &&
        Objects.equals(this.leaveTypeId, leaveCreateNewLeaveRequest1.leaveTypeId) &&
        Objects.equals(this.halfDay, leaveCreateNewLeaveRequest1.halfDay) &&
        Objects.equals(this.startTime, leaveCreateNewLeaveRequest1.startTime) &&
        Objects.equals(this.hoursAmountInCents, leaveCreateNewLeaveRequest1.hoursAmountInCents) &&
        Objects.equals(this.medicalLeaveType, leaveCreateNewLeaveRequest1.medicalLeaveType) &&
        Objects.equals(this.effectiveOn, leaveCreateNewLeaveRequest1.effectiveOn) &&
        Objects.equals(this.medicalDischargeReason, leaveCreateNewLeaveRequest1.medicalDischargeReason) &&
        Objects.equals(this.colegiateNumber, leaveCreateNewLeaveRequest1.colegiateNumber) &&
        Objects.equals(this.hasPreviousRelapse, leaveCreateNewLeaveRequest1.hasPreviousRelapse) &&
        Objects.equals(this.relapseLeaveId, leaveCreateNewLeaveRequest1.relapseLeaveId) &&
        Objects.equals(this.relapseOn, leaveCreateNewLeaveRequest1.relapseOn) &&
        Objects.equals(this.accidentOn, leaveCreateNewLeaveRequest1.accidentOn) &&
        Objects.equals(this.paternityBirthOn, leaveCreateNewLeaveRequest1.paternityBirthOn)&&
        Objects.equals(this.additionalProperties, leaveCreateNewLeaveRequest1.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, startOn, finishOn, employeeId, leaveTypeId, halfDay, startTime, hoursAmountInCents, medicalLeaveType, effectiveOn, medicalDischargeReason, colegiateNumber, hasPreviousRelapse, relapseLeaveId, relapseOn, accidentOn, paternityBirthOn, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LeaveCreateNewLeaveRequest1 {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startOn: ").append(toIndentedString(startOn)).append("\n");
    sb.append("    finishOn: ").append(toIndentedString(finishOn)).append("\n");
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    leaveTypeId: ").append(toIndentedString(leaveTypeId)).append("\n");
    sb.append("    halfDay: ").append(toIndentedString(halfDay)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    hoursAmountInCents: ").append(toIndentedString(hoursAmountInCents)).append("\n");
    sb.append("    medicalLeaveType: ").append(toIndentedString(medicalLeaveType)).append("\n");
    sb.append("    effectiveOn: ").append(toIndentedString(effectiveOn)).append("\n");
    sb.append("    medicalDischargeReason: ").append(toIndentedString(medicalDischargeReason)).append("\n");
    sb.append("    colegiateNumber: ").append(toIndentedString(colegiateNumber)).append("\n");
    sb.append("    hasPreviousRelapse: ").append(toIndentedString(hasPreviousRelapse)).append("\n");
    sb.append("    relapseLeaveId: ").append(toIndentedString(relapseLeaveId)).append("\n");
    sb.append("    relapseOn: ").append(toIndentedString(relapseOn)).append("\n");
    sb.append("    accidentOn: ").append(toIndentedString(accidentOn)).append("\n");
    sb.append("    paternityBirthOn: ").append(toIndentedString(paternityBirthOn)).append("\n");
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
    openapiFields.add("start_on");
    openapiFields.add("finish_on");
    openapiFields.add("employee_id");
    openapiFields.add("leave_type_id");
    openapiFields.add("half_day");
    openapiFields.add("start_time");
    openapiFields.add("hours_amount_in_cents");
    openapiFields.add("medical_leave_type");
    openapiFields.add("effective_on");
    openapiFields.add("medical_discharge_reason");
    openapiFields.add("colegiate_number");
    openapiFields.add("has_previous_relapse");
    openapiFields.add("relapse_leave_id");
    openapiFields.add("relapse_on");
    openapiFields.add("accident_on");
    openapiFields.add("paternity_birth_on");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("start_on");
    openapiRequiredFields.add("finish_on");
    openapiRequiredFields.add("employee_id");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to LeaveCreateNewLeaveRequest1
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!LeaveCreateNewLeaveRequest1.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LeaveCreateNewLeaveRequest1 is not found in the empty JSON string", LeaveCreateNewLeaveRequest1.openapiRequiredFields.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : LeaveCreateNewLeaveRequest1.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if ((jsonObj.get("description") != null && !jsonObj.get("description").isJsonNull()) && !jsonObj.get("description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("description").toString()));
      }
      if (!jsonObj.get("start_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `start_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("start_on").toString()));
      }
      if (!jsonObj.get("finish_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `finish_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("finish_on").toString()));
      }
      if ((jsonObj.get("half_day") != null && !jsonObj.get("half_day").isJsonNull()) && !jsonObj.get("half_day").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `half_day` to be a primitive type in the JSON string but got `%s`", jsonObj.get("half_day").toString()));
      }
      if ((jsonObj.get("start_time") != null && !jsonObj.get("start_time").isJsonNull()) && !jsonObj.get("start_time").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `start_time` to be a primitive type in the JSON string but got `%s`", jsonObj.get("start_time").toString()));
      }
      if ((jsonObj.get("effective_on") != null && !jsonObj.get("effective_on").isJsonNull()) && !jsonObj.get("effective_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `effective_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("effective_on").toString()));
      }
      if ((jsonObj.get("medical_discharge_reason") != null && !jsonObj.get("medical_discharge_reason").isJsonNull()) && !jsonObj.get("medical_discharge_reason").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `medical_discharge_reason` to be a primitive type in the JSON string but got `%s`", jsonObj.get("medical_discharge_reason").toString()));
      }
      if ((jsonObj.get("relapse_on") != null && !jsonObj.get("relapse_on").isJsonNull()) && !jsonObj.get("relapse_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `relapse_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("relapse_on").toString()));
      }
      if ((jsonObj.get("accident_on") != null && !jsonObj.get("accident_on").isJsonNull()) && !jsonObj.get("accident_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `accident_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("accident_on").toString()));
      }
      if ((jsonObj.get("paternity_birth_on") != null && !jsonObj.get("paternity_birth_on").isJsonNull()) && !jsonObj.get("paternity_birth_on").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `paternity_birth_on` to be a primitive type in the JSON string but got `%s`", jsonObj.get("paternity_birth_on").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LeaveCreateNewLeaveRequest1.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LeaveCreateNewLeaveRequest1' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LeaveCreateNewLeaveRequest1> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LeaveCreateNewLeaveRequest1.class));

       return (TypeAdapter<T>) new TypeAdapter<LeaveCreateNewLeaveRequest1>() {
           @Override
           public void write(JsonWriter out, LeaveCreateNewLeaveRequest1 value) throws IOException {
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
           public LeaveCreateNewLeaveRequest1 read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             // store additional fields in the deserialized instance
             LeaveCreateNewLeaveRequest1 instance = thisAdapter.fromJsonTree(jsonObj);
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
  * Create an instance of LeaveCreateNewLeaveRequest1 given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of LeaveCreateNewLeaveRequest1
  * @throws IOException if the JSON string is invalid with respect to LeaveCreateNewLeaveRequest1
  */
  public static LeaveCreateNewLeaveRequest1 fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LeaveCreateNewLeaveRequest1.class);
  }

 /**
  * Convert an instance of LeaveCreateNewLeaveRequest1 to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

