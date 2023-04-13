package org.example.lapis.service

import jakarta.persistence.EntityNotFoundException
import org.example.lapis.data.Transaction
import org.example.lapis.data.TransactionStatus.APPROVED
import org.example.lapis.data.TransactionStatus.PENDING
import org.example.lapis.data.repo.CustomerRepository
import org.example.lapis.data.repo.TransactionRepository
import org.springframework.stereotype.Service

@Service
class CustomerTransactionServiceImpl(
    private val customerRepository: CustomerRepository,
    private val transactionRepository: TransactionRepository,
) : CustomerTransactionService {

    override fun createTransaction(customerId: Long, operation: String, createdBy: String): Transaction {
        val customer = customerRepository.findById(customerId).orElseThrow { EntityNotFoundException() }
        val transaction = Transaction(
            customerId = customerId,
            operation = operation,
            status = PENDING,
            createdBy = createdBy)

        transactionRepository.save(transaction)
        return transaction
    }

    override fun activateTransaction(transactionId: Long, approvedBy: String): Transaction {
        val transaction = transactionRepository.findById(transactionId).orElseThrow { EntityNotFoundException() }
        if (transaction.status != PENDING) {
            throw IllegalArgumentException("Transaction must be Pending to be activated")
        }
        val customer = customerRepository.findById(transaction.customerId).orElseThrow { EntityNotFoundException() }
        customer.active = true
        transaction.status = APPROVED
        transactionRepository.save(transaction)
        return transaction
    }

    override fun deactivateTransaction(transactionId: Long, approvedBy: String): Transaction {
        val transaction = transactionRepository.findById(transactionId).orElseThrow { EntityNotFoundException() }
        if (transaction.status != PENDING) {
            throw IllegalArgumentException("Transaction must be Pending to be deactivated")
        }
        val customer = customerRepository.findById(transaction.customerId).orElseThrow { EntityNotFoundException() }
        customer.active = false
        transaction.status = APPROVED
        transactionRepository.save(transaction)
        return transaction
    }
}