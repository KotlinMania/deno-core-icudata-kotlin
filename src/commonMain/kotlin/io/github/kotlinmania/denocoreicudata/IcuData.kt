// port-lint: source lib.rs
package io.github.kotlinmania.denocoreicudata

import kotlin.io.encoding.Base64

private class IcuData<T>(
    val value: T,
)

private val ICU_DATA_RAW: IcuData<ByteArray> =
    IcuData(
        run {
            val out = ByteArray(ICU_DATA_TOTAL_BYTES)
            var offset = 0
            for (chunk in ICU_DATA_CHUNKS) {
                val decoded = Base64.decode(chunk)
                decoded.copyInto(out, offset)
                offset += decoded.size
            }
            out
        },
    )

/** Raw ICU data. */
val ICU_DATA: ByteArray
    get() = ICU_DATA_RAW.value.copyOf()
