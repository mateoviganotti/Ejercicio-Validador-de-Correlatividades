package domain.entity;

import domain.entities.Alumno;
import domain.entities.Inscripcion;
import domain.entities.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InscripcionTest {

    @Test
    @DisplayName("Test inscripcion falla porque no cumple con todas las correlativas de disenio")
    public void InscripcionRechazada() {
        //Creo disenio y correlativas
        Materia disenio = new Materia();

        Materia paradigmas = new Materia();
        disenio.agregarCorrelativa(paradigmas);

        Materia ingles1 = new Materia();
        disenio.agregarCorrelativa(ingles1);

        //creo economia y correlativas
        Materia economia = new Materia();

        Materia algebra = new Materia();
        economia.agregarCorrelativa(algebra);

        Materia analisisMatematico1 = new Materia();
        economia.agregarCorrelativa(analisisMatematico1);

        //creo al alumno
        Alumno alumno = new Alumno();
        alumno.agregarMateriaAprobada(paradigmas);
        alumno.agregarMateriaAprobada(algebra);
        alumno.agregarMateriaAprobada(analisisMatematico1);

        //creo la inscripcion
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateriaACursar(disenio);
        inscripcion.agregarMateriaACursar(economia);

        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Test inscripcion es aprobada")
    public void InscripcionAprobada(){
        //Creo arquitectura
        Materia arquitectura = new Materia();

        //creo Fisica2 y correlativas
        Materia fisica2 = new Materia();

        Materia fisica1 = new Materia();
        fisica2.agregarCorrelativa(fisica1);

        Materia analisisMatematico1 = new Materia();
        fisica2.agregarCorrelativa(analisisMatematico1);

        //creo al alumno
        Alumno alumno = new Alumno();
        alumno.agregarMateriaAprobada(fisica1);
        alumno.agregarMateriaAprobada(analisisMatematico1);

        //creo la inscripcion
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMateriaACursar(arquitectura);
        inscripcion.agregarMateriaACursar(fisica2);

        Assertions.assertTrue(inscripcion.aprobada());
    }

}