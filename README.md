# 🥤 Distributeur Automatique (Java Console App)

A simple **Java console application** that simulates a vending machine.  
Users can choose a product, insert money, and buy items while the stock updates automatically.  
It’s a beginner-friendly project that practices loops, arrays, and basic OOP.

---

## 🚀 Features

- Displays available products with prices and stock.
- Allows users to select and purchase a product.
- Calculates and returns change.
- Updates stock after each purchase.
- Counts total purchases (`countAchat`).
- Handles invalid input and insufficient payment.
- Simple error handling with `try...catch`.

---

## 🧱 Structure

```bash
Main.java
│
├── VendingMachine (static inner class)
│   ├── produits  → product names
│   ├── prix      → product prices
│   ├── stock     → available quantity
│   └── countAchat → number of successful purchases
│
├── updateStock()  → manages stock updates and payment
├── AcheterPrduit() → handles user purchase input
└── main()          → displays menu and runs the program loop
