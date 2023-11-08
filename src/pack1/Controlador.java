/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import cjb.ci.Mensajes;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class Controlador
{

    /**
     * Metodo para insertar un nuevo elemento a un arreglo de tipo dato
     *
     * @param array recive el arreglo donde se va a incertar el dato
     * @param d el dato que se desea insertar
     * @return retorna la direccion de memoria del nuevo arreglo con el dato
     * insertado
     */
    private static Datos[] inserta(Datos array[], Datos d)
    {
        if (array == null)
        {
            array = new Datos[1];
            array[0] = d;

        } else
        {
            Datos nvo[] = new Datos[array.length + 1];
            System.arraycopy(array, 0, nvo, 0, array.length);
            nvo[array.length] = d;
            array = nvo;
        }
        return array;
    }

    /**
     *
     * @param array el arreglo del cual se van a comparar las matriculas
     * @param cve la clave que va a ser validada
     * @param jf el frame donde se mostraran los mensajes
     * @return retorna true si la matricula es valida, y false si no lo es (ya
     * existe dentro del arreglo)
     */
    private static int validaMatricula(Datos array[], String cve)
    {
        if (array != null)
        {
            for (int i = 0; i < array.length; i++)
            {
                if (cve.equals(array[i].getCve()))
                {

                    return i;
                }
            }
        }
        return -1;
    }

    public static Datos[] altaAlumno(Datos array[], JFrame jf, String cve, String nom, String pApellido, String sApellido, char sexo, boolean desnut, boolean sobrepeso, boolean alergias, boolean obecidad, boolean diabetes, String otras, int viveCon, int carrera)
    {
        if (validaMatricula(array, cve) == -1)
        {
            Datos nvoA = new Alumnos(viveCon, carrera, cve, nom, pApellido, sApellido, sexo, desnut, sobrepeso, alergias, obecidad, diabetes, otras);
            array = inserta(array, nvoA);
        } else
        {
            Mensajes.error(jf, "Esa Matricula ya existe");
        }
        return array;
    }

    public static Datos[] altaPersonal(Datos array[], JFrame jf, String cve, String nom, String pApellido, String sApellido, char sexo, boolean desnut, boolean sobrepeso, boolean alergias, boolean obecidad, boolean diabetes, String otras, char estatus)
    {
        if (validaMatricula(array, cve) == -1)
        {
            Datos nvoA = new Personal(estatus, cve, nom, pApellido, sApellido, sexo, desnut, sobrepeso, alergias, obecidad, diabetes, otras);
            array = inserta(array, nvoA);
        } else
        {
            Mensajes.error(jf, "Esa Matricula ya existe");
        }
        return array;
    }

    public static Datos[] despModifica(Datos[] array, String cve, boolean desnut, boolean sobrepeso, 
            boolean alergias, boolean obecidad, boolean diabetes, String otras, char estatus, 
            int viveCon, int carrera, JFrame jf)
    {
        int pos = validaMatricula(array, cve);
        if (pos == -1)
        {
            Mensajes.error(jf, "Ninguna coincidencia");

        } else
        {
            if (array[pos] instanceof Alumnos)
            {
                
                ((Alumnos)array[pos]).viveCon=viveCon;
                ((Alumnos)array[pos]).carrera=carrera;
                array[pos].setOtras(otras);
                array[pos].setAlergias(alergias);
                array[pos].setDesnutricion(desnut);
                array[pos].setDiabetes(diabetes);
                array[pos].setObesidad(obecidad);
                array[pos].setSobrepeso(sobrepeso);
            } else
            {
                ((Personal)array[pos]).setEstatus(estatus);
                array[pos].setOtras(otras);
                array[pos].setAlergias(alergias);
                array[pos].setDesnutricion(desnut);
                array[pos].setDiabetes(diabetes);
                array[pos].setObesidad(obecidad);
                array[pos].setSobrepeso(sobrepeso);
            }
        }
        return array;
    }
    
}
