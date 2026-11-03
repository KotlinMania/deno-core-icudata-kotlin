package io.github.kotlinmania.build;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

/** Embeds the vendored ICU bytes as Kotlin constants without oversized JVM strings. */
public final class IcuDataGenerator {
    private static final int CHUNK_BYTES = 32 * 1024;
    private static final String OUTPUT = "io/github/kotlinmania/denocoreicudata/IcuDataChunks.kt";

    private IcuDataGenerator() {}

    public static int run(String... arguments) throws IOException {
        if (arguments.length != 2) {
            throw new IllegalArgumentException("Usage: IcuDataGenerator <icudtl.dat> <generated-source-directory>");
        }
        generate(Path.of(arguments[0]), Path.of(arguments[1]));
        return 0;
    }

    public static void main(String[] arguments) throws IOException {
        run(arguments);
    }

    public static void generate(Path input, Path outputDirectory) throws IOException {
        if (!Files.isRegularFile(input)) {
            throw new IOException("Required vendored ICU data file is missing: " + input);
        }
        long size = Files.size(input);
        if (size > Integer.MAX_VALUE) {
            throw new IOException("ICU payload exceeds Kotlin ByteArray capacity: " + size);
        }
        Path output = outputDirectory.resolve(OUTPUT);
        Files.createDirectories(output.getParent());
        try (InputStream bytes = Files.newInputStream(input);
                BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            writer.write("// Generated from src/common/commonMain/data/icudtl.dat; do not edit.\n");
            writer.write("package io.github.kotlinmania.denocoreicudata\n\n");
            writer.write("internal const val ICU_DATA_TOTAL_BYTES: Int = " + size + "\n\n");
            writer.write("internal val ICU_DATA_CHUNKS: List<String> =\n    listOf(\n");
            long writtenBytes = 0;
            byte[] chunk;
            while ((chunk = bytes.readNBytes(CHUNK_BYTES)).length != 0) {
                writer.write("        \"");
                writer.write(Base64.getEncoder().encodeToString(chunk));
                writer.write("\",\n");
                writtenBytes += chunk.length;
            }
            writer.write("    )\n");
            if (writtenBytes != size) {
                throw new IOException("ICU payload size changed during generation: " + input);
            }
        }
    }
}
