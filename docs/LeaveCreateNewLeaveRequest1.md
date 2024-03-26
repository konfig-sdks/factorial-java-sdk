

# LeaveCreateNewLeaveRequest1


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** |  |  [optional] |
|**startOn** | **String** |  |  |
|**finishOn** | **String** |  |  |
|**employeeId** | **Integer** |  |  |
|**leaveTypeId** | **Integer** |  |  [optional] |
|**halfDay** | [**HalfDayEnum**](#HalfDayEnum) |  |  [optional] |
|**startTime** | **String** |  |  [optional] |
|**hoursAmountInCents** | **Integer** |  |  [optional] |
|**medicalLeaveType** | **Integer** |  |  [optional] |
|**effectiveOn** | **String** |  |  [optional] |
|**medicalDischargeReason** | **String** |  |  [optional] |
|**colegiateNumber** | **Integer** |  |  [optional] |
|**hasPreviousRelapse** | **Boolean** |  |  [optional] |
|**relapseLeaveId** | **Integer** |  |  [optional] |
|**relapseOn** | **String** |  |  [optional] |
|**accidentOn** | **String** |  |  [optional] |
|**paternityBirthOn** | **String** |  |  [optional] |



## Enum: HalfDayEnum

| Name | Value |
|---- | -----|
| BEGGINING_OF_DAY | &quot;beggining_of_day&quot; |
| END_OF_DAY | &quot;end_of_day&quot; |



