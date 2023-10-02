package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;

import jakarta.persistence.*;


@Embeddable
public class Maquina_GimnasioPK implements Serializable{

@ManyToOne
@JoinColumn(name = "Maquina_id", referencedColumnName= "id")
private Maquina Maquina_id;

@ManyToOne
@JoinColumn(name = "Gimnasio_id", referencedColumnName= "id")
private Gimnasio Gimnasio_id;

public Maquina_GimnasioPK(Maquina Maquina_id, Gimnasio Gimnasio_id){
    super();
    this.Maquina_id = Maquina_id;
    this.Gimnasio_id = Gimnasio_id;
}

    public Maquina getReservas() {
        return Maquina_id;
    }

    public void setReservas(Maquina Maquina_id) {
        this.Maquina_id = Maquina_id;
    }
    public Gimnasio getServicios() {
        return Gimnasio_id;
    }

    public void SetServicios(Gimnasio Gimnasio_id) {
        this.Gimnasio_id = Gimnasio_id;
    }

    
}