#`keytool`

## generate key

```
keytool -genkey -alias dukecert -keyalg RSA -keysize 2048 -keystore dukestore -storepass duke123
```

## export public key

```
keytool -export -alias dukecert -file duke.cer -keystore dukestore -storepass duke123
```

## print key

```
keytool -printcert  -file duke.cer
```

## import key

```
keytool -import -alias dukecert -file duke.cer -keystore susanstore -storepass susan123
```

## list keys

```
keytool -list -keystore susanstore -storepass susan123
keytool -list -keystore dukestore -storepass duke123
```

## sign jar file

```
jarsigner -keystore dukestore -signedjar good-signed-app.jar good-app.jar dukecert
```

## run jar with security manager

Powershell

```
java "-Djava.security.manager" "-Djava.security.policy=app-signed.policy" -jar .\good-app.jar
```

Bash

```
java -Djava.security.manager -Djava.security.policy=sib_signed.policy -jar good-app.jar
```
