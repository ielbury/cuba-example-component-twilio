# cuba-example-component-twilio
CUBA example that shows how to create a app component that uses custom Spring MVC controllers.

The example integrates with the Twilio API with a sample Webhook. It contains of the two CUBA projects:

* cuba-component-example-twilio - the application component that includes the Twilio WebHook
* cuba-app-using-twilio - the application that uses the app-component

The actual Spring REST Controller is [TwilioWebHookController](https://github.com/mariodavid/cuba-example-component-twilio/blob/master/cuba-component-example-twilio/modules/web/src/com/company/ccet/controllers/TwilioWebHookController.java).
It is registered in the [rest-dispatcher-spring.xml](https://github.com/mariodavid/cuba-example-component-twilio/blob/master/cuba-component-example-twilio/modules/web/src/com/company/ccet/rest-dispatcher-spring.xml) which is registered as the additional XML configuration in the [web-app.properties](https://github.com/mariodavid/cuba-example-component-twilio/blob/master/cuba-component-example-twilio/modules/web/src/com/company/ccet/web-app.properties#L47).

The application using the app component only registeres the rest-dispatcher-spring.xml as well in the [web-app.properties](https://github.com/mariodavid/cuba-example-component-twilio/blob/master/cuba-app-using-twilio/modules/web/src/com/company/caut/web-app.properties#L48).

In order to get it running do the following:

1. clone the respository
2. Open the application component "cuba-component-example-twilio" in Studio
3. Select "Run > Install app component"
4. Open the application "cuba-app-using-twilio" in Studio
5. Start the application
6. make a HTTP request to the HTTP entpoint `curl -X GET http://localhost:8080/app/rest/twilio/callback`
