package io.cosmostation.suikotlin.model

data class SuiObjectInfo(
    val objectId: String, val version: Int, val digest: String, val type: String, val owner: SuiObjectOwner, val previousTransaction: String
)

data class SuiObjectData(
    val data: SuiObjectInfo,
)

data class SuiNextCursor(
    val objectId: String, val atCheckpoint: Long
)

data class SuiObjectDataResult(
    val data: List<SuiObjectData>, val hasNextPage: Boolean, val nextCursor: SuiNextCursor, val limit: Int
)

data class SuiObjectOwner(val AddressOwner: String)

data class SuiWrappedTxBytes(
    val txBytes: String, val gas: SuiObjectRef, val inputObjects: List<ImmOrOwnedMoveObject>
)

data class ImmOrOwnedMoveObject(val ImmOrOwnedMoveObject: SuiObjectRef)

data class SuiObjectRef(val objectId: String, val version: Int, val digest: String)

data class SuiTransactionDigest(val data: List<String>, val nextCursor: String)

sealed class TransactionQuery {
    class ToAddress(val ToAddress: String) : TransactionQuery()
    class FromAddress(val FromAddress: String) : TransactionQuery()
}
