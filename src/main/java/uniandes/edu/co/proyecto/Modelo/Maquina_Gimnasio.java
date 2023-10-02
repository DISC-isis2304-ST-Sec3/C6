package uniandes.edu.co.proyecto.Modelo;
import jakarta.persistence.*;


@Entity
@Table(name="Maquina_Gimnasio")
public class Maquina_Gimnasio {
    @EmbeddedId
    private Maquina_GimnasioPK pk;


    public Maquina_Gimnasio (Maquina Maquina_id, Gimnasio Gimnasio_id)
    {
        this.pk = new Maquina_GimnasioPK(Maquina_id, Gimnasio_id);
    }

    public Maquina_Gimnasio()
    {;}
    public Maquina_GimnasioPK getRMaquina_Gimnacio() {
        return pk;
    }

    public void SetSMaquina_Gimnacios(Maquina_GimnasioPK pk) {
        this.pk = pk;
    }

    
}