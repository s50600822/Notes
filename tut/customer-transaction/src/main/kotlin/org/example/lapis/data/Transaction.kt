package org.example.lapis.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import java.lang.System.*

@Entity
data class Transaction(
    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null, // ? cause hibernate to generate id and allow generated constructor that does not require the field
    var customerId: Long,
    var operation: String,
    var status: TransactionStatus,
    var createdBy: String,
    var createdEpoch: Long = currentTimeMillis(),
    var lastUpdated: Long = currentTimeMillis()
)


enum class TransactionStatus {
    PENDING,
    EDITING,
    APPROVED,
    NOT_APPROVED,
    DELETED
}