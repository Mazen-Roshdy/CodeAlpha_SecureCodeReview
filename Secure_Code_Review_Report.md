# Secure Coding Review Report

## Project Information

**Application Name:** VulnerableApp.java  
**Programming Language:** Java  
**Review Type:** Manual Secure Code Review  
**Reviewer:** Mazen Mahmoud Roshdy

---

## Vulnerability 1: Hardcoded Credentials

**Description:**
Database credentials are directly stored in the source code.

**Risk:**
If attackers gain access to the source code, they can retrieve database credentials (Username, Passwords) and compromise the system.

**Recommendation:**
Store credentials securely using environment variables or external configuration files.

---

## Vulnerability 2: SQL Injection

**Description:**
User input is directly concatenated into an SQL query.

**Risk:**
Attackers can manipulate SQL queries to bypass authentication or extract sensitive data.

**Recommendation:**
Use PreparedStatement instead of Statement to prevent SQL injection.

---

## Vulnerability 3: Information Disclosure

**Description:**
Application prints database connection success messages directly to users.

**Risk:**
This may reveal internal system behavior to attackers.

**Recommendation:**
Use secure logging mechanisms instead of exposing system messages to users.

---

## Vulnerability 4: Stack Trace Exposure

**Description:**
Application prints full exception stack traces.

**Risk:**
Stack traces expose internal system paths and database structure.

**Recommendation:**
Display generic error messages to users and log detailed errors internally.
