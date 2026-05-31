# Payment and Checkout Processing Gateway

This is a Spring Boot 3.x starter application that handles payment processing operations. It provides a RESTful interface for external clients to submit payment payloads and delegates logic to internal services.

## Project Structure
- Built with Java 21 and Spring Boot 3.x
- Configured as a standard Maven repository

## Getting Started

To run the application locally:
```bash
./mvnw spring-boot:run
```

## Endpoints

### Process Payment
`POST /api/payment/process`
Processes a payment payload.

**Expected Payload:**
```json
{
  "transactionId": "txn_123456"
}
```
