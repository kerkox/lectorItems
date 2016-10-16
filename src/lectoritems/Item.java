package lectoritems;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Paulker
 */
@Entity
public class Item implements Serializable{
    @Id
    int id_item;
    @Column (length = 80,nullable = false) 
    String descripcion;
    @Column (length = 15,nullable = false)
    String referencia;
    @Column (length = 5,nullable = false)
    String uni_inv;
    @Column (length = 5,nullable = true)
    String INVENT_UM;
    @Column (nullable = false)
    float INVENT_FACTOR;
    @Column (length = 5,nullable = true)
    String EMPAQUE_UM;
    @Column (nullable = false)
    float EMPAQUE_FACTOR;
    @Column (length = 5,nullable = true)
    String ORDEN_UM;
    @Column (nullable = false)
    float ORDEN_FACTOR;
    @Column (nullable = false)
    float peso;
    @Column (nullable = false)
    float VOLUMEN_KLS;
    @Column (nullable = false)
    int grupo;
    @Column (nullable = false)
    int linea;
    @Column (nullable = true)
    String  CRITERIO_1;
    @Column (nullable = true)
    String CRITERIO_2;
    @Column (nullable = true)
    String CRITERIO_3;
    @Column (nullable = true)
    String CRITERIO_4;
    @Column (length = 4,nullable = false)
    String impuesto;
    @Column (length = 10,nullable = false)
    String GEN;
    @Column (length = 10,nullable = false)
    String PROCED;
    @Column (length = 5,nullable = false)
    String EXT;
    @Column (length = 11,nullable = false)
    String TALLA;
    @Column (length = 11,nullable = false)
    String LOTE;
    @Column (length = 10,nullable = false)
    String SERIAL;
    @Column (nullable = false)
    float costo_estandar;

    public Item() {
    }

    public Item(int id_item, String descripcion, String referencia, String uni_inv, String INVENT_UM, float INVENT_FACTOR, String EMPAQUE_UM, float EMPAQUE_FACTOR, String ORDEN_UM, float ORDEN_FACTOR, float peso, float VOLUMEN_KLS, int grupo, int linea, String CRITERIO_1, String CRITERIO_2, String CRITERIO_3, String CRITERIO_4, String impuesto, String GEN, String PROCED, String EXT, String TALLA, String LOTE, String SERIAL, float costo_estandar) {
        this.id_item = id_item;
        this.descripcion = descripcion;
        this.referencia = referencia;
        this.uni_inv = uni_inv;
        this.INVENT_UM = INVENT_UM;
        this.INVENT_FACTOR = INVENT_FACTOR;
        this.EMPAQUE_UM = EMPAQUE_UM;
        this.EMPAQUE_FACTOR = EMPAQUE_FACTOR;
        this.ORDEN_UM = ORDEN_UM;
        this.ORDEN_FACTOR = ORDEN_FACTOR;
        this.peso = peso;
        this.VOLUMEN_KLS = VOLUMEN_KLS;
        this.grupo = grupo;
        this.linea = linea;
        this.CRITERIO_1 = CRITERIO_1;
        this.CRITERIO_2 = CRITERIO_2;
        this.CRITERIO_3 = CRITERIO_3;
        this.CRITERIO_4 = CRITERIO_4;
        this.impuesto = impuesto;
        this.GEN = GEN;
        this.PROCED = PROCED;
        this.EXT = EXT;
        this.TALLA = TALLA;
        this.LOTE = LOTE;
        this.SERIAL = SERIAL;
        this.costo_estandar = costo_estandar;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUni_inv() {
        return uni_inv;
    }

    public void setUni_inv(String uni_inv) {
        this.uni_inv = uni_inv;
    }

    public String getINVENT_UM() {
        return INVENT_UM;
    }

    public void setINVENT_UM(String INVENT_UM) {
        this.INVENT_UM = INVENT_UM;
    }

    public float getINVENT_FACTOR() {
        return INVENT_FACTOR;
    }

    public void setINVENT_FACTOR(float INVENT_FACTOR) {
        this.INVENT_FACTOR = INVENT_FACTOR;
    }

    public String getEMPAQUE_UM() {
        return EMPAQUE_UM;
    }

    public void setEMPAQUE_UM(String EMPAQUE_UM) {
        this.EMPAQUE_UM = EMPAQUE_UM;
    }

    public float getEMPAQUE_FACTOR() {
        return EMPAQUE_FACTOR;
    }

    public void setEMPAQUE_FACTOR(float EMPAQUE_FACTOR) {
        this.EMPAQUE_FACTOR = EMPAQUE_FACTOR;
    }

    public String getORDEN_UM() {
        return ORDEN_UM;
    }

    public void setORDEN_UM(String ORDEN_UM) {
        this.ORDEN_UM = ORDEN_UM;
    }

    public float getORDEN_FACTOR() {
        return ORDEN_FACTOR;
    }

    public void setORDEN_FACTOR(float ORDEN_FACTOR) {
        this.ORDEN_FACTOR = ORDEN_FACTOR;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getVOLUMEN_KLS() {
        return VOLUMEN_KLS;
    }

    public void setVOLUMEN_KLS(float VOLUMEN_KLS) {
        this.VOLUMEN_KLS = VOLUMEN_KLS;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getCRITERIO_1() {
        return CRITERIO_1;
    }

    public void setCRITERIO_1(String CRITERIO_1) {
        this.CRITERIO_1 = CRITERIO_1;
    }

    public String getCRITERIO_2() {
        return CRITERIO_2;
    }

    public void setCRITERIO_2(String CRITERIO_2) {
        this.CRITERIO_2 = CRITERIO_2;
    }

    public String getCRITERIO_3() {
        return CRITERIO_3;
    }

    public void setCRITERIO_3(String CRITERIO_3) {
        this.CRITERIO_3 = CRITERIO_3;
    }

    public String getCRITERIO_4() {
        return CRITERIO_4;
    }

    public void setCRITERIO_4(String CRITERIO_4) {
        this.CRITERIO_4 = CRITERIO_4;
    }

    
    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getGEN() {
        return GEN;
    }

    public void setGEN(String GEN) {
        this.GEN = GEN;
    }

    public String getPROCED() {
        return PROCED;
    }

    public void setPROCED(String PROCED) {
        this.PROCED = PROCED;
    }

    public String getEXT() {
        return EXT;
    }

    public void setEXT(String EXT) {
        this.EXT = EXT;
    }

    public String getTALLA() {
        return TALLA;
    }

    public void setTALLA(String TALLA) {
        this.TALLA = TALLA;
    }

    public String getLOTE() {
        return LOTE;
    }

    public void setLOTE(String LOTE) {
        this.LOTE = LOTE;
    }

    public String getSERIAL() {
        return SERIAL;
    }

    public void setSERIAL(String SERIAL) {
        this.SERIAL = SERIAL;
    }

    public float getCosto_estandar() {
        return costo_estandar;
    }

    public void setCosto_estandar(float costo_estandar) {
        this.costo_estandar = costo_estandar;
    }

    @Override
    public String toString() {
        return "\nId_item ="+this.id_item +
                "\n descripcion ="+ this.descripcion+
                "\n referencia ="+this.referencia+
                "\n INV ="+ this.uni_inv+
                "\n INVENT_UM ="+this.INVENT_UM+
                "\n INVENT_FACTOR ="+this.INVENT_FACTOR+
        "\n EMPAQUE_UM ="+this.EMPAQUE_UM+
        "\n EMPAQUE_FACTOR ="+this.EMPAQUE_FACTOR+
        "\n ORDEN_UM ="+this.ORDEN_UM+
        "\n ORDEN_FACTOR ="+this.ORDEN_FACTOR+
        "\n peso ="+this.peso+
        "\n VOLUMEN_KLS ="+this.VOLUMEN_KLS+
        "\n grupo ="+this.grupo+
        "\n linea ="+this.linea+
        "\n CRITERIO_1 = "+this.CRITERIO_1+
        "\n CRITERIO_2 ="+this.CRITERIO_2+
        "\n CRITERIO_3 ="+this.CRITERIO_3+
        "\n CRITERIO_4 ="+this.CRITERIO_4+
        "\n impuesto ="+this.impuesto+
        "\n GEN ="+this.GEN+
        "\n PROCED = "+this.PROCED+
        "\n EXT ="+this.EXT+
        "\n TALLA ="+this.TALLA+
        "\n LOTE ="+this.LOTE+
        "\n SERIAL ="+this.SERIAL+
        "\n costo_estandar = "+ this.costo_estandar;
    }


    
    
}
