import XCTest
import DenoCoreIcudata

final class DenoCoreIcudataExportTests: XCTestCase {
    func testIcuDataMatchesCommonTestExpectations() throws {
        let data = ICU_DATA

        XCTAssertEqual(data.size, 10_822_192)
        XCTAssertEqual(UInt8(bitPattern: data[0]), 0x90)
        XCTAssertEqual(UInt8(bitPattern: data[1]), 0x00)
        XCTAssertEqual(UInt8(bitPattern: data[2]), 0xDA)
        XCTAssertEqual(UInt8(bitPattern: data[3]), 0x27)
    }

    func testIcuDataReturnsDefensiveCopies() throws {
        let data = ICU_DATA
        let firstByte = data[0]

        data[0] = 0

        XCTAssertEqual(ICU_DATA[0], firstByte)
    }
}
