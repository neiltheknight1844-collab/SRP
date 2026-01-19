$ErrorActionPreference = "Stop"

$GradleVersion = "8.8"
$Dist = "gradle-$GradleVersion-bin.zip"
$Url = "https://services.gradle.org/distributions/$Dist"
$CacheDir = ".gradle-bin"
$GradleDir = Join-Path $CacheDir "gradle-$GradleVersion"
$ZipPath = Join-Path $CacheDir $Dist

# Java 17 check
try {
  $javaLine = (& java -version 2>&1 | Select-Object -First 1)
} catch {
  Write-Error "ERROR: Java not found. Install Java 17 and re-run."
  exit 1
}

if ($javaLine -match '"([0-9]+)\.') {
  $major = $Matches[1]
} else {
  Write-Error "ERROR: Could not parse java version."
  exit 1
}

if ($major -ne '17') {
  Write-Error "ERROR: Java 17 required. Detected Java $major."
  exit 1
}

New-Item -ItemType Directory -Force -Path $CacheDir | Out-Null

if (-not (Test-Path $GradleDir)) {
  if (-not (Test-Path $ZipPath)) {
    Write-Host "Downloading Gradle $GradleVersion..."
    Invoke-WebRequest -Uri $Url -OutFile $ZipPath
  }
  Write-Host "Extracting Gradle..."
  Expand-Archive -Path $ZipPath -DestinationPath $CacheDir -Force
}

Write-Host "Building mod JAR..."
$gradleExe = Join-Path $GradleDir "bin\\gradle.bat"
& $gradleExe --no-daemon build

Write-Host "Done. Check build\\libs for the mod jar."
