<#
.SYNOPSIS
Get-MemoryInfo Muestra cuanto espacio libre hay en
memoria y en swap.
.DESCRIPTION
Get-MemoryInfo utiliza el comanto Get-WmiObject y la
clase win32_operatingsystem para obtener información del
espacio libre en memoria y swap.
.EXAMPLE
Get-MemoryInfo
#>
Get-WmiObject -Class win32_operatingsystem | select FreeVirtualMemory,FreeSpaceInPagingFiles