# deno-core-icudata-kotlin in Kotlin

[![GitHub link](https://img.shields.io/badge/GitHub-KotlinMania%2Fdeno--core--icudata--kotlin-blue.svg)](https://github.com/KotlinMania/deno-core-icudata-kotlin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kotlinmania/deno-core-icudata-kotlin)](https://central.sonatype.com/artifact/io.github.kotlinmania/deno-core-icudata-kotlin)
[![Build status](https://img.shields.io/github/actions/workflow/status/KotlinMania/deno-core-icudata-kotlin/ci.yml?branch=main)](https://github.com/KotlinMania/deno-core-icudata-kotlin/actions)

This is a Kotlin Multiplatform line-by-line transliteration port of [`denoland/deno_core_icudata`](https://github.com/denoland/deno_core_icudata).

**Original Project:** This port is based on [`denoland/deno_core_icudata`](https://github.com/denoland/deno_core_icudata). All design credit and project intent belong to the upstream authors; this repository is a faithful port to Kotlin Multiplatform with no behavioural changes intended.

### Porting status

This is an **in-progress port**. The goal is feature parity with the upstream Rust crate while providing a native Kotlin Multiplatform API. Every Kotlin file carries a `// port-lint: source <path>` header naming its upstream Rust counterpart so the AST-distance tool can track provenance.

---

## Upstream README — `denoland/deno_core_icudata`

> The text below is reproduced and lightly edited from [`https://github.com/denoland/deno_core_icudata`](https://github.com/denoland/deno_core_icudata). It is the upstream project's own description and remains under the upstream authors' authorship; links have been rewritten to absolute upstream URLs so they continue to resolve from this repository.

## ICU Data for `deno_core`

You can find the data file in Rusty V8's `third_party/icu/common/icudtl.dat`

---

## About this Kotlin port

### Installation

```kotlin
dependencies {
    implementation("io.github.kotlinmania:deno-core-icudata-kotlin:0.1.2")
}
```

### Building

```bash
./gradlew build
./gradlew test
```

### Targets

- macOS arm64
- Linux x64 / arm64
- Windows mingw-x64
- iOS arm64 / simulator-arm64 (Swift export + XCFramework)
- tvOS arm64 / simulator-arm64
- watchOS arm32 compile-only, plus arm64 / device-arm64 / simulator-arm64 framework slices
- JS (browser + Node.js)
- Wasm-JS (browser + Node.js)
- Wasm-WASI (Node.js)
- Android (API 24+)
- Android Native arm32 / arm64 / x64 / x86
- JVM

### Porting guidelines

See [AGENTS.md](AGENTS.md) and [CLAUDE.md](CLAUDE.md) for translator discipline, port-lint header convention, and Rust → Kotlin idiom mapping.

### License

This Kotlin port is distributed under the same MIT license as the upstream [`denoland/deno_core_icudata`](https://github.com/denoland/deno_core_icudata). See [LICENSE](LICENSE) (and any sibling `LICENSE-*` / `NOTICE` files mirrored from upstream) for the full text.

Original work copyrighted by the deno_core_icudata authors.  
Kotlin port: Copyright (c) 2026 Sydney Renee and The Solace Project.

### Acknowledgments

Thanks to the [`denoland/deno_core_icudata`](https://github.com/denoland/deno_core_icudata) maintainers and contributors for the original Rust implementation. This port reproduces their work in Kotlin Multiplatform; bug reports about upstream design or behavior should go to the upstream repository.
