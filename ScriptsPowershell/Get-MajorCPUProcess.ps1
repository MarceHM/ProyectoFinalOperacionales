<#
.SYNOPSIS
Get-MajorCPUProcess Muestra las lista de los cinco (5)
procesos que consumen más CPU.
.DESCRIPTION
Get-MajorCPUProcess utiliza el comanto Get-Process
para obtener los procesos.
.EXAMPLE
Get-MajorCPUProcess
#>

Get-Process | sort CPU -Descending | select Name,Id,CPU,VM,Description -First 5