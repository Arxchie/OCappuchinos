/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

/**
 *
 * @author HP
 */
public class Main
{

    public static void main(String[] args)
    {
        Datos datos[] = null;
        datos=Controlador.altaAlumno(datos, null, "12345", "Jose", "Azteca", "Otomi", 'h', true, true, true, true, true, "Deficiencia renal", 4, 2);
        datos=Controlador.altaAlumno(datos, null, "24681", "Abram", "Diaz", "Gomez", 'h', true, false, false, true, true, "", 4, 2);
        datos=Controlador.altaAlumno(datos, null, "35791", "Lina", "Ramirez", "Suarez", 'h', false, true, false, true, true, "", 4, 2);
        System.out.println( datos[0].toString());
        System.out.println( datos[1].toString());
        System.out.println( datos[2].toString());
        System.out.println(datos.length);
        Datos nvo = new Alumnos(3, 1, "12345", "Jose", "Azteca", "Otomi", 'h', true, true, true, true, true, "Deficiencia renal");
        datos=Controlador.despModifica(datos, "12345", false, true, false, true, true, "Hepatitis", 'c', 0, 0, null);
        System.out.println(datos[0].toString());
        

    }
}
