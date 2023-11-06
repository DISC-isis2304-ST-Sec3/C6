package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name="reservas")
public class Reserva {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private Integer numero_personas;
    private Date fecha_entrada;
    private Date fecha_salida;
    private Integer costo_total;
    private Boolean check_in;
    private Boolean check_out;

    @ManyToOne
    @JoinColumn(name = "planes_de_cosumo_id", referencedColumnName = "id")
    private Plan_De_Consumo plan_De_Consumo;

    @OneToOne
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    private Usuario usuarios;

    @ManyToOne
    @JoinColumn(name = "habitaciones_id", referencedColumnName = "id")
    private Habitacion habitacion;

    @ManyToOne
    @JoinColumn(name = "hoteles_id", referencedColumnName = "id")
    private Hotel hotel;


    public Reserva(Integer numero_personas, Date fecha_entrada, Date fecha_salida, Integer costo_total, Boolean check_in, Boolean check_out,
    Integer cont_reservas, Hotel hotel, Habitacion habitacion, Usuario usuarios, Plan_De_Consumo plan_De_Consumo) {
        this.numero_personas = numero_personas;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.costo_total = costo_total;
        this.check_in = check_in;
        this.check_out = check_out;
        this.usuarios = usuarios;
        this.habitacion = habitacion;
        this.hotel = hotel;
        this.plan_De_Consumo = plan_De_Consumo;
    }

    public Plan_De_Consumo getPlan_De_Consumo() {
        return plan_De_Consumo;
    }

    public void setPlan_De_Consumo(Plan_De_Consumo plan_De_Consumo) {
        this.plan_De_Consumo = plan_De_Consumo;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Reserva()
    {;}

    public Habitacion gethabitacion(){
        return habitacion;
    }
    public void sethabitacion(Habitacion habitacion){
        this.habitacion=habitacion;
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

    public Usuario getId_usuario() {
        return usuarios;
    }

    public void setId_usuario(Usuario usuarios) {
        this.usuarios = usuarios;
    }

}
