[![wercker status](https://app.wercker.com/status/ce550090c4e12182442fb0af7ed7928b/s/master "wercker status")](https://app.wercker.com/project/byKey/ce550090c4e12182442fb0af7ed7928b)

# Description

Tago SDK for Java.

| what                  | where                    |
|-----------------------|--------------------------|
| Tago website          | http://tago.io           |
| SDK documentation     | http://sdk.java.tago.io    |
| General documentation | http://docs.tago.io      |
| Slack / Community     | http://community.tago.io |

# Installation

Maven
``` xml
<dependency>
    <groupId>io.tago.java</groupId>
    <artifactId>tago-java-maven-plugin</artifactId>
    <version>4.0.1</version>
</dependency>
```

Gradle
``` gradle
compile 'io.tago.java:tago-java-maven-plugin:4.0.1'
```

[Other Options](http://search.maven.org/#artifactdetails%7Cio.tago.java%7Ctago-java-maven-plugin%7C4.0.1%7Cjar)


# Quick Example
## Insert Device Data
``` java
Device device = new Device("8aa46f99-3156-4ebd-a275-fdb75c4dccbf");

final Object loc = new Object() {
    public Double lat = 42.2974279;
    public Double lng = -85.628292;
};

Object dataToInsert = new Object() {
    public String variable = "temperature";
    public String unit = "C";
    public Integer value = 63;
    public String time = "2015-11-03 13:44:33";
    public Object location = loc;
};

Result res = device.insert(data);

// -> See full documentation at: http://sdk.java.tago.io/
```

# License

Tago SDK for Java is released under the [Apache-2.0 License](https://github.com/tago-io/tago-sdk-java/blob/master/LICENSE.md).



Netty.io

https://netty.io/wiki/user-guide-for-4.x.html
https://netty.io/4.1/api/io/netty/handler/codec/ReplayingDecoder.html
