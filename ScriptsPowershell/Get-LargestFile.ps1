<#
.SYNOPSIS
Get-LargestFile Muestra el archivo más grande en
un directorio dado.
.DESCRIPTION
Get-LargestFile utiliza el comanto Get-ChildItem
para obtener un archivo de un directorio.
.PARAMETER Path
La ruta del archivo a consultar. Es un parametro
obligatorio.
.EXAMPLE
Get-LargestFile -NameDirectory C:\Users\PC\Documents
#>

[CmdletBinding()]
param (
[Parameter(Mandatory=$True)]
[Alias('directory')]
[string]$Path
)

$Path=$args[0]
Get-ChildItem -Path $Path | sort Length -Descending | select Mode,Name,Length,PSPath -First 1
