# sendsms
 An app to send sms from the data recieved from a server. This uses SMSManager in the Android to send a message without opening the default messaging app,it sends it via background service. This was used for a OTP, booking confirmation module for a project
</br>
<img src = "https://github.com/vignesh98/sendsms/blob/master/Githubpics/servernotstarted.jpg" width=150>
<img src = "https://github.com/vignesh98/sendsms/blob/master/Githubpics/serverstarted.jpg" width=150>
<img src = "https://github.com/vignesh98/sendsms/blob/master/Githubpics/serverstopped.jpg" width=150>

<h2>Usage</h2>
</br>
1. Connect the device in which this app is used to the same wifi as the one you want to make a httprequest from</br>
2. note down the ip address of the device where this app is installed in.</br>
3. make sure to provide SMS permission in android device</br>
4. just make a get request 192.168.0.102:8080/?number=1234567890&smsbody=messagetobesent where the ip is replaced by the device ip and number with the mobile number where the message is to be sent</br>
