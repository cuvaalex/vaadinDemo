Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User login with correct value
Given login windows
When I log my $username and $password
Then system show the main page

Scenario: User login with wrong value
Given login windows
When I log my $username and $password and their are uncorrect
Then system show the login page

Scenario: User login with wrong value 3 times
Given login windows
When I log my $username and $password and their are uncorrect for 3 time
Then system show an error page and the user is blocked for 1 hour



