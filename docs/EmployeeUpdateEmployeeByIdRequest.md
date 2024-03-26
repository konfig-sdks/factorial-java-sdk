

# EmployeeUpdateEmployeeByIdRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**email** | **String** |  |  [optional] |
|**firstName** | **String** |  |  [optional] |
|**lastName** | **String** |  |  [optional] |
|**birthdayOn** | **String** |  |  [optional] |
|**role** | [**RoleEnum**](#RoleEnum) |  |  [optional] |
|**gender** | [**GenderEnum**](#GenderEnum) |  |  [optional] |
|**identifier** | **String** |  |  [optional] |
|**identifierType** | [**IdentifierTypeEnum**](#IdentifierTypeEnum) |  |  [optional] |
|**nationality** | **String** |  |  [optional] |
|**bankNumber** | **String** |  |  [optional] |
|**country** | **String** |  |  [optional] |
|**city** | **String** |  |  [optional] |
|**state** | **String** |  |  [optional] |
|**postalCode** | **String** |  |  [optional] |
|**addressLine1** | **String** |  |  [optional] |
|**addressLine2** | **String** |  |  [optional] |
|**swiftBic** | **String** |  |  [optional] |
|**managerId** | **Integer** |  |  [optional] |
|**locationId** | **Integer** |  |  [optional] |
|**timeoffManagerId** | **Integer** |  |  [optional] |
|**phoneNumber** | **String** |  |  [optional] |
|**socialSecurityNumber** | **Integer** |  |  [optional] |
|**legalEntityId** | **Integer** |  |  [optional] |
|**companyIdentifier** | **String** |  |  [optional] |
|**contactName** | **String** |  |  [optional] |
|**contactNumber** | **String** |  |  [optional] |
|**taxId** | **String** |  |  [optional] |



## Enum: RoleEnum

| Name | Value |
|---- | -----|
| BASIC | &quot;basic&quot; |
| ADMIN | &quot;admin&quot; |



## Enum: GenderEnum

| Name | Value |
|---- | -----|
| MALE | &quot;male&quot; |
| FEMALE | &quot;female&quot; |



## Enum: IdentifierTypeEnum

| Name | Value |
|---- | -----|
| DNI | &quot;dni&quot; |
| NIE | &quot;nie&quot; |
| PASSPORT | &quot;passport&quot; |



