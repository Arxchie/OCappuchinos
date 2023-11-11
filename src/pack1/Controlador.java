/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pack1;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    public static Datos[] inserta(Datos array[], Datos d)
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
     * @return retorna true si la matricula es valida, y false si no lo es (ya
     * existe dentro del arreglo)
     */
    public static int validaMatricula(Datos array[], String cve)
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

    public static Datos[] modificaAlum(Datos[] array, int pos, boolean desnut, boolean sobrepeso,
            boolean alergias, boolean obecidad, boolean diabetes, String otras,
            int viveCon, int carrera)
    {

        ((Alumnos) array[pos]).viveCon = viveCon;
        ((Alumnos) array[pos]).carrera = carrera;
        array[pos].setOtras(otras);
        array[pos].setAlergias(alergias);
        array[pos].setDesnutricion(desnut);
        array[pos].setDiabetes(diabetes);
        array[pos].setObesidad(obecidad);
        array[pos].setSobrepeso(sobrepeso);

        return array;
    }

    public static Datos[] modificaPersonal(Datos[] array, int pos, boolean desnut, boolean sobrepeso,
            boolean alergias, boolean obecidad, boolean diabetes, String otras,
            char estatus)
    {
        ((Personal) array[pos]).setEstatus(estatus);
        array[pos].setOtras(otras);
        array[pos].setAlergias(alergias);
        array[pos].setDesnutricion(desnut);
        array[pos].setDiabetes(diabetes);
        array[pos].setObesidad(obecidad);
        array[pos].setSobrepeso(sobrepeso);

        return array;
    }

    private static void muestra(JTable tabla, Object[][] obj)
    {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < obj.length; i++)
        {
            modelo.addRow(obj[i]);
        }

    }

    /**
     * Metodo que aumenta un renglon a la matriz de historial clinico
     *
     * @param hC la matriz a la que se le va a agregar el renglon
     * @return la matriz con un renglon mas
     */
    public static HistorialClinico[][] nuevoHistorial(HistorialClinico[][] hC)
    {
        if (hC == null)
        {
            hC = new HistorialClinico[1][];
        } else
        {
            HistorialClinico nvo[][] = new HistorialClinico[hC.length + 1][];
            System.arraycopy(hC, 0, nvo, 0, hC.length);
            hC = nvo;
        }
        return hC;
    }

    /**
     * metodo que agrega una nueva columna a la matriz de historial 
     * clinico en un renglon dado e inserta la consulta en la columna
     * creada en ese renglon
     * @param hC la matriz a la que se le va a agregar una columna
     * @param dato el dato que se va a insertar
     * @param pos la posicion donde se va a crear la nueva columna
     * @return la matriz con la nueva columna y el dato incertado
     */
    public static HistorialClinico[][] nuevaConsulta(HistorialClinico[][] hC, HistorialClinico dato,int pos)
    {
        if (hC[pos] == null)
        {
            hC[pos] = new HistorialClinico[1];
        } else
        {
            HistorialClinico nvo[] = new HistorialClinico[hC[pos].length + 1];
            System.arraycopy(hC[pos], 0, nvo, 0, hC[pos].length);
            hC[pos] = nvo;
        }
        hC[pos][hC[pos].length - 1] = dato;
        return hC;
    }

}
