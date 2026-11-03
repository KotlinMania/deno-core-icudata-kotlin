import Testing
import DenoCoreIcudata

@Suite struct DenoCoreIcudataExportTests {
    @Test func testIcuDataMatchesCommonTestExpectations() throws {
        let data = ICU_DATA

        #expect(data.size == 10_822_192)
        #expect(UInt8(bitPattern: data[0]) == 0x90)
        #expect(UInt8(bitPattern: data[1]) == 0x00)
        #expect(UInt8(bitPattern: data[2]) == 0xDA)
        #expect(UInt8(bitPattern: data[3]) == 0x27)
    }

    @Test func testIcuDataReturnsDefensiveCopies() throws {
        let data = ICU_DATA
        let firstByte = data[0]

        data[0] = 0

        #expect(ICU_DATA[0] == firstByte)
    }
}
