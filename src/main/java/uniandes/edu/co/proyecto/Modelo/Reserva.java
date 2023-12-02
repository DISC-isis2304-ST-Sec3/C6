package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;

import jakarta.persistence.*;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("Reserva")

public class Reserva {
    @Id
	private String id;
    private Integer numero_personas;
    private Date fecha_entrada;
    private Date fecha_salida;
    private Integer costo_total;
    private Boolean check_in;
    private Boolean check_out;
    @DBRef
    private Hotel hotel_Id;
    @DBRef
    private List<Servicio> servicios;


    public Reserva(Integer numero_personas, Date fecha_entrada, Date fecha_salida, Integer costo_total, Boolean check_in, Boolean check_out,
    Integer cont_reservas, Hotel hotel_Id, Habitacion habitacion, Usuario usuarios, Plan_De_Consumo plan_De_Consumo, List<Servicio> servicios) {
        this.numero_personas = numero_personas;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.costo_total = costo_total;
        this.check_in = check_in;
        this.check_out = check_out;
        this.hotel_Id = hotel_Id;
        this.servicios = servicios;

    }

   
  public Reserva() {
        super();
    }

    
    public String getId() {
        return id;
    }

    public Integer getNumero_personas() {
        return numero_personas;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public Integer getCosto_total() {
        return costo_total;
    }

    public Boolean getCheck_in() {
        return check_in;
    }

    public Boolean getCheck_out() {
        return check_out;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumero_personas(Integer numero_personas) {
        this.numero_personas = numero_personas;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public void setCosto_total(Integer costo_total) {
        this.costo_total = costo_total;
    }

    public void setCheck_in(Boolean check_in) {
        this.check_in = check_in;
    }

    public void setCheck_out(Boolean check_out) {
        this.check_out = check_out;
    }


}
