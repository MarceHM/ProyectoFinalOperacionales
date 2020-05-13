<#
.SYNOPSIS
Get-ActiveConections Muestra las conecciones que estan
activas en la máquina.
.DESCRIPTION
Get-ActiveConections utiliza el comanto netstat para 
obtener informacion sobre las conexiones marcadas como
ESTABLISHED.
.EXAMPLE
Get-ActiveConections
#>

netstat -an | findstr /C:ESTABLISHED