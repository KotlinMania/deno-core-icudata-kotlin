// port-lint: ignore — verifies the embedded ICU_DATA round-trips the upstream tmp/deno_core_icudata/src/icudtl.dat blob.
package io.github.kotlinmania.denocoreicudata

import kotlin.test.Test
import kotlin.test.assertEquals

class IcuDataTest {

    @Test
    fun matchesUpstreamLength() {
        assertEquals(10_822_192, ICU_DATA.size)
    }

    @Test
    fun startsWithUDataInfoMagic() {
        // ICU `UDataInfo` headers always begin with a uint16 little-endian
        // header size followed by the two-byte magic number 0xDA 0x27. The
        // upstream icudtl.dat has a 0x0090-byte header and the stable magic.
        assertEquals(0x90.toByte(), ICU_DATA[0])
        assertEquals(0x00.toByte(), ICU_DATA[1])
        assertEquals(0xDA.toByte(), ICU_DATA[2])
        assertEquals(0x27.toByte(), ICU_DATA[3])
    }

    @Test
    fun exposesDefensiveCopies() {
        val data = ICU_DATA
        val firstByte = data[0]

        data[0] = 0

        assertEquals(firstByte, ICU_DATA[0])
    }
}
