@echo off
pushd %~dp0..
call scripts\package-source.bat
call boxtools.cmd -put folder 53465999117 InputReplace-src.7z
popd
