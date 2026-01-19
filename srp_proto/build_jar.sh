#!/usr/bin/env bash
set -euo pipefail

GRADLE_VERSION="8.8"
DIST="gradle-${GRADLE_VERSION}-bin.zip"
URL="https://services.gradle.org/distributions/${DIST}"
CACHE_DIR=".gradle-bin"
GRADLE_DIR="${CACHE_DIR}/gradle-${GRADLE_VERSION}"
ZIP_PATH="${CACHE_DIR}/${DIST}"

# Java 17 check
if ! command -v java >/dev/null 2>&1; then
  echo "ERROR: Java not found. Install Java 17 and re-run." >&2
  exit 1
fi

MAJOR=$(java -version 2>&1 | head -n 1 | sed -E 's/.*"([0-9]+).*/\1/')
if [ "${MAJOR}" != "17" ]; then
  echo "ERROR: Java 17 required. Detected Java ${MAJOR}." >&2
  exit 1
fi

mkdir -p "${CACHE_DIR}"

if [ ! -d "${GRADLE_DIR}" ]; then
  if [ ! -f "${ZIP_PATH}" ]; then
    echo "Downloading Gradle ${GRADLE_VERSION}..."
    if command -v curl >/dev/null 2>&1; then
      curl -L -o "${ZIP_PATH}" "${URL}"
    elif command -v wget >/dev/null 2>&1; then
      wget -O "${ZIP_PATH}" "${URL}"
    else
      echo "ERROR: Need curl or wget to download Gradle." >&2
      exit 1
    fi
  fi
  echo "Extracting Gradle..."
  unzip -q "${ZIP_PATH}" -d "${CACHE_DIR}"
fi

echo "Building mod JAR..."
"${GRADLE_DIR}/bin/gradle" --no-daemon build

echo "Done. Check build/libs for the mod jar." 
