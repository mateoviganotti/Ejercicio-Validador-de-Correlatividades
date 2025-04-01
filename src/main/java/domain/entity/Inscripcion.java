package domain.entity;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {
    private final Alumno alumno;
    private final Set<Materia> materiasACursar;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasACursar = new HashSet<>();
    }

    public void agregarMateriaACursar(Materia materia) {
        this.materiasACursar.add(materia);
    }
    public boolean aprobada() {
        for (Materia materia : materiasACursar) {
            if (!materia.cumpleCorrelativas(alumno)) {
                return false;
            }
        }
        return true;
    }
}
