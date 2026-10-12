# romannumerals4j

Tiny Java library for formatting and parsing Roman numerals, sourced from 
various StackOverflow posts.

Released under [CC-BY-SA 3.0](https://creativecommons.org/licenses/by-sa/3.0/legalcode.txt).

## Usage

### Formatting
Formatting numbers (1-3999 only):

```java
import com.github.fracpete.romannumerals4j.RomanNumeralFormat;
...
RomanNumeralFormat f = new RomanNumeralFormat();
System.out.println(f.format(57));
```

Outputs:
```
LVII
```

### Parsing
Parsing numbers:

```java
import com.github.fracpete.romannumerals4j.RomanNumeralFormat;
...
RomanNumeralFormat f = new RomanNumeralFormat();
System.out.println(f.parse("LVII"));
```

Outputs:
```
57
```

## Maven
Use the following dependency in your Maven project:

```xml
<dependency>
    <groupId>com.github.fracpete</groupId>
    <artifactId>romannumerals4j</artifactId>
    <version>0.0.1</version>
</dependency>
```
## Continuous Integration (CI)
This repository uses GitHub Actions for continuous integration. The pipeline is configured in `.github/workflows/maven.yml` and automatically executes on every push to the `main` branch. 

**Pipeline Steps:**
1. Sets up JDK 17.
2. Executes `mvn clean test` to run the JUnit 5 test suite.
3. Generates a JaCoCo code coverage report.
4. Uploads the JaCoCo HTML report as a downloadable artifact (v4) for coverage verification.
