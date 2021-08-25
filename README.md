# Angiotool ImageJ/Fiji Plugin
===========

A continuation of the effort to convert AngioTool ( https://ccrod.cancer.gov/confluence/display/ROB2/Home ) into a Fiji plugin in 2021.

## Update
Fixed compatibility issues with the latest versions of ImageJ 1 library.

Added support for macro assigning of parameter values.

Options for AngioTools are separated by a single space " "
* First option: sigma sizes (separated by comma ",") e.g. 10,30,40
* Second option: threshold_low e.g. 15
* Third option: threshold_high e.g. 255
* Fourth option: small particle removal (enter 0 for disable) e.g. 200
* Fifth option: Fill hole (enter 0 for disable) e.g. 1000

Example:

`run("AngioTool", "10,30,40 15 255 200 1000");`


To install, run maven:

`mvn -Dimagej.app.directory=/path_to_fiji/Fiji.app`
