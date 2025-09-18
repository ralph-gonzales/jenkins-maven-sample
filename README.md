# jenkins-maven-sample

A tiny Maven + Java project you can push to GitHub and use for Jenkins practice.
It includes JUnit 5 tests, JaCoCo coverage, Checkstyle, SpotBugs, and a cross‑platform `Jenkinsfile` (works on Windows and Linux agents).

## Build & test locally

```bash
mvn -B -U clean verify
```

- Unit tests: Surefire (`*Test.java`)
- Integration tests: Failsafe (`*IT.java`)
- Coverage report: `target/site/jacoco/index.html`
- Checkstyle report: `target/site/checkstyle.html`
- SpotBugs report: `target/spotbugsXml.xml` & `target/site/spotbugs.html`

## Run the app

```bash
mvn -q -DskipTests exec:java -Dexec.mainClass=com.example.app.App
```

## Jenkins usage

**Pipeline Script from SCM:** Commit this repo with `Jenkinsfile` at the root and create a Multibranch Pipeline or a Pipeline job set to "Pipeline script from SCM".

**Inline Pipeline Script:** Copy the `Jenkinsfile` contents into a Pipeline job. (Keeping it in SCM is recommended.)

### Jenkinsfile stages
- **Checkout**: `checkout scm`
- **Build & Test**: `mvn clean verify` (runs unit + integration tests, static analysis, coverage)
- Archives test results and reports as artifacts

> The Jenkinsfile auto-detects Windows vs Linux and uses `bat` or `sh` accordingly.

## Push to GitHub (example)

```bash
git init
git add .
git commit -m "feat: initial Jenkins-friendly Maven sample"
git branch -M main
git remote add origin https://github.com/<your-username>/jenkins-maven-sample.git
git push -u origin main
```
