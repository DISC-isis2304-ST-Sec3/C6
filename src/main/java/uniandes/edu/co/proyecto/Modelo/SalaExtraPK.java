package uniandes.edu.co.proyecto.Modelo;
import java.io.Serializable;

import jakarta.persistence.*;


@Embeddable
public class SalaExtraPK implements Serializable{

@ManyToOne
@JoinColumn(name = "Spas_id", referencedColumnName= "id")
private Spa Spas_id;

@ManyToOne
@JoinColumn(name = "PlanSpa_id", referencedColumnName= "id")
private PlanSpa PlanSpa_id;

public SalaExtraPK(Spa Spas_id, PlanSpa PlanSpa_id){
    super();
    this.Spas_id = Spas_id;
    this.PlanSpa_id = PlanSpa_id;
}

    public Spa getSpa() {
        return Spas_id;
    }

    public void setSpa(Spa Spas_id) {
        this.Spas_id = Spas_id;
    }
    public PlanSpa getSpaPlan() {
        return PlanSpa_id;
    }

    public void SetSpaPlan(PlanSpa PlanSpa_id) {
        this.PlanSpa_id = PlanSpa_id;
    }

    
}