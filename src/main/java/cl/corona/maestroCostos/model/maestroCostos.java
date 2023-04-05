package cl.corona.maestroCostos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "MAES_COSTOS", procedureName = "PRC_MAESTRO_COSTO_PMM", parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "C1", type = Class.class)})})
public class maestroCostos {
    @Id
    @JsonIgnore
    private int id;

    public int inner_pack_id;

    private int audit_number;

    private int cst_type_id;

    private int prd_lvl_child;

    private String prd_lvl_number;

    private int cst_cost;

    private int inner_pk_tech_key;

    private Date date_created;

    private Date download_date_1;

    private Date download_date_2;

    private int cst_key;

    private Date caldat;

    private Date fecha_proceso;

    private int id_usuario;

    private String nombre_archivo;

    private Date fecha_insercion;

    public maestroCostos() {
        super();
    }

    public maestroCostos(int id, int inner_pack_id, int audit_number, int cst_type_id, int prd_lvl_child, String prd_lvl_number, int cst_cost, int inner_pk_tech_key, Date date_created, Date download_date_1, Date download_date_2, int cst_key, Date caldat, Date fecha_proceso, int id_usuario, String nombre_archivo, Date fecha_insercion) {
        this.id = id;
        this.inner_pack_id = inner_pack_id;
        this.audit_number = audit_number;
        this.cst_type_id = cst_type_id;
        this.prd_lvl_child = prd_lvl_child;
        this.prd_lvl_number = prd_lvl_number;
        this.cst_cost = cst_cost;
        this.inner_pk_tech_key = inner_pk_tech_key;
        this.date_created = date_created;
        this.download_date_1 = download_date_1;
        this.download_date_2 = download_date_2;
        this.cst_key = cst_key;
        this.caldat = caldat;
        this.fecha_proceso = fecha_proceso;
        this.id_usuario = id_usuario;
        this.nombre_archivo = nombre_archivo;
        this.fecha_insercion = fecha_insercion;
    }

    @Override
    public String toString() {
        return "maestroCosto{" +
                "id=" + id +
                ", inner_pack_id=" + inner_pack_id +
                ", audit_number=" + audit_number +
                ", cst_type_id=" + cst_type_id +
                ", prd_lvl_child=" + prd_lvl_child +
                ", prd_lvl_number=" + prd_lvl_number +
                ", cst_cost=" + cst_cost +
                ", inner_pk_tech_key=" + inner_pk_tech_key +
                ", date_created=" + date_created +
                ", download_date_1=" + download_date_1 +
                ", download_date_2=" + download_date_2 +
                ", cst_key=" + cst_key +
                ", caldat=" + caldat +
                ", fecha_proceso=" + fecha_proceso +
                ", id_usuario=" + id_usuario +
                ", nombre_archivo='" + nombre_archivo + '\'' +
                ", fecha_insercion=" + fecha_insercion +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInner_pack_id() {
        return inner_pack_id;
    }

    public void setInner_pack_id(int inner_pack_id) {
        this.inner_pack_id = inner_pack_id;
    }

    public int getAudit_number() {
        return audit_number;
    }

    public void setAudit_number(int audit_number) {
        this.audit_number = audit_number;
    }

    public int getCst_type_id() {
        return cst_type_id;
    }

    public void setCst_type_id(int cst_type_id) {
        this.cst_type_id = cst_type_id;
    }

    public int getPrd_lvl_child() {
        return prd_lvl_child;
    }

    public void setPrd_lvl_child(int prd_lvl_child) {
        this.prd_lvl_child = prd_lvl_child;
    }

    public String getPrd_lvl_number() {
        return prd_lvl_number;
    }

    public void setPrd_lvl_number(String prd_lvl_number) {
        this.prd_lvl_number = prd_lvl_number;
    }

    public int getCst_cost() {
        return cst_cost;
    }

    public void setCst_cost(int cst_cost) {
        this.cst_cost = cst_cost;
    }

    public int getInner_pk_tech_key() {
        return inner_pk_tech_key;
    }

    public void setInner_pk_tech_key(int inner_pk_tech_key) {
        this.inner_pk_tech_key = inner_pk_tech_key;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDownload_date_1() {
        return download_date_1;
    }

    public void setDownload_date_1(Date download_date_1) {
        this.download_date_1 = download_date_1;
    }

    public Date getDownload_date_2() {
        return download_date_2;
    }

    public void setDownload_date_2(Date download_date_2) {
        this.download_date_2 = download_date_2;
    }

    public int getCst_key() {
        return cst_key;
    }

    public void setCst_key(int cst_key) {
        this.cst_key = cst_key;
    }

    public Date getCaldat() {
        return caldat;
    }

    public void setCaldat(Date caldat) {
        this.caldat = caldat;
    }

    public Date getFecha_proceso() {
        return fecha_proceso;
    }

    public void setFecha_proceso(Date fecha_proceso) {
        this.fecha_proceso = fecha_proceso;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public Date getFecha_insercion() {
        return fecha_insercion;
    }

    public void setFecha_insercion(Date fecha_insercion) {
        this.fecha_insercion = fecha_insercion;
    }
}
