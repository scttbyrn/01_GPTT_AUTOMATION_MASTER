Feature: Cashin/Cashout via Unified Wallet to GPTT Wallet

Scenario: Display Wallet Balance
Given the user is on the Cash In or Cash Out screen
When the system fetches account details via the fetch_account endpoint
Then the wallet balance virtual_visa fund should be displayed prominently at the top of the screen

Scenario: Cash In Flow
Given the user selects the Cash In option
When they enter an amount and confirm
Then the system should call the credit_fund endpoint to add the amount to the GPTT wallet
And display a success confirmation with the updated balance

Scenario: Cash Out Flow
Given the user selects the Cash Out option
When they enter an amount and confirm
Then the system should call the debit_fund endpoint to deduct the amount from the GPTT wallet 
And display a success confirmation with the updated balance

Scenario: Fee Display
Given the user is on either the Cash In or Cash Out screen
When the transaction details are displayed
Then the fee should be shown as ₱0.00 by default

Scenario: Error Handling
Given the API call fails or returns an error 
When the user attempts to cash in or cash out
Then an error message should be displayed explaining the issue
And the transaction should not proceed