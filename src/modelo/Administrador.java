package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Administrador {

	public final static String RUTA_PROCESOS = "C:\\Users\\PC\\Documents\\Get-MajorCPUProcess.ps1";
	public final static String RUTA_DISCOS = "C:\\Users\\PC\\Documents\\Get-DiskInfo.ps1";
	public final static String RUTA_ARCHIVO = "C:\\Users\\PC\\Documents\\Get-LargestFile.ps1";
	public final static String RUTA_MEMORIA = "C:\\Users\\PC\\Documents\\Get-MemoryInfo.ps1";
	public final static String RUTA_CONEXIONES = "C:\\Users\\PC\\Documents\\Get-ActiveConections.ps1";
	
	public Administrador() {
		
	}
	
	public String ejecutar(String ruta) {
		Runtime runtime = Runtime.getRuntime();
		String resultado = "";
		
		if(!ruta.equals(RUTA_ARCHIVO)) {
			
			try {
				Process process = runtime.exec("powershell.exe "+ruta);
				process.getOutputStream().close();
				
				String line;
				BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line=stdout.readLine())!=null) {
					System.out.println(line);
					resultado=resultado+line+"\n";
				}
				TimeUnit.SECONDS.sleep(2);
				
			}catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
				System.exit(-1);
			}
			
			
		}else {
			System.out.println("Método equivocado");
			return null;
		}
		
		return resultado;
		
	}
	
	public String ejecutar(String ruta, String rutaArch) {
		Runtime runtime = Runtime.getRuntime();
		String resultado = "";
		
		
		if(ruta.equals(RUTA_ARCHIVO)) {
			
			//String comando[] = new String[1];
			//comando[0]="powershell.exe "+ruta;
			//comando[1]=rutaArch;
			//System.out.println(comando);
			try {
				Process process = runtime.exec("powershell.exe "+ruta+" "+rutaArch);
				process.getOutputStream().close();;
				
				String line;
				BufferedReader stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line=stdout.readLine())!=null) {
					System.out.println(line);
					resultado=resultado+line+"\n";
				}
				TimeUnit.SECONDS.sleep(2);
				
			}catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
				System.exit(-1);
			}
			
			
		}else {
			System.out.println("Método equivocado");
			return null;
		}
		
		return resultado;
		
	}
	
}
