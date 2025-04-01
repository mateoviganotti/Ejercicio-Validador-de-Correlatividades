package domain.entities;


import java.util.HashSet;
import java.util.Set;

public class Materia {
    private final Set<Materia> materiasCorrelativas;

    public Materia() {
        this.materiasCorrelativas = new HashSet<>();
    }

    public void agregarCorrelativa(Materia materia) {
        this.materiasCorrelativas.add(materia);
    }

    public boolean cumpleCorrelativas(Alumno alumno) {
        for (Materia correlativa : materiasCorrelativas) {
            if (!alumno.tieneAprobada(correlativa)) {
                return false;
            }
        }
        return true;
    }
}
