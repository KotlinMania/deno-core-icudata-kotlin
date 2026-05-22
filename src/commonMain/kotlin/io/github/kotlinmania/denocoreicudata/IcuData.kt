// port-lint: source src/lib.rs
package io.github.kotlinmania.denocoreicudata

import kotlin.io.encoding.Base64

/** Raw ICU data. */
val ICU_DATA: ByteArray = run {
    val out = ByteArray(ICU_DATA_TOTAL_BYTES)
    var offset = 0
    for (chunk in ICU_DATA_CHUNKS) {
        val decoded = Base64.decode(chunk)
        decoded.copyInto(out, offset)
        offset += decoded.size
    }
    out
}
