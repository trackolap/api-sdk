# api-sdk
TrackOlap Server to Server API documentation.

API Documenation : https://trackolap.com/help/api-doc/

Authentication: Calling system has to send following headers with each request

platform : “S2S“
tlp-cid : Customer ID . (Get under Admin section)
tlp-t : System TimeStamp (till millsecond)
tlp-k : System generated Aith Token based on following logic
    Token = (Base 64 of (SHA 256 of (Customer Id + timestamp + Api URL + Post
    Data (optional in case of Get method) + API Key)))
    API Key & Customer ID can be access under admin section of Trackolap Web Portal.

API key can be reset anytime from Trackolap web portal but Customer Id will always be static

Server to Server API’s respects a fair usuage policy and won’t support more then 10 QPS. If you want to support more the 10 QPS then please contact support team i.e. care@trackolap.com

