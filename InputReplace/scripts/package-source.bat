@echo off
pushd %~dp0..
del InputReplace-src.7z
"c:\Program Files\7-Zip\7z.exe" a InputReplace-src.7z @scripts\srclist.txt -bb -xr!.*.marks -xr!.svn
popd
