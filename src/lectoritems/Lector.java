package lectoritems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import lectoritems.DAO.ItemJpaController;

/**
 *
 * @author Paulker
 */
public class Lector {

    public static Logger LOGGER = null;

    static {
        try {
            Handler handler = new FileHandler("paul.log");
            LOGGER.addHandler(handler);
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int time_seg;  //tiempo de actulizacion por defecto 
    String ruta_file; //la ruta donde estara el archivo para actulizar la BD
    FileReader fr;
    BufferedReader br;

    private EntityManagerFactory emf;
    private ItemJpaController itemJpa;

    void loadPersistence() {
        emf = Persistence.createEntityManagerFactory("lectorItemsPU");
        itemJpa = new ItemJpaController(emf);
    }

    public Lector(String ruta_file) {
        this.ruta_file = ruta_file;
        this.time_seg = 300; //VALOR POR DEFECTO
        loadPersistence();
    }

    public Lector(int time_seg, String ruta_file) {
        this.time_seg = time_seg;
        this.ruta_file = ruta_file;
        loadPersistence();
    }

    public int getTime_seg() {
        return time_seg;
    }

    public void setTime_seg(int time_seg) {
        this.time_seg = time_seg;
    }

    public String getRuta_file() {
        return ruta_file;
    }

    public void setRuta_file(String ruta_file) {
        this.ruta_file = ruta_file;
    }

    //*************************************
    //Metodos utiles
    /**
     * Este metodo cuando incia lee el archivo que esta en la ruta pasada al
     * crear el objeto Lector y se podrocede a leer y con los datos a crear un
     * objeto item para asignarlo a una base de datos
     *
     */
    public void iniciar() throws FileNotFoundException, IOException {

        File file = new File(this.ruta_file);
        System.out.println("Ya se creo el archivo: " + file);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line;
        String msj = "";
        System.out.println("Va a entrar a leer el archivo");
        while ((line = br.readLine()) != null) {
            //primero se evalia que tipo de linea si tieme datos de item
            if (line.equals("") || (line.contains("|")) || line.contains("FIN LISTADO")) {
                continue;
            }
            int index = line.indexOf("+--");
            if ((index > -1) && (index < 2)) {
                continue;
            }
            if (line.substring(0, 6).trim().equals("")) {
                continue;
            }

            Item item = leerItem(line);

            if (item != null) {
                if (itemExist(item.getId_item())) {
                    ActulizarBD(item);
//                    msj = "Actulizando ";
                } else {
                    insertarBD(item);
//                    msj = "Insertando ";
                }
//                System.out.println(msj + " item id: " + item.getId_item());
            }

        }

    }

    public int codigoItem(String line_text) {
        int Id_item = Integer.parseInt(line_text.substring(0, 6));
        return Id_item;
    }

    /**
     *
     * @param line_text recibe la linea leida del archivo
     * @return un objeto item con valores si es una line valida sino retorna
     * null
     */
    public Item leerItem(String line_text) {
        Item item = null;
//        //primero se evalia que tipo de linea si tieme datos de item
//        if (line_text.equals("") || (line_text.contains("|")) || line_text.contains("FIN LISTADO")) {
//            return null; //aqui sera null
//        }
//        int index = line_text.indexOf("+--");
//        if((index > -1) && (index < 2)){
//            return null;
//        }
//        if(line_text.substring(0, 6).trim().equals("")){
//            return null;
//        }

        /*public Item(int id_item, String descripcion, String referencia, 
        String uni_inv, String INVENT_UM, float INVENT_FACTOR, 
        String EMPAQUE_UM, float EMPAQUE_FACTOR, String ORDEN_UM, 
        float ORDEN_FACTOR, float peso, float VOLUMEN_KLS, int grupo, 
        int linea, int CRITERIO_1, int CRITERIO_2, int CRITERIO_3, 
        int CRITERIO_4, String impuesto, String GEN, String PROCED, String EXT,
        String TALLA, String LOTE, String SERIAL, float costo_estandar) {
         */
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

        INVENT_UM = line_text.substring(71, 75).trim();
        if (INVENT_UM.equals("")) {
            INVENT_UM = null;
        }

        float INVENT_FACTOR = Float.parseFloat(line_text.substring(75, 85).trim());

        EMPAQUE_UM = line_text.substring(85, 89).trim();
        if (EMPAQUE_UM.equals("")) {
            EMPAQUE_UM = null;
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
        String costo = invertir_puntos_comas(line_text.substring(210, 224).trim());
        float costo_estandar = Float.parseFloat(costo);

        item = new Item(Id_item, descripcion, referencia, INV, INVENT_UM, INVENT_FACTOR, EMPAQUE_UM, EMPAQUE_FACTOR, ORDEN_UM, ORDEN_FACTOR, peso, VOLUMEN_KLS, grupo, linea, CRITERIO_1, CRITERIO_2, CRITERIO_3, CRITERIO_4, impuesto, GEN, PROCED, EXT, TALLA, LOTE, SERIAL, costo_estandar);

        return item;
    }

    /**
     * recive una cadena de texto donde hay un valor decimal en formato USA para
     * cambiar a formato LATINO
     *
     * @param convertir 1,000.00
     * @return 1000,00
     */
    public static String invertir_puntos_comas(String convertir) {
        String organizado = convertir;
        if (convertir.contains(",")) {
            organizado = convertir.replace(",", "");
        }
//        } else {
//            organizado = convertir;
//        }
        return organizado;
    }

    /**
     * Se crea un item que no esta en la base de datos
     *
     * @param item con datos nuevos
     */
    public void insertarBD(Item item) {
        try {
            itemJpa.create(item);
        } catch (RollbackException ex) {
            System.out.println("Valor de referencia: --" + item.toString() + "--");
            ex.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Actuliza un item que ya esta en la base de Datos
     *
     * @param item un item con datos iguales o diferentes
     */
    public void ActulizarBD(Item item) {
        try {
            itemJpa.edit(item);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param codigo se usa para buscar un item
     * @return true siempre y cuando el item exista sino false
     */
    public boolean itemExist(int codigo) {
        Item item = itemJpa.findItem(codigo);

        return (item != null);

    }

    //*************************************
}
