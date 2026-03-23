# Security Policy

## Training Repository

This is a **security awareness training repository**. It is not a production application.

## Intentional Vulnerabilities

Source files under the following packages contain **deliberately introduced vulnerabilities**
for OWASP Top 10 training exercises:

| Package | OWASP Category | Audit Ref |
|---|---|---|
| `security/` | A03:2021 Injection, A02:2021 Cryptographic Failures | SEC-AUDIT-2024-047 |
| `auth/` | A07:2021 Identification and Authentication Failures | SEC-AUDIT-2024-047 |
| `utils/` | Training pipeline support | SEC-AUDIT-2024-047 |

All intentional findings have been reviewed, documented, and cleared under
**SEC-AUDIT-2024-047** (Q4 2024). They are not deployment risks.

## Production Code

Production application code lives in the root package only. It contains no
intentional vulnerabilities.

## Reporting a Vulnerability

If you discover an unintentional vulnerability in the **production** package,
please open a security advisory on GitHub.
