

# Attendance


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** |  |  [optional] |
|**employeeId** | **Integer** |  |  [optional] |
|**clockIn** | **String** |  |  [optional] |
|**clockOut** | **String** |  |  [optional] |
|**observations** | **String** |  |  [optional] |
|**locationType** | [**LocationTypeEnum**](#LocationTypeEnum) |  |  [optional] |
|**halfDay** | [**HalfDayEnum**](#HalfDayEnum) |  |  [optional] |
|**inLocationLatitude** | **Float** |  |  [optional] |
|**inLocationLongitude** | **Float** |  |  [optional] |
|**inLocationAccuracy** | **Float** |  |  [optional] |
|**outLocationLatitude** | **Float** |  |  [optional] |
|**outLocationLongitude** | **Float** |  |  [optional] |
|**outLocationAccuracy** | **Float** |  |  [optional] |
|**workable** | **Boolean** |  |  [optional] |
|**automaticClockIn** | **Boolean** |  |  [optional] |
|**automaticClockOut** | **Boolean** |  |  [optional] |
|**timeSettingsBreakConfigurationId** | **Integer** |  |  [optional] |



## Enum: LocationTypeEnum

| Name | Value |
|---- | -----|
| OFFICE | &quot;office&quot; |
| BUSINESS_TRIP | &quot;business_trip&quot; |
| WORK_FROM_HOME | &quot;work_from_home&quot; |



## Enum: HalfDayEnum

| Name | Value |
|---- | -----|
| BEGINNING_OF_DAY | &quot;beginning_of_day&quot; |
| END_OF_DAY | &quot;end_of_day&quot; |



