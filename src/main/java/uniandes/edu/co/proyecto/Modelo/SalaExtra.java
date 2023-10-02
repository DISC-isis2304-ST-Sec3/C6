package uniandes.edu.co.proyecto.Modelo;
import java.sql.Date;
import jakarta.persistence.*;


@Entity
@Table(name="Reservas")
public class SalaExtra {
    @EmbeddedId
    private SalaExtraPK pk;


    public SalaExtra (Spa Spas_id, PlanSpa PlanSpa_id)
    {
        this.pk = new SalaExtraPK(Spas_id, PlanSpa_id);
    }

    public SalaExtra()
    {;}
    public SalaExtraPK getSalaExtra() {
        return pk;
    }

    public void SetSSalaExtra(SalaExtraPK pk) {
        this.pk = pk;
    }

    
}