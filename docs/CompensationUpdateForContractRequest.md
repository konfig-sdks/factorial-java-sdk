

# CompensationUpdateForContractRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**description** | **String** |  |  [optional] |
|**contractsTaxonomyId** | **Integer** |  |  [optional] |
|**compensationType** | [**CompensationTypeEnum**](#CompensationTypeEnum) |  |  [optional] |
|**amount** | **Integer** |  |  [optional] |
|**unit** | [**UnitEnum**](#UnitEnum) |  |  [optional] |
|**syncWithSupplements** | **Boolean** |  |  [optional] |
|**payrollPolicyId** | **Integer** |  |  [optional] |
|**recurrenceCount** | **Integer** |  |  [optional] |
|**startsOn** | **String** |  |  [optional] |
|**recurrence** | [**RecurrenceEnum**](#RecurrenceEnum) |  |  [optional] |
|**firstPaymentOn** | **String** |  |  [optional] |
|**calculation** | [**CalculationEnum**](#CalculationEnum) |  |  [optional] |



## Enum: CompensationTypeEnum

| Name | Value |
|---- | -----|
| FIXED | &quot;fixed&quot; |
| UP_TO | &quot;up_to&quot; |



## Enum: UnitEnum

| Name | Value |
|---- | -----|
| MONEY | &quot;money&quot; |
| UNITS | &quot;units&quot; |



## Enum: RecurrenceEnum

| Name | Value |
|---- | -----|
| MONTHLY | &quot;monthly&quot; |
| EVERY_2_MONTHS | &quot;every_2_months&quot; |
| EVERY_3_MONTHS | &quot;every_3_months&quot; |
| EVERY_4_MONTHS | &quot;every_4_months&quot; |
| EVERY_5_MONTHS | &quot;every_5_months&quot; |
| EVERY_6_MONTHS | &quot;every_6_months&quot; |
| EVERY_7_MONTHS | &quot;every_7_months&quot; |
| EVERY_8_MONTHS | &quot;every_8_months&quot; |
| EVERY_9_MONTHS | &quot;every_9_months&quot; |
| EVERY_10_MONTHS | &quot;every_10_months&quot; |
| EVERY_11_MONTHS | &quot;every_11_months&quot; |
| EVERY_12_MONTHS | &quot;every_12_months&quot; |



## Enum: CalculationEnum

| Name | Value |
|---- | -----|
| CURRENT_PERIOD | &quot;current_period&quot; |
| PREVIOUS_PERIOD_ | &quot;previous_period&#39;&quot; |



