package org.example.lapis.service

import org.example.lapis.data.Transaction

interface CustomerTransactionService {
    fun createTransaction(customerId: Long, operation: String, createdBy: String): Transaction
    fun activateTransaction(transactionId: Long, approvedBy: String): Transaction
    fun deactivateTransaction(transactionId: Long, approvedBy: String): Transaction
}