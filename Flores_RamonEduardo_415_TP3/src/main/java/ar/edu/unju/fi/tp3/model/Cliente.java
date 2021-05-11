package ar.edu.unju.fi.tp3.model;



import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;




@Component
public class Cliente {

	private String tipoDocumento;
	private int nroDocumento;
	private String Nombre;
	private String Apellido;
	private String email;
	private String password;
	private LocalDate fechaNciemiento;
	private int codAreaTelefono;
	private int nroTelefono;
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
		super();
	}

	public Cliente(String tipoDocumento, int nroDocumento, String nombre, String apellido, String email,
			String password, LocalDate fechaNciemiento, int codAreaTelefono, int nroTelefono,
			LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		Nombre = nombre;
		Apellido = apellido;
		this.email = email;
		this.password = password;
		this.fechaNciemiento = fechaNciemiento;
		this.codAreaTelefono = codAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNciemiento() {
		return fechaNciemiento;
	}

	public void setFechaNciemiento(LocalDate fechaNciemiento) {
		this.fechaNciemiento = fechaNciemiento;
	}

	public int getCodAreaTelefono() {
		return codAreaTelefono;
	}

	public void setCodAreaTelefono(int codAreaTelefono) {
		this.codAreaTelefono = codAreaTelefono;
	}

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNciemiento, hoy);
		edad = periodo.getYears();		
		return edad;
	}
	
	public String getTiempoCumple() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		int varanio;
		if (hoy.getMonthValue()<this.fechaNciemiento.getMonthValue()) {
			varanio = hoy.getYear();
		}else {
			varanio = hoy.getYear()+1;
		}
		
		LocalDate fechaProximoCumple = LocalDate.of(varanio,this.fechaNciemiento.getMonth(),this.fechaNciemiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaProximoCumple );
		texto = "Año: "+periodo.getYears()+" Mes: "+periodo.getMonths()+" Dia: "+periodo.getDays();
		
		
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime fechaProxCumple = LocalDateTime.of(varanio, this.fechaNciemiento.getMonth(), this.fechaNciemiento.getDayOfMonth(), 0, 0);
		Duration duracion = Duration.between(ahora, fechaProxCumple);
		
		texto = texto + "Hora:" +duracion.toHoursPart()+" Min:"+duracion.toMinutesPart()+"Seg: "+duracion.toSecondsPart(); 
		return texto;					
	}

	public long getDiasDeVida(){
		LocalDate hoy = LocalDate.now();		
		long miliseg = this.fechaNciemiento.until(hoy, ChronoUnit.DAYS);
		return miliseg;
	} 	
	
	public String getTiempoHastaCumple(){
		LocalDate hoy = LocalDate.now();
		String fechaCad = "";		
		int anio;
		if(hoy.getMonthValue()< this.fechaNciemiento.getMonthValue())
			anio = hoy.getYear();
		else
			anio = hoy.getYear() + 1;
		LocalDate fechaNextCumple = LocalDate.of(anio, this.fechaNciemiento.getMonth(), this.fechaNciemiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaNextCumple);
				
		fechaCad = periodo.getDays() + "d-" + periodo.getMonths() + "m-" + periodo.getYears()+"a";
		return fechaCad;
	}
	
	public String getTiempoDesdeCompra(){
		LocalDate hoy = LocalDate.now();
		String fechaCad = "";
		Period periodo = Period.between(this.fechaUltimaCompra, hoy);				
		fechaCad = periodo.getYears() + "a-" + periodo.getMonths() + "m-" + periodo.getDays() + "d";
		return fechaCad;		
	}

	
	
	
	
}
