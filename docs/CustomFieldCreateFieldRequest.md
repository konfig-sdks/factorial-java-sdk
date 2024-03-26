

# CustomFieldCreateFieldRequest


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**label** | **String** |  |  |
|**slugName** | **String** |  |  |
|**fieldType** | [**FieldTypeEnum**](#FieldTypeEnum) |  |  |
|**minValue** | **Integer** |  |  [optional] |
|**maxValue** | **Integer** |  |  [optional] |
|**required** | **Boolean** |  |  |
|**editable** | [**EditableEnum**](#EditableEnum) |  |  |
|**visible** | [**VisibleEnum**](#VisibleEnum) |  |  |
|**choiceOptions** | [**List&lt;CustomFieldCreateFieldRequestChoiceOptionsInner&gt;**](CustomFieldCreateFieldRequestChoiceOptionsInner.md) |  |  [optional] |



## Enum: FieldTypeEnum

| Name | Value |
|---- | -----|
| TEXT | &quot;text&quot; |
| LONG_TEXT | &quot;long_text&quot; |
| NUMBER | &quot;number&quot; |
| SINGLE_CHOICE | &quot;single_choice&quot; |



## Enum: EditableEnum

| Name | Value |
|---- | -----|
| OWNED | &quot;owned&quot; |
| REPORTEES | &quot;reportees&quot; |
| TEAM_LEADER | &quot;team_leader&quot; |
| EVERYBODY | &quot;everybody&quot; |



## Enum: VisibleEnum

| Name | Value |
|---- | -----|
| OWNED | &quot;owned&quot; |
| REPORTEES | &quot;reportees&quot; |
| TEAM_LEADER | &quot;team_leader&quot; |
| EVERYBODY | &quot;everybody&quot; |



