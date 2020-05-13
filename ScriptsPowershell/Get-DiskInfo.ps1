<#
.SYNOPSIS
Get-DiskInfo Muestra los filesystems o discos que
están conectados a la maquina.
.DESCRIPTION
Get-DiskInfo utiliza el comanto Get-WmiObject y la
clase win32_logicaldisk para obtener información del
espacio libre, tamaño total, nombre e Id de un disco.
.EXAMPLE
Get-DiskInfo
#>

Get-WmiObject -Class win32_logicaldisk | select DeviceID,VolumeName,Size,FreeSpace