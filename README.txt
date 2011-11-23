
--------
Summary:
--------

This simple project represents how the Google+ API can be used on Android

--------
Details:
--------

The application provides 4 interaction buttons with the user. 
- Button 1: Authentication. 
-- OAuth 2.0 dance is used with the Google servers to authenticate the user. A
   webview is shown to the user in order to fill the credentials (uname/passwd).
- Button 2: Profile.
-- The user gets information about his profile.
- Button 3: Profile Search
-- The user can search "by name" through Google+ profiles and see their Activity.
- Button 4: Clear Google+ Credentials
-- The application stores the Access-token, Expiration-date and Refresh-token.
   No uname/passwd is stored anywhere.
   
-------------
Installation:
-------------

Clone the project and import it to your Eclipse. The libraries are already
included.

IMPORTANT: Before running your application fill the CLIENT_ID and CLIENT_SECRET
           in the SharedPreferencesCredentialStore class. You can find them at 
           https://code.google.com/apis/console