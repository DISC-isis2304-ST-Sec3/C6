package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="reservas")
public class Reserva {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Long id_usuario;    ///Para modelar las reservas por usuario
    private Integer numero_personas;
    private Date fecha_entrada;
    private Date fecha_salida;
    private Integer costo_total;
    private Boolean check_in;
    private Boolean check_out;
    private Integer cont_reservas; // Contador de reservas por dia 
    private Long id_habitacion;

    @OneToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuario usuarios_id;

    public Reserva(Integer numero_personas, Date fecha_entrada, Date fecha_salida, Integer costo_total, Boolean check_in, Boolean check_out,
    Integer cont_reservas, Long id_habitacion, Usuario usuarios_id) {
        this.numero_personas = numero_personas;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.costo_total = costo_total;
        this.check_in = check_in;
        this.check_out = check_out;
        this.usuarios_id = usuarios_id;
        this.cont_reservas = cont_reservas;
        this.id_habitacion = id_habitacion;
    }

    public Reserva()
    {;}

    public Long getId_habitacion(){
        return id_habitacion;
    }
    public void setId_habitacion(Long id_habitac){
        this.id_habitacion=id_habitacion;
    }
    public Long getId() {
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

    public void setId(Long id) {
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

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getCont_reservas() {
        return cont_reservas;
    }

    public void setCont_reservas(Integer cont_reservas) {
        this.cont_reservas = cont_reservas;
    }

}
