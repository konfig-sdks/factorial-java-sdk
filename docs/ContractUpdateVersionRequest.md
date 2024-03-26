

# ContractUpdateVersionRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**effectiveOn** | **String** |  |  |
|**employeeId** | **Integer** |  |  [optional] |
|**startsOn** | **String** |  |  [optional] |
|**endsOn** | **String** |  |  [optional] |
|**workingHoursFrequency** | [**WorkingHoursFrequencyEnum**](#WorkingHoursFrequencyEnum) |  |  [optional] |
|**workingWeekDays** | **String** |  |  [optional] |
|**workingHours** | **Integer** |  |  [optional] |
|**salaryFrequency** | [**SalaryFrequencyEnum**](#SalaryFrequencyEnum) |  |  [optional] |
|**salaryAmount** | **Integer** |  |  [optional] |
|**jobTitle** | **String** |  |  [optional] |
|**esCotizationGroup** | **Integer** | the cotization group id for Spain contracts |  [optional] |
|**esProfessionalCategoryId** | **Integer** | the professional category id for Spain contracts |  [optional] |
|**esEducationLevelId** | **Integer** | the education level id for Spain contracts |  [optional] |
|**esContractTypeId** | **Integer** | the contract type id for Spain contracts |  [optional] |



## Enum: WorkingHoursFrequencyEnum

| Name | Value |
|---- | -----|
| WEEK | &quot;week&quot; |
| DAY | &quot;day&quot; |
| MONTH | &quot;month&quot; |
| YEAR | &quot;year&quot; |



## Enum: SalaryFrequencyEnum

| Name | Value |
|---- | -----|
| YEARLY | &quot;yearly&quot; |
| MONTHLY | &quot;monthly&quot; |
| WEEKLY | &quot;weekly&quot; |
| HOURLY | &quot;hourly&quot; |
| DAILY | &quot;daily&quot; |



