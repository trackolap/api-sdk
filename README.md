# TrackOlap API
TrackOlap Server to Server API SDK

## Guide

TrackOlap is leader in location science and solutions for modern businesses, enterprises and educational institutions. Our Location science and Efficiency solution is a perfect fit for all type of business owners to improve their business operations whether assets, vehicles, employees or managing facilities. TrackOlap helps global enterprises to re imagine their businesses for the digital age. We seek to innovate in a way that minimizes the gap between our offerings and client needs, until both are at zero distance from one another.

API Documenation : https://trackolap.com/help/api-doc/

Authentication: Calling system has to send following headers with each request

platform : “S2S“

tlp-cid : Customer ID . (Get under Admin section)

tlp-t : System TimeStamp (till millsecond)

tlp-k : System generated Aith Token based on following logic
    
    Token = (Base 64 of (SHA 256 of (Customer Id + timestamp + Api URL + Post
    Data (optional in case of Get method) + API Key)))
    API Key & Customer ID can be access under admin section of Trackolap Web Portal.

API key can be reset anytime from TrackOlap web portal but Customer Id will always be static


This repo shows you how to integrate TrackOlap Api's into your system. It's a example built on Java. 

## What You'll Need

* Customerid - [Get it from here](https://platform.trackolap.com/)  
* API Secret - [Get it from here](https://platform.trackolap.com/)

Also you can contact care@trackolap.com to get the customer id and API Secret.

## Supported platform
* Any platform which can consume rest Based http request and response (in json).

## Running the Example
1. [Get Customer and API Secrret ](https://platform.trackolap.com/). Also you can contact care@trackolap.com to get the customer id and API Secret.
2. Download the example (java) and import the project 
3. Put the customer id and API secret in AssetTest -> setup Method.
4. Call the AssetTest class.

Have an issue? Please [contact us](mailto:care@trackpolap.com) or [create an issue on GitHub](https://github.com/trackolap/api-sdk/issues)

Server to Server API’s respects a fair usuage policy and won’t support more then 10 QPS. If you want to support more the 10 QPS then please contact support team i.e. care@trackolap.com

