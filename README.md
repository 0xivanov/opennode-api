
# OpenNode API Library

[![Maven Central](https://img.shields.io/maven-central/v/io.github.0xivanov/opennodeapi.svg?label=Maven%20Central)](https://search.maven.org/artifact/io.github.0xivanov/opennodeapi/1.0.1/jar)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/0xivanov/opennode-api-library/blob/main/LICENSE)

This is the official Java library for interacting with the OpenNode API. OpenNode is a simple and powerful payments platform that allows businesses to accept Bitcoin.

## Installation

### Maven

Add this library to your Maven project by including the following dependency:

```xml
<dependency>
    <groupId>io.github.0xivanov</groupId>
    <artifactId>opennodeapi</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Gradle

For Gradle projects, include the dependency like this:

```gradle
implementation 'io.github.0xivanov:opennodeapi:1.0.1'
```
## Configuration

Before using the OpenNode API Library, you need to provide your API key and read key as properties in your application. To do this, follow these steps:

1. In your application configuration (e.g., `application.properties` or `application.yml`), add the following properties with your actual API key and read key:

```properties
open.node.key=your_api_key_here
open.node.read_key=your_read_key_here
```
```yaml
open:
  node:
    key: your_api_key_here
    read_key: your_read_key_here
```
Make sure to replace `"your_api_key_here"` with your actual OpenNode API key.

## Usage

Here's how you can use this library to interact with the OpenNode API:

```java
package com.example.opennodeapi;

import com.example.opennodeapi.models.OpenNodeChargeInfo;
import com.example.opennodeapi.models.OpenNodeChargeResponse;
import com.example.opennodeapi.models.OpenNodeCreateCharge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OpennodeApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OpennodeApiApplication.class, args);

        OpenNodeService openNodeService = context.getBean(OpenNodeService.class);

        createCharge(openNodeService);
        getCharge(openNodeService, "aef7cc29-ccf9-404e-a2ca-64edc273bba9");
        listCharges(openNodeService);
    }

    private static void createCharge(OpenNodeService openNodeService) {
        OpenNodeCreateCharge charge = OpenNodeCreateCharge.builder().amount(1).build();

        OpenNodeChargeResponse createdCharge = openNodeService.createCharge(charge);
        System.out.println("Created Charge: " + createdCharge);
    }

    private static void getCharge(OpenNodeService openNodeService, String chargeId) {
        OpenNodeChargeInfo chargeInfo = openNodeService.getCharge(chargeId);
        System.out.println("Charge Info: " + chargeInfo);
    }

    private static void listCharges(OpenNodeService openNodeService) {
        var chargeList = openNodeService.listPaidCharges();
        System.out.println("Charge List: " + chargeList);
    }
}

```

## Documentation

For detailed documentation on how to use this library and the available API endpoints, please refer to the [OpenNode API Documentation](https://opennode.com/docs).

## License

This library is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or issues, feel free to [open an issue](https://github.com/0xivanov/opennode-api-library/issues) on GitHub.

---

© 2023 [0xivanov]
