# Criminal Intent 2020 — AppSec Training Sandbox
[![software_quality_security_issues](https://sonarcloud.io/api/project_badges/measure?project=orlovgithuborg_vulnerable-node&metric=software_quality_security_issues)](https://sonarcloud.io/summary/new_code?id=orlovgithuborg_vulnerable-node)

Android project built from Big Nerd Ranch Guide, 3rd Edition, extended as an internal
security awareness training application.

## Purpose

This repository is used by the team for hands-on OWASP Top 10 training exercises.
Source files under `security/`, `auth/`, and `utils/` contain **intentional vulnerability
examples** for educational use. They are not deployed to production.

| Package | Contents |
|---|---|
| `security/` | SQL injection, weak hashing examples |
| `auth/` | Authentication bypass patterns |
| `utils/` | Helper scaffolding for training pipeline |

Findings flagged by static analysis in these packages are expected by design.
The production application code lives in the root package only.



## Setup



Standard Android project — open in Android Studio, sync Gradle, run on emulator.


FaketToken=6jV1QhZhkKdwBbpDjPqgjOulQ5EUeouydEgX81xLmcBIT5Ohi4wgvqDt4pPAbliO
