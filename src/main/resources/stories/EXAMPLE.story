Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Lifecycle:
Before:
Given Print: Lifecycle: Before: Given
And Print: Lifecycle: Before: And
And Print: Lifecycle: Before: And2
After:
Outcome: ANY
Given Print: Lifecycle: After: Outcome: ANY Given
And Print: Lifecycle: After: Outcome: ANY And
And Print: Lifecycle: After: Outcome: ANY And2

Scenario: AC1
Given Print: AC1 Given
When Print: AC1 When
Then Fail: AC1 Then

Scenario: AC2
Given Print: AC2 Given
When Fail: AC2 When
Then Print: AC2 Then