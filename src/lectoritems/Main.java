package lectoritems;

/**
 *
 * @author Paulker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line_text = "000001     COL VERDE MENTA 100GR                    D0126           UND        0.0000        0.0000 UND    1.0000     0.00000    55.00000 0102   0102                           16%    NO  COMPRA NO    I/O PE NO     62,350.000";
        String CRITERIO_1 = null;
        String CRITERIO_2 = null;
        String CRITERIO_3 = null;
        String CRITERIO_4 = null;

        String INVENT_UM = null;
        String EMPAQUE_UM = null;
        String ORDEN_UM = null;
        int Id_item = Integer.parseInt(line_text.substring(0, 6));
        String descripcion = line_text.substring(6, 52).trim();
        String referencia = line_text.substring(52, 68).trim();
        String INV = line_text.substring(68, 71).trim();
        if (!line_text.substring(71, 75).trim().equals("")) {
            INVENT_UM = line_text.substring(71, 75).trim();
        }
        float INVENT_FACTOR = Float.parseFloat(line_text.substring(75, 85).trim());
        if (!line_text.substring(85, 89).trim().equals("")) {
            EMPAQUE_UM = line_text.substring(85, 89).trim();
        }
        float EMPAQUE_FACTOR = Float.parseFloat(line_text.substring(89, 99).trim());
        if (!line_text.substring(99, 103).trim().equals("")) {
            ORDEN_UM = line_text.substring(99, 103).trim();
        }
        float ORDEN_FACTOR = Float.parseFloat(line_text.substring(103, 113).trim());
        float peso = Float.parseFloat(line_text.substring(113, 125).trim());
        float VOLUMEN_KLS = Float.parseFloat(line_text.substring(125, 137).trim());
        int grupo = Integer.parseInt(line_text.substring(137, 142).trim());
        int linea = Integer.parseInt(line_text.substring(142, 149).trim());
        if (!line_text.substring(149, 155).trim().equals("")) {
            CRITERIO_1 = line_text.substring(149, 155).trim();
        }
        if (!line_text.substring(155, 161).trim().equals("")) {
            CRITERIO_2 = line_text.substring(155, 161).trim();
        }
        if (!line_text.substring(161, 167).trim().equals("")) {
            CRITERIO_3 = line_text.substring(161, 167).trim();
        }
        if (!line_text.substring(167, 173).trim().equals("")) {
            CRITERIO_4 = line_text.substring(167, 173).trim();
        }
        String impuesto = line_text.substring(173, 182).trim();
        String GEN = line_text.substring(182, 187).trim();
        String PROCED = line_text.substring(187, 194).trim();
        String EXT = line_text.substring(194, 197).trim();
        String TALLA = line_text.substring(197, 204).trim();
        String LOTE = line_text.substring(204, 207).trim();
        String SERIAL = line_text.substring(207, 210).trim();
        String costo = Lector.invertir_puntos_comas(line_text.substring(210, 224).trim());
        float costo_estandar = Float.parseFloat(costo);

        String datos =	"Id_item = " +Id_item + "\n"+
         "descripcion  =" +descripcion + "\n"+
         "referencia = "+referencia + "\n" +
         "INV ="+INV + "\n"+
         "INVENT_UM  ="+INVENT_UM + "\n" +
         "INVENT_FACTOR ="+INVENT_FACTOR + "\n"+
         "EMPAQUE_UM ="+EMPAQUE_UM + "\n"+
         "EMPAQUE_FACTOR = "+EMPAQUE_FACTOR + "\n"+
         "ORDEN_UM = "+ORDEN_UM+ "\n"+
        "ORDEN_FACTOR = " +ORDEN_FACTOR + "\n"+
         "peso = "+peso+ "\n"+
         "VOLUMEN_KLS = "+VOLUMEN_KLS+ "\n"+
         "grupo = "+grupo+ "\n"+
         "linea = "+linea+ "\n"+
         "CRITERIO_1 = "+CRITERIO_1+ "\n"+
         "CRITERIO_2 = "+CRITERIO_2+ "\n"+
         "CRITERIO_3 = "+CRITERIO_3+ "\n"+
         "CRITERIO_4 = "+CRITERIO_4+ "\n"+
         "impuesto = "+impuesto+ "\n"+
         "GEN = "+GEN+ "\n"+
         "PROCED = "+PROCED+ "\n"+
         "EXT = "+EXT+ "\n"+
         "TALLA = "+TALLA+ "\n"+
         "LOTE = "+LOTE+ "\n"+
         "SERIAL = "+SERIAL+ "\n"+
         "costo_estandar = "+costo_estandar+ "\n";
        System.out.println(datos);
    }
    
}
